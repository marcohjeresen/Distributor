/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Database.Database;
import Model.Lyric;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author markh
 */
public class SongControl {
    
    private static SongControl songControl;
    private Database database;

    private SongControl() throws ClassNotFoundException, SQLException {
        database = new Database();
    }
    
    
    public static SongControl getInstance() throws ClassNotFoundException, SQLException{
        if (songControl == null) {
            songControl = new SongControl();
        }
        return songControl;
    }
    
    
    public ArrayList<Lyric> getAllLyric(){
        ArrayList<Lyric> lyricList = new ArrayList<>();
        try{
            ResultSet rs = database.query("call getalllyric();");
            while (rs.next()){
                Lyric lyric = new Lyric(rs.getInt("ly_id"), rs.getString("ly_title"), rs.getString("ly_text"));
                lyricList.add(lyric);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SongControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lyricList;
    }
    
    
}
