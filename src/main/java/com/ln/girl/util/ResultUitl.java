package com.ln.girl.util;

import com.ln.girl.entity.Result;
import com.ln.girl.enums.ResultEnums;

/**
 * 返回对象工具类
 */
public class ResultUitl {

    public static Result success(Object object) {
        Result result = new Result();
        result.setCode(ResultEnums.SUCCESS.getCode());
        result.setMsg(ResultEnums.SUCCESS.getMsg());
        result.setData(object);
        return result;
    }

    public static Result success() {
        return success(null);
    }

    public static Result error(Integer code, String msg) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
