import java.util.ArrayList;
import java.util.List;
public class NinjaSession implements Session {
    private final int PRICE = 150; // Price for the session
    private final int MAX_PARTICIPANTS = 5; // Maximum allowed participants
    private SessionType sType;
    private String date;
    private ForumType fType;
    private Instructor instructor;
    private List<Client> registeredClients; // List of clients registered for the session
    private ForumTypeStrategy fTypeStrategy; // Strategy for validating forum type
    private List<Observer> observers; // List of observers to notify

    /**
     * Constructs a new NinjaSession with the specified date, forum type, and instructor.
     *
     * @param date       The date and time of the session.
     * @param fType      The forum type (e.g., age-based or gender-based restrictions).
     * @param instructor The instructor leading the Ninja session.
     */
    public NinjaSession(String date, ForumType fType, Instructor instructor) {
        this.sType = SessionType.Ninja;
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
     * @return The cost of the session.
     */
    public int getPrice() {
        return PRICE;
    }

    /**
     * Retrieves the instructor for the session.
     *
     * @return The Instructor object leading the session.
     */
    public Instructor getInstructor() {
        return this.instructor;
    }

    /**
     * Retrieves the session type as a string.
     *
     * @return The type of session (e.g., Ninja).
     */
    public String getSessionTypeString() {
        return sType.name();
    }

    /**
     * Retrieves the date of the session.
     *
     * @return A string representing the date of the session.
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
     * @param client The Client to register for the session.
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
     * Checks if there are available spots to register new clients.
     *
     * @return True if there are available spots, false otherwise.
     */
    public boolean hasPlace() {
        return (MAX_PARTICIPANTS > registeredClients.size());
    }

    /**
     * Checks if the client has sufficient balance to pay for the session.
     *
     * @param client The Client whose balance is being checked.
     * @return True if the client has enough balance, false otherwise.
     */
    public boolean hasBalance(Client client) {
        return (client.getBalance() - PRICE > 0);
    }

    /**
     * Checks if the client meets the forum type requirements for the session.
     *
     * @param client The Client to validate.
     * @return True if the client meets the forum requirements, false otherwise.
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
     * Returns a string representation of the session details.
     *
     * @return A formatted string containing session type, date, forum, instructor, and participant count.
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