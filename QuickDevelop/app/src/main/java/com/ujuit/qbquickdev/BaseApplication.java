package com.ujuit.qbquickdev;

import android.app.Application;
import android.support.multidex.MultiDex;

/**
 * Created by UJU105 on 2016/6/2.
 */
public class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        MultiDex.install(this);
    }
}
