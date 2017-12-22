package com.example.demo.commons;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/11/16.
 */
public class JsonResult<T> implements Serializable{
    private String code;
    private String message;
    private T result;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
    //初始构造参数
    public JsonResult() {
        super();
        this.code = RequestCode.REQUEST_SUCCESSS;
        this.message = RequestCode.RequestCode.get(this.code);
    }

    public void setResultCode( String code ){
        this.code = code;
        this.message = RequestCode.RequestCode.get(code);
    }
}
