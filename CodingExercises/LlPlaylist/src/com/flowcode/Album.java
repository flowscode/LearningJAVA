package com.flowcode;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String albumName;
    private ArrayList<Song> songs = new ArrayList<Song>();
    private ArrayList<String> trackList = new ArrayList<String>();
    private int numberOfSongs;

    public Album(String albumName) {
        this.albumName = albumName;
    }

    public String getAlbumName() {
        return albumName;
    }

    public ArrayList<Song> getSongs() {
        return songs;
    }

    public ArrayList<String> getTrackList() {
        return trackList;
    }

    public int getNumberOfSongs() {
        return numberOfSongs;
    }

    public void createTrackList(Album album){
        album.trackList.clear();
        for (Song song: album.songs) {
            album.trackList.add(song.getTitle());
        }
    }

}
