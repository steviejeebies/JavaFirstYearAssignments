import java.util.ArrayList;

public class HarnessRecords {

    static private ArrayList<Harness> harnessRecords;

    HarnessRecords()
    {
        harnessRecords= new ArrayList<Harness>();
    }

    HarnessRecords(String[][] addedHarness)
    {
        for(int i = 0; i<addedHarness.length;i++)
        {
            String make = addedHarness[i][1];
            int modelNum = Integer.parseInt(addedHarness[i][2]);
            String instructor = addedHarness[i][4];

            //if the harness has been used before
            if(addedHarness[i][0]=="yes")
                harnessRecords.add(new Harness(make, modelNum, instructor));
            else
            {
                int numUsed = Integer.parseInt(addedHarness[i][3]);
                boolean isOnLoan = (addedHarness[i][5]=="yes");
                String loanMember = addedHarness[i][6];

                harnessRecords.add(new Harness(make, modelNum, numUsed, instructor, isOnLoan, loanMember));
            }
        }
    }

    static public boolean isEmpty()
    {
        if(harnessRecords.size()==0)
            return true;

        return false;
    }

    public void addHarness(Harness harness)
    {
        harnessRecords.add(harness);
    }

    static public Harness findHarness(String make, int modelNum)
    {
        for(Harness currentHarness : harnessRecords)
        {
            if(currentHarness.getBrand() == make && currentHarness.getModelNum() == modelNum)
                return currentHarness;
        }
        return null;
    }

    static public Harness checkHarness(String instructor, String make, int modelNum)
    {
        Harness selectedHarness = null;

        for(Harness currentHarness : harnessRecords)
        {
            String currentHarnessBrand = currentHarness.getBrand();
            if(currentHarnessBrand.equalsIgnoreCase(make)
                    && currentHarness.getModelNum() == modelNum)
                selectedHarness = currentHarness;
        }

        if(selectedHarness != null && !selectedHarness.isHarnessOnLoan())
        {
            selectedHarness.checkHarness(instructor);
            return selectedHarness;
        }

        return null;
    }

    static public Harness loanHarness(String member)
    {
        for(Harness currentHarness : harnessRecords)
        {
            if(currentHarness.canHarnessBeLoaned())
            {
                currentHarness.loanHarness(member);
                return currentHarness;
            }
        }

        return null;
    }

    static public Harness returnHarness(String make, int modelNum)
    {
        Harness selectedHarness = null;

        for(Harness currentHarness : harnessRecords)
        {
            String currentHarnessBrand = currentHarness.getBrand();
            if(currentHarnessBrand.equalsIgnoreCase(make)
                    && currentHarness.getModelNum() == modelNum)
                selectedHarness = currentHarness;
        }

        if(selectedHarness.isHarnessOnLoan())
        {
            selectedHarness.returnHarness();
            return selectedHarness;
        }

        return null;
    }

    static public Harness removeHarness(String make, int modelNum)
    {
        Harness selectedHarness = null;
        for(Harness currentHarness : harnessRecords)
        {
            String currentHarnessBrand = currentHarness.getBrand();
            int currentHarnessModel = currentHarness.getModelNum();
            if(currentHarnessBrand.equalsIgnoreCase(make) &&
                    currentHarnessModel == modelNum)
                selectedHarness = currentHarness;
        }

        if(selectedHarness != null)
        {
            harnessRecords.remove(selectedHarness);
            return selectedHarness;
        }

        return null;
    }

    static public void viewHarnesses()
    {
        if(harnessRecords.size()>0)
        {
            for(Harness viewHarness : harnessRecords)
            {
                System.out.println(viewHarness + "\n _________ \n");
            }
        }
    }



}
