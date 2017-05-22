/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author markh
 */
public class Album {
    
    private int id;
    private String title;
    private String picturePath;
    private int stock;
    private int supplierPrice;
    private int salePrice;
    private int songNumbers;
    private PlateType plateType;
    private Supplier supplier;
    private Artist artist;
    private Genre genre;

    public Album(int id, String title, String picturePath, int stock, int supplierPrice, int salePrice, int songNumbers, PlateType plateType, Supplier supplier, Artist artist, Genre genre) {
        this.id = id;
        this.title = title;
        this.picturePath = picturePath;
        this.stock = stock;
        this.supplierPrice = supplierPrice;
        this.salePrice = salePrice;
        this.songNumbers = songNumbers;
        this.plateType = plateType;
        this.supplier = supplier;
        this.artist = artist;
        this.genre = genre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPicturePath() {
        return picturePath;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getSupplierPrice() {
        return supplierPrice;
    }

    public void setSupplierPrice(int supplierPrice) {
        this.supplierPrice = supplierPrice;
    }

    public int getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(int salePrice) {
        this.salePrice = salePrice;
    }

    public int getSongNumbers() {
        return songNumbers;
    }

    public void setSongNumbers(int songNumbers) {
        this.songNumbers = songNumbers;
    }

    public PlateType getPlateType() {
        return plateType;
    }

    public void setPlateType(PlateType plateType) {
        this.plateType = plateType;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }
    
    
    
}
