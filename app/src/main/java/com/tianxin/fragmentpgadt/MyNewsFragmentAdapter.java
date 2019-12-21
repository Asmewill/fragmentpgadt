package com.tianxin.fragmentpgadt;

import android.graphics.Bitmap;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.view.ViewGroup;

import com.tianxin.fragmentpgadt.observes.Observer;
import com.tianxin.fragmentpgadt.observes.TestObServernotice;

import java.util.List;

/**
 * 作者：created by meixi
 * 邮箱：15913707499@163.com
 * 日期：2019/5/31 17
 */

public class MyNewsFragmentAdapter extends FragmentPagerAdapter {
    private List<String> titleList;
    boolean[] fragmentsUpdateFlag = { false, false, false, false };
    private FragmentManager fm;

    public MyNewsFragmentAdapter(FragmentManager fragmentManager, List<String> titleList) {
        super(fragmentManager);
        this.titleList = titleList;
        this.fm = fragmentManager;


        StringBuffer selectstring = new StringBuffer();
        for (int c = 0;c<titleList.size();c++){
            if (c==titleList.size()-1){
                selectstring.append(titleList.get(c));
            }else {
                selectstring.append(titleList.get(c)+",");
            }
        }
        String onetypes = selectstring.toString();
        TestObServernotice.getInstance().addObserver(deleteObserver);
//        MyShareUtil.sharedPstring("seletypes",onetypes);
    }
    private Observer deleteObserver = new Observer() {
        @Override
        public void update(int id, int intparam, String param, Bitmap bitmap, List<String> mmUserList) {
            if (id==111){
//                titleList = mmUserList;
                LgqLogutil.i("efr23fr3f23==333"+titleList.size());
//                notifyDataSetChanged();
            }
        }
    };

    public void upd (){
        notifyDataSetChanged();
    }



    @Override
    public Fragment getItem(int position) {
        return FragmentTwoOne.newInstance(titleList.get(position));
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        //得到缓存的fragment
        Fragment fragment = (Fragment) super.instantiateItem(container,
                position);
        //得到tag，这点很重要
        String fragmentTag = fragment.getTag();

        //如果这个fragment需要更新

        FragmentTransaction ft = fm.beginTransaction();
        //移除旧的fragment
        ft.remove(fragment);
        //换成新的fragment
        fragment = FragmentTwoOne.newInstance(titleList.get(position));

        //添加新fragment时必须用前面获得的tag，这点很重要
        ft.add(container.getId(), fragment, fragmentTag);
        ft.attach(fragment);
        ft.commit();

        return fragment;
    }

    @Override
    public int getCount() {
        return titleList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titleList.get(position);
    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }
}
