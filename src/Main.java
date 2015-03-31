import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class Main
{
    public static void main(String args[])
    {
        AnagramChecker checker = new AnagramChecker(new File("Res/input.txt"));

        WriteToFile("Res/Ouput.txt", checker.returnCheck());
    }

    private static void WriteToFile(String ouput, String s)
    {
        try
        {
            FileWriter writer = new FileWriter(ouput);

            BufferedWriter bufferwritter = new BufferedWriter(writer);

            bufferwritter.write(s);

            bufferwritter.close();

        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

}
