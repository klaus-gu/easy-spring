package xyz.klausturbo.easyspring.beans;

import xyz.klausturbo.easyspring.context.support.ClassPathXmlApplicationContext;

/**
 * TODO .
 * @author <a href="mailto:guyue375@outlook.com">Klaus.turbo</a>
 * @program easy-spring
 **/
public class ClassPathXmlApplicationContext_TEST {
    
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring.xml");
        UserService userService = (UserService) context.getBean("userService");
        userService.register();
    }
    
}
