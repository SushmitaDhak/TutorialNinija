package com.BankApp;

public class Main {

	public static void main(String[] args) {
		//customer name , customer Account Number 
		// Customer Email,Balance,Phone Number 
		// User can deposit money, withdrow money
		Account acc = new Account ( "123456",0.0," Sushmita", "abc@gmail.com","1234567891" );
		acc.DepositMoney(500);
		acc.DepositMoney(5000);
		acc.WithdrawMoney(100);
		

	}

}
