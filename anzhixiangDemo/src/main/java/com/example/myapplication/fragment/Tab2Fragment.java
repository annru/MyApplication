package com.example.myapplication.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import com.example.myapplication.R;

import butterknife.Bind;
import butterknife.ButterKnife;


public class Tab2Fragment extends Fragment implements RadioGroup.OnCheckedChangeListener {
    private static final String TAG = "Tab2Fragment";

    private FragmentTransaction transaction;
    private ProductFragment productFragment;
    private OrgFragment orgFragment;
    private Fragment currentFragment;

    @Bind(R.id.product_radio_group)
    RadioGroup radioGroup;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate");
        init();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.i(TAG, "onCreateView");
        View view = inflater.inflate(R.layout.fragment_tab2, container, false);
        ButterKnife.bind(this, view);
        radioGroup.setOnCheckedChangeListener(this);
        return view;
    }

    private void init() {
        if (null == productFragment)
            productFragment = new ProductFragment();
        transaction = getChildFragmentManager().beginTransaction();
        transaction.add(R.id.product_content_layout, productFragment);
        transaction.commit();
        currentFragment = productFragment;
    }


    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        transaction = getChildFragmentManager().beginTransaction();
        transaction.hide(currentFragment);
        switch (checkedId) {
            case R.id.product_btn:
                if (null == productFragment) {
                    productFragment = new ProductFragment();
                    transaction.add(R.id.product_content_layout, productFragment);
                } else {
                    transaction.show(productFragment);
                }
                currentFragment = productFragment;

                break;
            case R.id.org_btn:
                if (null == orgFragment) {
                    orgFragment = new OrgFragment();
                    transaction.add(R.id.product_content_layout, orgFragment);
                } else {
                    transaction.show(orgFragment);
                }
                currentFragment = orgFragment;
                break;
        }
        transaction.commit();
    }
}
