package zendaimoney.myapplication;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import zendaimoney.myapplication.gen.DaoMaster;
import zendaimoney.myapplication.gen.DaoSession;

/**
 * Created by 00224524 on 2017/6/9.
 * description:
 */


public class MyApplication extends Application {
    public static MyApplication instance;
    private DaoMaster.DevOpenHelper mHelper;
    private SQLiteDatabase db;
    private DaoMaster mDaoMaster;
    private DaoSession mDaoSession;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        setDataBase();
    }

    public static MyApplication getInstance() {
        return instance;
    }

    private void setDataBase() {
        mHelper = new DaoMaster.DevOpenHelper(this, "notes-db", null);
        db = mHelper.getWritableDatabase();
        mDaoMaster = new DaoMaster(db);
        mDaoSession = mDaoMaster.newSession();
    }

    public DaoSession getDaoSession() {
        return mDaoSession;
    }

    public SQLiteDatabase getDb() {
        return db;
    }
}
