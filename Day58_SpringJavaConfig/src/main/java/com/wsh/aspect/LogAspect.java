package com.wsh.aspect;


import com.wsh.anno.Action;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect // 声明这是一个切面
@Component // 将此切面,放进Spring容器
public class LogAspect {

    // 被Action注解标识的,就在这里被设置成了切入点
    // 这里并不会找到MethodAopService中的方法
    @Pointcut("@annotation(com.wsh.anno.Action)")
    public void annotationCutPoint(){

    }
    // 声明建言,此建言(通知)在连接点之后执行
    @After(value = "annotationCutPoint()")
    public void after(JoinPoint joinPoint){
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        Action annotation = method.getAnnotation(Action.class);
//        System.out.println("注解式拦截:" + annotation.name());
    }

    @Before("execution(* com.wsh.service.*.*(..))")
    public void befor(JoinPoint joinPoint){
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
//        System.out.println("拦截方法规则:" + method.getName());
    }
}
