package xyz.klausturbo.easyspring.beans;

import xyz.klausturbo.easyspring.Stereotype.Component;

import java.util.Random;

/**
 * TODO .
 * @author <a href="mailto:guyue375@outlook.com">Klaus.turbo</a>
 * @program easy-spring
 **/
@Component("componentService")
public class ComponentService implements IComponentService{
    
    private String token;
    
    @Override
    public String queryUserInfo() {
        try {
            Thread.sleep(new Random(1).nextInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "哈哈哈,你查到了谁？";
    }
    
    @Override
    public String register(String userName) {
        try {
            Thread.sleep(new Random(1).nextInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
       return  "恭喜你注册成功！";
    }
    
    @Override
    public String toString() {
        return "ComponentService{" + "token='" + token + '\'' + '}';
    }
    
    public String getToken() {
        return token;
    }
    
    public void setToken(String token) {
        this.token = token;
    }
}
