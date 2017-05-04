package com.mlsdev.mlschatandroid.data.remote.api;

import com.mlsdev.mlschatandroid.BuildConfig;
import com.mlsdev.mlschatandroid.data.remote.api.contract.ChatsApiContract;
import com.mlsdev.mlschatandroid.data.remote.api.contract.ProfileAPIContract;
import com.mlsdev.mlschatandroid.data.remote.api.contract.UsersAPIContract;
import com.mlsdev.mlschatandroid.data.remote.api.handler.RxErrorHandlingCallAdapterFactory;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by oleksandr on 03.05.17.
 */

public class APIManager {

    private ChatsApiContract chatsApi;
    private ProfileAPIContract profileAPIContract;
    private UsersAPIContract usersAPIContract;

    private static APIManager instance;

    private APIManager() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);


        OkHttpClient client = new OkHttpClient.Builder().addNetworkInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request original = chain.request();

                Request.Builder requestBuilder = original.newBuilder();
                requestBuilder.header("Accept", "application/json");

                Request request = requestBuilder.build();
                return chain.proceed(request);
            }
        })
                .addInterceptor(loggingInterceptor).build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxErrorHandlingCallAdapterFactory.create())
                .client(client)
                .build();

//        TODO implement api creating

    }

    public static APIManager getInstance() {
        if (instance == null) {
            instance = new APIManager();
        }
        return instance;
    }

    public ChatsApiContract getChatsApi() {
        return chatsApi;
    }

    public ProfileAPIContract getProfileAPIContract() {
        return profileAPIContract;
    }

    public UsersAPIContract getUsersAPIContract() {
        return usersAPIContract;
    }
}
