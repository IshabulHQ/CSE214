/**
 * This class conntains information about a Request made to Elevator
 * holding information of sourceFloor,destinationFloor and timeEntered
 *
 * @author Ishabul Haque
 **/


public class Request {

    //Private member variables for class Request

    private int sourceFloor, destinationFloor, timeEntered;


    /**
     * This is a Constructor used to create a new SongRecord object
     *
     * @param numberOfFloors
     *     The number of floors in the building
     * @postcondition Values for sourceFloor and destinationFloor
     * will be randomly generated.
     */

    public Request(int numberOfFloors){

        sourceFloor = (int)(Math.random() * numberOfFloors + 1);
        destinationFloor = (int)(Math.random() * numberOfFloors + 1);

    }

    /**
     * Accessor method for sourceFloor
     *
     * @return Request sourceFloor as an int
     */

    public int getSourceFloor() {
        return sourceFloor;
    }

    /**
     * Mutator method for sourceFloor
     *
     * @param sourceFloor Request sourceFloor as an int
     * @postcondition sourceFloor is set to input int
     */

    public void setSourceFloor(int sourceFloor) {
        this.sourceFloor = sourceFloor;
    }

    /**
     * Accessor method for destinationFloor
     *
     * @return Request destinationFloor as an int
     */

    public int getDestinationFloor() {
        return destinationFloor;
    }

    /**
     * Mutator method for destinationFloor
     *
     * @param destinationFloor Request destinationFloor as an int
     * @postcondition destinationFloor is set to input int
     */

    public void setDestinationFloor(int destinationFloor) {
        this.destinationFloor = destinationFloor;
    }

    /**
     * Accessor method for timeEntered
     *
     * @return Request timeEntered as an int
     */

    public int getTimeEntered() {
        return timeEntered;
    }

    /**
     * Mutator method for timeEntered
     *
     * @param timeEntered Request timeEntered as an int
     * @postcondition timeEntered is set to input int
     */

    public void setTimeEntered(int timeEntered) {
        this.timeEntered = timeEntered;
    }

    /**
     * toString() method for Request
     * Returns members of Request in a formatted manner
     *
     * @return A String containing the Request members
     */

    @Override
    public String toString() {
        return
                "sourceFloor = " + sourceFloor +
                ", destinationFloor = " + destinationFloor +
                ", timeEntered = " + timeEntered + " ";
    }
}
