// NotificationService.java
import java.util.List;

public class NotificationService {
    private Gym gym;

    public NotificationService(Gym gym) {
        this.gym = gym;
    }

    public void notify(Session session, String message) {
        session.notifyObservers(message);
        gym.addHistoryLog("A message was sent to everyone registered for session " + session.getSessionTypeString() + " on " + session.getDateString() + " : " + message);
    }

    public void notify(String date, String warningMessage) {
        for (Session session : gym.getSessions()) {
            if (session.getDate().contains(date)) {
                session.notifyObservers(warningMessage);
            }
        }
        gym.addHistoryLog("A message was sent to everyone registered for a session on " + CurrentDate.ReturnDateReversedNohour(date) + " : " + warningMessage);
    }

    public void notify(String message) {
        List<Client> clientsList = gym.getClients();
        for (Client i : clientsList )
        {
            i.sendMessageInbox(message);
        }
        gym.addHistoryLog("A message was sent to all gym clients: " + message);
    }
}