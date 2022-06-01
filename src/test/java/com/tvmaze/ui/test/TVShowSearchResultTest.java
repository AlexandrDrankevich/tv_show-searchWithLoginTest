package com.tvmaze.ui.test;

import com.tvmaze.ui.steps.SearchResultStep;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TVShowSearchResultTest extends AbstractTest{
    @DataProvider(name = "partOfName")
    public static Object[] providePartOfTVShowName() {
        return new Object[]{"Law","Family","Girls"};
    }

    @Test(dataProvider = "partOfName")
    public void testSearchResultContainsTVShow(String tvShowPartOfName) {
        SearchResultStep searchResultStep=new SearchResultStep().openSearchResultByRequest(tvShowPartOfName);
        Assert.assertTrue(searchResultStep.isSearchResultListContainsTVShow(tvShowPartOfName));
    }

    @DataProvider(name = "invalidRequest")
    public static Object[] provideInvalidRequest() {
        return new Object[]{"rgregrgr"," ","llnb"};
    }

    @Test(dataProvider = "invalidRequest")
    public void testSearchResultMessageWithInvalidRequest(String request) {
        SearchResultStep searchResultStep=new SearchResultStep().openSearchResultByRequest(request);
        Assert.assertTrue(searchResultStep.isSearchResultContainsExpectedMessage());
    }
}
