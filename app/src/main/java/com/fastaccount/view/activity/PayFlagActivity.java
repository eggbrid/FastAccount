package com.fastaccount.view.activity;

import android.view.View;

import com.fastaccount.R;
import com.fastaccount.model.PayType;
import com.fastaccount.model.PayType;
import com.fastaccount.util.db.LiteOrmDBUtil;
import com.fastaccount.view.adapter.PayFlagAdapter;
import com.fastaccount.view.adapter.PayFlagAdapter;
import com.fastaccount.view.views.InputDialog;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xus on 2017/10/12.
 * 支付方式选择和展示页
 * 默认添加 微信 支付宝 现金 信用卡
 */

public class PayFlagActivity extends BaseActivity {
    protected TagFlowLayout flowlayout;
    private List<PayType> PayTypes;
    private PayFlagAdapter adapter;
    private boolean isSelect;

    @Override
    public int setLayoutId() {
        return R.layout.pay_flag_activity;
    }

    @Override
    public void initView() {
        isSelect = getIntent().getBooleanExtra("isSelect", false);
        setTitle("支付方式标签");
        setTitleRight("添加", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog();

            }
        });
        flowlayout = (TagFlowLayout) findViewById(R.id.flowlayout);
        if (isSelect) {
            flowlayout.setMaxSelectCount(1);
        } else {
            flowlayout.setMaxSelectCount(-1);
        }
    }
    private void showDialog() {
        InputDialog inputDialog = new InputDialog(this);
        inputDialog.setOnInputFinishListener(new InputDialog.OnInputFinishListener() {
            @Override
            public void onInputFinish(String text) {
                PayType PayType = new PayType();
                PayType.setName(text);
                PayType.setType(1);
                LiteOrmDBUtil.getInstance(PayFlagActivity.this).insert(PayType);
                PayTypes = LiteOrmDBUtil.getInstance(PayFlagActivity.this).getQueryAll(PayType.class);
                adapter = new PayFlagAdapter(PayFlagActivity.this, PayTypes);
                flowlayout.setAdapter(adapter);
            }
        });
        inputDialog.show();

    }
    @Override
    public void initData() {
        PayTypes = LiteOrmDBUtil.getInstance(this).getQueryAll(PayType.class);
        if (PayTypes == null || PayTypes.isEmpty()) {
            PayTypes = new ArrayList<>();
            PayType PayType = new PayType();
            PayType.setName("微信");
            PayType.setType(1);
            PayTypes.add(PayType);
            PayType PayType2 = new PayType();
            PayType2.setName("支付宝");
            PayType2.setType(1);
            PayTypes.add(PayType2);
            PayType PayType3 = new PayType();
            PayType3.setName("现金");
            PayType3.setType(1);
            PayTypes.add(PayType3);
            PayType PayType4 = new PayType();
            PayType4.setName("信用卡");
            PayType4.setType(1);
            PayTypes.add(PayType4);
            LiteOrmDBUtil.getInstance(this).insertAll(PayTypes);
            PayTypes = LiteOrmDBUtil.getInstance(this).getQueryAll(PayType.class);
        }
        adapter = new PayFlagAdapter(this, PayTypes);

        flowlayout.setAdapter(adapter);
    }
}
