package com.fastaccount.view.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fastaccount.R;
import com.fastaccount.util.IntentUtil;
import com.fastaccount.view.activity.AddLeftFlagActivity;
import com.fastaccount.view.activity.LeftFlagActivity;
import com.fastaccount.view.activity.PayFlagActivity;
import com.fastaccount.view.activity.SettingActivity;

/**
 * Created by xus on 2017/10/12.
 */

public class MainLeftFragment extends Fragment implements View.OnClickListener {
    protected View rootView;
    protected TextView mouth;
    protected TextView leftType;
    protected TextView payType;
    protected TextView upload;
    protected TextView setting;
    private DrawerLayout drawer_layout;

    public DrawerLayout getDrawer_layout() {
        return drawer_layout;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.main_left_fragment, container, false);

        initView(rootView);
        return rootView;
    }


    public void setDrawer_layout(DrawerLayout drawer_layout) {
        this.drawer_layout = drawer_layout;
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.mouth) {

        } else if (view.getId() == R.id.left_type) {
            IntentUtil.openActivity(getActivity(), LeftFlagActivity.class);
        } else if (view.getId() == R.id.pay_type) {
            IntentUtil.openActivity(getActivity(), PayFlagActivity.class);

        } else if (view.getId() == R.id.upload) {

        } else if (view.getId() == R.id.setting) {
            IntentUtil.openActivity(getActivity(), SettingActivity.class);

        }
    }

    private void initView(View rootView) {
        mouth = (TextView) rootView.findViewById(R.id.mouth);
        mouth.setOnClickListener(MainLeftFragment.this);
        leftType = (TextView) rootView.findViewById(R.id.left_type);
        leftType.setOnClickListener(MainLeftFragment.this);
        payType = (TextView) rootView.findViewById(R.id.pay_type);
        payType.setOnClickListener(MainLeftFragment.this);
        upload = (TextView) rootView.findViewById(R.id.upload);
        upload.setOnClickListener(MainLeftFragment.this);
        setting = (TextView) rootView.findViewById(R.id.setting);
        setting.setOnClickListener(MainLeftFragment.this);
    }
}
