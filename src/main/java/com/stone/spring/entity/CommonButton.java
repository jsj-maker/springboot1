package com.stone.spring.entity;

/**
 * Created by jisj on 2018/9/2.
 */
public class CommonButton extends Button{

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    private String type;//菜单类型
    private String key;//key值
}
