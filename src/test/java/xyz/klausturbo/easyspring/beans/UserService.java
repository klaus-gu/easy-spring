package xyz.klausturbo.easyspring.beans;

import xyz.klausturbo.easyspring.beans.factory.DisposableBean;
import xyz.klausturbo.easyspring.beans.factory.config.InitializingBean;

/**
 * TODO .
 * @author <a href="mailto:guyue375@outlook.com">Klaus.turbo</a>
 * @program easy-spring
 **/
public class UserService implements InitializingBean, DisposableBean {
    
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
    
    @Override
    public void destory() throws Exception {
        System.err.println("销毁");
    }
    
    @Override
    public void afterPropertiesSet() throws Exception {
        System.err.println("初始化");
    }
}
