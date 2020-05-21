package com.FreudBot.auth;

import java.util.Scanner;
import org.apache.log4j.Logger;

import com.FreudBot.jdbc.ConnectionFactory;
import com.FreudBot.user.User;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Auth {
	
	private static Logger log = Logger.getRootLogger();
	
	public String currPhone;
	
	public void mainMenu() {
		String newLine = System.getProperty("line.separator");
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Hi, my name is FreudBot, please select from the following options:");
		System.out.println("Press 1 to login:");
		System.out.println("Press 2 to create new account:");
		System.out.println("Press 3 to show all users:");
		
		int choice = scanner.nextInt();
		if (choice == 1) {
			login();
		} else if (choice == 2) {
			createUser();
		} else if (choice == 3) {
			showUsers();
		} else {
			System.out.println("Invalid choice. Please try again." + newLine);
			mainMenu();
		}	
		
	}
	
	public void login() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter your username:");
		String userName = scanner.nextLine();
		
		System.out.println("Please enter your password:");
		String password = scanner.nextLine();
		
		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement stmt;
		String queryString = "SELECT * FROM Quiz_User where user_name=? and password=?;";
		
		// query db to check for valid user	
		
			    try {
			    	stmt = conn.prepareStatement(queryString);
			        
			        stmt.setString(1, userName);
			        stmt.setString(2, password);
			        ResultSet results = stmt.executeQuery(); //where stmt is Object of PreparedStatement
			        if(!results.next()) {
			              System.out.println("Wrong Username and Password."); 
			              mainMenu();
			        } else {
			        	currPhone = results.getString(4);
			        	log.info("User logged in with phone number: " + currPhone);
			        }

			    } catch (SQLException e) {
			    	e.printStackTrace();
			    	log.error("SQL Exception", e);
			    }finally{
			    	try {
//						System.out.println("Closing connection");
						conn.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			    }
		
		
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
					log.info("User saved");
//					System.out.println("Closing connection");
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		
		public void showUsers(){
			Connection conn = ConnectionFactory.getConnection();
		  try
		  {
		    PreparedStatement stmt = conn.prepareStatement("select Display_All_Users()"); 
//		    System.out.println("Stored Procedure executed successfully");
		    ResultSet resultSet = stmt.executeQuery();
		    System.out.println("ALL USERS:");
		    while(resultSet.next()) {
		    	System.out.println(resultSet.getString(1));
		    }
		    
		    mainMenu();
		    
		  }
		  catch(Exception err)
		  {
		    System.out.println("An error has occurred.");
		    System.out.println("See full details below.");
		    err.printStackTrace();
		  }
		}
		
}

		
	
		
		

