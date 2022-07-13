package xyz.klausturbo.easyspring.beans.factory;

import xyz.klausturbo.easyspring.beans.BeansException;

/**
 * 工厂Bean .
 * @author <a href="mailto:guyue375@outlook.com">Klaus.turbo</a>
 * @program easy-spring
 **/
public interface FactoryBean<T> {
    
    T getObject() throws BeansException;
    
    Class<?> getObjectType();
    
    boolean isSingleton();
}
