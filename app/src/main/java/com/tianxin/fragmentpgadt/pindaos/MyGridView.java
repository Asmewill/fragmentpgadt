package com.tianxin.fragmentpgadt.pindaos;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * 作者：created by meixi
 * 邮箱：15913707499@163.com
 * 日期：2019/6/3 14
 */
public class MyGridView extends GridView {
    public MyGridView(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
    }

    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
                MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}