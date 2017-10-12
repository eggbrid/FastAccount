package com.fastaccount.view.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fastaccount.R;

/**
 * Created by xus on 2017/10/12.
 */

public class MainLeftFragment extends Fragment {
    private DrawerLayout drawer_layout;

    public DrawerLayout getDrawer_layout() {
        return drawer_layout;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_left_fragment, container, false);

        return view;
    }


    public void setDrawer_layout(DrawerLayout drawer_layout) {
        this.drawer_layout = drawer_layout;
    }
}
