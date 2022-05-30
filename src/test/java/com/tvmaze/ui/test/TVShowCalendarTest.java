package com.tvmaze.ui.test;

import com.tvmaze.ui.steps.TVShowCalendarStep;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TVShowCalendarTest extends AbstractTest {
    @DataProvider(name = "calendarDateAndTVShowName")
    public static Object[][] provideDateAndName() {
        return new Object[][]{{"25 May", "The Flash"}, {"07 April", "Walker"}, {"12 June", "Barry"}};
    }

    @Test(dataProvider = "calendarDateAndTVShowName")
    public void testCalendarContainsShowOnDate(String date, String tvShowName) {
        TVShowCalendarStep tvShowCalendarStep = new TVShowCalendarStep().openTVSHowCalendarOnDate(date);
        Assert.assertTrue(tvShowCalendarStep.isCalendarOnDateContainsTVShow(tvShowName));
    }
}
