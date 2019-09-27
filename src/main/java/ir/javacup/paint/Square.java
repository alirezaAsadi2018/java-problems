package ir.javacup.paint;

public class Square extends Shape {

	Integer length;

	public Square(Color c, Pattern p, int length) {
		super(c, p);
		this.length = length; // autoboxing

	}
	public boolean equals(Square obj){
		return super.equals(obj) && this.length.equals(obj.length);
	}
	@Override
	public String toString() {
		return super.toString().replace("Shape", "Square").replace("]", ", length:" + length +"]");
	}
}
