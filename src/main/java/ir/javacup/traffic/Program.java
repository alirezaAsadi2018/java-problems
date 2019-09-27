package ir.javacup.traffic;

import java.util.Arrays;
import java.util.List;

import ir.javacup.traffic.impl.TrafficInfo;
import ir.javacup.traffic.impl.TrafficInfoTransformer;
import ir.javacup.traffic.impl.TrafficObservable;

public class Program {
	
	public static void main(String[] args) {
		Subscriber<TrafficInfo> subscriber1 = obj -> System.out.println("#1: " + obj);
		Subscriber<TrafficInfo> subscriber2 = obj -> System.out.println("#2: " + obj);
		
		Observable<TrafficInfo> observable = new TrafficObservable();
		Transformer<TrafficInfo, String> transformer = new TrafficInfoTransformer();
		
		// MTAyMDEsMDM= : 10201,03
		// MTA0NTEsMDk= : 10451,09
		List<String> inputs = Arrays.asList("MTAyMDEsMDM=","MTA0NTEsMDk="); 
		
		new ir.javacup.traffic.Context<TrafficInfo, String>()
			.observable(observable)
			.transformer(transformer)
			.subscriber(subscriber1)
			.subscriber(subscriber2)
			.run(inputs);
	}

}
