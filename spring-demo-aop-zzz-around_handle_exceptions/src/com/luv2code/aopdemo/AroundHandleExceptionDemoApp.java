package com.luv2code.aopdemo;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.service.TrafficFortuneService;

public class AroundHandleExceptionDemoApp {

	private static Logger myLogger = Logger.getLogger(AroundHandleExceptionDemoApp.class.getName());
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		TrafficFortuneService theFortuneService = 
				context.getBean("trafficFortuneService", TrafficFortuneService.class);

		myLogger.info("\nMain Porogram: AroundDemoApp");
		 
		myLogger.info("Calling getFortune");
		
		
		String data = theFortuneService.getFortune(true);
		
		myLogger.info("\nMy fortune is: " + data);
		
		myLogger.info("Finished");
		
		context.close();
	}

}
