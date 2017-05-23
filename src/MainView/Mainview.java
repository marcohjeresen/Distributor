/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainView;

import Handler.OrderHandler;
import PanelsView.CreateView;
import PanelsView.OrderView;
import PanelsView.SingelOrderView;
import UtilityStuff.Listeners;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

/**
 *
 * @author markh
 */
public class Mainview extends javax.swing.JFrame implements ActionListener {

    private OrderView orderView;
    private CreateView createView;
    private Listeners listeners;
    private OrderHandler orderHandler;

    /**
     * Creates new form Mainview
     */
    public Mainview() {
        listeners = Listeners.getList();
        try {
            orderHandler = OrderHandler.getInstance();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Mainview.class.getName()).log(Level.SEVERE, null, ex);
        }
        initComponents();

        listeners.addListener(this);
        setSize(new Dimension(1200, 800));
        showOrderView();
//        orderView.setLocation((this.getWidth() - orderView.getWidth()) / 2, (this.getHeight() - orderView.getHeight() - 50) / 2);
    }

    public void showOrder() throws ClassNotFoundException, SQLException {
        JFrame jf = new JFrame("Tilføj Ret");
        SingelOrderView so = new SingelOrderView(orderHandler.getChoosenOrder(), jf);
        jf.add(so);
        jf.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        so.setVisible(true);
        jf.setVisible(true);
        jf.setSize(860, 372);

        int højde = ((this.getHeight() - jf.getHeight()) / 2);
        int brede = ((this.getWidth() - jf.getWidth()) / 2);
        jf.setLocation(brede, højde);
    }

    public void showOrderView() {
        jp_show.removeAll();
        try {
            orderView = new OrderView();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Mainview.class.getName()).log(Level.SEVERE, null, ex);
        }
        jp_show.add(orderView);
        this.repaint();
        this.revalidate();
    }

    public void showCreateSite() {
        jp_show.removeAll();
        try {
            createView = new CreateView();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Mainview.class.getName()).log(Level.SEVERE, null, ex);
        }
        jp_show.add(createView);
        this.repaint();
        this.revalidate();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jP_viewCont = new javax.swing.JPanel();
        jp_show = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Active Orders");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Create Records");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jP_viewCont.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout jp_showLayout = new javax.swing.GroupLayout(jp_show);
        jp_show.setLayout(jp_showLayout);
        jp_showLayout.setHorizontalGroup(
            jp_showLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 652, Short.MAX_VALUE)
        );
        jp_showLayout.setVerticalGroup(
            jp_showLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 736, Short.MAX_VALUE)
        );

        jP_viewCont.add(jp_show, "card2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jP_viewCont, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jP_viewCont, javax.swing.GroupLayout.DEFAULT_SIZE, 736, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        showCreateSite();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        showOrderView();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Mainview.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Mainview.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Mainview.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Mainview.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Mainview().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jP_viewCont;
    private javax.swing.JPanel jp_show;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent ae) {
        switch (ae.getActionCommand()) {
            case "Order Selected": {
                try {
                    showOrder();
                } catch (ClassNotFoundException | SQLException ex) {
                    Logger.getLogger(Mainview.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            break;
            case "New Album": {
                showCreateSite();
            }
            break;
        }
    }
}

