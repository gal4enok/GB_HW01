public class BankAccount {
    private int accountNumber;
    private int balance;


    public int get_balance() {
        return balance;
    }

    public void set_balance(int balance) {
        this.balance = balance;
    }

    public BankAccount(int accountNumber, int balance){
        this.accountNumber = accountNumber;
        this.balance = balance;

    }

    public void credit(int incomeAmount){
        this.balance+=incomeAmount;
    }

    public void debit(int outcomeAmount){

        if (this.balance >=outcomeAmount) {this.balance-=outcomeAmount;}
                else System.out.println("Debit amount is more than left amount");
    }

}
