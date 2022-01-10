
/**
 * This class contains information used to simulate the Elevator requests
 *
 * @author Ishabul Haque
 *
 **/


public class Simulator {

    public static void stepTracker(int step){
        System.out.print("Step " + step + ": ");
    }

    /**
     * simulate() Carries out actual simulation
     * @param p - proobability of requests
     * @param numOfFloors - total number of floors
     * @param numElevators - total number of elevators
     * @param simLength - Length of simulatio
     * @param debug - Checks if debugging mode is activated
     * @precondition The Playlist referred to by originalList has been instantiated.
     * @return Simulation occured
     */

    public static void simulate(double p, int numOfFloors,
                                int numElevators, int simLength,boolean debug) throws EmptyQueueException {

        // Cases where it will result in no simulation
        if(p < 0.0 || p > 1.0 || numOfFloors < 1 ||
                numElevators < 0 || simLength < 0){
            System.out.println("NO SIMULATION");
        }

        RequestQueue queue = new RequestQueue();
        BooleanSource arrival = new BooleanSource(p);

        int totalWaitTime = 0;
        int requests = 0;
        double avgWaitTime;
        int currentSecond;



        Elevator[] elevatorList = new Elevator[numElevators];
        int[] elevatorWaitTimes = new int [numElevators];

        for(int i = 0; i < numElevators; i ++){
            // Initializes new elevator for each index
            // of elevator list
            elevatorList[i] = new Elevator();
            // Initializes each elevator's wait time
            // to 0
            elevatorWaitTimes[i] = 0;
        }

        //loop simulates each time

        for(currentSecond = 1; currentSecond <= simLength;
        currentSecond++){

            // Event 1: Checks if a person has arrived and will
            // add to rear of queue
            if(arrival.requestArrived()){
                // Create a new request if person has arrived
                Request newRequest = new Request(numOfFloors);
                newRequest.setTimeEntered(currentSecond);
                queue.enqueue(newRequest);

                if(debug){
                    stepTracker(currentSecond);
                    System.out.println("A request arrives from Floor "
                    + newRequest.getSourceFloor() + " to Floor "
                    + newRequest.getDestinationFloor());
                }
            }
            else if(debug){
                stepTracker(currentSecond);
                System.out.println("Nothing arrives");
            }

            // Event 2: Checks if we can take a person off the
            // queue and put them in the Elevator

            for(int i = 0; i < numElevators && !queue.isEmpty(); i ++){
                // Checks if elevator is Idle
                if(elevatorList[i].getElevatorState() == 0){
                    // Removes request from front of queue to add
                    // person to elevator
                    Request newRequest = queue.dequeue();
                    // Adds wait time for desired elevator
                    elevatorWaitTimes[i] = Math.abs(newRequest.getSourceFloor() - elevatorList[i].getCurrentFloor());
                    // Update elevator on handling new request
                    elevatorList[i].setRequest(newRequest);
                    // Sets elevator status to moving to source
                    elevatorList[i].setElevatorState(1);
                }
            }

            // Event 3: Elevator is moving

            for(int i = 0; i < numElevators; i++){
                Elevator newElevator = elevatorList[i];
                // Elevator will not move if IDLE
                if(newElevator.getElevatorState() == 0){
                    continue;
                }
                // Elevator is moving towards source
                else if(newElevator.getElevatorState() == 1){

                    // If person was just picked up, change elevator sate
                    // too moving to destination

                    if(newElevator.getCurrentFloor() == newElevator.getRequest().getSourceFloor()){
                        newElevator.setElevatorState(10);
                    }

                    // If elevator is going to source floor, increment current floor
                    // to get elevator to move to source

                    else if(newElevator.getCurrentFloor() <
                            newElevator.getRequest().getSourceFloor()){

                        newElevator.setCurrentFloor(newElevator.getCurrentFloor() + 1);

                    }

                    // If elevator is above source floor, decrement currennt floor
                    // to get elevator close to source floor

                    else if(newElevator.getCurrentFloor() >
                            newElevator.getRequest().getSourceFloor()){

                        newElevator.setCurrentFloor(newElevator.getCurrentFloor() - 1);

                    }

                }


                // Elevator is moving towards destination
                else if(newElevator.getElevatorState() == 10){

                    // If person was just picked up, change elevator sate
                    // too moving to destination

                    if(newElevator.getCurrentFloor() == newElevator.getRequest().getDestinationFloor()){
                        newElevator.setElevatorState(0);
                        newElevator.setRequest(null);
                        totalWaitTime += elevatorWaitTimes[i];
                        elevatorWaitTimes[i] = 0;
                        requests++;
                    }

                    // If elevator is below destination floor, increment current floor
                    // to get elevator close to destination floor

                    else if(newElevator.getCurrentFloor() <
                            newElevator.getRequest().getDestinationFloor()){

                        newElevator.setCurrentFloor(newElevator.getCurrentFloor() + 1);

                    }

                    // If elevator is above destination floor, decrement current floor
                    // to get elevator close to destination floor

                    else if(newElevator.getCurrentFloor() >
                            newElevator.getRequest().getDestinationFloor()){

                        newElevator.setCurrentFloor(newElevator.getCurrentFloor() - 1);

                    }

                }

            }


            if(debug){
                System.out.print("Total Wait Time = " + totalWaitTime);
                System.out.print(" Total Requests  = " + requests);
                System.out.println("\nRequests: " + requests);
                System.out.println("Elevators: " + queue);

            }
        }


        avgWaitTime = totalWaitTime/requests;

        System.out.print("\nTotal Wait Time = " + totalWaitTime);
        System.out.print("\nTotal Requests  = " + requests);
        System.out.println("\nAverage Wait Time:: " + avgWaitTime);

    }
}