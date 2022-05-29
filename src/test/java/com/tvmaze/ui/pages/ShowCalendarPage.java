package com.tvmaze.ui.pages;

import com.tvmaze.ui.utils.DateConverter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShowCalendarPage extends AbstractPage {
    @FindBy(xpath = "//*[@name='filter']")
    private WebElement selectFilter;
    @FindBy(xpath = "//*[@value='popular']")
    private WebElement filterPopular;
    @FindBy(id = "month")
    private WebElement presentMonthName;
    @FindBy(xpath = "//div[contains(@class,'text-left')]/a")
    private WebElement previousMonth;
    @FindBy(xpath = "//div[contains(@class,'text-right')]/a")
    private WebElement nextMonth;

    String month = "August";
    int date = 28;

    public ShowCalendarPage selectShowCalendarFilter() {
        selectFilter.click();
        waitForVisibilityOfElement(filterPopular).click();
        return this;
    }

    public ShowCalendarPage chooseDate() {
        int searchingMonth = DateConverter.monthToInt(month);
        int presentMonth = DateConverter.monthToInt(presentMonthName.getText());
        if (searchingMonth == presentMonth) {
            return this;
        } else {
            if (searchingMonth < presentMonth) {
                previousMonth.click();
                chooseDate();
            }
            if (searchingMonth > presentMonth) {
                nextMonth.click();
                chooseDate();
            }
        }
        return this;
    }

}

