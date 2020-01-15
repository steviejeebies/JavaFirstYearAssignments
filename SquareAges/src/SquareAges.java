public class SquareAges {

    public static final int CURRENT_YEAR = 2018;
    public static final int MAX_AGE = 123;

    public static void main(String[] args) {

        for(int age = 0; age <= MAX_AGE; age++)
        {
            int yearOfAgeSquared = age * age;
            int yearBorn = yearOfAgeSquared - age;
            int earliestPossibleYearBorn = CURRENT_YEAR - MAX_AGE;

            if(yearBorn >= earliestPossibleYearBorn && yearBorn <= CURRENT_YEAR)
            {
                System.out.println(age + " squared is " +
                        yearOfAgeSquared + ". A person born in "
                        + yearBorn  + " will be " + age + " in "
                        + yearOfAgeSquared + ", and is alive today.");
            }
        }
    }
}
