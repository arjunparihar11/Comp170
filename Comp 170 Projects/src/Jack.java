/*
Name: Arjun Parihar
Class: Comp 170-003
Assignment: Chapter 1B - Jack
Purpose of Program:
Write a program that produces as output the words of “The
House That Jack Built.” Use methods for each verse and for
repeated text. Here are lyrics to use:
This is the house that Jack built.
This is the malt
That lay in the house that Jack built.
This is the rat,
That ate the malt
That lay in the house that Jack built.
This is the cat,
That killed the rat,
That ate the malt
That lay in the house that Jack built.
This is the dog,
That worried the cat,
That killed the rat,
That ate the malt
That lay in the house that Jack built.
This is the cow with the crumpled horn,
That tossed the dog,
That worried the cat,
That killed the rat,
That ate the malt
That lay in the house that Jack built.
This is the maiden all forlorn
That milked the cow with the crumpled horn,
That tossed the dog,
That worried the cat,
That killed the rat,
That ate the malt
That lay in the house that Jack built.

Algorithm:
1. Print unique lines
2. Call functions for repeated lines
3. Lines function for next repeated line calls previous function so lyrics repeat as intended
4. System outputs lyrics without a repeated sout
 */
public class Jack
{
    public static void main(String[] args)
    {
        System.out.println("This is the house that Jack built.");
        System.out.println("This is the malt");
        printLay();
        System.out.println("This is the rat,");
        printMalt();
        System.out.println("This is the cat,");
        printKilled();
        System.out.println("This is the dog,");
        printWorried();
        System.out.println("This is the cow with the crumpled horn,");
        System.out.println("This is the maiden all forlorn");
        System.out.println("That milked the cow with the crumpled horn,");
        printTossed();
    }
    public static void printLay()
    {
        System.out.println("That lay in the house that Jack built.");
    }
    public static void printMalt()
    {
        System.out.println("That ate the malt");
        printLay();
    }
    public static void printKilled()
    {
        System.out.println("That killed the rat,");
        printMalt();
    }
    public static void printWorried()
    {
        System.out.println("That worried the cat,");
        printKilled();
    }
    public static void printTossed()
    {
        System.out.println("That tossed the dog,");
        printWorried();
    }
}
