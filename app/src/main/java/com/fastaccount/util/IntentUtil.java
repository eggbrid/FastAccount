package com.fastaccount.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

/**
 * Created by xus on 2017/10/16.
 */

public class IntentUtil {
    public static void openActivity(Context context, Class activity){
        Intent intent=new Intent(context,activity);
        context.startActivity(intent);

    }
}
