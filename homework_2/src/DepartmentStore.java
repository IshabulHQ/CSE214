/** Class Description
 * Write a fully-documented class named DepartmentStore.
 * This class will contain a main method that provides a
 * menu with the following options to interact with the
 * program and update the store inventory
 *
 *  @author Ishabul Haque
 */

import java.util.Scanner;

public class DepartmentStore {
    private static Scanner sc = new Scanner(System.in);
    private static boolean status = true;
    private static String input;

    private static double checkPrice(){

        do{
            try{
                System.out.print("Enter the price: ");
                return Double.parseDouble(sc.nextLine());
            }
            catch(NumberFormatException ex){
                System.out.println("Please Enter a Valid Price");
            }
        }while(true);
    }

    private static String checkRfidTag(){
        boolean status = true;
        do{
            try{
                System.out.print("Enter the RFID: ");
                input = sc.nextLine();
                if(input.length() != 9){
                    throw new InvalidInput();
                }
                else{

                    status = false;
                }


            }catch(InvalidInput ex){
                ex.rfidTagLengthError();

            }
        }while(status);

        return input;
    }


    private static void printToScreen() {
        System.out.print("\nWelcome! \n" +
                "C - Clean store \n" +
                "I Insert an item into the list \n" +
                "L - List by location \n" +
                "M - Move an item in the store \n" +
                "O - Checkout:  \n" +
                "P - Print all items in store \n" +
                "R - Print by RFID tag number \n" +
                "U - Update inventory system \n" +
                "Q - Exit the program\n" +
                "O - Checkout:  \n" +
                "Q) Quit \n\n");

    }


    public static void main(String[] args) {
        String name, rfidTagNumber, originalLocation, currentLocation;
        double price;
        ItemList newList = new ItemList();



        while (status) {
            printToScreen();

            System.out.print("\nPlease select an option");


            String input = sc.nextLine().toUpperCase();

            switch (input) {
                case "C":
                    newList.cleanStore();
                    break;

                case "I":

                    System.out.println("Enter the name: ");
                    name = sc.nextLine();
                    rfidTagNumber = checkRfidTag();
                    System.out.println("Enter the original location: ");
                    originalLocation = sc.nextLine();
                    price = checkPrice();
                    newList.insertInfo(name, rfidTagNumber, price, originalLocation);
                    break;

                case "L":
                    System.out.println("Enter the location");
                    currentLocation = sc.nextLine();
                    newList.printByLocation(currentLocation);
                    break;

                case "M":
                    rfidTagNumber = checkRfidTag();
                    System.out.println("Enter the original location: ");
                    originalLocation = sc.nextLine();
                    System.out.println("Enter the current location: ");
                    currentLocation = sc.nextLine();
                    newList.moveItem(rfidTagNumber, originalLocation, currentLocation);
                    break;

                case "O":
                    System.out.println("Enter the cart number: ");
                    originalLocation = sc.nextLine();
                    price = newList.checkOut(originalLocation);
                    System.out.println("The total cost for all merchandise" +
                            "in cart" + originalLocation.substring(1,4) +
                            " was $" + price + "\n");

                    break;

                case "P":
                    newList.printAll();
                    break;

                case "R":
                    newList.printToDisplay();
                    rfidTagNumber = checkRfidTag();
                    newList.printByRFid(rfidTagNumber);
                    break;

                case "U":
                    newList.removeAllPurchased();
                    break;

                case "Q":
                    System.out.println("Goodbye");
                    status = false;

                default:
                    System.out.println("Invalid input");


            }
        }
    }
}