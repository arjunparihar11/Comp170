/*
Name: Arjun Parihar
Class: Comp 170-003
Assignment: Chapter 3B Assignment 1 (printSquare)
Purpose of Program:
Write a method called printSquare that accepts a minimum and maximum integer and prints a square of lines of
increasing numbers. The first line should start with the minimum, and each line that follows should start with the
next higher number. The sequence of numbers on a line wraps back to the minimum after it hits the maximum. For example,
the call printSquare(3, 7); should produce the following output:

34567
45673
56734
67345
73456

If the maximum passed is less than the minimum, the method produces no output.

Algorithm:
1. Call method and pass 2 parameters to it
2. Method takes min and max and produces square with nested for loop
3. Print results as created
 */
public class PrintSquare
{
    public static void main(String[] args)
    {
        //Square with line1 of 34567
        printSquare(3, 7);
    }
    public static void printSquare(int min, int max)
    {
        //number of rows = space between min and max
        for(int i=min;i<=max;i++)
        {
            //print numbers in order when digit is under max
            for(int j=i;j<=max;j++)
            {
                System.out.print(j);
            }
            //when number is over max reset at min and start over
            for(int k=0;k<(i-min);k++)
            {
                System.out.print(min+k);
            }
            //new line
            System.out.println();
        }
    }
}
