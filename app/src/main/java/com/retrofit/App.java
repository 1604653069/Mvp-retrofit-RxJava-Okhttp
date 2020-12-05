package com.retrofit;

import android.app.Application;

import com.retrofit.utils.CrashHandler;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        CrashHandler crashHandler = CrashHandler.getInstance();
        // 注册crashHandler
        crashHandler.init(getApplicationContext());
    }
}
