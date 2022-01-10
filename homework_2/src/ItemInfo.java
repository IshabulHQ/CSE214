/** Original Description
 *
 * 1. Write a fully-documented class named ItemInfo that contains various information
 * about a specific item that can or has been sold in a given department store. Include
 * the product's name(String) and price(a positive double) as fields along with the
 * information in the following format:
 *-rfidTagNumber: a
 * It is 9 characters long and represented in hexadecimal format(base 16) which means
 * each character is either a digit from 0 to 9 or one of the letters A through F, where
 * case is not important. The length of this String is to be fixed at 9.
 * -Original Location: a
 * The first character is 's' to designate that it is a shelf position and it is followed
 * by a 5 digit shelf number to further specify where it can be found in the store.
 * (Examples may be "s00013", "s90909", "s32760", etc.). The length of the String is to be fixed at 6.
 *
 * -Current Location: a S.
 * It may be a shelf position (as described above), an encoding of a cart number, which is
 * designated by the letter 'c' followed by a 3 digit number ("c101", "c001", "c347", etc.),
 * or it may have been checked out by a customer already in which case the location will be
 * represented by the String "out", where case is not important.
 */

/**
 * This class cotains information about a specific item that can be sold
 * Contains product's name, rfidTagNumber, original loocatiion, current
 * location as a String and price as a double
 *
 * @author Ishabul Haque
 **/


public class ItemInfo {



    //Private member variables for itemInfo
    private String name,rfidTagNumber,originalLocation,currentLocation;
    private double price;

    /**
     * This is a Constructor used to create a new ItemInfo object
     *
     * @param name
     *     The name of the product
     * @param rfidTagNumber
     *      String that encodes the radio frequency for scanning the item.
     * @param originalLocation
     *      String that encodes the original shelf position of the item.
     * @param currentLocation
     *      String that represents the location of the item at the current time
     * @param price
     *      The price of the product
     */

    public ItemInfo(String name, String rfidTagNumber, String originalLocation,
                    String currentLocation, double price) {
        this.name = name;
        this.rfidTagNumber = rfidTagNumber;
        this.originalLocation = originalLocation;
        this.currentLocation = currentLocation;
        this.price = price;
    }

    /**
     * Accessor method for name
     *
     * @return Product name as a String
     */


    public String getName() {
        return name;
    }

    /**
     * Mutator method for name
     *
     * @param name Product name as a String
     * @postcondition name is set to input String
     */

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Accessor method for rfidTagNumber
     *
     * @return Product rfidTagNumber as a String
     */

    public String getRfidTagNumber() {
        return rfidTagNumber;
    }

    /**
     * Mutator method for rfidTagNumber
     *
     * @param rfidTagNumber Product RfidTagNumber as a String
     * @postcondition RfidTagNumber is set to input String
     */

    public void setRfidTagNumber(String rfidTagNumber) {
        this.rfidTagNumber = rfidTagNumber;
    }

    /**
     * Accessor method for originalLocation
     *
     * @return Product originalLocation as a String
     */


    public String getOriginalLocation() {
        return originalLocation;
    }

    /**
     * Mutator method for originalLocation
     *
     * @param originalLocation Product originalLocation as a String
     * @postcondition originalLocation is set to input String
     */

    public void setOriginalLocation(String originalLocation) {
        this.originalLocation = originalLocation;
        this.setCurrentLocation(originalLocation);
    }

    /**
     * Accessor method for currentLocation
     *
     * @return Product currentLocation as a String
     */


    public String getCurrentLocation() {
        return currentLocation;
    }

    /**
     * Mutator method for currentLocation
     *
     * @param currentLocation Product currentLocation as a String
     * @postcondition currentLocation is set to input String
     */

    public void setCurrentLocation(String currentLocation) {
        this.currentLocation = currentLocation;
    }

    /**
     * Accessor method for price
     *
     * @return Product price as an int
     */


    public double getPrice() {
        return price;
    }

    /**
     * Mutator method for price
     *
     * @param price Product price as an int
     * @postcondition Product price is set as an int
     */

    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * toString() method for ItemInfo
     * Returns members of ItemInfo in a formatted manner
     *
     * @return A String containing the ItemInfo members
     */

    @Override
    public String toString() {

        String print = this.name
                + "\t\t" + this.rfidTagNumber
                + "\t\t" + this.originalLocation
                + "\t\t\t" + this.currentLocation
                + "\t\t\t" + this.price;
        return print;

    }

}













