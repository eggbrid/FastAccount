package com.fastaccount.view.views;

/**
 * Created by xus on 2016/7/19.
 */
public interface PeiDataSetting extends ChartDataSetting {

    int getItemNum(int pos);
    int getAllNum();
    Object getItemValue(int pos);
    String getItemName(int pos);
    int getSize();
    int[] getViewColor();
    int getViewItemColor(int pos);

}
