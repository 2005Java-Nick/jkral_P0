package com.FreudBot.main;

import java.util.Scanner;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;


public class main {
	
	
	  public static final String ACCOUNT_SID = System.getenv("TWILIO_ACCOUNT_SID");
	  public static final String AUTH_TOKEN = System.getenv("TWILIO_AUTH_TOKEN");
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

		
		Message message = Message.creator(new PhoneNumber("+15558675309"),
		        new PhoneNumber("+15017250604"), 
		        "This is the ship that made the Kessel Run in fourteen parsecs?").create();

		    System.out.println(message.getSid());
		
		
		
		
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Hi, I am FreudBot. What is your name?");
		String userName = scanner.nextLine();
		
		System.out.println("Hi "+ userName + ". What is your cell phone number?");
		int phone = scanner.nextInt();
		
		Human human = new Human(userName, phone);
	}

}
