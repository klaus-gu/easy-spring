package xyz.klausturbo.easyspring.beans.factory.config;

import xyz.klausturbo.easyspring.beans.BeansException;

/**
 * 用于修改新实例化的Bean对象 .
 * @author <a href="mailto:guyue375@outlook.com">Klaus.turbo</a>
 * @program easy-spring
 **/
public interface BeanPostProcessor {
    
    Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException;
    
    Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException;
}
