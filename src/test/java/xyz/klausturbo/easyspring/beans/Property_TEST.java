package xyz.klausturbo.easyspring.beans;

import org.junit.Test;
import xyz.klausturbo.easyspring.context.support.ClassPathXmlApplicationContext;

/**
 * TODO .
 * @author <a href="mailto:guyue375@outlook.com">Klaus.turbo</a>
 * @program easy-spring
 **/
public class Property_TEST {
    @Test
    public void test_property(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring-property.xml");
        IComponentService componentService = applicationContext.getBean("componentService",IComponentService.class);
        System.out.println(componentService);
    }
}
