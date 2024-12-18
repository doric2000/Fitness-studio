package gym.management.Sessions;

import gym.customers.Client;

/**
 * The gym.management.Sessions.ForumTypeStrategy interface represents a strategy for validating whether a client
 * meets the requirements of a specific forum type.
 * It follows the Strategy design pattern, allowing different forum types
 * (e.g., age-based, gender-based) to define their own validation logic.
 */
public interface ForumTypeStrategy {

    /**
     * Checks if the given client meets the requirements of the forum type.
     *
     * @param client The gym.customers.Client object to validate.
     * @return True if the client meets the forum type requirements, false otherwise.
     */
    public boolean checkFType(Client client);
}
