package xyz.klausturbo.easyspring.beans.factory.support;

import xyz.klausturbo.easyspring.beans.BeanFactory;
import xyz.klausturbo.easyspring.beans.factory.config.BeanDefinition;
import xyz.klausturbo.easyspring.beans.factory.config.DefaultSingletonBeanRegistry;

/**
 * TODO .
 * @author <a href="mailto:guyue375@outlook.com">Klaus.turbo</a>
 * @program easy-spring
 **/
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {
    
    @Override
    public Object getBean(String beanName) {
        Object bean = getSingleton(beanName);
        if (bean != null) {
            return bean;
        }
        BeanDefinition beanDefinition = getBeanDefinition(beanName);
        return createBean(beanName, beanDefinition);
    }
    
    protected abstract BeanDefinition getBeanDefinition(String name);
    
    protected abstract Object createBean(String name, BeanDefinition beanDefinition);
}
