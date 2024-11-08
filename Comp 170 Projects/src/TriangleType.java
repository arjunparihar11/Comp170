/*
Name: Arjun Parihar
Class: Comp 170-003
Assignment: Chapter 4B Assignment 2 (printTriangleType)
Purpose of Program:
First, write the method called printTriangleType referred to in Self-Check Problem 25. This method accepts three
integer arguments representing the lengths of the sides of a triangle and prints the type of triangle that these sides
form. Second, test your method by calling it from main with several different values, or by getting user input in main
and passing it to the method.

Here are some sample calls to printTriangleType:
printTriangleType(5, 7, 7);
printTriangleType(6, 6, 6);
printTriangleType(5, 7, 8);
printTriangleType(2, 18, 2);
The output produced by these calls should be
isosceles
equilateral
scalene
***will cause exception and end program***

Your method should throw an IllegalArgumentException if passed invalid values, such as ones where one side’s length is
longer than the sum of the other two, which is impossible in a triangle. For example, the call of
printTriangleType(2, 18, 2); should throw an exception.

Algorithm:
1. Check if Triangle is valid (one side is not greater than sum of other 2)
2. Check if equilateral
3. Check if isosceles
4. If valid triangle is not equilateral or isosceles it is scalene
 */
public class TriangleType
{
    public static void main(String[] args)
    {
        printTriangleType(5, 7, 7);
        printTriangleType(6, 6, 6);
        printTriangleType(5, 7, 8);
        printTriangleType(2, 18, 2);
    }
    public static void printTriangleType(int x, int y, int z)
    {
        //if the one side > sum of other 2, Triangle is invalid
        if(((x+y)<z) || ((x+z)<y) || ((z+y)<x))
        {
            System.out.println("invalid triangle");
        }
        //Triangle is valid:
        else
        {
            //if x=y and y=z then x=z making it equilatera;
            if((x==y) && (y==z))
            {
                System.out.println("equilateral");
            }
            //if only one pair is equal its isosceles
            else if((x==y) || (y==z) || (z==x))
            {
                System.out.println("isosceles");
            }
            //if none are equal it is scalene
            else
            {
                System.out.println("scalene");
            }
        }
    }
}
