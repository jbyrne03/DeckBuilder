package Homework3;

public class DeckIsEmptyException extends Exception
{
    /**
     * Exception that is used when the deck array is empty.
     */
    public DeckIsEmptyException()
    {
        super("The deck is empty!");
    }
    public DeckIsEmptyException(String message)
    {
        super(message);
    }
}
