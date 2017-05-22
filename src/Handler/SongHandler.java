/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Handler;

import Control.SongControl;
import Model.Artist;
import Model.Genre;
import Model.Lyric;
import Model.PlateType;
import Model.Supplier;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author markh
 */
public class SongHandler {

    private static SongHandler lyricsong;
    private SongControl songControl;
    private ArrayList<Lyric> addedLyric;

    private SongHandler() throws ClassNotFoundException, SQLException {
        songControl = SongControl.getInstance();
        addedLyric = new ArrayList<>();
    }

    public static SongHandler getInstance() throws ClassNotFoundException, SQLException {
        if (lyricsong == null) {
            lyricsong = new SongHandler();
        }
        return lyricsong;
    }

    public ArrayList<Lyric> getAllLyric() {
        return songControl.getAllLyric();
    }

    public ArrayList<Supplier> getAllSupplier() {
        return songControl.getAllSupplier();
    }

    public ArrayList<PlateType> getAllPlatetype() {
        return songControl.getAllPlatetype();
    }
    
    public ArrayList<Artist> getAllArtist() {
        return songControl.getAllartist();
    }
    
    public ArrayList<Genre> getAllGenre() {
        return songControl.getAllGenre();
    }
    
    public void addSongsToNewALbum(Lyric lyric){
        addedLyric.add(lyric);
        System.out.println("Added");
    }
    
    public void removeSongsFromNewAlbum(Lyric lyric){
        for (int i = 0; i < addedLyric.size(); i++) {
            if (addedLyric.get(i).equals(lyric)) {
                addedLyric.remove(i);
            }
        }
        System.out.println("Remove");
    }
    
    public ArrayList<Lyric> getSongsToNewAlbum(){
        return addedLyric;
    }

}
