package com.fastaccount.view.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.fastaccount.model.PayType;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;

import java.util.List;

/**
 * Created by xus on 2017/10/13.
 */

public class PayFlagAdapter extends TagAdapter<PayType> {


    public PayFlagAdapter(List<PayType> datas) {
        super(datas);
    }

    public PayFlagAdapter(PayType[] datas) {
        super(datas);
    }

    @Override
    public View getView(FlowLayout parent, int position, PayType payType) {
        return null;
    }
}
