package com.ouyang.scorerank.validator;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

/**
 * @ClassName ValidationImpl
 * @Description TODO
 * @Author ouyang
 * @Data 2020-01-31 17:46
 * @Version 1.0
 **/


@Component
public class ValidationImpl implements InitializingBean {

    private Validator validator;

    @Override
    public void afterPropertiesSet() throws Exception {
        this.validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    public ValidationResult validate(Object bean){
        final ValidationResult result = new ValidationResult();

        Set<ConstraintViolation<Object>> constraintViolationSet = validator.validate(bean);

        if(constraintViolationSet.size() > 0){
            // has errors
            result.setHasErrors(true);
            constraintViolationSet.forEach(constraintViolation->{
                String errMsg = constraintViolation.getMessage();
                String propertyName = constraintViolation.getPropertyPath().toString();
                result.gerErrMsgMap().put(propertyName, errMsg);
            });
        }

        return result;

    }
}
