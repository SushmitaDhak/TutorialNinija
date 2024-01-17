package programm;

import java.util.Scanner;

public class RevarseNumber {

	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter a Number ");
	int num = sc.nextInt();
	// 1
	int rev =0;
	while(num!=0) {
		rev=rev*10+num%10;
		num=num/10;
		
	}
	System.out.println("Reverse Number is : "+rev);
	 
	

	}

}
