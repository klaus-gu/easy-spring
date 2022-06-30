package xyz.klausturbo.easyspring.beans;

import xyz.klausturbo.easyspring.beans.factory.config.BeanDefinition;

/**
 * ${@link BeanFactory} 用于注册/获取一个 ${@link BeanDefinition}.
 * @author <a href="mailto:guyue375@outlook.com">Klaus.turbo</a>
 * @program easy-spring
 **/
@SuppressWarnings("all")
public interface BeanFactory {
    
    public Object getBean(String beanName);
    
    public Object getBean(String beanName, Object[] args);
}
