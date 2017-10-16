package com.fastaccount.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.fastaccount.R;
import com.fastaccount.model.LeftType;
import com.fastaccount.model.PayType;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;

import java.util.List;

/**
 * Created by xus on 2017/10/13.
 */

public class PayFlagAdapter extends TagAdapter<PayType> {

    private Context context;

    public PayFlagAdapter(Context context,List<PayType> datas) {
        super(datas);
        this.context=context;

    }


    @Override
    public View getView(FlowLayout parent, int position, PayType payType) {
        View v =  LayoutInflater.from(context).inflate(R.layout.item_tag,
                parent, false);
        TextView textView=v.findViewById(R.id.text);
        textView.setText(payType.getName());
        return v;
    }
}
