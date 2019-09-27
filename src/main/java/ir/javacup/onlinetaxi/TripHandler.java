package ir.javacup.onlinetaxi;

public class TripHandler {
    private static TripHandler instance = new TripHandler();
    private BikeTripMethod bikeTripMethod = new BikeTripMethod();
    private VIPTripMethod vipTripMethod = new VIPTripMethod();
    private EconomicTripMethod economicTripMethod = new EconomicTripMethod();

    private TripHandler() {

    }

    public static TripHandler getInstance() {
        return instance;
    }

    public int calcPrice(String type, TripParam params) {
        switch (type) {
            case "bike":
                return bikeTripMethod.calcPrice(params);
            case "economic":
                return economicTripMethod.calcPrice(params);
            case "vip":
                return vipTripMethod.calcPrice(params);
            default:
                return 0;
        }
    }

}
