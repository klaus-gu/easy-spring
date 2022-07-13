package xyz.klausturbo.easyspring.aop.framework.autoproxy;

import org.aopalliance.aop.Advice;
import org.aopalliance.intercept.MethodInterceptor;
import xyz.klausturbo.easyspring.aop.AdvisedSupport;
import xyz.klausturbo.easyspring.aop.Advisor;
import xyz.klausturbo.easyspring.aop.ClassFilter;
import xyz.klausturbo.easyspring.aop.Pointcut;
import xyz.klausturbo.easyspring.aop.TargetSource;
import xyz.klausturbo.easyspring.aop.aspectj.AspectJExpressionPointcutAdvisor;
import xyz.klausturbo.easyspring.aop.framework.ProxyFactory;
import xyz.klausturbo.easyspring.beans.BeanFactory;
import xyz.klausturbo.easyspring.beans.BeansException;
import xyz.klausturbo.easyspring.beans.factory.BeanFactoryAware;
import xyz.klausturbo.easyspring.beans.factory.config.InstantiationAwareBeanPostProcessor;
import xyz.klausturbo.easyspring.beans.factory.support.DefaultListableBeanFactory;

import java.util.Collection;

/**
 * TODO .
 * @author <a href="mailto:guyue375@outlook.com">Klaus.turbo</a>
 * @program easy-spring
 **/
public class DefaultAdvisorAutoProxyCreator implements InstantiationAwareBeanPostProcessor, BeanFactoryAware {
    
    private DefaultListableBeanFactory beanFactory;
    
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = (DefaultListableBeanFactory) beanFactory;
    }
    
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
    
    private boolean isInfrastructureClass(Class<?> beanClass) {
        return Advice.class.isAssignableFrom(beanClass) || Pointcut.class.isAssignableFrom(beanClass) || Advisor.class
                .isAssignableFrom(beanClass);
    }
    
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
    
    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        
        if (isInfrastructureClass(beanClass)) {
            return null;
        }
        
        Collection<AspectJExpressionPointcutAdvisor> advisors = beanFactory
                .getBeansOfType(AspectJExpressionPointcutAdvisor.class).values();
        
        for (AspectJExpressionPointcutAdvisor advisor : advisors) {
            ClassFilter classFilter = advisor.getPointcut().getClassFilter();
            if (!classFilter.matches(beanClass)) {
                continue;
            }
            
            AdvisedSupport advisedSupport = new AdvisedSupport();
            
            TargetSource targetSource = null;
            try {
                targetSource = new TargetSource(beanClass.getDeclaredConstructor().newInstance());
            } catch (Exception e) {
                e.printStackTrace();
            }
            advisedSupport.setTargetSource(targetSource);
            advisedSupport.setMethodInterceptor((MethodInterceptor) advisor.getAdvice());
            advisedSupport.setMethodMatcher(advisor.getPointcut().getMethodMatcher());
            advisedSupport.setProxyTargetClass(false);
            
            return new ProxyFactory(advisedSupport).getProxy();
            
        }
        
        return null;
    }
}
