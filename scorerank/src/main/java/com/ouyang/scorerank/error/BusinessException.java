package com.ouyang.scorerank.error;

/**
 * @ClassName BusinessException
 * @Description TODO
 * @Author ouyang
 * @Data 2020-01-30 14:45
 * @Version 1.0
 **/

public class BusinessException extends Exception implements CommonError {


    private CommonError commonError;

    /**
    * construct the common error object
    */
    public BusinessException(CommonError commonError){
        super();
        this.commonError = commonError;
    }

    /**
     * construct the common error using self-defined error message
     * */
    public BusinessException(CommonError commonError, String errMsg){
        super();
        this.commonError = commonError;
        this.commonError.setErrMsg(errMsg);
    }

    @Override
    public int getErrCode() {
        return this.commonError.getErrCode();
    }

    @Override
    public String getErrMsg() {
        return this.commonError.getErrMsg();
    }

    @Override
    public CommonError setErrMsg(String errMsg) {
        this.commonError.setErrMsg(errMsg);
        return this;
    }
}
