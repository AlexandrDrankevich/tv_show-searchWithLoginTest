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
    @FindBy(xpath = "//div[contains(text(),'Incorrect password')]")
    private WebElement incorrectPasswordMessage;
    @FindBy(xpath = "//div[contains(text(),'Unknown username/email')]")
    private WebElement incorrectUserNameMessage;

    public AuthorizedHomePage authorize(User user) {
        inputUserName.sendKeys(user.getUsername());
        inputPassword.sendKeys(user.getPassword());
        loginButton.click();
        return new AuthorizedHomePage();
    }

    public String getPasswordErrorMessage() {
        String message = waitForVisibilityOfElement(incorrectPasswordMessage).getText();
        logger.info("Authorize with incorrect pass message: " + message);
        return message;
    }

    public String getUserNameErrorMessage() {
        String message = waitForVisibilityOfElement(incorrectUserNameMessage).getText();
        logger.info("Authorize with incorrect name message: " + message);
        return message;

    }
}
