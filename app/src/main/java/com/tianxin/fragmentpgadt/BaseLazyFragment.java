package com.tianxin.fragmentpgadt;

import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 * 作者：created by meixi
 * 邮箱：15913707499@163.com
 * 日期：2019/5/31 17
 */

public abstract class BaseLazyFragment extends Fragment {
    private static final String TAG = BaseLazyFragment.class.getSimpleName();
    private boolean isPrepared;

    @Override

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initPrepare();
    }

    /**
     * 第一次onResume中的调用onUserVisible避免操作与onFirstUserVisible操作重复
     */
    private boolean isFirstResume = true;

    @Override

    public void onResume() {
        super.onResume();
        if (isFirstResume) {
            isFirstResume = false;
            return;
        }
        if (getUserVisibleHint()) {
            onUserVisible();
        }
    }

    @Override

    public void onPause() {
        super.onPause();
        if (getUserVisibleHint()) {
            onUserInvisible();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    private boolean isFirstVisible = true;
    private boolean isFirstInvisible = true;

    @Override

    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
//        LgqLogutil.i("显示===="+isVisibleToUser);
        if (isVisibleToUser) {
            if (isFirstVisible) {
                isFirstVisible = false;
                LgqLogutil.i("显示===="+isVisibleToUser);
                initPrepare();
            } else {
                onUserVisible();
            }
        } else {
            if (isFirstInvisible) {
                isFirstInvisible = false;
                LgqLogutil.i("显示===="+isVisibleToUser);
                onFirstUserInvisible();
            } else {
                onUserInvisible();
            }
        }
    }


    public synchronized void initPrepare() {
        if (isPrepared) {
            onFirstUserVisible();
        } else {
            isPrepared = true;
        }
    }

    /**
     * 第一次fragment可见（进行初始化工作）
     */
    public void onFirstUserVisible() {
    }

    /**
     * fragment可见（切换回来或者onResume）
     */
    public void onUserVisible() {
    }

    /**
     * 第一次fragment不可见（不建议在此处理事件）
     */
    public void onFirstUserInvisible() {
    }

    /**
     * fragment不可见（切换掉或者onPause）
     */
    public void onUserInvisible() {
    }

}

