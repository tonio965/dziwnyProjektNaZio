package com.zio.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


import ch.qos.logback.classic.Logger;


@Aspect
public class GetAspect {
	
	Logger logger = (Logger) LoggerFactory.getLogger(GetAspect.class);
	
	@Pointcut("execution(* get*())")
	private void newObjectCreated() {
		logger.info("get pointcut");
		System.out.println("get pointcut");
	}
	
	@Pointcut("execution(* *())")
	private void newObjectCreated2() {
		System.out.println("pointcut");
		logger.info("any method pointcut");
	}
	


}
