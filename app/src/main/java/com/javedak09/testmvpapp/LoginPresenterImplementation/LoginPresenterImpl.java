package com.javedak09.testmvpapp.LoginPresenterImplementation;

import android.app.Activity;
import android.text.TextUtils;
import android.widget.Toast;

import com.javedak09.testmvpapp.LoginView.LoginView;
import com.javedak09.testmvpapp.LoginContract.LoginPresenter;

/**
 * Created by javed.khan on 5/29/2017.
 */

public class LoginPresenterImpl implements LoginPresenter {
    LoginView loginView;

    public LoginPresenterImpl(LoginView loginView) {
        this.loginView = loginView;
    }

    @Override
    public void login(String username, String password) {
        if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {
            loginView.showValidationError();
        } else {
            if (username.equals("admin") && password.equals("admin")) {
                loginView.loginSuccess();
            } else {
                loginView.loginError();
            }
        }
    }

    @Override
    public void validate(String username, String password) {
        loginView.ValidateForm();
    }

    @Override
    public void CreateUser(String username, String password) {
        loginView.AddUser();
    }
}