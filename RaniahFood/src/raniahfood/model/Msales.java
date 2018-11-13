/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author dev
 */
public class Msales {
    
    private String id_sales;
    String nama_sales;
    int gaji_sales;
    String alamat_sales;
    String password_sales;
    
    public Msales(String id, String nama, int gaji, String alamat, String password) {
        this.id_sales = id;
        this.nama_sales = nama;
        this.gaji_sales = gaji;
        this.alamat_sales = alamat;
        this.password_sales = password;
    }
    
    public void setID_sales(String id) {
        this.id_sales = id;
    }
    
    public String getID_sales() {
        return id_sales;
    }
    
    public void setNama_sales(String nama) {
        this.nama_sales = nama;
    }
    
    public String getNama_sales() {
        return nama_sales;
    }
    
    public void setGaji_sales(int gaji) {
        this.gaji_sales = gaji;
    }
    
    public int getGaji_sales() {
        return gaji_sales;
    }
    
    public void setAlamat_sales(String alamat) {
        this.alamat_sales = alamat;
    }
    
    public String getAlamat_sales() {
        return alamat_sales;
    }
    
    public void setPassword_sales(String password) {
        this.password_sales = password;
    }
    
    public String getPassword_sales() {
        return password_sales;
    }
    
    public void ViewProduk() {
        
    }
    
    public void InputPenjualan() {
        
    }
    
    public void ViewDataPenjualan() {
        
    }
    
    public void UpdatePenjualan() {
        
    }
    
    public void DeletePenjualan() {
        
    }
    
    public void ViewLaporanPenjualan() {
        
    }
    
}
