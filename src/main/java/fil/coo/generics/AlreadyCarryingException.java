package fil.coo.generics;

public class AlreadyCarryingException extends RuntimeException {

    public AlreadyCarryingException(String message) {
        super(message + " porte déja quelque chose");
    }
}
