/**
 * This class is an exception use to see if the queue is empty
 *
 * @author Ishabul Haque
 **/

class InvalidInputException extends Throwable {

    public InvalidInputException(){

    }

    public void invalidProbability(){
        System.out.println("Probability must be between 0.0 and 1.0");
    }
}
