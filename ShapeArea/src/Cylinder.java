
public class Cylinder extends Shape{
	private double radius;
	private double height;
	public Cylinder(String name, int radius, int height) {
		super("Cylinder \"" + name + "\"");
		this.radius = radius;
		this.height = height;
	}

	@Override
	 public double area()
	 {
		double cylinderArea = Math.PI*(radius*radius)*height;
		return cylinderArea;
	 }

	@Override
	public String toString()
	{
		return super.toString() + " of radius " + radius + " and height " + height;
	}

}
