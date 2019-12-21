package com.tianxin.fragmentpgadt;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends FragmentActivity {

    private Fragment contentFg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        switchContent();
    }

    public void switchContent() {
        //必需继承FragmentActivity,嵌套fragment只需要这行代码
//        getSupportFragmentManager().beginTransaction().replace(R.id.con11, new MyFragment()).commitAllowingStateLoss();
        getSupportFragmentManager().beginTransaction().replace(R.id.con222, new NewsFragment()).commitAllowingStateLoss();

    }

}
