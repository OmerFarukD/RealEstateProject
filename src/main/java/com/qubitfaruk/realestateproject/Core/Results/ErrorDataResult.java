package com.qubitfaruk.realestateproject.Core.Results;

public class ErrorDataResult<T>extends DataResult<T> {
    public ErrorDataResult(T data, String message) {
        super(data, message, false);
    }

    public ErrorDataResult(T data) {
        super(data, false);
    }
    public ErrorDataResult(String message) {
        super(message, false);
    }
    public ErrorDataResult() {
        super(false);
    }
}
