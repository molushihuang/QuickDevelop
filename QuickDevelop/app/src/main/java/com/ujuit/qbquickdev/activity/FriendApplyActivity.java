package com.ujuit.qbquickdev.activity;

import android.os.Bundle;
import butterknife.Bind;
import butterknife.OnClick;
import com.anthole.quickdev.commonUtils.jsonUtils.JSONUtils;
import com.anthole.quickdev.http.RequestParams;
import com.anthole.quickdev.invoke.SystemBarTintInvoke;
import com.anthole.quickdev.ui.RequestHelper.base.IParser;
import com.ujuit.qbquickdev.R;
import com.ujuit.qbquickdev.activity.base.BaseActivity;
import com.ujuit.qbquickdev.adapter.FriendApplyAdapter;
import com.ujuit.qbquickdev.bean.FriendApplyBean;
import com.ujuit.qbquickdev.http.AbstractRequest;
import com.ujuit.qbquickdev.view.PtrMaterialFrameLayout;
import com.ujuit.qbquickdev.view.requestHelper.PullListHelper;
import com.ujuit.qbquickdev.view.xlist.XListView;

import java.util.List;


/**
 * 好友申请页面
 */
public class FriendApplyActivity extends BaseActivity implements FriendApplyAdapter.ItemListener {

    @Bind(R.id.ptr)
    PtrMaterialFrameLayout ptr;
    @Bind(R.id.xlistview)
    XListView xlistview;

    FriendApplyAdapter adapter;
    PullListHelper<FriendApplyBean> helper;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_friend_apply;
    }

    @Override
    protected void initData(Bundle savedInstanceState) {
        SystemBarTintInvoke.apply(this, R.color.titlebar_bg_black, true);

        adapter = new FriendApplyAdapter(this, this);
        helper = new PullListHelper<>(this, true);
        helper.setPtr(ptr);
        helper.setXListView(xlistview, adapter);
        helper.setDataSource(new AbstractRequest(this) {

            @Override
            public String getRelativeUrl() {
                return "/api/message/getFriendsList2.check";
            }

            @Override
            public RequestParams getParams() {
                RequestParams params = new RequestParams();

                return params;
            }
        });
        helper.setParser(new IParser<FriendApplyBean>() {

            @Override
            public List<FriendApplyBean> parseList(String data) {

                String subData = JSONUtils.getString(data, "list", "");

                return null;
            }
        });
        helper.refresh(200);

    }


    @OnClick(R.id.ibtn_left)
    public void close() {
        finish();
    }


    @Override
    public void onItemClick(FriendApplyBean item) {


    }


}
