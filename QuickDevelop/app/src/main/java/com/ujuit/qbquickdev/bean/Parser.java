package com.ujuit.qbquickdev.bean;

import com.anthole.quickdev.commonUtils.jsonUtils.JsonUtil;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pherson on 2017-5-2.
 */

public class Parser {

    /**
     * 解析新朋友申请列表
     *
     * @param data
     * @return
     */
    public static List<FriendApplyBean> parseFriendApplyList(String data) {
        List<FriendApplyBean> list = null;
        list = JsonUtil.getListFromJson(data, new TypeToken<ArrayList<FriendApplyBean>>() {
        });
        return list == null ? new ArrayList<FriendApplyBean>() : list;

    }
}
