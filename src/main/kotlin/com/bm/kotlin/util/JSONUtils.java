package com.bm.kotlin.util;

import com.alibaba.fastjson.JSON;

public class JSONUtils {
    public static String toJsonString(Object o) {
        return JSON.toJSONString(o);
    }
}
