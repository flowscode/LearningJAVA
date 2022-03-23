package com.flowcode;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        //  Created Array to hold all Albums
        ArrayList<Album> albums = new ArrayList<>();

        // Created New Album
        Album joshAlbum1 = new Album("Josh Album 1");
        Album joshAlbum2 = new Album("Josh Album 2");

        // Added album to list of Albums
        albums.add(joshAlbum1);
        albums.add(joshAlbum2);

        // Created Songs to add to albums
        Song song1 = new Song("Hello",3.45);
        Song song2 = new Song("Red Light",2.59);
        Song song3 = new Song("Vibe",3.29);
        Song song4 = new Song("May I", 3.36);
        Song song5 = new Song("Hold On", 3.56);
        Song song6 = new Song("New Day", 2.58);
        Song song7 = new Song("Maybe", 3.46);
        Song song8 = new Song("You Not Me", 3.54);
        Song song9 = new Song("Holly Wood", 3.22);
        Song song10 = new Song("Never Later", 3.40);


        // Added songs to Albums
        joshAlbum1.getSongs().add(song1);
        joshAlbum1.getSongs().add(song2);
        joshAlbum1.getSongs().add(song3);
        joshAlbum1.getSongs().add(song4);
        joshAlbum1.getSongs().add(song5);

        joshAlbum2.getSongs().add(song6);
        joshAlbum2.getSongs().add(song7);
        joshAlbum2.getSongs().add(song8);
        joshAlbum2.getSongs().add(song9);
        joshAlbum2.getSongs().add(song10);

        // create Track lists
        joshAlbum1.createTrackList(joshAlbum1);
        joshAlbum2.createTrackList(joshAlbum2);

        // Create Playlist
        LinkedList<Song> myPlaylist = new LinkedList<>();

        // Print Album names & Tracks
        int i = 1;
        for (Album album: albums) {
            System.out.println("Album number [" + i + "] : " + album.getAlbumName());
            System.out.println("Tracks : " + album.getTrackList() +
                             "\n--------------------------------------------------------");
            i++;
        }

        // Added songs to myPlaylist
        myPlaylist.add(albums.get(0).getSongs().get(0));
        myPlaylist.add(albums.get(0).getSongs().get(1));
        myPlaylist.add(albums.get(0).getSongs().get(2));

        myPlaylist.add(albums.get(1).getSongs().get(0));
        myPlaylist.add(albums.get(1).getSongs().get(1));
        myPlaylist.add(albums.get(1).getSongs().get(2));

        startPlaylist(myPlaylist);

    }


    private static void printMenu(){
        System.out.println("""
                                        
                        ------------ Playlist Menu ------------
                        [1] Previous Song
                        [2] Next Song
                        [3] Replay Current Song
                        [4] List Songs in Playlist
                        [5] Remove Current Song
                        [6] Print Menu
                        [7] Quit
                        ---------------------------------------
                        """);
    }

    //@SuppressWarnings("ConstantConditions")
    private static void startPlaylist(LinkedList<Song> playlist){
        // Add Scanner to take input
        Scanner scanner = new Scanner(System.in);

        // Quit (set to [true] within the while loop to stop while loop)
        boolean quit = false;

        // Check direction
        boolean goingForward = true;

        // create iterator to traverse through [playlist] and interact with songs in playlist
        ListIterator<Song> listIterator = playlist.listIterator();

        if (playlist.getFirst() == null){
            System.out.println("No songs in playlist");
            return;
        } else {
            printMenu();
            System.out.println("Now playing: " + listIterator.next().getTitle());
        }

        while (!quit) {
            int option = 0;
            System.out.print("\nOPTION: ");
            try {
                option = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException inputMismatchException) {
                scanner.next();
            }
            switch (option){
                    // check if last option was going previous, if it was then check if list has a [next]
                    // if it also has a [next] then move the [iterator] [next] to use up that extra space,
                    // ready to go to the next object for real
                    // if there is no next then just  set the direction to true
                    // (same for previous just  the other direction. it's all about using up that addition space when moving
                    // with the [iterator])
                // NEXT SONG
                case 2 :
                    if (!goingForward){
                        if (listIterator.hasNext()){
                            listIterator.next();
                        }
                        goingForward = true;
                    }
                    if (listIterator.hasNext()){
                        System.out.println("[NEXT] Now Playing: " + listIterator.next().getTitle());
                    } else {
                        System.out.println("No Next Song");
                    }
                    break;
                // PREVIOUS SONG
                case 1 :
                    if (goingForward){
                        if (listIterator.hasPrevious()){
                            listIterator.previous();
                        }
                        goingForward = false;
                    }
                    if(listIterator.hasPrevious()){
                        System.out.println("[PREVIOUS] Now playing: " + listIterator.previous().getTitle());
                    } else {
                        System.out.println("No Previous Song");
                    }
                    break;
                // REPLAY SONG
                case 3 :
                    if (goingForward){
                        if(listIterator.hasPrevious()){
                            System.out.println("[REPLAY] Now playing: " + listIterator.previous().getTitle());
                            listIterator.next();
                        } else {
                            System.out.println("Cannot Replay Song");
                        }
                    }
                    if (!goingForward){
                        listIterator.next();
                        if(listIterator.hasPrevious()){
                            System.out.println("[REPLAY] Now playing: " + listIterator.previous().getTitle());
                        } else {
                            System.out.println("Cannot Replay Song");
                        }
                    }
                    break;
                case 4 :
                    int trackNumber = 1;
                    System.out.println("------- List Songs in Playlist -------");
                    for (int i = 0; i < playlist.size() ; i++){
                        System.out.println(trackNumber + "). " + playlist.listIterator(i).next().getTitle());
                        trackNumber++;
                    }
                    break;
                // REMOVE CURRENT SONG
                case 5 :
                    if (playlist.size() > 0) {
                        System.out.println("REMOVED : " + listIterator.previous().getTitle());
                        listIterator.remove();
                        if (listIterator.hasNext()){
                            System.out.println("Now playing : " + listIterator.next().getTitle());
                        } else if (listIterator.hasPrevious()){
                            System.out.println("Now playing : " + listIterator.previous().getTitle());
                        } else {
                            System.out.println("List is empty...");
                        }
                    } else {
                        System.out.println("List is empty...");
                    }
                    break;
                case 6 :
                    printMenu();
                    break;
                case 7 :
                    System.out.println("Quit");
                    quit = true;
                    break;
                default:
                    System.out.println("OUT OF SCOPE OPTION");
                    break;
            }
        }
    }
}