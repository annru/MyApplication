package zendaimoney.mylibrary;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by 00224524 on 2017/3/22.
 * description:测试上传开源项目到JCenter
 */

public class Test {
    private Context mContext;

    public Test(Context context) {
        this.mContext = context;
    }

    public void testJCenter() {
        Toast.makeText(mContext, "测试上传开源项目到JCenter", Toast.LENGTH_LONG).show();
    }
}
