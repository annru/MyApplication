package com.example.myapplication.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.RadioGroup;

import com.example.myapplication.R;
import com.example.myapplication.base.BaseActivity;
import com.example.myapplication.fragment.Tab1Fragment;
import com.example.myapplication.fragment.Tab2Fragment;
import com.example.myapplication.fragment.Tab3Fragment;
import com.example.myapplication.fragment.Tab4Fragment;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MyTabActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener {

    @Bind(R.id.content_layout)
    FrameLayout contentLayout;

    @Bind(R.id.radio_group)
    RadioGroup radioGroup;

    private FragmentTransaction transaction;
    private Tab1Fragment tab1Fragment;
    private Tab2Fragment tab2Fragment;
    private Tab3Fragment tab3Fragment;
    private Tab4Fragment tab4Fragment;
    private Fragment currentFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_tab);
        ButterKnife.bind(this);
        init();
        radioGroup.setOnCheckedChangeListener(this);
    }

    private void init() {
        transaction = getSupportFragmentManager().beginTransaction();
        if (null == tab1Fragment) {
            tab1Fragment = new Tab1Fragment();
        }
        currentFragment = tab1Fragment;
        transaction.add(R.id.content_layout, tab1Fragment);
        transaction.commit();
    }


    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        transaction = getSupportFragmentManager().beginTransaction();
        transaction.hide(currentFragment);
        switch (checkedId) {
            case R.id.tab1_fragment_btn:

                if (null == tab1Fragment) {
                    tab1Fragment = new Tab1Fragment();
                    transaction.add(R.id.content_layout, tab1Fragment);
                } else {
                    transaction.show(tab1Fragment);
                }
//                transaction.addToBackStack(null);
                currentFragment = tab1Fragment;
                break;
            case R.id.tab2_fragment_btn:
//                transaction = getSupportFragmentManager().beginTransaction();
//                transaction.hide(currentFragment);
                if (null == tab2Fragment) {
                    tab2Fragment = new Tab2Fragment();
                    transaction.add(R.id.content_layout, tab2Fragment);
                } else {
                    transaction.show(tab2Fragment);
                }
//                transaction.commit();
                currentFragment = tab2Fragment;
                break;
            case R.id.tab3_fragment_btn:
//                transaction = getSupportFragmentManager().beginTransaction();
//                transaction.hide(currentFragment);
                if (null == tab3Fragment) {
                    tab3Fragment = new Tab3Fragment();
                    transaction.add(R.id.content_layout, tab3Fragment);
                } else {
                    transaction.show(tab3Fragment);
                }
//                transaction.commit();
//                transaction.addToBackStack(null);
                currentFragment = tab3Fragment;
                break;
            case R.id.tab4_fragment_btn:
//                transaction = getSupportFragmentManager().beginTransaction();
//                transaction.hide(currentFragment);
                if (null == tab4Fragment) {
                    tab4Fragment = new Tab4Fragment();
                    transaction.add(R.id.content_layout, tab4Fragment);
                } else {
                    transaction.show(tab4Fragment);
                }
//                transaction.commit();
                currentFragment = tab4Fragment;
                break;
        }
        transaction.commit();
    }
}
