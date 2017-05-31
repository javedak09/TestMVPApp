package com.javedak09.testmvpapp.contracts;

import android.provider.BaseColumns;

/**
 * Created by javed.khan on 5/30/2017.
 */

public class UserContract {
    private static final String TAG = "Users_CONTRACT";
    Long _ID;
    String ROW_USERNAME;
    String ROW_PASSWORD;

    public UserContract() {
        // Default Constructor
    }

    public UserContract(String username, String password) {
        this.ROW_PASSWORD = password;
        this.ROW_USERNAME = username;
    }

    public Long getUserID() {
        return this._ID;
    }

    public void setId(int id) {
        this._ID = Long.valueOf(id);
    }

    public String getUserName() {
        return this.ROW_USERNAME;
    }

    public void setUserName(String username) {
        this.ROW_USERNAME = username;
    }

    public String getPassword() {
        return this.ROW_PASSWORD;
    }

    public void setPassword(String password) {
        this.ROW_PASSWORD = password;
    }

    public static abstract class singleUser implements BaseColumns {

        public static final String URI = "/getusers.php";

        public static final String TABLE_NAME = "users";
        public static final String _ID = "id";
        public static final String ROW_USERNAME = "userid";
        public static final String ROW_PASSWORD = "passwd";

    }
}