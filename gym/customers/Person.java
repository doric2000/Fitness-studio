package gym.customers;

import gym.Balance;
import gym.CurrentDate;

public class Person {
    private String name;
    private Gender gender;
    private String birthDate; // Date of birth in string format
    private int id = 1111; // Unique identifier for each person
    private static int counter = 0; // Counter to ensure unique IDs
    private Balance balance; // gym.Balance object to manage financial operations

    /**
     * Constructs a new gym.customers.Person with the specified name, initial balance, gender, and birth date.
     *
     * @param name      The name of the person.
     * @param balance   The initial balance for the person.
     * @param g         The gender of the person.
     * @param birthDate The birth date of the person in string format.
     */
    public Person(String name, int balance, Gender g, String birthDate) {
        this.name = name;
        this.balance = new Balance(balance);
        this.gender = g;
        this.birthDate = birthDate;
        this.id = id + counter; // Assigns a unique ID
        counter++;
    }

    /**
     * Constructs a new gym.customers.Person as a copy of another gym.customers.Person.
     *
     * @param p The gym.customers.Person object to copy.
     */
    public Person(Person p) {
        this.name = p.name;
        this.gender = p.gender;
        this.birthDate = p.birthDate;
        this.balance = p.balance;
        this.id = p.id;
    }

    /**
     * Retrieves the person's balance.
     *
     * @return The current balance as an integer.
     */
    public int getBalance() {
        return this.balance.getAmount();
    }

    /**
     * Adds a specified amount to the person's balance.
     *
     * @param balance The amount to add.
     */
    public void addToBalance(int balance) {
        this.balance.addAmount(balance);
    }

    /**
     * Retrieves the birth date of the person.
     *
     * @return The birth date as a string.
     */
    public String getBirthDate() {
        return birthDate;
    }

    /**
     * Retrieves the gender of the person.
     *
     * @return The gym.customers.Gender enumeration value representing the person's gender.
     */
    public Gender getGender() {
        return gender;
    }

    /**
     * Retrieves the name of the person.
     *
     * @return The person's name as a string.
     */
    public String getName() {
        return name;
    }

    /**
     * Checks if the person is 18 years old or older.
     *
     * @return True if the person is old enough (18 or older), false otherwise.
     */
    public Boolean isOldEnough() {
        return this.getAge() >= 18;
    }

    /**
     * Calculates the person's age based on their birthdate.
     *
     * @return The age of the person as an integer.
     */
    public int getAge() {
        return CurrentDate.getAge(this.birthDate);
    }

    /**
     * Placeholder for retrieving notifications for the person, but , because a person is not a subscriber of the gym it will return null.
     *
     * @return A StringBuilder object representing notifications.
     */
    public StringBuilder getNotifications() {
        return null;
    }

    /**
     * Returns a string representation of the person's details, including ID, name,
     * gender, birthdate, age, and balance.
     *
     * @return A formatted string containing the person's details.
     */
    @Override
    public String toString() {
        return "ID: " + this.id +
                " | Name: " + this.name +
                " | Gender: " + this.getGender() +
                " | Birthday: " + this.birthDate +
                " | Age: " + this.getAge() +
                " | Balance: " + this.getBalance();
    }
}
