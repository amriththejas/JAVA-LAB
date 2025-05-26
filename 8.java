// Custom exception class
class LessBalanceException extends Exception {
    public LessBalanceException(double amount) {
        super("Withdraw amount ₹" + amount + " is not possible. Minimum balance ₹500 must be maintained.");
    }
}

// Account class
class Account {
    double balance;
    static final double MIN_BALANCE = 500;

    public Account() {
        balance = MIN_BALANCE;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited ₹" + amount + ". Current Balance: ₹" + balance);
    }

    public void withdraw(double amount) throws LessBalanceException {
        if (balance - amount < MIN_BALANCE) {
            throw new LessBalanceException(amount);
        } else {
            balance -= amount;
            System.out.println("Withdrew ₹" + amount + ". Current Balance: ₹" + balance);
        }
    }

    public double getBalance() {
        return balance;
    }
}

// Main class to test the program
public class BankApplication {
    public static void main(String[] args) {
        Account acc1 = new Account();
        Account acc2 = new Account();

        acc1.deposit(1000);
        acc2.deposit(1500);

        try {
            acc1.withdraw(600); // Should work
            acc2.withdraw(1200); // Should throw exception
        } catch (LessBalanceException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}






Deposited ₹1000.0. Current Balance: ₹1500.0
Deposited ₹1500.0. Current Balance: ₹2000.0
Withdrew ₹600.0. Current Balance: ₹900.0
Exception: Withdraw amount ₹1200.0 is not possible. Minimum balance ₹500 must be maintained.