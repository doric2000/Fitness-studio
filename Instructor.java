import java.util.ArrayList;

public class Instructor extends Person {
    ArrayList <SessionType> qualifiedSessions;
    int salaryPerHour;


    public Instructor(Person p, int salaryPerHour, ArrayList<SessionType> Sessions) {
        super(p);
        this.salaryPerHour = salaryPerHour;
        this.qualifiedSessions = Sessions;
    }

    public Instructor(Person p) {
        super(p);
    }

    public boolean isQualified(SessionType session)
    {
        return qualifiedSessions.contains(session);
    }
}
