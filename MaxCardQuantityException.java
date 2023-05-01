public class MaxCardQuantityException extends Exception
{
    /**
     * Exception that is used when a card exceeds its quantity limit in a deck.
     */
    public MaxCardQuantityException()
    {
        super("You cannot have anymore of that card.");
    }

    public MaxCardQuantityException(String message)
    {
        super(message);
    }
}
