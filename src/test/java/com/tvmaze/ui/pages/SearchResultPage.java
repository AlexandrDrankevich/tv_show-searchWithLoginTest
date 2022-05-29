package com.tvmaze.ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultPage extends AbstractPage{
    @FindBy(xpath = "//*[@id='w0']/div/article")
    protected List<WebElement> tvShowCardList;
    protected String tvShowNamePathInCard="//*[@id='w0']//*[@class='showname']//a";
    protected String episodeNamePathInCard="//*[@id='w0']//*[@class='auto cell episode-info']//a";

}
