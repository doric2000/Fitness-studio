import java.util.List;

public class Session {
    private SessionType sType;
    private String date;
    private ForumType fType;
    private Instructor instructor;
    private List<Client> registeredClients;

    public Session(SessionType sType,String date, ForumType fType,Instructor instructor)
    {
        this.sType = sType;
        this.date = date;
        this.fType = fType;
        this.instructor= instructor;
    }

    public boolean hasPlace()
    {
       return (this.sType.getMaxParticipants() > registeredClients.size());
    }

    public boolean hasBalance(Client client)
    {
        return (client.getBalance()-sType.getPrice()>0);
    }


    public boolean currectForum(Client client) {
        return (client.g)
    }
}

