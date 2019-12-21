package com.tianxin.fragmentpgadt.observes;

import android.graphics.Bitmap;

import java.util.List;

/**
 * 作者：created by meixi
 * 邮箱：15913707499@163.com
 * 日期：2019/6/3 14
 */

public interface Observer {

    void update(int id, int intparameter, String string, Bitmap bitmap,List<String> mUserList);
}