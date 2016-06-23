package com.example.myapplication.activity.gesture;

import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.base.BaseActivity;

/**
 * 设置手势密码
 */
public class SetGesturePwdActivity extends BaseActivity {

    /**
     * 手机号码
     */
//    public static final String PARAM_PHONE_NUMBER = "PARAM_PHONE_NUMBER";
    /**
     * 意图
     */
//    public static final String PARAM_INTENT_CODE = "PARAM_INTENT_CODE";
    /**
     * 首次提示绘制手势密码，可以选择跳过
     */
//    public static final String PARAM_IS_FIRST_ADVICE = "PARAM_IS_FIRST_ADVICE";
    private TextView mTextTitle;
    private LockIndicator mLockIndicator;
    private TextView mTextTip;
    //    private FrameLayout mGestureContainer;
    private GestureContentView mGestureContentView;
    private boolean mIsFirstInput = true;
    private String mFirstPassword = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_gesture_pwd);
        setUpViews();
        setSize();
    }

    private void setUpViews() {
        mTextTitle = (TextView) findViewById(R.id.text_title);

        mLockIndicator = (LockIndicator) findViewById(R.id.lock_indicator);
        mTextTip = (TextView) findViewById(R.id.text_tip);
        FrameLayout gestureContainer = (FrameLayout) findViewById(R.id.gesture_container);
        // 初始化一个显示各个点的viewGroup
        mGestureContentView = new GestureContentView(this, false, "",
                new GestureDrawline.GestureCallBack() {
                    @Override
                    public void onGestureCodeInput(String inputCode) {
                        if (!isInputPassValidate(inputCode)) {
                            mTextTip.setText(Html
                                    .fromHtml("<font color='#c70c1e'>最少连接4个点, 请重新输入</font>"));
                            mGestureContentView.clearDrawlineState(0L);
                            return;
                        }
                        if (mIsFirstInput) {
                            mTextTip.setText("请再次输入");
                            mFirstPassword = inputCode;
                            updateCodeList(inputCode);
                            mGestureContentView.clearDrawlineState(0L);
                        } else {
                            if (inputCode.equals(mFirstPassword)) {
                                Toast.makeText(SetGesturePwdActivity.this, "设置成功", Toast.LENGTH_SHORT).show();
                                mGestureContentView.clearDrawlineState(0L);
                                finish();

                            } else {
                                mTextTip.setText(Html
                                        .fromHtml("<font color='#c70c1e'>与第一次绘制不一致，请重新绘制</font>"));
                                // 左右移动动画
                                Animation shakeAnimation = AnimationUtils
                                        .loadAnimation(
                                                SetGesturePwdActivity.this,
                                                R.anim.shake);
                                mTextTip.startAnimation(shakeAnimation);
                                // // 保持绘制的线
                                // mGestureContentView.clearDrawlines();
                                mIsFirstInput = true;
                                updateCodeList("");
                                return;
                            }
                        }
                        mIsFirstInput = false;
                    }

                    @Override
                    public void checkedSuccess() {

                    }

                    @Override
                    public void checkedFail(String pass) {

                    }
                });
        // 设置手势解锁显示到哪个布局里面
        mGestureContentView.setParentView(gestureContainer);
        updateCodeList("");
    }

    private void updateCodeList(String inputCode) {
        // 更新选择的图案
        mGestureContentView.clearDrawlineState(0L);
        mLockIndicator.setPath(inputCode);
    }

    private boolean isInputPassValidate(String inputPassword) {
        if (TextUtils.isEmpty(inputPassword) || inputPassword.length() < 4) {
            return false;
        }
        return true;
    }

    /**
     * 设置字体大小
     */
    private void setSize() {
//        int width = ScreenUtil.getScreenWidth(this);
//        mTextTitle.setTextSize(DensityUtils.px2dp(this, width / 15));
//        mTextTip.setTextSize(DensityUtils.px2dp(this, width / 25));
    }
}
