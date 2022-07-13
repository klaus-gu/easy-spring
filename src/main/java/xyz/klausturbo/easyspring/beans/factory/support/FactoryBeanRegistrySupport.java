package xyz.klausturbo.easyspring.beans.factory.support;

import xyz.klausturbo.easyspring.beans.factory.FactoryBean;
import xyz.klausturbo.easyspring.beans.factory.config.DefaultSingletonBeanRegistry;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * ${@link FactoryBean 的注册} .
 * @author <a href="mailto:guyue375@outlook.com">Klaus.turbo</a>
 * @program easy-spring
 **/
public abstract class FactoryBeanRegistrySupport extends DefaultSingletonBeanRegistry {
    
    private final Map<String, Object> factoryBeanObjectCache = new ConcurrentHashMap<String, Object>();
    
    protected Object getCachedObjectForFactoryBean(String beanName) {
        Object object = this.factoryBeanObjectCache.get(beanName);
        return (object != NULL_OBJECT ? object : null);
    }
    
    protected Object getObjectFromFactoryBean(FactoryBean factory, String beanName) {
        if (factory.isSingleton()) {
            Object object = this.factoryBeanObjectCache.get(beanName);
            if (object == null) {
                object = doGetObjectFromFactoryBean(factory, beanName);
                this.factoryBeanObjectCache.put(beanName, (object != null ? object : NULL_OBJECT));
            }
            return (object != NULL_OBJECT ? object : null);
        }else {
            return doGetObjectFromFactoryBean(factory,beanName);
        }
    }
    
    private Object doGetObjectFromFactoryBean(FactoryBean factory, String beanName) {
        return factory.getObject();
    }
}
