package xyz.klausturbo.easyspring.beans;

import xyz.klausturbo.easyspring.context.support.ClassPathXmlApplicationContext;

/**
 * TODO .
 * @author <a href="mailto:guyue375@outlook.com">Klaus.turbo</a>
 * @program easy-spring
 **/
public class FactoryBean_TEST {
    
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        applicationContext.registerShutdownHook();
        
        UserService userService1 = applicationContext.getBean("userService", UserService.class);
        UserService userService2 = applicationContext.getBean("userService", UserService.class);
        
        System.out.println(userService1 == userService2);
    
        System.out.println(userService1.queryUserInfo());
    }
}
