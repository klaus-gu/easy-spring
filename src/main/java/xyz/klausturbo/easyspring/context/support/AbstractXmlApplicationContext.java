package xyz.klausturbo.easyspring.context.support;

import xyz.klausturbo.easyspring.beans.factory.support.DefaultListableBeanFactory;
import xyz.klausturbo.easyspring.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * TODO .
 * @author <a href="mailto:guyue375@outlook.com">Klaus.turbo</a>
 * @program easy-spring
 **/
public abstract class AbstractXmlApplicationContext extends AbstractRefreshableApplicationContext{
    
    @Override
    protected void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) {
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory,this);
        String[] confgiLocations = getConfigLocations();
        if (null != confgiLocations){
            beanDefinitionReader.loadBeanDefinitions(confgiLocations);
        }
    }
    
    protected abstract String[] getConfigLocations();
}
