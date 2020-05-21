package com.FreudBot.user;

public class User {
	
	int id;
	public String firstName;
	public String lastName;
	public String phoneNum;
	public String userName;
	public String password;
	public String resultString;
	
	public User(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}
	
	public User(String firstName, String lastName, String phoneNum, String userName, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNum = phoneNum;
		this.userName = userName;
		this.password = password;
	}	

}
