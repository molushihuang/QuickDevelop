package com.ujuit.qbquickdev.adapter;

import android.content.Context;
import android.view.View;
import com.anthole.quickdev.adapter.BaseAdapterHelper;
import com.anthole.quickdev.adapter.QuickAdapter;
import com.ujuit.qbquickdev.R;
import com.ujuit.qbquickdev.bean.FriendApplyBean;

public class FriendApplyAdapter extends QuickAdapter<FriendApplyBean> {

    ItemListener mItemListener;

    public FriendApplyAdapter(Context context, ItemListener mItemListener) {
        super(context, R.layout.item_crm_team_apply);
        this.mItemListener = mItemListener;

    }

    @Override
    protected void convert(BaseAdapterHelper helper, final FriendApplyBean item) {

//        TextView applyStatus = helper.getView(R.id.tv_apply_status);
//
//        helper.setText(R.id.tv_username, item.getMemberName());

        helper.setOnClickListener(R.id.activate_layout, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mItemListener.onItemClick(item);
            }
        });


    }

    public static interface ItemListener {
        void onItemClick(FriendApplyBean item);


    }

}
