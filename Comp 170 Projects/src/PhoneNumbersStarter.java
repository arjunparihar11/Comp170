import java.io.FileNotFoundException;
import java.util.Locale;
import java.awt.*;
import java.util.Scanner;
/*
Name: Arjun Parihar
Class: Comp 170-003
Assignment: Chapter 7 Assignment 1 (Phone Numbers)
Purpose of Program:
You expand the starter code into a full working app

This assignment gives you a working example of how to break up an app between main and methods. The basic structure is
provided as starter code and you need to complete it by adding to main and the two methods. Start by reading and
understanding PhoneNumbersStarter. Note the TO DOs; fill and complete them as indicated. You can add additional methods
to help implement the two incomplete methods in the starter code.

Your app works with names of people and phone numbers, each of which is stored in an array. The ith element in each
array correspond with each other (e.g. phone number at [i] is for person at [i])

When finished your two methods will allow updates to the list of phone numbers and printing out the current phone
directory. The user will enter a name to give a new phone number. That name may or may not be found in the list of
people. If found, the old number is replaced with the new phone number. If not found, nothing is changed (you may want
to let the user know). After you complete the two methods, call them from main to test your code.

Your output directory should look something similar to this (it must be formatted into clear columns and when there is
no phone number it must show *Unknown*)

Current Phone Directory:
|          Adam Smith|	(987) 654-3210	|
|   George Washington|	*Unknown*		|
|  Alexander Hamilton|	(312) 915-2000	|
|        Thomas Payne|	(909) 456-7890	|
|          Betsy Ross|	(303) 406-1234	|
|   Martha Washington|	*Unknown*		|
|     Deborah Sampson|	*Unknown*		|
|     Patience Wright|	(813) 377-4578	|

Algorithm:
 1. Use a Scanner170 to get input from user.
 2. Use boolean variable dataUpdate for tracking change of any number, if it is updated it is set to true, boolean
    variable nameMatch tracks if the current name maches with any name in array.
 3. Using a while loop that runs until break if the user input is "Done"
 4. In loop if user enters a valid name we ask for the new number to update the information.
 5. Whenever a valid name is entered and data is changed, boolean variable dataUpdate is update to true and nameMatch
    is changed to true.
 6. If name entered is invalid, user is informed and prompted for a new name.
 7. In the end the variable dataUpdate is returned.
 8. Using a for loop go through each record.
 9. If phone number is 0, use string format of printf the name and phone number in the given format
    (format = "|%20s|\t*Unknown*\t\t|\n").
10. If the number if greater than 0 then, Convert the phone number to String and use substring to get the required parts
    of the phone number. areaCode is initial 3 digits, nextThree is next three digits and the remaining four digits is
    lastFour using the format "|%20s|\t(%3s) %s-%s\t|\n"
 */
public class PhoneNumbersStarter
{
    public static void main(String[] args)
    {
		/* Two parallel arrays to hold phone numbers and names
			ith name matches ith phone number; 0 indicates number unknown
			the L tag at the end of the numbers makes them a java long primitive type
			(necessary to fit 10 digits)
			You may extend these arrays but DO NOT modify the types
		 */
        long[] numbers = {9876543210L, 0, 3129152000L, 9094567890L, 3034061234L, 0, 0, 8133774578L};
        String[] names = {"Adam Smith", "George Washington", "Alexander Hamilton", "Thomas Payne",
                "Betsy Ross", "Martha Washington", "Deborah Sampson", "Patience Wright"};

        //TODO: call the methods to test them. You can call them multiple times. Do some phone changes
        showPhoneNumbers(numbers, names);
        updateNumbers(numbers, names);
        showPhoneNumbers(numbers, names);
    }

