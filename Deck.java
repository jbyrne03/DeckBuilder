package Homework3;

import java.util.Scanner;

public class Deck
{
    private String gamerTag;
    private Card[] deck= new Card[30];

    private int position= 0;

    Deck()
    {
        gamerTag= "WorkCardPlayCard499";
    }
    Deck(String newGamerTag)
    {
        gamerTag= newGamerTag;
    }

    //Mutator
    /**
     * Sets value for String gamerTag.
     * This is the user's username.
     * @param newGamerTag
     */
    public void setGamerTag(String newGamerTag)
    {
        gamerTag= newGamerTag;
    }

    //Accessor
    /**
     * Gives access to the value stored in gamerTag.
     * @return gamerTag
     */
    public String getGamerTag()
    {
        return gamerTag;
    }
    /**
     * Gives access to the value stored in position.
     * position is the variable that stores how many cards are in the deck.
     * @return position
     */
    public int getPosition()
    {
        return position;
    }
    /**
     * Checks through a deck to find Card objects with the same name as String name.
     * Counts the number of times a name is equal to the one presented in the parameter.
     * @return count
     */
    private int getCount(String name)
    {
        int count = 0;
        for (int i = 0; i < deck.length; i++)
        {
            if ((deck[i]!= null) && (deck[i].getCardName().equalsIgnoreCase(name)))
            {
               count++;
            }
        }
        return count;
    }

    /**
     * Checks if the count of a card's name in a deck array.
     * If the count is one or more and the Card object is Legendary, the boolean is true.
     * If the count is two or more, the boolean is true.
     * @param card
     * @return true or false
     */
    private boolean isMaxQuantity(Card card)
    {
        if (getCount(card.getCardName()) >= 1 && card.getCardType().equalsIgnoreCase("legendary"))
        {
            return true;
        }
        else if (getCount(card.getCardName()) >= 2)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * Adds a card to the deck array.
     * If the array is full, throws DeckIsFullException.
     * If the name of a card appears too many times, throws MaxCardQuantityException.
     * Invokes readInput method for a card object to allow user to input information.
     * Saves card to the first null index available.
     * Increases value of position variable by one when a card is added.
     * @param card
     */
    public void addCard(Card card)
    {
        try
        {
            if(position>= deck.length)
                throw new DeckIsFullException();

            card.readInput();
            if(isMaxQuantity(card))
                throw new MaxCardQuantityException();
            for (int i= 0; i< deck.length; i++)
            {
                if (deck[i]==null)
                {
                    deck[i] = card;
                    break;
                }
            }
            position++;
        }
        catch(DeckIsFullException e)
        {
            System.out.println(e.getMessage());
        }
        catch(MaxCardQuantityException e)
        {
            System.out.println(e.getMessage());
        }

    }

    /**
     * Removes a card from a deck array.
     * Checks through a deck to find Card objects with the same name as a Card object.
     * Sets first card with the same name as null.
     * If the value of position is equal to 0, throws DeckIsEmptyException.
     * Decreases value of position variable by one when a card is removed.
     * @param card
     */
    public void removeCard(Card card)
    {
        try
        {
            if(position==0)
                throw new DeckIsEmptyException();

            Scanner keyboard= new Scanner(System.in);

            System.out.println("What's the name of the card you want to remove?");
            System.out.println("Enter card name: ");
            card.setCardName(keyboard.nextLine());
            if(getCount(card.getCardName())!=0)
            {
                for (int i=0; i< deck.length; i++)
                {
                    if ((deck[i]!= null) && (deck[i].getCardName().equalsIgnoreCase(card.getCardName())))
                    {
                        deck[i]=null;
                        System.out.println(card.getCardName()+" has been removed.");
                        break;
                    }
                }
                position--;
            }
            else
            {
                System.out.println("That card is not in your deck.");
            }
        }
        catch (DeckIsEmptyException e)
        {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Goes through deck array and prints information for all cards that aren't null.
     */
    public void printDeck()
    {
        for (int i=0; i< deck.length;i++)
        {
            if(deck[i] != null)
            {
                System.out.println("***** Card "+(i+1)+" *****");
                deck[i].writeOutput();
                System.out.println("******************");
                System.out.println();
            }
        }
    }

    /**
     * Allows user to build a deck array.
     * Displays user's gamer tag.
     * Displays number of cards present in the deck.
     * Can add, remove, or print cards.
     * Also provides option to exit the program when finished.
     * Users choose options from a numbered menu.
     * If inputted value is not valid, throws Exception.
     */
    public void buildDeck()
    {
        boolean isActive= true;
        while(isActive==true)
        {
            try {
                int choice = 0;
                Scanner keyboard = new Scanner(System.in);

                System.out.println(getGamerTag() + "'s Deck");
                System.out.println("Card Count: " + getPosition());
                System.out.println();

                System.out.println("What would you like to do?");
                System.out.println("1. Add a card");
                System.out.println("2. Remove a card");
                System.out.println("3. Print Deck");
                System.out.println("4. Exit");
                System.out.println("Please enter the number associated with your choice: ");
                choice = keyboard.nextInt();
                System.out.println();

                switch (choice)
                {
                    case 1:
                        addCard(new Card());
                        break;
                    case 2:
                        removeCard(new Card());
                        break;
                    case 3:
                        printDeck();
                        break;
                    case 4:
                        isActive = false;
                        break;
                    default:
                        System.out.println("Please enter a valid input");

                }
            }
            catch (Exception e)
            {
                System.out.println("Something went wrong");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("End of program");
        System.exit(0);
    }



    public static void main(String[] args)
    {
        Scanner keyboard= new Scanner(System.in);

        System.out.println("Welcome to the Hearth's Tone Card Deck Editor.");
        System.out.println("***DISCLAIMER: Any resemblance to other Intellectual Properties is purely coincidental.***");
        System.out.println();

        Deck deck1= new Deck();
        System.out.println("Please enter your gamertag: ");
        deck1.setGamerTag(keyboard.nextLine());
        System.out.println("Hello, "+deck1.getGamerTag());
        System.out.println();
        deck1.buildDeck();
    }
}
