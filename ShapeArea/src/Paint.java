public class Paint {
	private double coverage;
	
	Paint(double coverage){
		this.coverage = coverage;
	}
	
	public double amount(Shape theShape)
	{
		double paintNeeded = theShape.area()/coverage;
		
		System.out.println("Computing the area for " + theShape.toString() + "... \n"
				+ "Amount of paint required is " + paintNeeded);
		
		return paintNeeded;
	}
}
