package xyz.klausturbo.easyspring.beans.factory;

/**
 * 销毁 .
 * @author <a href="mailto:guyue375@outlook.com">Klaus.turbo</a>
 * @program easy-spring
 **/
public interface DisposableBean {
    
    /**
     * 销毁执行动作.
     * @throws Exception
     */
    void destory() throws Exception;
    
}
