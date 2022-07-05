package xyz.klausturbo.easyspring.beans.factory.config;

import xyz.klausturbo.easyspring.beans.BeansException;
import xyz.klausturbo.easyspring.beans.factory.ConfigurableListableBeanFactory;

/**
 * BeanFactory 后置处理器 .
 * @author <a href="mailto:guyue375@outlook.com">Klaus.turbo</a>
 * @program easy-spring
 **/
public interface BeanFactoryPostProcessor {
    
    /**
     * 在所有的${@link BeanDefinition} 加载完毕之后，实例化 Bean 之前提供修改 BeanDefinition 的机制.
     * @param beanFactory
     * @throws BeansException
     */
    void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException;
}
