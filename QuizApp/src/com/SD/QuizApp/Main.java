package com.SD.QuizApp;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.sound.midi.Soundbank;

public class Main {

	public static void main(String[] args) {
		Quiz q = new Quiz();
		q.logic();

	}

}

class Quiz {
	Scanner sc= new Scanner (System.in);
	int correctansCount =0;
	int wrongansCount=0;
	public void logic() {
		String question;
		Questions q1 = new Questions(question=" 1. Which Statement is true about java ?", "option1 = a) Java is sequence - dependent Programming Language ", "option= b) Java is Code - dependent Programming Language"," option3= c) Java is Platform - dependent Programming Language","option4  D) Java is Platform - Independent Programming Language");
		Questions q2 = new Questions(question="2. What is the extension of java code files ?" ,"option1 =a) .js","option2 =b) .txt", "option3 =c) .class","option4 =d) .java");
		Questions q3 = new Questions(question="3. Who Inverted Java Programming ?","option1 = a) JGuido Van Rossum ", "option= b) James Gossling"," option3= c) Dennis Ritchie","option4  D)Bjarane Stroustrup");
		Questions q4 = new Questions(question="4. Which one of the following is not Java feature ? ","option1 = a) Object-Oriented ", "option= b) Use Of Pointers"," option3= c)Portable","option4  D)Dynamic And Extensible");
		Questions q5 = new Questions(question="5. Which of these cannot be used for a variable name in Java ?  ","option1 = a) identifier & keyword ", "option= b)identifier"," option3= c)Keyword","option4  D)None of the above");
		Map<Questions,Character>hmap=new HashMap<>();
		hmap.put(q1, 'd');
		hmap.put(q2, 'd');
		hmap.put(q3, 'b');
		hmap.put(q4, 'b');
		hmap.put(q5, 'c');
		
		
		for(Map.Entry<Questions,Character>map:hmap.entrySet()) {
			System.out.println(map.getKey().getQuestion());
			System.out.println(map.getKey().getoption1());
			System.out.println(map.getKey().getoption2());
			System.out.println(map.getKey().getoption3());
			System.out.println(map.getKey().getoption4());
			System.out.println("Enter Your Answer : ");
			Character ans = sc.next().charAt(0);
			
			
			int cans = Character.compare(ans,map.getValue());
			if (cans==0) {
				System.out.println("Correct");
				correctansCount++;
			}
			else {
				System.out.println("Wrong");
			}
			wrongansCount++;
			
		}
		System.out.println();
		System.out.println("----------Result---------");
		System.out.println("Total Question ="+hmap.size());
		System.out.println("Correct Answered Questions = "+correctansCount);
		System.out.println("Wrong Answered Questions = "+wrongansCount);
		int percentage = (100*correctansCount/hmap.size());
		System.out.println("Percentage = "+percentage);
		if (percentage>95) {
			System.out.println("Performance Will be very good");
		}
		else if(percentage<35) {
			System.out.println("performace very low");
		}
		else {
			System.out.println("Performance : Medium");
		}
	}
}
