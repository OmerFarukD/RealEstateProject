package com.qubitfaruk.realestateproject.Core.Results;

public class SuccessResult extends Result{
    public SuccessResult(String message) {
        super(message, true);
    }

    public SuccessResult() {
        super(true);
    }

}
