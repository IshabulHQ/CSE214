import java.io.*;




/**
 * This class cotains information about a Playlist Handler holding Playlists
 *
 * @author Ishabul Haques
 **/


public class PlaylistHandler {

    private Playlist[] playlistArr;
    private int playlistSize;
    private static final int maxPlaylists = 50;
    private String[] nameArray = new String[maxPlaylists];




    /**
     * This is a Constructor used to create a new SongRecord object
     */

    public PlaylistHandler(){
        playlistSize = 0;
        playlistArr = new Playlist[playlistSize];
        nameArray[0] = "default";

    }

    /**
     * playListSize() Returns the size of the Playlist Handler
     * @return Returns the size of the playlist handler
     * Otherwise, the return value is false.
     */

    public int playListSize(){
        return this.playlistSize;
    }

    /**
     * addName() Adds playlist name to array of playlist names
     * @param name - String of playlist name
     * position - the position in the playlist handler where the name will be inserted
     * @precondition This playlist object has been instantiated and 1 < position
     * < songs_currently_in_playlisthandler + 1. The number of playlist objects in this
     * Playlist Handler is less than max_playlists.
     * @postcondition The new playlist name is now stored at the desired position in
     * the Playlist Handler.
     * @throws IllegalArgumentException
     * Indicates that position is not within the valid range.
     * @throws FullPlaylistException
     * Indicates that there is no more room inside of the Playlist to store the new
     * SongRecord object.
     */

    public void addName(String name, int position) throws FullPlaylistException{

        try{
            if(playlistSize == maxPlaylists){
                throw new FullPlaylistException();
            }
            else if(position <= 0 || position > maxPlaylists + 1){
                throw new IllegalArgumentException();
            }
            else{
                nameArray[position] = name;
            }

        }
        catch (IllegalArgumentException ex){

            System.out.println("Position is not within valid range");


        }
        catch(FullPlaylistException ex){

            System.out.println("There is no more room inside of Playlist Handler to store the new Playlist");
        }


    }

    /**
     * getName() Get the name of a Playlist the given position in this
     * Playlist Handler.
     * @param position - position of the Playlist Handler to retrieve
     * @precondition This Playlist Handler has been instantiated and 1 < position <
     * songs_currently_in_playlist.
     * @return The Playlist name at the specified position in this Playlist Handler.
     * @throws IllegalArgumentException
     * Indicates that position is not within the valid range.
     */

    public String getName(int position){

        try {

            if(position <= 0 || position > maxPlaylists){
                throw new IllegalArgumentException();
            }

            else{
                return nameArray[position-1];
            }
        }
        catch (IllegalArgumentException ex){

            System.out.println("Position is not within valid range");


        }
        return null;


    }

    /**
     * getNamePos() Get the position of a Playlist in the handler by name
     * Playlist Handler.
     * @param name - name of the Playlist  to retrieve
     * @precondition This Playlist Handler has been instantiated and 1 < position <
     * songs_currently_in_playlist.
     * @return The Playlist name at the specified position in this Playlist Handler.
     */

    public int getNamePos(String name){
        for(int i = 0; i < nameArray.length; i++){
            if(nameArray[i].equals(name)){
                return i+1;
            }

        }
        return -1;
    }


    /**
     * addPlaylist() Determines the number of Playlist currently in this Playlist
     * Handler
     * @param playlist - the new Playlist object to add to this Playlist Handler
     * position - the position in the playlist where the song will be inserted
     * @precondition This Playlist object has been instantiated and 1 < position
     * < songs_currently_in_playlist_handler + 1. The number of playlist objects in this
     * Playlist Handler is less than max_playlists.
     * @postcondition The new playlist is now stored at the desired position in
     * the Playlist Handler. All Playlist that were originally in positions greater than
     * or equal to position are moved back one position.
     * @throws IllegalArgumentException
     * Indicates that position is not within the valid range.
     * @throws FullPlaylistException
     * Indicates that there is no more room inside of the Playlist to store the new
     * SongRecord object.
     */

    public void addPlaylist(Playlist playlist,int position ) throws FullPlaylistException{

        try {

            if(playlistSize == maxPlaylists){
                throw new FullPlaylistException();
            }
            else if(position <= 0 || position > playlistSize + 1){
                throw new IllegalArgumentException();
            }

            else{
                this.playlistSize++;
                Playlist[] newPlaylistArr = new Playlist[playlistSize];

                System.arraycopy(playlistArr, 0, newPlaylistArr, 0, position-1);
                System.arraycopy(playlistArr, position-1, newPlaylistArr, position, playlistSize - position);

                newPlaylistArr[position-1] = playlist;
                playlistArr = newPlaylistArr;
            }

        }
        catch (IllegalArgumentException ex){

            System.out.println("Position is not within valid range");


        }
        catch(FullPlaylistException ex){

            System.out.println("There is no more room inside of PlaylistHandler to store the new PlayList");
        }


    }

    /**
     * getPlaylist() Get the Playlist at the given position in this Playlist Handler
     * object.
     * @param position - position of the playlist to retrieve
     * @precondition This Playlist Handler object has been instantiated and
     * 1 < position < songs_currently_in_playlisthandler.
     * @return The playlist at the specified position in this Playlist Handler object.
     * @throws IllegalArgumentException
     * Indicates that position is not within the valid range.
     */


    public Playlist getPlaylist(int position){

        try {

            if(position <= 0 || position > playlistSize){
                throw new IllegalArgumentException();
            }

            else{
                return this.playlistArr[position - 1];
            }
        }
        catch (IllegalArgumentException ex){

            System.out.println("Position is not within valid range");


        }
        return null;

    }
}
