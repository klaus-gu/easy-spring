package xyz.klausturbo.easyspring.beans.factory.support;

import cn.hutool.core.bean.BeanUtil;
import xyz.klausturbo.easyspring.beans.BeansException;
import xyz.klausturbo.easyspring.beans.PropertyValue;
import xyz.klausturbo.easyspring.beans.PropertyValues;
import xyz.klausturbo.easyspring.beans.factory.Aware;
import xyz.klausturbo.easyspring.beans.factory.BeanClassLoaderAware;
import xyz.klausturbo.easyspring.beans.factory.BeanFactoryAware;
import xyz.klausturbo.easyspring.beans.factory.BeanNameAware;
import xyz.klausturbo.easyspring.beans.factory.DisposableBean;
import xyz.klausturbo.easyspring.beans.factory.config.AutowireCapableBeanFactory;
import xyz.klausturbo.easyspring.beans.factory.config.BeanDefinition;
import xyz.klausturbo.easyspring.beans.factory.config.BeanPostProcessor;
import xyz.klausturbo.easyspring.beans.factory.config.BeanReference;
import xyz.klausturbo.easyspring.beans.factory.config.InitializingBean;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

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
        registerDisposableBeanIfNecessary(name, bean, beanDefinition);
        addSingleton(name, bean);
        return bean;
    }
    
    private void registerDisposableBeanIfNecessary(String name, Object bean, BeanDefinition beanDefinition) {
        if (bean instanceof DisposableBean || (beanDefinition.getDestoryMethodName() != null
                && beanDefinition.getDestoryMethodName() != "")) {
            registerDisposableBean(name, new DisposableBeanAdapter(bean, name, beanDefinition));
        }
    }
    
    private Object initializeBean(String name, Object bean, BeanDefinition beanDefinition) {
        if (bean instanceof Aware) {
            if (bean instanceof BeanFactoryAware) {
                ((BeanFactoryAware) bean).setBeanFactory(this);
            }
            if (bean instanceof BeanClassLoaderAware) {
                ((BeanClassLoaderAware) bean).setClassLoader(getBeanClassLoader());
            }
            if (bean instanceof BeanNameAware) {
                ((BeanNameAware) bean).setBeanName(name);
            }
        }
        Object wrappedBean = applyBeanPostProcessorsBeforeInitialization(bean, name);
        try {
            invokeInitMethods(name, wrappedBean, beanDefinition);
        } catch (Exception e) {
            throw new BeansException("Invocation of init method of bean[" + name + "] failed", e);
        }
        wrappedBean = applyBeanPostProcessorsAfterInitialization(bean, name);
        return wrappedBean;
    }
    
    private void invokeInitMethods(String beanName, Object bean, BeanDefinition beanDefinition) throws Exception {
        if (bean instanceof InitializingBean) {
            ((InitializingBean) bean).afterPropertiesSet();
        }
        String initMethodName = beanDefinition.getInitMethodName();
        if (initMethodName != null && initMethodName != "") {
            Method initMethod = beanDefinition.getBeanClass().getMethod(initMethodName);
            if (initMethod == null) {
                throw new BeansException(
                        "Could not find an init method named '" + initMethodName + "' on bean with name '" + beanName
                                + "'");
            }
            initMethod.invoke(bean);
        }
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
