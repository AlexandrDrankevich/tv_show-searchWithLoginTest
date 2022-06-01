package com.tvmaze.api.test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TVShowCalendarTest extends AbstractTest{
    @DataProvider(name = "calendarDateAndTVShowName")
    public static Object[][] provideDateAndName() {
        return new Object[][]{{"2022-05-25","The Flash"},{"2022-04-07", "Walker"}, {"2022-06-12", "Barry"}};
    }

    @Test(dataProvider = "calendarDateAndTVShowName")
    public void testGetResponseContainsShowOnDate(String date, String tvShowName) {
        String url ="https://api.tvmaze.com/schedule?country=US&date="+ date;
        client.sendGet(url);
        Assert.assertTrue(client.isResponseContainsTVShow(tvShowName));
    }

    }

