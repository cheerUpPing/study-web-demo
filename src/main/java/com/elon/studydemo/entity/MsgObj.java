package com.elon.studydemo.entity;

import java.io.Serializable;

public class MsgObj implements Serializable {

    private int code = 0;

    private String errMsg = "成功";

    private Object data;

    public MsgObj() {

    }

    public MsgObj(String errMsg) {
        this.errMsg = errMsg;
    }

    public MsgObj(Object data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
