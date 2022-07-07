package xyz.klausturbo.easyspring.beans.factory.config;

import xyz.klausturbo.easyspring.beans.PropertyValues;

/**
 * ${@link BeanDefinition} Bean 对象的定义，用于拆分一个完整的 Bean 对象.
 * @author <a href="mailto:guyue375@outlook.com">Klaus.turbo</a>
 * @program easy-spring
 **/
public class BeanDefinition {
    
    private Class beanClass;
    
    private PropertyValues propertyValues;
    
    private String initMethodName;
    
    private String destoryMethodName;
    
    public BeanDefinition(Class beanClass, PropertyValues propertyValues) {
        this.beanClass = beanClass;
        this.propertyValues = propertyValues != null ? propertyValues : new PropertyValues();
    }
    
    public BeanDefinition(Class beanClass) {
        this(beanClass, null);
    }
    
    public Class getBeanClass() {
        return beanClass;
    }
    
    public PropertyValues getPropertyValues() {
        return propertyValues;
    }
    
    public String getInitMethodName() {
        return initMethodName;
    }
    
    public void setInitMethodName(String initMethodName) {
        this.initMethodName = initMethodName;
    }
    
    public String getDestoryMethodName() {
        return destoryMethodName;
    }
    
    public void setDestoryMethodName(String destoryMethodName) {
        this.destoryMethodName = destoryMethodName;
    }
}
