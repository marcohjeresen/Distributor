/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Handler;

import Control.SongControl;
import Model.Lyric;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author markh
 */
public class SongHandler {
    
    private static SongHandler lyricHandler;
    private SongControl lyricControl;

    private SongHandler() throws ClassNotFoundException, SQLException {
        lyricControl = SongControl.getInstance();
    }
    
    public static SongHandler getInstance() throws ClassNotFoundException, SQLException{
        if (lyricHandler == null) {
            lyricHandler = new SongHandler();
        }
        return lyricHandler;
    }
    
    public ArrayList<Lyric> getAllLyric(){
        return lyricControl.getAllLyric();
    }
    
    
}
