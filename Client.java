import java.util.Objects;


public class Client extends Person {


    public Client(Person person) {
        super(person);
    }


    public StringBuilder getNotifications() {
        StringBuilder allMessages= new StringBuilder();
        allMessages.append("[");
        for (int i = 0; i < messageInbox.size(); i++) {
            if (messageInbox.get(i) != null) { // Check if current element is not null
                allMessages.append(messageInbox.get(i));
                // Only append a ,+space if it's not the last element
                if (i < messageInbox.size() - 1) {
                    allMessages.append(", ");
                }
            }
        }
        allMessages.append("]");
        return allMessages;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return this.getBalance() == client.getBalance() && Objects.equals(this.getName(), client.getName()) && Objects.equals(this.getBirthDate(), client.getBirthDate());
    }

}