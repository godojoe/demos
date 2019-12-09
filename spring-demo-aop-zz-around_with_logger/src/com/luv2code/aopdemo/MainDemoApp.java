package com.luv2code.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		Account tempAccount = new Account();
		tempAccount.setName("Madhu");
		tempAccount.setLevel("Platinum");
		theAccountDAO.addAccount(tempAccount, true);
		theAccountDAO.doWork();
		
		theAccountDAO.setName("foobar");
		theAccountDAO.setServiceCode("silver");
		
		String name = theAccountDAO.getName();
		String code = theAccountDAO.getServiceCode();
				
		MembershipDAO theMembershipDAO = 
				context.getBean("membershipDAO", MembershipDAO.class);
		
		theMembershipDAO.addSillyMember();
		theMembershipDAO.goToSleep();
		
		context.close();
	}

}
