package com.FreudBot.main;

import java.util.Scanner;

import com.FreudBot.auth.Auth;
import com.FreudBot.jdbc.ConnectionFactory;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import java.util.concurrent.TimeUnit;

import org.joda.time.IllegalFieldValueException;

import io.github.cdimascio.dotenv.Dotenv;



public class main {	  
//	.env variables for twilio
	  static Dotenv dotenv = Dotenv.load();
	  public static String ACCOUNT_SID = dotenv.get("TWILIO_ACCOUNT_SID");
	  public static String AUTH_TOKEN = dotenv.get("TWILIO_AUTH_TOKEN");
	  
	public static void main(String[] args) throws InterruptedException{
		
		String newLine = System.getProperty("line.separator");
			
		Auth auth = new Auth();		
		auth.mainMenu();
				

//			Instantiate the main Quiz class		
		Quiz quiz = new Quiz();	
		
//		methods to get answers to personality test
		quiz.questionAnimal();
		quiz.questionClothing();
		quiz.questionWater();
		
//		set a timeout and print analyzing
		System.out.println(newLine + "...ANALYZING..." + newLine);		
		TimeUnit.SECONDS.sleep(3);
		
//		instantiate the twilio object with protected account info and print analysis
		Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
		quiz.analysis(auth.currPhone);
		
	}

}
