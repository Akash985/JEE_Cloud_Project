package com.capgemini.model;

public class User {
	
	private String userFullName;
	private String UserName;
	private String userPassword;
	private static int userId = 1001;
	private char gender;
	private int age;
	private long phoneNumber;
	
	
	public User(String userFullName, String userName, String userPassword, char gender, int age,
			long phoneNumber) {
		super();
		this.userFullName = userFullName;
		UserName = userName;
		this.userPassword = userPassword;
		this.userId = userId+1;
		this.gender = gender;
		this.age = age;
		this.phoneNumber = phoneNumber;
	}


	public String getUserFullName() {
		return userFullName;
	}


	public void setUserFullName(String userFullName) {
		this.userFullName = userFullName;
	}


	public String getUserName() {
		return UserName;
	}


	public void setUserName(String userName) {
		UserName = userName;
	}


	public String getUserPassword() {
		return userPassword;
	}


	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
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


	public long getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	
	
	
}
