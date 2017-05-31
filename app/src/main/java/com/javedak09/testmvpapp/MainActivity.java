package com.javedak09.testmvpapp;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
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

public class MainActivity extends Activity implements LoginView {

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
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        //presenter = new LoginPresenterImpl(this);
        //presenter.login("admin", "admin");
    }

    public void CreateUser(View view) {

        presenter = new LoginPresenterImpl(this);
        presenter.validate(userid.getText().toString(), passwd.getText().toString());
        presenter.CreateUser(userid.getText().toString(), passwd.getText().toString());
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

    public void OpenDBManager(View view) {
        Intent intent = new Intent(this, AndroidDatabaseManager.class);
        startActivity(intent);
    }
}