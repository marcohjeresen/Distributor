/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PanelsView;

import Control.OrderControl;
import Handler.OrderHandler;
import Model.OrderLine;
import PanelsButtom.OrderLineButtom;
import UtilityStuff.Listeners;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author markh
 */
public class OrderView extends javax.swing.JPanel implements ActionListener {

    private OrderHandler orderHandler;
    private Listeners listeners;

    /**
     * Creates new form OrderView
     */
    public OrderView() throws ClassNotFoundException, SQLException {
        orderHandler = OrderHandler.getInstance();
        listeners = Listeners.getList();
        initComponents();
        setSize(new Dimension(685, 506));
        listeners.addListener(this);
        showActiveOrders();
    }

    public void showActiveOrders() throws ClassNotFoundException, SQLException {
        OrderLineButtom olb;
        ArrayList<OrderLine> orderLineList = orderHandler.getActiveOrders();
        jP_activeOrder.removeAll();
        for (int i = 0; i < orderLineList.size(); i++) {
            olb = new OrderLineButtom(orderLineList.get(i));
            jP_activeOrder.add(olb);
            olb.setLocation(0, ((5 * i) + (olb.getHeight() * i)));
            olb.setVisible(true);
            int count = i + 1;
            jP_activeOrder.setPreferredSize(new Dimension(olb.getWidth(), ((5 * count) + (olb.getHeight() * count))));
        }
        jP_activeOrder.revalidate();
        jP_activeOrder.repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScroll_ActiveOrders = new javax.swing.JScrollPane();
        jP_activeOrder = new javax.swing.JPanel();

        setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Active Orders", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        javax.swing.GroupLayout jP_activeOrderLayout = new javax.swing.GroupLayout(jP_activeOrder);
        jP_activeOrder.setLayout(jP_activeOrderLayout);
        jP_activeOrderLayout.setHorizontalGroup(
            jP_activeOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 671, Short.MAX_VALUE)
        );
        jP_activeOrderLayout.setVerticalGroup(
            jP_activeOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 481, Short.MAX_VALUE)
        );

        jScroll_ActiveOrders.setViewportView(jP_activeOrder);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScroll_ActiveOrders, javax.swing.GroupLayout.DEFAULT_SIZE, 673, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScroll_ActiveOrders, javax.swing.GroupLayout.DEFAULT_SIZE, 483, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jP_activeOrder;
    private javax.swing.JScrollPane jScroll_ActiveOrders;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent ae) {
        switch (ae.getActionCommand()) {
            case "Order Accept": {
                try {
                    showActiveOrders();
                } catch (ClassNotFoundException | SQLException ex) {
                    Logger.getLogger(OrderView.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            break;
        }
    }
}
