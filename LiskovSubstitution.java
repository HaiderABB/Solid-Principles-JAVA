abstract class Account {
  public abstract void deposit(double amount);

  public abstract void withdraw(double amount);

  public abstract void CheckBalance();

  double AccountBalance;
}

// Savings Account Class

class SavingsAccount extends Account {

  public SavingsAccount() {
    AccountBalance = 0;
  }

  public void deposit(double amount) {
    System.out.println("Amount " + amount + " deposited in Savings Account");
    AccountBalance = AccountBalance + amount;
  }

  public void withdraw(double amount) {
    System.out.println("Amount " + amount + " in Savings Account");
    AccountBalance = AccountBalance - amount;
  }

  public void CheckBalance() {
    System.out.println("Your Account balance is " + AccountBalance);
  }

}

// Checking Account Class

class CheckingAccount extends Account {
  public CheckingAccount() {
    AccountBalance = 0;
  }

  public void deposit(double amount) {
    System.out.println("Amount " + amount + " deposited in Checking Account");
    AccountBalance = AccountBalance + amount;
  }

  public void withdraw(double amount) {
    System.out.println("Amount " + amount + " in Checking Account");
    AccountBalance = AccountBalance - amount;
  }

  public void CheckBalance() {
    System.out.println("Your Account balance is " + AccountBalance);
  }
}

public class LiskovSubstitution {
  public static void main(String[] args) {
    Account Saccount = new SavingsAccount();
    Account Caccount = new CheckingAccount();

    Saccount.deposit(2000);
    Saccount.CheckBalance();
    Saccount.withdraw(100);
    Saccount.CheckBalance();

    // Checking Account

    Caccount.deposit(2000);
    Caccount.CheckBalance();
    Caccount.withdraw(100);
    Caccount.CheckBalance();

  }
}