package ir.javacup.paint;

public class Shape {
	Color color;
	Pattern pattern;

	public Shape(Color c, Pattern p) {
		this.color = c;
		this.pattern = p;
	}
	public boolean equals(Shape obj) {
		return obj != null && obj.color == this.color && this.pattern == obj.pattern;
	}
	@Override
	public String toString() {
		return "Shape[color:" + color + ", pattern:"+ pattern + "]";
	}
}

enum Color {
	BLUE, GREEN, RED
}

enum Pattern {
	DOTTED, STRIPED, ZIGZAG
}
