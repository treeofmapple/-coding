package java_poo.Four_4;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {

		Bank bank = new Bank();

		Account account1 = new Account("Emilio Doja", "CR-56", 5000);
		Account account2 = new Account("Catarin Roya", "CR-5064", 4000);
		Account account3 = new Account("Altermin Callardo", "CR-2030", 124500);

		ArrayList<Account> accounts = bank.getAccounts();

		for (Account account : accounts)
			System.out.println(account.getAccountName());

		System.out.println("\nAfter depositing 1000 into account1:");

		bank.depositMoney(account1, 1000);

		System.out.println(account1.getAccountName());
		System.out.println("No Transation in account2");
		
		System.out.println(account2.getAccountName());
		System.out.println("After withdrawing 5000 from account3:");
		
		bank.withdrawMoney(account3, 5000);
		System.out.println(account3.toString());
		
		
	}

}
