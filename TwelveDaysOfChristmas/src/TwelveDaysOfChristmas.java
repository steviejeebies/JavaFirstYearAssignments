public class TwelveDaysOfChristmas {

    public static final int TOTAL_DAYS = 12;
    public static final int FIRST_DAY = 1;
    public static final String TWELFTH_LINE = "12 Drummers Drumming";
    public static final String ELEVENTH_LINE = "11 Pipers Piping";
    public static final String TENTH_LINE = "10 Lords a Leaping";
    public static final String NINTH_LINE = "9 Ladies Dancing";
    public static final String EIGHTH_LINE = "8 Maids a Milking";
    public static final String SEVENTH_LINE = "7 Swans a Swimming";
    public static final String SIXTH_LINE = "6 Geese a Laying";
    public static final String FIFTH_LINE = "5 Golden Rings";
    public static final String FOURTH_LINE = "4 Calling Birds";
    public static final String THIRD_LINE = "3 French Hens";
    public static final String SECOND_LINE = "2 Turtle Doves";
    public static final String FIRST_LINE = "Partridge in a Pear Tree";

    public static void main(String[] args) {
        int currentDayNumber = 0;
        String currentDayName = null;

        do
        {
            currentDayNumber++;

            switch(currentDayNumber)
            {
                case 1:
                    currentDayName = "first";
                    break;
                case 2:
                    currentDayName = "second";
                    break;
                case 3:
                    currentDayName = "third";
                    break;
                case 4:
                    currentDayName = "fourth";
                    break;
                case 5:
                    currentDayName = "fifth";
                    break;
                case 6:
                    currentDayName = "sixth";
                    break;
                case 7:
                    currentDayName = "seventh";
                    break;
                case 8:
                    currentDayName = "eighth";
                    break;
                case 9:
                    currentDayName = "ninth";
                    break;
                case 10:
                    currentDayName = "tenth";
                    break;
                case 11:
                    currentDayName = "eleventh";
                    break;
                case 12:
                    currentDayName = "twelfth";
                    break;
            }

            System.out.println("On the " + currentDayName
                    + " day of Christmas \nmy true love sent to me:");

            switch(currentDayNumber)
            {
                case 12:
                    System.out.println(TWELFTH_LINE);
                case 11:
                    System.out.println(ELEVENTH_LINE);
                case 10:
                    System.out.println(TENTH_LINE);
                case 9:
                    System.out.println(NINTH_LINE);
                case 8:
                    System.out.println(EIGHTH_LINE);
                case 7:
                    System.out.println(SEVENTH_LINE);
                case 6:
                    System.out.println(SIXTH_LINE);
                case 5:
                    System.out.println(FIFTH_LINE);
                case 4:
                    System.out.println(FOURTH_LINE);
                case 3:
                    System.out.println(THIRD_LINE);
                case 2:
                    System.out.println(SECOND_LINE);
                case 1:
                    System.out.println(
                            ((currentDayNumber != FIRST_DAY) ? "And a " : "A ") + FIRST_LINE);
            }

            System.out.println("");  //For blank line between verses.

        }while(currentDayNumber < TOTAL_DAYS);

    }
}
