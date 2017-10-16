package com.fastaccount.view.activity;

import android.app.Dialog;
import android.view.View;

import com.fastaccount.R;
import com.fastaccount.model.LeftType;
import com.fastaccount.util.db.LiteOrmDBUtil;
import com.fastaccount.view.adapter.LeftFlagAdapter;
import com.fastaccount.view.views.InputDialog;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by xus on 2017/10/12.
 * 分类生活标签选择页和添加页
 * 默认添加 衣服 吃喝 住宿 旅游
 */

public class LeftFlagActivity extends BaseActivity {
    protected TagFlowLayout flowlayout;
    private List<LeftType> leftTypes;
    private LeftFlagAdapter adapter;
    private boolean isSelect;

    @Override
    public int setLayoutId() {
        return R.layout.left_flag_activity;
    }

    @Override
    public void initView() {
        isSelect = getIntent().getBooleanExtra("isSelect", false);
        setTitle("分类标签");
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
                LeftType leftType = new LeftType();
                leftType.setName(text);
                leftType.setType(1);
                LiteOrmDBUtil.getInstance(LeftFlagActivity.this).insert(leftType);
                leftTypes = LiteOrmDBUtil.getInstance(LeftFlagActivity.this).getQueryAll(LeftType.class);
                adapter = new LeftFlagAdapter(LeftFlagActivity.this, leftTypes);
                flowlayout.setAdapter(adapter);
            }
        });
        inputDialog.show();

    }

    @Override
    public void initData() {
        leftTypes = LiteOrmDBUtil.getInstance(this).getQueryAll(LeftType.class);
        if (leftTypes == null || leftTypes.isEmpty()) {
            leftTypes = new ArrayList<>();
            LeftType leftType = new LeftType();
            leftType.setName("衣服");
            leftType.setType(1);
            leftTypes.add(leftType);
            LeftType leftType2 = new LeftType();
            leftType2.setName("吃喝");
            leftType2.setType(1);
            leftTypes.add(leftType2);
            LeftType leftType3 = new LeftType();
            leftType3.setName("住宿");
            leftType3.setType(1);
            leftTypes.add(leftType3);
            LeftType leftType4 = new LeftType();
            leftType4.setName("旅游");
            leftType4.setType(1);
            leftTypes.add(leftType4);
            LiteOrmDBUtil.getInstance(this).insertAll(leftTypes);
            leftTypes = LiteOrmDBUtil.getInstance(this).getQueryAll(LeftType.class);
        }
        adapter = new LeftFlagAdapter(this, leftTypes);

        flowlayout.setAdapter(adapter);
    }
}
