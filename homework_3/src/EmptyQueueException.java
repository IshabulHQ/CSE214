/**
 * This class is an exception use to see if the queue is empty
 *
 * @author Ishabul Haque
 **/

public class EmptyQueueException extends Exception {

    public EmptyQueueException(){

    }

    public void emptyQueue(){
        System.out.println("Empty Queue");
    }
}
