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

    public BaseClient() {
        client = HttpClientBuilder.create().build();
    }

    public void sendGet(String url) {
        try {
            response = client.execute(new HttpGet(url));
        } catch (IOException e) {
            logger.warn(e.getMessage());
        }
    }

    public int getStatusCode() {
        statusCode = response.getStatusLine().getStatusCode();
        logger.info(statusCode);
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

    public <T> List<T> getListBodyValuesByKey(String key) {
        JSONArray jsonArray = new JSONArray(body);
        List<T> valuesList = new ArrayList<>();
        for (Object jsonObject : jsonArray) {
            valuesList.add((T) ((JSONObject) jsonObject).get(key));
        }
        logger.info(valuesList);
        return valuesList;
    }

    public void closeClient() {
        try {
            client.close();
        } catch (IOException e) {
            logger.warn(e.getMessage());
        }
    }

}
