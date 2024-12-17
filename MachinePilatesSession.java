import java.util.ArrayList;
import java.util.List;

public class MachinePilatesSession implements Session{
    private final int PRICE =80;
    private final int MAX_PARTICIPANTS = 10;
    private SessionType sType;
    private String date;
    private ForumType fType;
    private Instructor instructor;
    private List<Client> registeredClients;
    private ForumTypeStrategy fTypeStrategy;
    private List<Observer> observers;


    public MachinePilatesSession(String date, ForumType fType, Instructor instructor) {
        this.sType=SessionType.MachinePilates;
        this.date = date;
        this.fType = fType;
        this.instructor = instructor;
        registeredClients = new ArrayList<Client>();
        fTypeStrategy = fType.getStrategy();
        observers  = new ArrayList<>();
    }


    public String getForumTypeString(){
        return fType.name();
    }

    public int getPrice(){
        return PRICE;
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

    public String getDateString(){
        // create a date instance
        // reformat date string to YYYY-MM-DDTHH:MM
        return CurrentDate.YearMonthDateHHmm(this.getDate()).replace(" ", "T");
    }

    public void registerClient(Client client) {
        observers.add(client);
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
        return (MAX_PARTICIPANTS > registeredClients.size());
    }

    // check if the client has enough balance after subtracting the price of the session
    public boolean hasBalance(Client client) {
        return (client.getBalance() - PRICE > 0);
    }

    // check if the client is in the right forum
    public boolean isForumCorrect(Client client) {
        return fTypeStrategy.checkFType(client);
    }
    public boolean isForumTypeGender()
    {
        return (fType.equals(ForumType.Male) || fType.equals(ForumType.Female));
    }

    public void registerObserver (Observer o) {
        observers.add(o);
    }

    public void removeObserver (Observer o) {
        observers.remove(o);
    }

    public void notifyObservers(String message)
    {
        for (Observer observer : observers)
        {
            observer.update(message);
        }
    }

    @Override
    public String toString() {
        return "Session Type: " + this.sType.name() +" | Date: " + this.date + " | Forum: " + this.fType.name() + " | Instructor: " + this.instructor.getName() + " | Participants: " + this.registeredClients.size() + "/" + MAX_PARTICIPANTS;

    }



}
