import java.util.ArrayList;

public class Instructor extends Person {
    private ArrayList <SessionType> qualifiedSessions;
    private int salaryPerHour;



    public Instructor(Person p, int salaryPerHour, ArrayList<SessionType> Sessions) {
        super(p);
        this.salaryPerHour = salaryPerHour;
        this.qualifiedSessions = Sessions;
    }

    public Instructor(Instructor instructor){
        super(instructor);
        this.salaryPerHour = instructor.salaryPerHour;
        this.qualifiedSessions = instructor.qualifiedSessions;
    }

    public Instructor(Person p) {
        super(p);
    }

    public void payInstructor(){
        this.addToBalance(salaryPerHour);
    }

    public int getSalaryPerHour() {
        return salaryPerHour;
    }

    public boolean isQualified(SessionType session)
    {
        return qualifiedSessions.contains(session);
    }

    @Override
    public String toString() {
        return super.toString() + " | Role: Instructor | Salary per Hour: "+this.salaryPerHour+ " | Certified Classes: "+qualifiedSessions.toString().replace("[","").replace("]","");
    }
}
