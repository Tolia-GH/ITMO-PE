package Exceptions;

/**
 * The type Abstract exception.
 */
public abstract class AbstractException extends RuntimeException{
    /**
     * Instantiates a new Abstract exception.
     *
     * @param message the message
     */
    public AbstractException(String message) {
        super(message);
    }
}
