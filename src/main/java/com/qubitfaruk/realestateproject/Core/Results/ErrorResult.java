package com.qubitfaruk.realestateproject.Core.Results;

public class ErrorResult extends Result{
    public ErrorResult(String message) {
        super(message, false);
    }

    public ErrorResult() {
        super(false);
    }
}
