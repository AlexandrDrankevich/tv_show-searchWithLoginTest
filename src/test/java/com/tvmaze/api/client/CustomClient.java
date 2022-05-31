package com.tvmaze.api.client;

import com.tvmaze.api.utils.BodyProcessing;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class CustomClient {
    private CloseableHttpClient client;
    private CloseableHttpResponse response;
    private int statusCode;
    private String body;
    public static final Logger logger = LogManager.getLogger();


    public CustomClient() {
        client = HttpClientBuilder.create().build();
    }

    public void sendGet(String url) {
        try {
            response = client.execute(new HttpGet(url));
        } catch (IOException e) {
            logger.warn(e.getMessage());
        }
        logger.info("Request: " + url);
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

    public boolean isResponseContainTVShow(String tvShow) {
        return BodyProcessing.isResponseContainTVShow(tvShow, getBody());
    }

    public void closeClient() {
        try {
            client.close();
        } catch (IOException e) {
            logger.warn(e.getMessage());
        }
    }
}
