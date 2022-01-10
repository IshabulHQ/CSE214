/**
 * @author Ishabul Haque
 **/

public class FullPlaylistException extends Exception {
    /**
     * FullPlaylistExcpetion() Indicates that there is no more
     * room inside of the Playlist to store the new SongRecord object.
     * @postcondition Throws an error Saying Playlist is Full
     */
    public FullPlaylistException(){
        super("Playlist Full.");
    }

    public FullPlaylistException(String message){
        // Passed message
        super(message);
    }

}