package xyz.klausturbo.easyspring.context;

import xyz.klausturbo.easyspring.beans.BeansException;
import xyz.klausturbo.easyspring.beans.factory.Aware;

/**
 * TODO .
 * @author <a href="mailto:guyue375@outlook.com">Klaus.turbo</a>
 * @program easy-spring
 **/
public interface ApplicationContextAware extends Aware {
    
    void setApplicationContext(ApplicationContext applicationContext) throws BeansException;
}
