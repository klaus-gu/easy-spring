package xyz.klausturbo.easyspring.beans.factory.config;

import xyz.klausturbo.easyspring.beans.BeansException;

/**
 * TODO .
 * @author <a href="mailto:guyue375@outlook.com">Klaus.turbo</a>
 * @program easy-spring
 **/
public interface InstantiationAwareBeanPostProcessor extends BeanPostProcessor {
    
    Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException;
    
}
