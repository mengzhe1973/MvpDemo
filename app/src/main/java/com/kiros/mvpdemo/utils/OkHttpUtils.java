package com.kiros.mvpdemo.utils;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import com.kiros.mvpdemo.ui.LoginActivity;
import com.kiros.mvpdemo.widget.LoadingDialog;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.LinkedHashMap;
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
 * Created by kiros on 2016/4/11.
 */
public class OkHttpUtils {

    private OkHttpClient client;
    //超时时间
    public static final int TIMEOUT = 1000 * 60;

    //json请求
    public static final MediaType JSON = MediaType
            .parse("application/json; charset=utf-8");

    private Handler handler = new Handler(Looper.getMainLooper());

    private static OkHttpUtils httpUtils;
    private static LoadingDialog loadingDialog;
    private static Context mContext;
    private SharedPreferencesHelper sp;
    private LinkedHashMap<String, String> params = new LinkedHashMap<String, String>();

    public OkHttpUtils() {
        this.init();
    }

    public OkHttpUtils(Context context) {
        mContext = context;
        loadingDialog = new LoadingDialog(context);
        sp = new SharedPreferencesHelper(context);
        this.init();
    }

    private void init() {
        client = new OkHttpClient();
        //设置超时
        client.newBuilder().connectTimeout(TIMEOUT, TimeUnit.SECONDS).
                writeTimeout(TIMEOUT, TimeUnit.SECONDS).readTimeout(TIMEOUT, TimeUnit.SECONDS)
                .build();
    }


    public static OkHttpUtils getInstance() {
        if (httpUtils == null) {
            synchronized (OkHttpUtils.class) {
                if (httpUtils == null) {
                    httpUtils = new OkHttpUtils();
                }
            }
        }
        return httpUtils;
    }

    /**
     * post请求  json数据为body
     */
    public void postJson(String url, String json, final HttpCallBack callBack) {
        RequestBody body = RequestBody.create(JSON, json);
        final Request request = new Request.Builder()
                .header("Content-Type", "application/json")
                .addHeader("token", sp.getStringKey("token"))
                .addHeader("user_id", sp.getStringKey("user_id"))
                .url(url)
                .post(body)
                .build();

        OnStart(callBack);

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(okhttp3.Call cal, IOException e) {
                OnError(callBack, e.getMessage());
                onComplete(callBack);
            }

            @Override
            public void onResponse(okhttp3.Call cal, Response response) throws IOException {
                String data = response.body().string();
                try {
                    JSONObject jsonObj = new JSONObject(data);
                    if (response.isSuccessful()) {
                        if (jsonObj.optBoolean("success")) {
                            onSuccess(callBack, jsonObj);
                        } else {
                            Toast.makeText(mContext, jsonObj.optString("message"), Toast.LENGTH_LONG).show();
                        }
                    } else {
                        OnError(callBack, response.message());
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                onComplete(callBack);
            }
        });
    }

    /**
     * post请求  map是body
     *
     * @param url
     * @param map
     * @param callBack
     */
    public void postMap(String url, Map<Object, Object> map, final HttpCallBack callBack) {
        FormBody.Builder builder = new FormBody.Builder();
        builder.add("token", (String) sp.getSharedPreference("token", ""));
        //遍历map
        if (map != null) {
            for (Map.Entry<Object, Object> entry : map.entrySet()) {
                builder.add(entry.getKey().toString(), entry.getValue().toString());
            }
        }
        Log.d("请求的urlaaaaaa:", url);
        RequestBody body = builder.build();
        Request request = new Request.Builder()
                .header("Content-Type", "application/json")
                .url(url)
                .post(body)
                .build();
        OnStart(callBack);
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(okhttp3.Call cal, IOException e) {
                OnError(callBack, e.getMessage());
                onComplete(callBack);
            }

            @Override
            public void onResponse(okhttp3.Call cal, Response response) throws IOException {
                String data = response.body().string();
                Log.d("返回信息aaaaaa:", data);
                try {
                    JSONObject jsonObj = new JSONObject(data);
                    if (response.isSuccessful()) {
                        if (jsonObj.optInt("code") == 1) {
                            onSuccess(callBack, jsonObj);
                        } else {
                            OnError(callBack, jsonObj.optString("msg"));
                        }
                    } else {
                        OnError(callBack, response.message());
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                onComplete(callBack);
            }
        });
    }

