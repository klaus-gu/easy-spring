package xyz.klausturbo.easyspring.beans;

import xyz.klausturbo.easyspring.beans.factory.FactoryBean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/**
 * TODO .
 * @author <a href="mailto:guyue375@outlook.com">Klaus.turbo</a>
 * @program easy-spring
 **/
public class ProxyFactoryBean implements FactoryBean<IUserDao> {
    
    @Override
    public IUserDao getObject() throws BeansException {
        InvocationHandler handler = (proxy,method,args)->{
            Map<String,String> hashmap = new HashMap<>();
            hashmap.put("1111","guyue");
            hashmap.put("2222","zhangsan");
            return "你被代理了 "+method.getName()+": "+hashmap.get(args[0].toString());
        };
        return (IUserDao) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),new Class[]{IUserDao.class},handler);
    }
    
    @Override
    public Class<?> getObjectType() {
        return IUserDao.class;
    }
    
    @Override
    public boolean isSingleton() {
        return true;
    }
}
