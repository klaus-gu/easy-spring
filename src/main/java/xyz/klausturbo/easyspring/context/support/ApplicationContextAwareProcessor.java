package xyz.klausturbo.easyspring.context.support;

import xyz.klausturbo.easyspring.beans.BeansException;
import xyz.klausturbo.easyspring.beans.factory.config.BeanPostProcessor;
import xyz.klausturbo.easyspring.context.ApplicationContext;
import xyz.klausturbo.easyspring.context.ApplicationContextAware;

/**
 * TODO .
 * @author <a href="mailto:guyue375@outlook.com">Klaus.turbo</a>
 * @program easy-spring
 **/
public class ApplicationContextAwareProcessor implements BeanPostProcessor {
    
    private final ApplicationContext applicationContext;
    
    public ApplicationContextAwareProcessor(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }
    
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof ApplicationContext) {
            ((ApplicationContextAware) bean).setApplicationContext(applicationContext);
        }
        return bean;
    }
    
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
