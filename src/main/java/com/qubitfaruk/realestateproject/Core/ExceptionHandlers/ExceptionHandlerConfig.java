package com.qubitfaruk.realestateproject.Core.ExceptionHandlers;
import com.qubitfaruk.realestateproject.Core.Exception.BusinessException;
import com.qubitfaruk.realestateproject.Core.Results.ErrorDataResult;
import com.qubitfaruk.realestateproject.Core.Results.ErrorResult;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.HashMap;
import java.util.Map;
@RestControllerAdvice
public class ExceptionHandlerConfig {
    @ExceptionHandler(BusinessException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResult handleBusinessException(BusinessException exception){
        return new ErrorResult(exception.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Map<String,String>> handleExceptionForField(MethodArgumentNotValidException exception){
        Map<String,String> validationErrors= new HashMap<>();
        ErrorDataResult<Map<String,String>> error= new ErrorDataResult<>(validationErrors,"validation rules");
        if (!exception.getFieldErrors().isEmpty()){
            for (FieldError fieldError : exception.getBindingResult().getFieldErrors()) {
                validationErrors.put(fieldError.getField(),fieldError.getDefaultMessage());
            }

        }
        if (!exception.getGlobalErrors().isEmpty()){
            for (ObjectError objectError: exception.getBindingResult().getGlobalErrors()){
                validationErrors.put(objectError.getObjectName(),objectError.getDefaultMessage());
            }
        }
        error.setData(validationErrors);
       return error;
    }
}
