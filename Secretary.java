import gym.Exception.ClientNotRegisteredException;
import gym.Exception.DuplicateClientException;
import gym.Exception.InstructorNotQualifiedException;
import gym.Exception.InvalidAgeException;

import java.util.ArrayList;
import java.util.List;

/**
 * The Secretary class represents a staff member responsible for managing clients, instructors,
 * sessions, and other gym operations.
 * It extends the Person class and interacts with the Gym singleton instance.
 */
public class Secretary extends Person {
    private int salary;
    protected Gym gym;
    private Person person;
    private NotificationService notificationService;

    private SessionFactory sessionFactory;

    /**
     * Constructs a new Secretary with a given person object and salary.
     *
     * @param p      The Person object representing the secretary.
     * @param salary The monthly salary of the secretary.
     */
    public Secretary(Person p, int salary) {
        super(p);
        this.person=p;
        this.salary = salary;
        this.gym = Gym.getInstance();
        this.notificationService = new NotificationService(this.gym);
        this.sessionFactory = new SessionFactory();
        gym.addHistoryLog("A new secretary has started working at the gym: " + p.getName());
    }

    /**
     * Registers a client in the gym system.
     *
     * @param p The person to be registered as a client.
     * @return A newly registered Client object.
     * @throws DuplicateClientException If the client is already registered.
     * @throws InvalidAgeException      If the client does not meet the age requirement.
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
     * Unregisters a client from the gym system.
     *
     * @param c The Client to be unregistered.
     * @throws ClientNotRegisteredException If the client is not registered.
     */
    public void unregisterClient(Client c) throws ClientNotRegisteredException {
        if (!gym.getClients().contains(c)) {
            throw new ClientNotRegisteredException("Error: Registration is required before attempting to unregister");
        }
        gym.addHistoryLog("Unregistered client: " + c.getName());
        gym.getClients().remove(c);
    }

    /**
     * Retrieves a list of all registered clients.
     *
     * @return A List of Client objects.
     */
    public List<Client> getClient() {
        return gym.getClients();
    }


    /**
     * Hires a new instructor with a given salary and session types they can teach.
     *
     * @param p        The Person to be hired as an instructor.
     * @param salary   The salary per hour for the instructor.
     * @param sessions A list of SessionTypes the instructor is qualified to teach.
     * @return A newly hired Instructor object.
     */
    public Instructor hireInstructor(Person p, int salary, ArrayList<SessionType> sessions) {
        if (p == null || sessions.isEmpty()) {
            return null;
        }
        gym.addHistoryLog("Hired new instructor: " + p.getName() + " with salary per hour: " + salary);
        Instructor newInstructor = new Instructor(p,salary, sessions);
        gym.getInstructors().add(newInstructor);
        return newInstructor;
    }


    /**
     * Registers a client to a lesson if all criteria are met.
     *
     * @param client         The Client to register.
     * @param currentSession The Session the client will be registered to.
     * @throws DuplicateClientException     If the client is already registered for the session.
     * @throws ClientNotRegisteredException If the client is not registered in the gym system.
     */
    public void registerClientToLesson(Client client, Session currentSession) throws DuplicateClientException, ClientNotRegisteredException {
        boolean errorFlag = false;

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
        if (CurrentDate.isExpiredDate(currentSession.getDate())) {
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
                gym.addHistoryLog("Registered client: " + client.getName() + " to session: " + currentSession.getSessionTypeString() + " on " + currentSession.getDateString() + " for price: " + currentSession.getPrice());

        }
    }

    /**
     * Sends a notification related to a session.
     *
     * @param session The Session associated with the notification.
     * @param message The notification message.
     */
    public void notify(Session session, String message) {
        notificationService.notify(session,message);
    }

    /**
     * Sends a notification for a specific date.
     *
     * @param date          The date of the notification.
     * @param warningMessage The message to be sent.
     */
    public void notify(String date, String warningMessage) {
        notificationService.notify(date,warningMessage);

    }
    /**
     * Sends a generic notification.
     *
     * @param message The notification message.
     */
    public void notify(String message) {
        notificationService.notify(message);
    }

    /**
     * Pays salaries to the secretary and all instructors for their sessions.
     */
    public void paySalaries() {
        this.addToBalance(this.salary);
        gym.addBalance(-this.salary);
        List<Session> allSessions = gym.getSessions();
        for (Session s : allSessions) {
            s.getInstructor().addToBalance(s.getInstructor().getSalaryPerHour());
            gym.addBalance(-s.getInstructor().getSalaryPerHour());
        }
        gym.addHistoryLog("Salaries have been paid to all employees");
    }

    /**
     * Prints all historical actions and logs.
     */
    public void printActions() {
        List<String> actionsLog = gym.getHistoryLog();
        for (String str : actionsLog) {
            System.out.println(str);
        }
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
        String dateNHour2 = CurrentDate.YearMonthDateHHmm(dateNHour).replace(" ", "T");
        if (!instructor.isQualified(sessionToCheck)) {
            throw new InstructorNotQualifiedException();
        }
        gym.addHistoryLog("Created new session: " + sessionToCheck.name() + " on " + dateNHour2 + " with instructor: " + instructor.getName());
        // here we will have to implement our Factory

        Session newSession = sessionFactory.createSession(sessionToCheck,dateNHour,forumType,instructor);
        gym.getSessions().add(newSession);
        return newSession;
    }

    @Override
    public String toString() {
        return super.toString() + " | Role: Secretary | Salary per Month: "+this.salary;
    }
}
