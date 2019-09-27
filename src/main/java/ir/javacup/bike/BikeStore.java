package ir.javacup.bike;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class BikeStore {
	Map<String, Long> borrowTimeMap = new HashMap<>();
	List<Bike> bikes = new LinkedList<>();
	List<Bike> borrowedBikes = new LinkedList<>();
	List<String> damagedBikes = new LinkedList<>();
	private BikeProvider provider;
	private Clock clock;
	private long expireTime;
	
	// TODO

	public BikeStore(BikeProvider provider, Clock clock, long expireTime) {
		this.provider = provider;
		this.clock = clock;
		this.expireTime = expireTime;
	}

	public Bike borrow() {
		for (Bike bike : bikes) {
			if(borrowedBikes.contains(bike))
				continue;
			if(damagedBikes.contains(bike.getId())){
				provider.repair(bike);
				damagedBikes.remove(bike.getId());
			}else{
				borrowTimeMap.put(bike.getId(), clock.getCurrentTime());
				borrowedBikes.add(bike);
				return bike;
			}
		}
		for (Bike borrowedBike : borrowedBikes) {
			if(borrowTimeMap.get(borrowedBike.getId()) + expireTime < clock.getCurrentTime()){
				borrowTimeMap.put(borrowedBike.getId(), clock.getCurrentTime());
				return borrowedBike;
			}
		}
		Bike bike = provider.provide();
		bikes.add(bike);
		borrowTimeMap.put(bike.getId(), clock.getCurrentTime());
		borrowedBikes.add(bike);
		return bike;
	}

	public void restore(Bike bike, boolean needsRepair) {
		if(!borrowedBikes.contains(bike))
			throw new IllegalArgumentException("this bike doesn't belong to our shop!");
		borrowedBikes.remove(bike);
		if(needsRepair)
			damagedBikes.add(bike.getId());
	}
	
	public int borrowedCount() {
		return borrowedBikes.size();
	}
}
