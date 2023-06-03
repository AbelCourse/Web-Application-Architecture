package Lab4.advice;

import Lab4.domain.Logger;
import Lab4.repositotry.LoggerRepo;
import jakarta.transaction.Transactional;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;

@Component
@Aspect
@Transactional
public class LoggerAdvice {

    @Autowired
    LoggerRepo loggerRepo;

    @After("execution( * Lab4.controller.UserController.*(..))")
    public void logAfter(JoinPoint joinPoint) {
        //System.err.println("Log after the method: " + joinPoint.getSignature().getName());
        Object[] signatureArgs = joinPoint.getArgs();
        //System.err.println(Arrays.stream(signatureArgs).toList());
        Logger log = new Logger(LocalDate.now(), LocalTime.now(),joinPoint.getSignature().getName(), joinPoint.getArgs().toString());
        loggerRepo.save(log);
    }
    @AfterThrowing("execution( * Lab4.controller.UserController.*(..))")
    public void logAfterException(JoinPoint joinPoint) {
        System.err.println("Log Exception method: " + joinPoint.getSignature().getName());
        System.err.println(joinPoint.getArgs());
        Logger log = new Logger(LocalDate.now(), LocalTime.now(),joinPoint.getSignature().getName(), joinPoint.getArgs().toString());
        loggerRepo.save(log);
    }
}
