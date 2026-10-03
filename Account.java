import java.util.Scanner;
import java.util.ArrayList;
class BankAccount{
    private int accountNumber;
    private String accountHolder;
    private double balance;
    static int totalAccounts=0;
    static String bankName="Utkarsh Bank";
    BankAccount(String accountHolder,double balance){
        totalAccounts++;
        accountNumber=totalAccounts;
        this.accountHolder=accountHolder;
        this.balance=balance;
    }
    void deposit(double amount){
        if(amount>0){
            balance=balance+amount;
        }
    }
    void withdraw(double amount){
        if(amount>0&&amount<=balance){
            balance=balance-amount;
        }
    }
    static int getTotalAccounts(){
        return totalAccounts;
    }
    void displayDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: " + balance);
        System.out.println();
    }
    int getAccountNumber(){
        return accountNumber;
    }
}
public class Account{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<BankAccount> accounts=new ArrayList<>();
        for(int i=0;i<n;i++) {
            String name=sc.next();
            double balance=sc.nextDouble();
            BankAccount account =new BankAccount(name, balance);
            accounts.add(account);
        }
        int m=sc.nextInt();
        for(int i = 0; i < m; i++){
            int accountNumber = sc.nextInt();
            String type = sc.next();
            double amount = sc.nextDouble();
            BankAccount account = accounts.get(accountNumber-1);
            if(type.equals("DEPOSIT")){
                account.deposit(amount);
            } else if(type.equals("WITHDRAW")){
                account.withdraw(amount);
            }
        }
        for(int i=0;i<accounts.size();i++){
            accounts.get(i).displayDetails();
        }
        System.out.println("Total Accounts: " + BankAccount.getTotalAccounts());
        sc.close();
    }
}
