/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PanelsButtom;

import Handler.OrderHandler;
import Model.OrderLine;
import java.awt.Dimension;
import java.sql.SQLException;

/**
 *
 * @author markh
 */
public class OrderLineButtom extends javax.swing.JPanel {
    
    private OrderLine orderLine;
    private OrderHandler orderHandler;

    /**
     * Creates new form OrderLine
     */
    public OrderLineButtom(OrderLine orderLine) throws ClassNotFoundException, SQLException {
        this.orderLine = orderLine;
        orderHandler = OrderHandler.getInstance();
        initComponents();
        setSize(new Dimension(526, 30));
        jL_Date.setText("Date: "+orderLine.getDate());
        jL_StoreChain.setText("Store: "+orderLine.getCustomers().getName());
        jL_AlbumAmount.setText("Amount: "+orderLine.getAlbumAmount());
    }
    
    public void selectOrder(){
        orderHandler.setChoosenOrderline(orderLine);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jL_Date = new javax.swing.JLabel();
        jL_StoreChain = new javax.swing.JLabel();
        jL_AlbumAmount = new javax.swing.JLabel();
        jB_ShowOrder = new javax.swing.JButton();

        jL_Date.setText("jLabel1");

        jL_StoreChain.setText("jLabel1");

        jL_AlbumAmount.setText("jLabel1");

        jB_ShowOrder.setText("Show");
        jB_ShowOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_ShowOrderActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jL_Date, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jL_StoreChain, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jL_AlbumAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jB_ShowOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jL_AlbumAmount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jL_Date, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jL_StoreChain, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jB_ShowOrder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jB_ShowOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_ShowOrderActionPerformed
        selectOrder();
    }//GEN-LAST:event_jB_ShowOrderActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jB_ShowOrder;
    private javax.swing.JLabel jL_AlbumAmount;
    private javax.swing.JLabel jL_Date;
    private javax.swing.JLabel jL_StoreChain;
    // End of variables declaration//GEN-END:variables
}
