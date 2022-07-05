package xyz.klausturbo.easyspring.context;

import xyz.klausturbo.easyspring.beans.BeansException;

/**
 * TODO .
 * @author <a href="mailto:guyue375@outlook.com">Klaus.turbo</a>
 * @program easy-spring
 **/
public interface ConfigurableApplicationContext extends ApplicationContext {
    
    /**
     * 刷新容器.
     * @throws BeansException
     */
    void refresh() throws BeansException;
    
}
