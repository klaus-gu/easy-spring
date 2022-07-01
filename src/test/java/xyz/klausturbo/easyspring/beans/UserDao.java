package xyz.klausturbo.easyspring.beans;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO .
 * @author <a href="mailto:guyue375@outlook.com">Klaus.turbo</a>
 * @program easy-spring
 **/
public class UserDao {
    private static Map<String , String> userMap = new HashMap<>();
    
    static {
        userMap.put("1001","张三");
        userMap.put("1002","李四");
    }
    
    public String queryUserNameById(String id){
        return userMap.get(id);
    }
}
