package xyz.klausturbo.easyspring.aop.framework;

import xyz.klausturbo.easyspring.aop.AdvisedSupport;

/**
 * TODO .
 * @author <a href="mailto:guyue375@outlook.com">Klaus.turbo</a>
 * @program easy-spring
 **/
public class ProxyFactory {
    
    private AdvisedSupport advisedSupport;
    
    public ProxyFactory(AdvisedSupport advisedSupport) {
        this.advisedSupport = advisedSupport;
    }
    
    public Object getProxy() {
        return createAopProxy().getProxy();
    }
    
    private AopProxy createAopProxy() {
        if (advisedSupport.isProxyTargetClass()) {
            return new Cglib2AopProxy(advisedSupport);
        }
        return new JdkDynamicAopProxy(advisedSupport);
    }
}
