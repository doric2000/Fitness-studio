import java.util.ArrayList;
import java.util.List;

public class Session {
    private SessionType sType;
    private String date;
    private ForumType fType;
    private Instructor instructor;
    private List<Client> registeredClients;
    private ForumTypeStrategy fTypeStrategy;

    public Session(SessionType sType, String date, ForumType fType, Instructor instructor) {
        this.sType = sType;
        this.date = date;
        this.fType = fType;
        this.instructor = instructor;
        registeredClients = new ArrayList<Client>();
        fTypeStrategy = fType.getStrategy();
    }

    public String getDate(){
        return this.date;
    }

    public void registerClient(Client client) {
        registeredClients.add(client);
    }
    public boolean isRegistered(Client client) {
        return registeredClients.contains(client);
    }

    // check if the session has enough place to register a new client
    public boolean hasPlace() {
        return (this.sType.getMaxParticipants() > registeredClients.size());
    }

    // check if the client has enough balance after subtracting the price of the session
    public boolean hasBalance(Client client) {
        return (client.getBalance() - sType.getPrice() > 0);
    }

    // check if the client is in the right forum
    public boolean isForumCorrect(Client client) {
        return fTypeStrategy.checkFType(client);
    }
    public boolean isForumTypeGender()
    {
       return (fType.equals(ForumType.Male) || fType.equals(ForumType.Female));
    }
}

