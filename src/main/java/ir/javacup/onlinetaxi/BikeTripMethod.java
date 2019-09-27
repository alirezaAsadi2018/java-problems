package ir.javacup.onlinetaxi;

public class BikeTripMethod implements TripMethod {
    double rp = 1.5;
    double r = 0.8;
    double p = 2;
    @Override
    public int calcPrice(TripParam params) {
        int price = DistanceMap.distance[params.getSource()][params.getDestination()] * 4000;
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
