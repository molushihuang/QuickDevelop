package com.ujuit.qbquickdev.http;

import android.content.Context;
import com.anthole.quickdev.QAppManager;
import com.anthole.quickdev.commonUtils.StringUtils;
import com.anthole.quickdev.commonUtils.T;
import com.anthole.quickdev.commonUtils.jsonUtils.JSONUtils;
import com.anthole.quickdev.http.TextHttpResponseHandler;
import com.example.aaron.library.MLog;
import com.ujuit.qbquickdev.Constants;
import cz.msebera.android.httpclient.Header;
import org.json.JSONException;
import org.json.JSONObject;


/**
 * 处理网络请求结果
 *
 * @author Administrator
 */
public abstract class BaseResponseHandler extends TextHttpResponseHandler {


    @Override
    public void onFailure(final int statusCode, Header[] headers, String responseString, Throwable throwable) {
        try {

            MLog.e("网络请求失败" + getRequestURI().toURL(), statusCode + responseString + "\n" + throwable.getMessage());

            if (statusCode > 400) {
                onFailure(ws_code.FAIL, "接口异常" + statusCode);
            } else {
                onFailure(ws_code.SLOWNET, Constants.Tip.SLOW_NET);
            }
        } catch (Exception e) {
        }

    }

    @Override
    public void onSuccess(int statusCode, Header[] headers, String responseString) {
        try {

            MLog.d("网络请求结果 : " + getRequestURI().toURL(), "\n" + responseString);

            JSONObject obj;
            try {
                obj = new JSONObject(responseString);

                ws_code code = ws_code.parse(JSONUtils.getInt(obj, "code", -2));
                final String data = JSONUtils.getString(obj, "data", "");
                String message = JSONUtils.getString(obj, "message", "");
                if (code == ws_code.SUCCESS) {
                    onSuccess(data);
                } else {
                    onFailure(code, message);
                }
            } catch (JSONException e) {

                e.printStackTrace();
                onFailure(ws_code.JSONERROR, "解析异常");
            }
        } catch (Exception e) {

        }
    }


    public abstract void onSuccess(String data);

    public abstract void onFailure(ws_code code, String message);

    /**
     * 处理异常
     *
     * @param context
     * @param code
     * @param message
     */
    public void handlerError(Context context, ws_code code, String message, boolean showToast) {
        try {

            if (code == ws_code.NOLOGIN) {
                // 登录去
                QAppManager.getAppManager().finishAllActivity();

//                if (context instanceof Activity) {
//                    ((Activity) context).startActivity(new Intent(context, LoginActivity.class));
//                }
                T.showShort(context, "请重新登录");
            } else {
                if (showToast) {
                    if (!StringUtils.isEmpty(message))
                        T.showShort(context, message);
                }
            }

        } catch (Exception e) {

        }

    }

}
