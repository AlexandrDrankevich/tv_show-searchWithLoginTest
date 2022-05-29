package com.tvmaze.ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AuthorizedHomePage extends AbstractPage {
    @FindBy(xpath = "//*[@href='/calendar']")
    private WebElement calendarButton;
    public TVShowCalendarPage clickCalendarButton() {
        calendarButton.click();
        return new TVShowCalendarPage();
    }
}
