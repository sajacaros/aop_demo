package com.bnpinnovation.aop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Slf4j
public class ArgumentLogAspect {
    @Around(value = "@annotation(argumentLog)")
    public Object argument(ProceedingJoinPoint joinPoint, ArgumentLog argumentLog) throws Throwable {

        if(joinPoint.getArgs().length != 1) {
            // TODO: 2020-04-08
            throw new RuntimeException("syntax error, argument is only 1");
        }
        log.info("type : {}", argumentLog.dummy());
        Object argument = joinPoint.getArgs()[0];
        if(argument instanceof String) {
            String arg = (String) argument;
            log.info("arg : {}", arg);
        } else if(argument instanceof List){ // multi
            List<String> args = (List<String>) argument;
            log.info("args : {}", args);
        }
        return joinPoint.proceed();
    }
}
