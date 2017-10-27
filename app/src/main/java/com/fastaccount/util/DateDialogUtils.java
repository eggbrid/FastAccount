package com.fastaccount.util;

import android.app.Activity;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.Window;
import android.widget.TextView;


import com.fastaccount.R;

import java.util.Date;

/**
 * Created by 雪元 on 2016/8/1.
 */
public class DateDialogUtils {
    BirthDateDialogFromTop birthDiologFromTop;
    BirthDateDialog birthDiolog;
    private Activity activity;
    private int gongDay = 0;
    private int limit=1;//0表示不限制,1表示限制
    public DateDialogUtilsListener attendanceFragmentListener;
    private int startTime;
    public static int start2016=2016;

    public void setDateDialogUtilsListener(DateDialogUtilsListener attendanceFragmentListener) {
        this.attendanceFragmentListener = attendanceFragmentListener;
    }

    public interface DateDialogUtilsListener {
        public void attendanceFragment(String year, String month, String day);
    }




    /**
     * @param activity
     * @param gongDay  是否隐藏日期
     */
    public DateDialogUtils(Activity activity, int gongDay) {  //0表示年月日，1表示年月，2 表示年
        this.activity = activity;
        this.gongDay = gongDay;
    }
    /**
     * @param activity
     * @param limit  是否限制
     */
    public DateDialogUtils(int limit, Activity activity) {  //0表示年月日，1表示年月，2 表示年
        this.activity = activity;
        this.limit=limit;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    /**
     * @param activity 不限制 不隱藏
     */
    public DateDialogUtils(Activity activity) {  //0表示年月日，1表示年月，2 表示年
        this.activity = activity;
        limit=0;
    }

    /**
     * @param activity
     * @param gongDay  是否隐藏日期
     * @param limit 是否限制
     */
    public DateDialogUtils(Activity activity, int gongDay, int limit) {  //0表示年月日，1表示年月，2 表示年
        this.activity = activity;
        this.gongDay = gongDay;
        this.limit=limit;
    }

    public void showDialog(final TextView textView) {
        DisplayMetrics dm = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels;
        String curDate;
        int[] date;
        try {
            curDate = textView.getText().toString();
            if(curDate.indexOf("-")!=-1){
                date = ValidateUtils.getYMDArray(curDate, "-");
            }else{
                date = ValidateUtils.getYMDArray(curDate, "\\.");
            }

        } catch (Exception e) {
            date = ValidateUtils.getYMDArray(DateUtil.getInstance().simMPoiD_HMS(new Date().getTime() + ""), "\\.");
        }
        birthDiolog = new BirthDateDialog(activity,
                new BirthDateDialog.PriorityListener() {
                    @Override
                    public void refreshPriorityUI(String year, String month, String day) {
                        if (attendanceFragmentListener != null) {
                            attendanceFragmentListener.attendanceFragment(year, month, day);
                        }
                    }
                }, date[0], date[1], date[2], width,
                height, "", gongDay,limit,startTime);
        Window window = birthDiolog.getWindow();
        window.setGravity(Gravity.BOTTOM); // 此处可以设置dialog显示的位置
        window.setWindowAnimations(R.style.dialogstyle); // 添加动画
        birthDiolog.setCancelable(true);
        birthDiolog.show();
    }
    public void showDialog(final String textView) {
        DisplayMetrics dm = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels;
        String curDate;
        int[] date;
        try {
            curDate = textView.toString();
            if(curDate.indexOf("-")!=-1){
                date = ValidateUtils.getYMDArray(curDate, "-");
            }else{
                date = ValidateUtils.getYMDArray(curDate, "\\.");
            }

        } catch (Exception e) {
            date = ValidateUtils.getYMDArray(DateUtil.getInstance().simMPoiD_HMS(new Date().getTime() + ""), "\\.");
        }
        birthDiolog = new BirthDateDialog(activity,
                new BirthDateDialog.PriorityListener() {
                    @Override
                    public void refreshPriorityUI(String year, String month, String day) {
                        if (attendanceFragmentListener != null) {
                            attendanceFragmentListener.attendanceFragment(year, month, day);
                        }
                    }
                }, date[0], date[1], date[2], width,
                height, "", gongDay,limit,startTime);
        Window window = birthDiolog.getWindow();
        window.setGravity(Gravity.BOTTOM); // 此处可以设置dialog显示的位置
        window.setWindowAnimations(R.style.dialogstyle); // 添加动画
        birthDiolog.setCancelable(true);
        birthDiolog.show();
    }

    public DateDialogUtilsListener1 attendanceFragmentListener1;

    public void setDateDialogUtilsListener(DateDialogUtilsListener1 attendanceFragmentListener1) {
        this.attendanceFragmentListener1 = attendanceFragmentListener1;
    }

    public interface DateDialogUtilsListener1 {
        public void attendanceFragment(String year, String month, String day, String hhhh, String mmmm, int hindex, int mindex);
    }



    public void showDialogYYYY(final TextView textView, int hindex, int mhindex) {
        DisplayMetrics dm = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels;
        String curDate;
        int[] date;
        try {
            curDate = textView.getText().toString();
            if(curDate.indexOf("-")!=-1){
                date = ValidateUtils.getYMDArray(curDate, "-");
            }else{
                date = ValidateUtils.getYMDArray(curDate, "\\.");
            }

        } catch (Exception e) {
            date = ValidateUtils.getYMDArray(DateUtil.getInstance().simMPoiD_HMS(new Date().getTime() + ""), "\\.");
        }
        BirthDateTimeDialog  birthDiolog = new BirthDateTimeDialog(activity,
                new BirthDateTimeDialog.PriorityListener() {
                    @Override
                    public void refreshPriorityUI(String year, String month, String day, String hhhh, String mmmm, int hindex, int mindex) {
                        if (attendanceFragmentListener1 != null) {
                            attendanceFragmentListener1.attendanceFragment(year, month, day,hhhh,mmmm,hindex,mindex);
                        }
                    }
                }, date[0], date[1], date[2], width,
                height, "", gongDay,limit);
        birthDiolog.setHindex(hindex);
        birthDiolog.setMindex(mhindex);
        Window window = birthDiolog.getWindow();
        window.setGravity(Gravity.BOTTOM); // 此处可以设置dialog显示的位置
        window.setWindowAnimations(R.style.dialogstyle); // 添加动画
        birthDiolog.setCancelable(true);
        birthDiolog.show();
    }
    public void showDialogFromTop(String year, String mouth, BirthDateDialogFromTop.PriorityListener listener) {
        DisplayMetrics dm = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = DensityUtil.dp2px(activity,314);
        int height = dm.heightPixels;
        String curDate;
        int[] date;
        try {
            curDate = year + "-" + mouth;
            date = ValidateUtils.getYMDArray(curDate, "-");

        } catch (Exception e) {
            date = ValidateUtils.getYMDArray(DateUtil.getInstance().simMPoiD_HMS(new Date().getTime() + ""), "\\.");
        }
        birthDiologFromTop = new BirthDateDialogFromTop(activity, listener, date[0], date[1], date[2], width,
                height,gongDay, limit, startTime,R.style.myDialog,false);
        Window window = birthDiologFromTop.getWindow();
        window.setGravity(Gravity.CENTER); // 此处可以设置dialog显示的位置
        birthDiologFromTop.setCancelable(true);
        birthDiologFromTop.show();

    }
    public void showDialogFromCenter(String year, String mouth, String day, BirthDateDialogFromTop.PriorityListener listener) {
        DisplayMetrics dm = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = DensityUtil.dp2px(activity,314);
        int height = dm.heightPixels;
        String curDate;
        int[] date;
        try {
            curDate = year + "-" + mouth+"-"+day;
            date = ValidateUtils.getYMDArray(curDate, "-");

        } catch (Exception e) {
            date = ValidateUtils.getYMDArray(DateUtil.getInstance().simMPoiD_HMS(new Date().getTime() + ""), "\\.");
        }
        birthDiologFromTop = new BirthDateDialogFromTop(activity, listener, date[0], date[1], date[2], width,
                height,gongDay, limit, startTime,R.style.myDialog,false);
        Window window = birthDiologFromTop.getWindow();
        window.setGravity(Gravity.CENTER); // 此处可以设置dialog显示的位置
        birthDiologFromTop.setCancelable(true);
        birthDiologFromTop.show();

    }
}
