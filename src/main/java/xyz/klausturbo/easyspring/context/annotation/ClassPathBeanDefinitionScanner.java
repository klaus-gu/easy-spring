package xyz.klausturbo.easyspring.context.annotation;

import cn.hutool.core.util.StrUtil;
import xyz.klausturbo.easyspring.Stereotype.Component;
import xyz.klausturbo.easyspring.beans.factory.config.BeanDefinition;
import xyz.klausturbo.easyspring.beans.factory.support.BeanDefinitionRegistry;

import java.util.Set;

/**
 * TODO .
 * @author <a href="mailto:guyue375@outlook.com">Klaus.turbo</a>
 * @program easy-spring
 **/
public class ClassPathBeanDefinitionScanner extends ClassPathScanningCandidateComponentProvider {
    
    private BeanDefinitionRegistry registry;
    
    public ClassPathBeanDefinitionScanner(BeanDefinitionRegistry registry) {
        this.registry = registry;
    }
    
    public void doScan(String... basePackages) {
        
        for (String basePackage : basePackages) {
            Set<BeanDefinition> candidates = findCandidateComponents(basePackage);
            for (BeanDefinition beanDefinition : candidates) {
                String beanScope = resolveBeanScope(beanDefinition);
                if (StrUtil.isNotEmpty(beanScope)) {
                    beanDefinition.setScope(beanScope);
                }
                registry.registerBeanDefinition(determineBeanName(beanDefinition), beanDefinition);
            }
        }
    }
    
    private String determineBeanName(BeanDefinition beanDefinition) {
        Class<?> beanClass = beanDefinition.getBeanClass();
        Component component =beanClass.getAnnotation(Component.class);
        String value = component.value();
        if (StrUtil.isEmpty(value)){
            value = StrUtil.lowerFirst(beanClass.getSimpleName());
        }
        return value;
    }
    
    private String resolveBeanScope(BeanDefinition beanDefinition) {
        Class<?> beanClass = beanDefinition.getBeanClass();
        Scope scope = beanClass.getAnnotation(Scope.class);
        if (null != scope) {
            return scope.value();
        }
        return StrUtil.EMPTY;
    }
    
    
}
