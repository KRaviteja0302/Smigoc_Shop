package com.example.smigoc_shop.models;

import android.os.Parcel;
import android.os.Parcelable;

public class LoginRequest implements Parcelable {
    String mobile;
    String password;

    public LoginRequest(String mobile, String password) {
        this.mobile = mobile;
        this.password = password;
    }

    protected LoginRequest(Parcel in) {
        mobile = in.readString();
        password = in.readString();
    }

    public static final Creator<LoginRequest> CREATOR = new Creator<LoginRequest>() {
        @Override
        public LoginRequest createFromParcel(Parcel in) {
            return new LoginRequest(in);
        }

        @Override
        public LoginRequest[] newArray(int size) {
            return new LoginRequest[size];
        }
    };

    public String getMobile() {
        return mobile;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mobile);
        dest.writeString(password);
    }
}
