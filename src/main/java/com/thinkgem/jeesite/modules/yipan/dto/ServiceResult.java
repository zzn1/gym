package com.thinkgem.jeesite.modules.yipan.dto;

import java.io.Serializable;

/**
 * @ClassName: ServiceResult
 * @Description: TODO
 * @Author: Zhang Zhaonian
 * @date: 2020/5/26 23:05
 */
public class ServiceResult<T> implements Serializable {

    private boolean success = false;

    private Integer errors;

    private String message;

    private T result;

    public ServiceResult() {
    }

    public static <T> ServiceResult<T> success(T result) {
        ServiceResult<T> item = new ServiceResult<T>();
        item.success = true;
        item.result = result;
        item.errors = 0;
        item.message = "success";
        return item;
    }

    public static <T> ServiceResult<T> success() {
        ServiceResult<T> item = new ServiceResult<T>();
        item.success = true;
        item.errors = 0;
        item.message = "success";
        return item;
    }

    public static <T> ServiceResult<T> failure(String errorMessage, Integer errorCode) {
        ServiceResult<T> item = new ServiceResult<T>();
        item.success = false;
        item.errors = errorCode;
        item.message = errorMessage;
        return item;
    }

    public static <T> ServiceResult<T> failure(Integer errorCode) {
        ServiceResult<T> item = new ServiceResult<T>();
        item.success = false;
        item.errors = errorCode;
        item.message = "failure";
        return item;
    }

    public static <T> ServiceResult<T> failure(String message) {
        ServiceResult<T> item = new ServiceResult<T>();
        item.success = false;
        item.errors = 1;
        item.message = message;
        return item;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Integer getErrors() {
        return errors;
    }

    public void setErrors(Integer errors) {
        this.errors = errors;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
