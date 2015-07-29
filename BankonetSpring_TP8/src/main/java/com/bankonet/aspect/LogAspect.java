package com.bankonet.aspect;

import java.util.Arrays;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component("logAspect")
@Aspect
public class LogAspect {
	
	final String cut = "execution(* com.bankonet.metier.*.*(..)) || execution(* com.bankonet.dao.*.*(..))";
	
	private Log log = LogFactory.getLog(this.getClass());
	
//	private String classTarget(JoinPoint joinPoint){
//		return joinPoint.getTarget().getClass().toString();
//	}
//	
//	private String methodName(JoinPoint joinPoint){
//		return joinPoint.getSignature().getName();
//	}
//	
//	private StringBuffer argsBuffer(JoinPoint joinPoint, String methodName){
//		return new StringBuffer("");
//	}
	
	@Before(cut)
	@Order(0)
	public void logBeforeMetier(JoinPoint joinPoint){
		System.out.println("-----------BEFORE---------------");
		System.out.println(joinPoint.getTarget().getClass());
		System.out.println("Méthode " + joinPoint.getSignature().getName() + " invoquée avec " + Arrays.toString(joinPoint.getArgs()));
		
//		System.out.println("---- AOP ---- BEFORE ---- " + joinPoint.getTarget().getClass().getCanonicalName());
//		
//		String methodName = methodName(joinPoint);
//		StringBuffer sbin = new StringBuffer(methodName);
//		
//		StringBuffer argsBuffer = argsBuffer(joinPoint, methodName);
//		
//		sbin.append(argsBuffer);
//		
//		System.out.println("---- AOP ---- BEFORE ---- " + sbin.toString());
		
	}
	
	@AfterReturning(pointcut = cut, returning="result")
	@Order(1)
	public void logAfterReturning(JoinPoint joinPoint, Object result){
		System.out.println("-----------AFTER RETURNING---------------");
		System.out.println(joinPoint.getTarget().getClass());
		System.out.println("Méthode " + joinPoint.getSignature().getName() + " terminée par " + result);
		
//		String name = joinPoint.getSignature().toShortString();
//		System.out.println("---- AOP ---- AFTER RETURNING --- " + name + "returning : [" + result + "]");
	}
	
	@Around(cut)
	@Order(2)
	public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable{
		System.out.println("-----------AROUND---------------");
		System.out.println(joinPoint.getTarget().getClass());
		System.out.println("Méthode " + joinPoint.getSignature().getName() + " invoquée avec " + Arrays.toString(joinPoint.getArgs()));
		//System.out.println("---- AOP ---- AROUND ---- " + joinPoint.getTarget().getClass().getCanonicalName());
		try{
			Object result = joinPoint.proceed();
			System.out.println("Méthode " + joinPoint.getSignature().getName() + " terminée par " + result);
			
			//String name = joinPoint.getSignature().toShortString();
			//System.out.println("---- AOP ---- AROUND ---- " + name + "returning : [" + result + "]");
			return result;
		} catch (Exception e){
			System.err.println("Exception levée");
			System.err.println("Message de l'exception : " + e.getMessage());
			throw e;
		}
	}
}
