package com.capgemini.ui;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.capgemini.exception.BookingFailedException;
import com.capgemini.exception.BusNotAvailableException;
import com.capgemini.exception.InvalidUserPasswordException;
import com.capgemini.exception.PhoneNumberExistsException;
import com.capgemini.exception.SeatAlreadyOccupiedException;
import com.capgemini.exception.SeatNotAvailableException;
import com.capgemini.exception.SourceAndDestinationAreEqualException;
import com.capgemini.exception.UserNameExistsException;
import com.capgemini.exception.UserNotFoundException;
import com.capgemini.model.Bus;
import com.capgemini.model.Passenger;
import com.capgemini.model.User;
import com.capgemini.service.BookTicket;
import com.capgemini.service.BookTicketImpl;
import com.capgemini.service.SearchBus;
import com.capgemini.service.SearchBusImpl;
import com.capgemini.service.SeatArrangement;
import com.capgemini.service.SeatArrangementImpl;
import com.capgemini.service.UserLogin;
import com.capgemini.service.UserLoginImpl;
import com.capgemini.service.UserSignUp;
import com.capgemini.service.UserSignUpImpl;

public class App {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		boolean flag = true;
		int age;
		char gender;

		do {
			System.out.println("**********************Bus Reservation**********************");
			System.out.println();
			System.out.println("Welcome to Bus Reservation");
			System.out.println();
			System.out.println("1. Login");
			System.out.println("2. SignUp");
			System.out.println("3. Admin login");
			System.out.println("0. Exit Application");
			System.out.println("Enter your choice: ");

			int choice = 0;
			while (true) {
				try {
					choice = input.nextInt();

					if (choice <= 0 || choice > 3) {
						System.out.println("!!!You have to choose a choice from 0 to 3");
						continue;
					} else {
						break;
					}
				} catch (InputMismatchException e) {
					System.out.println("Invalid input! You have to enter a choice");
					input.next();
					continue;
				}
			}
			System.out.println();

			switch (choice) {

			case 1:
				User user;
				boolean nextLoopflag;
				String addword = "";
				UserLogin userLogin = new UserLoginImpl();
				while (true) {
					System.out.println("===========================================================================");
					System.out.println("Enter your login Username " + addword + ":");
					String userName = input.next();
					try {
						user = userLogin.validateUserName(userName);
						nextLoopflag = true;
						System.out.println("Enter the password: ");
						break;
					} catch (UserNotFoundException e) {
						System.out.println(e.getMessage());
						nextLoopflag = false;
						addword = "again";
						continue;
					}
				}
				while (nextLoopflag) {
					String password = input.next();
					boolean result;
					try {
						result = userLogin.passwordVerification(user, password);
						nextLoopflag = false;
						break;
					} catch (InvalidUserPasswordException e) {
						System.out.println(e.getMessage());
						System.out.println("Enter the password again: ");
						continue;
					}

				}
				System.out.println("===========================================================================");
				System.out.println("Go ahead!!!!");

				List<Bus> availBusList = new ArrayList<Bus>();
				String source;
				String destination;
				String dateOfTravel;
				String day;
				Bus selectedBus;
				
				
				// ask for source to destination
				label1: while (true) {
					System.out.println("Enter your Source");
					source = input.next();
					System.out.println("Enter your destination");
					destination = input.next();
					System.out.println("Enter the date of travelin dd/m//yyyy");
					dateOfTravel = input.next();
					SearchBus searchBus = new SearchBusImpl();
					try {
						day = findDayOnThisDate(dateOfTravel);
						availBusList = searchBus.showAvailableBuses(source, destination, day);
					} catch (SourceAndDestinationAreEqualException e) {
						System.out.println(e.getMessage());
						continue label1;
					} catch (BusNotAvailableException e) {
						System.out.println(e.getMessage());
						continue label1;
					} catch (ParseException e) {
						System.out.println("Date entered is not in a valid format!!!");
						continue label1;
					} 

					System.out.println("Buses available for this route are as follows :");
					for (int i = 0; i < availBusList.size(); i++) {
						System.out.println((i + 1) + ". " + availBusList.get(i).getBusName() + " - "
								+ availBusList.get(i).getDepartTime());
					}
					// here user selects the bus
					System.out.println("Select the choice in which you want to travel from above list");
					int busChoice = input.nextInt(); // ##here exception
					selectedBus = availBusList.get(busChoice - 1);
					
					
					// show seat availability in that bus
					label2: while (true) {
						System.out.println("Seat available in " + selectedBus.getBusName() + " are as follows :");
						SeatArrangement seatings = new SeatArrangementImpl();
						try {
							System.out.println(seatings.seatAvailability(selectedBus));
						} catch (SeatNotAvailableException e) {
							System.out.println(e.getMessage());
							System.out.println("Try for other bus...");
							continue label1;
						}

						// here user selects the seatNo
						System.out.println("Enter the seat you want :");
						int selectedSeatNo = input.nextInt();
						
						//validateSeatNo of that bus
						SeatArrangement seatArrgn = new SeatArrangementImpl();
						try {
							seatArrgn.validateSeat(selectedBus, selectedSeatNo);
						} catch (SeatAlreadyOccupiedException e) {
							System.out.println();
							System.out.println(e.getMessage());
							System.out.println("Enter seats from below available seats");
							continue label2;
						}

						// ask to enter passenger details
						System.out.println("Enter the passenger details :");
						System.out.println("Enter the passenger full name : ");
						input.nextLine();
						String pssgnName = input.nextLine();
						System.out.println("Enter passenger gender :");
						gender = input.next().charAt(0);
						System.out.println("Enter passenger Age :");
						age = input.nextInt();

						Passenger pssgn = new Passenger(pssgnName, gender, age);
						
						System.out.println("\nYour ticket details are:");
						BookTicket bkticket = new BookTicketImpl();
						System.out
								.println(bkticket.showTicket(source, destination, selectedBus, pssgn, selectedSeatNo,dateOfTravel));

						System.out.println("Do you want to confirm ticket (Y->yes/N->No)");
						char choice2 = input.next().charAt(0);//############################################
						if (choice2 == 'Y') {
							try {
								System.out.println();
								System.out.println(
										bkticket.bookTicket(source, destination, selectedBus, pssgn, selectedSeatNo, dateOfTravel));
							} catch (BookingFailedException e) {
								System.out.println(e.getMessage());
								System.out.println("Try again...");
								continue label2;
							} 
						} else {
							System.out.println("You canceled to book! \n");
							continue label1;
						}

						System.out.println();
						System.out.println("Do you want to book ticket again? \n Enter--> (Y->yes/N->No)");
						char choice3 = input.next().charAt(0);//############################################
						if (choice3 == 'Y') {
							continue label2;
						} else {
							System.out.println("Do you want to goto home page or logout enter your choice ");
							System.out.println("1. Home page \n2. Logout");
							int choice4;
							
							label3: while (true) {
								try {
									choice = input.nextInt();

									if (choice < 0 || choice > 2) {
										System.out.println("!!!You have to choose a choice either 1 or 2");
										continue label3;
									} else {
										break label3;
									}
								} catch (InputMismatchException e) {
									System.out.println("Invalid input! You have to enter a choice again");
									input.next();
									continue;
								}
							}
							
							if (choice == 1) {
								continue label1;
							} else {
								break label1;
							}

						}
					}
				}
				//############################################ do not forget to close all resurces
				break;

				
			case 2:
				System.out.println("===========================================================================");
				System.out.println("Enter your Full Name:");
				input.nextLine(); // This line you have to add (It consumes the \n character which was not read by
									// nextInt() earlier)
				String userFullName = input.nextLine();
				System.out.println("Enter username you want:");
				String userName = input.next();
				System.out.println("Enter your age:");
				age = input.nextInt();
				System.out.println("Enter your Gender M/F:");
				gender = input.next().charAt(0);
				while (gender != 'M' && gender != 'F') {
					System.out.println("!!!Enter either \"M\"->for male or \"F\"->for Female!!!");
					gender = input.next().charAt(0);
				}
				System.out.println("Enter Your Mobile Number");
				long phoneNumber = input.nextLong();
				//############################################## create exception to validate phone number
				System.out.println("Set your password:");
				String userPassword = input.next();
				User newUser = new User(userFullName, userName, userPassword, gender, age, phoneNumber);
				UserSignUp newUserSignUp = new UserSignUpImpl();
				boolean userCreated;
				try {
					userCreated = newUserSignUp.signUp(newUser);
					System.out.println("User created or not: " + userCreated);
					System.out.println();
					if (userCreated) {
						newUser.toString();
						System.out.println();
					}
				} catch (UserNameExistsException | PhoneNumberExistsException e) {
					System.out.println(e.getMessage());
				}
				
			

				break;

				
			case 3:
				// admin login and services that admin can do
				break;

			
			case 0:
				// this to exit from application
				flag = false;
				break;

			}

		} while (flag);
	}

	static String findDayOnThisDate(String date) throws ParseException {
		SimpleDateFormat SDFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date userDt;
		String str = null;
		userDt = SDFormat.parse(date);
		SimpleDateFormat sdf = new SimpleDateFormat("E");
		str = sdf.format(userDt);

		return str;
	}

}
