package xyz.klausturbo.easyspring.beans.factory.config;

/**
 * ${@link BeanDefinition} Bean 对象的定义，用于拆分一个完整的 Bean 对象.
 * @author <a href="mailto:guyue375@outlook.com">Klaus.turbo</a>
 * @program easy-spring
 **/
public class BeanDefinition {
    
    private Class beanClass;
    
    public BeanDefinition(Class beanClass) {
        this.beanClass = beanClass;
    }
    
    public Class getBeanClass() {
        return beanClass;
    }
}
