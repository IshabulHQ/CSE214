
/**
 * This class contains information about an Elevator and it's current state
 * It holds info about the current floor of the elevator, the elevator state
 * oof idle, to source and to destination and info about the request
 *
 * @author Ishabul Haque
 **/

public class Elevator {

    private int currentFloor,elevatorState;
    private Request request;

    private static final int IDLE = 0;
    private static final int TO_SOURCE = 1;
    private static final int TO_DESTINATION = 10;

    /**
     * Elevator() constructs an instance of Elevator class
     * with default values
     */

    public Elevator(){
        request = null;
        elevatorState = IDLE;
        currentFloor = 1;
    }

    /**
     * Accessor method for currentFloor
     *
     * @return Request currentFloor as an int
     */

    public int getCurrentFloor() {
        return currentFloor;
    }

    /**
     * Mutator method for destinationFloor
     *
     * @param currentFloor int currentFloor
     * @postcondition currentFloor is set to input currentFloor
     */

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    /**
     * Accessor method for elevatorState
     *
     * @return Elevator elevatorState as an int
     */

    public int getElevatorState() {
        return elevatorState;
    }

    /**
     * Mutator method for elevatorState
     *
     * @param elevatorState int elevatorState
     * @postcondition elevatorState is set to input elevatorState
     */

    public void setElevatorState(int elevatorState) {
        this.elevatorState = elevatorState;
    }

    /**
     * Accessor method for request
     *
     * @return Request request
     */

    public Request getRequest() {
        return request;
    }

    /**
     * Mutator method for request
     *
     * @param request Request request
     * @postcondition request is set to input request
     */

    public void setRequest(Request request) {
        this.request = request;
    }

    public String returnState(int elevatorState){
        String state;

        if(elevatorState == IDLE){
            state = "IDLE";
        }
        else if(elevatorState == TO_SOURCE){
            state = "IDLE";
        }
        else if(elevatorState == TO_DESTINATION){
            state = "IDLE";
        }
        else{
            state = null;
        }
        return state;

    }

    /**
     * toString() method for Elevator
     * Returns members of Elevator in a formatted manner
     *
     * @return A String containing the Elevator members
     */

    @Override
    public String toString() {
        return "Elevator: " +
                "Floor " + currentFloor +
                ", " + returnState(this.elevatorState) +
                ", request = " + request +
                '}';
    }
}
