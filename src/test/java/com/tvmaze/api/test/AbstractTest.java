package com.tvmaze.api.test;

import com.tvmaze.api.client.BaseClient;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class AbstractTest {
    BaseClient client;

    @BeforeMethod
    public void getClient() {
        client = new BaseClient();
    }

    @AfterMethod
    public void tearDownClient() {
        client.closeClient();
    }
}
