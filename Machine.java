import java.util.*;
class BankAccount {
    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
        System.out.println("\nOpening Blanace is " + balance);
    }

    public boolean deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            return true;
        } 
        else {
            return false;
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= this.balance) {
            this.balance -= amount;
            return true;
        } 
        else {
            return false;
        }
    }

    public double checkBalance() {
        return this.balance;
    }
}

class ATM {
    private BankAccount bankAccount;

    public ATM(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    void Menu()
    {
        System.out.println("\nPress 1 for Withdrawing Money.");
        System.out.println("Press 2 for Depositing Money.");
        System.out.println("Press 3 for Checking the balance.");
        System.out.println("press 4 for Exit.");
    }

    public String withdraw(double amount) {
        if (amount > 0 && amount <= this.bankAccount.checkBalance()) {
            
            if (this.bankAccount.withdraw(amount)) {
                return "Withdrawal of " + amount + " successful.";
            } 
            else {
                return "Withdrawal failed. Please enter a valid amount.";
            }
        } 
        
        else {
            return "Insufficient funds. Please enter a valid amount.";
        }
    }

    public String deposit(double amount) {
        if (amount > 0) {
            
            if (this.bankAccount.deposit(amount)) {
                return "Deposit of " + amount + " successful.";
            } 
            else {
                return "Deposit failed. Please enter a valid amount.";
            }
        }
        
        else {
            return "Invalid amount. Please enter a valid amount.";
        }
    }

    public String checkBalance() {
        return "Current balance: " + this.bankAccount.checkBalance();
    }
}

public class Machine {
    public static void main(String[] args) throws Exception {
        BankAccount bankAccount = new BankAccount(1000);
        ATM atm = new ATM(bankAccount);
        System.out.println("----------------------------------------------");
        Scanner sc = new Scanner(System.in);

        atm.Menu();
        System.out.println("----------------------------------------------");
        try{
        while (true) {
        
        System.out.print("\nEnter Your Choise : ");
        int ch = sc.nextInt();
        
        switch (ch) {
            case 1:
            try{
                System.out.print("\nEnter Amount for Withdraw Money : ");
                int amt = sc.nextInt();
                System.out.println(atm.withdraw(amt));
            }
            catch(Exception e1)
            {
                System.out.println("\nInvalid");
            }
                break;
            
            case 2:
                try{
                System.out.print("\nEnter Amount for Deposite Money : ");
                int amt1 = sc.nextInt();
                System.out.println(atm.deposit(amt1));
                }
                catch(Exception e1)
                {
                    System.out.println("\nInvalid ");
                }
                break;
            
            case 3:
                System.out.println("\n" + atm.checkBalance());
                break;

            case 4:
                System.exit(0);

                break;

            default:
                System.out.println("\nEnter Valid Choise from Menu .");
                break;
        }
        System.out.println("----------------------------------------------");
    }
    }
    finally{
        sc.close();
    }
    }
}
