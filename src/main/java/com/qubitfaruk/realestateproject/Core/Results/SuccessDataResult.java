package com.qubitfaruk.realestateproject.Core.Results;

public class SuccessDataResult<T> extends  DataResult<T> {
    public SuccessDataResult(T data, String message) {
        super(data, message, true);
    }

    public SuccessDataResult(T data) {
        super(data, true);
    }

    public SuccessDataResult(String message) {
        super(message, true);
    }

    public SuccessDataResult() {
        super(true);
    }
}
