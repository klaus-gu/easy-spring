package xyz.klausturbo.easyspring.beans;


import xyz.klausturbo.easyspring.beans.factory.config.BeanDefinition;
import xyz.klausturbo.easyspring.beans.factory.support.DefaultListableBeanFactory;

/**
 * 测试类 .
 * @author <a href="mailto:guyue375@outlook.com">Klaus.turbo</a>
 * @program easy-spring
 **/
class Test {
    
    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanFactory.registerBeanDefinition("beanDefinition", beanDefinition);
        // 有参构造
        // UserService service = (UserService) beanFactory.getBean("beanDefinition",new Object[]{"guyue"});
        // 无参构造
        UserService service = (UserService) beanFactory.getBean("beanDefinition");
        
        service.register();
    }
}