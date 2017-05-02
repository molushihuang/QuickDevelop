package com.ujuit.qbquickdev.activity;

import android.os.Bundle;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.OnClick;
import com.anthole.quickdev.invoke.SystemBarTintInvoke;
import com.ujuit.qbquickdev.R;
import com.ujuit.qbquickdev.activity.base.BaseActivity;

public class MainActivity extends BaseActivity {

    @Bind(R.id.tv_hello)
    TextView tvHello;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initData(Bundle savedInstanceState) {
        SystemBarTintInvoke.apply(this, R.color.titlebar_bg_black, true);


    }

    @OnClick(R.id.tv_hello)
    public void toFreind(){
        jump2Activity(FriendApplyActivity.class);

    }
}
