package com.FreudBot.auth;

import java.util.Scanner;

import com.FreudBot.jdbc.ConnectionFactory;
import com.FreudBot.user.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class Auth {
	
	
	/*
	 * What do I need for auth?
	 * Menu 1. login 2.Create account
	 * if 1
	 * username: ?
	 * password: ?
	 * 
	 * if 2
	 * What is your first name?
	 * What is your phone number?
	 * create password: 
	 * Congratulations, name. Your username is your phone number: ### 
	 * Your password is: ###
	 * 
	 * where to store usernames and passwords? map? .env?
	 * 
	 *  Back to original menu
	 *  if 1 and username and password are correct
	 *  Then play the quiz
	 * 
	 */
	
	
	
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
			System.out.println("pressed 2");
			createUser();
		} else {
			System.out.println("Invalid choice");
			mainMenu();
		}	
		
		scanner.close();
		
	}
	
	public void login() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter your username:");
		String userName = scanner.next();
		
		System.out.println("Please enter your password:");
		String password = scanner.next();
		
		ConnectionFactory cf = new ConnectionFactory();
		cf.getConnection();
		
		// query db to check for valid user	
		scanner.close();
		
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
		
		scanner.close();
		
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
				//"update player set player_tokens = '510' where player_name = 'DoomSlayer'"
				//stmt.executeUpdate(SAVE_PLAYER_QUERY + "'" + p.getTokens() + "'" + SAVE_PLAYER_QUERY_2 + "'" + p.getName() + "'");
				stmt.setString(1, user.firstName);
				stmt.setString(2, user.lastName);
				stmt.setString(3, user.phoneNum);
				stmt.setString(4, user.userName);
				stmt.setString(5, user.password);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
	
	}	


