import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

class Main{
    static Denominations d = new Denominations(20, 100, 100);
    static int total_atm_balance;
    static Customers c1 = new Customers(101, "Suresh", "2343", 25234);
    static Customers c2 = new Customers(102, "Ganesh", "5432", 34123);
    static Customers c3 = new Customers(103, "Magesh", "7854", 26100);
    static Customers c4 = new Customers(104, "Naresh", "2345", 80000);
    static Customers c5 = new Customers(105, "Harish", "1907", 103400);
    public static void loadCash(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of Two Thousands: ");
        d.setTwo_thousands(d.getTwo_thousands() + sc.nextInt());
        total_atm_balance += 2000 * d.getTwo_thousands();
        System.out.println("Enter the number of Five Hundreds: ");
        d.setFive_hundreds(d.getFive_hundreds() + sc.nextInt());
        total_atm_balance += 500 * d.getFive_hundreds();
        System.out.println("Enter the number of Hundreds");
        d.setHundreds(d.getHundreds() + sc.nextInt());
        total_atm_balance += 100 * d.getHundreds();
        System.out.println("Successfully Loaded");
    }
    public static void getATMBalance(){
        System.out.println("Currency    Count   Total");
        System.out.format("%8s %8s %7s", 2000, d.getTwo_thousands(), 2000* d.getTwo_thousands());
        System.out.println();
        System.out.format("%8s %8s %7s", 500, d.getFive_hundreds(), 500* d.getFive_hundreds());
        System.out.println();
        System.out.format("%8s %8s %7s", 100, d.getHundreds(), 100* d.getHundreds());
        System.out.println();
    }
    public static void getCustomers(ArrayList<Customers> cl){
        System.out.println("Acc_no\tName\tPin\t\tBalance");
        for (Customers c:
            cl) {
            System.out.println(c.getAcc_no() + "\t\t" + c.getName() + "\t" + c.getPin() + "\t" + c.getAcc_balance() );
        }
    }
    public static Customers identifyUser(ArrayList<Customers> cl, int acc_no){
        for (Customers customer : cl) {
            if (customer.getAcc_no() == acc_no) {
                return customer;
            }
        }
        return null;
    }
    public static int checkBalance(Customers c){
        return c.getAcc_balance();
    }
    public static void transferMoney(Customers c1, Customers c2, int amount){
        if(amount < 1000 || amount > 10000){
            System.out.println("Invalid amount");
        }
        else if(c1.getAcc_balance() - amount < 0){
            System.out.println("Insufficient Balance to proceed transaction");
        }
        else{
            c1.setAcc_balance(c1.getAcc_balance() - amount);
            c2.setAcc_balance(c2.getAcc_balance() + amount);
            System.out.println("Transaction successful");
        }
    }
    public static void withdrawMoney(Customers c, int amount, Denominations d){
        if(amount < 100 || amount > 10000){
            System.out.println("Invalid amount");
            return;
        }
        if(amount > total_atm_balance){
            System.out.println("The ATM has insufficient funds");
            return;
        }
        if(amount > c.getAcc_balance()){
            System.out.println("Insufficient balance");
            return;
        }
        c.setAcc_balance(c.getAcc_balance() - amount);
        if(amount / 2000 > 0){
            int a = amount / 2000;
            if(d.getTwo_thousands() < a){
                a = d.getTwo_thousands();
            }
            amount -= a * 2000;
            d.setTwo_thousands(d.getTwo_thousands() - a);
        }
        if(amount / 500 > 0){
            int a = amount / 500;
            if(d.getFive_hundreds() < a){
                a = d.getFive_hundreds();
            }
            amount -= a * 500;
            d.setFive_hundreds(d.getFive_hundreds() - a);
        }
        if(amount / 100 > 0){
            int a = amount / 100;
            if(d.getHundreds() < a){
                a = d.getHundreds();
            }
            d.setHundreds(d.getHundreds() - a);
        }
    }
    public static void atmOperations(ArrayList<Customers> cl){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the account number:");
        int acc_no = sc.nextInt();
        Customers c = identifyUser(cl ,acc_no);
        System.out.println("Enter the PIN number:");
        String pin = sc.next();
        if(! c.getPin().equals(pin)){
            System.out.println("Invalid Pin");
            return;
        }

        int x = 50;
        while (x != 0) {
            System.out.println("Press 1 to check balance: ");
            System.out.println("Press 2 to withdraw money");
            System.out.println("Press 3 to transfer money");
            System.out.println("Press 4 to Check ATM balance");
            System.out.println("Press 5 to go back to main page");
            x = sc.nextInt();
            switch (x) {
                case 1 -> System.out.println(checkBalance(c));
                case 2 -> {
                    System.out.println("Enter amount to be withdrawn");
                    int amount = sc.nextInt();
                    withdrawMoney(c, amount, d);
                }
                case 3 -> {
                    System.out.println("Enter receiver account number");
                    int receiver_acc_no = sc.nextInt();
                    Customers receiver = identifyUser(cl, receiver_acc_no);
                    System.out.println("Enter amount to be transferred");
                    int amount = sc.nextInt();
                    transferMoney(c, receiver, amount);
                }
                case 4 -> {
                    getATMBalance();
                }
                case 5 -> {
                    x = 0;
                }
                default -> {
                    System.out.println("Invalid option");
                }
            }

        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Customers> cl = new ArrayList<Customers>();
        cl.add(c1);
        cl.add(c2);
        cl.add(c3);
        cl.add(c4);
        cl.add(c5);
        int x = 50;
        while(x != 0){
            System.out.println("Press 1 to load cash\nPress 2 to show customer details\nPress 3 to show ATM operations\nPress 4 to exit");
            x = sc.nextInt();
            switch (x) {
                case 1 -> loadCash();
                case 2 -> getCustomers(cl);
                case 3 -> atmOperations(cl);
                case 4 -> x = 0;
                default -> System.out.println("Invalid input");
            }
        }

    }


}