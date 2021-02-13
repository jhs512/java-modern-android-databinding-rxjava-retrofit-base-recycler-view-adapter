package com.example.sbs.myapplication;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.sbs.myapplication.databinding.ActivityMainBinding;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        mainBinding.setLifecycleOwner(this);

        MainViewModel mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        mainBinding.setVm(mainViewModel);
        mainViewModel.initView(mainBinding);

        setContentView(mainBinding.getRoot());
    }
}