package gym.Exception;

/**
 * The InstructorNotQualifiedException class is a custom exception that is thrown
 * when an instructor is not qualified to conduct a specific session type.
 */
public class InstructorNotQualifiedException extends Exception {

    /**
     * Retrieves the exception message indicating the instructor's lack of qualifications.
     *
     * @return A string explaining that the instructor is not qualified for the session type.
     */
    @Override
    public String getMessage() {
        return "Error: Instructor is not qualified to conduct this session type.";
    }
}
