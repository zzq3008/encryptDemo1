package com.example.demo.base.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect//(value="com.example.demo.*")
public class LogAspect {

	@Pointcut("execution(* com.example.demo.*.*.*(..))")
    public void pointCut(){}
    
    @Before("pointCut()")
    public void doBefore(JoinPoint joinPoint){
    	String name = joinPoint.getSignature().getName();
        System.out.println(name+"方法执行前");
    }
    
    @After("pointCut()")
    public void doAfter(JoinPoint joinPoint){
    	String name = joinPoint.getSignature().getName();
        System.out.println(name+"方法执行后");
    }
    
    @AfterReturning(pointcut="pointCut()",returning="returnVal")
    public void afterReturn(JoinPoint joinPoint,Object returnVal){
    	String name = joinPoint.getSignature().getName();
        System.out.println(name+"方法返回值:" + returnVal);
    }
    
    @AfterThrowing(pointcut="pointCut()",throwing="error")
    public void afterThrowing(JoinPoint joinPoint,Throwable error){
        System.out.println("AOP AfterThrowing Advice..." + error);
        System.out.println("AfterThrowing...");
    }
    
//    @Around("pointCut()")
//    public Object around(ProceedingJoinPoint pjp){
//        System.out.println("AOP Aronud before...");
//        Object proceed = null;
//    	Object[] args = pjp.getArgs();
//        try {
//            pjp.proceed();
//         // 目标方法执行完成后会有返回值，这个返回值一定return出去
//    		proceed = pjp.proceed(args);
//        } catch (Throwable e) {
//            e.printStackTrace();
//        }
//        System.out.println("AOP Aronud after...");
//        return proceed;
//    }

}
