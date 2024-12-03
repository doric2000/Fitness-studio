package gym.Exception;

public class DuplicateClientException extends Exception {
    public DuplicateClientException() {
        System.out.println("This Client already exists.");
    }
}
