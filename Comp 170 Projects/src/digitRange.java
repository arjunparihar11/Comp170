/*
Name: Arjun Parihar
Class: Comp 170-003
Assignment: Chapter 5A Assignment 1 - textbook Chapter 5 Exercise 20 (digitRange)
Purpose of Program:
Write a method called digitRange that accepts an integer as a parameter and returns the range of values of its digits.
The range is defined as 1 more than the difference between the largest and smallest digit value. For example, the call
of digitRange(68437) would return 6 because the largest digit value is 8 and the smallest is 3, so If the number
contains only one digit, return 1 . You should solve this problem without using a String.

Algorithm:
1. Ask User for an integer inside while loop
2. Send user's int as parameter for digitRange method
3. digitRange tests each digit one at a time for max or min
4. return max - min + 1
5. Stay in loop asking for another integer until user sends 0 as their int
 */
public class digitRange
{
    public static void main(String[] args)
    {
        //testing method
        Scanner170 console = new Scanner170(System.in);
        int x = 1;
        while(x!=0)
        {
            System.out.print("Enter an Integer to get its digit range (Enter 0 to exit program): ");
            x = console.nextInt();
            System.out.println("digit range:" + digitRange(x));
        }
    }
    public static int digitRange(int x)
    {
        x = Math.abs(x);//in case int is negative, treat same as positive
        int min = 10;//min at 10 so that 1st digit is guaranteed smaller
        int max = 0;//max at 0 so that 1st digit is guaranteed larger
        if(x < 10)//if int is a single digit number return 1
        {
            return 1;
        }
        while (x != 0)//each loop x%10 so when it equals 0 we have gone through each digit
        {
            int digit = x % 10;//get last digit of number
            if(digit > max)//if digit is larger than last largest digit it is the new max
            {
                max = digit;
            }
            else if(digit < min)//if digit is smaller than last smallest digit it is the new min
            {
                min = digit;
            }
            x /= 10;//div by 10 so that the next x%10= returns the next digit
        }
        return max - min + 1;//range = max digit - min digit + 1
    }
}

