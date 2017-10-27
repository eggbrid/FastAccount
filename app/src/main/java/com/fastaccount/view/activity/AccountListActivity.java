package com.fastaccount.view.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.fastaccount.R;
import com.fastaccount.util.BirthDateDialogFromTop;
import com.fastaccount.util.DateDialogUtils;

/**
 * Created by xus on 2017/10/16.
 */

public class AccountListActivity extends BaseActivity implements View.OnClickListener {
    protected TextView mouth;
    protected ListView list;
    protected ImageView noDataImage;
    protected TextView noDataText;

    @Override
    public int setLayoutId() {
        return R.layout.account_list_activity;
    }

    @Override
    public void initView() {
        setTitle("账单");
        mouth = (TextView) findViewById(R.id.mouth);
        mouth.setOnClickListener(AccountListActivity.this);
        list = (ListView) findViewById(R.id.list);
        noDataImage = (ImageView) findViewById(R.id.no_data_image);
        noDataText = (TextView) findViewById(R.id.no_data_text);
    }

    @Override
    public void initData() {

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.mouth) {
            DateDialogUtils dateDialogUtils=new DateDialogUtils(this,1);
            dateDialogUtils.showDialogFromTop("2017", "10", new BirthDateDialogFromTop.PriorityListener() {
                @Override
                public void refreshPriorityUI(String year, String month, String day) {

                }

                @Override
                public void onDissMiss() {

                }
            });
        }
    }
}
