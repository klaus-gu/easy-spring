package xyz.klausturbo.easyspring.beans.factory.support;

import xyz.klausturbo.easyspring.beans.BeansException;
import xyz.klausturbo.easyspring.beans.factory.DisposableBean;
import xyz.klausturbo.easyspring.beans.factory.config.BeanDefinition;

import java.lang.reflect.Method;

/**
 * 销毁的方法 .
 * @author <a href="mailto:guyue375@outlook.com">Klaus.turbo</a>
 * @program easy-spring
 **/
public class DisposableBeanAdapter implements DisposableBean {
    
    private final Object bean;
    
    private final String beanName;
    
    private String destoryMethodName;
    
    public DisposableBeanAdapter(Object bean, String beanName, BeanDefinition beanDefinition) {
        this.bean = bean;
        this.beanName = beanName;
        this.destoryMethodName = beanDefinition.getDestoryMethodName();
    }
    
    @Override
    public void destory() throws Exception {
        if (bean instanceof DisposableBean) {
            ((DisposableBean) bean).destory();
        }
        if (destoryMethodName != null && destoryMethodName != "" && !(bean instanceof DisposableBean && "destory"
                .equals(this.destoryMethodName))) {
            Method destoryMethod = bean.getClass().getMethod(destoryMethodName);
            if (null == destoryMethod){
                throw new BeansException("Couldn't find a destroy method named '" + destoryMethodName + "' on bean with name '" + beanName + "'");
            }
            destoryMethod.invoke(bean);
        }
    }
}
