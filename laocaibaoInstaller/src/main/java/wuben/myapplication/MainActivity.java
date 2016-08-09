package wuben.myapplication;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    private static final String PACKAGE_NAME = "com.onlinecredit.laomoney.android";

    @Bind(R.id.installed_rl)
    RelativeLayout installedRl;

    @Bind(R.id.uninstalled_ll)
    LinearLayout uninstalledLl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }

    @Override
    protected void onResume() {
        super.onResume();
        updateInstallStatus();
    }

    @OnClick({R.id.update_btn, R.id.install_btn})
    public void setOnClick(View view) {
        switch (view.getId()) {
            case R.id.update_btn:
                if (isInstallLaocaibao()) {
                    Intent intent = getPackageManager().getLaunchIntentForPackage(PACKAGE_NAME);
                    startActivity(intent);
                } else {
                    //update
                }
                break;
            case R.id.install_btn:
                break;
        }
    }


    private boolean isInstallLaocaibao() {
        PackageInfo packageInfo;
        try {
            packageInfo = this.getPackageManager().getPackageInfo(PACKAGE_NAME, 0);
        } catch (PackageManager.NameNotFoundException e) {
            packageInfo = null;
            e.printStackTrace();
        }
        return packageInfo != null;
    }

    private void updateInstallStatus() {
        if (isInstallLaocaibao()) {
            installedRl.setVisibility(View.VISIBLE);
            uninstalledLl.setVisibility(View.GONE);
        } else {
            uninstalledLl.setVisibility(View.VISIBLE);
            installedRl.setVisibility(View.GONE);
        }
    }
}
