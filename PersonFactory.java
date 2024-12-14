import java.util.ArrayList;

import java.util.ArrayList;

public class PersonFactory {

    public static Client createClient(Person person) {
        return new Client(new Person(person));
    }

    public static Instructor createInstructor(Person person, int salaryPerHour, ArrayList<SessionType> sessions) {
        return new Instructor(new Person(person), salaryPerHour, sessions);
    }

    public static Secretary createSecretary(Person person, int salary) {
        return new Secretary(new Person(person), salary);
    }
}