public class InvalidInputException extends Throwable {

    public void invalidInput(String input){
        System.out.println("Please enter valid " + input);
    }

}
