package com.ouyang.scorerank.validator;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName ValidationResult
 * @Description TODO
 * @Author ouyang
 * @Data 2020-01-31 17:46
 * @Version 1.0
 **/

public class ValidationResult {

    private boolean hasErrors = false;

    private Map<String, String> errMsgMap = new HashMap<>();

    public String getErrorMsg(){
        return StringUtils.join(errMsgMap.values().toArray(), ",");
    }

    public boolean isHasErrors(){
        return hasErrors;
    }

    public void setHasErrors(boolean hasErrors){
        this.hasErrors = hasErrors;
    }

    public Map<String, String> gerErrMsgMap(){
        return errMsgMap;
    }

    public void setErrMsgMap(Map<String, String> errMsgMap){
        this.errMsgMap = errMsgMap;
    }

}
