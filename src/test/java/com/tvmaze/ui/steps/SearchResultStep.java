package com.tvmaze.ui.steps;

import com.tvmaze.ui.entity.TVShow;
import com.tvmaze.ui.pages.AuthorizedHomePage;
import com.tvmaze.ui.pages.SearchResultPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class SearchResultStep extends SearchResultPage {
    List<TVShow> tvShowList;

    public SearchResultStep openSearchResultByRequest(String searchRequest) {
        new AuthorizedHomePage()
                .typeSearchRequestAndSend(searchRequest);
        logger.info("Part of TVShow name: " + searchRequest);
        return this;
    }

    public List<TVShow> createSearchResultList() {
        String episodeName;
        tvShowList = new ArrayList<>();
        for (WebElement tvShowCard : tvShowCardList) {
            String tvShowName = tvShowCard.findElement(By.xpath(".//*[@class='showname']//a")).getText();
            try {
                episodeName = tvShowCard.findElement(By.xpath(".//*[@class='auto cell episode-info']//a")).getText();
            } catch (Exception e) {
                episodeName = "no name";
            }
            tvShowList.add(new TVShow(tvShowName, episodeName));
        }
        logger.info(tvShowList);
        return tvShowList;
    }

    public boolean isSearchResultListContainTVShow(String tvShow) {
        if (tvShowList == null) {
            tvShowList = createSearchResultList();
        }
        return tvShowList.stream().anyMatch(s -> s.getShowName().contains(tvShow));
    }
}

