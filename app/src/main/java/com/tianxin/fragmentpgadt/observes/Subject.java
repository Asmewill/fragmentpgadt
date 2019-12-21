package com.tianxin.fragmentpgadt.observes;

import android.graphics.Bitmap;

import java.util.List;

/**
 * 作者：created by meixi
 * 邮箱：15913707499@163.com
 * 日期：2019/6/3 14
 */

public interface Subject {

    /**
     * 注册一个观察者
     */
    void addObserver(Observer observer);

    /**
     * 删除一个观察者
     *
     * @return 是否删除成功
     */
    boolean removeObserver(Observer observer);

    /**
     * 通知所有的观察者
     *
     * @param id 对应观察者的id
     */
    void notifyObserver(int id,int intparameter,String s,Bitmap bitmap,List<String> mUserList);

}
