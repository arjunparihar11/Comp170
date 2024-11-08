/**Name: Arjun Parihar
 * Class: Comp 170-003
 * Assignment:Chapter 8A Assignment 1 (Custom Project) - Card Games
 *
 * Purpose of Program:
 * Card class to be able to create card objects to create the deck with for both games. Functions to print cards and
 * for game mechanics
 *
 * @var Suit - an enum (Constant Array) of the 4 suits in a deck of cards
 * @var Value - an enum (Constant Array) of the 14 card values in a deck of cards
 * *Textbook Appendix C*
 *
 * @function Card(Suit s, Value v) - contructor default so that a card is created with a suite and value
 * @param -s - the suite of a created card
 * @param -v - the value of a created card
 *
 * @function toString() - print card in the format "ACE OF DIAMONDS"
 *
 * @function getValue() - returns value of card, needed for blackjack when needing to calculate hand values
 *
 * @function rank() - similar to value function, but needed for War game to set hierarchy of card values
 *
 * Algorithm:
 * 1. This class is mainly created in order for the Deck class to be an array of card objects
 * 2. This class can be used to compare card ranks for War game
 *
 * @return A class for Cards that will be needed for both blackjack and war
 */
public class Card
{
    //Card Characteristics
    final private Suit suit;
    final private Value value;
    //Default Constructor
    public Card(Suit s, Value v)
    {
        value = v;//set card value
        suit = s;//set card suit
    }
    //Prints out Card in Nice Format
    public String toString()
    {
        return value.toString() + " OF " + suit.toString();
    }
    //Return value of Card, necessary for calculating hand values in Blackjack
    public Value getValue()
    {
        return value;
    }
    //Return rank of a card, necessary for calculating winners in War
    public int rank()
    {
        int rank=0;//begin as no rank
        switch(value)//switch case set rank based on the value of the card
        {
            //numbers are ranked as their number
            case TWO: rank = 2; break;
            case THREE: rank = 3; break;
            case FOUR: rank = 4; break;
            case FIVE: rank = 5; break;
            case SIX: rank = 6; break;
            case SEVEN: rank = 7; break;
            case EIGHT: rank = 8; break;
            case NINE: rank = 9; break;
            case TEN: rank = 10; break;
            //faces are worth in order
            case JACK: rank = 11; break;
            case QUEEN: rank = 12; break;
            case KING: rank = 13; break;
            //ace is the most valuable card
            case ACE: rank = 14; break;
        }
        return rank;
    }
}
