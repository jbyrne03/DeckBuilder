public class DeckIsFullException extends Exception
{
    /**
     * Exception that is used when the deck array is full.
     */
    public DeckIsFullException()
    {
        super("The deck is full!");
    }
    public DeckIsFullException(String message)
    {
        super(message);
    }
}
