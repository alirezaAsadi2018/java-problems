package ir.javacup.bankTest;

public class CheckingAccount extends BankAccount {
    private double overdraftAmount;

    public CheckingAccount(String customerNationalId, String accountNumber, double balance, double overdraftAmount) {
        super(customerNationalId, accountNumber, balance);
        this.overdraftAmount = overdraftAmount;
    }

    public double getOverdraftAmount() {
        return overdraftAmount;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof CheckingAccount))
            return false;
        return super.equals(obj);
    }
}
