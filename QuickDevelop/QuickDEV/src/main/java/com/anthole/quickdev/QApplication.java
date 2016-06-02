package com.anthole.quickdev;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.lang.reflect.Field;

import android.app.Application;
import android.content.pm.ApplicationInfo;
import android.os.Build;

import com.anthole.quickdev.invoke.FileInvoke;

import dalvik.system.DexClassLoader;

public abstract class QApplication extends Application{
	
	private static QApplication application;
	
	@Override
	public void onCreate() {
		super.onCreate();
		
		application = this;
		FileInvoke.getInstance().init(this, getAppDir());

	}
	
	/**
	 * 获取Application
	 * 
	 * @return
	 */
	public static QApplication getApplication()
	{
		return application;
	}
	
	/**
	 * 配置  app dir 如 qiugou
	 * @return
	 */
	public abstract String getAppDir();

}
