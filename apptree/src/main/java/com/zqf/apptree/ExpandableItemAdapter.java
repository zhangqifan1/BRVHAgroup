package com.zqf.apptree;

import android.util.Log;
import android.view.View;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.util.List;

public class ExpandableItemAdapter extends BaseMultiItemQuickAdapter<MultiItemEntity, BaseViewHolder> {

    public static final int TYPE_LEVEL_0 = 0;
    public static final int TYPE_LEVEL_1 = 1;
    public static final int TYPE_PERSON = 2;

    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public ExpandableItemAdapter(List<MultiItemEntity> data) {
        super(data);
        addItemType(TYPE_LEVEL_0, R.layout.item0);
        addItemType(TYPE_LEVEL_1, R.layout.item1);
        addItemType(TYPE_PERSON, R.layout.item2);
    }


    @Override
    protected void convert(final BaseViewHolder holder, final MultiItemEntity item) {
        switch (holder.getItemViewType()) {
            case TYPE_LEVEL_0:
                Bean0 bean0 = (Bean0) item;
                holder.setText(R.id.tv0,bean0.getStr());
                break;
            case TYPE_LEVEL_1:
                Bean1 bean1 = (Bean1) item;
                holder.setText(R.id.tv1,bean1.getStr());
                break;
            case TYPE_PERSON:
                Bean2 bean2 = (Bean2) item;
                holder.setText(R.id.tv2,bean2.getStr());
                break;
        }
    }
}