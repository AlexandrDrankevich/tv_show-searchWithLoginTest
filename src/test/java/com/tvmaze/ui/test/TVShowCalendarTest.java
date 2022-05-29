package com.tvmaze.ui.test;

import com.tvmaze.ui.entity.User;
import com.tvmaze.ui.pages.HomePage;
import com.tvmaze.ui.utils.UserCreator;
import org.testng.annotations.Test;

public class TVShowCalendarTest extends AbstractTest {
    @Test
    public void testCalendarContainsShowOnDate(){
        User user = UserCreator.createUser();
        new HomePage().openPage()
                .clickLoginButton()
                .authorize(user)
                .clickCalendarButton()
                .selectShowCalendarFilter()
                .chooseDate()
                .createShowList();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
