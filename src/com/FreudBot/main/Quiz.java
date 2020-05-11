package com.FreudBot.main;

import java.util.*;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import java.io.Serializable;
import org.apache.log4j.Logger;

import io.github.cdimascio.dotenv.Dotenv;

public class Quiz  {
	
	private static Logger log = Logger.getRootLogger();
	
//	Human human;
//	Instantiate needed twilio objects
	static Dotenv dotenv = Dotenv.load();
	public static String ACCOUNT_SID = dotenv.get("TWILIO_ACCOUNT_SID");
	public static String AUTH_TOKEN = dotenv.get("TWILIO_AUTH_TOKEN");
	
	Scanner scanner = new Scanner(System.in);
//	create string arrays to hold the answers to questions
	String[] animalAnswers = new String[2];
	String[] clothingAnswers = new String[2];
	String[] waterAnswers = new String[2];
	
//	Questions pertaining to favorite animal
	public void questionAnimal() {
//		sysout animal questions and store responses
		String question = "What is your favorite type of animal?";		
		System.out.println(question);
		String animal = scanner.nextLine();
		animalAnswers[0] = animal;
			
		String likeQuestion = "What are three characteristics of that animal that you like? Think about adjectives like soft, cuddly etc...";
		System.out.println(likeQuestion);
		String animalLikes = scanner.nextLine();
		animalAnswers[1] = animalLikes;		
	}
//	Questions pertaining to favorite clothing	
	public void questionClothing()  {
//		sysout clothing questions and store responses
		String question = "What is your favorite article of clothing?";		
		System.out.println(question);
		String clothing = scanner.nextLine();
		clothingAnswers[0] = clothing;
		
		String likeQuestion = "What are three characteristics of that article of clothing that you like?";
		System.out.println(likeQuestion);
		String clothingLikes = scanner.nextLine();
		clothingAnswers[1] = clothingLikes;		
	}
//	Questions pertaining to favorite body of water
	public void questionWater()  {
//		sysout water questions and store reponses
		String question = "What is your favorite body of water? It could be specific, like Hudson River. Or it could be general, like lakes or oceans.";		
		System.out.println(question);
		String water = scanner.nextLine();
		waterAnswers[0] = water;
		
		String likeQuestion = "What are three characteristics of that body of water that you like?";
		System.out.println(likeQuestion);
		String waterLikes = scanner.nextLine();
		waterAnswers[1] = waterLikes;		
	}
//	method to sysout the analysis and also text the analysis
	public void analysis(String phoneNum) {
		
		String newLine = System.getProperty("line.separator");
//		concatenate strings to provide analysis based on answers and sysout
		String analysis1 = "After careful analysis, Freudbot has determined:" + newLine + newLine + "You see yourself as:" + newLine + animalAnswers[1].toUpperCase();
		System.out.println(analysis1);
		
		String analysis2 = newLine + "Others see you as:" + newLine + clothingAnswers[1].toUpperCase();
		System.out.println(analysis2);
		
		String analysis3 = newLine + "You see your romantic life as:" + newLine + waterAnswers[1].toUpperCase();
		System.out.println(analysis3);
		
//		init twilio and send text message to user's phone using twilio API
		Twilio.init(ACCOUNT_SID, AUTH_TOKEN);		
		
		Message message = Message.creator(new PhoneNumber(phoneNum),
        new PhoneNumber("+12057549077"), 
        analysis1 + newLine + analysis2 + newLine + analysis3).create();

//        System.out.println(message.getSid());
	}
	
	
	
}
