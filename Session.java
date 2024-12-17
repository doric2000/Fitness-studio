import java.util.List;

public interface Session {
        public String getForumTypeString();
        public int getPrice();
        public Instructor getInstructor();
        public String getSessionTypeString();
        public String getDate();
        public String getDateString();
        public void registerClient(Client client);
        public List<Client> getRegisteredClients();
        public boolean isRegistered(Client client);
        // check if the session has enough place to register a new client
        public boolean hasPlace();
        // check if the client has enough balance after subtracting the price of the session
        public boolean hasBalance(Client client);
        // check if the client is in the right forum
        public boolean isForumCorrect(Client client);
        public boolean isForumTypeGender();
        public void registerObserver (Observer o);
        public void removeObserver (Observer o);
        public void notifyObservers(String message);
    }



