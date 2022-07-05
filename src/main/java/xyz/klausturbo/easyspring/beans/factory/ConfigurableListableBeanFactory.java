package xyz.klausturbo.easyspring.beans.factory;

import xyz.klausturbo.easyspring.beans.BeansException;
import xyz.klausturbo.easyspring.beans.factory.config.AutowireCapableBeanFactory;
import xyz.klausturbo.easyspring.beans.factory.config.BeanDefinition;
import xyz.klausturbo.easyspring.beans.factory.config.BeanPostProcessor;
import xyz.klausturbo.easyspring.beans.factory.config.ConfigurableBeanFactory;

/**
 * .
 * @author <a href="mailto:guyue375@outlook.com">Klaus.turbo</a>
 * @program easy-spring
 **/
public interface ConfigurableListableBeanFactory
        extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory {
    
    BeanDefinition getBeanDefinition(String beanName) throws BeansException;
    
    void preInstantiateSingletons() throws BeansException;
    
    @Override
    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);
}
