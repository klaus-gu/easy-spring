package xyz.klausturbo.easyspring.aop.framework;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import xyz.klausturbo.easyspring.aop.AdvisedSupport;

import java.lang.reflect.Method;

/**
 * TODO .
 * @author <a href="mailto:guyue375@outlook.com">Klaus.turbo</a>
 * @program easy-spring
 **/
public class Cglib2AopProxy implements AopProxy {
    
    private final AdvisedSupport advisedSupport;
    
    public Cglib2AopProxy(AdvisedSupport advisedSupport) {
        this.advisedSupport = advisedSupport;
    }
    
    @Override
    public Object getProxy() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(advisedSupport.getTargetSource().getTarget().getClass());
        enhancer.setInterfaces(advisedSupport.getTargetSource().getTargetClass());
        enhancer.setCallback(new DynamicAdvicedInterceptor(advisedSupport));
        return enhancer.create();
    }
    
    private static class DynamicAdvicedInterceptor implements MethodInterceptor {
        
        private final AdvisedSupport adviced;
        
        public DynamicAdvicedInterceptor(AdvisedSupport adviced) {
            this.adviced = adviced;
        }
        
        @Override
        public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
            CglibMethodInvocation methodInvocation = new CglibMethodInvocation(adviced.getTargetSource().getTarget(),
                    method, objects, methodProxy);
            if (adviced.getMethodMatcher().matches(method, adviced.getTargetSource().getTarget().getClass())) {
                return adviced.getMethodInterceptor().invoke(methodInvocation);
            }
            return methodInvocation.proceed();
        }
    }
    
    private static class CglibMethodInvocation extends ReflectiveMethodInvocation {
        
        private final MethodProxy methodProxy;
        
        public CglibMethodInvocation(Object target, Method method, Object[] arguments, MethodProxy methodProxy) {
            super(target, method, arguments);
            this.methodProxy = methodProxy;
        }
        
        @Override
        public Object proceed() throws Throwable {
            return this.methodProxy.invoke(this.target, this.arguments);
        }
    }
}
