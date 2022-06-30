package xyz.klausturbo.easyspring.beans.factory;

/**
 * TODO .
 * @author <a href="mailto:guyue375@outlook.com">Klaus.turbo</a>
 * @program easy-spring
 **/
public class BeansException extends RuntimeException{
    
    public BeansException(String message) {
        super(message);
    }
    
    public BeansException(String message, Throwable cause) {
        super(message, cause);
    }
}
