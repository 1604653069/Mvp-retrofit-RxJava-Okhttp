package com.retrofit.api;

import com.google.gson.annotations.SerializedName;

public class HttpStatus {
    @SerializedName("code")
    private int code;
    @SerializedName("msg")
    private String msg;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return msg;
    }

    /**
     * API是否请求失败
     *
     * @return 失败返回true, 成功返回false
     */
    public boolean isCodeInvalid() {
        return code != 0;
    }
}
