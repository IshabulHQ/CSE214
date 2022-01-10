/**
 * This class contains information about ann email which includes
 * who the email is going to, who is cc'd and bcc'd in the email,
 * subject, body content  and timestamp
 *
 * @author Ishabul Haque
 **/

import java.io.Serializable;
import java.util.Comparator;
import java.util.GregorianCalendar;



public class Email implements Serializable, Comparable{

    private String to,cc,bcc;
    private String subject,body;
    private GregorianCalendar timestamp;

    /**
     * Email() constructs an instance of Email class
     * with default values of null and the current time
     * for when the email is constructed
     */

    public Email(){
        this.to = null;
        this.cc = null;
        this.bcc = null;
        this.subject = null;
        this.body = null;

        this.timestamp = new GregorianCalendar();
    }

    /**
     * This is a Constructor used to create a new Email object
     * which is the first node
     * @param to
     *     The to field of the email
     * @param cc
     *     The cc field of the email
     * @param bcc
     *     The bcc field of the email
     * @param subject
     *     The subject field of email
     * @param body
     *     The body field of the email
     * @param timestamp
     *     The timestamp of the email
     */

    public Email(String to, String cc, String bcc, String subject, String body,
                 GregorianCalendar timestamp){
        this.to = to;
        this.cc = cc;
        this.bcc = bcc;
        this.subject = subject;
        this.body = body;
        this.timestamp = timestamp;
    }

    /**
     * Accessor method for to
     *
     * @return Email to field as a String
     */

    public String getTo() {
        return to;
    }

    /**
     * Mutator method for to field
     *
     * @param to Email to field as a String
     * @postcondition to is set to input String
     */

    public void setTo(String to) {
        this.to = to;
    }

    /**
     * Accessor method for cc
     *
     * @return Email cc field as a String
     */

    public String getCc() {
        return cc;
    }

    /**
     * Mutator method for cc field
     *
     * @param cc Email cc field as a String
     * @postcondition cc is set to input String
     */

    public void setCc(String cc) {
        this.cc = cc;
    }

    /**
     * Accessor method for bcc
     *
     * @return Email bcc field as a String
     */

    public String getBcc() {
        return bcc;
    }

    /**
     * Mutator method for to field
     *
     * @param bcc Email bcc field as a String
     * @postcondition bcc is set to input String
     */

    public void setBcc(String bcc) {
        this.bcc = bcc;
    }

    /**
     * Accessor method for subject
     *
     * @return Email subject field as a String
     */

    public String getSubject() {
        return subject;
    }

    /**
     * Mutator method for to field
     *
     * @param subject Email subject field as a String
     * @postcondition subject is set to input String
     */

    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * Accessor method for body
     *
     * @return Email body field as a String
     */

    public String getBody() {
        return body;
    }

    /**
     * Mutator method for body field
     *
     * @param body Email body  as a String
     * @postcondition body is set to input String
     */

    public void setBody(String body) {
        this.body = body;
    }

    /**
     * Accessor method for timestamp
     *
     * @return Email timestamp
     */

    public GregorianCalendar getTimestamp() {
        return timestamp;
    }

    /**
     * Mutator method for to field
     *
     * @param timestamp Email timestamp
     * @postcondition timestamp is set to input
     */

    public void setTimestamp(GregorianCalendar timestamp) {
        this.timestamp = timestamp;
    }

    /**
     * isEmpty() Checks if email content is empty
     * @return true or false for email content being
     * empty
     */

    public boolean isEmpty(){
        return (this.to == null &&
                this.cc == null &&
                this.bcc == null);
    }

    /**
     * compareTo() Compare the subjects of two email objects
     * @param obj - an object in which this Email is compared
     * @return Returns an int value of
     * 1 if first subject is greater than second subject
     * -1 if first subject is less than second object
     * 0 if both subjects are the same
     * only if the object is an instance of email
     */

    public int compareTo(Object obj) {

        if (obj instanceof Email && !((Email) obj).isEmpty()) {
            Email otherEmail = (Email) obj;
            int value = this.subject.compareTo(otherEmail.getSubject());
            if (value > 0) {
                return 1;
            } else if (value < 0) {
                return -1;

            } else {
                return 0;
            }

        }
        return -10;
    }


    /**
     * equals() Compare this Email to another object for equality.
     *
     * @param obj - an object in which this Email is compared
     * @return A return value of true indicates that obj refers to a Email
     * object with the same Email contents
     * Otherwise, the return value is false.
     */


    @Override
    public boolean equals(Object obj) {

        if (obj instanceof Email && !((Email) obj).isEmpty()) {

            Email email = (Email) obj;

            if(!email.getTo().equals(to) &&
                    !email.getCc().equals(cc) &&
                    !email.getBcc().equals(bcc) &&
                    !email.getSubject().equals(subject) &&
                    !email.getBody().equals(body) &&
                    !email.getTimestamp().equals(timestamp)){
                return false;
            }
        }
        return true;
    }

    /**
     * toString() Gets the String representation of the Email object
     * @return The String representation of the Email object.
     */
    @Override
    public String toString() {
        return
                "\nTo: " + to +
                "\nCC: " + cc +
                "\nBCC: " + bcc +
                "\nSubject: " + subject +
                "\n" + body;
    }
}

    /**
     * sortBySubjectAscending() Sorts emails
     * by subject ascending by using the
     * compareTo method
     * @postcondition Emails are sorted by
     * subject ascending and current sorting
     * method is updated
     */

class SubjectAscending implements Comparator{

    public int compare(Object o1, Object o2){

        Email e1 = (Email)o1;
        Email e2 = (Email)o2;

        return (e1.getSubject().compareTo(e2.getSubject()));
    }
}
    /**
     * sortBySubjectDescending() Sorts emails
     * by subject descending by using the
     * compareTo method
     * @postcondition Emails are sorted by
     * subject descending and current sorting
     * method is updated
     */

class SubjectDescending implements Comparator{

    public int compare(Object o1, Object o2){

        Email e1 = (Email)o1;
        Email e2 = (Email)o2;

        return -(e1.getSubject().compareTo(e2.getSubject()));
    }
}

    /**
     * sortByDateAscending() Sorts emails
     * by date ascending by using the
     * compareTo method
     * @postcondition Emails are sorted by
     * date ascending and current sorting
     * method is updated
     */

class DateAscending implements Comparator{

    public int compare(Object o1, Object o2){

        Email e1 = (Email)o1;
        Email e2 = (Email)o2;

        return (e1.getTimestamp().compareTo(e2.getTimestamp()));
    }
}
    /**
     * sortByDateDescending() Sorts emails
     * by date descending by using the
     * compareTo method
     * @postcondition Emails are sorted by
     * date descending and current sorting
     * method is updated
     */

class DateDescending implements Comparator{

    public int compare(Object o1, Object o2){

        Email e1 = (Email)o1;
        Email e2 = (Email)o2;

        return -(e1.getTimestamp().compareTo(e2.getTimestamp()));
    }
}
