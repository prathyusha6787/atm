import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public boolean deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            return true;
        } else {
            return false;
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= this.balance) {
            this.balance -= amount;
            return true;
        } else {
            return false;
        }
    }
    1
    

    public double checkBalance() {
        return this.balance;
    }
}

class ATM {
    private BankAccount account;

    public ATM(BankAccount account) {
        this.account = account;
    }

    public void displayMenu() {
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            displayMenu();
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter the amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    scanner.nextLine(); 
                    if (account.withdraw(withdrawAmount)) {
                        System.out.println("Withdrawal successful. Remaining balance: $" + account.checkBalance());
                    } else {
                        System.out.println("Withdrawal failed. Insufficient funds.");
                    }
                    break;

                case "2":
                    System.out.print("Enter the amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    scanner.nextLine(); 
                    if (account.deposit(depositAmount)) {
                        System.out.println("Deposit successful. New balance: $" + account.checkBalance());
                    } else {
                        System.out.println("Deposit failed. Please enter a valid amount.");
                    }
                    break;

                case "3":
                    System.out.println("Current balance: $" + account.checkBalance());
                    break;

                case "4":
                    System.out.println("Exiting ATM. Thank you!");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
                    break;
            }
        }
    }
}

class Main {
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(2000); 
        ATM atmMachine = new ATM(userAccount);
        atmMachine.run();
    }
}