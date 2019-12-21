package com.tianxin.fragmentpgadt;

/**
 * 作者：created by meixi
 * 邮箱：15913707499@163.com
 * 日期：2019/6/3 09
 */

import android.util.Log;

public class LgqLogutil {

    private static boolean ifShow=true;


    public static void setIfShow(boolean b){
        ifShow = b;
    }


    public static void i(String string){
        StackTraceElement[] s = Thread.currentThread().getStackTrace();
        String methodName = s[3].getMethodName();
        if (ifShow)
            Log.i("lgq",methodName+"----"+string);
    }

    public static void e(String string){
        StackTraceElement[] s = Thread.currentThread().getStackTrace();
        String methodName = s[3].getMethodName();
        if (ifShow)
            Log.e("lgq",methodName+"----"+string);
    }

}
