
public class Rectangle extends Shape {
	private double length;
	private double width;

	public Rectangle(String name, int length, int width) {
		super("Rectangle \"" + name + "\"");
		this.length = length;
		this.width = width;
	}

	@Override
	public double area() {
		double rectangleArea = length * width;
		return rectangleArea;
	}

	@Override
	public String toString()
	{
		return super.toString() + " of length " + length + " and width " + width;
	}
}
