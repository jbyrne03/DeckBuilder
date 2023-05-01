package Homework3;
/**
 * This class is used to create the Card object.
 * Cards have a name, a class, and a type.
 * Can be used to set and access the values or a card.
 * writeOutput method to print card information.
 * readInput method to allow user to input data for Card objects.
 * @author James Byrne
 * @version 0.1
 * @since 03/09/2023
 * @email jbyrne03@nyit.edu
 */

import java.util.Scanner;

public class Card
{
    private String cardName;
    private String cardClass;
    private String cardType;

    public Card()
    {
    }
    public Card(String newCardName, String newCardClass, String newCardType)
    {
       cardName= newCardName;
        cardClass= newCardClass;
        cardType= newCardType;
    }

    // Mutators

    /**
     * Sets value for String cardName.
     * @param newCardName
     */
    public void setCardName(String newCardName)
    {
        cardName = newCardName;
    }
    /**
     * Sets value for String cardClass.
     * Class can be things like: knight, mage, realtor, priest, etc.
     * This one was confusing because it didn't mean class like the programming term.
     * @param newCardClass
     */
    public void setCardClass(String newCardClass)
    {
        cardClass= newCardClass;
    }
    /**
     * Sets value for String cardClass.
     * Type should be: common, rare, epic, or legendary.
     * Type is also a programming term, but it was still less confusing than class.
     * @param newCardType
     */
    public void setCardType(String newCardType)
    {
        cardType= newCardType;
    }


    //Accessors

    /**
     * Gives access to the value stored in cardName.
     * @return cardName
     */
    public String getCardName()
    {
        return cardName;
    }
    /**
     * Gives access to the value stored in cardClass.
     * @return cardClass
     */
    public String getCardClass()
    {
        return cardClass;
    }
    /**
     * Gives access to the value stored in cardType.
     * @return cardType
     */
    public String getCardType()
    {
        return cardType;
    }

    /**
     * Prints information for a Card object.
     */
    public void writeOutput()
    {
        System.out.println("Name: "+getCardName());
        System.out.println("Class: "+getCardClass());
        System.out.println("Type: "+getCardType());
    }

    /**
     * Allows users to input information for a Card object.
     * cardType is chosen from four options (common, rare, epic, legendary)
     */
    public void readInput()
    {
        Scanner keyboard=new Scanner(System.in);

        System.out.println("What is the name of the card:");
        setCardName(keyboard.nextLine());
        System.out.println("What is the class of the card:");
        setCardClass(keyboard.nextLine());

        boolean badChoice=true;
        while (badChoice)
        {
            System.out.println("What is the type of the card:");
            System.out.println("1. Common");
            System.out.println("2. Rare");
            System.out.println("3. Epic");
            System.out.println("4. Legendary");
            System.out.println("Please enter the number associated with your choice: ");
            int choice = keyboard.nextInt();

            switch (choice)
            {
                case 1:
                    setCardType("Common");
                    break;
                case 2:
                    setCardType("Rare");
                    break;
                case 3:
                    setCardType("Epic");
                    break;
                case 4:
                    setCardType("Legendary");
                    break;
                default:
                    System.out.println("Please enter a valid input.");
                    break;
            }
            if (choice>0 && choice<=4)
            {
                System.out.println("You've chosen: "+getCardType());
                badChoice=false;
            }
        }
    }
}
