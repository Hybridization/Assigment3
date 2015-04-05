/*
Author: Matthew Hoare
E-mail: mrh5493@psu.edu
Course: CMPSC 221
Assignment: Programming Assignment 3
Due date: 4/4/2015
File:  AnagramChecker.java
Purpose: To Check to See if Words in file are Anagram and Output the Result
Compiler/IDE: Java SE Development Kit 8u40/IntelliJ IDEA 14.1.1
Operating
system: MS Windows 8.1 Pro
Reference(s): Java 8 API - Oracle Documentation
(http://docs.oracle.com/javase/8/docs/api/)
*/

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class AnagramChecker
{
    private ArrayList<String> words = new ArrayList<String>();
    private ArrayList<String> orginalwords = new ArrayList<String>();

    /** This Constructor will read from File and store data into Two ArrayLists
     *
     * @param input File Object that will be readed for input
     */
    AnagramChecker(File input)
    {
        Scanner sc = null;

        try {
            sc = new Scanner(input); // Open File
            System.out.println("File Found\nNow Reading From File");

            int pos =0;  // Reading from file
            while(sc.hasNextLine())
            {
                orginalwords.add(sc.nextLine()); // For output
                words.add(orginalwords.get(pos).toUpperCase().replaceAll(" ", "")); // For Checking
                pos++;
            }

            sc.close(); //Closing File
        }
        catch(FileNotFoundException e)
        {
            System.out.println("File Not Found\nNow Exiting Program");
            System.exit(0);
        }
        catch (Exception e)
        {
          System.out.println(e.getMessage());
        }
    }

    /** return a string containing the output that will be write to file
     *
     * @return the string containing answer to the anagrams
     */
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

    /** return true or false if pairs are anagrams or not
     *
     * @param s first word to be checked
     * @param s1 second word to be checked
     * @return true if pairs are anagrams and false if otherwise
     */
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

    /** this will take a string and write to a file
     *
     * @param output name of file that will maded
     * @param s string to be writen to file
     */
    public void WriteToFile(String output, String s)
    {
        try
        {
            System.out.println("Now Writing to File");

            FileWriter writer = new FileWriter(output);
            BufferedWriter bufferwritter = new BufferedWriter(writer);
            bufferwritter.write(s);
            bufferwritter.close();

            System.out.println("File is Done");

        }
        catch (Exception e)
        {
            System.out.println("Error Occur While Writing File\nNow Exiting Program");
        }
    }
}
