/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Handler;

import Control.SongControl;
import Model.Lyric;
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

    private SongHandler() throws ClassNotFoundException, SQLException {
        songControl = SongControl.getInstance();
    }
    
    public static SongHandler getInstance() throws ClassNotFoundException, SQLException{
        if (lyricsong == null) {
            lyricsong = new SongHandler();
        }
        return lyricsong;
    }
    
    public ArrayList<Lyric> getAllLyric(){
        return songControl.getAllLyric();
    }
    
    public ArrayList<Supplier> getAllSupplier(){
        return songControl.getAllSupplier();
    }
    
    
}
