package com.tvmaze.ui.test;

import com.tvmaze.ui.driver.DriverSingleton;
import com.tvmaze.ui.steps.AuthorizeStep;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class AbstractTest {

    @BeforeClass
    public void logIn() {
        AuthorizeStep.logIn();
    }

    @AfterClass
    public void tearDown() {
        DriverSingleton.closeDriver();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
