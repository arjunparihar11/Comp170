/*
Name: Arjun Parihar
Class: Comp 170-003
Assignment: Chapter 1B - Mississippi
Purpose of Program:
Write a program to spell out MISSISSIPPI using block letters

Algorithm:
1.
 */
public class Mississippi
{
    public static void main(String[] args)
    {
        printBlockM();
        printBlockI();
        printBlockS();
        printBlockS();
        printBlockI();
        printBlockS();
        printBlockS();
        printBlockI();
        printBlockP();
        printBlockP();
        printBlockI();
    }
    public static void printBlockM()
    {
        System.out.println("M     M");
        System.out.println("MM   MM");
        System.out.println("M M M M");
        System.out.println("M  M  M");
        System.out.println("M     M");
        System.out.println("M     M");
        System.out.println("M     M");
    }
    public static void printBlockI()
    {
        System.out.println("IIIII");
        System.out.println("  I");
        System.out.println("  I");
        System.out.println("  I");
        System.out.println("  I");
        System.out.println("  I");
        System.out.println("IIIII");
    }
    public static void printBlockS()
    {
        System.out.println(" SSSSS");
        System.out.println("S     S");
        System.out.println("S");
        System.out.println(" SSSSS");
        System.out.println("      S");
        System.out.println("S     S");
        System.out.println(" SSSSS");
    }
    public static void printBlockP()
    {
        System.out.println("PPPPPP");
        System.out.println("P    P");
        System.out.println("PPPPPP");
        System.out.println("P");
        System.out.println("P");
        System.out.println("P");
    }

}
