package ir.javacup.onlinetaxi;

public class Main {
    public static void main(String[] args) {
        TripHandler taxi = TripHandler.getInstance();

        int price = taxi.calcPrice("vip", new TripParam(1, 1, true, false));
        int price2 = new VIPTripMethod().calcPrice(new TripParam(1, 1, true, false));
        System.out.println(price + " = " + price2);

        price = taxi.calcPrice("bike", new TripParam(2, 4, true, true));
        price2 = new BikeTripMethod().calcPrice(new TripParam(2, 4, true, true));
        System.out.println(price + " = " + price2);
    }
}
