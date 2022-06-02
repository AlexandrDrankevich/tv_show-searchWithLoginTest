package com.tvmaze.ui.steps;

import com.tvmaze.ui.entity.User;
import com.tvmaze.ui.pages.AuthorizedHomePage;
import com.tvmaze.ui.pages.HomePage;

public class AuthorizeStep {
    public static AuthorizedHomePage logIn(User user) {
        return new HomePage().openPage()
                .clickLoginButton()
                .authorize(user);
    }
}
