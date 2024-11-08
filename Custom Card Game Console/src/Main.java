import java.io.FileNotFoundException;//for txt to track Blackjack bank
/**Name: Arjun Parihar
 * Class: Comp 170-003
 * Assignment:Chapter 8A Assignment 1 (Custom Project) - Card Games
 *
 * Purpose of Program:
 * Create a program that can run multiple different card games. Blackjack and War. Have Blackjack money be tracked in
 * a file so that the bank is consistent between runs of the program.
 *
 * @var input - Scanner of Console for user's input on menu
 * @var game - Blackjack or War game depending on input
 *
 * Algorithm:
 * 1. Use Scanner To Get User Input from Menu of Card Games
 * 2. While loop to validate user enters an int from the menu
 * 3. Nested if-elseif based on user input
 * 4. Create selected game by making an object of said game from the classes in the program
 * 5. After game is complete return to menu with ability to exit or play another game
 *
 * @return Main function to run project. Will keep user in loop until exit is selected to play either card game using
 * objects of the Blackjack and War classes.
 */
public class Main
{
    public static void main(String[] args) throws FileNotFoundException
    {
        //Scanner for input
        Scanner170 console = new Scanner170(System.in);
        int input = 0;
        //do while to ensure it runs at lease once to get into menu
        do
        {
            System.out.println("\nWelcome! Would You Like To Play: \n1. Blackjack\n2. War\n3. Exit\n(Please Input Integer 1, 2, or 3):");
            //validate that user inputed an integer
            while(!console.hasNextInt())
            {
                System.out.println("You Must Enter an Integer!");
                //if it was not an integer try again
                console.next();
            }
            input = console.nextInt();
            if(input==1)//Blackjack
            {
                //Create Blackjack game
                Blackjack game = new Blackjack();
                String[] arg ={"1"};//parameter for Blackjack's main function
                game.main(arg);//start game
            }
            else if(input==2)//War
            {
                //Create War game
                War game = new War();
                String[] arg ={"2"};//parameter for War's main function
                game.main(arg);//start game
            }
            else if(input==3)//Exit
            {
                System.out.println("Goodbye!");//let user know program is over
            }
            else//if user entered an int <0 or >3
            {
                System.out.println("Integer entered must be 1, 2, or 3.");
            }
        }while(input != 3);//stay in loop until exit is selected
    }
}
