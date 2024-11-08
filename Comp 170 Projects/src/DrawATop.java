/*
Name: Arjun Parihar
Class: Comp 170-003
Assignment: Chapter 2B Assignment 1 - Draw A Top
Purpose of Program:
Write a program that produces the figures like the following. It's a bit like a spinning top sitting on a base.
Use a class constant for the size of the figure. The example is for size 4. Your program should work for sizes from 2 up.
The constant defines the number of rows in each section of the figure and the maximum width of the figure is 2 * the constant.

For an extra challenge, convert the constant to a non-final static variable and read its value using Console.promptInt().

Use several static methods to make the program understandable and avoid redundancy.

Start by thinking about the "parts" of the drawing, something like stick, top of top, middle of top, etc. The "stick" at the top
and the top and bottom of the top have the constant size number of lines; there's only one line in the middle. The "bottom stick"
has twice the number of lines as the constant size, and the top base has the constant size number of lines. You'll have to figure
out how to indent the various pieces of the figure with the correct number of spaces and how to adjust the number of characters
in the various pieces of the top when the size changes.

Be sure to try a few different sizes when running your program, at least 2, 4, and any odd number.

Algorithm:
1.
 */
public class DrawATop
{
    public static final int SIZE = 4;
    public static void main(String[] args)
    {
        drawTop();
        drawBody();
        //drawBottom();
        drawBase();
    }
    public static void drawTop()
    {
        for(int i=0;i<SIZE+1;i++)
        {
            for(int j=0;j<SIZE-1;j++)
            {
                System.out.print(" ");
            }
            System.out.println("||");
        }
    }
    public static void drawBody()
    {
        for(int i=0; i<SIZE-1;i++)
        {
            for(int j=0;j<SIZE-2-i;j++)
            {
                System.out.print(" ");
            }
            for(int j=SIZE;j>SIZE-1-i;j--)
            {
                System.out.print("*");
            }
            System.out.print("||");
            for(int j=SIZE;j>SIZE-1-i;j--)
            {
                System.out.print("*");
            }
            for(int j=0;j<SIZE-2-i;j++)
            {
                System.out.print(" ");
            }
            System.out.println();
        }
        for(int x=0;x<SIZE*2;x++)
        {
            System.out.print("=");
        }
        System.out.println();


    }
    public static void drawBottom()
    {
        for(int i=0;i<SIZE*2+1;i++)
        {
            for(int j=0;j<SIZE-1;j++)
            {
                System.out.print(" ");
            }
            System.out.println("||");
        }
    }
    public static void drawBase()
    {

    }
}
