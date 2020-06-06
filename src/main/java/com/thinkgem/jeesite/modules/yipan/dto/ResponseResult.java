package com.thinkgem.jeesite.modules.yipan.dto;

import java.io.Serializable;

public class ResponseResult implements Serializable {

    private String code;

    private String message;

    private String beans;

    public String getBeans() {
        return beans;
    }

    public void setBeans(String beans) {
        this.beans = beans;
    }

    public  static  ResponseResult success(){
        ResponseResult responseResult = new ResponseResult();
        responseResult.code = "success";
        return responseResult;
    }

    public  static  ResponseResult success(String message){
        ResponseResult responseResult = new ResponseResult();
        responseResult.code = "success";
        responseResult.message = message;
        return responseResult;
    }
    public  static  ResponseResult success(String message,String beans){
        ResponseResult responseResult = new ResponseResult();
        responseResult.code = "success";
        responseResult.message = message;
        responseResult.beans = beans;
        return responseResult;
    }
    public  static  ResponseResult error(){
        ResponseResult responseResult = new ResponseResult();
        responseResult.code = "error";
        return responseResult;
    }
    public  static  ResponseResult error(String message){
        ResponseResult responseResult = new ResponseResult();
        responseResult.code = "error";
        responseResult.message = message;
        return responseResult;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
