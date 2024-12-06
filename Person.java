import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Person {
    private String name;
    private Gender gender;
    private String birthDate;
    private int id=1111;
    private static int counter =0;
    private Balance balance;


    public Person(String name, int balance, Gender g , String birthDate)
    {
        this.name=name;
        this.balance = new Balance(balance);
        this.gender = g;
        this.birthDate= birthDate;
        this.id = id + counter;
        counter++;
    }
    public Person(Person p)
    {
        this.name = p.name;
        this.gender = p.gender;
        this.birthDate = p.birthDate;
        this.balance = p.balance;
        this.id = p.id;
    }

    public int getBalance() {
        return this.balance.getAmount();
    }

    protected void addToBalance(int balance){
        this.balance.addAmount(balance);
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
        return (today.getYear()-birthDate.getYear());
    }

    public StringBuilder getNotifications() {
        return null;

    }

    @Override
    public String toString() {
        return "ID: " + this.id +" | Name: " + this.name + " | Gender: " + this.getGender() + " | Birthday: " + this.birthDate + " | Age: " + this.getAge() + " | Balance: " + this.getBalance();

    }
}