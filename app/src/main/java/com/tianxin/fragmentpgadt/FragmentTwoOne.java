package com.tianxin.fragmentpgadt;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.liaoinstan.springview.widget.SpringView;
import com.tianxin.fragmentpgadt.refreshs.SuperSwipeRefreshLayout;

/**
 * 作者：created by meixi
 * 邮箱：15913707499@163.com
 * 日期：2019/5/31 17
 */
public class FragmentTwoOne extends BaseLazyFragment implements SwipeRefreshLayout.OnRefreshListener{

    private String newsTypeIds;

    private RecyclerView recyclerView;
    private Button button;

    SuperSwipeRefreshLayout swipehome;

    public static FragmentTwoOne newInstance(String newsTypeIds) {
        FragmentTwoOne fragmentTwoOne = new FragmentTwoOne();
        Bundle bundle = new Bundle();
        bundle.putString("newsTypeIds", newsTypeIds);
        fragmentTwoOne.setArguments(bundle);
        return fragmentTwoOne;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_two_one, container, false);

        recyclerView =(RecyclerView)view.findViewById(R.id.fragment_two_one_recyclerview);
        button = (Button)view.findViewById(R.id.itembutton);
        swipehome = (SuperSwipeRefreshLayout)view.findViewById(R.id.swipehome);
        swipehome.setOnRefreshListener(this);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        newsTypeIds = getArguments().getString("newsTypeIds");
        button.setText(newsTypeIds);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                swipehome.setRefreshing(false);
            }
        });
        LgqLogutil.i("getdata0000--------------"+newsTypeIds);
    }

    @Override
    public void onFirstUserVisible() {
        super.onFirstUserVisible();
//        LgqLogutil.e("getdata2222"+newsTypeIds);

    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
//        LgqLogutil.i("显示===="+isVisibleToUser+">..."+newsTypeIds);
    }


    @Override
    public void onRefresh() {
        button.setText("aabb");
    }


    @Override
    public void onResume() {
        super.onResume();
        LgqLogutil.e("getdata1111"+newsTypeIds);
    }

}
