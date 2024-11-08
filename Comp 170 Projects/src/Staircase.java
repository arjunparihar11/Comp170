/*
Name: Arjun Parihar
Class: Comp 170-003
Assignment: Q1 Writing code – Staircase
Purpose of Program:
Write a complete Java program to draw a staircase as shown below.
The program shall include a static method called drawStairCase that
takes one int parameter (the number of steps in the staircase).
The method prints a staircase seen from the side with as many steps
as specified by its parameter. In the program's main method use Console
to prompt the user for an int value. Then call drawStairCase to draw a
staircase with the height specified by the user.The staircase has a number
of steps (rows) equal to its parameter.  Each row consists of hash marks (##)
followed by two underscores (__). The number of hash marks increases by two
from step to step with the top having zero hash marks; the number of underscores
remains the same for each step.

Algorithm:
1. Prompt user for size
2. Pass user input into int var userSize
3. Send userSize as parameter for drawStairCase() function
4. Print staircase of specified size
 */
public class Staircase
{
    public static void main(String[] args)
    {
        //prompt user
        System.out.print("Enter a size for the staircase:");
        //take user input into var userSize
        int userSize = Console.nextInt();
        //pass userSize as parameter for function
        drawStairCase(userSize);
    }
    public static void drawStairCase(int size)
    {
        //Loop 1 row per size
        for(int i=0;i<size;i++)
        {
            //adjusts number of hashes per step
            for(int j=0;j<i;j++)
            {
                System.out.print("##");
            }
            //end each step with underscores
            System.out.println("__");
        }
    }
}
