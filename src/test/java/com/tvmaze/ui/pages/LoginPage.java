package com.tvmaze.ui.pages;

import com.tvmaze.ui.entity.User;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {
    @FindBy(id = "loginform-username")
    private WebElement inputUserName;
    @FindBy(id = "loginform-password")
    private WebElement inputPassword;
    @FindBy(xpath = "//button[text()='Login']")
    private WebElement loginButton;
    @FindBy(xpath = "//*[@href='/calendar']")
    private WebElement calendarButton;

    public LoginPage authorize(User user) {
        inputUserName.sendKeys(user.getUsername());
        inputPassword.sendKeys(user.getPassword());
        loginButton.click();
        return this;
    }

    public TVShowCalendarPage clickCalendarButton() {
        calendarButton.click();
        return new TVShowCalendarPage();
    }
}
