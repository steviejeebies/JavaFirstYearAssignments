
public class Sphere extends Shape{
	private double radius;
	public Sphere(String name, int radius) {
		super("Sphere \"" + name + "\"");
		this.radius = radius;
	}

	@Override
	 public double area()
	 {
		double sphereArea = 4*(Math.PI)*(radius*radius);
		return sphereArea;
	 }
	
	@Override
	public String toString()
	{
		return super.toString() + " of radius " + radius;
	}
}
