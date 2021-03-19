package com.example.smigoc_shop;

import android.app.Application;
import android.content.Context;

import androidx.room.Room;

import com.example.smigoc_shop.db.DBClient;
import com.example.smigoc_shop.network.ApiRequest;
import com.example.smigoc_shop.network.ApiService;


public class AppLoader extends Application {

    private static ApiRequest apiRequest;
    private Context context;
    private static DBClient db;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        if (apiRequest == null)
            apiRequest = new ApiRequest(getApplicationContext());
    }

    public static ApiService getRetrofit() {
        return apiRequest.getRetrofit();
    }

    public static DBClient getDBClient(Context context) {
        if (db == null)
            db = Room.databaseBuilder(context, DBClient.class, "smigoc-shop").build();
        return db;
    }
}