    public void asyPostJson(String apiId, Map<String, String> map, String jsonString, final HttpCallBack callBack) {
        if (TextUtils.isEmpty(jsonString)) {
            return;
        }
        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        RequestBody requestBody = RequestBody.create(JSON, jsonString);
        Log.e("======>>", apiId + " 请求json：" + jsonString);
        String url = apiId + "?";

        //遍历map
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue().toString();
                url = url + "&" + key + "=" + value;
            }
        }
        Log.e("", "============URL============" + apiId + ":" + url);
        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call cal, IOException e) {
                OnError(callBack, e.getMessage());
                onComplete(callBack);
            }

            @Override
            public void onResponse(Call cal, Response response) throws IOException {
                String data = response.body().string();
                try {
                    JSONObject jsonObj = new JSONObject(data);
                    if (response.isSuccessful()) {
                        if (jsonObj.optBoolean("success")) {
                            onSuccess(callBack, jsonObj);
                        } else {
                            Toast.makeText(mContext, jsonObj.optString("message"), Toast.LENGTH_LONG).show();
                        }
                    } else {
                        OnError(callBack, response.message());
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                onComplete(callBack);
            }
        });
    }

    public void PostJsonBody(String url, String[] keys, String[] values, String jsonString, final HttpCallBack callBack) {
        if (TextUtils.isEmpty(jsonString)) {
            return;
        }
        RequestBody requestBody = RequestBody.create(JSON, jsonString);
        Log.e("======>>", url + " 请求json：" + jsonString);

        String resUrl;
        if ((keys != null && values != null)) {
            for (int i = 0; i < keys.length + 1; i++) {
                if (i == keys.length) {
                    params.put("user_id", sp.getStringKey("user_id"));
                } else {
                    params.put(keys[i], values[i]);
                }
            }
            resUrl = attachHttpGetParams(url, params);
        } else {
            resUrl = url;
        }
        Log.e("", "============URL============" + resUrl);
        Request request = new Request.Builder()
                .url(resUrl)
                .header("Content-Type", "application/json")
                .addHeader("token", sp.getStringKey("token"))
                .post(requestBody)
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call cal, IOException e) {
                OnError(callBack, e.getMessage());
                onComplete(callBack);
            }

            @Override
            public void onResponse(Call cal, Response response) throws IOException {
                String data = response.body().string();
                try {
                    JSONObject jsonObj = new JSONObject(data);
                    if (response.isSuccessful()) {
                        if (jsonObj.optInt("code") == 200) {
                            onSuccess(callBack, jsonObj);
                        } else {
//                            Toast.makeText(mContext, jsonObj.optString("message"), Toast.LENGTH_LONG).show();
                            OnError(callBack, jsonObj.optString("msg"));
                        }
                    } else {
                        OnError(callBack, response.message());
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                onComplete(callBack);
            }
        });
    }

    /**
     * get 请求
     *
     * @param url
     * @param callBack return string
     */
    public void getJsonForString(String url, String[] keys, String[] values, final HttpCallBack callBack) {
        String resUrl;
        if ((keys != null && values != null)) {
            for (int i = 0; i < keys.length; i++) {
                params.put(keys[i], values[i]);
            }
            resUrl = attachHttpGetParams(url, params);
        } else {
            resUrl = url;
        }
        Log.d("aaaaaa", resUrl);
        final Request request = new Request.Builder()
                .header("Content-Type", "application/json")
                .addHeader("token", sp.getStringKey("token"))
                .addHeader("user_id", sp.getStringKey("user_id"))
                .url(resUrl)
                .build();
        OnStart(callBack);
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(okhttp3.Call cal, IOException e) {
                OnError(callBack, e.getMessage());
                onComplete(callBack);
            }

            @Override
            public void onResponse(okhttp3.Call cal, Response response) throws IOException {
                String data = response.body().string();
                if (response.isSuccessful()) {
                    onSuccess(callBack, data);
                } else {
                    OnError(callBack, response.message());
                }
                onComplete(callBack);
            }
        });
    }

    /**
     * @param url
     * @param keys
     * @param values
     * @param callBack return JSONObject
     */
    public void getJson(String url, String[] keys, String[] values, final HttpCallBack callBack) {
        String resUrl;
        if ((keys != null && values != null)) {
            for (int i = 0; i < keys.length + 1; i++) {
                if (i == keys.length) {
                    params.put("user_id", sp.getStringKey("user_id"));
                } else {
                    params.put(keys[i], values[i]);
                }
            }
            resUrl = attachHttpGetParams(url, params);
        } else {
            resUrl = url;
        }
        Log.d("aaaaaa", resUrl);
        final Request request = new Request.Builder()
                .header("Content-Type", "application/json")
                .addHeader("token", sp.getStringKey("token"))
//                .addHeader("user_id", sp.getStringKey("user_id"))
                .url(resUrl)
                .build();

        OnStart(callBack);
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(okhttp3.Call cal, IOException e) {
                Log.d("aaaaaa", e.getMessage());
                loadingDialog.dismiss();
                OnError(callBack, e.getMessage());
                onComplete(callBack);
            }

            @Override
            public void onResponse(okhttp3.Call cal, Response response) throws IOException {
                String data = response.body().string();
                Log.d("aaaaaa", data);
                loadingDialog.dismiss();
                onComplete(callBack);
                try {
                    JSONObject jsonObj = new JSONObject(data);
                    if (response.isSuccessful()) {
                        if (jsonObj.optBoolean("success")) {
                            onSuccess(callBack, jsonObj);
                        } else {
                            Looper.prepare();
                            Toast.makeText(mContext, jsonObj.optString("message"), Toast.LENGTH_LONG).show();
                            if (jsonObj.optString("code").equals("10001")) {
                                mContext.startActivity(new Intent(mContext, LoginActivity.class));
                            }
                            Looper.loop();
                        }
                    } else {
                        OnError(callBack, response.message());
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    Looper.prepare();
                    Toast.makeText(mContext, "服务器异常", Toast.LENGTH_LONG).show();
                    Looper.loop();
                    Log.d("aaaaaa", e.toString());
                }
            }
        });
    }

    /**
     * 为HttpGet 方便的添加多个name value 参数。
     *
     * @param params
     * @return
     */
    public static String attachHttpGetParams(LinkedHashMap<String, String> params) {

        Iterator<String> keys = params.keySet().iterator();
        Iterator<String> values = params.values().iterator();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("?");

        for (int i = 0; i < params.size(); i++) {
            String value = null;
            try {
                value = URLEncoder.encode(values.next(), "utf-8");
            } catch (Exception e) {
                e.printStackTrace();
            }

            stringBuffer.append(keys.next() + "=" + value);
            if (i != params.size() - 1) {
                stringBuffer.append("&");
            }
        }
        Log.d("aaaaaa", "stringBuffer===>" + stringBuffer.toString());
        return stringBuffer.toString();
    }

    /**
     * 为HttpGet 的 url 方便的添加多个name value 参数。
     *
     * @param url
     * @param params
     * @return
     */
    public static String attachHttpGetParams(String url, LinkedHashMap<String, String> params) {

        Iterator<String> keys = params.keySet().iterator();
        Iterator<String> values = params.values().iterator();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("?");

        for (int i = 0; i < params.size(); i++) {
            String value = null;
            try {
                value = URLEncoder.encode(values.next(), "utf-8");
            } catch (Exception e) {
                e.printStackTrace();
            }

            stringBuffer.append(keys.next() + "=" + value);
            if (i != params.size() - 1) {
                stringBuffer.append("&");
            }
        }
        Log.d("aaaaaa", "stringBuffer===>" + url + stringBuffer.toString());
        return url + stringBuffer.toString();
    }

    public void OnStart(HttpCallBack callBack) {
//        loadingDialog.show();
        if (!NetWorkUtils.isNetworkConnected(mContext)) {
            Toast.makeText(mContext, "网络跑火星上了...", Toast.LENGTH_SHORT).show();
        } else {
            if (callBack != null) {
                callBack.onStart(true);
            }
        }
    }

    public void onComplete(HttpCallBack callBack) {
        loadingDialog.dismiss();
        if (callBack != null) {
            callBack.onComplete();
        }
    }

    /**
     * @param callBack
     * @param data
     */
    public void onSuccess(final HttpCallBack callBack, final String data) {
        Log.d("aaaaaa", data);
        loadingDialog.dismiss();
        if (callBack != null) {
            handler.post(new Runnable() {
                @Override
                public void run() {//在主线程操作
                    callBack.onSuccess(data);
                }
            });
        }
    }

    /**
     * @param callBack
     * @param obj
     */
    public void onSuccess(final HttpCallBack callBack, final JSONObject obj) {
        Log.d("aaaaaa", obj.toString());
        loadingDialog.dismiss();
        if (callBack != null) {
            handler.post(new Runnable() {
                @Override
                public void run() {//在主线程操作
                    callBack.onSuccess(obj);
                }
            });
        }
    }

    public void OnError(final HttpCallBack callBack, final String msg) {
        Log.e("aaaaaa", msg);
        loadingDialog.dismiss();
        if (callBack != null) {
            handler.post(new Runnable() {
                @Override
                public void run() {
                    callBack.onError(msg);
                }
            });
        }
    }

    public static abstract class HttpCallBack {
        //开始
        public void onStart(Boolean isLoadingDialog) {
            if (loadingDialog != null) {
                if (isLoadingDialog) {
                    loadingDialog.show();
                } else {
                    loadingDialog.dismiss();
                }
            }
        }

        //成功回调返回String
        public void onSuccess(String data) {
        }

        ;

        //成功回调
        public abstract void onSuccess(JSONObject obj);

        //失败
        public abstract void onError(String msg);

        //结束
        public void onComplete() {
            if (loadingDialog != null) {
                loadingDialog.dismiss();
            }
        }
    }
}

