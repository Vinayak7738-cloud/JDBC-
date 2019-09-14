package com.bv.execution;

import com.bv.service.LoginService;
import com.bv.service.SPDemo;

public class BankApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		//LoginService.getDetails();
		//SPDemo.callSp();
		
		if(LoginService.validateUser(102, "vinayak"))
		{
			System.out.println("Valid User");
		}
		else
		{
			System.out.println("Invalid User");
		}
	}
	

}
