package ir.javacup.accounting;

import java.util.*;

public class Accounting {
	private PriorityQueue<Health> healthList =
			new PriorityQueue<>(Comparator.comparing(Health::getPriority).reversed());
	private Queue<Grocery> groceryList = new LinkedList<>();
	private Stack<HomeAppliance> homeApplianceStack = new Stack<>();
	
	public void addCost(Cost cost) {
		if(cost instanceof Health)
			healthList.add((Health) cost);
		else if(cost instanceof Grocery)
			groceryList.add((Grocery) cost);
		else if(cost instanceof HomeAppliance)
			homeApplianceStack.add((HomeAppliance) cost);
	}

	public Cost getCost() {
		if(!healthList.isEmpty())
			return healthList.poll();
		else if(!groceryList.isEmpty())
			return groceryList.poll();
		else if(!homeApplianceStack.isEmpty())
			return homeApplianceStack.pop();
		return null;
	}

	public static void main(String[] args) {
		Accounting acc = new Accounting();
		acc.addCost(new Grocery(50000, "meat"));
		acc.addCost(new Health(100000, 1, "CalMagZink capsule"));
		acc.addCost(new HomeAppliance(4000000, "TV"));
		acc.addCost(new Health(60000, 4, "yearly check up"));
		acc.addCost(new Grocery(4000, "pancake powder"));
		acc.addCost(new HomeAppliance(600000, "pot"));
		
		System.out.println(acc.getCost());
		System.out.println(acc.getCost());
		System.out.println(acc.getCost());
		System.out.println(acc.getCost());
		System.out.println(acc.getCost());
		System.out.println(acc.getCost());
		System.out.println(acc.getCost());
	}

}
