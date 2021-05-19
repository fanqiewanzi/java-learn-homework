package com.example.learn1;

import lombok.Getter;


public enum Response {
    ERROR(false,400,"操作失败"),SUCCESS(true,200,"操作成功"),INTERNAL(false,500,"内部错误");
    @Getter
    boolean ok;
    @Getter
    Integer code;
    @Getter
    private String message;
    Response(boolean ok, Integer code, String message)
    {
        this.ok=ok;
        this.code=code;
        this.message=message;
    }

}