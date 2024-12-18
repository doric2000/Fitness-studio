package gym.management.Sessions;

import gym.customers.Client;
import gym.customers.Gender;

public class MaleForumType implements ForumTypeStrategy {

    /**
     * Checks if the given client meets the "Male" forum type requirement.
     * A client qualifies if their gender is Male.
     *
     * @param client The gym.customers.Client object to validate.
     * @return True if the client's gender is Male, false otherwise.
     */
    @Override
    public boolean checkFType(Client client) {
        return (client.getGender() == Gender.Male);
    }
}