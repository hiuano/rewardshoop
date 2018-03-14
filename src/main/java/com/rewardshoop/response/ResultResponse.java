package com.rewardshoop.response;

import java.util.List;

public class ResultResponse {
    private boolean state;
    private String errMsg;
    private Object obj;

    public ResultResponse(boolean state, Object obj) {
        this.state = state;
        this.obj = obj;
    }


    public ResultResponse(boolean state) {
        this.state = state;
    }

    public ResultResponse(boolean state, String errMsg) {
        this.state = state;
        this.errMsg = errMsg;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }
}
