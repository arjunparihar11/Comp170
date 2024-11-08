import java.util.*;
import java.io.*;
/*
Name: Arjun Parihar
Class: Comp 170-003
Assignment: Chapter 6 Assignment 2 - textbook Chapter 6 Programming Project 1 (Counting Words, etc)
Purpose of Program:
Students are often asked to write term papers containing a certain number of words. Counting words in a 
long paper is a tedious task, but the computer can help. Write a program WordCount.java that counts the
number of words, lines, and total characters (not including whitespace) in a paper, assuming that 
consecutive words are separated either by spaces or end-of-line characters.

In the Virtual Machine, download and use the attached hamlet.txt file as the input for your program. 
Put it in the my_Java_programs/src folder and use CheckIO.findFile("hamlet.txt") to connect a File 
object to it for WordCount.

Algorithm:
1. Find hamlet.txt
2. Create scanner of hamlet.txt
3. While loop though each word of hamlet.txt
4. Increase wordCount int per each word in hamlet.txt
5. Print wordCount
 */
public class WordCount
{
    public static void main(String[] args) throws FileNotFoundException
    {
		//Find File
        CheckIO.findFile("hamlet.txt");
		//File into scanner
        Scanner170 input = new Scanner170(new File("hamlet.txt"));
		//int to count up words
        int wordCount = 0;
		//while txt has another word, keep looping
        while(input.hasNext())
        {
            String word = input.next();//there is a word
            wordCount++;//add to total
        }
		//print result
        System.out.println("Word Count: " + wordCount);
    }

}
