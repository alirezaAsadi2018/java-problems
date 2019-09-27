package ir.javacup.onlinetaxi;

public class EconomicTripMethod implements TripMethod {
    double rp = 1.4;
    double r = 1.2;
    double p = 1.2;
    @Override
    public int calcPrice(TripParam params) {
        int price = DistanceMap.distance[params.getSource()][params.getDestination()] * 5000;
        if(params.isRainy() && params.isPeakTime())
            return (int) (price * rp);
        else if(params.isRainy())
            return (int) (price * r);
        else if(params.isPeakTime())
            return (int) (price * p);
        else
            return price;
    }
}
