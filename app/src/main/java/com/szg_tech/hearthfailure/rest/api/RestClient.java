package com.szg_tech.hearthfailure.rest.api;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by ahmetkucuk on 3/16/17.
 */

public class RestClient {
    //private static final String BASE_URL = "http://api.calchfrisk.net/";
    private static final String BASE_URL = "http://pulmonaryhypertensionexpert.com/";

    //    private static final String BASE_URL = "http://heart.xpsign.com/api/";
    private static ApiService apiService;

    public RestClient(String token) {
        // Add the interceptor to OkHttpClient
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.interceptors().add(new AuthenticationInterceptor(token));
        builder.connectTimeout(120, TimeUnit.SECONDS)
                .writeTimeout(120, TimeUnit.SECONDS)
                .readTimeout(120, TimeUnit.SECONDS)
                .addInterceptor(logging);
        OkHttpClient client = builder.build();

        Retrofit restAdapter = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        apiService = restAdapter.create(ApiService.class);
    }

    public ApiService getApi() {
        return apiService;
    }

}
