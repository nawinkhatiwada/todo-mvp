package com.nawin.todo_mvp.utils;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.nawin.todo_mvp.R;

import static android.text.TextUtils.isEmpty;

/**
 * Created by brain on 1/5/17.
 */

public class MvpBindings {

    @BindingAdapter("imageUrl")
    public static void setImageUrl(ImageView imageView, String url) {
        if (!isEmpty(url))
            Glide.with(imageView.getContext()).load(url).error(R.drawable.ic_launcher).into(imageView);
    }
}
