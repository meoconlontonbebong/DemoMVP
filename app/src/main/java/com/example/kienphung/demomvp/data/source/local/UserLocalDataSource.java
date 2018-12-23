package com.example.kienphung.demomvp.data.source.local;

import com.example.kienphung.demomvp.data.model.User;
import com.example.kienphung.demomvp.data.source.UserDataSource;

public class UserLocalDataSource implements UserDataSource.LocalDataSource {
    private static UserLocalDataSource sUserLocalDataSource;

    public UserLocalDataSource() {
    }

    public static synchronized UserLocalDataSource getInstance() {
        if (sUserLocalDataSource == null) sUserLocalDataSource = new UserLocalDataSource();
        return sUserLocalDataSource;
    }

    public void destroyInstance() {
        if (sUserLocalDataSource != null) sUserLocalDataSource = null;
    }

    @Override
    public void insertUser(User user) {

    }

    @Override
    public void getUser(String userId) {

    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public void deleteUser(User user) {

    }
}
