package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.println("Enter account data:");
			System.out.print("Number: ");
			int accountNumber = sc.nextInt();
			System.out.print("Holder: ");
			String accountHolder = sc.next();
			sc.next();
			System.out.print("Initial balance: ");
			double initialBalance = sc.nextDouble();
			System.out.print("Withdraw limit: ");
			double withdrawLimit = sc.nextDouble();
			Account account = new Account(accountNumber, accountHolder, initialBalance, withdrawLimit);
			
			System.out.println();
			System.out.print("Enter the amount for withdraw: ");
			double amount = sc.nextDouble();
			account.withdraw(amount);
			System.out.printf("New balance: %.2f", account.getBalance());
		} catch(DomainException e) {
			System.out.println("Withdraw error: " + e.getMessage());
		} finally {
			sc.close();
		}
	}
	
}
