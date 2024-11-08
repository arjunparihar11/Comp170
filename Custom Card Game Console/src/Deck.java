import java.util.*;
/**Name: Arjun Parihar
 * Class: Comp 170-003
 * Assignment:Chapter 8A Assignment 1 (Custom Project) - Card Games
 *
 * Purpose of Program:
 * Deck class the most important class for card games as it handles most of the game mechanics such as hands, the playing
 * deck, shuffling and more. A deck is defined as an ArrayList of Card objects.
 *
 * @function Deck() - construct a deck out of an ArrayList of Card objects
 *
 * @function void createDeck() - add standard 52 cards into a deck ArrayList
 *
 * @function void shuffle() - randomize order of deck
 *
 * @function void addCard(Card c) - add a card from another deck or hand to deck
 * @param -c - The card being added to deck
 *
 * @function void removeCard(int x) - remove a card from deck or hand
 * @param -x - Index of card being removed from deck
 *
 * @function Card getCard(int x) - get Card object info for a card in the deck
 * @param -x - Index of card
 *
 * @functin draw(Deck d) - draw a card from a deck to another or to a hand
 * @param -d - deck being drawn from
 *
 * @function ind value() - calculate the value of a hand in a game of blackjack
 *
 * @function int deckSize() - return number of cards in a deck, necessary for War
 *
 * @function void refillDeck(Deck d) - return cards from hand or another deck to deck
 *
 * @function String toString() - print out all Cards inside an array
 *
 * Algorithm:
 * 1. This deck class is highly importand for both card games as it serves most functions of a card game
 * 2. Most game mechanics of both games are run with functions from the deck class.
 *
 * @return A deck can be used for the playing deck or hands in either game
 */
public class Deck
{
    //A Deck is an ArrayList of Cards
    private ArrayList<Card> cards;
    //Constructor
    public Deck()
    {
        cards = new ArrayList<Card>();
    }
    //Create a deck of 52 cards
    public void createDeck()
    {
        //for each suit add one of each value (13 cards) *For Each Loop in Chapter 7.1 of Textbook
        for(Suit cardSuit : Suit.values())
        {
            //for each value card should have 4 versions 13 * 4 = (52 cards)
            for(Value cardValue : Value.values())
            {
                cards.add(new Card(cardSuit,cardValue));//create a deck of 52 standard cards
            }
        }
    }
    //default deck is ordered, we want to randomize the order to play games
    public void shuffle()
    {
        //temp deck
        ArrayList<Card> temp = new ArrayList<Card>();
        Random rand = new Random();
        int index=0;
        //size will change as cards move, so setting it to a var to stay constant in for loop
        int size = cards.size();
        for(int i=0; i <size;i++)//for every card in deck
        {
            index = rand.nextInt(cards.size());//create a random index 0-51
            temp.add(cards.get(index));//place card at random index
            cards.remove(cards.get(index));//do not repeat same card
        }
        cards = temp;//deck is now shuffled temp deck
    }
    //add a card to deck/hand
    public void addCard(Card c)
    {
        cards.add(c);
    }
    //remove a card from deck/hand
    public void removeCard(int x)
    {
        cards.remove(x);
    }
    //return Card object info of a card in a deck
    public Card getCard(int x)
    {
        return cards.get(x);
    }
    //draw a deck from one to another or to a hand
    public void draw(Deck d)
    {
        cards.add(d.getCard(0));
        d.removeCard(0);
    }
    //value will be used to calculate the value of a hand(deck) in Blackjack to ensure Ace is optimized 11 or 1
    public int value()
    {
        int value=0;//total
        int ace=0;//num of aces
        for(Card c : cards)//for every card in deck
        {
            switch(c.getValue())//if the value is x, +x to total
            {
                case TWO: value += 2; break;
                case THREE: value += 3; break;
                case FOUR: value += 4; break;
                case FIVE: value += 5; break;
                case SIX: value += 6; break;
                case SEVEN: value += 7; break;
                case EIGHT: value += 8; break;
                case NINE: value += 9; break;
                case TEN: value += 10; break;
                case JACK: value += 10; break;
                case QUEEN: value += 10; break;
                case KING: value += 10; break;
                case ACE: ace += 1; break;//count aces in hand
            }
        }
        //Ace value 1 or 11 to avoid bust
        for(int i=0;i<ace;i++)//for every ace in hand
        {
            if(value > 10)//if value is 11 without an ace, ace should always be equal to 1 to avoid bust
            {
                value += 1;
            }
            else//otherwise ace is safe to be 11
            {
                value += 11;
            }
        }
        return value;
    }
    //return number of cards in a deck/hand, most useful for War, but also checking for blackjacks in 2 cards
    public int deckSize()
    {
        return cards.size();
    }
    //take cards from hand back into deck for another round
    public void refillDeck(Deck d)
    {
        int size = cards.size();
        for(int i=0;i<size;i++)
        {
            d.addCard(this.getCard(i));
        }
        for(int j=0;j<size;j++)
        {
            this.removeCard(0);
        }
    }
    //print all the cards in a deck or hand
    public String toString()
    {
        String output = "";
        //int i=0;testing purposes
        //for each card in array
        for(Card c : cards)
        {
            output += "\n" + c.toString();
            //i++;testing purposes
        }
        return output;
    }
}

