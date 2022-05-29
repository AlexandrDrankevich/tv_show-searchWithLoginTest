package com.tvmaze.ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage {
    private final String BASE_URL = "https://www.tvmaze.com/";
    @FindBy(xpath = "//*[@href='/account/login']")
    private WebElement loginButton;

    public HomePage openPage() {
        driver.get(BASE_URL);
        return this;
    }

    public LoginPage clickLoginButton() {
        loginButton.click();
        return new LoginPage();
    }
}
