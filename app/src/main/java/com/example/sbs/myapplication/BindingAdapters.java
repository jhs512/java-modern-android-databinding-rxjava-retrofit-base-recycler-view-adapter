package com.example.sbs.myapplication;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;
import androidx.databinding.BindingConversion;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;

import java.util.List;

public class BindingAdapters {
    @BindingConversion
    public static ColorDrawable convertLvColorToDrawable(MutableLiveData<Integer> color) {
        if (color == null) {
            return null;
        }

        return new ColorDrawable(color.getValue());
    }

    @BindingAdapter({"imageUrl"})
    public static void loadImage(ImageView imageView, String imageUrl) {
        loadImage(imageView, imageUrl, 0);
    }

    @BindingAdapter({"imageUrl", "borderRadius"})
    public static void loadImage(ImageView imageView, String imageUrl, int borderRadius) {
        RequestBuilder<Drawable> rb = Glide.with(imageView.getContext())
                .load(imageUrl)
                .diskCacheStrategy(DiskCacheStrategy.RESOURCE);

        if (borderRadius > 0) {
            rb.transform(new CenterCrop(), new RoundedCorners((int) MyApplication.dipToPixels(borderRadius)));
        }

        rb.placeholder(R.color.black).into(imageView);
    }

    @BindingAdapter({"isVisible"})
    public static void setVisibility(ImageView imageView, boolean isVisible) {
        imageView.setVisibility(isVisible ? View.VISIBLE : View.GONE);
    }

    @BindingAdapter({"items"})
    public static void notifyAdapter(RecyclerView recyclerView, List items) {
        Log.d("AA1", "실행됨");
        BaseRecyclerViewAdapter adapter = (BaseRecyclerViewAdapter) recyclerView.getAdapter();
        adapter.setItems(items);
    }
}
