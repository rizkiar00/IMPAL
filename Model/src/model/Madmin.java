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
public class Madmin {
    
    private String id_admin;
    String nama_admin;
    int gaji_admin;
    String alamat_admin;
    String password_admin;
    
    public Madmin(String id, String nama, int gaji, String alamat, String password) {
        this.id_admin = id;
        this.nama_admin = nama;
        this.gaji_admin = gaji;
        this.alamat_admin = alamat;
        this.password_admin = password;
    }
    
    public void setID_admin(String id) {
        this.id_admin = id;
    }
    
    public String getID_admin() {
        return id_admin;
    }
    
    public void setNama_admin(String nama) {
        this.nama_admin = nama;
    }
    
    public String getNama_admin() {
        return nama_admin;
    }
    
    public void setGaji_admin(int gaji) {
        this.gaji_admin = gaji;
    }
    
    public int getGaji_admin() {
        return gaji_admin;
    }
    
    public void setAlamat_admin(String alamat) {
        this.alamat_admin = alamat;
    }
    
    public String getAlamat_admin() {
        return alamat_admin;
    }
    
    public void setPassword_admin(String password) {
        this.password_admin = password;
    }
    
    public String getPassword_admin() {
        return password_admin;
    }
    
    public void InputHarga() {
        
    }
    
    public void UpdateHarga() {
        
    }
    
    public void ViewDataBahan() {
        
    }
    
    public void ViewBahanKurang() {
        
    }
    
    public void ViewLaporanKeuangan() {
        
    }
    
    public void InputRegistrasi() {
        
    }
    
    public void UpdateRegistrasi() {
        
    }
    
    public void DeleteRegistrasi() {
        
    }
    
    public void ViewRegistrasi() {
        
    }
    
    public void ViewLaporanPenjualan() {
        
    }
    
}
