package ir.javacup.car;

public class Car {
	
	int weight;
	String color;
	String name;
	Car(){
		this("Fride", "White", 500);
	}
	Car(int weight){
		this("Fride", "White", weight);
	}
	Car(String name){
		this(name, "White", 500);
	}
	Car(String name, String color){
		this(name, color, 500);
	}
	Car(String name, String color, int weight){
		this.name = name;
		this.color = color;
		this.weight = weight;
	}
}
