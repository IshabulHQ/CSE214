import java.io.*;

/** Original Class Description
 * Write a fully-documented class named SongRecord which contains information about a particular audio file.
 It should have member variables for the title and artist (both strings) as well as two member variables for the
 song's length in minutes and seconds (both ints). You should provide accessor and mutator methods for each variable
 as well as a default constructor. For the mutator method of the seconds variable, you should throw an exception if the
 new value is less than 0 or greater than 59. For the mutator method of the minutes variable, you should throw an exception
 if the new value is negative. Finally, you should provide a toString() method that neatly prints the information about the
 audio file on a single line as shown below in the sample output.

 **/

/**
 * This class cotains information about a particular audio file
 * Contains title name, artist name, song's length in minutes and seconds
 *
 * @author Ishabul Haque
 **/

public class SongRecord {

    // Private member variables for Song
    private String title, artist;
    private int minutes, seconds;

    // Default Constructor
    public SongRecord() {

    }

    /**
     * This is a Constructor used to create a new SongRecord object
     *
     * @param title
     *     The title of a Song
     * @param artist
     *     The artist of a Song
     * @param minutes
     *  The minutes of a Song
     * @param seconds
     *  The secods of a Song
     */


    public SongRecord(String title, String artist, int minutes, int seconds) {


            this.title = title;
            this.artist = artist;
            this.minutes = minutes;
            this.seconds = seconds;

    }

    /**
     * Accessor method for title
     *
     * @return Song title as a String
     */

    public String getTitle() {
        return this.title;
    }

    /**
     * Mutator method for title
     *
     * @param title Song title as a String
     * @postcondition title is set to input String
     */

    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Accessor method for artist
     *
     * @return Song artist as a String
     */

    public String getArtist() {
        return this.artist;
    }

    /**
     * Mutator method for artist
     *
     * @param artist Song artist as a String
     * @postcondition artist is set to input String
     */

    public void setArtist(String artist) {
        this.artist = artist;
    }


    /**
     * Accessor method for minutes
     *
     * @return Song minutes as an int
     */

    public int getMinutes() {
        return this.minutes;
    }

    /**
     * Mutator Method for variable minutes
     *
     * @param minutes Song length as an int
     *                Precondition:
     *                int  minutes must be greater than or equal to 0.
     * @throws IllegalArgumentException Indicates that int minutes is less than 0
     **/

    public void setMinutes(int minutes) {
        try{

            if (minutes < 0) {
                throw new IllegalArgumentException();
            }
            else {
                this.minutes = minutes;
            }

        }
        catch(IllegalArgumentException ex){
            System.out.println("Number should be greater than 0");
        }

    }

    /**
     * Accessor method for seconds
     *
     * @return Song seconds as an int
     */

    public int getSeconds() {
        return this.seconds;
    }

    /**
     * Mutator Method for variable seconds
     *
     * @param seconds Song secods as an innt
     *                Precondition:
     *                int seconds must be greater than 0 and less than 59
     * @throws IllegalArgumentException Indicates that minutes is less than 0 or greater than 59
     **/

    public void setSeconds(int seconds) {

        try{

            if (seconds < 0 || seconds > 59) {
                throw new IllegalArgumentException();
            }
            else {
                this.seconds = seconds;
            }

        }
        catch(IllegalArgumentException ex){
            System.out.println("Number should be between 0 and 59");
        }


    }

    /**
     * toString() method for SongRecord
     * Returns members of Song Record in a formatted table
     *
     * @return A String containing the Song Record members
     */

    @Override
    public String toString() {

        String print = "\t\t" + this.title
                + "\t\t" + this.artist
                + "\t\t" + this.minutes + ":"
                + this.seconds;
        return print;
    }
}



