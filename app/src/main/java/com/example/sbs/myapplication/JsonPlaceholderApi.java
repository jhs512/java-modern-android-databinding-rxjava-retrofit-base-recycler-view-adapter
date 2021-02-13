package com.example.sbs.myapplication;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;

public interface JsonPlaceholderApi {
    @GET("/todos")
    Observable<List<Article>> todos();

}
