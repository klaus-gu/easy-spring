package xyz.klausturbo.easyspring.beans.factory.support;

import xyz.klausturbo.easyspring.core.io.ResourceLoader;

/**
 * TODO .
 * @author <a href="mailto:guyue375@outlook.com">Klaus.turbo</a>
 * @program easy-spring
 **/
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader {
    
    private final BeanDefinitionRegistry registry;
    
    private ResourceLoader resourceLoader;
    
    public AbstractBeanDefinitionReader(BeanDefinitionRegistry registry) {
        this(registry, null);
    }
    
    public AbstractBeanDefinitionReader(BeanDefinitionRegistry registry, ResourceLoader resourceLoader) {
        this.registry = registry;
        this.resourceLoader = resourceLoader;
    }
    
    @Override
    public BeanDefinitionRegistry getRegistry() {
        return registry;
    }
    
    @Override
    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }
}
