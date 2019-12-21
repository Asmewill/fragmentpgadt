package com.tianxin.fragmentpgadt;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.ColorInt;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * 作者：created by meixi
 * 邮箱：15913707499@163.com
 * 日期：2019/5/31 17
 */

public abstract class BaseFragment extends Fragment {

    private static int nOpeningSecondCount = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View contentView = inflater.inflate(getViewLayout(), container, false);
        return contentView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(savedInstanceState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
//        QuicklyBackNotice.getInstance().addObserver(quicklyBackObserver);
        nOpeningSecondCount++;

        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onDetach() {
//        QuicklyBackNotice.getInstance().removeObserver(quicklyBackObserver);
        nOpeningSecondCount--;
        if (nOpeningSecondCount < 0)
            nOpeningSecondCount = 0;
        super.onDetach();
    }

    /**
     * @return 布局resourceId
     */
    public abstract int getViewLayout();

    /**
     * 从intent获取数据，初始化View。或者其他view级第三方控件的初始化,及相关点击事件的绑定
     *
     * @param savedInstanceState
     */
    protected abstract void initView(Bundle savedInstanceState);

    @Override
    public void onDestroy() {
        super.onDestroy();

    }

    @Override
    public void onResume() {
        super.onResume();
        //注：回调 1
    }

    @Override
    public void onPause() {
        super.onPause();
        //注：回调 2
    }
    protected void setStatusBar(@ColorInt int color) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getActivity().getWindow().setStatusBarColor(color);
        }

    }
}
