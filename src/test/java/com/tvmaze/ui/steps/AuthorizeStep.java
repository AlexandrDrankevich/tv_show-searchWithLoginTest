package com.tvmaze.ui.steps;

import com.tvmaze.ui.entity.User;
import com.tvmaze.ui.pages.HomePage;
import com.tvmaze.ui.utils.UserCreator;

public class AuthorizeStep {
    public static void logIn() {
        User user = UserCreator.createUser();
        new HomePage().openPage()
                .clickLoginButton()
                .authorize(user);
    }
}
