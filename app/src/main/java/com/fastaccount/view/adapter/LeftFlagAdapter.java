package com.fastaccount.view.adapter;

import android.view.View;

import com.fastaccount.model.LeftType;
import com.fastaccount.model.PayType;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;

import java.util.List;

/**
 * Created by xus on 2017/10/13.
 */

public class LeftFlagAdapter extends TagAdapter<LeftType> {
    public LeftFlagAdapter(List<LeftType> datas) {
        super(datas);
    }

    public LeftFlagAdapter(LeftType[] datas) {
        super(datas);
    }

    @Override
    public View getView(FlowLayout parent, int position, LeftType leftType) {
        return null;
    }
}
