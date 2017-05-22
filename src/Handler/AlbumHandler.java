/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Handler;

import Control.AlbumControl;
import Model.Album;
import Model.OrderLine;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author markh
 */
public class AlbumHandler {
    
    private static AlbumHandler albumHandler;
    private AlbumControl albumControl;

    private AlbumHandler() throws ClassNotFoundException, SQLException {
        albumControl = AlbumControl.getInstance();
    }
    
    public static AlbumHandler getInstance() throws ClassNotFoundException, SQLException{
        if (albumHandler == null) {
            albumHandler = new AlbumHandler();
        }
        return albumHandler;
    }
    
    
    public Album getAlbum(int albumid){
        return albumControl.getAlbum(albumid);
    }
    
}
