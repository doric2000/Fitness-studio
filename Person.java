import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Person {
    private String name;
    private int balance;
    private Gender gender;
    private String birthDate;

    public Person(String name, int balance, Gender g , String birthDate)
    {
        this.name=name;
        this.balance = balance;
        this.gender = g;
        this.birthDate= birthDate;
    }
    public Person(Person p)
    {
        this.name = p.name;
        this.gender = p.gender;
        this.birthDate = p.birthDate;
        this.balance = p.balance;
    }

    public int getBalance() {
        return balance;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public Gender getGender() {
        return gender;
    }

    public String getName() {
        return name;
    }

    public Boolean isOldEnough()
    {
        return this.getAge() >= 18;

    }

    public int getAge(){
        // Define the date format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        // Parse the birthdate string into a LocalDate
        LocalDate birthDate = LocalDate.parse(this.birthDate, formatter);

        // Get today's date
        LocalDate today = LocalDate.now();

        // Calculate the age
        return (int)ChronoUnit.YEARS.between(birthDate, today);
    }

    public String getNotifications() {
        return "die bitch";
    }
}