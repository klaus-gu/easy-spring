package xyz.klausturbo.easyspring.beans;

/**
 * TODO .
 * @author <a href="mailto:guyue375@outlook.com">Klaus.turbo</a>
 * @program easy-spring
 **/
public class UserService {
    
    private final String name;
    
    public UserService(String name) {
        this.name = name;
    }
    
    public void register() {
        System.err.println("新注册用户：" + name);
    }
}
