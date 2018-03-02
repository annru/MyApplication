package com.example.myapplication;

import android.content.Context;

import com.example.myapplication.databinding.ListItemBinding;

/**
 * Created on 2017/12/27.
 *
 * @author 00224524
 */

public class PeopleAdapter extends BaseBindingAdapter<People, ListItemBinding> {

    public PeopleAdapter(Context context) {
        super(context);
    }

    @Override
    protected int getLayoutResId(int viewType) {
        return R.layout.list_item;
    }

    @Override
    protected void onBindItem(ListItemBinding binding, People item) {
        binding.setPeople(item);
        binding.executePendingBindings();
    }
}
