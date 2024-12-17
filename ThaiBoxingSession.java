import java.util.ArrayList;
import java.util.List;

/**
 * Represents a Thai Boxing session in the gym.
 * Implements the Session interface and manages session details,
 * registered clients, and observer notifications.
 */
public class ThaiBoxingSession implements Session {
    private final int PRICE = 100; // Price of the session
    private final int MAX_PARTICIPANTS = 20; // Maximum number of participants allowed
    private SessionType sType;
    private String date;
    private ForumType fType;
    private Instructor instructor;
    private List<Client> registeredClients;
    private ForumTypeStrategy fTypeStrategy;
    private List<Observer> observers;

    /**
     * Constructs a ThaiBoxingSession with the specified date, forum type, and instructor.
     *
     * @param date       The date of the session.
     * @param fType      The forum type for the session (e.g., Male, Female, Age group).
     * @param instructor The instructor leading the session.
     */
    public ThaiBoxingSession(String date, ForumType fType, Instructor instructor) {
        this.sType = SessionType.ThaiBoxing;
        this.date = date;
        this.fType = fType;
        this.instructor = instructor;
        registeredClients = new ArrayList<>();
        fTypeStrategy = fType.getStrategy();
        observers = new ArrayList<>();
    }

    /**
     * Gets the forum type of the session as a string.
     *
     * @return The forum type as a string.
     */
    public String getForumTypeString() {
        return fType.name();
    }

    /**
     * Retrieves the price of the session.
     *
     * @return The price of the session.
     */
    public int getPrice() {
        return PRICE;
    }

    /**
     * Retrieves the instructor of the session.
     *
     * @return The Instructor object leading the session.
     */
    public Instructor getInstructor() {
        return this.instructor;
    }

    /**
     * Gets the session type as a string.
     *
     * @return The session type (Thai Boxing) as a string.
     */
    public String getSessionTypeString() {
        return sType.name();
    }

    /**
     * Retrieves the session date.
     *
     * @return The session date as a string.
     */
    public String getDate() {
        return this.date;
    }

    /**
     * Retrieves the formatted session date in "YYYY-MM-DDTHH:MM" format.
     *
     * @return The formatted session date string.
     */
    public String getDateString() {
        return CurrentDate.YearMonthDateHHmm(this.getDate()).replace(" ", "T");
    }

    /**
     * Registers a client for the session and adds them as an observer.
     *
     * @param client The Client to register.
     */
    public void registerClient(Client client) {
        observers.add(client);
        registeredClients.add(client);
    }

    /**
     * Checks if a client is already registered for the session.
     *
     * @param client The Client to check.
     * @return True if the client is registered, false otherwise.
     */
    public boolean isRegistered(Client client) {
        return registeredClients.contains(client);
    }

    /**
     * Checks if the session has available spots for new participants.
     *
     * @return True if there is space, false otherwise.
     */
    public boolean hasPlace() {
        return (MAX_PARTICIPANTS > registeredClients.size());
    }

    /**
     * Checks if a client has sufficient balance to register for the session.
     *
     * @param client The Client to check.
     * @return True if the client has enough balance, false otherwise.
     */
    public boolean hasBalance(Client client) {
        return (client.getBalance() - PRICE > 0);
    }

    /**
     * Checks if a client meets the forum type requirements (e.g., gender, age).
     *
     * @param client The Client to check.
     * @return True if the client meets the forum requirements, false otherwise.
     */
    public boolean isForumCorrect(Client client) {
        return fTypeStrategy.checkFType(client);
    }

    /**
     * Determines if the forum type is gender-based.
     *
     * @return True if the forum is gender-based, false otherwise.
     */
    public boolean isForumTypeGender() {
        return (fType.equals(ForumType.Male) || fType.equals(ForumType.Female));
    }

    /**
     * Notifies all observers with a given message.
     *
     * @param message The message to send to observers.
     */
    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }

    /**
     * Returns a string representation of the session details.
     *
     * @return A formatted string with session details including type, date, forum, instructor, and participants.
     */
    @Override
    public String toString() {
        return "Session Type: " + this.sType.name() +
                " | Date: " + this.date +
                " | Forum: " + this.fType.name() +
                " | Instructor: " + this.instructor.getName() +
                " | Participants: " + this.registeredClients.size() + "/" + MAX_PARTICIPANTS;
    }
}
