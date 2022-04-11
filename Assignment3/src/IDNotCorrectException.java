public class IDNotCorrectException extends Exception{
    public IDNotCorrectException(int counter){
        super("Sender ID does not consists of 11 digits in line " + counter + ".");
    }
}