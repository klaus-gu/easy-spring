package xyz.klausturbo.easyspring.beans.factory;

import xyz.klausturbo.easyspring.beans.BeansException;
import xyz.klausturbo.easyspring.beans.PropertyValue;
import xyz.klausturbo.easyspring.beans.PropertyValues;
import xyz.klausturbo.easyspring.beans.factory.config.BeanDefinition;
import xyz.klausturbo.easyspring.beans.factory.config.BeanFactoryPostProcessor;
import xyz.klausturbo.easyspring.core.io.DefaultResourceLoader;
import xyz.klausturbo.easyspring.core.io.Resource;

import java.io.IOException;
import java.util.Properties;

/**
 * TODO .
 * @author <a href="mailto:guyue375@outlook.com">Klaus.turbo</a>
 * @program easy-spring
 **/
public class PropertyPlaceholderConfigurer implements BeanFactoryPostProcessor {
    
    public static final String DEFAULT_PLACEHOLDER_PREFIX = "${";
    
    public static final String DEFAULT_PLACEHOLDER_SUFFIX = "}";
    
    private String location;
    
    public void setLocation(String location) {
        this.location = location;
    }
    
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        try {
            DefaultResourceLoader defaultResourceLoader = new DefaultResourceLoader();
            Resource resource = defaultResourceLoader.getResource(location);
            Properties properties = new Properties();
            properties.load(resource.getInputStream());
            
            String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();
            for (String beanName : beanDefinitionNames) {
                BeanDefinition beanDefinition = beanFactory.getBeanDefinition(beanName);
                PropertyValues propertyValues = beanDefinition.getPropertyValues();
                for (PropertyValue propertyValue : propertyValues.getPropertyValues()) {
                    Object value = propertyValue.getValue();
                    if (!(value instanceof String)) {
                        continue;
                    }
                    String strVal = (String) value;
                    StringBuilder stringBuilder = new StringBuilder(strVal);
                    int startIdx = strVal.indexOf(DEFAULT_PLACEHOLDER_PREFIX);
                    int stopIdx = strVal.indexOf(DEFAULT_PLACEHOLDER_SUFFIX);
                    
                    if (startIdx != -1 && stopIdx != -1 && startIdx < stopIdx) {
                        String propKey  =strVal.substring(startIdx+2,stopIdx);
                        String propVal = properties.getProperty(propKey);
                        stringBuilder.replace(startIdx,stopIdx+1,propVal);
                        propertyValues.addPropertyValue(new PropertyValue(propertyValue.getName(),stringBuilder.toString()));
                    }
                }
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        
    }
}
