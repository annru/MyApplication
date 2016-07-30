package com.example.myapplication.activity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.base.BaseActivity;
import com.example.myapplication.mvp2.LoginPresenter;
import com.example.myapplication.mvp2.LoginPresenterImpl;
import com.example.myapplication.mvp2.LoginView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * mvp架构模式模拟登录功能的实现
 * 参考流程；
 * 1 Activity做了一些UI初始化的东西并需要实例化对应LoginPresenter的引用和实现 LoginView的接口，监听界面动作
 * 2 登陆按钮按下后即接收到登陆的事件，在onClick里接收到即通过LoginPresenter的引用把它交给LoginPresenter处理。LoginPresenter接收到了登陆的逻辑就知道要登陆了
 * 3 然后LoginPresenter显示进度条并且把逻辑交给我们的Model去处理，也就是这里面的LoginModel，（LoginModel的实现类LoginModelImpl），同时会把OnLoginFinishedListener也就是LoginPresenter自身传递给我们的Model（LoginModel）。
 * 4 LoginModel处理完逻辑之后，结果通过OnLoginFinishedListener回调通知LoginPresenter
 * 5 LoginPresenter再把结果返回给view层的Activity，最后activity显示结果
 */

public class LoginActivity extends BaseActivity implements LoginView {


    @Bind(R.id.username_edit)
    EditText usernameEdit;

    @Bind(R.id.password_edit)
    EditText passwordEdit;

    private LoginPresenter presenter;
    private ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        presenter = new LoginPresenterImpl(this);
    }

    @OnClick(R.id.login_btn)
    public void setOnClickEvent() {
        presenter.validateCredentials(usernameEdit.getText().toString().trim(), passwordEdit.getText().toString().trim());
    }

    @Override
    public void showProgress() {
        loadingDialog();
    }

    @Override
    public void hideProgress() {
        if (progressDialog != null && progressDialog.isShowing())
            progressDialog.dismiss();
    }

    @Override
    public void setUsernameError() {
        loginErrorAlert("用户名错误");
    }

    @Override
    public void setPasswordError() {
        loginErrorAlert("密码错误");
    }

    @Override
    public void navigateToHome() {
        if (progressDialog != null && progressDialog.isShowing())
            progressDialog.dismiss();
        Toast.makeText(this, "登录成功", Toast.LENGTH_LONG).show();
    }

    private void loadingDialog() {
        if (progressDialog == null)
            progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("正在加载...");
        if (!progressDialog.isShowing())
            progressDialog.show();
    }


    private void loginErrorAlert(String msg) {
        AlertDialog alertDialog = new AlertDialog.Builder(this).setPositiveButton("知道了", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        }).create();
        alertDialog.setMessage(msg);
        alertDialog.show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }
}
