package xyz.klausturbo.easyspring.beans;

import xyz.klausturbo.easyspring.beans.factory.support.DefaultListableBeanFactory;
import xyz.klausturbo.easyspring.beans.factory.xml.XmlBeanDefinitionReader;
import xyz.klausturbo.easyspring.core.io.DefaultResourceLoader;
import xyz.klausturbo.easyspring.core.io.ResourceLoader;

/**
 * TODO .
 * @author <a href="mailto:guyue375@outlook.com">Klaus.turbo</a>
 * @program easy-spring
 **/
public class XmlBeanDefinitionReader_TEST {
    
    public static void main(String[] args) {
        ResourceLoader resourceLoader = new DefaultResourceLoader();
        
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory,resourceLoader);
        
        reader.loadBeanDefinitions("classpath:spring.xml");
        
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.register();
    }
}
