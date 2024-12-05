import java.util.Objects;

public class Client extends Person{


    public Client(Person person) {
        super(person);
    }


    public String getNotifications() {
        return null;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return this.getBalance() == client.getBalance() && Objects.equals(this.getName(), client.getName()) && Objects.equals(this.getBirthDate(), client.getBirthDate());
    }

}