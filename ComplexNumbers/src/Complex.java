
public class Complex {

    private double x;
    private double y;

    public Complex()
    {
        x = 0;
        y = 0;
    }

    public Complex(double realPart, double imaginaryPart)
    {
        x = realPart;
        y = imaginaryPart;
    }

    public double getReal()
    {
        return x;
    }

    public double getImaginary()
    {
        return y;
    }

    public static Complex add(Complex a, Complex b)
    {
        double realSum = a.getReal() + b.getReal();
        double imagSum = a.getImaginary() + b.getImaginary();
        Complex result = new Complex(realSum, imagSum);

        return result;
    }

    public static Complex multiply(Complex a, Complex b)
    {
        double realMul = (a.getReal()*b.getReal()) - a.getImaginary()*b.getImaginary();
        double imagMul = (a.getReal()*b.getImaginary()) + a.getImaginary()*b.getReal();
        Complex result = new Complex(realMul, imagMul);

        return result;
    }

    public static String toString(Complex a)
    {
        double realNum = a.getReal();
        double imagNum = a.getImaginary();
        // if realNum or imagNum don't have any numbers after their decimal point, then we don't want to print
        // x.0, we just want to print x.
        String realString = (realNum/(int)realNum == 1) ? (int) realNum + "" : realNum + "";
        String imagString = (imagNum/(int)imagNum == 1) ? (int) imagNum + "" : imagNum + "";

        return realString + " i" + imagString;
    }
}
