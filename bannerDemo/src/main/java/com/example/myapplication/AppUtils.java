package com.example.myapplication;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import java.util.Random;

/**
 * 跟App相关的辅助类
 *
 * @author lj
 */
public class AppUtils {
    private final static String TAG = "AppUtils";
    //    private static String macAddress;
//    private static boolean isShowFlag = false;

    private AppUtils() {
        /* cannot be instantiated */
        throw new UnsupportedOperationException("cannot be instantiated");

    }

    /**
     * 判断sim卡是否可用
     *
     * @param context 上下文
     * @return true为可以拨打, false为不可拨打
     */
    public static boolean isCanUseSim(Context context) {
        try {
            TelephonyManager mgr = (TelephonyManager) context
                    .getSystemService(Context.TELEPHONY_SERVICE);

            return TelephonyManager.SIM_STATE_READY == mgr.getSimState();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


    public static boolean isNetWorkAvailable(Context context) {
        if (!isNetWorkStatus(context)) {
            Log.e(TAG, "executeUrl : network not available");
            return false;
        }
        return true;
    }

    private static boolean isNetWorkStatus(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = connectivityManager.getActiveNetworkInfo();
        return info != null && info.isConnected();
    }

    /**
     * 获取当前的系统时间,格式为（yyyy-MM-dd HH:mm:ss）
     */
    public static String getCurrentDateTime(String formatStr) {
        long time = System.currentTimeMillis();
        SimpleDateFormat format = new SimpleDateFormat(formatStr, Locale.CHINA);// "yyyyMMddhhmmsss"
        return format.format(time);
    }

    /**
     * 生成5位数的随机数
     */
    public static String createFiveDigitRandom() {
        Random random = new Random();
        int num = (int) (random.nextDouble() * (100000 - 10000) + 10000);
        return String.valueOf(num);
    }

    /**
     * 判断一个程序是否显示在前端,根据测试此方法执行效率在11毫秒,无需担心此方法的执行效率
     *
     * @param context 上下文环境
     * @return true--->在前端,false--->不在前端
     */
    public static boolean isAppOnForeground(Context context) {
        ActivityManager activityManager = (ActivityManager) context
                .getSystemService(Context.ACTIVITY_SERVICE);
        String packageName = context.getPackageName();

        List<RunningAppProcessInfo> appProcesses = activityManager
                .getRunningAppProcesses();
        if (appProcesses == null)
            return false;

        for (RunningAppProcessInfo appProcess : appProcesses) {
            if (appProcess.processName.equals(packageName)
                    && appProcess.importance == RunningAppProcessInfo.IMPORTANCE_FOREGROUND) {
                return true;
            }
        }
        return false;
    }


    /**
     * 获取application中指定的meta-data
     *
     * @return 如果没有获取成功(没有对应值, 或者异常)，则返回值为""
     */
    public static String getAppMetaData(Context ctx, String key) {
        if (ctx == null || TextUtils.isEmpty(key)) {
            return "";
        }
        String resultData = "";
        try {
            PackageManager packageManager = ctx.getPackageManager();
            if (packageManager != null) {
                ApplicationInfo applicationInfo = packageManager.getApplicationInfo(ctx.getPackageName(),
                        PackageManager.GET_META_DATA);
                if (applicationInfo != null) {
                    if (applicationInfo.metaData != null) {
                        Object value = applicationInfo.metaData.get(key);
                        if (value != null) {
                            return value.toString();
                        }
                    }
                }
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return resultData;
    }


    /**
     * 根据银行编码判断显示图片
     *
     * @param bankCode 银行代码
     * @return int
     */


    /**
     * 设置状态栏颜色
     * 备注：需要在Activity所加载的布局文件的根布局加上android:fitsSystemWindows="true"
     */

    public static void setStatusBarColor(Activity activity, int color) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            setTranslucentStatus(true, activity);
//            setTitleViewPadding(activity);
        }
        SystemBarTintManager tintManager = new SystemBarTintManager(activity);
        tintManager.setStatusBarTintEnabled(true);
        tintManager.setStatusBarTintResource(color);
        setStatusBarTranslucent(activity);//此方法为新增
    }

    /**
     * 设置状态栏透明
     *
     * @param activity Activity实例
     */
    private static void setStatusBarTranslucent(Activity activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {//5.0
            Window window = activity.getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.getDecorView()
                    .setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {//4.4
            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
    }

//    private static void setTitleViewPadding(Activity activity) {
//        View view = activity.findViewById(R.id.title_bar);
//        if (view != null) {
//            int statusBarHeight = ScreenUtils.getStatusBarHeight(activity.getBaseContext());
//            view.setPadding(0, statusBarHeight, 0, 0);
//        }
//    }

    @TargetApi(19)
    private static void setTranslucentStatus(boolean on, Activity activity) {
        Window win = activity.getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();
        final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
        if (on) {
            winParams.flags |= bits;
        } else {
            winParams.flags &= ~bits;
        }
        win.setAttributes(winParams);
    }

    public static boolean checkApkExist(Context context, String packageName) {
        if (packageName == null || "".equals(packageName)) {
            return false;
        }
        try {
            ApplicationInfo info = context.getPackageManager()
                    .getApplicationInfo(packageName, PackageManager.GET_UNINSTALLED_PACKAGES);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }

    public static void copyText(Context context, String text) {
        ClipboardManager clipboard = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData data = ClipData.newPlainText("text", text);
        clipboard.setPrimaryClip(data);
    }

    /**
     * 获取设备deviceId
     */
    public static String getDeviceId(Context context) {
        TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        return tm.getDeviceId();
    }
}
