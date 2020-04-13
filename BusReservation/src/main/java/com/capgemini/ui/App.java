package com.capgemini.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.capgemini.dao.UserDao;
import com.capgemini.dao.UserDaoImpl;
import com.capgemini.model.Bus;
import com.capgemini.model.Passenger;
import com.capgemini.model.User;
import com.capgemini.service.SearchBus;
import com.capgemini.service.SearchBusImpl;
import com.capgemini.service.SeatArrangement;
import com.capgemini.service.SeatArrangementImpl;
import com.capgemini.service.UserLogin;
import com.capgemini.service.UserLoginImpl;
import com.capgemini.service.UserSignUp;
import com.capgemini.service.UserSignUpImpl;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
		Scanner input = new Scanner(System.in);
		boolean flag =true;
		int age;
		char gender;
		
		do {
			System.out.println("*******************Bus Reservation*******************");
			System.out.println();
			System.out.println("Welcome to Bus Reservation");
			System.out.println();
			System.out.println("1. Login");
			System.out.println("2. SignUp");
			System.out.println("3. Admin login");
			System.out.println("4. Admin work for debuging");
			System.out.println("0. Exit Application");
			System.out.println("Enter your choice: ");
			
			int choice = input.nextInt();//$$$here also exception will come because if user enters input other than digit
			while(choice!=1 && choice!=2 && choice!=3 && choice!=4 && choice!=0) {
				System.out.println("Inavlid input!!!----enter either\'1\' or\'2\' or\'3\' or\'4\' or\'0\'");
				choice = input.nextInt();
			}
			System.out.println();
			
			switch (choice) {
			case 1:
				User user;
				boolean nextLoopflag;
				String addword ="";
				UserLogin userLogin = new UserLoginImpl();
				while(true) {
					System.out.println("===========================================================================");
					System.out.println("Enter your login Username "+addword+":");
					String userName = input.next();
					user = userLogin.validateUserName(userName);
					if(user==null) {
						System.out.println("!!!!!!!!!!invalid user name");//instead of this here we should handle inavlid username exception
						System.out.println();
						nextLoopflag = false;
						addword ="again";
						continue ;
					}
					else {
						nextLoopflag = true;
						System.out.println("Enter the password: ");
						break;
					}				
				}
				
				while(nextLoopflag) {
					String password = input.next();
					boolean result = userLogin.passwordVerification(user, password);
					if(result==false) {
						System.out.println("Enter the password again: ");
						continue;
					}
					else {
						nextLoopflag = false;
						//flag=true;//used for debuging
						break;
					}
				}
				System.out.println("===========================================================================");
				System.out.println("Go ahead!!!!");
				
				List<Bus> availBusList = new ArrayList<Bus>();
				//ask for source to destination
				System.out.println("Enter your Source");
				String source = input.next();
				System.out.println("Enter your destination");
				String destination = input.next();
				//display buses for that source to destination
				SearchBus searchBus = new SearchBusImpl();
				availBusList = searchBus.showAvailableBuses(source, destination);
				System.out.println("Buses available for this route are as follows :");
				for (int i = 0; i < availBusList.size(); i++) {
					System.out.println((i+1)+". "+availBusList.get(i).getBusName());
				}
				//here user selects the bus
				System.out.println("Select the choice in which you want to travel from above list");
				int busChoice = input.nextInt();				
				Bus selectedBus = availBusList.get(busChoice-1);
				
				//show seat availability in that bus
				System.out.println("Seat available in "+selectedBus.getBusName()+" are as follows :");
				SeatArrangement seatings = new SeatArrangementImpl();
				System.out.println(seatings.seatAvailability(selectedBus));
				//here user selects the seatNo
				System.out.println("Enter the seat you want :");
				int selectedSeatNo = input.nextInt();
				
				//ask to enter passenger details
				System.out.println("Enter the passenger details :");
				System.out.println("Enter the passenger full name : ");
				input.nextLine();
				String pssgnName = input.nextLine();
				System.out.println("Enter passenger gender :");
				gender = input.next().charAt(0);
				System.out.println("Enter passenger Age :");
				age = input.nextInt();
				
				Passenger pssgn = new Passenger(pssgnName, gender, age);
				
				
				
				//Show the tickect for the above things,
				//for eg we will call function-->String showTicket(Bus bus, Passenger pssgn, int seatNumber )
				//then ask to confirm tickect
				//after this call function --> String bookTicket(Bus bus, Passenger pssgn, int seatNumber)
				
				//ask user if he wants to add one more passenger 
				
				//do not forget to close all resurces
				break;
				
			case 2:
				System.out.println("===========================================================================");
				System.out.println("Enter your Full Name:");
				input.nextLine(); // This line you have to add (It consumes the \n character which was not read by nextInt() earlier)
				String userFullName = input.nextLine();				
				System.out.println("Enter username you want:");
				String userName = input.next();
				System.out.println("Enter your age:");
				age = input.nextInt();
				System.out.println("Enter your Gender M/F:");
				gender = input.next().charAt(0);
				while(gender!='M'&&gender!='F') {
					System.out.println("!!!Enter either \"M\"->for male or \"F\"->for Female!!!");
					gender = input.next().charAt(0);
				}
				System.out.println("Enter Your Mobile Number");
				long phoneNumber = input.nextLong();
				//create exception to validate phone number
				System.out.println("Set your password:");
				String userPassword = input.next();
				User newUser  = new User(userFullName, userName, userPassword, gender, age, phoneNumber);				
				UserSignUp newUserSignUp = new  UserSignUpImpl();
				boolean userCreated = newUserSignUp.signUp(newUser);
				System.out.println("User created or not: "+userCreated);
				System.out.println();
				if(userCreated) {
					//diplays deatils of new user creteds
					System.out.println();
				}
			
				break;
				
			case 3:
				//admin login and services that admin can do
				break;
				
			case 4:

				break;
				
			case 0:
				//this to exit from application
				flag = false;
				break;			

			}			
			
		} while (flag);
    }
}
