package xyz.klausturbo.easyspring.beans;

import xyz.klausturbo.easyspring.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * TODO .
 * @author <a href="mailto:guyue375@outlook.com">Klaus.turbo</a>
 * @program easy-spring
 **/
public class CatServiceBeforeAdvise implements MethodBeforeAdvice {
    
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("拦截方法：" + method.getName());
    }
}
