/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Database.Database;
import Model.Album;
import Model.AlbumToOrder;
import Model.Artist;
import Model.Customers;
import Model.Genre;
import Model.OrderLine;
import Model.PlateType;
import Model.Supplier;
import UtilityStuff.Listeners;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author markh
 */
public class AlbumControl {

    private static AlbumControl albumControl;
    private Database database;
    private Listeners listeners;
    private int currentId;

    private AlbumControl() throws ClassNotFoundException, SQLException {
        database = new Database();
        listeners = Listeners.getList();
        currentId = 0;

    }

    public static AlbumControl getInstance() throws ClassNotFoundException, SQLException {
        if (albumControl == null) {
            albumControl = new AlbumControl();
        }
        return albumControl;
    }
    

    public Album getAlbum(int albumid) {
        Album album = null;

        try {
            ResultSet rs = database.query("call getalbum("+ albumid +");");
            while (rs.next()) {
                PlateType plateType = new PlateType(rs.getInt("pt_id"), rs.getString("pt_type"));
                Supplier supplier = new Supplier(rs.getInt("su_cvrnumber"), rs.getString("su_name"), rs.getString("su_street"), rs.getInt("su_tlf"), rs.getString("su_mail"));
                Artist artist = new Artist(rs.getInt("ar_id"), rs.getString("ar_name"));
                Genre genre = new Genre(rs.getInt("ge_id"), rs.getString("ge_type"));
                album = new Album(rs.getInt("al_id"), rs.getString("al_title"), rs.getString("al_picturepath"), rs.getInt("al_stock"), rs.getInt("al_suppprice"), rs.getInt("al_saleprice"), rs.getInt("al_songamount"), plateType, supplier, artist, genre);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AlbumControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return album;
    }
    
    public void updateStock(Album album, int amount){
        try{
            database.change("call updatestock("+album.getId()+","+amount+")");
        }catch (SQLException ex){
            Logger.getLogger(AlbumControl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void createNewAlbum(Album a){
        try{
            ResultSet rs = database.query("call createnewalbum("+a.getTitle()+","+a.getPicturePath()+","+a.getStock()+","+a.getSupplierPrice()+","+a.getSalePrice()+","+a.getSongNumbers()+","+a.getPlateType().getId()+","+a.getSupplier().getCvrNumber()+","+a.getArtist().getId()+","+a.getGenre().getId()+")");
            while (rs.next()){
                currentId = rs.getInt("nextid");
            }
        } catch (SQLException ex) {
            Logger.getLogger(AlbumControl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
