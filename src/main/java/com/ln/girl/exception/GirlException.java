package com.ln.girl.exception;

import com.ln.girl.enums.ResultEnums;

/**
 * 自定义异常
 */
public class GirlException extends RuntimeException {
    private Integer code;

    public GirlException(ResultEnums resultEnums) {
        super(resultEnums.getMsg());
        this.code = resultEnums.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
