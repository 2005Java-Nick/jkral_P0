package com.FreudBot.main;

import java.util.Scanner;

public class main {
	
	public static void yo() {
		System.out.println("yo");
	}
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		yo();
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Hi, I am FreudBot. What is your name?");
		String userName = scanner.nextLine();
		
		System.out.println("Hi "+ userName + ". What is your cell phone number?");
		int phone = scanner.nextInt();
		
		Human human = new Human(userName, phone);
	}

}
