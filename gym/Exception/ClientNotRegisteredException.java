package gym.Exception;

/**
 * The ClientNotRegisteredException class is a custom exception that is thrown
 * when an operation is attempted on a client who is not registered in the system.
 */
public class ClientNotRegisteredException extends Exception {

    /**
     * Constructs a new ClientNotRegisteredException with a specified detail message.
     *
     * @param message The detail message explaining the cause of the exception.
     */
    public ClientNotRegisteredException(String message) {
        super(message);
    }
}
