import gym.Exception.ClientNotRegisteredException;
import gym.Exception.DuplicateClientException;
import gym.Exception.InstructorNotQualifiedException;
import gym.Exception.InvalidAgeException;

import java.util.ArrayList;
import java.util.List;

public class Secretary extends Person {
    int salary;
    Gym gym;

    public Secretary(Person p, int salary) {
        super(p);
        this.salary = salary;
        this.gym = Gym.getInstance();
        gym.addHistoryLog("A new secretary has started working at the gym: " + p.getName());
    }

//    public Secretary(Secretary s, Person person){
//        s.gym =
//        this.salary = s.salary;
//        this.gym = s.gym;
//    }

    public int getSalary() {
        return salary;
    }

    protected void setSalary(int newSalary) {

        this.salary = newSalary;
    }

    /**
     * This method is used to register a client
     *
     * @param p - the person that we are registering
     * @return the new client that has been registered
     * @throws DuplicateClientException - if the client is already registered
     * @throws InvalidAgeException      - if the client is not old enough
     */
    public Client registerClient(Person p) throws DuplicateClientException, InvalidAgeException {
        Client newClient = new Client(p);
        if (gym.getClients().contains(newClient)) {
            throw new DuplicateClientException("Error: The client is already registered");
        }
        if (!newClient.isOldEnough()) {
            throw new InvalidAgeException();
        }
        gym.getClients().add(newClient);
        gym.addHistoryLog("Registered new client: " + p.getName());
        return newClient;
    }

    /**
     * This method is used to unregister a client
     *
     * @param c - the client that we are unregistering
     * @throws ClientNotRegisteredException - if the client is not registered
     */
    public void unregisterClient(Client c) throws ClientNotRegisteredException {
        if (!gym.getClients().contains(c)) {
            throw new ClientNotRegisteredException("Error: Registration is required before attempting to unregister");
        }
        gym.addHistoryLog("Unregistered client: " + c.getName());
        gym.getClients().remove(c);
    }

    public List<Client> getClient() {
        return gym.getClients();

    }


    /**
     * This method is used to hire an instructor
     *
     * @param p        - which person we are hiring
     * @param salary   - the salary for hour for the Instructur
     * @param sessions - Contains all sessions that can teach.
     * @return the new Instructor that has been hired.
     */
    public Instructor hireInstructor(Person p, int salary, ArrayList<SessionType> sessions) {
        if (p == null || sessions.isEmpty()) {
            return null;
        }
        return new Instructor(p,salary,sessions);
    }


    /**
     * This method is used to register a client to a lesson
     *
     * @param client         - the client that we are registering
     * @param currentSession - the session that we are registering the client to
     * @throws DuplicateClientException     - if the client is already registered
     * @throws ClientNotRegisteredException - if the client is not registered
     */
    public void registerClientToLesson(Client client, Session currentSession) throws DuplicateClientException, ClientNotRegisteredException {
        CurrentDate cDate = gym.currentDate;
        // check if the client is even a registered client
        if (!gym.getClients().contains(client)) {
            throw new ClientNotRegisteredException("Error: The client is not registered with the gym and cannot enroll in lessons");
        }
        // check if the client is qualified to register to the session by checking if he has enough balance, if the session has place and if he is in the right forum
        if (!currentSession.hasPlace()) {
            gym.addHistoryLog("Failed registration: No available spots for session");
            errorFlag=true;
        }
        // check if the session date is not expired
        if (cDate.isExpiredDate(currentSession.getDate())) {
            gym.addHistoryLog("Failed registration: Session is not in the future");
            errorFlag=true;
        }

        if (!currentSession.isForumCorrect(client)) {
            if (currentSession.isForumTypeGender()) {
                gym.addHistoryLog("Failed registration: Client's gender doesn't match the session's gender requirements");
                errorFlag = true;
            }
            else {
                gym.addHistoryLog("Failed registration: Client doesn't meet the age requirements for this session (" + currentSession.getForumTypeString() + ")");
                errorFlag=true;
            }
        }
        //checking if client doesn't have enough money after checking if he can fill all the requirements
        if (!currentSession.hasBalance(client)) {
            gym.addHistoryLog("Failed registration: Client doesn't have enough balance");
            errorFlag=true;
        }
        if (currentSession.isRegistered(client)) {
            throw new DuplicateClientException("Error: The client is already registered for this lesson");
        }
        if (!errorFlag){
                // add the money to gym balance
                gym.addBalance(currentSession.getPrice());
                // charge the client with the set amount of the current session
                client.chargeClient(currentSession.getPrice());
                currentSession.registerClient(client);
                gym.addHistoryLog("Registered client: " + client.getName() + " to session: " + currentSession.getSessionTypeString() + " on " + currentSession.getDateForPrinting() + " for price: " + currentSession.getPrice());

        }
    }


    public void notify(Session s4, String s) {
    }

    public void notify(String s4, String s) {
    }

    public void notify(String s) {
    }

    public void paySalaries() {
    }

    public void printActions() {
    }

    /**
     * This method is used to add a session
     *
     * @param sessionToCheck - the type of session that we are adding
     * @param dateNHour      - the date and hour of the session
     * @param forumType      - the type of forum that the session is going to be
     * @param instructor     - the instructor that is going to teach the session
     * @return the new session that has been added
     * @throws InstructorNotQualifiedException - if the instructor is not qualified to teach the session
     */
    public Session addSession(SessionType sessionToCheck, String dateNHour, ForumType forumType, Instructor instructor) throws InstructorNotQualifiedException {
        if (!instructor.isQualified(sessionToCheck)) {
            throw new InstructorNotQualifiedException();
        }
        return new Session(sessionToCheck, dateNHour,forumType,instructor);
    }
}
