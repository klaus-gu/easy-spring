package xyz.klausturbo.easyspring.aop;

/**
 * TODO .
 * @author <a href="mailto:guyue375@outlook.com">Klaus.turbo</a>
 * @program easy-spring
 **/
public class TargetSource {
    
    private final Object target;
    
    public TargetSource(Object target) {
        this.target = target;
    }
    
    public Class<?>[] getTargetClass() {
        return this.target.getClass().getInterfaces();
    }
    
    public Object getTarget() {
        return this.target;
    }
}