    /**
     * Ask the user to update zero or more phone numbers using a Scanner170 object. User enters name
     * of person, if that person found in people parameter, then allow update of corresponding phone number
     * in phoneNumbers parameter.
     *
     * Loop asking for names for which to update the phone number until user enters *Done*
     *
     * @param phoneNumbers - array of phone numbers in order matching names (0 indicates number unknown)
     * @param people - array of people names in same order as phone numbers
     * @return boolean true if any numbers were changed; false if no numbers changed successfully (for
     * 			example if user never enters a name found in people
     *
     * 	TODO: Enter the rest of your pseudo code here (give details on how you will process user requests,
     * 	search and make changes.
     * 1. Use a Scanner170 to get input from user.
     * 2. Use boolean variable dataUpdate for tracking change of any number, if it is updated it is set to true, boolean
     *    variable nameMatch tracks if the current name maches with any name in array.
     * 3. Using a while loop that runs until break if the user input is "Done"
     * 4. In loop if user enters a valid name we ask for the new number to update the information.
     * 5. Whenever a valid name is entered and data is changed, boolean variable dataUpdate is update to true and nameMatch
     *    is changed to true.
     * 6. If name entered is invalid, user is informed and prompted for a new name.
     * 7. In the end the variable dataUpdate is returned.
     */
    public static boolean updateNumbers(long[] phoneNumbers, String[] people)
    {
        //TODO:  write your code here
        //return true;  // temporary so stub compiles.  Replace with your full code for method
        Scanner console = new Scanner(System.in);
        String name = "";
        boolean dataUpdate = false;
        boolean nameMatch;
        while(true)
        {
            System.out.println("Enter the name of the person's phone number you want to update or enter \"Done\" to end: ");
            name = console.nextLine();
            nameMatch = false;
            if(name.toLowerCase().equals("done"))
            {
                break;//exit loop user enters done
            }
            for(int i=0; i<people.length;i++)//loop through people array
            {
                if(name.toLowerCase().equals(people[i].toLowerCase()))//if input matches an entry in loop
                {
                    nameMatch = true;
                    boolean validNumber = false;
                    do
                    {
                        System.out.println("Enter updated phone number for " + people[i] + " or 0 if unknown.");
                        long number = console.nextLong();
                        validNumber = validNumber(number);
                        phoneNumbers[i] = number;
                    }while(validNumber == false);
                    dataUpdate = true;
                    System.out.println("Number updated!");
                }
            }
            if(!nameMatch)//if name did not match any in loop
            {
                System.out.println("Entered name doesn't exist.");
            }
        }
        return dataUpdate;
    }

    /**
     * Show the full set of names and phone numbers in the format indicated in the assignment
     * (Display them to the console)
     *
     * @param phoneNumbers- array of phone numbers in order matching names (0 indicates number unknown)
     * @param people- array of people names in same order as phone numbers
     *
     * TODO:  Enter full pseudo code here (give details about how you will process the input parameters
     *              and how you will create the correct format.  If helpful, mention key variables to use
     * 1. Using a for loop go through each record.
     * 2. If phone number is 0, use string format of printf the name and phone number in the given format
     *    (format = "|%20s|\t*Unknown*\t\t|\n").
     * 3. If the number if greater than 0 then, Convert the phone number to String and use substring to get the required parts
     *    of the phone number. areaCode is initial 3 digits, nextThree is next three digits and the remaining four digits is
     *    lastFour using the format "|%20s|\t(%3s) %s-%s\t|\n"
     */
    public static void showPhoneNumbers(long[] phoneNumbers, String[] people)
    {
        //TODO:  write your code here
        System.out.println("Current Phone Directory:");
        for(int i=0; i<people.length; i++)//loop through people array
        {
            if(phoneNumbers[i]==0)//if phone number is 0
            {
                System.out.printf("|%20s|\t*Unknown*\t\t|\n",people[i]);//format table with *unknown* in 2nd column
                continue;
            }
            String number = Long.toString(phoneNumbers[i]);//use string to extract phone number
            String areaCode = number.substring(0, 3);//area code digits 012
            String nextThree = number.substring(3, 6);//next 345
            String lastFour = number.substring(6);//last digits 6789
            System.out.printf("|%20s|\t(%3s) %s-%s\t|%n",people[i],areaCode,nextThree,lastFour);//print phone numbers in formated table
        }
    }

    /**
     * Checks if updated phone number is 0 or a 10 digit number
     * @param x - user inputed phone number
     * @param count - digit count of inputed phone number
     *
     * 1. If inputed number is 0, it is valid since phone number is unknown.
     * 2. Loop through inputed phone number dividing by 10 and increasing count each time
     * 3. If count is 10 the input is valid
     */
    public static boolean validNumber(long x)
    {
        if(x==0)//unknown number is valid
        {
            return true;
        }
        else//input is not 0
        {
            int count=0;
            while(x!=0)//loop through each place digit of number
            {
                x/=10;//go through each digit
                count++;//count up each time
            }
            if(count==10)//if number has 10 digits it is a valid number
            {
                return true;
            }
            else//number is not 0 or 10 digits long
            {
                System.out.println("Phone number must be 10 digits long or \"0\" if unknown");
                return false;
            }
        }
    }

}