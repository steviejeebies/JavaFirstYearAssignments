// A GUI system for a manager of a rock climbing company to lend out harnesses, make sure they've been checked
// after so many uses, and add or remove from their list of harnesses.

import java.util.Scanner;

public class ManagerCheck {

    static HarnessRecords harnessRecords = new HarnessRecords();

    public static void main(String[] args) {
        boolean acceptedInput = false;
        int noOfHarnesses = 0;

        while(!acceptedInput)
        {
            System.out.println("How many harnesses do you have in stock?");
            Scanner userInput = new Scanner(System.in);
            try
            {
                noOfHarnesses = userInput.nextInt();
                if(noOfHarnesses>0)
                {
                    addToHarnessRecords(noOfHarnesses);
                    acceptedInput = true;
                }
                else
                    throw new java.util.InputMismatchException();
            }
            catch(java.util.InputMismatchException e)
            {
                System.out.println("Invalid input.");
            }
        }

        boolean finished = false;
        while(!finished)
        {
            System.out.println("What do you want to do? ('add' to add harness, 'remove' to remove a harness, \n"
                    + "'check' to mark that a harness as just been checked by an instructor, 'loan' to loan harness to member, \n"
                    + "'return' if a member has returned their harness, 'view' to view status of all harnesses, 'quit' to quit)");
            Scanner userInput = new Scanner(System.in);
            String input = userInput.next();

            if(input.equalsIgnoreCase("add"))
            {
                addToHarnessRecords(1);
            }
            else if(input.equalsIgnoreCase("remove"))
            {
                try
                {
                    System.out.println("What is the brand of the harness you want to remove?");
                    userInput = new Scanner(System.in);
                    String removeBrand = userInput.next();
                    System.out.println("What is the model number of the harness you want to remove?");
                    int removeModelNumber = Integer.parseInt(userInput.next());
                    Harness removeTest = HarnessRecords.removeHarness(removeBrand, removeModelNumber);
                    if(removeTest == null)
                        System.out.println("Harness not found.");
                    else
                        System.out.println("Harness removed successfully.");
                }
                catch(java.util.InputMismatchException e)
                {
                    System.out.println("Invalid input.");
                }
            }
            else if(input.equalsIgnoreCase("check"))
            {
                try
                {
                    System.out.println("What is the brand of the harness you want to check?");
                    userInput = new Scanner(System.in);
                    String checkBrand = userInput.next();
                    System.out.println("What is the model number of the harness you want to check?");
                    int checkModelNumber = Integer.parseInt(userInput.next());
                    System.out.println("Which instructor checked the harness?");
                    String checkInstructor = userInput.next();
                    Harness checkTest = HarnessRecords.checkHarness(checkInstructor, checkBrand, checkModelNumber);
                    if(checkTest == null)
                        System.out.println("Harness not found (or is currently on loan).");
                    else
                        System.out.println("Harness check status updated successfully.");
                }
                catch(java.util.InputMismatchException e)
                {
                    System.out.println("Invalid input.");
                }
            }
            else if(input.equalsIgnoreCase("loan"))
            {
                try
                {
                    System.out.println("Which member wants to loan a harness?");
                    userInput = new Scanner(System.in);
                    String memberToLoan = userInput.next();
                    Harness loanTest = HarnessRecords.loanHarness(memberToLoan);
                    if(loanTest == null)
                        System.out.println("No harnesses currently available.");
                    else
                        System.out.println(memberToLoan + " has been lended the following Harness:\n" + loanTest);
                }
                catch(java.util.InputMismatchException e)
                {
                    System.out.println("Invalid input.");
                }
            }
            else if(input.equalsIgnoreCase("return"))
            {
                try
                {
                    System.out.println("What is the brand of the harness you want to return?");
                    userInput = new Scanner(System.in);
                    String returnBrand = userInput.next();
                    System.out.println("What is the model number of the harness you want to return?");
                    int returnModelNumber = Integer.parseInt(userInput.next());
                    Harness returnTest = HarnessRecords.returnHarness(returnBrand, returnModelNumber);
                    if(returnTest == null)
                        System.out.println("Harness not found in records.");
                    else
                        System.out.println("Harness returned successfully.");
                }
                catch(java.util.InputMismatchException e)
                {
                    System.out.println("Invalid input.");
                }
            }
            else if(input.equalsIgnoreCase("view"))
            {
                HarnessRecords.viewHarnesses();
            }
            else if(input.equalsIgnoreCase("quit"))
            {
                finished = true;
            }
        }

    }

