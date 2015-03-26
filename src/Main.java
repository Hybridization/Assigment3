import java.io.File;

public class Main
{
    public static void main(String args[])
    {
        AnagramChecker checker = new AnagramChecker(new File("Res/input.txt"));

        System.out.print(checker.returnCheck());
    }

}
