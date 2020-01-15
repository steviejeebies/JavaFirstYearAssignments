import java.util.ArrayList;

public class Stack {
    private ArrayList<Integer> stackArray = new ArrayList<Integer>();
    int stackIndex = 0;

    public void push(int intPushed)
    {
        stackArray.add(intPushed);
        stackIndex++;
    }

    public int pop()
    {
        if(stackIndex != 0)
        {
            int returnValue = stackArray.get(stackIndex);
            stackArray.remove(stackIndex);
            return returnValue;
        }
        else
            throw new java.util.EmptyStackException();
    }

    public int peek()
    {
        if(stackIndex>0)
            return stackArray.get(stackIndex-1);
        else
            throw new java.util.EmptyStackException();
    }

    public int search(int searchedNum)
    {
        int position = 0;
        for(int currentValue : stackArray)
        {
            if(currentValue==searchedNum)
                return position;
            else
                position++;
        }

        throw new java.util.NoSuchElementException();
    }

    //Question asks not to remove the element from the stack, so this move() method
    //just copies the element to the top of the stack, assuming that the element
    //is in the stack.

    public boolean move(int element)
    {
        if(search(element)!=-1)
        {
            push(element);
            return true;
        }

        return false;
    }
}
