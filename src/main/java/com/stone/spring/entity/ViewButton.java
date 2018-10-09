package com.stone.spring.entity;

/**
 * Created by jisj on 2018/9/2.
 */
public class ViewButton extends Button {

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    private String type;//菜单类型
    private String url;//view路径值
}
