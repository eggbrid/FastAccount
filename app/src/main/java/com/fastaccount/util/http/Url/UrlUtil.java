package com.fastaccount.util.http.Url;

/**
 * Created by xus on 2017/3/25.
 */

public class UrlUtil {
    private static String baseUrl = "";

    public static String getUrl() {
//        if (TextUtils.isEmpty(baseUrl)) {
//            ApplicationInfo info = null;
//            try {
//                info = APP.getInstance().getPackageManager().getApplicationInfo(APP.getInstance().getPackageName(), PackageManager.GET_META_DATA);
//                baseUrl = info.metaData.getString("hostIp");
//            } catch (PackageManager.NameNotFoundException e) {
//
//            }
//            if (TextUtils.isEmpty(baseUrl)) {
//                baseUrl = "http://123.56.216.53:8080/";
//            }
//        }
        return baseUrl;
    }

    public static String TEST = getUrl() + "trt_service/article/articleQuery"; //测试



}
