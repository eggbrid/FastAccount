package com.fastaccount.util.db;

import android.app.Activity;
import android.content.Context;


/**
 * Created by xus on 2017/7/13.
 */

public class DBUtil {
    private static DBUtil dbUtil;
    private static LiteOrmDBUtil liteOrmDBUtil;

    private DBUtil(Context c) {
        liteOrmDBUtil = LiteOrmDBUtil.getInstance(c);
    }

    public static synchronized DBUtil getInstance(Context c) {
        if (dbUtil == null || liteOrmDBUtil == null) {
            synchronized (DBUtil.class) {
                if (dbUtil == null || liteOrmDBUtil == null) {
                    dbUtil = new DBUtil(c);
                }
            }
        }
        return dbUtil;
    }



}
