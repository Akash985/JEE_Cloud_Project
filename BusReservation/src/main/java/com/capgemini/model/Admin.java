package com.capgemini.model;

public class Admin {

	private String adminFullName;
	private String adminUserName;
	private String adminPassword;
	private int adminId;
	private char gender;
	private int age;
	
	public Admin(String adminFullName,String adminUserName,String adminPassword,int adminId,char gender,int age) {
		super();
		this.adminFullName=adminFullName;
		this.adminUserName=adminUserName;
		this.adminPassword=adminPassword;
		this.adminId=adminId;
		this.gender=gender;
		this.age=age;
	}

	public String getAdminFullName() {
		return adminFullName;
	}

	public void setAdminFullName(String adminFullName) {
		this.adminFullName = adminFullName;
	}

	public String getAdminUserName() {
		return adminUserName;
	}

	public void setAdminUserName(String adminUserName) {
		this.adminUserName = adminUserName;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
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

	@Override
	public String toString() {
		return "Admin [adminFullName=" + adminFullName + ", adminUserName=" + adminUserName + ", adminPassword="
				+ adminPassword + ", adminId=" + adminId + ", gender=" + gender + ", age=" + age + "]";
	}
	
	
}

	
	
	

