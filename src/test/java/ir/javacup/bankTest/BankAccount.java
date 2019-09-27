package ir.javacup.bankTest;

public class BankAccount {
    protected String customerNationalId;
    protected String accountNumber;
    protected double balance;

    public BankAccount(String customerNationalId, String accountNumber, double balance) {
        this.customerNationalId = customerNationalId;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void withdraw(double v) {
        if(v < 0)
            throw new IllegalArgumentException("Sorry, you can not withdraw a negative amount");
        if(v > balance)
            throw new RuntimeException("Your balance is not enough");
        balance -= v;
    }

    public String getCustomerNationalId(){
        return customerNationalId;
    }
    public String getAccountNumber(){
        return accountNumber;
    }
    public double getBalance() {
        return balance;
    }

    public void deposit(double v) {
        balance += v;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof BankAccount))
            return false;
        BankAccount that = (BankAccount) obj;
        return this.accountNumber.equals(that.accountNumber)
                && this.customerNationalId.equals(that.customerNationalId);
    }
}
