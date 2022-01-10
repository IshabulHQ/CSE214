import java.io.*;

/** Original Class Description
 * Write a fully-documented class named Playlist that stores all SongRecord
 * objects that belong to a particular playlist. The SongRecord objects should
 * be stored in an array. There should be a maximum of 50 SongRecord objects allowed,
 * a number which should be defined as a final variable. The class will be based on
 * the following ADT specification:
 */

/**
 * This class cotains information about a Playlist holding songRecords
 * Methods Used: clone(), addSoong(),equals(),size(),removeSong(),getSog(),
 * printAllSogs(),getSongsByArtist(),toString()
 *
 * @author Ishabul Haque
 **/


public class Playlist implements Cloneable {

    private SongRecord[] songRecord;
    private String name;
    private int size;
    private static final int maxSongs = 50;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Playlist() constructs an instance of Playlist class
     * with no SongRecord objects in it
     *
     * @PostCondition An empty Playlist of Song Records
     */

    public Playlist() {
        size = 0;
        songRecord = new SongRecord[size];

    }

    /**
     * clone() Generate a copy of this Playlist.
     *
     * @return The return value is a copy of this Playlist.
     * Subsequent changes to the copy will not affect the original, nor vice versa.
     * Note that the return value must be typecast to a Playlist before it can be used.
     * @throws CloneNotSupportedException Indicates that object is not cloneable
     */

    public Object clone() {

        String error = "Object not Cloneable";
        Playlist clone = new Playlist();

        try {

            clone = (Playlist)super.clone();
            clone.songRecord =  songRecord.clone();
            return clone;


        }
        catch (CloneNotSupportedException ex) {
            return error;
        }
    }

    /**
     * size() Determines the number of SongRecords currently in this Playlist.
     *
     * @precondition This PlayList object has been instantiated.
     * @return The number of SongRecords in this Playlist.
     */

    public int size(){
        return this.size;
    }

    /**
     * addSong() Determines the number of SongRecords currently in this Playlist.
     * @param song - the new SongRecord object to add to this Playlist
     * position - the position in the playlist where the song will be inserted
     * @precondition This SongRecord object has been instantiated and 1 < position
     * < songs_currently_in_playlist + 1. The number of SongRecord objects in this
     * Playlist is less than max_songs.
     * @postcondition The new SongRecord is now stored at the desired position in
     * the Playlist. All SongRecords that were originally in positions greater than
     * or equal to position are moved back one position.
     * @throws IllegalArgumentException
     * Indicates that position is not within the valid range.
     * @throws FullPlaylistException
     * Indicates that there is no more room inside of the Playlist to store the new
     * SongRecord object.
     */

    public void addSong(SongRecord song,int position ) throws FullPlaylistException{

        try {

            if(size == maxSongs){
                throw new FullPlaylistException();
            }
            else if(position <= 0 || position > size + 1){
                throw new IllegalArgumentException();
            }

            else{
                this.size++;
                SongRecord[] newSongRecord = new SongRecord[size];

                System.arraycopy(songRecord, 0, newSongRecord, 0, position-1);
                System.arraycopy(songRecord, position-1, newSongRecord, position, size - position);

                newSongRecord[position-1] = song;
                songRecord = newSongRecord;
            }

        }
        catch (IllegalArgumentException ex){

            System.out.println("Position is not within valid range");


        }
        catch(FullPlaylistException ex){

            System.out.println("There is no more room inside of Playlist to store the new Song");
        }


    }

    /**
     * removeSong() Determines the number of SongRecords currently in this Playlist.
     * @param position - the position in the playlist where the song will be removed
     * from.
     * @precondition This PlayList object has been instantiated and 1 < position <
     * songs_currently_in_playlist.
     * @postcondition The SongRecord at the desired position in the Playlist has been
     * removed. All SongRecords that were originally in positions greater than or equal
     * to position are moved forward one position. (Ex: If there are 5 songs in a Playlist,
     * positions 1-5, and you remove the SongRecord at position 4, the SongRecord that was at
     * position 5 will be moved to position 4).
     * @throws IllegalArgumentException
     * Indicates that position is not within the valid range.
     */

