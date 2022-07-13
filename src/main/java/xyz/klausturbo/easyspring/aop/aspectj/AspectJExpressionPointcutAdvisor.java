package xyz.klausturbo.easyspring.aop.aspectj;

import org.aopalliance.aop.Advice;
import xyz.klausturbo.easyspring.aop.PointcutAdvisor;
import xyz.klausturbo.easyspring.aop.Pointcut;

/**
 * TODO .
 * @author <a href="mailto:guyue375@outlook.com">Klaus.turbo</a>
 * @program easy-spring
 **/
public class AspectJExpressionPointcutAdvisor implements PointcutAdvisor {
    
    private AspectJExpressionPointcut pointcut;
    
    private Advice advice;
    
    private String expression;
    
    public void setExpression(String expression) {
        this.expression = expression;
    }
    
    @Override
    public Advice getAdvice() {
        return advice;
    }
    
    @Override
    public Pointcut getPointcut() {
        if (null == pointcut) {
            pointcut = new AspectJExpressionPointcut(expression);
        }
        return pointcut;
    }
    
    public void setAdvice(Advice advice) {
        this.advice = advice;
    }
}
