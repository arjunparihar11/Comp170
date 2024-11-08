/*
Name: Arjun Parihar
Class: Comp 170-003
Assignment: Chapter 5B Assignment 1  - Holy Digits
Purpose of Program:
Holy digits Batman! The Riddler is planning his next caper somewhere on Pennsylvania Avenue.
In his usual sporting fashion, he has left the address in the form of a puzzle. The address on
Pennsylvania is a four-digit number where:
* All four digits are different
* The digit in the thousands place is 2 times the digit in the tens place
* The number is even
* The sum of the digits is 25
Write a program that uses a loop (or loops) to find the address where the Riddler plans to strike.
Print out the address that matches the riddle.

Algorithm:
1. Nest for loop for each digit (4 deep)
2. Loop each digit 0-9
3. Inner most loop nested if statements for each requirement
4. Inner most if statement will be the answer, print the result
 */
public class holyDigits
{
    public static void main(String[] args)
    {
        //thousands digit 0-9
        for(int thousands=0; thousands<10; thousands++)
        {
            //hundreds digit 0-9
            for(int hundreds=0; hundreds<10; hundreds++)
            {
                //tens digit 0-9
                for(int tens=0; tens<10; tens++)
                {
                    //ones digit 0-9
                    for(int ones=0; ones<10; ones++)
                    {
                        //All 4 digits are different
                        if(thousands != hundreds && thousands != tens && thousands != ones && hundreds != tens && hundreds != ones && tens != ones)
                        {
                            //The digit in the thousands place is 2 times the digit in the tens place
                            if(thousands == 2*tens)
                            {
                                //The number is even
                                if(ones%2 == 0)
                                {
                                    //The sum of the digits is 25
                                    if(thousands+hundreds+tens+ones == 25)
                                    {
                                        System.out.println("The Address is " + thousands + "" + hundreds + "" + tens + "" + ones + " Pennslyvania Avenue.");
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
