

package com.tvmaze.ui.test;

import com.tvmaze.ui.driver.DriverSingleton;
import com.tvmaze.ui.entity.User;
import com.tvmaze.ui.pages.AuthorizedHomePage;
import com.tvmaze.ui.pages.LoginPage;
import com.tvmaze.ui.steps.AuthorizeStep;
import com.tvmaze.ui.utils.RetryAnalyzer;
import com.tvmaze.ui.utils.TestListener;
import com.tvmaze.ui.utils.UserCreator;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({TestListener.class})
public class TvMazeLoginTest {
    @AfterMethod
    public void tearDown() throws InterruptedException {
        DriverSingleton.closeDriver();
        Thread.sleep(6000);
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void testAuthorizeWithCorrectData() {
        User user = UserCreator.createDefaultUser();
        AuthorizedHomePage authorizedHomePage = AuthorizeStep.logIn(user);
        Assert.assertEquals(authorizedHomePage.getAuthorizedUserName(), user.getUsername());
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void testAuthorizeWithInCorrectPassword() {
        User user = UserCreator.createUser("Alexandr", "2789");
        AuthorizeStep.logIn(user);
        Assert.assertTrue(new LoginPage().getPasswordErrorMessage().contains("Incorrect password"));
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void testAuthorizeWithInCorrectUserName() {
        User user = UserCreator.createUser("Alexandrem", "27052009");
        AuthorizeStep.logIn(user);
        Assert.assertTrue(new LoginPage().getUserNameErrorMessage().contains("Unknown username"));
    }
}