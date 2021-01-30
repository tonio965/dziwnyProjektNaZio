package com.zio.services;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.zio.aspects.GetAspect;

import ch.qos.logback.classic.Logger;

@Aspect
@Component
public class MyAspect {
	
	Logger logger = (Logger) LoggerFactory.getLogger(MyAspect.class);
	
	@Before(value = "execution(* com.zio.controllers.*.get*(..))")
	public void beforeGet(JoinPoint joinPoint) {
	
		logger.info("Before get method: "+joinPoint.getSignature());
	}
	
	@Before(value = "execution(* com.zio.controllers.*.add*(..))")
	public void beforeAdd(JoinPoint joinPoint) {
		logger.info("Before add method: "+joinPoint.getSignature());
	}
	
	@Before(value = "execution(* com.zio.controllers.*.set*(..))")
	public void beforeSet(JoinPoint joinPoint) {
		logger.info("Before add method: "+joinPoint.getSignature());
	}
	
	@Before(value = "execution(* com.zio.controllers.*.find*(..))")
	public void beforeFind(JoinPoint joinPoint) {
		logger.info("Before find method: "+joinPoint.getSignature());
	}

}
