package com.qubitfaruk.realestateproject.AOP.Attributes.Logging.LogDb.Aspect;

import com.qubitfaruk.realestateproject.AOP.CrossCuttingConcerns.Logging.LoggerRepository;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggerToDbAspect {

private final LoggerRepository loggerRepository;

    public LoggerToDbAspect(LoggerRepository loggerRepository) {
        this.loggerRepository = loggerRepository;
    }

    
}
