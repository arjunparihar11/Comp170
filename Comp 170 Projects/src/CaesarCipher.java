/*
Name: Arjun Parihar
Class: Comp 170-003
Assignment: Chapter 4B Assignment 1 - textbook Chapter 4 Programming Project 8 (Caesar Cipher)
Purpose of Program:
Write a program that implements the Caesar Cipher required by this Programming Project.

Example:
Your message? Attack zerg at dawn
Encoding key? 3
Your message: DWWDFN CHUJ DW GDZQ

Clarifications: Use a method for the cipher (maybe public static String ceasarCipher(String inputMessage, int shift)
that is called from main.  Main must prompt the user for both a message to be encrypted and the encoding key number
using Scanner170.  If you use ceasarCipher as shown, then main must print out the result.  Notice the result is in all
UPPERCASE letters.  We learned a while ago about the String class method toUpperCase() which will be helpful. Then
notice that blanks are not changed (not shifted) - one way to do this is to test each character in inputMessage to see
if it is a blank.  Another way is to shift only the characters 'A' to 'Z' (since a blank is not in that range).

Write pseudo code and write an cumulative algorithm that builds a String for the return value one character at a time.

To do good testing call your method at least twice from main with different inputs and shifts. One way to test is to
use the result of the first test as the input to the second test.  If you use the negative of the original shift key
you should get back the original message!

Algorithm:
1. Ask user for message, place in variable
2. Ask user for shift, place in variable
3. Send variables to method to encrypt message
4. Change char of String one at a time in for loop
5. If char was blank, undo shift (keep blank)
6. If char past Z after shift, subtract 26 to return to start of alphabet
7. Return new String
 */
public class CaesarCipher
{
    public static void main(String[] args)
    {
        Scanner170 console = new Scanner170(System.in);//
        System.out.print("Your message?: ");
        String userInput = console.nextLine();
        System.out.print("Encoding key? ");
        int key = console.nextInt();
        System.out.println("Your message: " + ceasarCipher(userInput, key));
    }
    public static String ceasarCipher(String message, int shift)
    {
        //String to return
        String cipheredMessage = "";
        //Loop through each character of message
        for(int i=0; i<message.length(); i++)
        {
            //get ascii value of char after shift
            int x = message.toUpperCase().charAt(i) + shift;//to upper to keep ascii between 65(A) and 90(Z)
            //if ascii is 32, it is blank, so undo shift to keep char blank
            if(x == 32 + shift)
            {
                x-=shift;
            }
            //if ascii is over 90, it is past Z, subtract by 26 to go back to start of alphabet
            if(x>90)
            {
                x-=26;
            }
            cipheredMessage+= (char)x;//add each shifted char to the string one at a time
        }
        return cipheredMessage;//return completed String
    }
}
