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
        Assert.assertTrue(searchResultStep.isSearchResultListContainTVShow(tvShowPartOfName));

    }
}
