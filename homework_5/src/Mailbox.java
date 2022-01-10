/**
 * This class represents an email box and it will
 * contain all of the folders and the remaining logic.
 *
 * @author Ishabul Haque
 **/

import java.util.Scanner;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.GregorianCalendar;



public class Mailbox implements Serializable{

    private Folder inbox = new Folder("Inbox");
    private Folder trash = new Folder("Trash");
    private ArrayList<Folder> folderList = new ArrayList<Folder>();

    /**
     * Mailbox() constructs an instance of Mailbox class
     * with default folders added to folder list
     */
    public Mailbox(){

        folderList.add(inbox);
        folderList.add(trash);

    }

    /**
     * Accessor method for inbox
     *
     * @return Inbox field as a Folder
     */

    public Folder getInbox() {
        return inbox;
    }

    /**
     * Mutator method for to field
     * @param inbox is set to input folder
     * @postcondition inbox is set to input folder
     */

    public void setInbox(Folder inbox) {
        this.inbox = inbox;
    }

    /**
     * Accessor method for trash
     *
     * @return Trash field as a Folder
     */

    public Folder getTrash() {
        return trash;
    }

    /**
     * Mutator method for to field
     * @param trash  is set to input folder
     * @postcondition trash is set to input folder
     */

    public void setTrash(Folder trash) {
        this.trash = trash;
    }

    /**
     * Accessor method for to
     *
     * @return Folderlist as array list
     */

    public ArrayList<Folder> getFolderList() {
        return folderList;
    }

    /**
     * Mutator method for to field
     *
     * @param folderList Folderlist Array list
     * @postcondition folderList is set to input array list
     */

    public void setFolderList(ArrayList<Folder> folderList) {
        this.folderList = folderList;
    }

    /**
     * listSize() Returns the size of folder list
     * @return Returns the size of folder list
     */

    public int listLength(){
        return this.folderList.size();
    }

    /**
     * addFolder() Adds new folder to folder list
     *
     * @param folder new folder too be added
     * @postcondition Adds new folder to folder
     * list after checking for duplicates
     */

    public void addFolder(Folder folder){

        int i = 0;
        while(i < folderList.size()){
            if(folderList.get(i).getName().equalsIgnoreCase(folder.getName())){
                System.out.println("Folder name is already being used");
                break;
            }
            i++;
        }
        folderList.add(folder);

    }

    /**
     * addFolder() Deletes folder
     * @param name Folder name to be deleted
     * @postcondition Deletes specified folder
     * if found
     */

    public void deleteFolder(String name){
        if(name.equalsIgnoreCase("Inbox") || name.equalsIgnoreCase("Trash")){
            System.out.println(name + " cannot be deleted \n");
            return;
        }

        int i = 0;
        while(i < folderList.size()){

            if(folderList.get(i).getName().equalsIgnoreCase(name)){
                folderList.remove(i);
                System.out.println(name + " has been successfully deleted");
                break;
            }
            i++;
        }

        System.out.println(name + " folder does not exist\n");
    }

    /**
     * composeEmail() Gets user input on the contents
     * of the email and adds it to the inbox.
     * @postcondition New email was created based on
     * valid user input
     */

    public void composeEmail(){

        GregorianCalendar cal =  new GregorianCalendar();
        Scanner sc = new Scanner(System.in);
        String to,cc,bcc,subject;
        String error = "";
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";

        try{

            System.out.println("\nEnter recipient (To): ");
            to = sc.nextLine().trim();

            if(!to.matches(regex)){
                error = "To";
                System.out.println(to);
                throw new InvalidInputException();
            }

            System.out.print("\nEnter carbon copy recipients (CC): ");
            cc = sc.nextLine().trim();

            if(!cc.matches(regex)){

                error = "Cc";
                throw new InvalidInputException();

            }

            System.out.print("\nEnter blind carbon copy recipients (BCC): ");
            bcc = sc.nextLine().trim();

            if(!bcc.matches(regex)){

                error = "Bcc";
                throw new InvalidInputException();

            }

            System.out.print("\nEnter subject line: ");
            subject = sc.nextLine().trim();

            if(subject.isEmpty()){

                error = "Subject";
                throw new InvalidInputException();

            }



        }catch(InvalidInputException ex){
            ex.invalidInput(error);
            return;

        }

        System.out.print("\nEnter body: ");
        String body = sc.nextLine().trim();
        Email newEmail = new Email(to,cc,bcc,subject,body,cal);
        inbox.addEmail(newEmail);
        System.out.println("\nEmail successfully added to Inbox.\n");
    }

    /**
     * deleteEmail() Moves the email to the
     * trash. (This method shouldn’t remove any emails
     * from folders, the method removeEmail should be
     * called and then deleteEmail is called on the result)
     *
     * @param email Email to delete (move to trash)
     */

    public void deleteEmail(Email email){
        trash.addEmail(email);
    }


    /**
     * clearTrash() Removes all emails from the
     * trash folder.
     *
     * @postcondition Trash folder is empty
     */

    public void clearTrash() throws OutOfBoundsException {
        int count = trash.getEmails().size();
        int i = 0;
        while(i < count){
            trash.removeEmail(i);
            i++;
        }
        System.out.println("\n" + count + " item(s) successfully deleted.\n");
    }

    /**
     * moveEmail() Takes the given email and
     * puts in in the given folder. If the
     * folder cannot be found, instead move it
     * to the Inbox.
     *
     * @param email Email to be moved
     * @param target Folder of desired location
     * @postcondition Email was moved to desired
     * folder
     */

    public void moveEmail(Email email, Folder target){
        for(int i = 0; i < folderList.size(); i++){
            boolean status = folderList.get(i).getName().equalsIgnoreCase(target.getName());
            if(status = true){
                target.addEmail(email);
                System.out.println("\n\"" + email.getSubject() +
                        "\" successfully moved to "
                        + target.getName() + ".");
                break;

            }

            else{
                System.out.println("Folder does not exist");
            }
        }

    }


    /**
     * getFolder() Returns a folder by folder name.
     *
     * @param name Name of desired folder
     * @postcondition Returns a folder by folder name.
     */

    public Folder getFolder(String name){
        int i = 0;
        while(i < folderList.size()){
            if(folderList.get(i).getName().equalsIgnoreCase(name)){
                return folderList.get(i);
            }
            i++;
        }
        System.out.println("\nFolder does not exist.");
        return null;
    }


    /**
     * toString() Gets the String representation of this Mailbox object
     * @return The String representation of this Mailbox object.
     */

    public String toString(){
        String output = "";
        int i = 0;
        while(i < folderList.size()){
            output += folderList.get(i).getName() + "\n";
            i++;
        }
        return output;
    }
}