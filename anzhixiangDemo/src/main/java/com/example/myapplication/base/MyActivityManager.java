package com.example.myapplication.base;

import android.app.Activity;
import android.util.Log;

import java.util.Stack;

/**
 * Created by 00224524 on 2016/7/28.
 * 描述：activity管理类
 */
public class MyActivityManager {
    private static MyActivityManager instance;
    private static Stack<Activity> activityStack;

    public static MyActivityManager getInstance() {
        if (null == instance) {
            instance = new MyActivityManager();
        }
        return instance;
    }

    //添加一个Activity
    public void addActivity(Activity activity) {
        if (activityStack == null) {
            activityStack = new Stack<>();
        }
        activityStack.add(activity);
    }

    //移除一个Activity
    public void removeActivity(Activity activity) {
        if (activityStack != null && activityStack.size() > 0) {
            if (activity != null) {
                activity.finish();
                activityStack.remove(activity);
            }
        }
    }

    //获取栈顶的activity，先进后出原则
    public Activity getLastActivity() {
        return activityStack.lastElement();
    }

    //退出所有Activity
    public void finishAllActivity() {
        if (activityStack != null) {
            while (activityStack.size() > 0) {
                Activity activity = getLastActivity();
                if (activity == null) break;
                removeActivity(activity);
            }
        }
    }

    public void testPrintln() {
        Log.i("数量", activityStack.size() + "");
        for (int i = 0; i < activityStack.size(); i++) {
            System.out.println("第" + i + "个" + activityStack.get(i).getLocalClassName());
        }
    }
}
