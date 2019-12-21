package com.tianxin.fragmentpgadt.observes;

import android.graphics.Bitmap;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：created by meixi
 * 邮箱：15913707499@163.com
 * 日期：2019/6/3 14
 */

public class TestObServernotice implements Subject {

    private static Subject subject;
    private List<Observer> observers = new ArrayList<>();

    private TestObServernotice() {
        // TODO Auto-generated constructor stub
    }

    public static Subject getInstance() {
        if (null == subject) {
            synchronized (TestObServernotice.class) {
                if (null == subject)
                    subject = new TestObServernotice();
            }
        }
        return subject;
    }

    @Override
    public void addObserver(Observer observer) {
        // TODO Auto-generated method stub
        observers.add(observer);
    }

    @Override
    public boolean removeObserver(Observer observer) {
        // TODO Auto-generated method stub
        return observers.remove(observer);
    }

    @Override
    public void notifyObserver(int id, int intparam, String param, Bitmap bitmap,List<String> mUserList) {
        // TODO Auto-generated method stub
        for (Observer observer : observers) {
            observer.update(id,intparam,param,bitmap,mUserList);
        }
    }
}
