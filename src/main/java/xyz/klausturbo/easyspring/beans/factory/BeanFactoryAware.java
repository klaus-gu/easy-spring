package xyz.klausturbo.easyspring.beans.factory;

import xyz.klausturbo.easyspring.beans.BeanFactory;
import xyz.klausturbo.easyspring.beans.BeansException;

/**
 * TODO .
 * @author <a href="mailto:guyue375@outlook.com">Klaus.turbo</a>
 * @program easy-spring
 **/
public interface BeanFactoryAware extends Aware {
    
    void setBeanFactory(BeanFactory beanFactory) throws BeansException;
}
