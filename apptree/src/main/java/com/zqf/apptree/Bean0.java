package com.zqf.apptree;

import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 * -----------------------------
 * Created by zqf on 2018/3/27.
 * ---------------------------
 */

public class Bean0 implements MultiItemEntity {
    @Override
    public int getItemType() {
        return 0;
    }

    private String str;

    public Bean0(String str) {
        this.str = str;
    }

    public String getStr() {
        return str;
    }
}
