package xyz.klausturbo.easyspring.beans.factory;

/**
 * TODO .
 * @author <a href="mailto:guyue375@outlook.com">Klaus.turbo</a>
 * @program easy-spring
 **/
public interface BeanNameAware extends Aware {
    
    void setBeanName(String name);
}
