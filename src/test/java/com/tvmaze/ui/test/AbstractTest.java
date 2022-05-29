package com.tvmaze.ui.test;

import com.tvmaze.ui.driver.DriverSingleton;
import org.testng.annotations.AfterMethod;

public class AbstractTest {

    @AfterMethod
    public void tearDown() {
        DriverSingleton.closeDriver();
    }
}
