package xyz.klausturbo.easyspring.aop;

import java.lang.reflect.Method;

/**
 * TODO .
 * @author <a href="mailto:guyue375@outlook.com">Klaus.turbo</a>
 * @program easy-spring
 **/
public interface MethodBeforeAdvice extends BeforeAdvice {
    
    void before(Method method, Object[] args, Object target) throws Throwable;
}
