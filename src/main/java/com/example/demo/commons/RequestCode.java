package com.example.demo.commons;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/11/16.
 */
public class RequestCode {
    public static final String REQUEST_SUCCESSS = "00";

    public static final Map<String, String> RequestCode = new HashMap<String, String>();
    static {
        RequestCode.put("00", "请求成功");
    }

}
