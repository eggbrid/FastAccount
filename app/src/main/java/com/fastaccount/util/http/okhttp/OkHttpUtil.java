package com.fastaccount.util.http.okhttp;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import android.util.Log;

import com.fastaccount.util.AndroidIDUtil;
import com.fastaccount.util.http.Url.UrlUtil;
import com.fastaccount.util.http.okhttp.interfaces.CallBack;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


/**
 * Created by xus on 2017/3/24.
 */

public class OkHttpUtil {
    private static OkHttpClient client;
    private static Gson gson = new Gson();
    private static JsonParser parser = new JsonParser();


    public static void initHttpUtil() {
        UrlUtil.getUrl();
        client = new OkHttpClient.Builder().connectTimeout(60, TimeUnit.SECONDS).readTimeout(60, TimeUnit.SECONDS).writeTimeout(60, TimeUnit.SECONDS).build();
    }

    public static <P> void doGet(final Activity context, String url, Map<String, String> map, final CallBack callBack, final Class<P> pClass) {

        try {

            if (!map.containsKey("mac")) {
                map.put("mac", AndroidIDUtil.getLocalMacAddressFromIp(context));
                map.put("imei", AndroidIDUtil.getSzImei(context));
                map.put("model", AndroidIDUtil.getSystemModel());
                map.put("osVersion", AndroidIDUtil.getSystemVersion());
                map.put("os", "android");
            }
        } catch (Exception e) {
        }
        try {

            String addUrl = "?";
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (TextUtils.isEmpty(entry.getValue())) {
                    continue;
                }
                addUrl = addUrl + entry.getKey() + "=" + entry.getValue() + "&";
            }
            addUrl = addUrl.substring(0, addUrl.length() - 1);
            url = url + addUrl;
            Request request = new Request.Builder().url(url).build();
            client.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(Call call, final IOException e) {
                    runUIError(context, callBack, e.toString());
                }

                @Override
                public void onResponse(Call call, final Response response) throws IOException {
                    setSuccess(context, response, callBack, pClass);

                }


            });
        } catch (Exception e) {
            runUIError(context, callBack, e.toString());
        }
    }

    public static Map<String, String> getFromMap(Context context) {
        Map<String, String> map = new HashMap<>();
        try {
            map.put("mac", AndroidIDUtil.getLocalMacAddressFromIp(context));
            map.put("imei", AndroidIDUtil.getSzImei(context));
            map.put("model", AndroidIDUtil.getSystemModel());
            map.put("osVersion", AndroidIDUtil.getSystemVersion());
            map.put("os", "android");

        } catch (Exception e) {
        }
        return map;
    }


    public static <P> void doPost(final Activity context, String url, Map<String, String> map, final CallBack callBack, final Class<P> pClass) {
        try {
            if (!map.containsKey("mac")) {
                map.put("mac", AndroidIDUtil.getLocalMacAddressFromIp(context));
                map.put("imei", AndroidIDUtil.getSzImei(context));
                map.put("model", AndroidIDUtil.getSystemModel());
                map.put("osVersion", AndroidIDUtil.getSystemVersion());
                map.put("os", "android");
            }
        } catch (Exception e) {
        }
        try {

            String addUrl = "?";
            FormBody.Builder formBodyBuilder = new FormBody.Builder();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (TextUtils.isEmpty(entry.getValue())) {
                    continue;
                }
                formBodyBuilder = formBodyBuilder.add(entry.getKey(), entry.getValue());
                addUrl = addUrl + entry.getKey() + "=" + entry.getValue() + "&";

            }
            FormBody formBody = formBodyBuilder.build();
            Request request = new Request.Builder().url(url).post(formBody).build();
            Log.e("wangxu", request.url().toString());
            Log.e("wangxu", addUrl);

            client.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(Call call, final IOException e) {
                    context.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            runUIError(context, callBack, e.toString());
                        }
                    });
                }

                @Override
                public void onResponse(Call call, final Response response) throws IOException {
                    setSuccess(context, response, callBack, pClass);
                }


            });
        } catch (Exception e) {
            e.printStackTrace();
            runUIError(context, callBack, e.toString());
        }
    }

    public static <P, V> void doPost(final Activity context, String url, V v, final CallBack callBack, final Class<P> pClass) {
        try {

            RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), toJson(v));
//            FormBody formBody = formBodyBuilder.build();
            Request request = new Request.Builder().url(url).post(requestBody).build();
            client.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(Call call, final IOException e) {
                    runUIError(context, callBack, e.toString());
                }

                @Override
                public void onResponse(Call call, final Response response) throws IOException {
                    setSuccess(context, response, callBack, pClass);
                }


            });
        } catch (Exception e) {
            e.printStackTrace();
            runUIError(context, callBack, e.toString());

        }
    }

    public static <P> void setSuccess(final Activity context, final Response response, final CallBack callBack, final Class<P> pClass) {
        try {
            String json = response.body().string();


            Log.e("wangxu", json);
            ResponseCodeBean responseCodeBean = gson.fromJson(json, ResponseCodeBean.class);
            if (responseCodeBean.getState().equals("0") || responseCodeBean.getState().equals("success")) {
                JsonObject jsonObject = parser.parse(json).getAsJsonObject();


                if (jsonObject.has("data")) {


                } else {
                    runUISuccess(context, callBack, null);
                }


            } else {
                runUIError(context, callBack, responseCodeBean.getMsg());
            }
        } catch (Exception e) {
            runUIError(context, callBack, e.toString());
        }
    }


    /**
     * 检测当的网络（WLAN、3G/2G）状态
     *
     * @param context Context
     * @return true 表示网络可用
     */
    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivity = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity != null) {
            NetworkInfo info = connectivity.getActiveNetworkInfo();
            if (info != null && info.isConnected()) {// 当前网络是连接的
                if (info.getState() == NetworkInfo.State.CONNECTED) {
                    // 当前所连接的网络可用
                    return true;
                }
            }
        }
        return false;
    }

    public static <P> void runUISuccess(final Activity context, final CallBack callBack, final P p) {
        context.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                callBack.onSuccess(p);

            }
        });

    }

    public static <P> void runUIError(final Activity context, final CallBack callBack, final String s) {
        context.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                callBack.onError(s);

            }
        });
    }

    public static <P> String toJson(P p) {
        return gson.toJson(p);
    }

    public static <P> P fromJson(String json, Class<P> p) {
        return gson.fromJson(json, p);
    }
}
