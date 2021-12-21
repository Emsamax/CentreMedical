public class PatientInexistantException extends RuntimeException{
    public PatientInexistantException() {
    }
    public PatientInexistantException(String message) {
    super(message);
    }
    public String getMessage() {
    return super.getMessage();
    }  
}
