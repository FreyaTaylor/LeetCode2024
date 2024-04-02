package src._JavaBasic;

public class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public synchronized void deposit(double amount) {
        System.out.println("Deposit: " + amount);
        this.balance += amount;
        System.out.println("Current Balance: " + this.balance);
    }

    public synchronized void withdraw(double amount) {
        if (this.balance >= amount) {
            System.out.println("Withdraw: " + amount);
            this.balance -= amount;
            System.out.println("Current Balance: " + this.balance);
        } else {
            System.out.println("Insufficient balance for withdrawal.");
        }
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000);

        // 创建并启动存款线程
        Thread depositThread = new Thread(() -> {
            account.deposit(500);
        });
        depositThread.start();

        // 创建并启动取款线程
        Thread withdrawThread = new Thread(() -> {
            account.withdraw(200);
        });
        withdrawThread.start();
    }
}

