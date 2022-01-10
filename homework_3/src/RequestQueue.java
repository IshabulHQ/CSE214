/**
 * This class cotains information about a Queue of Requests holding information
 * about the head, tail and info for the linked list
 * Playlist holding songRecords
 *
 * @author Ishabul Haque
 **/

public class RequestQueue {

    private RequestNode head;
    private RequestNode tail;
    private Request item;

    /**
     * RequestQueue() constructs an instance of RequestQueue class
     * with default values of null
     */

    public RequestQueue(){

        head = null;
        tail = null;

    }

    /**
     * isEmpty() Checks if Queue is empty by checking if head
     * value of linked list is null
     * @return
     */

    public boolean isEmpty() {

        return (head == null);

    }

    /**
     * enque() Adds item to the rear of the queue
     * @param item Request added to queue
     * @postcondition Request was added to the queue
     */

    public void enqueue(Request item){

        RequestNode newNode = new RequestNode(item);
        if(head == null){
            head = newNode;
            tail = head;
        }
        else{
            tail.setPrev(newNode);
            tail = newNode;
        }

        System.out.println(item + "was added to the rear of the " +
                "queue ");
    }

    /**
     * deque() Removes first item from the front of the queue
     * @throws EmptyQueueException Checks if Queue is empty
     * @postcondition First item from the queue was removed
     * @return
     */

    public Request dequeue() throws EmptyQueueException {

        Request item = null;

        try{
            if(isEmpty()){
                tail = null;
                throw new EmptyQueueException();
            }
            item = head.getInfo();
            head = head.getNext();
            System.out.println(item + " was removed from the queue");

        }catch(EmptyQueueException ex){
            ex.emptyQueue();

        }
        return item;




    }


}
