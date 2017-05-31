package com.javedak09.testmvpapp.LoginView;

/**
 * Created by javed.khan on 5/29/2017.
 */

public interface LoginView {
    void showValidationError();
    boolean ValidateForm();
    void AddUser();
    void loginSuccess();
    void loginError();
}