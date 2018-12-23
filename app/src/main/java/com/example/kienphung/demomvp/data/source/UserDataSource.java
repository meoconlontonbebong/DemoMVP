package com.example.kienphung.demomvp.data.source;

import com.example.kienphung.demomvp.data.model.User;
import com.example.kienphung.demomvp.data.source.remode.UserRemoteDataSource;

public interface UserDataSource {
    interface LocalDataSource extends UserDataSource {
        void insertUser(User user);

        void getUser(String userId);

        void updateUser(User user);

        void deleteUser(User user);
    }

    interface RemoteDataSource extends UserDataSource {
        void login(String username, String password
                , UserRemoteDataSource.OnLoginComplete onLoginComplete);
    }
}
