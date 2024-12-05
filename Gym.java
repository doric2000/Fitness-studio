import java.util.ArrayList;
import java.util.List;

public class Gym {
    String gymName; // the Name of our gym
    Secretary secretary; // Gym's secretary
    private static Gym instance; // Working with the Singleton principle to make sure that we have only one instance.
    private List<Client> clients; // A list of the gym clients.
    private int balance; // gym balance , will be initialized to 0.
    protected CurrentDate currentDate; // the current date of the gym

    private List<Session> Sessions;

    private Gym() {
        clients = new ArrayList<Client>();
        balance=0;
        currentDate = CurrentDate.getInstance();
    }

    public static Gym getInstance() {
        if (instance == null) {
            instance = new Gym();
        }
        return instance;
    }
    public void setName(String nameOfGym) {
        this.gymName=nameOfGym;
    }

    public void setSecretary(Person person, int salary) {
        if (this.secretary != null) {
            this.secretary.gym = null;
        }
            secretary = new Secretary(person, salary);

    }

    public Secretary getSecretary() {
        return this.secretary;
    }

    public List<Client> getClients() {
        return clients;
    }
}