    public static void addToHarnessRecords(int numOfHarnessesToAdd)
    {
        boolean acceptedInput = false;
        String[][] startingHarnesses = null;

        if(harnessRecords==null)
            startingHarnesses = new String[numOfHarnessesToAdd][7];


        for(int i = 0; i<numOfHarnessesToAdd;i++)
        {
            boolean newHarness = false;
            String make = null;
            int modelNum = 0;
            int numUsed = 0;
            String instructor = null;
            boolean isOnLoan = false;
            String memberOnLoan = null;

            while(!acceptedInput)
            {
                System.out.println("Harness " + (i+1) + ": Is the harness brand new? ('yes' or 'no')");
                Scanner userInput = new Scanner(System.in);
                String input = userInput.next();

                if(input.equalsIgnoreCase("yes"))
                {
                    newHarness = true;
                    acceptedInput = true;
                }
                else if(input.equalsIgnoreCase("no"))
                    acceptedInput = true;
                else
                    System.out.println("Invalid input.");
            }

            System.out.println("Harness " + (i+1) + ": What brand is the Harness?");
            Scanner userInput = new Scanner(System.in);
            String input = userInput.next();

            make = input;

            while(acceptedInput)
            {
                System.out.println("Harness " + (i+1) + ": What is the model number?");
                userInput = new Scanner(System.in);
                try
                {
                    modelNum = userInput.nextInt();
                    acceptedInput = false;
                }
                catch(java.util.InputMismatchException e)
                {
                    System.out.println("Invalid input.");
                }
            }

            System.out.println("Harness " + (i+1) + ": Which instructor checked the harness last?");
            userInput = new Scanner(System.in);
            instructor  = userInput.next();

            if(!newHarness)
            {
                while(!acceptedInput)
                {
                    System.out.println("Harness " + (i+1) + ": How many times has the harness "
                            + "been used since last checked?");
                    userInput = new Scanner(System.in);
                    try
                    {
                        int currentModelNum = userInput.nextInt();

                        if(currentModelNum<0)
                            throw new java.util.InputMismatchException();

                        numUsed = currentModelNum;
                        acceptedInput = true;
                    }
                    catch(java.util.InputMismatchException e)
                    {
                        System.out.println("Invalid input.");
                    }
                }

                while(acceptedInput)
                {
                    System.out.println("Harness " + (i+1) + ": Is the harness currently on loan? ('yes' or 'no')");
                    userInput = new Scanner(System.in);
                    input = userInput.next();

                    if(input.equalsIgnoreCase("yes"))
                    {
                        isOnLoan = true;
                        acceptedInput = false;
                    }
                    else if(input.equalsIgnoreCase("no"))
                        acceptedInput = false;
                    else
                        System.out.println("Invalid input.");
                }

                if(isOnLoan)
                {
                    System.out.println("Harness " + (i+1) + ": Which member currently has the harness?");
                    userInput = new Scanner(System.in);
                    input = userInput.next();

                    memberOnLoan = input;
                }

                if(harnessRecords != null)
                {
                    Harness add1Harness = new Harness(make, modelNum, numUsed, instructor, isOnLoan, memberOnLoan);
                    harnessRecords.addHarness(add1Harness);
                }
                else
                {
                    startingHarnesses[i][0] = (newHarness)?"yes":"no";
                    startingHarnesses[i][1] = make;
                    startingHarnesses[i][2] = Integer.toString(modelNum);
                    startingHarnesses[i][3] = Integer.toString(numUsed);
                    startingHarnesses[i][4] = instructor;
                    startingHarnesses[i][5] = (isOnLoan)?"yes":"no";
                    startingHarnesses[i][6] = memberOnLoan;
                }
            }
            else
            {
                if(harnessRecords != null)
                {
                    Harness add1Harness = new Harness(make, modelNum, instructor);
                    harnessRecords.addHarness(add1Harness);
                    System.out.println("Harness successfully added.");
                }
                else
                {
                    startingHarnesses[i][0] = (newHarness)?"yes":"no";
                    startingHarnesses[i][1] = make;
                    startingHarnesses[i][2] = Integer.toString(modelNum);
                    startingHarnesses[i][4] = instructor;
                }
            }
        }

        if(harnessRecords==null)
        {
            harnessRecords = new HarnessRecords(startingHarnesses);
        }
    }
}

