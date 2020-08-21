package com.example.objectbox;

import android.app.Application;

/**
 * Application
 *
 * @author wangshy
 * @date 2020/08/19
 */
public class BaseApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        //在Application里初始化ObjectBox
        ObjectBox.init(this);
    }
}
