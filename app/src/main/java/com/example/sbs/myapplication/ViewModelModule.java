package com.example.sbs.myapplication;

import dagger.Binds;
import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ViewModelComponent;
import dagger.hilt.android.scopes.ViewModelScoped;

@InstallIn(ViewModelComponent.class)
@Module
public abstract class ViewModelModule {
    /*
    @Binds
    @ViewModelScoped
    public static ArticleService provideArticleService() {
        return new ArticleService();
    }
    */
}