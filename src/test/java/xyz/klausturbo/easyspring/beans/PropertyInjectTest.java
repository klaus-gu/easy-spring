package xyz.klausturbo.easyspring.beans;

import xyz.klausturbo.easyspring.beans.factory.config.BeanDefinition;
import xyz.klausturbo.easyspring.beans.factory.config.BeanReference;
import xyz.klausturbo.easyspring.beans.factory.support.DefaultListableBeanFactory;

/**
 * TODO .
 * @author <a href="mailto:guyue375@outlook.com">Klaus.turbo</a>
 * @program easy-spring
 **/
public class PropertyInjectTest {
    
    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        
        beanFactory.registerBeanDefinition("userDao", new BeanDefinition(UserDao.class));
        
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("userDao", new BeanReference("userDao")));
        
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class, propertyValues);
        beanFactory.registerBeanDefinition("userService", beanDefinition);
        
        UserService userService =(UserService) beanFactory.getBean("userService");
        userService.queryUserNameById("1001");
    }
    
}