    public void removeSong(int position){
        try {

            if(position <= 0 || position > size){
                throw new IllegalArgumentException();
            }

            else{
                size--;
                SongRecord[] newSongRecord = new SongRecord[size];

                System.arraycopy(songRecord, 0, newSongRecord, 0, position-1);
                System.arraycopy(songRecord, position, newSongRecord, position-1, size-position+1);

                songRecord = newSongRecord;
            }

            System.out.println("Song removed at position " + position);
        }
        catch (IllegalArgumentException ex){

            System.out.println("Position is not within valid range");


        }

    }

    /**
     * getSong() Get the SongRecord at the given position in this Playlist object.
     * @param position - position of the SongRecord to retrieve
     * @precondition This Playlist object has been instantiated and 1 < position <
     * songs_currently_in_playlist.
     * @return The SongRecord at the specified position in this Playlist object.
     * @throws IllegalArgumentException
     * Indicates that position is not within the valid range.
     */

    public SongRecord getSong(int position){

        try {

            if(position <= 0 || position > size){
                throw new IllegalArgumentException();
            }

            else{
                return this.songRecord[position - 1];
            }
        }
        catch (IllegalArgumentException ex){

            System.out.println("Position is not within valid range");


        }
        return null;

    }

    /**
     * printToDisplay() Prints a neatly formatted table header
     * @postcondition A neatly formatted table header is displayed
     */

    public static void printToDisplay() {
        System.out.println(String.format("%s%13s%17s%17s","Song#","Title","Artist","Length"));
        System.out.println("---------------------------------------------------------------------");
    }


    /**
     * printAllSongs() Prints a neatly formatted table of each SongRecord in the
     * Playlist on its own line with its position number as shown in the sample output.
     * @precondition This PlayList object has been instantiated.
     * @postcondition A neatly formatted table of each SongRecord in the Playlist on its
     * own line with its position number has been displayed to the user.
     */

    public void printAllSongs(){

        printToDisplay();
        for(int i = 0; i < size; i++) {
            System.out.print(i + 1);
            System.out.println('\t' + songRecord[i].toString()+ "\n");
        }

    }

    /**
     * getSongByArtist() Generates a new Playlist containing all SongRecords in
     * the original Playlist performed by the specified artist.
     * @param originalList - the original Playlist
     * artist - the name of the artist
     * @precondition The Playlist referred to by originalList has been instantiated.
     * @return A new Playlist object containing all SongRecords in the original
     * Playlist performed by the specified artist.
     */

    public static Playlist getSongByArtist(Playlist originalList, String artist) throws FullPlaylistException{

        if(originalList == null || artist == null){

            return null;

        }

        Playlist answer = new Playlist();
        int count = 1;

        for(int i=1; i<=originalList.size(); i++){
            if(artist.equalsIgnoreCase(originalList.getSong(i).getArtist())){
                answer.addSong(originalList.getSong(i), count++);
            }
        }
        return answer;
    }


    /**
     * toString() Gets the String representation of this Playlist object, which
     * is a neatly formatted table of each SongRecord in the Playlist on its own
     * line with its position number as shown in the sample output
     * @return The String representation of this Playlist object.
     */

    public String toString(){
        return super.toString();

    }

    /**
     * equals() Compare this Playlist to another object for equality.
     *
     * @param obj - an object in which this Playlist is compared
     * @return A return value of true indicates that obj refers to a Playlist
     * object with the same SongRecords in the same order as this Playlist.
     * Otherwise, the return value is false.
     * @throws CloneNotSupportedException Indicates that object is not cloneable
     */

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Playlist && obj != null) {

            Playlist playlist = (Playlist) obj;

            for (int i = 0; i < this.size; i++) {
                if (playlist.size() != this.size) {
                    return false;

                }

                else if (!this.songRecord[i].equals(playlist.songRecord[i]))
                    return false;


            }

        }
        return true;
    }
}




