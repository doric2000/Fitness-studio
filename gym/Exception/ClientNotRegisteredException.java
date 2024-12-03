package gym.Exception;

public class ClientNotRegisteredException extends Exception {
    public ClientNotRegisteredException() {
        System.out.println("This client is not registered to this gym");
    }
}
