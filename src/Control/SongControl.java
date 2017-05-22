/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Database.Database;
import Model.Artist;
import Model.Genre;
import Model.Lyric;
import Model.PlateType;
import Model.Supplier;
import com.sun.org.apache.bcel.internal.generic.AALOAD;
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

    public static SongControl getInstance() throws ClassNotFoundException, SQLException {
        if (songControl == null) {
            songControl = new SongControl();
        }
        return songControl;
    }

    public ArrayList<Lyric> getAllLyric() {
        ArrayList<Lyric> lyricList = new ArrayList<>();
        try {
            ResultSet rs = database.query("call getalllyric();");
            while (rs.next()) {
                Lyric lyric = new Lyric(rs.getInt("ly_id"), rs.getString("ly_title"), rs.getString("ly_text"));
                lyricList.add(lyric);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SongControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lyricList;
    }

    public ArrayList<Supplier> getAllSupplier() {
        ArrayList<Supplier> suppliers = new ArrayList<>();
        try {
            ResultSet rs = database.query("call getallsupplier();");
            while (rs.next()) {
                Supplier s = new Supplier(rs.getInt("su_cvrnumber"), rs.getString("su_name"), rs.getString("su_street"), rs.getInt("su_tlf"), rs.getString("su_mail"));
                suppliers.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SongControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return suppliers;
    }

    public ArrayList<Artist> getAllartist() {
        ArrayList<Artist> artistList = new ArrayList<>();
        try {
            ResultSet rs = database.query("call getallartist();");
            while (rs.next()) {
                Artist a = new Artist(rs.getInt("ar_id"), rs.getString("ar_name"));
                artistList.add(a);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SongControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return artistList;
    }

    public ArrayList<Genre> getAllGenre() {
        ArrayList<Genre> genreList = new ArrayList<>();
        try {
            ResultSet rs = database.query("call getallgenre();");
            while (rs.next()) {
                Genre g = new Genre(rs.getInt("ge_id"), rs.getString("ge_type"));
                genreList.add(g);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SongControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return genreList;
    }

    public ArrayList<PlateType> getAllPlatetype() {
        ArrayList<PlateType> plateTypeListy = new ArrayList<>();
        try {
            ResultSet rs = database.query("call getallplatetype();");
            while (rs.next()) {
                PlateType pt = new PlateType(rs.getInt("pt_id"), rs.getString("pt_type"));
                plateTypeListy.add(pt);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SongControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return plateTypeListy;
    }

}
