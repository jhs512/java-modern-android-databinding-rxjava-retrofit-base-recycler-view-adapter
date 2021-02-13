package com.example.sbs.myapplication;

import android.app.Application;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.sbs.myapplication.databinding.ActivityMainBinding;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class MainViewModel extends AndroidViewModel {
    private final ArticleService articleService;

    private final MutableLiveData<String> lvTitle;
    private final MutableLiveData<Integer> lvTitleBackground;
    private final MutableLiveData<Boolean> lvImageViewVisible;
    private final MutableLiveData<List<Article>> lvArticles;

    @Inject
    public MainViewModel(@NonNull Application application, ArticleService articleService) {
        super(application);
        this.articleService = articleService;

        lvTitle = new MutableLiveData<>("안녕하세요.");
        lvTitleBackground = new MutableLiveData<>(R.color.black);
        lvImageViewVisible = new MutableLiveData<>(false);
        lvArticles = new MutableLiveData<>();
    }

    public void initView(ActivityMainBinding mainBinding) {
        mainBinding.activityMainRecyclerViewArticle.setAdapter(new BaseRecyclerViewAdapter<Article>(R.layout.item_article));
        loadArticles();
    }

    private void loadArticles() {
        articleService.getArticles(resultData -> {
            lvArticles.setValue(resultData.body.articles);
        }, throwable -> {
            Toast.makeText(getApplication(), "통신오류", Toast.LENGTH_SHORT).show();
        });
    }

    public MutableLiveData<String> getLvTitle() {
        return lvTitle;
    }

    public void setLvTitle(String title) {
        lvTitle.setValue(title);
    }

    public MutableLiveData<Integer> getLvTitleBackground() {
        return lvTitleBackground;
    }

    public void setLvTitleBackground(int color) {
        lvTitleBackground.setValue(color);
    }

    public MutableLiveData<Boolean> getLvImageViewVisible() {
        return lvImageViewVisible;
    }

    public void setLvImageViewVisible(boolean visible) {
        lvImageViewVisible.setValue(visible);
    }

    public MutableLiveData<List<Article>> getLvArticles() {
        return lvArticles;
    }
}
