package Lab4.advice.annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExecutionTimeAspect {

    @Around("@annotation(Lab4.advice.annotation.ExecutionTime)")
    public Object calculateExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        var result = proceedingJoinPoint.proceed();
        long finish = System.currentTimeMillis();
        System.err.println(proceedingJoinPoint.getSignature().getName() + " takes : " + (finish - start) +" milliseconds");
        return result;
    }
}
