package xyz.klausturbo.easyspring.beans;

/**
 * Bean 属性 .
 * @author <a href="mailto:guyue375@outlook.com">Klaus.turbo</a>
 * @program easy-spring
 **/
public class PropertyValue {
    
    private final String name;
    
    private final Object value;
    
    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }
    
    public String getName() {
        return name;
    }
    
    public Object getValue() {
        return value;
    }
}
