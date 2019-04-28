package org.pursuit.marvelfordummies.data.network;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

final class MarvelRetrofit {
    private static final String BASE_URL = "https://gateway.marvel.com/v1/public/";
    private static Retrofit instance;

    synchronized static Retrofit getInstance() {
        if (instance == null) {
            instance = new Retrofit.Builder()
              .baseUrl(BASE_URL)
              .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
              .addConverterFactory(GsonConverterFactory.create())
              .client(new OkHttpClient.Builder()
                .readTimeout(15, TimeUnit.SECONDS)
                .connectTimeout(15, TimeUnit.SECONDS)
                .build())
              .build();
        }
        return instance;
    }
}
