/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Handler;

import Control.SongControl;
import Model.Album;
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
    private Artist selectedArtist;
    private PlateType selectedPlatetype;
    private Genre selectedGenre;
    private Supplier selectedSupl;

    private SongHandler() throws ClassNotFoundException, SQLException {
        songControl = SongControl.getInstance();
        addedLyric = new ArrayList<>();
        selectedArtist = null;
        selectedPlatetype = null;
        selectedGenre = null;
        selectedSupl = null;
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
    }
    
    public void removeSongsFromNewAlbum(Lyric lyric){
        for (int i = 0; i < addedLyric.size(); i++) {
            if (addedLyric.get(i).equals(lyric)) {
                addedLyric.remove(i);
            }
        }
    }
    
    
     public ArrayList<Lyric> getSongsToNewAlbum(){
        return addedLyric;
    }   
     
    public void setSelectedArtist(Artist artist){
        selectedArtist = artist;
    }
    
    public void setSelectedGenre(Genre genre){
        selectedGenre = genre;
    }
    
    public void setSelectedPlateType(PlateType plateType){
        selectedPlatetype = plateType;
    }
    
    public void setSelectedSupl(Supplier supplier){
        selectedSupl = supplier;
    }
    
    public void createNewAlbum(String title, String pict, int stock, int suppPrice, int salePrice){
        Album a = new Album(0, title, pict, stock, suppPrice, salePrice, addedLyric.size(), selectedPlatetype, selectedSupl, selectedArtist, selectedGenre);
    }
    

    


}
