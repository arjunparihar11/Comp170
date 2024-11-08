/*
Name: Arjun Parihar
Class: Comp 170-003
Assignment: Exam TWO Part B Question 1, writing code - counting valid words from a user
Purpose of Program:
Write a full program containing a method countValidWords according to the following description. Please review this
information carefully, including the grading rubric at the end:

Write a method that counts valid words entered by the user. The method takes a Scanner170 connected to the console plus
two characters as parameters - only words that start with a letter between those two characters are considered valid.

The method must reject second and third parameter values that are not letters by throwing an IllegalArgumentException.

The two characters given to the method may be given in either order, the smaller first or the larger. The characters may
be in either upper or lower case, and comparisons with the first letter of potential valid words must be case-insensitive,
so a and A are the same, allowing words that start with a or A.

After the method counts valid words that the user enters it must return that count. The user signals that all words have
been entered by typing a "word" whose first character is not a letter.

The method must tell the user what it does and prompt them for input related to the character parameters it is given.
The method must tell the user that when they enter a "word" that begins with anything other than a letter the method will
stop accepting words and return the count of valid user words it has seen so far. The ending "word" that starts with a
non-letter must not be included in that count.

The program must contain both pseudocode for the method as well as pre- and post-condition comments regarding the method.
Note: pseudocode is not in-line comments inside the method, but rather a block of comments before the method that explains
how the method will implement its requirements conceptually, not with details about the implementation - so the pseudocode
would NOT look like Java statements but rather what logic and information it will use in its implementation. It may include
the types of statements used in the method such as loops or decision-making, but only the general nature of the tests that
such statements use, not their specific content. See pages 108-109, 180-182, and 259 in the textbook.

Pre- and post-condition comments must follow the pseudocode. See pages 279-283 and 372 in the textbook.
The method may optionally contain in-line comments as well.

The program containing this method must call the method in main three (3) times for testing purposes as follows:
Test 1: the characters are lower case a and k, in that order
Test 2: the characters are z and q in that order; one is in upper case
Test 3: one of the characters is not a letter (throws an exception)

At least one of the words entered for the first test should be in a different case (upper vs. lower), and for the second
test the first entered word should be valid (between q and z) and the second entered "word" should start with a non-letter
so that the returned count of valid words would be 1. The third test should throw the required exception.

Algorithm:
1.Call countValidWords method
1. Method first checks if character parameters x or y are valid chars a-z, if not it will throw an exception
2. If chars are letters method will turn them both to lower case so the input didn't matter if it was upper or lower
3. While loop through each word in user input until the first character of a word is not a letter
4. Inside while loop test each word if it starts with a letter inside character parameter range
5. Add to the int count for each word that is valid, returning that count at end of method
6. If first character is not a letter, break from while loop, since user is done entering words
7. Store returned int in a variable and print result of valid words
 */
public class countValidWords
{
    /*MAIN METHOD:
    1. Test the characters are lower case a and k, in that order
    2. Test the characters are z and q in that order; one is in upper case
    3. Test one of the characters is not a letter (throws an exception)
    4. Store returned int in a variable and print result of valid words
    Method will word as long as the parameters entered are valid
    */
    public static void main(String[] args)
    {
        Scanner170 console = new Scanner170(System.in);
        //Test the characters are lower case a and k, in that order
        int count1 = countValidWords(console,'a','k');
        System.out.println("Count of valid words is: " + count1);
        //Test the characters are z and q in that order; one is in upper case
        int count2 = countValidWords(console,'z','q');
        System.out.println("Count of valid words is: " + count2);
        //Test one of the characters is not a letter (throws an exception)
        int count3 = countValidWords(console,'1','a');
        System.out.println("Count of valid words is: " + count3);
    }
    /*COUNTVALIDWORDS METHOD:
    1. Method first checks if character parameters x or y are valid chars a-z, if not it will throw an exception
    2. If chars are letters method will turn them both to lower case so the input didn't matter if it was upper or lower
    3. While loop through each word in user input until the first character of a word is not a letter
    4. Inside while loop test each word if it starts with a letter inside character parameter range
    5. Add to the int count for each word that is valid, returning that count at end of method
    6. If first character is not a letter, break from while loop, since user is done entering words
    Pre: Scanner is connected to console, parameters for char as assumed to be valid
    Post: Parameters for char are validated, scanner is used to take input, result is counted in while loop
    */
    public static int countValidWords(Scanner170 input, char x, char y)
    {
        //check if parameter is a letter
        if(!Character.isLetter(x) || !Character.isLetter(y))
        {
            throw new IllegalArgumentException("Character Parameter Range Entered Was Not A Valid Letter");
        }
        //figure out which letter is upper/lower limit
        char upper, lower;
        if(x > y)
        {
            upper = Character.toUpperCase(x);
            lower = Character.toUpperCase(y);
        }
        else
        {
            upper = Character.toUpperCase(y);
            lower = Character.toUpperCase(x);
        }
        //count each valid word
        int count =0;
        input = new Scanner170(System.in);
        System.out.println("Enter words starting with letters between " + lower + " and " + upper + ". Enter a word not starting with a letter to end.");
        //keep loop until input is out of words
        while(input.hasNext())
        {
            //separate each word into String
            String word = input.next();
            //char representing first letter of word
            char firstLetter = Character.toUpperCase(word.charAt(0));
            //if character is not a letter, break from loop
            if (!Character.isLetter(firstLetter))
            {
                break;
            }
            //if character is equal or greater than lower limit AND equal or lower than upper limit, it is valid
            if(firstLetter >= lower && firstLetter <= upper)
            {
                count++;
            }
        }
        //after loop is broken each word inputed has been tested
        return count;
    }
}
