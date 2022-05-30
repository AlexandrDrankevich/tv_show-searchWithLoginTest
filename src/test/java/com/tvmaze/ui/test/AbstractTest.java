package com.tvmaze.ui.test;

import com.tvmaze.ui.driver.DriverSingleton;
import com.tvmaze.ui.steps.AuthorizeStep;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class AbstractTest {

    @BeforeTest
    public void logIn() {
        AuthorizeStep.logIn();
    }

    @AfterTest
    public void tearDown() {
        DriverSingleton.closeDriver();
    }
}
