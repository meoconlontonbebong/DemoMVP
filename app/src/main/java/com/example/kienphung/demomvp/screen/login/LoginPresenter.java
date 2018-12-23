package com.example.kienphung.demomvp.screen.login;

import com.example.kienphung.demomvp.data.repositoty.UserRepository;
import com.example.kienphung.demomvp.data.source.remode.UserRemoteDataSource;
import com.example.kienphung.demomvp.util.commom.StringUtil;

public class LoginPresenter implements LoginContract.Presenter, UserRemoteDataSource.OnLoginComplete {
    private LoginContract.View mView;
    private UserRepository mUserRepository;

    public LoginPresenter(UserRepository userRepository) {
        this.mUserRepository = userRepository;
    }

    @Override
    public void onSuccess() {

        mView.toHomeActivity();


    }

    @Override
    public void onFail() {
        mView.showLoginFailMessage();

    }

    @Override
    public void login(String username, String password) {
        mView.showProgressBar();
        if (!StringUtil.checkValidateUsername(username)) {
            mView.showUsernameErrorMessage();
            return;
        }
        if (!StringUtil.checkValidatePassword(password)) {
            mView.showPasswordErrorMessage();
            return;
        }
        mUserRepository.login(username, password, this);
    }

    @Override
    public void setView(LoginContract.View view) {
        this.mView = view;
    }

    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }
}
