package gym.Exception;

/**
 * The InvalidAgeException class is a custom exception that is thrown
 * when a client does not meet the minimum age requirement (18 years old)
 * to register for a gym membership or session.
 */
public class InvalidAgeException extends Exception {

    /**
     * Retrieves the exception message indicating the age restriction.
     *
     * @return A string explaining that clients must be at least 18 years old to register.
     */
    @Override
    public String getMessage() {
        return "Error: Client must be at least 18 years old to register";
    }
}
