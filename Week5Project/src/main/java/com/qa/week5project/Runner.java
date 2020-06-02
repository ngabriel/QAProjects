package com.qa.week5project;

import com.qa.week5project.DAO.CustomerDAO;
import com.qa.week5project.Models.Customer;
import com.qa.week5project.Utils.Input;

public class Runner {
	
	public static void main(String[] args) {
		Input input = new Input();
		
		System.out.println("Database username:  ");
		String user = input.getInput();
		System.out.println("Database password:  ");
		String password = input.getInput();
		
		
		CustomerDAO customerDao = new CustomerDAO(user,password);
		
		System.out.println("What's your name?");
		String name = input.getString();
		System.out.println("What is your faveourite colour");
		String favColour = input.getString();
		
		
		Customer customer = new Customer(name, favColour);
		
		customerDao.insertCustomer(customer);
		
		
	}

}
