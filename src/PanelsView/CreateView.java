/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PanelsView;

import Handler.SongHandler;
import Model.Artist;
import Model.Genre;
import Model.Lyric;
import Model.PlateType;
import Model.Supplier;
import PanelsButtom.LyricButtom;
import PanelsButtom.NewLyricButtom;
import java.awt.Dimension;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author markh
 */
public class CreateView extends javax.swing.JPanel {

    private SongHandler songHandler;

    /**
     * Creates new form CreateView
     */
    public CreateView() throws ClassNotFoundException, SQLException {
        songHandler = SongHandler.getInstance();
        initComponents();
        setSize(new Dimension(500, 625));
        fillSongs();
        fillSupplierCombo();
        fillArtistCombo();
        fillGenreCombo();
        fillPlatetypeCombo();
    }

    public void fillSongs() throws ClassNotFoundException, SQLException {
        NewLyricButtom newLyricButtom = new NewLyricButtom();
        LyricButtom lyricButtom;
        ArrayList<Lyric> lyricList = songHandler.getAllLyric();
        jP_songs.removeAll();
        jP_songs.add(newLyricButtom);
        newLyricButtom.setLocation(0, 0);
        newLyricButtom.setVisible(true);
        for (int i = 0; i < songHandler.getAllLyric().size(); i++) {
            lyricButtom = new LyricButtom(songHandler.getAllLyric().get(i));
            jP_songs.add(lyricButtom);
            lyricButtom.setLocation(0, ((5 * (i+1)) + (lyricButtom.getHeight() * (i+1))));
            lyricButtom.setVisible(true);
            int count = (i+1) + 1;
            jP_songs.setPreferredSize(new Dimension(lyricButtom.getWidth(), ((5 * count) + (lyricButtom.getHeight() * count))));
        }
        jP_songs.revalidate();
        jP_songs.repaint();
    }
    
    public void fillSupplierCombo(){
        jC_Supl.removeAllItems();
        
        for (Supplier s : songHandler.getAllSupplier()) {
            jC_Supl.addItem(s);
        }
    }
    
    public void fillArtistCombo(){
        jC_artist.removeAllItems();
        
        for (Artist a : songHandler.getAllArtist()) {
            jC_artist.addItem(a);
        }
    }
    
    public void fillGenreCombo(){
        jC_genre.removeAllItems();
        
        for (Genre g : songHandler.getAllGenre()) {
            jC_genre.addItem(g);
        }
    }
    
    public void fillPlatetypeCombo(){
        jC_platetype.removeAllItems();
        
        for (PlateType p : songHandler.getAllPlatetype()) {
            jC_platetype.addItem(p);
        }
    }
    
    public void createNewALbum(){
        songHandler.createNewAlbum(jT_title.getText(), jT_pict.getText(), Integer.parseInt(jT_Stock.getText()), Integer.parseInt(jT_suppprice.getText()), Integer.parseInt(jT_saleprice.getText()));
        songHandler.addSongToAlbumDB();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jT_title = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jT_pict = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jT_Stock = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jT_suppprice = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jT_saleprice = new javax.swing.JTextField();
        jC_platetype = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jC_Supl = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        jC_artist = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        jC_genre = new javax.swing.JComboBox();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jP_songs = new javax.swing.JPanel();
        jB_create = new javax.swing.JButton();

        jT_title.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jT_titleActionPerformed(evt);
            }
        });

        jLabel1.setText("Title");

        jLabel2.setText("Picture Path");

        jLabel3.setText("Stock");

        jLabel4.setText("Supplier Price");

        jLabel5.setText("Sale Price");

        jC_platetype.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jC_platetypeActionPerformed(evt);
            }
        });

        jLabel7.setText("Plate Type");

        jLabel8.setText("Supplier");

        jC_Supl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jC_SuplActionPerformed(evt);
            }
        });

        jLabel9.setText("Artist");

        jC_artist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jC_artistActionPerformed(evt);
            }
        });

        jLabel10.setText("Genre");

        jC_genre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jC_genreActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Songs", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        javax.swing.GroupLayout jP_songsLayout = new javax.swing.GroupLayout(jP_songs);
        jP_songs.setLayout(jP_songsLayout);
        jP_songsLayout.setHorizontalGroup(
            jP_songsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 246, Short.MAX_VALUE)
        );
        jP_songsLayout.setVerticalGroup(
            jP_songsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 518, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(jP_songs);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );

        jB_create.setText("CREATE");
        jB_create.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_createActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jB_create, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jC_genre, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jC_artist, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jC_Supl, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jC_platetype, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jT_saleprice)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jT_suppprice)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jT_title)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jT_pict)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jT_Stock)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jT_title, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jT_pict, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jT_Stock, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jT_suppprice, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jT_saleprice, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jC_platetype, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jC_Supl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jC_artist, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jC_genre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jB_create, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jT_titleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jT_titleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jT_titleActionPerformed

    private void jC_platetypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jC_platetypeActionPerformed
        songHandler.setSelectedPlateType((PlateType) jC_platetype.getSelectedItem());
    }//GEN-LAST:event_jC_platetypeActionPerformed

    private void jC_SuplActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jC_SuplActionPerformed
        songHandler.setSelectedSupl((Supplier) jC_Supl.getSelectedItem());
    }//GEN-LAST:event_jC_SuplActionPerformed

    private void jC_artistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jC_artistActionPerformed
        songHandler.setSelectedArtist((Artist) jC_artist.getSelectedItem());
    }//GEN-LAST:event_jC_artistActionPerformed

    private void jC_genreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jC_genreActionPerformed
        songHandler.setSelectedGenre((Genre) jC_genre.getSelectedItem());
    }//GEN-LAST:event_jC_genreActionPerformed

    private void jB_createActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_createActionPerformed
        createNewALbum();
    }//GEN-LAST:event_jB_createActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jB_create;
    private javax.swing.JComboBox jC_Supl;
    private javax.swing.JComboBox jC_artist;
    private javax.swing.JComboBox jC_genre;
    private javax.swing.JComboBox jC_platetype;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jP_songs;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jT_Stock;
    private javax.swing.JTextField jT_pict;
    private javax.swing.JTextField jT_saleprice;
    private javax.swing.JTextField jT_suppprice;
    private javax.swing.JTextField jT_title;
    // End of variables declaration//GEN-END:variables
}
