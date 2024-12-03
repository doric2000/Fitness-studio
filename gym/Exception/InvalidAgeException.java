package gym.Exception;

public class InvalidAgeException extends Exception {
    public InvalidAgeException() {
        System.out.println("This client is too young to subscribe to this gym");
    }
}
