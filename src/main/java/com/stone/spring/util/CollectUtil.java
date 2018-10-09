package com.stone.spring.util;


import java.util.List;

/**
 * Created by jisj on 2018/8/11.
 */
public class CollectUtil {
    public static boolean isCollectEmpty(List users) {
        return users == null || users.size() == 0;
    }
}
