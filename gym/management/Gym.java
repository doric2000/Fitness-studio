package gym.management;

import gym.customers.Client;
import gym.customers.Person;
import gym.management.Sessions.Session;

import java.util.ArrayList;
import java.util.List;
//Our singleton class
public class Gym {
    private String gymName; // The name of the gym
    Secretary secretary; // The gym's secretary
    private static Gym instance; // Singleton instance of the gym
    private List<Client> clients; // List of the gym's clients
    private List<Instructor> instructors; // List of the gym's instructors
    private int balance; // The gym's financial balance
    private List<String> historyLog; // Log of significant gym actions and events
    private List<Session> sessions; // List of all sessions held at the gym

    /**
     * Private constructor to prevent direct instantiation.
     * Initializes empty lists for clients, instructors, sessions, and history logs,
     * and sets the gym balance to zero.
     */
    private Gym() {
        clients = new ArrayList<>();
        instructors = new ArrayList<>();
        balance = 0;
        historyLog = new ArrayList<>();
        sessions = new ArrayList<>();
    }

    /**
     * Retrieves the singleton instance of the gym.management.Gym class.
     * Creates a new instance if it does not already exist.
     *
     * @return The single instance of the gym.management.Gym.
     */
    public static Gym getInstance() {
        if (instance == null) {
            instance = new Gym();
        }
        return instance;
    }

    /**
     * Sets the name of the gym.
     *
     * @param nameOfGym The name to assign to the gym.
     */
    public void setName(String nameOfGym) {
        this.gymName = nameOfGym;
    }

    /**
     * Assigns a secretary to the gym.
     * If a secretary already exists, they are unassigned before the new one is set.
     *
     * @param person The gym.customers.Person object representing the new secretary.
     * @param salary The salary for the new secretary.
     */
    public void setSecretary(Person person, int salary) {
        if (this.secretary != null) {
            this.secretary.gym = null;
        }
        secretary = new Secretary(person, salary);
    }

    /**
     * Adds a specified amount to the gym's financial balance.
     *
     * @param money The amount to add to the balance.
     */
    public void addBalance(int money) {
        balance += money;
    }

    /**
     * Logs an action or event into the gym's history log.
     *
     * @param text The text to add to the history log.
     */
    public void addHistoryLog(String text) {
        historyLog.add(text);
    }

    /**
     * Retrieves the gym's session list.
     *
     * @return A list of sessions held at the gym.
     */
    public List<Session> getSessions() {
        return sessions;
    }

    /**
     * Retrieves the gym's history log.
     *
     * @return A list of strings representing historical actions or events.
     */
    public List<String> getHistoryLog() {
        return historyLog;
    }

    /**
     * Retrieves the gym's secretary.
     *
     * @return The gym.management.Secretary assigned to the gym.
     */
    public Secretary getSecretary() {
        return this.secretary;
    }

    /**
     * Retrieves a list of all clients registered with the gym.
     *
     * @return A list of gym.customers.Client objects.
     */
    public List<Client> getClients() {
        return clients;
    }

    /**
     * Retrieves a list of all instructors working at the gym.
     *
     * @return A list of gym.management.Instructor objects.
     */
    public List<Instructor> getInstructors() {
        return instructors;
    }

    /**
     * Retrieves a list of all employees in the gym, including instructors and the secretary.
     *
     * @return A list of gym.customers.Person objects representing gym employees.
     */
    private List<Person> getEmployees() {
        List<Person> employees = new ArrayList<>(instructors);
        employees.add(getSecretary());
        return employees;
    }

    /**
     * Returns a string representation of the gym's details, including the name, secretary,
     * financial balance, clients, employees, and session data.
     *
     * @return A formatted string with all gym details.
     */
    @Override
    public String toString() {
        StringBuilder all = new StringBuilder();
        all.append("Gym Name: ").append(this.gymName).append("\n");
        all.append("Gym Secretary: ").append(this.secretary.toString()).append("\n");
        all.append("Gym Balance: ").append(this.balance).append("\n\n");

        all.append("Clients Data:\n");
        for (Client client : this.clients) {
            all.append(client.toString()).append("\n");
        }

        all.append("\nEmployees Data:\n");
        for (Person employee : this.getEmployees()) {
            all.append(employee.toString()).append("\n");
        }

        all.append("\nSessions Data:\n");
        for (int i = 0; i < this.sessions.size(); i++) {
            if (i == this.sessions.size() - 1) {
                all.append(sessions.get(i).toString());
            } else {
                all.append(sessions.get(i).toString()).append("\n");
            }
        }
        return all.toString();
    }
}