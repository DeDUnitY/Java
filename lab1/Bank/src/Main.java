import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Создание банковских счетов
        BankAccount[] accounts = {
                new BankAccount("Иван Иванов", "1001", 5000),
                new BankAccount("Пётр Петров", "1002", 10000),
                new BankAccount("Анна Сидорова", "1003")
        };

        BankAccount currentAccount = accounts[0];

        boolean running = true;

        while (running) {

            System.out.println("\n===== БАНК =====");
            System.out.println("Текущий счёт: " +
                    currentAccount.getAccountNumber());
            System.out.println("1. Просмотреть список счетов");
            System.out.println("2. Просмотреть информацию о счёте");
            System.out.println("3. Пополнить счёт");
            System.out.println("4. Снять деньги");
            System.out.println("5. Сменить счёт");
            System.out.println("6. Количество созданных счетов");
            System.out.println("0. Выход");
            System.out.print("Выберите пункт: ");

            String input = scanner.nextLine();

            switch (input) {

                case "1":
                    System.out.println("\n--- Список счетов ---");

                    for (int i = 0; i < accounts.length; i++) {
                        System.out.println(
                                (i + 1) + ". " +
                                        accounts[i].getOwner() +
                                        " | Счёт: " +
                                        accounts[i].getAccountNumber()
                        );
                    }
                    break;

                case "2":
                    System.out.println("\n--- Информация о счёте ---");
                    System.out.println("Владелец: " +
                            currentAccount.getOwner());
                    System.out.println("Номер счёта: " +
                            currentAccount.getAccountNumber());
                    System.out.println("Баланс: " +
                            currentAccount.getBalance());
                    break;

                case "3":
                    System.out.print("Введите сумму пополнения: ");

                    try {
                        double amount = Double.parseDouble(scanner.nextLine());
                        currentAccount.deposit(amount);
                    } catch (NumberFormatException e) {
                        System.out.println(
                                "Ошибка: необходимо ввести число."
                        );
                    }
                    break;

                case "4":
                    System.out.print("Введите сумму снятия: ");

                    try {
                        double amount = Double.parseDouble(scanner.nextLine());
                        currentAccount.withdraw(amount);
                    } catch (NumberFormatException e) {
                        System.out.println(
                                "Ошибка: необходимо ввести число."
                        );
                    }
                    break;

                case "5":
                    System.out.println("\n--- Выбор счёта ---");

                    for (int i = 0; i < accounts.length; i++) {
                        System.out.println(
                                (i + 1) + ". " +
                                        accounts[i].getOwner() +
                                        " | " +
                                        accounts[i].getAccountNumber()
                        );
                    }

                    System.out.print("Введите номер элемента: ");

                    try {
                        int number = Integer.parseInt(scanner.nextLine());

                        if (number >= 1 && number <= accounts.length) {
                            currentAccount = accounts[number - 1];

                            System.out.println(
                                    "Выбран счёт: " +
                                            currentAccount.getAccountNumber()
                            );
                        } else {
                            System.out.println(
                                    "Ошибка: такого счёта нет."
                            );
                        }

                    } catch (NumberFormatException e) {
                        System.out.println(
                                "Ошибка: необходимо ввести целое число."
                        );
                    }
                    break;

                case "6":
                    System.out.println(
                            "Количество созданных счетов: " +
                                    BankAccount.getAccountsCount()
                    );
                    break;

                case "0":
                    running = false;
                    System.out.println("Программа завершена.");
                    break;

                default:
                    System.out.println(
                            "Ошибка: такого пункта меню нет."
                    );
            }
        }

        scanner.close();
    }
}

