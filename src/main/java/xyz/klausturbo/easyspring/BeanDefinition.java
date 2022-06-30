package xyz.klausturbo.easyspring;

/**
 * ${@link BeanDefinition} Bean 对象的定义，用于拆分一个完整的 Bean 对象.
 * @author <a href="mailto:guyue375@outlook.com">Klaus.turbo</a>
 * @program easy-spring
 **/
public class BeanDefinition {
    
    private Object bean;
    
    public BeanDefinition(Object bean) {
        this.bean = bean;
    }
    
    public Object getBean() {
        return bean;
    }
}
