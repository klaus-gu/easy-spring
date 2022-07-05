package xyz.klausturbo.easyspring.beans.factory.config;

import xyz.klausturbo.easyspring.beans.BeanFactory;
import xyz.klausturbo.easyspring.beans.BeansException;

/**
 * 可以在系统运行过程中动态的往spring容器中注入bean对象 .
 * @author <a href="mailto:guyue375@outlook.com">Klaus.turbo</a>
 * @program easy-spring
 **/
public interface AutowireCapableBeanFactory extends BeanFactory {
    
    Object applyBeanPostProcessorsBeforeInitialization(Object existingBean, String beanName) throws BeansException;
    
    Object applyBeanPostProcessorsAfterInitialization(Object existingBean, String beanName) throws BeansException;
    
}
