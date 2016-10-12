package com.cniao5.cniaoPlay.common;

import android.app.Application;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by mcdull on 16/6/3.
 * 应用程序主类
 */
public class AppApplication extends Application {

    private static AppApplication appContext;

    @Override
    public void onCreate() {
        super.onCreate();
        appContext = this;
        Fresco.initialize(this);
    }


    public static AppApplication getAppContext() {
        if (appContext == null) {
            appContext = new AppApplication();
        }
        return appContext;
    }


    /**
     * 获取当前版本信息
     *
     * @return
     */
    public String getVersion() {
        try {
            PackageManager manager = this.getPackageManager();
            PackageInfo info = manager.getPackageInfo(this.getPackageName(), 0);
            String version = info.versionName;
            return "V  " + version;
        } catch (Exception e) {
            e.printStackTrace();
            return "未知";
        }
    }
}
