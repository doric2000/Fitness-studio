package gym.management;

import gym.customers.Person;
import gym.management.Sessions.SessionType;

import java.util.ArrayList;

/**
 * The gym.management.Instructor class represents a gym instructor, extending the gym.customers.Person class.
 * It includes details about the instructor's salary, the sessions they are qualified to teach,
 * and methods to manage payments and qualifications.
 */
public class Instructor extends Person {
    private ArrayList<SessionType> qualifiedSessions; // List of sessions the instructor is qualified to teach
    private int salaryPerHour; // The instructor's salary per hour

    /**
     * Constructs an gym.management.Instructor with a gym.customers.Person's details, hourly salary, and a list of qualified sessions.
     *
     * @param p              The gym.customers.Person object containing the instructor's basic details.
     * @param salaryPerHour  The salary per hour for the instructor.
     * @param Sessions       A list of SessionTypes the instructor is certified to teach.
     */
    public Instructor(Person p, int salaryPerHour, ArrayList<SessionType> Sessions) {
        super(p);
        this.salaryPerHour = salaryPerHour;
        this.qualifiedSessions = Sessions;
    }

    /**
     * Constructs a new gym.management.Instructor as a copy of an existing gym.management.Instructor.
     *
     * @param instructor The gym.management.Instructor object to copy.
     */
    public Instructor(Instructor instructor) {
        super(instructor);
        this.salaryPerHour = instructor.salaryPerHour;
        this.qualifiedSessions = instructor.qualifiedSessions;
    }

    /**
     * Constructs an gym.management.Instructor using a gym.customers.Person object without additional details.
     *
     * @param p The gym.customers.Person object containing the instructor's basic details.
     */
    public Instructor(Person p) {
        super(p);
    }

    /**
     * Retrieves the instructor's salary per hour.
     *
     * @return The instructor's salary per hour.
     */
    public int getSalaryPerHour() {
        return salaryPerHour;
    }

    /**
     * Checks if the instructor is qualified to teach a specific session type.
     *
     * @param session The gym.management.Sessions.SessionType to check.
     * @return True if the instructor is qualified to teach the session, false otherwise.
     */
    public boolean isQualified(SessionType session) {
        return qualifiedSessions.contains(session);
    }

    /**
     * Returns a string representation of the instructor's details, including their salary,
     * qualified classes, and personal information.
     *
     * @return A formatted string containing the instructor's details.
     */
    @Override
    public String toString() {
        return super.toString() +
                " | Role: Instructor | Salary per Hour: " + this.salaryPerHour +
                " | Certified Classes: " + qualifiedSessions.toString().replace("[", "").replace("]", "");
    }
}