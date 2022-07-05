package xyz.klausturbo.easyspring.context.support;

/**
 * TODO .
 * @author <a href="mailto:guyue375@outlook.com">Klaus.turbo</a>
 * @program easy-spring
 **/
public class ClassPathXmlApplicationContext extends AbstractXmlApplicationContext{
    
    private String[] configLocations;
    
    public ClassPathXmlApplicationContext() {
    }
    
    public ClassPathXmlApplicationContext(String configLocation) {
        this(new String[]{configLocation});
    }
    
    public ClassPathXmlApplicationContext(String[] configLocations) {
        this.configLocations = configLocations;
        refresh();
    }
    
    @Override
    protected String[] getConfigLocations() {
        return configLocations;
    }
}
