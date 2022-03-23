package com.flowcode;

import com.flowcode.model.Artist;
import com.flowcode.model.Datasource;
import com.flowcode.model.SongArtist;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Datasource datasource = new Datasource();
        if(!datasource.open()){
            System.out.println("Cant open datasource");
            return;
        }

        List<Artist> artists = datasource.queryArtists(5);
        if(artists == null){
            System.out.println("No Artists!");
            return;
        }

        for(Artist object : artists){
            System.out.println("ID: " + object.getId() + ", NAME: " + object.getName());
        }

        System.out.println("===============================================================");

        List<String> albumsForArtist =
                datasource.queryAlbumsForArtist("Carole King", Datasource.ORDER_BY_ASC);
        for(String o : albumsForArtist){
            System.out.println(o);
        }

        System.out.println("===============================================================");

        List<SongArtist> songArtists = datasource.queryArtistForSong("Go Your Own Way", Datasource.ORDER_BY_DESC);
            if (songArtists == null) {
                System.out.println("Couldn't find the artist for the song");
                return;
            }
        System.out.println();
        for(SongArtist o : songArtists){
            System.out.println("Artists name: " + o.getArtistName() + " --- Album name: " + o.getAlbumName() + " --- Track: " + o.getTrack());
        }
        System.out.println("\n=============================================");
        datasource.querySongsMetadata();
        System.out.println("\n=============================================");

        int count = datasource.getCount(Datasource.TABLE_SONGS);
        System.out.println("Number of songs is: " + count);

        datasource.close();

    }
}
