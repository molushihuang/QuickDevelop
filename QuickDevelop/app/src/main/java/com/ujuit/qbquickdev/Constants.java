package com.ujuit.qbquickdev;

import com.anthole.quickdev.invoke.FileInvoke;

/**
 * Created by pherson on 2017-4-27.
 */

public class Constants {


    public static final class File {






        public static final String baseFolder = FileInvoke.getInstance().getAppDir().getPath();
        private static String locLogPath = baseFolder + "/log/";
        public static String screenShotsPath = baseFolder + "/ScreenShots/";
        public static String savePath = baseFolder + "/save/";
        public static final String shareDir = baseFolder + "/share/";
        public static final String tempPath = baseFolder + "/temp/";
        public static final String crashPath = baseFolder + "/crash/";

        public static String getSavePath(){
            String path = savePath;
            java.io.File file = new java.io.File(path);
            if(!file.exists()){
                file.mkdirs();
            }
            return path;
        }

        public static String getTempPath(){
            String path = tempPath;
            java.io.File file = new java.io.File(path);
            if(!file.exists()){
                file.mkdirs();
            }
            return path;
        }

        public static String getCrashPath() {
            String path = crashPath;
            java.io.File file = new java.io.File(path);
            if(!file.exists()){
                file.mkdirs();
            }
            return path;
        }
    }
}
