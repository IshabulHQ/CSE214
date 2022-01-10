
/**
 * This class contains information about the probability of
 * a request coming
 *
 * @author Ishabul Haque
 **/

public class BooleanSource {

    private double probability;


    /**
     * BooleanSource() Checks the validity of the the probability
     * @param p Probability as a double
     * @throws IllegalArgumentException() If proobability is less than
     * 0 or greater than 1
     */

    public BooleanSource(double p){

        if( p < 0.0 || p > 1.0){
            throw new IllegalArgumentException();

        }
        this.probability = p;

    }

    /**
     * requestArrived() returns boolean value of a request
     * arriving based on a randomly generated probability
     * @return True or false depending on probability
     */

    public boolean requestArrived(){

        return (Math.random() < probability);
    }

}
