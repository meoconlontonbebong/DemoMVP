package com.example.kienphung.demomvp.screen;

public interface BasePresenter<T> {
    void setView(T view);
    void start();
    void stop();
}
