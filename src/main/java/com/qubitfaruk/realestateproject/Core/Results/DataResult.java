package com.qubitfaruk.realestateproject.Core.Results;

import lombok.Data;


public class DataResult <T> extends Result{
   private T data;

    public DataResult(T data,String message, boolean isSuccess ) {
        super(message, isSuccess);
        this.data = data;
    }

    public DataResult(T data,boolean isSuccess) {
        super(isSuccess);
        this.data = data;
    }

    public DataResult(String message, boolean isSuccess) {
        super(message, isSuccess);
    }

    public DataResult(boolean isSuccess) {
        super(isSuccess);
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
