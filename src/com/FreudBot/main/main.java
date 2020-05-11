package com.FreudBot.main;

import java.util.Scanner;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import java.util.concurrent.TimeUnit;

import io.github.cdimascio.dotenv.Dotenv;



public class main {
	
	  
	
	  static Dotenv dotenv = Dotenv.load();
	  public static String ACCOUNT_SID = dotenv.get("TWILIO_ACCOUNT_SID");
	  public static String AUTH_TOKEN = dotenv.get("TWILIO_AUTH_TOKEN");
	  
	public static void main(String[] args) throws InterruptedException {
		
		String newLine = System.getProperty("line.separator");
		
		Scanner scanner = new Scanner(System.in);
			
		System.out.println("Hi, I am FreudBot. What is your name?");
		String name = scanner.nextLine();
			
		System.out.println("Hi "+ name + ". What is your cell phone number?");
		String phoneNum = scanner.nextLine();
		System.out.println(phoneNum);
					
		Quiz quiz = new Quiz();		
	
		quiz.questionAnimal();
		quiz.questionClothing();
		quiz.questionWater();
		
		System.out.println(newLine + "...ANALYZING..." + newLine);
		
		TimeUnit.SECONDS.sleep(3);
		
		Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
		quiz.analysis(phoneNum);
		
		
	}

}
