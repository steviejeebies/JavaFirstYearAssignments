public class TriangularStars {

    public static void main(String[] args) {

        int triangleNumber = 1;
        int starIncrement = 0;
        System.out.println("The following are triangular-star numbers:");


        for(int triangleIncrement = 1; triangleNumber > 0 ;triangleIncrement++)
        {
            triangleNumber = determineTriangleNumber(triangleIncrement);
            starIncrement = 0;

            if(isStarNumber(triangleNumber, starIncrement))
                System.out.println(triangleNumber + "...");
        }

        //above for loop repeats until triangleNumber becomes negative, i.e. surpasses
        //Integer.MAX_VALUE. starIncrement resets back to zero for every triangleNumber
        //tested.

        System.out.println("Done.");

    }

    public static int determineTriangleNumber(int increment)
    {
        int currentNValue = increment;
        int triangleNumber = 1;

        while(currentNValue > 1)	//if currentNValue = 1, triangleNumber remains 1.
        {
            triangleNumber += currentNValue;
            currentNValue--;
        }

        return triangleNumber;
    }

    public static boolean isStarNumber(int testedNumber, int starIncrement)

    {
        int starNumberOfIncrement = (6 * starIncrement) * (starIncrement - 1) + 1;

        if(starNumberOfIncrement < testedNumber)
        {
            starIncrement++;
            return isStarNumber(testedNumber, starIncrement);	//recursive function
        }

        return (testedNumber == starNumberOfIncrement);
    }


}
