import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.Period;


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

        return CurrentDate.getAge(this.birthDate);
    }

    public StringBuilder getNotifications() {
        return null;

    }

    @Override
    public String toString() {
        return "ID: " + this.id +" | Name: " + this.name + " | Gender: " + this.getGender() + " | Birthday: " + this.birthDate + " | Age: " + this.getAge() + " | Balance: " + this.getBalance();

    }
}