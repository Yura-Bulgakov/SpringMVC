package org.example.springmvc.logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;


@Aspect
@Component
public class ServiceLoggingAspect {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Before("@annotation(ServiceLogging)")
    public void logServiceMethodBeforeExecution(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getTarget().getClass().getName();
        Object[] methodArgs = joinPoint.getArgs();
        logger.info("Старт метода {}.{} c параметрами {}", className, methodName,
                Arrays.toString(methodArgs));
    }

    @After("@annotation(ServiceLogging)")
    public void logServiceMethodExecution(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getTarget().getClass().getName();
        logger.info("Метод {}.{} выполнен", className, methodName);
    }

}
