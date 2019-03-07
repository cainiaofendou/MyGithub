package com.example.mygithub.app;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.example.mygithub.dao.DaoMaster;
import com.example.mygithub.dao.DaoSession;


public class MyApplication extends Application {
    private static MyApplication instance;
    private DaoSession mDaoSession;
    @Override
    public void onCreate() {
        super.onCreate();
        //初始化数据库
        initGreenDao();
        instance =this;

    }

    private void initGreenDao() {
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(this, Constants.DB_NAME);
        SQLiteDatabase database = devOpenHelper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(database);
        mDaoSession = daoMaster.newSession();
    }

    public  static synchronized   MyApplication getInstance(){
        return  instance;
    }

    public DaoSession getDaoSession() {
        return mDaoSession;
    }
}
