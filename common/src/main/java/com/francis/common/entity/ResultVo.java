package com.francis.common.entity;

import lombok.Data;

/**
 * @author: francis
 * @description:
 * @date: 2021/1/14 23:00
 */
@Data
public class ResultVo<T> {
    private static final int CODE_SUCCESS = 0;
    private static final int CODE_FAILED = 1;
    private static final String MESSAGE_SUCCESS = "success";

    private int code;
    private String message;
    private T data;

    public ResultVo() {}

    public ResultVo(int code, String message) {
        this(code, message, null);
    }

    public ResultVo(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public ResultVo success(T data) {
        this.code = CODE_SUCCESS;
        this.message = MESSAGE_SUCCESS;
        this.data = data;
        return this;
    }

    public ResultVo failed(String message) {
        this.code = CODE_FAILED;
        this.message = message;
        this.data = null;
        return this;
    }
}
