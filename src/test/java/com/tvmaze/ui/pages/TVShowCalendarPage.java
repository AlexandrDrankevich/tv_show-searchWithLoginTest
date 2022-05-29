package com.tvmaze.ui.pages;

import com.tvmaze.ui.utils.DateConverter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TVShowCalendarPage extends AbstractPage {
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
    protected String patternShowLocator = "//div[contains(@class,'%s-%s')]//li";

    public TVShowCalendarPage selectShowCalendarFilter() {
        selectFilter.click();
        waitForVisibilityOfElement(filterPopular).click();
        return this;
    }

    public TVShowCalendarPage chooseDate(String month) {
        int searchingMonth = DateConverter.monthToInt(month);
        int presentMonth = DateConverter.monthToInt(presentMonthName.getText());
        if (searchingMonth == presentMonth) {
            return this;
        } else {
            if (searchingMonth < presentMonth) {
                previousMonth.click();
                chooseDate(month);
            }
            if (searchingMonth > presentMonth) {
                nextMonth.click();
                chooseDate(month);
            }
        }
        return this;
    }
}

