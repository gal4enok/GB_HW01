public class BankAccount {
    private int _accountNumber;
    private int _balance;


    public int get_balance() {
        return _balance;
    }

    public void set_balance(int _balance) {
        this._balance = _balance;
    }

    public BankAccount(int accountNumber, int balance){
        this._accountNumber = accountNumber;
        this._balance = balance;

    }
    public void credit(int incomeAmount){
        this._balance+=incomeAmount;
    }

    public void debit(int outcomeAmount){

        if (this._balance >=outcomeAmount) {this._balance-=outcomeAmount;}
                else System.out.println("Debit amount is more than left amount");
    }

}
