/**Name: Arjun Parihar
 * Class: Comp 170-003
 * Assignment:Chapter 8A Assignment 1 (Custom Project) - Card Games
 *
 * Purpose of Program:
 * The War class handles the actual game of War using function from the deck or card classes.
 *
 * Algorithm:
 *  1. Welcome to the game, print out basic rules of War
 *  2. Scanner for user input if they want to begin
 *  3. Create decks, split deck between user and cpu, have hand for user to select from 3 drawn cards
 *  4. Using Scanner user inputs which of the 3 drawn cards they want to play
 *  5. Each battle has 3 outcomes: User Wins, CPU wins, Tie-WAR
 *  6. If User wins both cards played get added to playerDeck
 *  7. If CPU wins both cards played get added to cpuDeck
 *  8. If there is a tie, WAR begins, each user will place 1 card from deck until there is a winner
 *  9. Using a loop to keep game in WAR until a winner is chosen
 * 10. War uses temporary hands so that when a winner is decided the cards are easily transferred to winner
 * 11. Game continues util one side loses all their cards to the other.
 *
 * @return The class ends after user loses all their cards or decides to exit. User will be sent back to the loop in
 *         Main class.
 **/
public class War
{
    public static void main(String[] args)
    {
        //Rules
        System.out.println("\nWelcome to WAR!\nRULES:" +
                "\nThe deck is divided evenly, with each player receiving 26 cards. Randomly selected who will go first. Each player places draws 3 cards into their hand." +
                "\nThe player picks one card to play at a time and the CPU does the same. Whoever has the higher card at each draw takes both cards and puts them on the bottom of their deck." +
                "\nIf the turned-up cards are again the same rank, it is WAR. Each player places another card face down from the top of their deck until someone has a higher card takes all " +
                "\n10 cards, and so on. The game ends when one player has won all the cards.");
        Scanner170 console = new Scanner170(System.in);
        int input = 0;
        do//So that loop goes at least once
        {
            //create decks, and user hand
            Deck deck = new Deck();
            deck.createDeck();
            Deck playerDeck = new Deck();
            Deck cpuDeck = new Deck();
            Deck hand = new Deck();
            //Validation to begin
            System.out.println("\nBegin Round of War?\n1. Yes\n2. No");
            while (!console.hasNextInt())//if user inputed proper int
            {
                System.out.println("You Must Enter an Integer.");
                console.next();//try again
            }
            input = console.nextInt();
            if (input == 1)//Play
            {
                //Shuffle deck
                //Split deck into 2 decks, one for player and one for cpu
                deck.shuffle();
                for (int i = 0; i < 26; i++)
                {
                    playerDeck.draw(deck);//draw 26 cards into player deck
                }
                for (int j = 0; j < 26; j++)
                {
                    cpuDeck.draw(deck);//draw 26 cards into cpu deck
                }
                //player draws 3 cards into their hand to begin
                hand.draw(playerDeck);
                hand.draw(playerDeck);
                hand.draw(playerDeck);
                //Game loops until someone loses their cards
                while (hand.deckSize() > 0  || cpuDeck.deckSize() > 0)
                {
                    //if hand doesn't have 3 cards but playerDeck has cards remaining, add to hand
                    while(hand.deckSize() < 3 && playerDeck.deckSize() > 0)
                    {
                        hand.draw(playerDeck);
                    }
                    //if user has no cards left break from game loop
                    if(hand.deckSize()==0)
                    {
                        break;
                    }
                    //Current Score
                    System.out.println("Player: " + (playerDeck.deckSize()+ hand.deckSize()) + "\tCPU: " + cpuDeck.deckSize());
                    //cpu Shuffle every round
                    cpuDeck.shuffle();
                    //print user 2
                    //System.out.println("Player Deck:"+playerDeck.toString()); Testing
                    //System.out.println("Hand:"+hand.toString()); Testing
                    //If user has less than 3 cards dont give them 3 opitiobs each time
                    if(playerDeck.deckSize()+hand.deckSize() >= 3)//if more than 3
                    {
                        System.out.println("\nWhich Card Will You Play?\n0. " + hand.getCard(0) + "\n1. " + hand.getCard(1) + "\n2. " + hand.getCard(2));
                    }
                    if(hand.deckSize() == 2)//2 options
                    {
                        System.out.println("\nWhich Card Will You Play?\n0. " + hand.getCard(0) + "\n1. " + hand.getCard(1));
                    }
                    else//only option is to play your only card
                    {
                        input = 0;
                    }
                    while (!console.hasNextInt())//validate user sent an int
                    {
                        System.out.println("Must Enter an Integer");
                        console.next();//try again
                    }
                    input = console.nextInt();
                    if (input == 0)//Played 1st Card in Hand
                    {
                        if (hand.getCard(0).rank() > cpuDeck.getCard(0).rank())//If User Card > CPU Card
                        {
                            //Print Results
                            System.out.println("You Played: " + hand.getCard(0).toString());
                            System.out.println("CPU Played: " + cpuDeck.getCard(0).toString());
                            System.out.println("You Won");
                            //Add Cards to Winner's Deck
                            playerDeck.addCard(hand.getCard(0));
                            hand.removeCard(0);
                            playerDeck.draw(cpuDeck);
                            //if Deck has no cards, cannot draw
                            if(playerDeck.deckSize() >0)
                            {
                                hand.draw(playerDeck);
                            }
                        }
                        else if (hand.getCard(0).rank() == cpuDeck.getCard(0).rank())//if User Card = CPU Card then WAR
                        {
                            //print results
                            System.out.println("You Played: " + hand.getCard(0).toString());
                            System.out.println("CPU Played: " + cpuDeck.getCard(0).toString());
                            //WAR until winner or out of cards
                            while (true || playerDeck.deckSize()==0)
                            {
                                //temp hands for WAR
                                System.out.println("WAR");
                                Deck playerWar = new Deck();
                                Deck cpuWar = new Deck();
                                //If there is no cards in deck draw from hand
                                if(playerDeck.deckSize() >0)
                                {
                                    playerWar.draw(playerDeck);
                                }
                                else if(hand.deckSize() >0)
                                {
                                    playerWar.draw(hand);
                                }
                                //Rare, but happened in testing where last card was the same as CPU and game could not go on
                                else
                                {
                                    break;//break lose via tiebreaker of cards remaining
                                }
                                cpuWar.draw(cpuDeck);
                                System.out.println("You Played: " + playerWar.getCard(playerWar.deckSize() - 1).toString());
                                System.out.println("CPU Played: " + cpuWar.getCard(cpuWar.deckSize() - 1).toString());
                                if (playerWar.getCard(playerWar.deckSize() - 1).rank() > cpuWar.getCard(cpuWar.deckSize() - 1).rank())
                                {//If you win then all cards from WAR go to your deck
                                    System.out.println("You Won");
                                    int size = cpuWar.deckSize();//var since size would change
                                    for (int i = 0; i < size; i++)//for every card in the war add to your deck
                                    {
                                        playerDeck.draw(cpuWar);
                                    }
                                    int size2 = playerWar.deckSize();//var since size would change
                                    for (int i = 0; i < size2; i++)//for every card in the war add to your deck
                                    {
                                        playerDeck.draw(playerWar);
                                    }
                                    //reload hand with 3 cards
                                    playerDeck.addCard(hand.getCard(0));
                                    hand.removeCard(0);
                                    playerDeck.draw(cpuDeck);
                                    //cannot draw if out of cards in deck
                                    if(playerDeck.deckSize() >0)
                                    {
                                        hand.draw(playerDeck);
                                    }
                                    break;//exit War Loop
                                }
                                if (playerWar.getCard(playerWar.deckSize() - 1).rank() < cpuWar.getCard(cpuWar.deckSize() - 1).rank())
                                {//if CPU Card > User Card in WAR
                                    System.out.println("You Lost");
                                    int size = playerWar.deckSize();
                                    for (int i = 0; i < size; i++)//every card played in War goes to CPU deck
                                    {
                                        cpuDeck.draw(playerWar);
                                    }
                                    //reload hand
                                    cpuDeck.addCard(hand.getCard(0));
                                    hand.removeCard(0);
                                    //cannot draw if out of cards
                                    if(playerDeck.deckSize() >0)
                                    {
                                        hand.draw(playerDeck);
                                    }
                                    break;//exit War loop
                                }
                            }
                        }
                        else//if CPU Card > User Card
                        {
                            //Print Results
                            System.out.println("You Played: " + hand.getCard(0).toString());
                            System.out.println("CPU Played: " + cpuDeck.getCard(0).toString());
                            System.out.println("You Lost");
                            //add user cards to cpu decl
                            cpuDeck.addCard(hand.getCard(0));
                            hand.removeCard(0);
                            //reload user hand, if cards available
                            if(playerDeck.deckSize() >0)
                            {
                                hand.draw(playerDeck);
                            }
                        }
                    }
                    else if (input == 1)//User plays 2nd Cart
                    {
                        //User Card > CPU Card
                        if (hand.getCard(1).rank() > cpuDeck.getCard(0).rank())
                        {
                            //Print
                            System.out.println("You Played: " + hand.getCard(1).toString());
                            System.out.println("CPU Played: " + cpuDeck.getCard(0).toString());
                            System.out.println("You Won");
                            //Add Cards
                            playerDeck.addCard(hand.getCard(1));
                            hand.removeCard(1);
                            //Reload Hand
                            playerDeck.draw(cpuDeck);
                            if(playerDeck.deckSize() >0)
                            {
                                hand.draw(playerDeck);
                            }
                        }
                        else if (hand.getCard(1).rank() == cpuDeck.getCard(0).rank())
                        {//Tie - WAR
                            System.out.println("You Played: " + hand.getCard(1).toString());
                            System.out.println("CPU Played: " + cpuDeck.getCard(0).toString());
                            while (true || playerDeck.deckSize()==0) //Loop until winner or out of cards
                            {
                                System.out.println("WAR");
                                Deck playerWar = new Deck();
                                Deck cpuWar = new Deck();
                                if(playerDeck.deckSize() >0)//if user wins add hand to their deck
                                {
                                    playerWar.draw(playerDeck);
                                }
                                else if(hand.deckSize() >0)//if cpu wins add hand to its deck
                                {
                                    playerWar.draw(hand);
                                }
                                else
                                {
                                    //Rare loss to WAR with tie and no cards remaining
                                    break;//Exit to lose
                                }
                                //Add Cards/ Reload hand
                                cpuWar.draw(cpuDeck);
                                System.out.println("You Played: " + playerWar.getCard(playerWar.deckSize() - 1).toString());
                                System.out.println("CPU Played: " + cpuWar.getCard(cpuWar.deckSize() - 1).toString());
                                if (playerWar.getCard(playerWar.deckSize() - 1).rank() > cpuWar.getCard(cpuWar.deckSize() - 1).rank())
                                {//if User Wins
                                    System.out.println("You Won");
                                    int size = cpuWar.deckSize();
                                    for (int i = 0; i < size; i++)
                                    {
                                        playerDeck.draw(cpuWar);
                                    }
                                    int size2 = playerWar.deckSize();
                                    for (int i = 0; i < size2; i++)
                                    {
                                        playerDeck.draw(playerWar);
                                    }
                                    playerDeck.addCard(hand.getCard(1));
                                    hand.removeCard(1);
                                    playerDeck.draw(cpuDeck);
                                    if(playerDeck.deckSize() >0)
                                    {
                                        hand.draw(playerDeck);
                                    }
                                    break;
                                }
                                if (playerWar.getCard(playerWar.deckSize() - 1).rank() < cpuWar.getCard(cpuWar.deckSize() - 1).rank())
                                {//if user loses WAR
                                    System.out.println("You Lost");
                                    int size = playerWar.deckSize();
                                    for (int i = 0; i < size; i++)//add hand from WAR to cpu
                                    {
                                        cpuDeck.draw(playerWar);
                                    }
                                    cpuDeck.addCard(hand.getCard(1));
                                    hand.removeCard(1);
                                    //cannot draw from nothing
                                    if(playerDeck.deckSize() >0)
                                    {
                                        hand.draw(playerDeck);
                                    }
                                    break;
                                }
                            }
                        }
                        else//cpu > user card
                        {
                            //print
                            System.out.println("You Played: " + hand.getCard(1).toString());
                            System.out.println("CPU Played: " + cpuDeck.getCard(0).toString());
                            System.out.println("You Lost");
                            cpuDeck.addCard(hand.getCard(1));
                            hand.removeCard(1);
                            //cannot draw from nothing
                            if(playerDeck.deckSize() >0)
                            {
                                hand.draw(playerDeck);
                            }
                        }
                    }
                    else if (input == 2)//User plays 3rd Card
                    {
                        if (hand.getCard(2).rank() > cpuDeck.getCard(0).rank())
                        {//user > cpu card
                            //print
                            System.out.println("You Played: " + hand.getCard(2).toString());
                            System.out.println("CPU Played: " + cpuDeck.getCard(0).toString());
                            System.out.println("You Won");
                            //reload hand/add to deck
                            playerDeck.addCard(hand.getCard(2));
                            hand.removeCard(2);
                            playerDeck.draw(cpuDeck);
                            //cannot draw from nothing
                            if(playerDeck.deckSize() >0)
                            {
                                hand.draw(playerDeck);
                            }
                        }
                        else if (hand.getCard(2).rank() == cpuDeck.getCard(0).rank())
                        {//push - WAR
                            System.out.println("You Played: " + hand.getCard(2).toString());
                            System.out.println("CPU Played: " + cpuDeck.getCard(0).toString());
                            while (true || playerDeck.deckSize()==0)
                            {//War Loop until winner or loss of cards
                                System.out.println("WAR");
                                Deck playerWar = new Deck();
                                Deck cpuWar = new Deck();
                                //draw from hand if needed
                                if(playerDeck.deckSize() >0)
                                {
                                    playerWar.draw(playerDeck);
                                }
                                else if(hand.deckSize() >0)
                                {
                                    playerWar.draw(hand);
                                }
                                else//Rare loss to losing card on a push in WAR
                                {
                                    break;
                                }
                                cpuWar.draw(cpuDeck);
                                System.out.println("You Played: " + playerWar.getCard(playerWar.deckSize() - 1).toString());
                                System.out.println("CPU Played: " + cpuWar.getCard(cpuWar.deckSize() - 1).toString());
                                if (playerWar.getCard(playerWar.deckSize() - 1).rank() > cpuWar.getCard(cpuWar.deckSize() - 1).rank())
                                {//user wins WAR
                                    System.out.println("You Won");
                                    int size = cpuWar.deckSize();
                                    //Add hands from WAR to user deck
                                    for (int i = 0; i < size; i++)
                                    {
                                        playerDeck.draw(cpuWar);
                                    }
                                    int size2 = playerWar.deckSize();
                                    for (int i = 0; i < size2; i++)
                                    {
                                        playerDeck.draw(playerWar);
                                    }
                                    //reload hand
                                    playerDeck.addCard(hand.getCard(2));
                                    hand.removeCard(2);
                                    playerDeck.draw(cpuDeck);
                                    //cannot draw from nothing
                                    if(playerDeck.deckSize() >0)
                                    {
                                        hand.draw(playerDeck);
                                    }
                                    break;//exit loop
                                }
                                if (playerWar.getCard(playerWar.deckSize() - 1).rank() < cpuWar.getCard(cpuWar.deckSize() - 1).rank())
                                {//cpu > user in WAR
                                    System.out.println("You Lost");
                                    int size = playerWar.deckSize();
                                    //user war hand goes to cpu
                                    for (int i = 0; i < size; i++)
                                    {
                                        cpuDeck.draw(playerWar);
                                    }
                                    //reload hand
                                    cpuDeck.addCard(hand.getCard(2));
                                    hand.removeCard(2);
                                    //cannot draw from nothing
                                    if(playerDeck.deckSize() >0)
                                    {
                                        hand.draw(playerDeck);
                                    }
                                    break;
                                }
                            }
                        }
                        else//CPU > User Card
                        {
                            //print
                            System.out.println("You Played: " + hand.getCard(2).toString());
                            System.out.println("CPU Played: " + cpuDeck.getCard(0).toString());
                            System.out.println("You Lost");
                            //reload hand
                            cpuDeck.addCard(hand.getCard(2));
                            hand.removeCard(2);
                            //cannot draw from nothing
                            if(playerDeck.deckSize() >0)
                            {
                                hand.draw(playerDeck);
                            }
                        }
                    }
                }
                //exit game loops to see who won
                if(playerDeck.deckSize() == 0)//if user has no cards they lost
                {
                    System.out.println("You Lost All Your Cards. Game Over.");
                }
                else//otherwise cpu lost
                {
                    System.out.println("You Took All The CPU's Cards. Congrats!");
                }
            }
            else if (input == 2)//exit
            {
                System.out.println("Thanks For Playing War!");
            }
            else//user did not enter proper int
            {
                System.out.println("You Must Enter 1 or 2.");
            }
        } while (input != 2);
    }
}

