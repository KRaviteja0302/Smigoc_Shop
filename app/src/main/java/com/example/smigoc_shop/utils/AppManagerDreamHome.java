package com.example.smigoc_shop.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.smigoc_shop.models.LoginResopnse;


public class AppManagerDreamHome {

    SharedPreferences pref;

    private final String KEY_Login = "login";
    private final String KEY_MOBILE = "mobile";

    private final String KEY_ACCESS_TOKEN = "access_token";
    private final String KEY_REFRESH_TOKEN = "refresh_token";


    public AppManagerDreamHome(Context context) {
        pref = context.getSharedPreferences("SMIGOC", Context.MODE_PRIVATE);
    }

    public void saveLoginDone() {
        pref.edit().putBoolean(KEY_Login, true).apply();
    }

    public boolean isLoginDone() {
        return pref.getBoolean(KEY_Login, false);
    }

    public void saveLoginUser(LoginResopnse login) {
        SharedPreferences.Editor edit = pref.edit();
        edit.putString(KEY_MOBILE, login.getRequest().getMobile());

//        edit.putString(KEY_EMAIL, login.getUser().getEmail());
//        edit.putString(KEY_ROLE, login.getRole());
        edit.putString(KEY_ACCESS_TOKEN, login.getJwt().getAccessToken());
        edit.putString(KEY_REFRESH_TOKEN, login.getJwt().getRefreshToken());

//        edit.putString(KEY_USER_TYPE, login.getUsertype());
        edit.commit();
    }




    public String getToken() {
        return pref.getString(KEY_ACCESS_TOKEN, "");
    }

    public String getRefreshToken() {
        return pref.getString(KEY_REFRESH_TOKEN, "");
    }

    public void logout() {
        pref.edit().clear().commit();
    }


}
