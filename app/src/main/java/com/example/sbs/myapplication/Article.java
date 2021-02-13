package com.example.sbs.myapplication;

import androidx.lifecycle.ViewModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Article implements HaveItemViewModel {
    public int id;
    public int userId;
    public String title;
    public boolean completed;
    public ViewModel articleViewModel;

    public ViewModel getItemViewModel(int layoutId) {
        if (articleViewModel == null) {
            if (layoutId == R.layout.item_article) {
                articleViewModel = new ArticleType1ViewModel(this);
            }
        }

        return articleViewModel;
    }
}
