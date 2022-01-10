import java.util.Scanner;

/**
 * This class contains information to prompt user to input simulation results
 *
 * @author Ishabul Haque
 **/


public class Analyzer {

    private static double probability;
    private static int numOfFloors, numOfElevators, simLength;
    private static boolean debug;
    static Simulator simulator = new Simulator();

    private static Scanner sc = new Scanner(System.in);



    public static void printToDisplay() throws InvalidInputException {



            System.out.println("Welcome to the Elevator simulator! \n");
            try{
                System.out.print("Please enter the probability  of arrival" +
                        "for Requests: ");
                probability = sc.nextDouble();
                if(probability < 0.0 || probability > 1.0){
                    throw new InvalidInputException();
                }

                System.out.print("\nPlease enter the number of floors:");
                numOfFloors = sc.nextInt();
                if(numOfFloors < 0){
                    throw new IllegalArgumentException();
                }
                System.out.print("\nPlease enter the number of elevators: ");
                numOfElevators = sc.nextInt();
                if(numOfElevators < 0){
                    throw new IllegalArgumentException();
                }
                System.out.print("\n Please enter the length of the simulation " +
                        "(in time uniis): ");
                simLength = sc.nextInt();
                if(simLength < 0){
                    throw new IllegalArgumentException();
                }

                System.out.print("\nPlease enter true or false for debugging ");
                debug = sc.nextBoolean();


            }catch(InvalidInputException ex){
                ex.invalidProbability();
            }


        try {
            simulator.simulate(probability,numOfFloors,numOfElevators,simLength,debug);
        } catch (EmptyQueueException ex) {
            ex.printStackTrace();
        }


    }


    public static void main (String[] args) throws InvalidInputException {

        Analyzer analyzer = new Analyzer();
        printToDisplay();


    }
}
