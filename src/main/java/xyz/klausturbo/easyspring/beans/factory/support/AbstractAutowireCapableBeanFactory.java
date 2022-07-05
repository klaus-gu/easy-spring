package xyz.klausturbo.easyspring.beans.factory.support;

import cn.hutool.core.bean.BeanUtil;
import xyz.klausturbo.easyspring.beans.BeansException;
import xyz.klausturbo.easyspring.beans.PropertyValue;
import xyz.klausturbo.easyspring.beans.PropertyValues;
import xyz.klausturbo.easyspring.beans.factory.config.AutowireCapableBeanFactory;
import xyz.klausturbo.easyspring.beans.factory.config.BeanDefinition;
import xyz.klausturbo.easyspring.beans.factory.config.BeanPostProcessor;
import xyz.klausturbo.easyspring.beans.factory.config.BeanReference;

import java.lang.reflect.Constructor;

/**
 * TODO .
 * @author <a href="mailto:guyue375@outlook.com">Klaus.turbo</a>
 * @program easy-spring
 **/
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory
        implements AutowireCapableBeanFactory {
    
    private InstaniationStrategy instaniationStrategy = new CglibSubclassingInstantiationStrategy();
    
    @Override
    protected Object createBean(String name, BeanDefinition beanDefinition, Object[] args) {
        Object bean = null;
        try {
            bean = createBeanInstance(beanDefinition, name, args);
            // 给 Bean 填充属性
            applyPropertyValues(name, bean, beanDefinition);
            bean = initializeBean(name, bean, beanDefinition);
        } catch (BeansException e2) {
            throw new BeansException("Failed to instantiate [" + name + "]", e2);
        }
        addSingleton(name, bean);
        return bean;
    }
    
    private Object initializeBean(String name, Object bean, BeanDefinition beanDefinition) {
        Object wrappedBean = applyBeanPostProcessorsBeforeInitialization(bean, name);
        invokeInitMethods(name, wrappedBean, beanDefinition);
        wrappedBean = applyBeanPostProcessorsAfterInitialization(bean, name);
        return wrappedBean;
    }
    
    private void invokeInitMethods(String name, Object wrappedBean, BeanDefinition beanDefinition) {
    }
    
    private void applyPropertyValues(String beanName, Object bean, BeanDefinition beanDefinition) {
        try {
            PropertyValues propertyValues = beanDefinition.getPropertyValues();
            for (PropertyValue propertyValue : propertyValues.getPropertyValues()) {
                String name = propertyValue.getName();
                Object value = propertyValue.getValue();
                if (value instanceof BeanReference) {
                    BeanReference beanReference = (BeanReference) value;
                    value = getBean(beanReference.getBeanName());
                }
                BeanUtil.setFieldValue(bean, name, value);
            }
        } catch (Exception e) {
            throw new BeansException("Error setting property values:" + beanName);
        }
    }
    
    private Object createBeanInstance(BeanDefinition beanDefinition, String name, Object[] args) {
        Constructor<?> usedConstructor = null;
        Class<?> beanClass = beanDefinition.getBeanClass();
        Constructor<?>[] constructors = beanClass.getDeclaredConstructors();
        for (Constructor<?> constructor : constructors) {
            if (null != args && args.length == constructor.getParameterTypes().length) {
                usedConstructor = constructor;
                break;
            }
        }
        return getInstaniationStrategy().instantiate(beanDefinition, name, usedConstructor, args);
    }
    
    public InstaniationStrategy getInstaniationStrategy() {
        return instaniationStrategy;
    }
    
    public void setInstaniationStrategy(InstaniationStrategy instaniationStrategy) {
        this.instaniationStrategy = instaniationStrategy;
    }
    
    @Override
    public Object applyBeanPostProcessorsBeforeInitialization(Object existingBean, String beanName)
            throws BeansException {
        Object result = existingBean;
        for (BeanPostProcessor beanPostProcessor : getBeanPostProcessors()) {
            Object current = beanPostProcessor.postProcessBeforeInitialization(existingBean, beanName);
            if (null == current) {
                return result;
            }
            result = current;
        }
        return result;
    }
    
    @Override
    public Object applyBeanPostProcessorsAfterInitialization(Object existingBean, String beanName)
            throws BeansException {
        Object result = existingBean;
        for (BeanPostProcessor beanPostProcessor : getBeanPostProcessors()) {
            Object current = beanPostProcessor.postProcessAfterInitialization(existingBean, beanName);
            if (null == current) {
                return result;
            }
            result = current;
        }
        return result;
    }
}
