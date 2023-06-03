package Lab4.advice.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
public @interface ExecutionTime {
}