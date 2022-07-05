package xyz.klausturbo.easyspring.beans.factory;

import xyz.klausturbo.easyspring.beans.BeanFactory;
import xyz.klausturbo.easyspring.beans.BeansException;

import java.util.Map;

/**
 * 用于获取 bean列表的工厂 .
 * @author <a href="mailto:guyue375@outlook.com">Klaus.turbo</a>
 * @program easy-spring
 **/
public interface ListableBeanFactory extends BeanFactory {
    
    <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException;
    
    String[] getBeanDefinitionNames();
}
