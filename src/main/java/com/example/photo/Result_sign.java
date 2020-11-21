package com.example.photo;

/**
 * 返回的操作结果标志和结果信息
 */
public class Result_sign {
    //返回状态码
    private String status;
    //返回信息
    private String msg;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
