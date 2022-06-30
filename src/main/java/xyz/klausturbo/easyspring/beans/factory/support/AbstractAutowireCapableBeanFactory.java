package xyz.klausturbo.easyspring.beans.factory.support;

import xyz.klausturbo.easyspring.beans.factory.BeansException;
import xyz.klausturbo.easyspring.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * TODO .
 * @author <a href="mailto:guyue375@outlook.com">Klaus.turbo</a>
 * @program easy-spring
 **/
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {
    
    private InstaniationStrategy instaniationStrategy = new CglibSubclassingInstantiationStrategy();
    
    @Override
    protected Object createBean(String name, BeanDefinition beanDefinition, Object[] args) {
        Object bean = null;
        try {
            bean = createBeanInstance(beanDefinition, name, args);
        } catch (BeansException e2) {
            throw new BeansException("Failed to instantiate [" + name + "]", e2);
        }
        addSingleton(name, bean);
        return bean;
    }
    
    private Object createBeanInstance(BeanDefinition beanDefinition, String name, Object[] args) {
        Constructor usedConstructor = null;
        Class beanClass = beanDefinition.getBeanClass();
        Constructor[] constructors = beanClass.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
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
}
