package com.tvmaze.api.test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TVShowSearchTest extends AbstractTest {
    @DataProvider(name = "partOfName")
    public static Object[] providePartOfTVShowName() {
        return new Object[]{"Law", "Family", "Girls"};
    }

    @Test(dataProvider = "partOfName")
    public void testGetSearchResponseContainsTVShow(String tvShowPartOfName) {
        String url = "https://api.tvmaze.com/search/shows?q=" + tvShowPartOfName;
        client.sendGet(url);
        Assert.assertTrue(client.isResponseContainsTVShow(tvShowPartOfName));
    }
}
