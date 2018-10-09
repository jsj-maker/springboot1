package com.stone.spring.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by jisj on 7/26/16.
 */
public class BaseEntity implements Serializable {

    public BaseEntity(){
        code = -99;
    }

    public Object data;
    public List<? extends Object> data_list;
    public int code;
    public String function_id;
    public String message;
}
