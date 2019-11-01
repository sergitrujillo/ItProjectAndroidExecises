package cat.udl.itproject.itsampleapp;

import java.io.Serializable;

public class User implements Serializable {
    private String mUserLogin;
    private String mUserName;
    private int mImageResourceId;

    public User(String mUserLogin, String mUserName, int mImageResourceId) {
        this.mUserLogin = mUserLogin;
        this.mUserName = mUserName;
        this.mImageResourceId = mImageResourceId;
    }

    public String getmUserLogin() {
        return mUserLogin;
    }

    public void setmUserLogin(String mUserLogin) {
        this.mUserLogin = mUserLogin;
    }

    public String getmUserName() {
        return mUserName;
    }

    public void setmUserName(String mUserName) {
        this.mUserName = mUserName;
    }

    public int getmImageResourceId() {
        return mImageResourceId;
    }

    public void setmImageResourceId(int mImageResourceId) {
        this.mImageResourceId = mImageResourceId;
    }
}
