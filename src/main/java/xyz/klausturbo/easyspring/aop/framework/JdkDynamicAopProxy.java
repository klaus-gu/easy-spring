package xyz.klausturbo.easyspring.aop.framework;

import org.aopalliance.intercept.MethodInterceptor;
import xyz.klausturbo.easyspring.aop.AdvisedSupport;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * TODO .
 * @author <a href="mailto:guyue375@outlook.com">Klaus.turbo</a>
 * @program easy-spring
 **/
public class JdkDynamicAopProxy implements AopProxy, InvocationHandler {
    
    private final AdvisedSupport adviced;
    
    public JdkDynamicAopProxy(AdvisedSupport adviced) {
        this.adviced = adviced;
    }
    
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (adviced.getMethodMatcher().matches(method, adviced.getTargetSource().getTarget().getClass())) {
            MethodInterceptor methodInterceptor = adviced.getMethodInterceptor();
            return methodInterceptor
                    .invoke(new ReflectiveMethodInvocation(adviced.getTargetSource().getTarget(), method, args));
        }
        return method.invoke(adviced.getTargetSource().getTarget(), args);
    }
    
    @Override
    public Object getProxy() {
        return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
                adviced.getTargetSource().getTargetClass(), this);
    }
}
