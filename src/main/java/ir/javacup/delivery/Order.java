package ir.javacup.delivery;

public class Order {

    private String getName;
    private long phoneNumber;
    private double weight;

    public String getName() {
        return getName;
    }

    public void setName(String name) {
        this.getName = name;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object obj) {
        if (!obj.getClass().equals(Order.class))
            return false;
        Order that = (Order) obj;
        return this.getPhoneNumber() == that.getPhoneNumber()
                && this.getName.equals(that.getName)
                && this.getWeight() == that.getWeight();
    }

    @Override
    public int hashCode() {
        return getName.hashCode() * 51 + 37;
    }
}
