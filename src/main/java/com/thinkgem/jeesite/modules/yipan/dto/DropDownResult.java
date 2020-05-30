package com.thinkgem.jeesite.modules.yipan.dto;

import java.io.Serializable;

/*
* 下拉框封装类
* */
public class DropDownResult implements Serializable {

    private String id;

    private String text;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
