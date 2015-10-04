/*
Author: Matthew Hoare
E-mail: mrh5493@psu.edu
Course: CMPSC 221
Assignment: Programming Assignment 3
Due date: 4/4/2015
File: Main.java
Purpose: Java application that determines if pairs of words and phrases stored in a text file are anagrams
Compiler/IDE: Java SE Development Kit 8u40/IntelliJ IDEA 14.1.1
Operating
system: MS Windows 8.1 Pro
Reference(s): Java 8 API - Oracle Documentation
(http://docs.oracle.com/javase/8/docs/api/)
*/

import java.io.File;

public class Main
{
    public static void main(String args[])
    {
        AnagramChecker checker = new AnagramChecker(new File("AnagramPairs.txt"));
        System.out.println("Now Checking Anagrams pairs");
        checker.WriteToFile("Ouput.txt", checker.returnCheck());
    }

}
