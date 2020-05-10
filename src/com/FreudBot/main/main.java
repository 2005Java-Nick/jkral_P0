package com.FreudBot.main;

import java.util.Scanner;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import io.github.cdimascio.dotenv.Dotenv;



public class main {
	
	  static Dotenv dotenv = Dotenv.load();
	  public static String ACCOUNT_SID = dotenv.get("TWILIO_ACCOUNT_SID");
	  public static String AUTH_TOKEN = dotenv.get("TWILIO_AUTH_TOKEN");
	  
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
		
//		Twilio.setUsername(dotenv.get(ACCOUNT_SID));
//		Twilio.setPassword(dotenv.get(AUTH_TOKEN));
				
		
		Message message = Message.creator(new PhoneNumber("+12074159349"),
		        new PhoneNumber("+12057549077"), 
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
