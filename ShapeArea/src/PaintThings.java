
public class PaintThings {

	public static void main(String[] args) {
		Rectangle deck = new Rectangle("deck", 20, 35);
		Sphere bigBall = new Sphere("bigBall", 15);
		Cylinder tank = new Cylinder("tank", 10, 30);
		
		Paint redPaint = new Paint(350); //assigned a coverage of 300 to get the same results as the example output
		redPaint.amount((Shape) deck);
		redPaint.amount((Shape) bigBall);
		redPaint.amount((Shape) tank);
		

	}

}
