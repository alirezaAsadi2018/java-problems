package ir.javacup.onlinetaxi;

public class VIPTripMethod implements TripMethod {
    double rp = 3;
    double r = 2;
    double p = 2;
    @Override
    public int calcPrice(TripParam params) {
        int price = DistanceMap.distance[params.getSource()][params.getDestination()] * 10000;
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
