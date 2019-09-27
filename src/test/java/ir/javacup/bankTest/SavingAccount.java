package ir.javacup.bankTest;

public class SavingAccount extends BankAccount {
    private double interestAmount;

    public SavingAccount(String customerNationalId, String accountNumber, double balance, double interestAmount) {
        super(customerNationalId, accountNumber, balance);
        this.interestAmount = interestAmount;
    }

    public double getInterestAmount() {
        return interestAmount;
    }

    public void addInterest() {
        balance += balance * interestAmount;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof SavingAccount))
            return false;
        return super.equals(obj);
    }
}
