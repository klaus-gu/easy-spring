package xyz.klausturbo.easyspring.beans.factory.config;

import java.util.HashMap;
import java.util.Map;

/**
 * 用于操作单例的bean，包括单例bean的存储与获取 .
 * @author <a href="mailto:guyue375@outlook.com">Klaus.turbo</a>
 * @program easy-spring
 **/
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {
    
    private Map<String, Object> singletonObjects = new HashMap<String, Object>();
    
    @Override
    public Object getSingleton(String beanName) {
        return singletonObjects.get(beanName);
    }
    
    public void addSingleton(String beanName, Object singletonObject) {
        singletonObjects.put(beanName, singletonObject);
    }
}
