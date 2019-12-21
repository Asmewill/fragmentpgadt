package com.tianxin.fragmentpgadt;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.tianxin.fragmentpgadt.observes.Observer;
import com.tianxin.fragmentpgadt.observes.TestObServernotice;
import com.tianxin.fragmentpgadt.pindaos.PindaoActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：created by meixi
 * 邮箱：15913707499@163.com
 * 日期：2019/5/31 17
 */
public class NewsFragment extends BaseFragment {

    TabLayout fragmentATablayout;
    NoAnimationViewPager fragmentAViewPager;
    LinearLayout linearLayout;

    private MyNewsFragmentAdapter adapter;
    private List<String> mUserList = new ArrayList<>();

    private boolean ifnew=false;
    private int po;

    @Override
    public int getViewLayout() {
        return R.layout.fragment_news;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View contentView = inflater.inflate(getViewLayout(), container, false);
        fragmentATablayout = (TabLayout)contentView.findViewById(R.id.fragment_a_tablayout);
        fragmentAViewPager = (NoAnimationViewPager)contentView.findViewById(R.id.fragment_a_viewPager);
        linearLayout =(LinearLayout)contentView.findViewById(R.id.activity_two_image);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startActivity(new Intent(getContext(), PindaoActivity.class));

                Intent intent = new Intent(getActivity(), PindaoActivity.class);

                startActivityForResult(intent, 2011);
            }
        });
        TestObServernotice.getInstance().addObserver(deleteObserver);
        return contentView;

    }

    private Observer deleteObserver = new Observer() {
        @Override
        public void update(int id, int intparam, String param, Bitmap bitmap, List<String> mmUserList) {
            if (id==111){
                LgqLogutil.e("cccc=改变了3333333=="+mmUserList.size()+mmUserList.get(2));
                mUserList = mmUserList;
                ifnew = true;
                LgqLogutil.i("lai了顶顶顶顶");
            }
        }
    };

    @Override
    protected void initView(Bundle savedInstanceState) {
        mUserList.add("推荐");
        mUserList.add("热点");
        mUserList.add("东莞");
        mUserList.add("时尚");
        mUserList.add("科技");
        mUserList.add("体育");
        mUserList.add("军事");
        mUserList.add("财经");
        mUserList.add("网络");


        initInfo();
        LgqLogutil.i("cccc==="+mUserList.size());
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        LgqLogutil.i("req"+requestCode+"...res"+resultCode);
        if (requestCode == 2011 ) {
            initInfo();
            fragmentAViewPager.setCurrentItem(po);
        }
    }

    private void initInfo() {
        LgqLogutil.i("lai重新更新了44444444cccccccc4444==="+mUserList.size()+mUserList.get(2));
        fragmentATablayout.setTabMode(TabLayout.MODE_SCROLLABLE);//可以滚动
        adapter = new MyNewsFragmentAdapter(getActivity().getSupportFragmentManager(), mUserList);
        fragmentAViewPager.setAdapter(adapter);
        fragmentATablayout.setupWithViewPager(fragmentAViewPager);
        fragmentAViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                po = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
