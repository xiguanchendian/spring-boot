package com.xgcd.springboot.bean;

public class RespBean4Swagger {

    private Integer status;
    private String msg;
    private Object obj;

    public static RespBean4Swagger build() {
        return new RespBean4Swagger();
    }

    private RespBean4Swagger() {

    }

    private RespBean4Swagger(Integer status, String msg, Object obj) {
        this.status = status;
        this.msg = msg;
        this.obj = obj;
    }

    public static RespBean4Swagger ok(String msg) {
        return new RespBean4Swagger(200, msg, null);
    }

    public static RespBean4Swagger ok(String msg, Object obj) {
        return new RespBean4Swagger(200, msg, obj);
    }

    public static RespBean4Swagger error(String msg) {
        return new RespBean4Swagger(500, msg, null);
    }

    public static RespBean4Swagger error(String msg, Object obj) {
        return new RespBean4Swagger(500, msg, obj);
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }
}
