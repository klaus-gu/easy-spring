package xyz.klausturbo.easyspring.beans.factory.support;

import xyz.klausturbo.easyspring.beans.BeansException;
import xyz.klausturbo.easyspring.beans.factory.FactoryBean;
import xyz.klausturbo.easyspring.beans.factory.config.BeanDefinition;
import xyz.klausturbo.easyspring.beans.factory.config.BeanPostProcessor;
import xyz.klausturbo.easyspring.beans.factory.config.ConfigurableBeanFactory;
import xyz.klausturbo.easyspring.util.ClassUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO .
 * @author <a href="mailto:guyue375@outlook.com">Klaus.turbo</a>
 * @program easy-spring
 **/
public abstract class AbstractBeanFactory extends FactoryBeanRegistrySupport implements ConfigurableBeanFactory {
    
    private final List<BeanPostProcessor> beanPostProcessors = new ArrayList<BeanPostProcessor>();
    
    private ClassLoader classLoader = ClassUtils.getDefaultClassLoader();
    
    @Override
    public Object getBean(String beanName) {
        return doGetBean(beanName, null);
    }
    
    @Override
    public Object getBean(String beanName, Object[] args) {
        return doGetBean(beanName, args);
    }
    
    @Override
    public <T> T getBean(String name, Class<T> requiredType) throws BeansException {
        return (T) getBean(name);
    }
    
    protected <T> T doGetBean(String beanName, Object[] args) {
        Object shareInstance = getSingleton(beanName);
        if (shareInstance != null) {
            return (T) getObjectForBeanInstance(shareInstance, beanName);
        }
        BeanDefinition beanDefinition = getBeanDefinition(beanName);
        Object bean = createBean(beanName, beanDefinition, args);
        return (T) getObjectForBeanInstance(bean, beanName);
    }
    
    private Object getObjectForBeanInstance(Object beanInstance, String beanName) {
        if (!(beanInstance instanceof FactoryBean)) {
            return beanInstance;
        }
        Object object = getCachedObjectForFactoryBean(beanName);
        if (object == null) {
            FactoryBean<?> factoryBean = (FactoryBean<?>) beanInstance;
            object = getObjectFromFactoryBean(factoryBean, beanName);
        }
        return object;
    }
    
    protected abstract BeanDefinition getBeanDefinition(String name);
    
    protected abstract Object createBean(String name, BeanDefinition beanDefinition, Object[] args);
    
    @Override
    public void addBeanPostProcessor(BeanPostProcessor beanPostProcessor) {
        this.beanPostProcessors.remove(beanPostProcessor);
        this.beanPostProcessors.add(beanPostProcessor);
    }
    
    public List<BeanPostProcessor> getBeanPostProcessors() {
        return this.beanPostProcessors;
    }
    
    public ClassLoader getBeanClassLoader() {
        return this.classLoader;
    }
}
