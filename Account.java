import java.util.Currency;
import java.util.Scanner;

public class Account {
    String customerName;
    String customerId;
    int balance;
    int prevTransaction;
    //constructor
    Account(String cname,String cid){
        System.out.println(); // just  for visual purpose
        customerName = cname;
        customerId = cid;
    }
    // depositing money
    void deposit(int amount){
        if(amount !=0){
            balance = balance + amount;
            prevTransaction = amount;
        }
    }
    // withdraw function
    void withdraw(int amount){

        if(amount!=0 && balance>=amount){
            balance = balance - amount;
            prevTransaction = -amount; // withdrawn -100(say)
        }
    }

    //previous transaction history
    void getPreviouTransaction(){
        if(prevTransaction > 0){
            System.out.println("Deposited: " + prevTransaction);
        }
        else if(prevTransaction<0){
            System.out.println("WithDraw: " + Math.abs(prevTransaction));
        }
        else{
            System.out.println("No transaction occured!");
        }
    }

    //Interest
    void calculateInterest(int years){
        float interestRate = 0.085F;// 8.5%
        double newBalance = (balance * interestRate * years) + balance;
        System.out.println("The current intersest rate is "+(10 * interestRate) + "%");
        System.out.println("After " + years + " years,your balance will be "+ newBalance);
    }

    // MENU function
    void showMenu() {
        int option;
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome " + customerName + "!");
        System.out.println("Your Id is: " + customerId);
        System.out.println();
        System.out.println("What would you like to do?");
        System.out.println();
        System.out.println("A. Check your Balance");
        System.out.println("B. Make a Deposit");
        System.out.println("C. Make a Withdrawal");
        System.out.println("D. View Previous Transaction");
        System.out.println("E. Calculate Interest");
        System.out.println("F. Exit");


        do {
            System.out.println();
            System.out.print("Enter an option: ");
            char opt1 = sc.next().charAt(0);
            option = Character.toUpperCase(opt1);
            System.out.println();

            switch (option) {
                case 'A':
                    System.out.println("===================");
                    System.out.println("Balance: " + balance);
                    System.out.println("===================");
                    break;

                case 'B':
                    System.out.print("Enter an amount to Deposit: ");
                    int amount1 = sc.nextInt();
                    deposit(amount1);
                    break;

                case 'C':
                    System.out.println("Enter an amount to withdraw");
                    int amount2 = sc.nextInt();
                    withdraw(amount2);
                    System.out.println();
                    break;

                case 'D':
                    System.out.println("===================");
                    getPreviouTransaction();
                    System.out.println("===================");
                    break;

                case 'E':
                    System.out.println("Enter how many years of accrued interest: ");
                    int years = sc.nextInt();
                    calculateInterest(years);
                    break;

                case 'F':
                    System.out.println("===================");
                    break;
                default:
                    System.out.println("ERROR! invalid option . Please enter A,B,C,D or E  to access services");
                    break;
            }


        } while (option != 'F');

        System.out.println("Thank You, Visit again !! ");

    }


}
