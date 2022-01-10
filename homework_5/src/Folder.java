/**
 * This class contains information a folder to store emails
 * when added or removed and will sort them accordingly
 *
 * @author Ishabul Haque
 **/
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.GregorianCalendar;


public class Folder implements Serializable{

    private ArrayList<Email> emails;
    private String name, currentSortingMethod;

    /**
     * Folder() constructs an instance of Folder class
     * with no Email objects in it
     * @PostCondition An empty Folder of Emails
     */
    public Folder(String name){
        this.emails = new ArrayList<Email>();
        this.name = name;
        this.currentSortingMethod = "DD";
    }

    /**
     * This is a Constructor used to create a new SongRecord object
     *
     * @param emails
     *     Array List containing emails for Folder class
     * @param emails
     *     Name of the folder
     * @param currentSortingMethod
     *     Contains the current sorting method
     * @postcondition Generates a new folder containing emails from
     * current list and declares the folder's name and the current
     * sorting method of the emails
     */

    public Folder(ArrayList<Email> emails, String name, String currentSortingMethod){
        this.emails = emails;
        this.name = name;
        this.currentSortingMethod = currentSortingMethod;
    }

    /**
     * Accessor method for to
     * @return Emails
     */

    public ArrayList<Email> getEmails() {

        return this.emails;
    }

    /**
     * Accessor method for Email
     *
     * @return Email by index in list
     */

    public Email getEmails(int index){
        if(index < 0 || index > emails.size()-1){
            return null;
        }
        return this.emails.get(index);
    }

    /**
     * Mutator method for emails field
     *
     * @param emails Arraylist emails
     * @postcondition Arraylist emails is set to
     * input arraylist
     */

    public void setEmails(ArrayList<Email> emails) {
        this.emails = emails;
    }

    /**
     * Accessor method for name
     *
     * @return Folder name field as a String
     */

    public String getName() {
        return name;
    }

    /**
     * Mutator method for name field
     *
     * @param name Folder name field as a String
     * @postcondition name is set to input String
     */

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Accessor method for currentSortingMethod
     * @return currentSortingMethod field
     * as a String
     */

    public String getCurrentSortingMethod() {
        return currentSortingMethod;
    }

    /**
     * Mutator method for currentSortingMethod
     * field
     *
     * @param currentSortingMethod Folder
     * currentSortingMethod field as a String
     * @postcondition currentSortingMethod is set
     * to input String
     */

    public void setCurrentSortingMethod(String currentSortingMethod) {
        this.currentSortingMethod = currentSortingMethod;
    }


    /**
     * addEmail() - Adds an email to the folder
     * @param email Email being added to folder
     * @postcondition Email was added to the folder
     * by current sorting method
     */
    public void addEmail(Email email){

        if(emails.isEmpty()){
            emails.add(email);
        }
        else{
            emails.add(email);

            for(int i = 0; i < emails.size() - 1; i++){
                int counter = i;

                if(email.getTimestamp().compareTo(emails.get(i).getTimestamp()) > 0){

                    emails.set(i,emails.get(counter++));

                }
            }
        }

    }

    /**
     * Removes an email from the folder by index.
     *
     * @param i
     * 	location of arraylist to remove email
     * @return
     * 	The email which was removed
     */

    public Email removeEmail(int i) throws OutOfBoundsException{

        try{
            if(i < -1 || i > emails.size()){
                throw new OutOfBoundsException();
            }

        }catch(OutOfBoundsException ex){
            ex.invalidLocation();

        }
        return emails.remove(i);

    }

    /**
     * sortBySubjectAscending() Sorts emails
     * by subject ascending
     * @postcondition Emails are sorted by
     * subject ascending and current sorting
     * method is updated
     */

    public void sortBySubjectAscending(){
        Collections.sort(emails, new SubjectAscending());
        currentSortingMethod = "SA";
    }
    /**
     * sortBySubjectDescending() Sorts emails
     * by subject descending
     * @postcondition Emails are sorted by
     * subject descending and current sorting
     * method is updated
     */

    public void sortBySubjectDescending(){
        Collections.sort(emails, new SubjectDescending());
        currentSortingMethod = "SD";
    }


    /**
     * sortByDateAscending() Sorts emails
     * by date ascending
     * @postcondition Emails are sorted by
     * date ascending and current sorting
     * method is updated
     */

    public void sortByDateAscending(){
        Collections.sort(emails, new DateAscending());
        currentSortingMethod = "DA";
    }
    /**
     * sortByDateDescending() Sorts emails
     * by date descending
     * @postcondition Emails are sorted by
     * date descending and current sorting
     * method is updated
     */

    public void sortByDateDescending(){
        Collections.sort(emails, new DateDescending());
        currentSortingMethod = "DD";
    }

    /**
     * equals() Compare this Email to another object for equality.
     *
     * @param obj - an object in which this Email is compared
     * @return A return value of true indicates that obj refers to a Email
     * object with the same Email contents
     * Otherwise, the return value is false.
     */

    public boolean equals(Object obj){
        return super.equals(obj);
    }

    /**
     * printToTable() Prints a neatly formatted table header
     * @postcondition A neatly formatted table header is displayed
     */


    public static void printTable() {
        System.out.println(String.format("%s%-10s%-10s%7s","Index |","","Time ","| Subject |"));
        System.out.println("------------------------------------------");
    }

    /**
     * toString() Gets the String representation of this Folder object, which
     * is a neatly formatted table of each Email in the Folder on its own
     * line with its position number as shown in the sample output
     * @return The String representation of this Folder object.
     */

    public String toString(){

        if(emails.size() == 0)
            return "\n" + this.name + " is empty .";

        printTable();

        int minute;
        String time,date;
        String output = "";

        for(int i=0; i<emails.size(); i++){
             date = (emails.get(i).getTimestamp().get(GregorianCalendar.MONTH) + 1)  + "/" +
                    emails.get(i).getTimestamp().get(GregorianCalendar.DAY_OF_MONTH) + "/" +
                    emails.get(i).getTimestamp().get(GregorianCalendar.YEAR);

             time = emails.get(i).getTimestamp().get(GregorianCalendar.HOUR) + ":";
             minute = emails.get(i).getTimestamp().get(GregorianCalendar.MINUTE);
             if(minute < 10){
                 time = time + "0" + minute;
             }
             else{
                 time = time + minute;
             }

             if(emails.get(i).getTimestamp().get(GregorianCalendar.AM) == 0){
                 time = time + "AM";
             }
             else{
                 time = time + "PM";
             }

             date = time + " " + date;
             output = String.format("%-6s|  %-18s| %-5s ", i+1, date, emails.get(i).getSubject());
        }
        return output;
    }
}
