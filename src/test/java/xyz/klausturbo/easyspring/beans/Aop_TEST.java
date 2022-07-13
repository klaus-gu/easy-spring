package xyz.klausturbo.easyspring.beans;

import org.junit.Test;
import xyz.klausturbo.easyspring.aop.AdvisedSupport;
import xyz.klausturbo.easyspring.aop.TargetSource;
import xyz.klausturbo.easyspring.aop.aspectj.AspectJExpressionPointcut;
import xyz.klausturbo.easyspring.aop.framework.Cglib2AopProxy;
import xyz.klausturbo.easyspring.aop.framework.JdkDynamicAopProxy;
import xyz.klausturbo.easyspring.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.Method;

/**
 * TODO .
 * @author <a href="mailto:guyue375@outlook.com">Klaus.turbo</a>
 * @program easy-spring
 **/
public class Aop_TEST {
    
    @Test
    public void test_bean_aop(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring-aop.xml");
        ICatService catService = applicationContext.getBean("catService",ICatService.class);
        System.out.println("测试结果："+catService.queryUserInfo());
    }
    
    @Test
    public void test_aop() throws NoSuchMethodException {
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut(
                "execution(* xyz.klausturbo.easyspring.beans.CatService.*(..))");
        
        Class<CatService> clazz = CatService.class;
        Method method = clazz.getDeclaredMethod("queryUserInfo");
        System.out.println(pointcut.matches(clazz));
        System.out.println(pointcut.matches(method,clazz));
    }
    
    @Test
    public void test_dynamic_aop(){
        ICatService catService = new CatService();
        AdvisedSupport advisedSupport = new AdvisedSupport();
        advisedSupport.setTargetSource(new TargetSource(catService));
        advisedSupport.setMethodInterceptor(new CatServiceInterceptor());
        advisedSupport.setMethodMatcher(new AspectJExpressionPointcut("execution(* xyz.klausturbo.easyspring.beans.CatService.*(..))"));
        ICatService jdkProxy = (ICatService) new JdkDynamicAopProxy(advisedSupport).getProxy();
        System.out.println("测试结果："+jdkProxy.queryUserInfo());
        
        ICatService cglibProxy = (ICatService) new Cglib2AopProxy(advisedSupport).getProxy();
        System.out.println("测试结果："+cglibProxy.register("王武"));
    }
    
}
