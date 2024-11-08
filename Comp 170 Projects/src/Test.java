import java.io.FileNotFoundException;
import java.util.Locale;
import java.awt.*;
import java.io.File;

/*
Name: Arjun Parihar
Class: Comp 170-003
Assignment:
Purpose of Program:

Algorithm:
1.
 */
public class Test
{
    public static void main(String[] args)
    {
        WorkRecord Joe = new WorkRecord("Joe");
        Joe.addHours(5);
        System.out.println(Joe);
        WorkRecord Abe = new WorkRecord("Abe");
        System.out.println(Abe);

    }
}

