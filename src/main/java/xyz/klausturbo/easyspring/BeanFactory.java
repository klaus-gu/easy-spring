package xyz.klausturbo.easyspring;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * ${@link BeanFactory} 用于注册/获取一个 ${@link BeanDefinition}.
 * @author <a href="mailto:guyue375@outlook.com">Klaus.turbo</a>
 * @program easy-spring
 **/
@SuppressWarnings("all")
public class BeanFactory {
    
    private Map<String,/*bean name*/ BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<String, BeanDefinition>();
    
    public Object getBean(String beanName) {
        return beanDefinitionMap.get(beanName);
    }
    
    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(name, beanDefinition);
    }
}
