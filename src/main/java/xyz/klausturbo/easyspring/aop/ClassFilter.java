package xyz.klausturbo.easyspring.aop;

/**
 * TODO .
 * @author <a href="mailto:guyue375@outlook.com">Klaus.turbo</a>
 * @program easy-spring
 **/
public interface ClassFilter {
    
    boolean matches(Class<?> clazz);
}
