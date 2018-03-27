package com.zqf.brvhagroup;

import com.chad.library.adapter.base.entity.SectionEntity;

public class MySection extends SectionEntity<Bean> {

    private String iamgeUrl;
    public MySection(boolean isHeader, String header,String iamgeUrl) {
        super(isHeader, header);
        this.iamgeUrl=iamgeUrl;
    }

    public MySection(Bean bean) {
        super(bean);
    }

    public String iamgeUrl(){
        return iamgeUrl;
    }
}

