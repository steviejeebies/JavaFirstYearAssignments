//FileOutputStream: write string

import java.io.FileOutputStream;
public class FileOutputStreamTest
{
    public static void main(String args[])
    {
        try
        {
            FileOutputStream fileOut =  new FileOutputStream("out.txt");
            String myString = "Welcome to Java";
            byte myByteArray [] = myString.getBytes();
            fileOut.write(myByteArray);
            fileOut.close();
            System.out.println("Success!");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
