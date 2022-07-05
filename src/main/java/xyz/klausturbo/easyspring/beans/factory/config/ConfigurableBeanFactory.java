package xyz.klausturbo.easyspring.beans.factory.config;

import xyz.klausturbo.easyspring.beans.factory.HierarchicalBeanFactory;

/**
 * 可用于配置的 BeanFactory .
 * @author <a href="mailto:guyue375@outlook.com">Klaus.turbo</a>
 * @program easy-spring
 **/
public interface ConfigurableBeanFactory extends HierarchicalBeanFactory, SingletonBeanRegistry {
    
    String SCOPE_SINGLETON = "singleton";
    
    String SCOPE_PROTOTYPE = "prototype";
    
    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);
}
