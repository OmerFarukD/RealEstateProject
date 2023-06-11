package com.qubitfaruk.realestateproject.AOP.CrossCuttingConcerns.Logging.Aspect;

import com.qubitfaruk.realestateproject.AOP.CrossCuttingConcerns.Logging.LogDetails;
import com.qubitfaruk.realestateproject.AOP.CrossCuttingConcerns.Logging.LoggerRepository;
import com.qubitfaruk.realestateproject.Core.Results.Result;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.time.LocalDate;



@Aspect
@Component
public class LoggerToDbAspect {

private final LoggerRepository loggerRepository;

    public LoggerToDbAspect(LoggerRepository loggerRepository) {
        this.loggerRepository = loggerRepository;
    }

    @Pointcut("@annotation(com.qubitfaruk.realestateproject.AOP.Attributes.Logging.LogDb.LoggerToDb)")
    public void callAtLogMethodToDB() {}

    @AfterReturning(value = "callAtLogMethodToDB()",returning = "result")
    public void logToDb(JoinPoint point, Result result) {
        String methodName = point.getSignature().getName();
        Object[] args=point.getArgs();
        String params="";
        if (args.length>0){
            StringBuilder paramsBuilder= new StringBuilder();
            for (Object arg : args) {
                paramsBuilder.append(arg.getClass().getSimpleName())
                        .append(":{");
                Field[] fields=arg.getClass().getDeclaredFields();
                for (Field field : fields) {
                    field.setAccessible(true);
                    try{
                        paramsBuilder.append(field.getName())
                                .append(":")
                                .append(field.get(arg).toString())
                                .append(", ");
                    }catch (IllegalAccessException e){
                        e.printStackTrace();
                    }
                }
                paramsBuilder.setLength(paramsBuilder.length()-2);
                paramsBuilder.append("}, ");
            }
            paramsBuilder.setLength(paramsBuilder.length()-2);
            params=paramsBuilder.toString();
        }
        LogDetails logDetails = new LogDetails();
        logDetails.setMethodName(methodName);
        logDetails.setParameters(params);
        logDetails.setLogDate(LocalDate.now());
        logDetails.setReturnValue(result.getMessage());
        loggerRepository.save(logDetails);
    }
}
