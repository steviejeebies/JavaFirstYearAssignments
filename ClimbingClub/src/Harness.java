public class Harness {
    final int MAX_TIMES_USED = 25;
    private String brand;
    private int modelNumber;
    private int timesUsed;
    private String lastInstructor;
    private boolean onLoan;
    private String memberOnLoan;

    public Harness(String make, int modelNum, int numUsed, String instructor, boolean isOnLoan, String loanMember)
    {
        brand = make;
        modelNumber = modelNum;
        timesUsed = numUsed;
        lastInstructor = instructor;
        onLoan = isOnLoan;
        memberOnLoan = (onLoan?loanMember:"None");
    }

    public Harness(String make, int modelNum, String instructor)
    {
        brand = make;
        modelNumber = modelNum;
        timesUsed = 0;
        lastInstructor = instructor;
        onLoan = false;
        memberOnLoan = "None";
    }

    public void checkHarness(String instructorChecking)
    {
        if(!onLoan)
        {
            lastInstructor = instructorChecking;
            timesUsed = 0;
        }
    }

    public boolean isHarnessOnLoan()
    {
        if(onLoan)
            return true;

        return false;
    }

    public boolean canHarnessBeLoaned()
    {
        if(!onLoan&&timesUsed<MAX_TIMES_USED)
        {
            return true;
        }
        return false;
    }

    public void loanHarness(String currentMember)
    {
        if(canHarnessBeLoaned())
        {
            onLoan = true;
            timesUsed++;
            memberOnLoan = currentMember;
        }
    }

    public void returnHarness()
    {
        if(onLoan)
        {
            memberOnLoan = "None";
            onLoan = false;
        }
    }

    public String getBrand()
    {
        return brand;
    }

    public int getModelNum()
    {
        return modelNumber;
    }

    public String toString()
    {
        return "Brand: " + brand
                + "\nModel No.: " + modelNumber
                + "\nTimes Used (Since Last Check): " + timesUsed
                + "\nLast Instructor: "+ lastInstructor
                + "\nOn Loan: " + onLoan
                + "\nMember On Loan: " + memberOnLoan;
    }

}
