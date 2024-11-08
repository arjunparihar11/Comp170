/*
Name: Arjun Parihar
Class: Comp 170-003
Assignment: Q2 Writing code – Print Multiples
Purpose of Program:
Write a complete Java program with at least two methods; one of them will be the main method.
Test your program to make sure its results make sense and comply with the requirements of the problem.
Use techniques and concepts covered only in the first three chapters of the textbook unless instructed otherwise.
Your code must include comments describing the problem-solving strategy you apply.
Write a complete Java program with main and a static method named printMultiples that accepts, in order,
an integer number and an integer howMany as parameters and that prints a complete line of output reporting
the first howMany multiples of number.  For example, the following calls:
printMultiples(3, 5);
printMultiples(7, 3);
should produce this output:
The first 5 multiples of 3 are 3,  6,  9 , 12,  15
The first 3 multiples of 7 are 7,  14,  21
Notice that the multiples are separated by commas and a space but no comma at the end.
You must exactly reproduce this format.  You may assume that the number of multiples (howMany)
you will be asked to generate is greater than or equal to 1. Your method must work with any value of number
including negative numbers and zero.
Write a main method that tests your printMultiples method by calling the method
at least three times with different parameters.

Algorithm:
1. Call method with specified parameters
2. Print default begining of statement
3. Loop through factos 1 to n-1 with commas
4. Print final nth factor without a comma
 */
public class Multiples
{
    public static void main(String[] args)
    {
        //Testing with 3 calls of method
        printMultiples(3,5);
        printMultiples(7,3);
        printMultiples(2,8);
    }
    public static void printMultiples(int x, int howMany)
    {
        //Default statement
        System.out.print("The first " + howMany + " multiples of " + x + " are ");
        //Prints factors from 1 to n-1 with comma
        for(int i=1;i<howMany;i++)
        {
            System.out.print(i*x + ", ");
        }
        //print last nth factor without comma
        System.out.println(x*howMany);
    }
}
