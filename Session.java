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

    public Session(Session session){
        this.sType = session.sType;
        this.date = session.date;
        this.fType =  session.fType;
        this.instructor = session.instructor;
    }

    public String getForumTypeString(){
        return fType.name();
    }

    public int getPrice(){
        return sType.getPrice();
    }

    public Instructor getInstructor(){
        return this.instructor;
    }

    public String getSessionTypeString(){

        return sType.name();
    }
    public String getDate(){
        return this.date;
    }

    public String getDateForPrinting(){
        // create a date instance
        CurrentDate dateFormatter = CurrentDate.getInstance();
        // reformat date string to YYYY-MM-DDTHH:MM
        return dateFormatter.YearMonthDateHHmm(this.getDate()).replace(" ", "T");
    }

    public void registerClient(Client client) {

        registeredClients.add(client);
    }
    public List<Client> getRegisteredClients()
    {
        return registeredClients;
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

    @Override
    public String toString() {
        return "Session Type: " + this.sType.name() +" | Date: " + this.date + " | Forum: " + this.fType.name() + " | Instructor: " + this.instructor.getName() + " | Participants: " + this.registeredClients.size() + "/" + this.sType.getMaxParticipants();

    }
}

