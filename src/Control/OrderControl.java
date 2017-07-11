/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Database.Database;
import Model.Album;
import Model.AlbumToOrder;
import Model.Customers;
import Model.OrderLine;
import UtilityStuff.Listeners;
import UtilityStuff.SendMail;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;

/**
 *
 * @author markh
 */
public class OrderControl {

    private static OrderControl orderControl;
    private Database database;
    private Customers customers;
    private OrderLine orderLine;
    private Listeners listeners;
    private AlbumControl albumControl;

    private OrderControl() throws ClassNotFoundException, SQLException {
        this.database = new Database();
        listeners = Listeners.getList();
        this.customers = null;
        this.orderLine = null;
        this.albumControl = AlbumControl.getInstance();
    }

    public static OrderControl getInstance() throws ClassNotFoundException, SQLException {
        if (orderControl == null) {
            orderControl = new OrderControl();
        }
        return orderControl;
    }

    public ArrayList<OrderLine> getActiveOrders() {
        ArrayList<OrderLine> activeOrders = new ArrayList<>();

        try {
            ResultSet rs = database.query("call getallactiveorder();");
            while (rs.next()) {
                customers = new Customers(rs.getInt("cu_cvrnumber"), rs.getString("cu_name"), rs.getString("cu_storechain"), rs.getString("cu_street"), rs.getInt("cu_tlf"), rs.getString("cu_mail"));
                orderLine = new OrderLine(rs.getInt("or_id"), rs.getDate("or_date"), customers, rs.getInt("or_totalprice"), rs.getBoolean("or_orderend"));
                activeOrders.add(orderLine);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (OrderLine activeOrder : activeOrders) {
            activeOrder.setAlbumList(getAlbumToOrders(activeOrder));
        }
        return activeOrders;
    }

    public ArrayList<AlbumToOrder> getAlbumToOrders(OrderLine orderLine) {
        OrderLine tempOrderLine = orderLine;
        ArrayList<AlbumToOrder> albumToOrdersList = new ArrayList<>();
        try {
            ResultSet rs = database.query("call getalbumtoorder("+ orderLine.getId() +");");
            while (rs.next()) {
                Album album = albumControl.getAlbum(rs.getInt("al_id"));
                AlbumToOrder albumToOrder = new AlbumToOrder(album, orderLine, rs.getInt("ao_amount"), rs.getInt("ao_price"));
                albumToOrdersList.add(albumToOrder);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return albumToOrdersList;
    }
    
    public void acceptOrder(int orderid, String email){
        try{
            database.change("call acceptorder("+orderid+")");
            SendMail mail = new SendMail(email,"prøve");
        }catch (SQLException ex){
            Logger.getLogger(CustomerControl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(OrderControl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
