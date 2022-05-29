package com.tvmaze.ui.pages;

import com.tvmaze.ui.utils.DateSelection;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShowShowCalendarPage extends AbstractPage {
    @FindBy(xpath = "//*[@name='filter']")
    private WebElement selectFilter;
    @FindBy(xpath = "//*[@value='popular']")
    private WebElement filterPopular;
    @FindBy(id = "month")
    private WebElement monthName;
    String month = "March";
    int date = 28;

    public ShowShowCalendarPage selectShowCalendarFilter() {
        selectFilter.click();
        waitForVisibilityOfElement(filterPopular).click();
        return this;
    }

    public ShowShowCalendarPage date() {
        int searchingMonth = DateSelection.monthToInt(month);
        int presentMonth = DateSelection.monthToInt(monthName.getText());

        if (searchingMonth == presentMonth) {
            return this;
        } else {
            if(searchingMonth<presentMonth){
                while ()
            }

        }


    }

}

