package com.ujuit.qbquickdev.activity.base;

import android.content.Context;
import android.os.Build;
import android.support.multidex.MultiDex;
import android.util.Log;
import com.anthole.quickdev.CrashHandler;
import com.anthole.quickdev.QApplication;
import com.anthole.quickdev.commonUtils.TimeUtils;
import com.google.gson.Gson;
import com.ujuit.qbquickdev.Constants;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

/**
 * Created by UJU105 on 2016/6/2.
 */
public class BaseApplication extends QApplication {

    public static Context applicationContext;
    private static BaseApplication instance;

    public static BaseApplication getInstance() {
        return instance;
    }
    @Override
    public void onCreate() {
        super.onCreate();

        Log.e("手机信息++MANUFACTURER", Build.MANUFACTURER);
        Log.e("手机信息++BOARD", Build.BOARD);
        Log.e("手机信息++BRAND", Build.BRAND);
        Log.e("手机信息++PRODUCT", Build.PRODUCT);

        applicationContext = this;
        instance = this;
        MultiDex.install(this);//64k问题处理，谷歌的方法

        //崩溃处理
//        CrashHandler.getInstance().init(this, new OnCrashListener() {
//
//            @Override
//            public void onCrash(CrashHandler.QCrashBean crashBean) {
//
//                try {
//                    saveCrashInfo(crashBean);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//                //崩溃后跳转到主actitity
//                QAppManager.getAppManager().finishAllActivity();
//                Intent intent = new Intent(BaseApplication.this, MainActivity.class);
//                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                startActivity(intent);
//            }
//        });


    }

    //将崩溃日志保存在本地
    private void saveCrashInfo(CrashHandler.QCrashBean crashBean) throws IOException {
        HashMap<String, String> map = new HashMap<>();
        map.put("operationTime", System.currentTimeMillis() + "");
        map.put("content", crashBean.getExceptionInfo());
        map.put("version", crashBean.getVersionName());
        map.put("brand", crashBean.getBrand());
        map.put("system", "android " + crashBean.getSdkVersion());
        map.put("build", crashBean.getVersionCode());
        map.put("model", crashBean.getModel());
        map.put("operationIp", crashBean.getIp());

        String json = new Gson().toJson(map);
        String path = Constants.File.getCrashPath();
        String fileName = "crash-" + TimeUtils.getTime(System.currentTimeMillis(), "yyyy-MM-dd-HH-mm-ss") + "-" + System.currentTimeMillis() + ".log";
        FileOutputStream fos = new FileOutputStream(path + fileName);
        fos.write(json.getBytes());
        fos.close();
    }

    @Override
    public String getAppDir() {
        return "appName";
    }


}
