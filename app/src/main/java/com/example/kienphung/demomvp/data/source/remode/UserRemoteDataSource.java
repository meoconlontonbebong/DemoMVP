package com.example.kienphung.demomvp.data.source.remode;

import com.example.kienphung.demomvp.data.source.UserDataSource;

public class UserRemoteDataSource implements UserDataSource.RemoteDataSource {
    private static UserRemoteDataSource sUserRemoteDataSource;

    public UserRemoteDataSource() {
    }

    public static synchronized UserRemoteDataSource getInstance() {
        if (sUserRemoteDataSource == null) sUserRemoteDataSource = new UserRemoteDataSource();
        return sUserRemoteDataSource;
    }

    public static void destroyInstance() {
        if (sUserRemoteDataSource != null) sUserRemoteDataSource = null;
    }

    @Override
    public void login(String username, String password, UserRemoteDataSource.OnLoginComplete onLoginComplete) {
        if (username.equals("username") && password.equals("password")) onLoginComplete.onSuccess();
        else onLoginComplete.onFail();
    }

    public interface OnLoginComplete {
        void onSuccess();

        void onFail();
    }
}
