import gym.Exception.ClientNotRegisteredException;
import gym.Exception.DuplicateClientException;
import gym.Exception.InstructorNotQualifiedException;
import gym.Exception.InvalidAgeException;

import java.util.ArrayList;
import java.util.List;

public class Secretary extends Person {
    int salary;
    Gym gym;

    public Secretary(Person p,int salary){
        super(p);
        this.salary = salary;
        this.gym=Gym.getInstance();
    }

    public int getSalary() {

        return salary;
    }
    protected void setSalary(int newSalary) {

        this.salary= newSalary;
    }

    public Client registerClient(Person p)  throws DuplicateClientException, InvalidAgeException {
        Client newClient = new Client(p);
        if (gym.getClients().contains(newClient))
        {
            throw new DuplicateClientException();
        }
        if (!newClient.isOldEnough())
        {
            throw new InvalidAgeException();
        }
                gym.getClients().add(newClient);
                return newClient;
    }

    public List<Client> getClient(){
        return gym.getClients();

    }
    public void unregisterClient(Client c) throws ClientNotRegisteredException {
        if (!gym.getClients().contains(c))
        {
            throw new ClientNotRegisteredException();
        }
        gym.getClients().remove(c);
    }

    /**
     *
     * @param p - which person we are hiring
     * @param salary - the salary for hour for the Instructur
     * @param sessions - Contains all sessions that can teach.
     * @return the new Instructor that has been hired.
     */
    public Instructor hireInstructor(Person p, int salary, ArrayList<SessionType> sessions)  {
        if (p == null || sessions.isEmpty())
        {
            return null;
        }
        return new Instructor(p,salary,sessions);
    }

    public void registerClientToLesson(Client client, Session currentSession) throws DuplicateClientException , ClientNotRegisteredException{
        if (currentSession.hasPlace() && currentSession.hasBalance(client) && currentSession.currectForum(client)){

        }

    }

    public void notify(Session s4, String s) {
    }
    public void notify(String s4, String s) {
    }
    public void notify( String s) {
    }

    public void paySalaries() {
    }

    public void printActions() {
    }

    public Session addSession(SessionType sessionToCheck, String datenhour, ForumType forumType, Instructor instructor) throws InstructorNotQualifiedException {
        if (!instructor.isQualified(sessionToCheck)) {
            throw new InstructorNotQualifiedException();
        }
        return new Session(sessionToCheck,datenhour,forumType,instructor);
    }
}
