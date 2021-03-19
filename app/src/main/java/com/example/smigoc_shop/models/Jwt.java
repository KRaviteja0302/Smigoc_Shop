package com.example.smigoc_shop.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Jwt implements Parcelable {

	@SerializedName("access_token")
	private String accessToken;
	@SerializedName("refresh_token")
	private String refreshToken;

	protected Jwt(Parcel in) {
		accessToken = in.readString();
		refreshToken = in.readString();
	}

	public String getAccessToken() {
		return accessToken;
	}

	public String getRefreshToken() {
		return refreshToken;
	}

	public static Creator<Jwt> getCREATOR() {
		return CREATOR;
	}

	public static final Creator<Jwt> CREATOR = new Creator<Jwt>() {
		@Override
		public Jwt createFromParcel(Parcel in) {
			return new Jwt(in);
		}

		@Override
		public Jwt[] newArray(int size) {
			return new Jwt[size];
		}
	};

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(accessToken);
		dest.writeString(refreshToken);
	}
}
