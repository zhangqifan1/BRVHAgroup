package com.zqf.brvhagroup;

/**
 * -----------------------------
 * Created by zqf on 2018/3/27.
 * ---------------------------
 */

class Bean {
    String item;
    String head;

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public Bean(String item, String head) {
        this.item = item;
        this.head = head;
    }
}
