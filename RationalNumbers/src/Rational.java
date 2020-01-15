public class Rational {

    private int numerator;
    private int denominator;

    public Rational(int num, int den)
    {
        if(den>0)
        {
            numerator = num;
            denominator = den;
        }
        else if(den<0)
        {
            denominator=-den;
            numerator=-num;
        }
        else throw new IllegalArgumentException();
    }

    public Rational(int num)
    {
        numerator = num;
        denominator = 1;
    }

    public int getNum()
    {
        return numerator;
    }

    public int getDen()
    {
        return denominator;
    }

    public Rational add(Rational fraction)
    {
        int numADenB = numerator*fraction.getDen();
        int numBDenA = fraction.getNum()*denominator;
        int denADenB = denominator*fraction.getDen();
        int addTopATopB = numADenB + numBDenA;
        Rational result = new Rational(addTopATopB, denADenB);
        return result.simplify();
    }

    public Rational subtract(Rational fraction)
    {
        int numADenB = numerator*fraction.getDen();
        int numBDenA = fraction.getNum()*denominator;
        int denADenB = denominator*fraction.getDen();
        int subTopATopB = numADenB - numBDenA;
        Rational result = new Rational(subTopATopB, denADenB);
        return result.simplify();

    }

    public Rational multiply(Rational fraction)
    {
        int resultNum = numerator*fraction.getNum();
        int resultDen = denominator*fraction.getDen();
        Rational result = new Rational(resultNum, resultDen);
        return result.simplify();

    }

    public Rational divide(Rational fraction)
    {
        int resultNum = numerator*fraction.getDen();
        int resultDen = denominator*fraction.getNum();
        Rational result = new Rational(resultNum, resultDen);
        return result.simplify();
    }

    public boolean equals(Rational fraction)
    {
        int numADenB = numerator*fraction.getDen();
        int numBDenA = fraction.getNum()*denominator;

        if(numADenB == numBDenA)
            return true;

        return false;
    }

    public boolean isLessThan(Rational fraction)
    {
        int numADenB = numerator*fraction.getDen();
        int numBDenA = fraction.getNum()*denominator;

        if(numADenB < numBDenA)
            return true;

        return false;
    }

    public int gcd()
    {
        int valueA = denominator;
        int valueB = numerator;

        //Euclidian algorithm to find gcd.

        while(valueB!=0)
        {
            int remainder = valueB;
            valueB = valueA%valueB;
            valueA = remainder;
        }

        return valueA;
    }

    public Rational simplify()
    {
        return new Rational(numerator/gcd(),denominator/gcd());
    }

    public String toString()
    {
        // if you want a rational number with denominator of 1 to only return the numerator
        // (e.g. 13/1 -> 13), remove the comments from the following lines.

        //	if(denominator == 1)
        //		return "" + numerator;
        //	else
        return (denominator == 1) ? "" + numerator : numerator + "/" + denominator;


    }
}