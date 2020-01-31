package com.ouyang.scorerank.response;

/**
 * @ClassName CommonReturnType
 * @Description TODO
 * @Author ouyang
 * @Data 2020-01-30 14:50
 * @Version 1.0
 **/

/**
 * Return object used by controller
 * */

public class CommonReturnType {

    /**
     * Return status: success OR fail
     * */
    private String status;

    /**
     * If the status is success, the data should return the json data that the frontend needs
     * If the status is fail, the data should return common error
     * */
    private Object data;

    public static CommonReturnType create(Object result){
        return CommonReturnType.create(result, "success");
    }

    public static CommonReturnType create(Object result, String status){
        CommonReturnType commonReturnType = new CommonReturnType();
        commonReturnType.setStatus(status);
        commonReturnType.setData(result);
        return commonReturnType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
