package org.huke.oauth.cxf.security.server.domian;

import java.io.Serializable;

/**
 * @author huke
 * @create 2017/3/23
 */
public class Result<T> implements Serializable{

    public static final String CODE_SUCCESS = "0000";
    public static final String CODE_FAILURE = "9999";


    private static final long serialVersionUID = 6420929889389616396L;

    private T data;

    private String errorCode;   //错误

    private String errorMsg;    //错误描述

    public Result(T data, String errorCode, String errorMsg) {
        this.data = data;
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
