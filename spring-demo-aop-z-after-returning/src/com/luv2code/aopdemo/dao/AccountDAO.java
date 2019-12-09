package com.luv2code.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Component
public class AccountDAO {

	private String name;
	
	private String serviceCode;
	
	public List<Account> findAccounts() {
		List<Account> theAccounts = new ArrayList<>();
		
		Account temp1 = new Account("John", "Silver");
		Account temp2 = new Account("Madhu", "Platinum");		
		Account temp3 = new Account("Luca", "Gold");
		theAccounts.add(temp1);
		theAccounts.add(temp2);
		theAccounts.add(temp3);
		return theAccounts;
	}
	
	public String getName() {
		System.out.println(getClass() +  ": getName()");
		return name;
	}

	public void setName(String name) {
		System.out.println(getClass() +  ": setName()");
		this.name = name;
	}

	public String getServiceCode() {
		System.out.println(getClass() +  ": getServiceCode()");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println(getClass() +  ": setServiceCode()");
		this.serviceCode = serviceCode;
	}

	public void addAccount(Account theAccount, boolean vipFlag) {
		
		System.out.println(getClass() +  ": DOING MY DB WORK: ADDING AN ACCOUNT");
	}
	
	public boolean doWork() {
		
		System.out.println(getClass() +  ": doWork()");
		
		return false;
	}
}
