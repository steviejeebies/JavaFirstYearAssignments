public class ComplexNumbers {

    public static void main(String[] args) {
        Complex test1 = new Complex(3,5);
        Complex test2 = new Complex(4,3);
        System.out.println("Our numbers are " + Complex.toString(test1) + ", and " + Complex.toString(test2));

        Complex addResult = Complex.add(test1, test2);
        Complex mulResult = Complex.multiply(test1, test2);

        String result1 = Complex.toString(addResult);
        String result2 = Complex.toString(mulResult);

        System.out.println("The result of addition is " + result1);
        System.out.println("The result of multiplication is " + result2);
    }
}
