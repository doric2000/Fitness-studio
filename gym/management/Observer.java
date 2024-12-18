package gym.management;

/**
 * The gym.management.Observer interface defines a contract for objects that need to be notified of updates or changes
 * It follows the gym.management.Observer design pattern, where observers listen for messages or notifications
 * from a subject they are registered with.
 */
public interface Observer {

    /**
     * Updates the observer with a specific message.
     * This method is called when the subject (observable) notifies all registered observers.
     *
     * @param message The message containing the update or notification details.
     */
    void update(String message);
}