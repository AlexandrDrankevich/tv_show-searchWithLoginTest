package com.tvmaze.api.test;

import com.tvmaze.api.client.CustomClient;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class AbstractTest {
    CustomClient client;

    @BeforeMethod
    public void getClient() {
        client = new CustomClient();
    }

    @AfterMethod
    public void tearDownClient() {
        client.closeClient();
    }
}
