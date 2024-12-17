package gym.Exception;

/**
 * The DuplicateClientException class is a custom exception that is thrown
 * when an attempt is made to register a client who is already registered in the system
 * or trying to register for the same session again.
 */
public class DuplicateClientException extends Exception {

    /**
     * Constructs a new DuplicateClientException with a specified detail message.
     *
     * @param message The detail message explaining the cause of the exception.
     */
    public DuplicateClientException(String message) {
        super(message);
    }
}
