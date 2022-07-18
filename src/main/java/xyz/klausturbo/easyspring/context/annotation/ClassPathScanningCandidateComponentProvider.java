package xyz.klausturbo.easyspring.context.annotation;

import cn.hutool.core.util.ClassUtil;
import xyz.klausturbo.easyspring.Stereotype.Component;
import xyz.klausturbo.easyspring.beans.factory.config.BeanDefinition;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * TODO .
 * @author <a href="mailto:guyue375@outlook.com">Klaus.turbo</a>
 * @program easy-spring
 **/
public class ClassPathScanningCandidateComponentProvider {
    
    public Set<BeanDefinition> findCandidateComponents(String basePackage){
        Set<BeanDefinition> candidates  = new LinkedHashSet<>();
        Set<Class<?>> classes = ClassUtil.scanPackageByAnnotation(basePackage, Component.class);
        for (Class<?> aClass : classes) {
            candidates.add(new BeanDefinition(aClass));
        }
        return candidates;
    }

}
