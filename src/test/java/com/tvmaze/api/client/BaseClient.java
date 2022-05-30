package com.tvmaze.api.client;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BaseClient {
    private CloseableHttpClient client;
    private CloseableHttpResponse response;
    private int statusCode;
    private String body;
    private static final Logger logger = LogManager.getLogger();
    private List<String> tvShowList;

    public BaseClient() {
        client = HttpClientBuilder.create().build();
    }

    public void sendGet(String url) {
        try {
            response = client.execute(new HttpGet(url));
        } catch (IOException e) {
            logger.warn(e.getMessage());
        }
        logger.info("Request: "+url);
        getStatusCode();
    }

    public int getStatusCode() {
        statusCode = response.getStatusLine().getStatusCode();
        if (statusCode != 200) {
            logger.error("An error code received. Server returned "
                    + statusCode + " " + response.getStatusLine()
                    .getReasonPhrase());
            throw new RuntimeException("An error code received. Server returned "
                    + statusCode + " " + response.getStatusLine()
                    .getReasonPhrase());
        }
        logger.info("StatusCodes: " + statusCode);
        return statusCode;
    }

    public String getBody() {
        try {
            body = EntityUtils.toString(response.getEntity());
        } catch (IOException e) {
            logger.warn(e.getMessage());
        }
        return body;
    }

    public List<String> getTVShowList() {
        body = getBody();
        JSONArray jsonArray = new JSONArray(body);
        List<JSONObject> jsonObjectList = new ArrayList<>();
        for (Object jsonObject : jsonArray) {
            jsonObjectList.add(((JSONObject) jsonObject).getJSONObject("show"));
        }
        tvShowList=new ArrayList<>();
        for (JSONObject jsonObject : jsonObjectList) {
            tvShowList.add(jsonObject.getString("name"));
        }
        logger.info("TVShow names: "+tvShowList);
        return tvShowList;
    }

    public boolean isResponseContainTVShow(String tvShow) {
        if (tvShowList == null) {
            tvShowList = getTVShowList();
        }
        return tvShowList.stream().anyMatch(s -> s.contains(tvShow));
    }

    public void closeClient() {
        try {
            client.close();
        } catch (IOException e) {
            logger.warn(e.getMessage());
        }
    }
}
