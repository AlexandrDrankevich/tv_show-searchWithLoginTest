package com.tvmaze.ui.pages;

import com.tvmaze.ui.entity.TVShow;
import com.tvmaze.ui.utils.DateConverter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

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
    private String patternShowLocator = "//div[contains(@class,'%s-%s')]//li";
    String month = "May";
    int date = 23;

    public TVShowCalendarPage selectShowCalendarFilter() {
        selectFilter.click();
        waitForVisibilityOfElement(filterPopular).click();
        return this;
    }

    public TVShowCalendarPage chooseDate() {
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

    public List<TVShow> createShowList() {

        String ShowLocator = String.format(patternShowLocator, DateConverter.monthToInt(month), date);
        List<WebElement> showElements = driver.findElements(By.xpath(ShowLocator));
        List<TVShow> showsList = new ArrayList<>();
        for (WebElement showElement : showElements) {
            String showName = showElement.findElement(By.xpath("./div/span/a")).getText();
            String episodeName = showElement.findElement(By.xpath("./div/a")).getAttribute("title");
            String episodeNumber = showElement.findElement(By.xpath("./div/a")).getText();
            showsList.add(new TVShow(showName, episodeName, episodeNumber));
        }
        logger.info(showsList);
        return showsList;
    }

}

