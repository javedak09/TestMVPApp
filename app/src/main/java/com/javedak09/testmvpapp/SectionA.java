package com.javedak09.testmvpapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.javedak09.testmvpapp.LoginContract.LoginPresenter;
import com.javedak09.testmvpapp.LoginPresenterImplementation.LoginPresenterImpl;
import com.javedak09.testmvpapp.LoginView.LoginView;
import com.javedak09.testmvpapp.contracts.UserContract;
import com.javedak09.testmvpapp.core.DBHelper;

import butterknife.ButterKnife;
import butterknife.BindView;
import butterknife.OnClick;


public class SectionA extends Activity implements LoginView {

    @BindView(R.id.userid)
    EditText userid;

    @BindView(R.id.passwd)
    EditText passwd;

    String var_userid;
    String var_passwd;

    private LoginPresenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnCreateUser)
    void CreateUser() {
        presenter = new LoginPresenterImpl(this);
        if (presenter.validate(userid.getText().toString(), passwd.getText().toString())) {
            presenter.CreateUser(userid.getText().toString(), passwd.getText().toString());
        }
    }

    @OnClick(R.id.btnCancel)
    void CancelEntry() {
        userid.setText(null);
        passwd.setText(null);
    }

    @Override
    public boolean ValidateForm() {

        if (userid.getText().toString().isEmpty()) {
            Toast.makeText(this, "ERROR(Empty) User id required ", Toast.LENGTH_SHORT).show();
            userid.requestFocus();
            return false;
        }

        if (passwd.getText().toString().isEmpty()) {
            Toast.makeText(this, "ERROR(Empty) Password required ", Toast.LENGTH_SHORT).show();
            passwd.requestFocus();
            return false;
        }

        return true;
    }


    @Override
    public void AddUser() {

        UserContract uc = new UserContract();
        DBHelper db = new DBHelper(this);

        uc.setUserName(userid.getText().toString());
        uc.setPassword(passwd.getText().toString());

        db.addForm(uc);
    }


    @Override
    public void showValidationError() {
        Toast.makeText(this, "Please enter valid username and password!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginSuccess() {
        Toast.makeText(this, "You are succussfully logged in!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginError() {
        Toast.makeText(this, "Invalid login credintails!", Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.btnDBManager)
    void OpenDBManager() {
        Intent intent = new Intent(this, AndroidDatabaseManager.class);
        startActivity(intent);
    }
}