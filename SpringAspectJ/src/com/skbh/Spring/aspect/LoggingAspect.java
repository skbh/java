package com.skbh.Spring.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggingAspect {

	@Before("allCircleMethod()")
	public void logginAdvice(JoinPoint joinPoint) {
		System.out.println("Advice get method excuted");
		/*
		 * Circle circle=(Circle) joinPoint.getTarget();
		 * System.out.println(circle.getName()); circle.setName("sushil");
		 * System.out.println(circle.getName());
		 */
	}

	@Before("allGetter()")
	public void secondAdvice() {
		System.out.println("second Advice excuted");
	}

	@Pointcut("execution(public * get*())")
	public void allGetter() {
	}

	@Pointcut("within(com.skbh.Spring.model.Circle)")
	public void allCircleMethod() {
	}

	@AfterReturning(pointcut = "args(name)", returning = "returnString")
	public void constructor(String name, String returnString) {
		System.out.println("constructor menthod called [" + name + "]" + "return string [" + returnString + "]");
	}

	@AfterThrowing(pointcut = "args(name)", throwing = "ex")
	public void exception(String name, RuntimeException ex) {
		System.out.println("exception occurs thrown by " + ex);
	}

}

// @Before("allGetter() && allCircleMethod()")
// public void logginAdvice(){
// System.out.println("Advice get method excuted");
// }
//
//
// @Pointcut("within(com.skbh.Spring.model.Circle)")
// public void allCircleMethod(){}

// @Before("execution(* get*(..))")
// public void logginAdvice(){
// System.out.println("Advice get method excuted");
// }
//

// @Before("execution(public String com.skbh.Spring.model.Circle.getName())")
// public void logginAdvice(){
// System.out.println("Advice Run method excuted");
// }

// @Before("execution(public * get*())")
// public void logginAdvice(){
// System.out.println("Advice get method excuted");
// }
