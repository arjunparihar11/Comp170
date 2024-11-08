/*
Name: Arjun Parihar
Class: Comp 170-003
Assignment: Chapter 8A Assignment 2 (Work Hours)

Purpose of Program:
Copy the skeleton of the class WorkRecord below and complete it to make a full OOP class. Complete your work in the
tools used in class. When you have the class ready copy the partial code into a new class called WorkRecordTester that
has main and try to run it.  You can extend main to do more tests and create new objects.Copy the skeleton of the class
WorkRecord below and complete it to make a full OOP class. Complete your work in the tools used in class. When you have
the class ready copy the partial code into a new class called WorkRecordTester that has main and try to run it.  You can
extend main to do more tests and create new objects.

Algorithm:
1.
 */
public class WorkRecord
{
    private String name; // private instance variables for WorkRecord
    private int hours;

    // Construct a WorkRecord for the specified name, with initial hours 0.
    public WorkRecord(String name)  // the constructor – code it!
    {
        //TO DO: complete the method
        this.name = name;
        hours = 0;
    }

    // Return the number of hours in this WorkRecord.
    public int getHours()  // a getter method – code it!
    {
        //TO DO: complete the method
        return hours;
    }

    // Update the number of hours when moreHours additional hours are worked.
    public void addHours(int moreHours)  // an instance method – code it!
    {
        //TO DO: complete the method
        hours += moreHours;
    }

    // Return a String in the form like the example:     Andy: 15 hours
    @Override
    public String toString()  // the overridden toString method – code it!
    {
        //TO DO: complete the method
        return name + ": " + hours + " hours";
    }
}