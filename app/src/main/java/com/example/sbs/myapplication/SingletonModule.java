package com.example.sbs.myapplication;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@InstallIn(SingletonComponent.class)
@Module
public class SingletonModule {
    @Provides
    @Singleton
    public static ArticleService provideArticleService(JsonPlaceholderApi jsonPlaceholderApi) {
        return new ArticleService(jsonPlaceholderApi);
    }

    @Provides
    @Singleton
    public static JsonPlaceholderApi provideJsonPlaceholderApi() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com")
                .addConverterFactory(GsonConverterFactory.create()) // GSON 사용
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create()) // RX Java 사용
                .build();

        return retrofit.create(JsonPlaceholderApi.class);
    }
}
