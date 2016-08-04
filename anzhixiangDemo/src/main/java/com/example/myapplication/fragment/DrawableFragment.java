package com.example.myapplication.fragment;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.myapplication.R;
import com.example.myapplication.base.BaseFragment;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by 00224524 on 2016/8/3.
 * 描述：
 */
public class DrawableFragment extends BaseFragment {

    @Bind(R.id.drawable_btn)
    ImageButton drawableBtn;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_drawable, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick(R.id.drawable_btn)
    public void setOnClick() {
        final Drawable drawable = ContextCompat.getDrawable(getActivity(), R.drawable.ic_3d_rotation).mutate();
        drawableBtn.setImageDrawable(tintDrawable(drawable, ContextCompat.getColorStateList(getActivity(), R.color.selector_drawable)));
    }

    public Drawable tintDrawable(Drawable drawable, ColorStateList color) {
        final Drawable tempDrawable = DrawableCompat.wrap(drawable);
        DrawableCompat.setTintList(tempDrawable, color);
        return tempDrawable;
    }
}
