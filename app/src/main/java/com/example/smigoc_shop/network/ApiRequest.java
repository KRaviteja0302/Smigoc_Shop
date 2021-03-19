package com.example.smigoc_shop.network;

import android.content.Context;
import android.content.Intent;



import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiRequest {

    private String BASE_URL = "http://milk.smigocsoftwaresolutions.com/";

    Context context;

    public ApiRequest(Context context) {
        this.context = context;
    }

    public ApiService getRetrofit() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .addInterceptor(new AppInterceptor(context))
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client)
                .build();
        return retrofit.create(ApiService.class);
    }

    public static <T> ObservableTransformer<T, T> applyObservableAsync() {
        return observable -> observable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public class AppInterceptor implements Interceptor {

        Context context;

        public AppInterceptor(Context context) {
            this.context = context;
        }

        @NotNull
        @Override
        public Response intercept(@NotNull Chain chain) throws IOException {
            Request request = chain.request().newBuilder()
                    .addHeader("version", "1.0")
                    .addHeader("Appid", "$#!G@(-$3@p")
                    .build();
            Response response = chain.proceed(request);
            if (response.code() == 401) {
                //token expired or invalid user
              //  context.startActivity(new Intent(context, LoginActivity.class));
            }
            return response;
        }
    }
}
