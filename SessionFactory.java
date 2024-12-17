public class SessionFactory {

    /**
     * Creates a session based on the specified session type, date, forum type, and instructor.
     *
     * @param sType      The type of session to create (e.g., Ninja, MachinePilates, ThaiBoxing, Pilates).
     * @param date       The date and time for the session.
     * @param fType      The forum type for the session (e.g., Age-based, Gender-based).
     * @param instructor The instructor assigned to lead the session.
     * @return An instance of the appropriate session type, or null if the session type is invalid.
     */
    public Session createSession(SessionType sType, String date, ForumType fType, Instructor instructor) {
        if (sType == null) {
            return null; // No session type specified
        }

        // Create and return the appropriate session based on the session type
        if (sType.name().equals("Ninja")) {
            return new NinjaSession(date, fType, instructor);
        } else if (sType.name().equals("MachinePilates")) {
            return new MachinePilatesSession(date, fType, instructor);
        } else if (sType.name().equals("ThaiBoxing")) {
            return new ThaiBoxingSession(date, fType, instructor);
        } else if (sType.name().equals("Pilates")) {
            return new PilatesSession(date, fType, instructor);
        }

        // If session type doesn't match any known type, return null
        return null;
    }
}