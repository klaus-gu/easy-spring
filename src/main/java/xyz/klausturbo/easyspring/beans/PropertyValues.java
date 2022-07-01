package xyz.klausturbo.easyspring.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * bean 属性集合 .
 * @author <a href="mailto:guyue375@outlook.com">Klaus.turbo</a>
 * @program easy-spring
 **/
public class PropertyValues {
    
    private final List<PropertyValue> propertyValueList = new ArrayList<>();
    
    public void addPropertyValue(PropertyValue propertyValue) {
        this.propertyValueList.add(propertyValue);
    }
    
    public PropertyValue[] getPropertyValues() {
        return this.propertyValueList.toArray(new PropertyValue[0]);
    }
    
    public PropertyValue getPropertyValue(String propertyName) {
        for (PropertyValue propertyValue : this.propertyValueList) {
            if (propertyValue.getName().equals(propertyName)) {
                return propertyValue;
            }
        }
        return null;
    }
}
