import java.util.ArrayList;
import java.util.List;

public class MachinePilatesSession implements Session {
    private final int PRICE = 80; // Price per session
    private final int MAX_PARTICIPANTS = 10; // Maximum allowed participants
    private SessionType sType; // Type of the session
    private String date; // Session date and time
    private ForumType fType; // Forum type (e.g., Male, Female, Senior)
    private Instructor instructor; // Instructor leading the session
    private List<Client> registeredClients; // List of registered clients
    private ForumTypeStrategy fTypeStrategy; // Forum type strategy for client validation
    private List<Observer> observers; // List of observers for notifications

    /**
     * Constructs a new MachinePilatesSession with the specified date, forum type, and instructor.
     *
     * @param date       The date and time of the session.
     * @param fType      The forum type restricting client participation.
     * @param instructor The instructor leading the session.
     */
    public MachinePilatesSession(String date, ForumType fType, Instructor instructor) {
        this.sType = SessionType.MachinePilates;
        this.date = date;
        this.fType = fType;
        this.instructor = instructor;
        this.registeredClients = new ArrayList<>();
        this.fTypeStrategy = fType.getStrategy();
        this.observers = new ArrayList<>();
    }

    /**
     * Retrieves the forum type of the session as a string.
     *
     * @return A string representing the forum type.
     */
    public String getForumTypeString() {
        return fType.name();
    }

    /**
     * Retrieves the price of the session.
     *
     * @return The cost of the session as an integer.
     */
    public int getPrice() {
        return PRICE;
    }

    /**
     * Retrieves the instructor leading the session.
     *
     * @return The Instructor object.
     */
    public Instructor getInstructor() {
        return this.instructor;
    }

    /**
     * Retrieves the session type as a string.
     *
     * @return A string representing the session type (e.g., MachinePilates).
     */
    public String getSessionTypeString() {
        return sType.name();
    }

    /**
     * Retrieves the raw date of the session.
     *
     * @return A string representing the session date.
     */
    public String getDate() {
        return this.date;
    }

    /**
     * Retrieves the session date formatted as "YYYY-MM-DDTHH:MM".
     *
     * @return A formatted string representing the session date.
     */
    public String getDateString() {
        return CurrentDate.YearMonthDateHHmm(this.getDate()).replace(" ", "T");
    }

    /**
     * Registers a client for the session and adds them as an observer.
     *
     * @param client The Client object to register.
     */
    public void registerClient(Client client) {
        observers.add(client);
        registeredClients.add(client);
    }

    /**
     * Checks if a client is already registered for the session.
     *
     * @param client The Client object to check.
     * @return True if the client is registered, false otherwise.
     */
    public boolean isRegistered(Client client) {
        return registeredClients.contains(client);
    }

    /**
     * Checks if the session has available spots for new clients.
     *
     * @return True if there is space, false otherwise.
     */
    public boolean hasPlace() {
        return (MAX_PARTICIPANTS > registeredClients.size());
    }

    /**
     * Checks if the client has sufficient balance to pay for the session.
     *
     * @param client The Client object to check.
     * @return True if the client has enough balance, false otherwise.
     */
    public boolean hasBalance(Client client) {
        return (client.getBalance() - PRICE > 0);
    }

    /**
     * Checks if the client meets the forum type requirements.
     *
     * @param client The Client object to validate.
     * @return True if the client meets the forum type rules, false otherwise.
     */
    public boolean isForumCorrect(Client client) {
        return fTypeStrategy.checkFType(client);
    }

    /**
     * Determines if the session's forum type is gender-based.
     *
     * @return True if the forum type is gender-based, false otherwise.
     */
    public boolean isForumTypeGender() {
        return (fType.equals(ForumType.Male) || fType.equals(ForumType.Female));
    }

    /**
     * Notifies all registered observers with a specified message.
     *
     * @param message The notification message to send.
     */
    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }

    /**
     * Returns a string representation of the session details, including type, date, forum,
     * instructor, and participant count.
     *
     * @return A formatted string containing session details.
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
