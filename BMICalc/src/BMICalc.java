import java.util.Scanner;
import javax.swing.JOptionPane;

public class BMICalc {
    public static void main (String [] args) {

        String weightInput = JOptionPane.showInputDialog("We will calculate your BMI using your weight and height."
                +"\n\nWhat is your weight (in kilograms)?");
        Scanner weightScanner = new Scanner(weightInput);
        double weight = weightScanner.nextDouble();
        weightScanner.close();

        String heightInput = JOptionPane.showInputDialog("What is your height (in metres)?");
        Scanner heightScanner = new Scanner(heightInput);
        double height = heightScanner.nextDouble();
        heightScanner.close();

        double heightSquare = height * height;
        double BMI = weight / heightSquare;

        JOptionPane.showMessageDialog(null, "Your BMI is " + BMI + ".");
    }
}
