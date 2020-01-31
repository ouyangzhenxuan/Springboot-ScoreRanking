package com.ouyang.scorerank.error;

public enum EmbusinessError implements CommonError {
    PARAMETER_VALIDATION_ERROR(10001, "Parameter not validated"),
    UNKNOWN_ERROR(10002, "Error unknown")


    ;

    private int errCode;
    private String errMsg;

    private EmbusinessError(int errCode, String errMsg){
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    @Override
    public int getErrCode() {
        return this.errCode;
    }

    @Override
    public String getErrMsg() {
        return this.errMsg;
    }

    @Override
    public CommonError setErrMsg(String errMsg) {
        this.errMsg = errMsg;
        return this;
    }
}
