import java.io.FileNotFoundException;//for saving score
import java.io.PrintStream;//For printing score
import java.io.File;//For saving score
/**Name: Arjun Parihar
 * Class: Comp 170-003
 * Assignment:Chapter 8A Assignment 1 (Custom Project) - Card Games
 *
 * Purpose of Program:
 * The Blackjack class handles the actual game of blackjack using function from the deck or card classes.
 *
 * Algorithm:
 *  1. Welcome to the game, print out basic rules of Blackjack
 *  2. Create playing deck, shuffle it and create hands for dealer and player
 *  3. Get Bank money account from txt file
 *  4. Begin game loop by asking if they are ready for a round of blackjack
 *  5. Use Scanner console to get a bet amount from user
 *  6. Validate user inputed a double for their bet
 *  7. Draw cards and based on user hand send them to one of 3 game loops
 *  8. One for if they can split, double down, or none
 *  9. Game loops to allow user to hit until they bust or stand
 * 10. After exiting game loop winner validations are in place
 * 11. Seperate one for if there was a split to check the extra hand
 * 12. User can then play again until they run out of money or exit and save their bank to txt file.
 *
 * @return The class ends after user loses all their money or decides to save their banked cash an exits. User will be
 *         sent back to the loop in Main class.
 **/
public class Blackjack
{
    public static void main(String[] args) throws FileNotFoundException
    {
        //Rules
        System.out.println("\nWelcome to BLACKJACK!\nRULES:" +
                "\nThe player attempts to beat the dealer by getting a count as close to 21 as possible, without going over 21." +
                "\nBefore the deal begins, the player places a bet, you will start with $100." +
                "\nNumbered cards are worth their number in value, faces are worth 10, and aces are worth 1 or 11." +
                "\nThe dealer is dealt a face up and face down card then the player goes first and must decide whether to \"stand\" (not ask for another card) or \"hit\" (ask for another card)" +
                "\nWhen player stands, the dealer's face-down card is turned up. If the total is 17 or more, it must stand. Otherwise, they must take a card. " +
                "\nThe dealer must continue to take cards until the total is 17 or more, at which point the dealer must stand.");
        //Create deck and hands
        Deck deck = new Deck();
        deck.createDeck();
        deck.shuffle();
        Deck dealer = new Deck();
        Deck hand = new Deck();
        Deck splitHand = new Deck();
        //Bank
        Scanner170 bank = new Scanner170(new File("C:/Users/aspar/OneDrive/Documents/School/Loyola/Comp 170/Custom Card Game Console/src/BlackJackBank.txt"));
        double money = bank.nextDouble();
        //Game Loop
        Scanner170 console = new Scanner170(System.in);
        int input = 0;
        do//Make sure runs at least once
        {
            System.out.println("\nPlayer Bank: $" + money +"\nStart Blackjack Round?\n1. Yes\n2. No");
            while(!console.hasNextInt())//is input an int?
            {
                System.out.println("Must Enter 1 or 2");
                console.next();//try again
            }
            input = console.nextInt();
            if(input==1)//Play Blackjack
            {
                System.out.println("Player Bank: $" + money + "\nHow Much Would You Like To Bet:");
                while (!console.hasNextDouble())//validate bet
                {
                    System.out.println("Please Enter a Double for your Bet");
                    console.next();
                }
                double bet = console.nextDouble();
                if (bet > money)//cannot bet more money than you have in the bank
                {
                    System.out.println("You Cannot Bet More Than You Have In Your Bank");
                    break;//exit loop, try again
                }
                //shuffle deck and deal cards
                deck.shuffle();
                //dealer gets first draw
                dealer.draw(deck);
                dealer.draw(deck);
                //player gets next
                hand.draw(deck);
                hand.draw(deck);
                boolean end = false;//for checking win scenarios
                boolean split = false;//for checking win scenarios
                if (money > 2 * bet)//if you have double your bet available, split or double down is available
                {
                    if (hand.getCard(0).equals(hand.getCard(1)))//if you have 2 cards of same value split is available
                    {
                        while (true)//Loop until stand or bust
                        {
                            System.out.println("\nDealer's Hand: (?)");
                            System.out.println(dealer.getCard(0).toString() + "\nFACE DOWN CARD");
                            System.out.print("\nYour Hand: (" + hand.value() + ")");
                            System.out.println(hand.toString());

                            System.out.println("\nWould You Like To:\n1. Hit\n2. Stand\n3. Double Down\n4. Split Hand");
                            int action = console.nextInt();
                            if (action == 1)//Hit
                            {
                                hand.draw(deck);
                                if (hand.value() > 21)//Bust
                                {
                                    System.out.print("\nYour New Hand: (" + hand.value() + ")");
                                    System.out.println(hand.toString());
                                    System.out.println(hand.value() + ", You Busted");
                                    money -= bet;
                                    end = true;
                                    break;
                                }
                            }
                            if (action == 2)//Stand
                            {
                                break;
                            }
                            if (action == 3)//Double Down
                            {
                                bet *= 2;//Double bet
                                hand.draw(deck);
                                System.out.print("\nYour New Hand: (" + hand.value() + ")");
                                System.out.println(hand.toString());
                                if (hand.value() > 21)
                                {
                                    System.out.println(hand.value() + ", You Busted");
                                    money -= bet;
                                    end = true;
                                    break;
                                }
                                break;//Only allowed to hit once on a double down
                            }
                            if (action == 4)//Split
                            {
                                //Create 2nd hand with one card from original hand
                                split = true;
                                splitHand.addCard(hand.getCard(1));
                                hand.removeCard(1);
                                splitHand.draw(deck);
                                hand.draw(deck);
                                while (true)//Game loop with 2 hands
                                {
                                    System.out.println("\nDealer's Hand: (?)");
                                    System.out.println(dealer.getCard(0).toString() + "\nFACE DOWN CARD");
                                    System.out.print("\nYour 1st Hand: (" + hand.value() + ")");
                                    System.out.println(hand.toString());

                                    System.out.println("\nWould You Like To:\n1. Hit\n2. Stand");
                                    int act = console.nextInt();
                                    if (act == 1)//Hit
                                    {
                                        hand.draw(deck);
                                        if (hand.value() > 21)//Bust
                                        {
                                            System.out.print("\nYour New Hand: (" + hand.value() + ")");
                                            System.out.println(hand.toString());
                                            System.out.println(hand.value() + ", You Busted");
                                            money -= bet;
                                            end = true;
                                            break;
                                        }
                                    }
                                    if (act == 2)//Stand
                                    {
                                        break;
                                    }
                                }
                                while (true)//2nd Hand
                                {
                                    System.out.println("\nDealer's Hand: (?)");
                                    System.out.println(dealer.getCard(0).toString() + "\nFACE DOWN CARD");
                                    System.out.print("\nYour Split Hand: (" + splitHand.value() + ")");
                                    System.out.println(splitHand.toString());

                                    System.out.println("\nWould You Like To:\n1. Hit\n2. Stand");
                                    int act = console.nextInt();
                                    if (act == 1)//Hit
                                    {
                                        splitHand.draw(deck);
                                        System.out.print("\nYour New Split Hand: (" + splitHand.value() + ")");
                                        System.out.println(splitHand.toString());
                                        if (splitHand.value() > 21)//Bust
                                        {
                                            System.out.println(splitHand.value() + ", You Busted");
                                            money -= bet;
                                            end = true;
                                            break;
                                        }
                                    }
                                    if (act == 2)//Stand
                                    {
                                        break;
                                    }
                                }
                            }
                        }
                    }
                    else//Split is not available
                    {
                        while (true)//Game Loop
                        {
                            System.out.println("\nDealer's Hand: (?)");
                            System.out.println(dealer.getCard(0).toString() + "\nFACE DOWN CARD");
                            System.out.print("\nYour Hand: (" + hand.value() + ")");
                            System.out.println(hand.toString());

                            System.out.println("\nWould You Like To:\n1. Hit\n2. Stand\n3. Double Down");
                            int action = console.nextInt();
                            if (action == 1)//Hit
                            {
                                hand.draw(deck);
                                if (hand.value() > 21)//Bust
                                {
                                    System.out.print("\nYour New Hand: (" + hand.value() + ")");
                                    System.out.println(hand.toString());
                                    System.out.println(hand.value() + ", You Busted");
                                    money -= bet;
                                    end = true;
                                    break;
                                }
                            }
                            if (action == 2)//Stand
                            {
                                break;
                            }
                            if (action == 3)//Double Down
                            {
                                bet *= 2;//Double Bet
                                hand.draw(deck);
                                System.out.print("\nYour New Hand: (" + hand.value() + ")");
                                System.out.println(hand.toString());
                                if (hand.value() > 21)
                                {
                                    System.out.println(hand.value() + ", You Busted");
                                    money -= bet;
                                    end = true;
                                    break;
                                }
                                break;//Can only hit once on a double down
                            }
                        }
                    }
                }
                else //Double down and Split not available
                {
                    while (true)
                    {
                        System.out.println("\nDealer's Hand: (?)");
                        System.out.println(dealer.getCard(0).toString() + "\nFACE DOWN CARD");
                        System.out.print("\nYour Hand: (" + hand.value() + ")");
                        System.out.println(hand.toString());

                        System.out.println("\nWould You Like To:\n1. Hit\n2. Stand");
                        int action = console.nextInt();
                        if (action == 1)//Hit
                        {
                            hand.draw(deck);
                            if (hand.value() > 21)//Bust
                            {
                                System.out.print("\nYour New Hand: (" + hand.value() + ")");
                                System.out.println(hand.toString());
                                System.out.println(hand.value() + ", You Busted");
                                money -= bet;
                                end = true;
                                break;
                            }
                        }
                        if (action == 2)//Stand
                        {
                            break;
                        }
                    }
                }

                if (dealer.value() == 21 && dealer.deckSize() == 2 && end == false)//Dealer Blackjack = Auto Loss
                {
                    System.out.print("\nDealer's Hand: (" + dealer.value() + ")");
                    System.out.println(dealer.toString());
                    System.out.println("Dealer Has Blackjack, You Lose");
                    if(split)
                    {
                        System.out.print(" Both Hands\n");
                        money -= bet;
                    }
                    money -= bet;
                    end = true;
                }
                if (hand.value() == 21 && hand.deckSize() == 2 && end == false)//If you get blackjack 1.5x bet
                {
                    System.out.println("YOU GOT BLACKJACK!");
                    money += 1.5 * bet;
                    end = true;
                }
                if (dealer.value() > hand.value() && end == false && dealer.value() < 21) //if Dealer hand > with only 2 cards You Lose
                {
                    System.out.print("\nDealer's Hand: (" + dealer.value() + ")");
                    System.out.println(dealer.toString());
                    System.out.println("Dealer Wins, You Lose");
                    money -= bet;
                    end = true;
                }
                while (dealer.value() < 17 && end==false) //Dealer "AI", Draw until 17 or higher
                {
                    dealer.draw(deck);
                }
                //System.out.print("\nDealer's Hand: (" + dealer.value() + ")");
                //System.out.println(dealer.toString());
                if (dealer.value() > hand.value() && end == false && dealer.value() < 21)//if Dealer > without bust you lose
                {
                    System.out.print("\nDealer's Hand: (" + dealer.value() + ")");
                    System.out.println(dealer.toString());
                    System.out.println("Dealer Wins, You Lose");
                    money -= bet;
                    end = true;
                }
                if (dealer.value() > 21 && end == false)//if dealer > you lose
                {
                    System.out.print("\nDealer's Hand: (" + dealer.value() + ")");
                    System.out.println(dealer.toString());
                    System.out.println("Dealer Loses, You Win");
                    money += bet;
                    end = true;
                }
                if (dealer.value() == hand.value() && end == false)// if tie Push
                {
                    System.out.print("\nDealer's Hand: (" + dealer.value() + ")");
                    System.out.println(dealer.toString());
                    System.out.println("Hands are Equal. Push.");
                    end = true;
                }
                if (hand.value() > dealer.value() && end == false)//if you are > without going over you win
                {
                    System.out.print("\nDealer's Hand: (" + dealer.value() + ")");
                    System.out.println(dealer.toString());
                    System.out.println("Dealer Loses, You Win");
                    money += bet;
                    end = true;
                }
                if(split)//if there is a split test split hand vs dealer as well
                {
                    if (splitHand.value() == 21 && splitHand.deckSize() == 2 && end == false)//if you get blackjack 1.5x bet
                    {
                        System.out.println("YOU GOT BLACKJACK!");
                        money += 1.5 * bet;
                        end = true;
                    }
                    if (dealer.value() > splitHand.value() && end == false) //if dealer is > without drawing you lose
                    {
                        System.out.print("\nDealer's Hand: (" + dealer.value() + ")");
                        System.out.println(dealer.toString());
                        System.out.println("Dealer Wins, You Lose");
                        money -= bet;
                        end = true;
                    }
                    while (dealer.value() < 17)//Dealer "AI", draw until 17 or over
                    {
                        dealer.draw(deck);
                    }
                    //System.out.print("\nDealer's Hand: (" + dealer.value() + ")");
                    //System.out.println(dealer.toString());
                    if (dealer.value() > splitHand.value() && end == false)//if Dealer > without bust you lose
                    {
                        System.out.print("\nDealer's Hand: (" + dealer.value() + ")");
                        System.out.println(dealer.toString());
                        System.out.println("Dealer Wins, You Lose");
                        money -= bet;
                        end = true;
                    }
                    if (dealer.value() > 21 && end == false) //if Dealer busts, you win
                    {
                        System.out.println("Dealer Busts, You Win");
                        money += bet;
                        end = true;
                    }
                    if (dealer.value() == splitHand.value() && end == false) //Push split hand if tie
                    {
                        System.out.println("Hands are Equal. Push.");
                        end = true;
                    }
                    if (splitHand.value() > dealer.value() && end == false)//if split hand > without bust you win
                    {
                        System.out.println("Dealer Busts, You Win");
                        money += bet;
                        end = true;
                    }
                }
                //put cards back in deck for next round
                hand.refillDeck(deck);
                splitHand.refillDeck(deck);
                dealer.refillDeck(deck);
            }
            else if(input==2)//End game
            {
                System.out.println("Thanks For Playing Blackjack");
                try//Save winnings in txt file for next time
                {
                    PrintStream saveBank = new PrintStream("C:/Users/aspar/OneDrive/Documents/School/Loyola/Comp 170/Custom Card Game Console/src/BlackJackBank.txt");
                    saveBank.print(money);
                    saveBank.close();
                }
                catch(Exception e)//catch in case file not found
                {
                    e.getStackTrace();
                }
            }
            else//User did not enter 1 or 2 as an int
            {
                System.out.println("Must Enter 1 or 2");
            }
        }while(input!=2);//Stay in loop until exit
    }
}
