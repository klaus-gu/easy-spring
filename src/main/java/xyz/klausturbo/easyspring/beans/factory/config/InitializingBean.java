package xyz.klausturbo.easyspring.beans.factory.config;

/**
 * 初始化 .
 * @author <a href="mailto:guyue375@outlook.com">Klaus.turbo</a>
 * @program easy-spring
 **/
public interface InitializingBean {
    
    /**
     * Bean初始化之前做的事情.
     * @throws Exception
     */
    void afterPropertiesSet() throws Exception;
    
}
