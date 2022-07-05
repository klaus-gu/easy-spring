package xyz.klausturbo.easyspring.core.io;

/**
 * TODO .
 * @author <a href="mailto:guyue375@outlook.com">Klaus.turbo</a>
 * @program easy-spring
 **/
public interface ResourceLoader {
    
    String CLASSPATH_URL_PREFIX = "classpath:";
    
    Resource getResource(String location);
}
