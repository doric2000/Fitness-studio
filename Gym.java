import java.util.ArrayList;
import java.util.List;

public class Gym {
    String gymName;
    Secretary secretary;
    private static Gym instance;
    private List<Client> clients;

    private List<Session> Sessions;

    private Gym() {
        clients = new ArrayList<Client>();

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
        secretary = new Secretary(person,salary);
    }

    public Secretary getSecretary() {
        return this.secretary;
    }

    public List<Client> getClients() {
        return clients;
    }
}
