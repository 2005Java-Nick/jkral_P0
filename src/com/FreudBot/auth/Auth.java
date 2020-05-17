package com.FreudBot.auth;

import java.util.Scanner;

import com.FreudBot.jdbc.ConnectionFactory;
import com.FreudBot.user.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Auth {
	
	
	
	public void mainMenu() {
		String newLine = System.getProperty("line.separator");
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Hi, my name is FreudBot, please select from the following options:");
		System.out.println("Press 1 to login:");
		System.out.println("Press 2 to create new account:");
		
		int choice = scanner.nextInt();
		if (choice == 1) {
			login();
		} else if (choice == 2) {
			createUser();
		} else {
			System.out.println("Invalid choice");
			mainMenu();
		}	
		
	}
	
	public void login() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter your username:");
		String userName = scanner.nextLine();
		
		System.out.println("Please enter your password:");
		String password = scanner.nextLine();
		
		ConnectionFactory cf = new ConnectionFactory();
		cf.getConnection();
		
		// query db to check for valid user	
		
		
	}
	
	public void createUser() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("What's your first name?");
		String firstName = scanner.nextLine();
		
		System.out.println("What's your last name?");
		String lastName = scanner.nextLine();
		
		System.out.println("Please enter your phone number:");
		String phoneNum = scanner.nextLine();
		
		System.out.println("Please enter your username:");
		String userName = scanner.nextLine();
		
		System.out.println("Please enter your password:");
		String password = scanner.nextLine();
		
		// validate username and password
		
		// store in db
		User user = new User(firstName, lastName, phoneNum, userName, password);		
		saveUser(user);
		
	}		
		
		public void saveUser(User user) {
			Connection conn = ConnectionFactory.getConnection();
			final String CREATE_USER = "INSERT INTO Quiz_User(first_name, last_name, phone_num, user_name, password) "
	                + "VALUES(?,?,?,?,?)";
			//conn.setSchema(schema);
			PreparedStatement stmt;
			try {
				stmt = conn.prepareStatement(CREATE_USER);
				stmt.setString(1, user.firstName);
				stmt.setString(2, user.lastName);
				stmt.setString(3, user.phoneNum);
				stmt.setString(4, user.userName);
				stmt.setString(5, user.password);
				System.out.println(user.password);
				stmt.execute();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					System.out.println("Closing connection");
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
	
	}	


