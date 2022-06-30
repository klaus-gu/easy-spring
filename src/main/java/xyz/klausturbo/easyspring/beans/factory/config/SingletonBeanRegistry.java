package xyz.klausturbo.easyspring.beans.factory.config;

/**
 * TODO .
 * @author <a href="mailto:guyue375@outlook.com">Klaus.turbo</a>
 * @program easy-spring
 **/
public interface SingletonBeanRegistry {
    
    Object getSingleton(String beanName);
}
