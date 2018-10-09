package com.stone.spring.util;


import java.util.List;
import java.util.Objects;

import com.stone.spring.entity.BaseEntity;


/**
 * Created by jisj on 2018/8/8.
 */
public class ResultUtil {
    public static BaseEntity getResultSuccess(String function_id,String message, boolean isSuccess) {

        BaseEntity entity = new BaseEntity();
        entity.code = isSuccess?0:-1;
        entity.function_id = function_id;
        entity.message = message;
        return entity;
    }

    public static BaseEntity getResultDataList(String function_id,String message, List<? extends Object> reports) {
        BaseEntity entity = new BaseEntity();
        entity.code = reports != null && reports.size() > 0 ?0:-1;
        entity.function_id = function_id;
        entity.data_list = reports;
        entity.message = message;
        return entity;

    }

    public static BaseEntity getResultData(String function_id, Object obj) {
        BaseEntity entity = new BaseEntity();
        entity.code = obj != null  ?0:-1;
        entity.function_id = function_id;
        entity.data = obj;
        return entity;
    }
}
