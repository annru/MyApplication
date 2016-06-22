package com.example.myapplication.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.myapplication.R;
import com.example.myapplication.base.BaseActivity;
import com.example.myapplication.fragment.GuideViewFragment;
import com.example.myapplication.fragment.MainFragment;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnItemClick;

public class DrawerLayoutActivity extends BaseActivity implements AdapterView.OnItemClickListener {

    @Bind(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    @Bind(R.id.drawer_listview)
    ListView listView;

    private FragmentManager mFragmentManager;
    private GuideViewFragment guideViewFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer_layout);
        ButterKnife.bind(this);
        listView.setAdapter(new ArrayAdapter<>(this, R.layout.drawer_list_item, getResources()
                .getStringArray(R.array.drawer_item)));
        initFragment();
    }

    private void initFragment() {
        MainFragment mainFragment = new MainFragment();
        mFragmentManager = getSupportFragmentManager();
        mFragmentManager.beginTransaction().add(R.id.content_layout, mainFragment).commit();
    }

    @OnItemClick(R.id.drawer_listview)
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        drawerLayout.closeDrawers();
        switch (position) {
            case 0:
                if (null == guideViewFragment) {
                    guideViewFragment = new GuideViewFragment();
                    mFragmentManager.beginTransaction().add(R.id.content_layout, guideViewFragment)
                            .commit();
                } else {
                    mFragmentManager.beginTransaction().replace(R.id.content_layout,
                            guideViewFragment)
                            .commit();
                }
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }
}
