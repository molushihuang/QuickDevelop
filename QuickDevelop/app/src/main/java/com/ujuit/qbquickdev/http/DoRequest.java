package com.ujuit.qbquickdev.http;


import android.content.Context;
import android.os.Handler;
import com.anthole.quickdev.commonUtils.NetUtils;
import com.anthole.quickdev.commonUtils.logUtils.Logs;
import com.anthole.quickdev.http.RequestHandle;
import com.anthole.quickdev.http.RequestParams;
import com.anthole.quickdev.http.base.AsyncHttpClientUtil;
import com.ujuit.qbquickdev.http.BaseRequest.HttpMethod;


public class DoRequest {

    public static RequestHandle postRelative(Context context, String relativeUrl, RequestParams params, BaseResponseHandler responseHandler) {
        return request(context, HttpMethod.POST, BaseRequest.BaseHost + relativeUrl.trim(), params, responseHandler);
    }

    public static RequestHandle getRelative(Context context, String relativeUrl, RequestParams params, BaseResponseHandler responseHandler) {
        return request(context, HttpMethod.GET, BaseRequest.BaseHost + relativeUrl.trim(), params, responseHandler);
    }

    public static RequestHandle post(Context context, String url, RequestParams params, final BaseResponseHandler responseHandler) {
        return request(context, HttpMethod.POST, url.trim(), params, responseHandler);
    }

    public static RequestHandle get(Context context, String url, RequestParams params, final BaseResponseHandler responseHandler) {
        return request(context, HttpMethod.GET, url.trim(), params, responseHandler);
    }

    /**
     * 请求
     * <p>
     * 模块 名
     * 方法名
     *
     * @param params          参数
     * @param responseHandler
     */
    public static RequestHandle request(Context context, HttpMethod httpMethod, String url, RequestParams params, final BaseResponseHandler responseHandler) {

        RequestHandle mRequestHandle = null;
        if (!NetUtils.isConnected(context)) {
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {

                @Override
                public void run() {
                    responseHandler.onFailure(ws_code.NONET, "无网络请求");
                }
            }, 100);

            return mRequestHandle;
        }
        if (params == null) {
            params = new RequestParams();
        }
        Logs.e("请求参数 " + url, params.toString());
        switch (httpMethod) {
            case POST:
                mRequestHandle = AsyncHttpClientUtil.getInstance(context).post(context, url, params, responseHandler);

                break;
            case GET:
                mRequestHandle = AsyncHttpClientUtil.getInstance(context).get(context, url, params, responseHandler);

        }
        return mRequestHandle;
    }

}