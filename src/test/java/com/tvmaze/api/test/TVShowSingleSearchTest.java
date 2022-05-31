package com.tvmaze.api.test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TVShowSingleSearchTest extends AbstractTest{
    @DataProvider(name = "tvShowName")
    public static Object[] provideTVShowName() {
        return new Object[]{"Flash","Walker", "Barry"};
    }

    @Test(dataProvider = "tvShowName")
    public void testGetSingleSearchResponseContainsShow(String tvShowName) {
        String url ="https://api.tvmaze.com/singlesearch/shows?q=" + tvShowName;
        client.sendGet(url);
        Assert.assertTrue(client.isResponseContainTVShow(tvShowName));
    }
}

