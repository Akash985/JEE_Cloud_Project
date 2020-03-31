package com.capgemini.ui;

import java.util.Scanner;

import com.capgemini.model.Passenger;
import com.capgemini.service.BookingService;
import com.capgemini.service.BookingServiceImpl;

public class BookingBus {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		BookingService service = new BookingServiceImpl();
		Passenger pssgn1 = new Passenger("Atharva", "AtharvaP1997",101, 21,'M', "22222222");
		Passenger pssgn2 = new Passenger("Arun", "Arun1997",102, 22,'M', "88888888");
		Passenger pssgn3 = new Passenger("Akash", "AkashY1997",103, 23,'M', "11111111");
		service.signUp(pssgn1);
		service.signUp(pssgn2);
		service.signUp(pssgn3);
	//This is data which will automatically filed in database whenever we execute our project
	//so we don't need to signup again and again
		 
	//login page added
		process:while(true) {
		
		System.out.println("Enter your login Username:");
		String userName = input.next();
		Passenger pssgn = service.login(userName);
		if(pssgn==null) {
			System.out.println("!!!!!!!!!!invalid user name");
			System.out.println("========================================================");
			System.out.println();
			continue process;
		}
		System.out.println("Enter the password: ");
		String password = input.next();
		boolean result = service.passwordVerification(pssgn, password);
		
		}
	}

}
