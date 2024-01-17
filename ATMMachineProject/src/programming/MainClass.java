package programming;

import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		ATMOprationInterface op = new ATMOprationImplementation();
		int atmnumber= 12345;
		int atmpin = 123;
		Scanner in = new Scanner (System.in);
		System.out.println("Welcome To ATM Machine");
		System.out.print("Enter a ATM Number : ");
		int atmNumber = in.nextInt();
		System.out.println("Enter Pin: ");
		int pin = in.nextInt();
		if((atmnumber==atmNumber) && (atmpin==pin)) {
			System.out.println("Validation Done ");
			while (true ) {
				System.out.println("1.View Available Balance\n2.Withdraw Amount\n3.Deposit Amount\n4.View MiniStatement\n5.Exist");
				System.out.println("Enter a Choice : ");
				int ch = in.nextInt();
				if(ch==1) {
					op.viewBalance();
				}
				else if(ch==2) {
					System.out.println("Enter Amount Withdraw");
					double withdrawAmount =in.nextDouble();
					op.withdrawAmount(withdrawAmount);
					
				}
				else if(ch==3) {
					System.out.println("Enter Amount to Deposit : ");
					double depositAmount = in.nextDouble();
					op.depositAmount(depositAmount);
					
				}
				else if(ch==4) {
					op.viewMiniStatement();
					
				}
				else if(ch==5) {
					System.out.println("Collect Your ATM Card\n Thank you using ATM machine !");
					System.exit(0);
				}
				else {
					System.out.println("Please Enter Correct Choice");
				}
			}
		}
		else {
			System.out.println("Incorrect ATM Pin");
		}
		System.exit(0);

		
	}

}
