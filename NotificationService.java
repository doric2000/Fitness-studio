import java.util.ArrayList;

public class NotificationService {
    private ArrayList<EventListener> observers;
    public NotificationService(){
        observers = new ArrayList<>();
    }

    public void subscribe(EventListener o){
        observers.add(o);
    }

    public void unsubscribe(EventListener o){
        observers.remove(o);
    }

    public void notifyObservers(String message){
        for (EventListener listener : observers){
            listener.update(message);
        }
    }
}
