public class BankAccount {

    private String owner;
    private String accountNumber;
    private double balance;

    private static int accountsCount = 0;

    // Конструктор с нулевым балансом
    public BankAccount(String owner, String accountNumber) {
        this.owner = owner;
        this.accountNumber = accountNumber;
        this.balance = 0;
        accountsCount++;
    }

    // Конструктор с начальным балансом
    public BankAccount(String owner, String accountNumber, double balance) {
        this.owner = owner;
        this.accountNumber = accountNumber;

        if (balance >= 0) {
            this.balance = balance;
        } else {
            this.balance = 0;
        }

        accountsCount++;
    }

    // Пополнение счёта
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Счёт успешно пополнен.");
        } else {
            System.out.println("Ошибка: сумма пополнения должна быть больше 0.");
        }
    }

    // Снятие денег
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Ошибка: сумма снятия должна быть больше 0.");
        } else if (amount > balance) {
            System.out.println("Ошибка: недостаточно средств.");
        } else {
            balance -= amount;
            System.out.println("Деньги успешно сняты.");
        }
    }

    public String getOwner() {
        return owner;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public static int getAccountsCount() {
        return accountsCount;
    }
}
