package java_poo.Four_4;

import java.util.ArrayList;
import java.util.Objects;

public class Bank {

	private ArrayList<Account> accounts;

	public Bank() {
		accounts = new ArrayList<Account>();
	}

	public ArrayList<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(ArrayList<Account> accounts) {
		this.accounts = accounts;
	}

	public void addAccount(Account account) {
		accounts.add(account);
	}

	public void removeAccount(Account account) {
		accounts.remove(account);
	}

	public void depositMoney(Account account, double ammount) {
		account.deposit(ammount);
	}

	public void withdrawMoney(Account account, double ammount) {
		account.withdraw(ammount);
	}

	@Override
	public int hashCode() {
		return Objects.hash(accounts);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Bank))
			return false;
		Bank other = (Bank) obj;
		return Objects.equals(accounts, other.accounts);
	}

	@Override
	public String toString() {
		return String.format("Bank = [accounts: %s]", accounts);
	}

}
