package ir.javacup.banking;

public class CreditCard {
    private String cardNumber;
    private double credit;

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardName) {
        this.cardNumber = cardName;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }
}