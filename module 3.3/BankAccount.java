public class BankAccount {
    private static int totalAccounts;
    private final int accountNumber;
    private double balance;

    public BankAccount(double initialBalance) {
        if (!Double.isFinite(initialBalance) || initialBalance < 0) {
            throw new IllegalArgumentException("Initial balance must be finite and non-negative.");
        }
        balance = initialBalance;
        accountNumber = ++totalAccounts;
    }

    public int getAccountNumber() { return accountNumber; }
    public double getBalance() { return balance; }
    public static int getTotalAccounts() { return totalAccounts; }

    public void deposit(double amount) {
        validateAmount(amount);
        if (!Double.isFinite(balance + amount)) {
            throw new IllegalArgumentException("Deposit is too large.");
        }
        balance += amount;
    }

    public boolean withdraw(double amount) {
        validateAmount(amount);
        if (amount > balance) {
            return false;
        }
        balance -= amount;
        return true;
    }

    private static void validateAmount(double amount) {
        if (!Double.isFinite(amount) || amount <= 0) {
            throw new IllegalArgumentException("Amount must be finite and positive.");
        }
    }

    public static void main(String[] args) {
        BankAccount account1 = new BankAccount(1000);
        BankAccount account2 = new BankAccount(2000);
        account1.deposit(500);
        account2.withdraw(800);
        System.out.println("Account " + account1.getAccountNumber() + " balance: " + account1.getBalance());
        System.out.println("Account " + account2.getAccountNumber() + " balance: " + account2.getBalance());
        System.out.println("Total number of accounts: " + BankAccount.getTotalAccounts());
    }
}
