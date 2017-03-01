package com.dortmund.westfalen.love;

import java.io.Serializable;

/**
 * Created by timzhou on 17/2/27.
 */
public class Result<T> implements Serializable {

    private static final long serialVersionUID = -7998498437572441967L;

    private boolean success = false;
    private Integer totalCount;
    private T result;
    private String errorCode;
    private String errorMessage;

    public Result() {
    }

    public Result(boolean success, T result, String errorCode, String errorMessage) {
        this.success = success;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.result = result;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public void addResultMessage(String errorCode, String errorMessage) {
        this.success = false;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public void addCustomMessage(String errorMessage) {
        this.success = false;
        this.errorCode = "Custom Error";
        this.errorMessage = errorMessage;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }
}

