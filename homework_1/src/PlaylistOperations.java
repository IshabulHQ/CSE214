import java.util.Scanner;


/** Class Description
 *  Write a fully documented class named PlaylistOperations that is based on the following
 *  specification:
 */

/**
 * This class cotains informatio about a particulr audio file
 * Contains title name, artist name, song's lenngth in minutes and seconds
 *
 * @author Ishabul Haque
 **/


public class PlaylistOperations  {



    /**
     * printToScreen() Prints out playlist keyboard controls
     * by prompting a menu command selecting the operation
     *
     * @precondition This PlayList object has been instantiated.
     * @return The number of SongRecords in this Playlist.
     */

    private static void printToScreen() {
        System.out.print("\nA) Add Song\n" +
                "B) Print Songs by Artist \n" +
                "G) Get Song \n" +
                "R) Remove Song \n" +
                "P) Print All Songs \n" +
                "S) Size:  \n" +
                "Q) Quit \n\n" +
                "Extra Credit Options: \n"+
                "N) Create new playlist: \n"+
                "V) Change current playlist: \n" +
                "C) Copy current playlist to new one: \n" +
                "E) Compare songs in current playlist with given playlist: \n " +
                "D) Display all playlist names: \n\n" +
                "Select a menu option: " );

    }

    public static void main(String[] args) throws FullPlaylistException {




        String title,artist,name;
        int minutes,seconds,position;

        //Int variable used to access playlists in playlist handler
        int target = 1;

        // Boolean used to monitor program's continuity

        boolean status = true;

        //Object used to store SongRecords
        Playlist playlist = new Playlist();

        // Object used to store playlists

        PlaylistHandler playlistArr = new PlaylistHandler();
        // Adds first/default playlist to playlist handler

        playlistArr.addPlaylist(playlist,target);

        //Int variable used to monitor total number of playlists
        int counter = 1;


        while(status) {

            printToScreen();
            Scanner sc = new Scanner(System.in);
            String input = sc.nextLine().toUpperCase();


                switch(input) {
                    case "A":

                        // Input Commands to add params to SonngRecord object

                        System.out.println(" ");
                        System.out.print("\nEnter the song title: ");
                        title = sc.nextLine();
                        System.out.print("\nEnter the song artist: ");
                        artist = sc.nextLine();


                            System.out.print("\nEnter the song length (minutes): ");
                            minutes = sc.nextInt();
                            System.out.print("\nEnter the song length (seconds): ");
                            seconds = sc.nextInt();


                        System.out.print("\nEnter the position: ");
                        position = sc.nextInt();

                        SongRecord song1 = new SongRecord(title,artist,minutes,seconds);
                        // Add songRecord object to playlist
                        playlistArr.getPlaylist(target).addSong(song1, position);
                        System.out.println("\nSong Added Title: "+song1.getTitle()+" by: "+song1.getArtist()+
                                " at position "+ position + "." + "to playlist: " + playlistArr.getName(target));

                        break;

                    case "B":

                        //getSongByArtist method called by taking in user input as artist param and
                        // selecting current playlist

                        System.out.println("Enter the artist: ");
                        artist = sc.nextLine();
                        playlistArr.getPlaylist(target).getSongByArtist(playlist, artist).printAllSongs();


                        break;

                    case "G":

                         //getSong method called by taking in user input as position param


                        System.out.println();
                        System.out.print("Enter the position: ");
                        position = sc.nextInt();

                        if(position <= 0 || position > playlist.size()){
                            System.out.println("No song at position: " + position);
                        }
                        else{
                            playlistArr.getPlaylist(target).printToDisplay();
                            System.out.println(position + " " + playlistArr.getPlaylist(target).getSong(position));

                        }

                        break;

                    case "R":

                        // Takes user input as position param for removeSong method

                        System.out.println("Enter the position: ");
                        position = sc.nextInt();
                        playlistArr.getPlaylist(target).removeSong(position);
                        break;

                    case "P":

                        //Calls printAllSongs method

                        playlistArr.getPlaylist(target).printAllSongs();
                        break;

                    case "S":

                        // Calls size methood

                        System.out.println("There are " +
                                playlistArr.getPlaylist(target).size() + " song(s) in the current playlist");
                        break;

                    case "Q":

                        // Terminates the program by exiting the while loop

                        System.out.println("Program terminating normally...");
                        status = false;
                        break;

                    case "N":

                        // Creates new playlist and adds to playlist handler
                        // with addName and addPlaylist method

                        System.out.print("Input new Playlist Name:");
                        name = sc.nextLine();
                        Playlist generatedPlaylist = new Playlist();
                        playlistArr.addName(name,counter);
                        counter++;
                        target = counter;
                        playlistArr.addPlaylist(generatedPlaylist,target);
                        System.out.println("Now on playlist: " + name);
                        break;

                    case "V":

                        // Uses .getNamePos to get position of playlist name
                        // in name array and use it to access desired playlist
                        // by manipulating target int to select playlist

                        System.out.print("Input playlist name to change to: ");
                        name = sc.nextLine();
                        target = playlistArr.getNamePos(name);
                        System.out.println(target);
                        System.out.println("Now on playlist: " + name);

                        break;

                    case "C":

                        System.out.print("Input new playlist name:  ");
                        name = sc.nextLine();
                        generatedPlaylist = playlistArr.getPlaylist(target);
                        playlistArr.addName(name,counter);
                        counter++;
                        target = counter;
                        playlistArr.addPlaylist(generatedPlaylist,target);
                        System.out.println("Now on playlist: " + name);


                        break;
                    case "E":

                        // Compares selected and current playlist using the equals method

                        System.out.print("Input playlist name to compare to current one:  ");
                        name = sc.nextLine();
                        int temp = playlistArr.getNamePos(name);
                        boolean message = playlistArr.getPlaylist(target).equals(playlistArr.getPlaylist(temp));
                        String truth = "";
                        if(message = true){
                             truth = "the same";
                        }
                        else{
                             truth = "not the same";
                        }

                        System.out.println("Playlist: " + playlistArr.getPlaylist(target) +
                                " and Playlist: " + playlistArr.getPlaylist(temp) +
                                " are " + truth);



                        break;
                    case "D":

                        // Prints out all playlist names by accessing name playlist using counter

                        for(int i = 0; i < counter; i++){
                            System.out.println("Playlist " + (i+1) + ": " + playlistArr.getName(i+1) + "\n");

                        }
                        break;

                    default:

                        // Default Message

                        System.out.println("\nInvalid menu option");
                        break;

                }
        }

    }
}
