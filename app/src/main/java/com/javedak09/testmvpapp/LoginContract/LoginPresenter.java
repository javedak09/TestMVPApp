package com.javedak09.testmvpapp.LoginContract;

/**
 * Created by javed.khan on 5/29/2017.
 */

public interface LoginPresenter {
    void login(String username, String password);
    boolean validate(String username, String password);
    void CreateUser(String username, String password);
}