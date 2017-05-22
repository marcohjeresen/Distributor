/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Database.Database;
import Model.Customers;
import UtilityStuff.Listeners;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author markh
 */
public class CustomerControl {
    
    private static CustomerControl customerControl;
    private Database database;
    private Listeners listeners;
    private Customers customers;

    private CustomerControl() throws ClassNotFoundException, SQLException {
        database = new Database();
        listeners = Listeners.getList();
        customers = null;
    }
    
    public static CustomerControl getInstance() throws ClassNotFoundException, SQLException{
        if (customerControl == null) {
            customerControl = new CustomerControl();
        }
        return customerControl;
    }
    
    public Customers getCustomer(Customers customers){
        customers = null;
        try {
            ResultSet rs = database.query("call getcustomer("+ customers.getCvrNumber() +");");
            while (rs.next()){
                customers = new Customers(rs.getInt("cu_cvrnumber"), rs.getString("cu_name"), rs.getString("cu_storechain"), rs.getString("cu_street"), rs.getInt("cu_tlf"), rs.getString("cu_mail"));
            }
        }catch (SQLException ex){
           Logger.getLogger(CustomerControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return customers;
    }
    
    
    
    
}
