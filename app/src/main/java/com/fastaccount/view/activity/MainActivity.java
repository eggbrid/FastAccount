package com.fastaccount.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.fastaccount.R;
import com.fastaccount.view.fragment.ContentFragment;
import com.fastaccount.view.fragment.MainLeftFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    protected TextView back;
    protected TextView title;
    protected TextView more;
    protected FrameLayout flyContent;
    protected DrawerLayout drawerLayout;
    private FragmentManager fManager;
    protected MainLeftFragment fgLeftMenu;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.main_avtivity);
        initView();

    }

    private void initView() {
        fManager = getSupportFragmentManager();
        back = (TextView) findViewById(R.id.back);
        title = (TextView) findViewById(R.id.title);
        more = (TextView) findViewById(R.id.more);
        flyContent = (FrameLayout) findViewById(R.id.fly_content);
        fgLeftMenu = (MainLeftFragment) fManager.findFragmentById(R.id.fg_left_menu);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        back.setText("设置");
        back.setOnClickListener(this);
        ContentFragment cFragment2 = new ContentFragment();
        fManager.beginTransaction().replace(R.id.fly_content,cFragment2).commit();

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.back:
                drawerLayout.openDrawer(Gravity.LEFT);
                break;
        }
    }
}
