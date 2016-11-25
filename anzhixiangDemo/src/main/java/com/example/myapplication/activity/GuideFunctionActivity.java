package com.example.myapplication.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.base.BaseActivity;

import net.frederico.showtipsview.ShowTipsBuilder;
import net.frederico.showtipsview.ShowTipsView;
import net.frederico.showtipsview.ShowTipsViewInterface;

import butterknife.Bind;
import butterknife.ButterKnife;

public class GuideFunctionActivity extends BaseActivity {

    @Bind(R.id.guide_test_btn)
    Button guideTestBtn;

    @Bind(R.id.guide_test2_btn)
    Button guideTest2Btn;


    @Bind(R.id.guide_test3_btn)
    Button guideTest3Btn;

    private static final String SHOWCASE_ID = "500";
    private static final int withDelay = 500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide_function);
        ButterKnife.bind(this);
//        presentShowcaseSequence(); // one second delay
        showCaseViewTips(guideTestBtn);
    }


    private void showCaseViewTips(final View targetView) {
        ShowTipsView showtips = new ShowTipsBuilder(this)
                .setTarget(targetView)
                .setTitle("A magnific button")
                .setDescription("This button do nothing so good")
                .setDelay(1000)
                .build();

        showtips.show(this);
        showtips.setCallback(new ShowTipsViewInterface() {
            @Override
            public void gotItClicked() {
                if (targetView == guideTestBtn) {
                    showCaseViewTips(guideTest2Btn);
                } else if (targetView == guideTest2Btn) {
                    showCaseViewTips(guideTest3Btn);
                }
            }
        });


        Toast.makeText(this, R.string.test,Toast.LENGTH_LONG).show();

    }
}
