import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class AnagramChecker
{
    ArrayList<String> words = new ArrayList<String>();
    ArrayList<String> orginalwords = new ArrayList<String>();

    AnagramChecker(File input)
    {
        Scanner sc = null;

        try {
            sc = new Scanner(input);
        }
        catch (Exception e)
        {
          System.out.println(e.getMessage());
        }

        int pos =0;
        while(sc.hasNextLine())
        {
            orginalwords.add(sc.nextLine());
            words.add(orginalwords.get(pos).toUpperCase().replaceAll(" ", ""));
            pos++;
        }

        sc.close();
    }

    public String returnCheck()
    {
        String answer = "";

        for(int x=0;x<words.size();x+=2)
        {
            if(check(words.get(x),words.get(x+1)))
                answer += orginalwords.get(x) + " and " + orginalwords.get(x+1) + " are anagrams!\n";
            else
                answer+=  orginalwords.get(x) + " and " + orginalwords.get(x+1) +" are NOT anagrams.\n";
        }


        return answer;
    }

    private boolean check(String s, String s1) {

        if(s.length() != s1.length()) // First Check
            return false;

        int[] abcString1 = new int[26];

            for(int x=0;x<s.length();x++)
                abcString1[ ((int)s.charAt(x)) - 65  ] ++;

        int[] abcString2 = new int[26];

        for(int x=0;x<s.length();x++)
            abcString2[ ((int)s1.charAt(x)) - 65  ] ++;

        for(int x=0;x<26;x++)
        {
            if(abcString1[x] != abcString2[x])
                return  false;
        }

        return true;
    }

    @Override
    public String toString()
    {
        String answer = "";

        for(int x=0;x<words.size();x++)
            answer += words.get(x) + "\n";

        return answer;
    }

}
