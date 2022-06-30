package xyz.klausturbo.easyspring.beans.factory.support;

import xyz.klausturbo.easyspring.beans.factory.config.BeanDefinition;

/**
 * TODO .
 * @author <a href="mailto:guyue375@outlook.com">Klaus.turbo</a>
 * @program easy-spring
 **/
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {
    
    @Override
    protected Object createBean(String name, BeanDefinition beanDefinition) {
        Object bean = null;
        try {
            bean = beanDefinition.getBeanClass().newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        addSingleton(name, bean);
        return bean;
    }
}
