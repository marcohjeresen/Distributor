/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Handler;

import Control.OrderControl;
import Model.OrderLine;
import UtilityStuff.Listeners;
import java.sql.SQLException;
import java.util.ArrayList;



/**
 *
 * @author markh
 */
public class OrderHandler {
    
    private static OrderHandler orderHandler;
    private OrderControl orderControl;
    private OrderLine choosenOrderLine;
    private Listeners listeners;

    public OrderHandler() throws ClassNotFoundException, SQLException {
        orderControl = OrderControl.getInstance();
        choosenOrderLine = null;
        listeners = Listeners.getList();
    }
    
    public static OrderHandler getInstance() throws ClassNotFoundException, SQLException{
        if (orderHandler == null) {
            orderHandler = new OrderHandler();
        }
        return orderHandler;
    }
    
    
    public ArrayList<OrderLine> getActiveOrders(){
        return orderControl.getActiveOrders();
    }
    
    public void setChoosenOrderline(OrderLine orderLine){
        choosenOrderLine = orderLine;
        listeners.notifyListeners("Order Selected");
    }
    
    public OrderLine getChoosenOrder(){
        return choosenOrderLine;
    }
    
    
    
}
