package com.tvmaze.ui.test;

import com.tvmaze.ui.driver.DriverSingleton;
import com.tvmaze.ui.steps.AuthorizeStep;
import com.tvmaze.ui.utils.UserCreator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class AbstractTest {

    @BeforeClass
    public void logIn() {
        AuthorizeStep.logIn(UserCreator.createDefaultUser());
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        DriverSingleton.closeDriver();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
