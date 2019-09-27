package ir.javacup.traffic.impl;

import ir.javacup.traffic.Observable;
import ir.javacup.traffic.Subscriber;

import java.util.ArrayList;
import java.util.List;

public class TrafficObservable implements Observable<TrafficInfo> {
    private List<Subscriber<TrafficInfo>> subscribers = new ArrayList<>();
    @Override
    public void push(TrafficInfo obj) {
        for (Subscriber<TrafficInfo> subscriber : subscribers) {
            subscriber.onNext(obj);
        }
    }

    @Override
    public void subscribe(Subscriber<TrafficInfo> subscriber) {
        subscribers.add(subscriber);
    }
}
