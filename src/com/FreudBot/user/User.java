package com.FreudBot.user;

public class User {
	
	/* 
	 * What do I need in this class? if user logs in then take quiz
	 * if user creates new account, do they have to log in
	 * 
	 */
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
