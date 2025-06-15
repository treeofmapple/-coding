#include <iostream>
#include <string>

class BankAccount {
private:
    std::string owner;
    double balance;

public:
    // Constructor
    BankAccount(std::string name, double initialBalance) {
        owner = name;
        balance = initialBalance;
    }

    // Deposit method
    void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            std::cout << "Deposited: $" << amount << "\n";
        } else {
            std::cout << "Invalid deposit amount!\n";
        }
    }

    // Withdraw method
    void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            std::cout << "Withdrawn: $" << amount << "\n";
        } else {
            std::cout << "Invalid withdrawal amount or insufficient funds!\n";
        }
    }

    // Display account details
    void display() const {
        std::cout << "Account Owner: " << owner << "\n";
        std::cout << "Current Balance: $" << balance << "\n";
    }
};

int main() {
    // Create a bank account
    BankAccount account("Alice", 1000.0);

    // Perform transactions
    account.display();
    account.deposit(500.0);
    account.withdraw(200.0);
    account.display();

    return 0;
}
