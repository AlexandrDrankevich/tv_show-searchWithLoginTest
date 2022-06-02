package com.tvmaze.ui.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AuthorizedHomePage extends AbstractPage {
    @FindBy(xpath = "//*[@href='/calendar']")
    private WebElement calendarButton;
    @FindBy(id = "searchform-q")
    private WebElement searchInput;
    @FindBy(id="user-menu")
    private WebElement buttonUserMenu;
    @FindBy(xpath = "//*[@id='user-thumb']//h3")
    private WebElement userName;
    @FindBy(xpath = "//*[contains(@href,'logout')]")
    private WebElement buttonLogOut;

    public TVShowCalendarPage clickCalendarButton() {
        calendarButton.click();
        return new TVShowCalendarPage();
    }

    public SearchResultPage typeSearchRequestAndSend(String searchRequest) {
        searchInput.clear();
        searchInput.sendKeys(searchRequest, Keys.ENTER);
        return new SearchResultPage();
    }
    public String getAuthorizedUserName(){
        buttonUserMenu.click();
        return waitForVisibilityOfElement(userName).getText();
    }
    public void logOut(){
        buttonUserMenu.click();
        waitForVisibilityOfElement(buttonLogOut).click();
    }
}
