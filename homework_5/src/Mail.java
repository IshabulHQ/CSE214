/**
 * This class contains information a folder to store emails
 * when added or removed and will sort them accordingly
 *
 * @author Ishabul Haque
 **/

import java.io.Serializable;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class Mail implements Serializable{


    public static Mailbox mailbox;
    public static Folder folder;

    /**
     * printToDisplay() Prints the menu to the screen
     * @postcondition Prints the menu to the screen
     */

    public static void printToDisplay(){

        System.out.print("\nMailbox:\n--------\n" +
                mailbox + "\n" +
                "A - Add folder \n" +
                "R - Remove folder\n" +
                "C - Compose email\n" +
                "F - Open folder \n" +
                "I - Open Inbox \n" +
                "T - Open Trash \n" +
                "E - Empty Trash \n"+
                "Q - Quit \n"+
                "Enter a user option: \n");
    }

    /**
     * printToDisplay() Prints the folder menu to the screen
     * @postcondition Prints the folder menu to the screen
     */
    public static void printFolderMenu(){

        System.out.print("\nM - Move email \n" +
                "D - Delete email \n" +
                "V - View email contents \n" +
                "SA - Sort by subject line in ascending order \n" +
                "SD - Sort by subject line in descending order \n" +
                "DA - Sort by date in ascending order \n" +
                "DD - Sort by date in descending order \n" +
                "R - Return to mailbox\n"+
                "Enter a user option: ");
    }

    /**
     * fileWrite() Creates new mailbox file to save
     * @postcondition Mailbox file was created and save
     */

    public static void fileWrite(){
        try{

            FileOutputStream file = new FileOutputStream("mailbox.obj");
            ObjectOutputStream fout = new ObjectOutputStream(file);
            fout.writeObject(mailbox);
            fout.close();

            System.out.println("Program successfully exited and mailbox saved.");

        }
        catch(IOException a){
            System.out.println("Cannot save file.");
        }
        System.exit(0);
    }

    /**
     * fileRead() Checks to see if mailboox.obj is found
     * otherwise start new mailbox
     * @postcondition Mailbox is created either new or based
     * on an old file
     */

    public static void fileRead(){
        try {
            FileInputStream file = new FileInputStream("mailbox.obj");
            ObjectInputStream fin = new ObjectInputStream(file);
            mailbox = (Mailbox)fin.readObject();
            file.close();
            System.out.println("Mailbox.obj found, starting with previous mailbox.\n");
        }
        catch (IOException | ClassNotFoundException ex) {
            mailbox = new Mailbox();
            System.out.println("Previous save not found, starting with an empty mailbox.\n");
        }
    }

    /**
     * folderMenu() Handles menu options for
     * folder section
     */

    public static void folderMenu() throws OutOfBoundsException {

        String input;
        folder.sortByDateDescending();
        boolean status = true;
        int index;

        do{
            Scanner sc = new Scanner(System.in);
            System.out.println("\n" + folder.getName());
            System.out.println(folder);
            Email email;

            printFolderMenu();
            input = sc.next().toUpperCase().trim();

            switch(input){

                case "M":

                    System.out.print("\nEnter the index of the email to move: ");
                    index = Integer.parseInt(sc.next()) -1;

                    if(folder.getEmails(index) != null && index > -1){

                        email = folder.getEmails(index);
                        System.out.println("\nFolders:");
                        System.out.println(mailbox);
                        System.out.println("Select a folder to move\" " + email.getSubject() + "\" to: ");
                        sc.nextLine();

                        mailbox.moveEmail(email, mailbox.getFolder(sc.nextLine().trim()));
                        folder.removeEmail(index);
                    }
                    else{

                        System.out.println("\nInvalid Index");

                    }
                    break;

                case "D":
                    System.out.print("\nEnter the index of the email to move: ");
                    index = Integer.parseInt(sc.next()) -1;

                    if(folder.getEmails(index) != null && index > -1){

                        email = folder.getEmails(index);
                        folder.removeEmail(index);
                        mailbox.deleteEmail(email);

                    }
                    else{
                        System.out.println("\nInvalid Index");
                    }
                    break;

                case "V":
                    System.out.print("\nEnter email index: ");

                    index = Integer.parseInt(sc.next()) -1;

                    if(folder.getEmails(index) != null && index > -1){

                        System.out.println(folder.getEmails(index));

                    }
                    else{
                        System.out.println("\nInvalid Index");
                    }
                    break;

                case "SA":

                    folder.sortBySubjectAscending();
                    break;

                case "SD":

                    folder.sortBySubjectDescending();
                    break;

                case "DA":

                    folder.sortByDateAscending();
                    break;

                case "DD":

                    folder.sortByDateDescending();
                    break;

                case "R":

                    status = false;
                    break;

                default:

                    System.out.println("\nNot a menu option.\n");
                    break;
            }


        } while(status);
        System.out.println();
    }

    public static void main(String[] args) throws OutOfBoundsException {

        fileRead();
        String input;
        Scanner sc = new Scanner(System.in);
        boolean status = true;

        do{
            printToDisplay();
            input = sc.next().toUpperCase().trim();

            switch(input){

                case "A":

                    System.out.println("\nEnter folder name: ");
                    sc.nextLine();
                    Folder newFolder = new Folder(sc.nextLine().trim());
                    mailbox.addFolder(newFolder);
                    System.out.println();
                    break;

                case "R":

                    System.out.println("\nEnter folder to remove: ");
                    sc.nextLine();
                    mailbox.deleteFolder(sc.nextLine().trim());
                    break;

                case "C":

                    mailbox.composeEmail();
                    break;

                case "E":

                    mailbox.clearTrash();
                    break;

                case "F":

                    System.out.println("\nEnter folder name: ");
                    sc.nextLine();
                    folder = mailbox.getFolder(sc.nextLine().trim());
                    if(folder != null)
                        folderMenu();
                    else{
                        System.out.println("Folder not found");
                    }
                    break;

                case "I":

                    folder = mailbox.getFolder("Inbox");
                    folderMenu();
                    break;

                case "T":

                    folder = mailbox.getFolder("Trash");
                    folderMenu();
                    break;

                case "Q":

                    status = false;
                    break;

                default:
                        System.out.println("\nNot a menu option.\n");
                    break;
            }

        } while(status);

        fileWrite();
    }
}