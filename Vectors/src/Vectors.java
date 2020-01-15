
public class Vectors {

    public static void main(String[] args) {
        double[] input = new double[]{1,2,3,4,5,6,7,8,9,10};
        double vectorMagnitude = vectorMagnitude(input);
        double[] normalise = normalise(input, vectorMagnitude);

        for(int index = 0; index<input.length; index++)
        {
            System.out.println(input[index]);
        }
    }

    public static double vectorMagnitude(double[] input) {

        double magnitudeTemp = 0;

        for(int index = 0; index<input.length; index++)
        {
            magnitudeTemp += Math.pow(input[index], 2);
        }

        double magnitude = Math.pow((Math.sqrt(magnitudeTemp)), 2);
        return magnitude;
    }

    public static double[] normalise(double[] input, double vectorMagnitude)
    {
        double[] normalise = new double[input.length];
        for(int index = 0; index<input.length; index++)
        {
            double currentValue = input[index];
            normalise[index] = currentValue / vectorMagnitude;
        }

        return normalise;
    }


}
