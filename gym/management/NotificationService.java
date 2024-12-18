package gym.management;

import gym.CurrentDate;
import gym.customers.Client;
import gym.management.Sessions.Session;

import java.util.List;

public class NotificationService {
    private Gym gym; // Reference to the gym.management.Gym instance

    /**
     * Constructs a gym.management.NotificationService with a reference to the gym.management.Gym instance.
     *
     * @param gym The gym.management.Gym instance used for retrieving sessions and clients.
     */
    public NotificationService(Gym gym) {
        this.gym = gym;
    }

    /**
     * Sends a notification to all observers registered for a specific session.
     * A history log is also updated to record the message and the session details.
     *
     * @param session The session for which the message is sent.
     * @param message The notification message to send.
     */
    public void notify(Session session, String message) {
        session.notifyObservers(message);
        gym.addHistoryLog("A message was sent to everyone registered for session " +
                session.getSessionTypeString() + " on " + session.getDateString() + " : " + message);
    }

    /**
     * Sends a notification to all observers registered for sessions occurring on a specific date.
     * A history log is updated to record the message and affected date.
     *
     * @param date          The date for which notifications are sent (in string format).
     * @param warningMessage The warning or notification message to send.
     */
    public void notify(String date, String warningMessage) {
        for (Session session : gym.getSessions()) {
            if (session.getDate().contains(date)) {
                session.notifyObservers(warningMessage);
            }
        }
        gym.addHistoryLog("A message was sent to everyone registered for a session on " +
                CurrentDate.ReturnDateReversedNohour(date) + " : " + warningMessage);
    }

    /**
     * Sends a notification to all clients registered in the gym.
     * Each client receives the message via their inbox, and a history log is updated.
     *
     * @param message The message to send to all gym clients.
     */
    public void notify(String message) {
        List<Client> clientsList = gym.getClients();
        for (Client client : clientsList) {
            client.sendMessageInbox(message);
        }
        gym.addHistoryLog("A message was sent to all gym clients: " + message);
    }
}
