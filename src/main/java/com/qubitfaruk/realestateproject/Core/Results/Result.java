package com.qubitfaruk.realestateproject.Core.Results;
public class Result {

    public Result(String message, boolean isSuccess) {
        this(isSuccess);
        this.message = message;
    }

    public Result(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    private String message;
    private boolean isSuccess;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }
}
