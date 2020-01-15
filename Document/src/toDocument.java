import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class toDocument {
    public static void main(String args[])
    {
        try
        {
            FileOutputStream fout = new FileOutputStream("out.txt");
            BufferedOutputStream bout = new BufferedOutputStream(fout);
            String s = "Welcome to Java!";
            byte[] byteArray = s.getBytes();
            bout.write(byteArray);
            bout.flush();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
