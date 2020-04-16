package com.capgemini.model;

public class Passenger {

	private String PassengerName;
	private char gender;
	private int age;
	
	public Passenger(String passengerName, char gender, int age) {
		PassengerName = passengerName;
		this.gender = gender;
		this.age = age;
	}

	public String getPassengerName() {
		return PassengerName;
	}

	public void setPassengerName(String passengerName) {
		PassengerName = passengerName;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	

}
