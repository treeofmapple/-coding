package java_poo.Four_4;

import java.util.Objects;

public class Account {
	private String Name;
	private String AccountName;
	private double Balance;

	public Account() {
	}

	public Account(String name, String accountName, double balance) {
		this.Name = name;
		this.AccountName = accountName;
		this.Balance = balance;
	}

	public String getName() {
		return Name;
	}

	public String getAccountName() {
		return AccountName;
	}

	public double getBalance() {
		return Balance;
	}

	public void setName(String name) {
		Name = name;
	}

	public void setAccountName(String accountName) {
		this.AccountName = accountName;
	}

	public void setBalance(double balance) {
		this.Balance = balance;
	}

	public void deposit(double ammount) {
		Balance += ammount;
	}

	public void withdraw(double ammount) {
		Balance -= ammount;
	}

	@Override
	public int hashCode() {
		return Objects.hash(AccountName, Balance, Name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Account))
			return false;
		Account other = (Account) obj;
		return Objects.equals(AccountName, other.AccountName)
				&& Double.doubleToLongBits(Balance) == Double.doubleToLongBits(other.Balance)
				&& Objects.equals(Name, other.Name);
	}

	@Override
	public String toString() {
		return String.format("Account = [Name: %s, AccountName: %s, Balance: %s]", Name, AccountName, Balance);
	}
}
