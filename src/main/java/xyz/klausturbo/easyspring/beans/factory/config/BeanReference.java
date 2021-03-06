package xyz.klausturbo.easyspring.beans.factory.config;

/**
 * Bean 引用 .
 * @author <a href="mailto:guyue375@outlook.com">Klaus.turbo</a>
 * @program easy-spring
 **/
public class BeanReference {
    
    private final String beanName;
    
    public BeanReference(String beanName) {
        this.beanName = beanName;
    }
    
    public String getBeanName() {
        return beanName;
    }
}
