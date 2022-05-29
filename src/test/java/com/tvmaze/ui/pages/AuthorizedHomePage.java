package com.tvmaze.ui.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AuthorizedHomePage extends AbstractPage {
    @FindBy(xpath = "//*[@href='/calendar']")
    private WebElement calendarButton;
    @FindBy(id = "searchform-q")
    private WebElement searchInput;

    public TVShowCalendarPage clickCalendarButton() {
        calendarButton.click();
        return new TVShowCalendarPage();
    }

    public SearchResultPage typeSearchRequestAndSend(String searchRequest) {
        searchInput.clear();
        searchInput.sendKeys(searchRequest, Keys.ENTER);
        return new SearchResultPage();
    }
}
