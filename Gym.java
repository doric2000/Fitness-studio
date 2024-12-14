import java.util.ArrayList;
import java.util.List;

public class Gym {
    String gymName; // the Name of our gym
    Secretary secretary; // Gym's secretary
    private static Gym instance; // Working with the Singleton principle to make sure that we have only one instance.
    private List<Client> clients; // A list of the gym clients.
    private List<Instructor> instructors;
    private int balance; // gym balance , will be initialized to 0. The secretary salary will not affect the balance.
    protected CurrentDate currentDate; // the current date of the gym
    private List<String> historyLog;

    private List<Session> sessions;

    private Gym() {
        clients = new ArrayList<>();
        instructors = new ArrayList<>();
        balance = 0;
        currentDate = CurrentDate.getInstance();
        historyLog = new ArrayList<>();
        sessions = new ArrayList<>();
    }

    public void addBalance(int money) {
        balance += money;
    }

    public List<Session> getSessions()
    {
        return sessions;
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
        secretary = PersonFactory.createSecretary(person,salary);
    }

    public void addHistoryLog(String text){
        historyLog.add(text);
    }

    public List<String> getHistoryLog(){
        return historyLog;
    }

    public Secretary getSecretary() {
        return this.secretary;
    }

    public List<Client> getClients() {
        return clients;
    }
    public List<Instructor> getInstructors(){return  instructors;}

    private List<Person> getEmployees(){
        List<Person> employees = new ArrayList<>(instructors);
        employees.add(getSecretary());
        return employees;
    }

    @Override
    public String toString() {
        StringBuilder all= new StringBuilder();
        all.append("Gym Name: " + this.gymName + "\n");
        all.append("Gym Secretary: " + this.secretary.toString() + "\n");
        all.append("Gym Balance: " + this.balance + "\n");
        all.append("\n");
        all.append("Clients Data:" + "\n");
        for (int i = 0; i < this.clients.size(); i++) {
            all.append(clients.get(i).toString()).append("\n");
        }
        all.append("\n");
        all.append("Employees Data:" + "\n");
        for (int i = 0; i < this.getEmployees().size(); i++) {
            all.append(getEmployees().get(i).toString()).append("\n");
        }
        all.append("\n");
        all.append("Sessions Data:" + "\n");
        for (int i = 0; i < this.sessions.size(); i++) {
            if (i == this.sessions.size()-1 )
                all.append(sessions.get(i).toString());
            else {
                all.append(sessions.get(i).toString()).append("\n");
            }

        }



        return all.toString();
    }


}
