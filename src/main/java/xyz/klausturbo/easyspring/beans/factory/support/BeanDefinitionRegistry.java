package xyz.klausturbo.easyspring.beans.factory.support;

import xyz.klausturbo.easyspring.beans.factory.config.BeanDefinition;

/**
 * TODO .
 * @author <a href="mailto:guyue375@outlook.com">Klaus.turbo</a>
 * @program easy-spring
 **/
public interface BeanDefinitionRegistry {
    
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
}
