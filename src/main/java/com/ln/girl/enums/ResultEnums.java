package com.ln.girl.enums;

public enum ResultEnums {
    UNKNOW_ERROR(-1, "未知错误"),
    SUCCESS(200, "成功"),
    PRIMARY_SCHOOL(100, "你还在上小学"),
    MIDDLE_SCHOOL(101, "你还在上初中"),
    ADD_ERROR(103, "添加出错"),
    ;
    private Integer code;
    private String msg;

    ResultEnums(Integer code, String msg){
        this.code = code;
        this.msg = msg;
    }
    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
