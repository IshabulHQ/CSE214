/**
 * This class displays a menu to operate through the tree
 *
 * @author Ishabul Haque
 **/

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;


public class TreeDriver {

    private static Scanner sc;
    private static Tree tree = new Tree();


    /**
     * printToScreen() Prints the menu to the screen
     * @return Prints the menu to the screen
     */
    private static void printToScreen(){

        System.out.print("\nL - Load a Tree.\n" +
                "H - Begin a Help Session.\n" +
                "T - Traverse the Tree in preorder. \n" +
                "Q - Quit\n" +
                "Choice>  " );

    }


    /**
     * readFromFile() Takes the file name input from
     * the user and accesses it's content to create
     * a new tree
     * @return A new tree is created from the file's
     * content
     */
    public static void getFile(){

        String label,prompt,message;

        boolean status = true;

        try {

            // Have file name inputted and check if it exits before
            // saving it as a file
            System.out.print("Enter the file name> ");
            String text = sc.next();
            File file = new File(text);
            sc = new Scanner(file);

            // Have TreeNode params saved from next text in file

            label = sc.nextLine().trim();
            message = sc.nextLine().trim();
            prompt = sc.nextLine().trim();

            //Create a new node based on the saved params
            TreeNode newNode = new TreeNode(label,prompt,message);

            // Add new node to the tree
            tree = new Tree(newNode);


            // Go through the file to add a new node to the tree
            while(sc.hasNextLine()){

                String parentLabel = sc.nextLine().trim();

                // Retrieve the number of children for a particular node
                char numOfChild = parentLabel.charAt(parentLabel.length() - 1);
                int numOfChildren = Integer.parseInt(String.valueOf(numOfChild));

                parentLabel = parentLabel.substring(0,parentLabel.length()-1).trim();

                // Create new children for a particular node
                for(int i = 1; i <= numOfChildren; i++){
                    label = sc.nextLine().trim();
                    message = sc.nextLine().trim();
                    prompt = sc.nextLine().trim();

                    // If unable to add a new node, throw an error
                    if(!tree.addNode(label,prompt,message, parentLabel))
                        status = false;
                }
            }
            if(!status){

                System.out.println("File not correctly formatted.");
                return;

            }
            else{
                System.out.println("Tree created successfully!");
            }
        }
        catch (FileNotFoundException ex) {
            System.out.println("File Not Found ");
        }
        catch(Exception ex){
            System.out.println("File not correctly formatted ");
        }
    }


    public static void main(String[] args){

        boolean status = true;
        while(status){

            printToScreen();
            sc = new Scanner(System.in);

            String input = sc.next().toUpperCase();
            System.out.println();

            switch (input){

                case "L":

                    getFile();
                    break;

                case "H":

                    tree.beginSession();
                    break;

                case "T":

                    tree.preOrder();
                    break;

                case "Q":

                    System.out.println("Thank you for using our automated help services!");
                    status = false;

                default:

                    System.out.println("Invalid menu option.\n");

            }
        }
    }
}