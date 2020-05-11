package com.FreudBot.main;

import java.util.*;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import io.github.cdimascio.dotenv.Dotenv;

public class Quiz {
	
	Human human;
	
	static Dotenv dotenv = Dotenv.load();
	public static String ACCOUNT_SID = dotenv.get("TWILIO_ACCOUNT_SID");
	public static String AUTH_TOKEN = dotenv.get("TWILIO_AUTH_TOKEN");
	
	Scanner scanner = new Scanner(System.in);
	
	String[] animalAnswers = new String[2];
	String[] clothingAnswers = new String[2];
	String[] waterAnswers = new String[2];
	

	
	
	
	public void questionAnimal()  {
		
		String question = "What is your favorite type of animal?";		
		System.out.println(question);
		String animal = scanner.nextLine();
		animalAnswers[0] = animal;
		
		String likeQuestion = "What are three characteristics of that animal that you like? Think about adjectives like soft, cuddly etc...";
		System.out.println(likeQuestion);
		String animalLikes = scanner.nextLine();
		animalAnswers[1] = animalLikes;		
	}
	
	public void questionClothing()  {
		
		String question = "What is your favorite article of clothing?";		
		System.out.println(question);
		String clothing = scanner.nextLine();
		clothingAnswers[0] = clothing;
		
		String likeQuestion = "What are three characteristics of that article of clothing that you like?";
		System.out.println(likeQuestion);
		String clothingLikes = scanner.nextLine();
		clothingAnswers[1] = clothingLikes;		
	}
	
	public void questionWater()  {
		
		String question = "What is your favorite body of water? It could be specific, like Hudson River. Or it could be general, like lakes or oceans.";		
		System.out.println(question);
		String water = scanner.nextLine();
		waterAnswers[0] = water;
		
		String likeQuestion = "What are three characteristics of that body of water that you like?";
		System.out.println(likeQuestion);
		String waterLikes = scanner.nextLine();
		waterAnswers[1] = waterLikes;		
	}
	
	public void analysis(String phoneNum) {
		
		String newLine = System.getProperty("line.separator");
		
		String analysis1 = "After careful analysis, Freudbot has determined that: " + newLine + newLine + "You see yourself as: " + animalAnswers[1];
		System.out.println(analysis1);
		
		String analysis2 = newLine + "Others see you as: " + clothingAnswers[1];
		System.out.println(analysis2);
		
		String analysis3 = newLine + "And you see your romantic life as: " + waterAnswers[1];
		System.out.println(analysis3);
		
		Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
		
		
		Message message = Message.creator(new PhoneNumber(phoneNum),
        new PhoneNumber("+12057549077"), 
        analysis1 + newLine + analysis2 + newLine + analysis3).create();

//        System.out.println(message.getSid());
	}
	
	
	
}
