package gym.management.Sessions;

import gym.customers.Client;
import gym.management.Instructor;

public interface Session {

        /**
         * Retrieves the forum type of the session as a string.
         * The forum type determines restrictions such as gender or age group.
         *
         * @return A string representing the forum type.
         */
        public String getForumTypeString();

        /**
         * Retrieves the price of the session.
         *
         * @return The cost of the session as an integer.
         */
        public int getPrice();

        /**
         * Retrieves the instructor leading the session.
         *
         * @return An gym.management.Instructor object representing the session's instructor.
         */
        public Instructor getInstructor();

        /**
         * Retrieves the session type as a string.
         * Example session types: ThaiBoxing, Ninja, Pilates, etc.
         *
         * @return A string representing the session type.
         */
        public String getSessionTypeString();

        /**
         * Retrieves the date of the session in its raw format.
         *
         * @return A string representing the date of the session.
         */
        public String getDate();

        /**
         * Retrieves the session date formatted as "YYYY-MM-DDTHH:MM".
         *
         * @return A formatted string representing the session date.
         */
        public String getDateString();

        /**
         * Registers a client to the session.
         *
         * @param client The gym.customers.Client object to be registered.
         */
        public void registerClient(Client client);

        /**
         * Checks if a given client is already registered for the session.
         *
         * @param client The gym.customers.Client to check.
         * @return True if the client is registered, false otherwise.
         */
        public boolean isRegistered(Client client);

        /**
         * Checks if the session has available spots for new clients.
         *
         * @return True if there are available spots, false otherwise.
         */
        public boolean hasPlace();

        /**
         * Checks if a client has sufficient balance to pay for the session.
         *
         * @param client The gym.customers.Client whose balance is checked.
         * @return True if the client has enough balance, false otherwise.
         */
        public boolean hasBalance(Client client);

        /**
         * Checks if a client meets the forum type requirements for the session.
         * Example: gender-based or age-based restrictions.
         *
         * @param client The gym.customers.Client to validate.
         * @return True if the client meets the forum requirements, false otherwise.
         */
        public boolean isForumCorrect(Client client);

        /**
         * Determines if the session's forum type is based on gender (e.g., Male, Female).
         *
         * @return True if the forum type is gender-based, false otherwise.
         */
        public boolean isForumTypeGender();

        /**
         * Notifies all registered observers with a given message.
         *
         * @param message The message to send to observers.
         */
        public void notifyObservers(String message);
}