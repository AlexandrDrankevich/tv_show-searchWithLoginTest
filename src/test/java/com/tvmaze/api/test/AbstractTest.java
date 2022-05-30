package com.tvmaze.api.test;

import com.tvmaze.api.client.BaseClient;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class AbstractTest {
    BaseClient client;

    @BeforeClass
    public void getClient() {
        client = new BaseClient();
    }

    @AfterClass
    public void tearDownClient() {
        client.closeClient();
    }
}
