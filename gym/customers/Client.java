package gym.customers;

import gym.management.Observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Client extends Person implements Observer {
    private List<String> messageInbox; // Inbox to store received messages

    /**
     * Constructs a new gym.customers.Client using a gym.customers.Person object.
     *
     * @param person The gym.customers.Person object containing basic client information.
     */
    public Client(Person person) {
        super(person);
        messageInbox = new ArrayList<>();
    }

    /**
     * Retrieves all notifications/messages in the client's inbox as a formatted string.
     *
     * @return A StringBuilder containing all messages in the inbox, formatted as a list.
     */
    public StringBuilder getNotifications() {
        StringBuilder allMessages = new StringBuilder();
        allMessages.append("[");
        for (int i = 0; i < messageInbox.size(); i++) {
            if (messageInbox.get(i) != null) { // Check if the current element is not null
                allMessages.append(messageInbox.get(i));
                // Append a comma and space unless it's the last element
                if (i < messageInbox.size() - 1) {
                    allMessages.append(", ");
                }
            }
        }
        allMessages.append("]");
        return allMessages;
    }

    /**
     * Charges the client by deducting a specified amount from their balance.
     *
     * @param money The amount to deduct from the client's balance.
     */
    public void chargeClient(int money) {
        this.addToBalance(-money);
    }

    /**
     * Sends a message to the client's inbox.
     *
     * @param message The message to be added to the inbox.
     */
    public void sendMessageInbox(String message) {
        this.messageInbox.add(message);
    }

    /**
     * Updates the client with a new notification message.
     * This method is called when the client is notified as an gym.management.Observer.
     *
     * @param message The message to add to the client's inbox.
     */
    @Override
    public void update(String message) {
        this.messageInbox.add(message);
    }

    /**
     * Checks equality between this client and another object.
     * Two clients are considered equal if they have the same balance, name, and birth date.
     *
     * @param o The object to compare against.
     * @return True if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return this.getBalance() == client.getBalance() &&
                Objects.equals(this.getName(), client.getName()) &&
                Objects.equals(this.getBirthDate(), client.getBirthDate());
    }
}
