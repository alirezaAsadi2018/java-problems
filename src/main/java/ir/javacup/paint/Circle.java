package ir.javacup.paint;

public class Circle extends Shape {
	Double redius;

	public Circle(Color c, Pattern p, double r) {
		super(c, p);
		this.redius = r;
	}
	public boolean equals(Circle obj){
		return super.equals(obj) && this.redius.equals(obj.redius);
	}
	@Override
	public String toString() {
		return super.toString().replace("Shape", "Circle").replace("]", ", redius:" + redius.intValue() +"]");
	}

	public void setRedius(Double redius) {
		Circle c = new Circle(Color.BLUE, Pattern.DOTTED, 10);
		System.out.println(c);
	}
}

