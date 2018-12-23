package com.example.kienphung.demomvp.screen.login;

import com.example.kienphung.demomvp.screen.BasePresenter;

public interface LoginContract {
    interface View {

        void showProgressBar();

        void hideProgressBar();

        void showUsernameErrorMessage();

        void showPasswordErrorMessage();

        void showLoginFailMessage();

        void toHomeActivity();
    }

    interface Presenter extends BasePresenter<LoginContract.View> {
        void login(String username, String password);
    }
}
