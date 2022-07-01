package xyz.klausturbo.easyspring.beans;

/**
 * TODO .
 * @author <a href="mailto:guyue375@outlook.com">Klaus.turbo</a>
 * @program easy-spring
 **/
public class UserService {
    
    private UserDao userDao;
    
    private String name;
    
    public UserService() {
    }
    
    public UserService(String name) {
        this.name = name;
    }
    
    public void register() {
        System.err.println("新注册用户：" + name);
    }
    
    public void queryUserNameById(String userId) {
        String userName = userDao.queryUserNameById(userId);
        System.err.println(userId + " == " + userName);
    }
}
