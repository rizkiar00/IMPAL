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
public class Mkoki {
    
    private String id_koki;
    String nama_koki;
    int gaji_koki;
    String alamat_koki;
    String password_koki;
    
    public Mkoki(String id, String nama, int gaji, String alamat, String password) {
        this.id_koki = id;
        this.nama_koki = nama;
        this.gaji_koki = gaji;
        this.alamat_koki = alamat;
        this.password_koki = password;
    }
    
    public void setID_koki(String id) {
        this.id_koki = id;
    }
    
    public String getID_koki() {
        return id_koki;
    }
    
    public void setNama_koki(String nama) {
        this.nama_koki = nama;
    }
    
    public String getNama_koki() {
        return nama_koki;
    }
    
    public void setGaji_koki(int gaji) {
        this.gaji_koki = gaji;
    }
    
    public int getGaji_koki() {
        return gaji_koki;
    }
    
    public void setAlamat_koki(String alamat) {
        this.alamat_koki = alamat;
    }
    
    public String getAlamat_koki() {
        return alamat_koki;
    }
    
    public void setPassword_koki(String password) {
        this.password_koki = password;
    }
    
    public String getPassword_koki() {
        return password_koki;
    }
    
    public void ViewProduk() {
        
    }
    
    public void InputProduk() {
        
    }
    
    public void UpdateProduk() {
        
    }
    
    public void DeleteProduk() {
        
    }
    
    public void InputBahan() {
        
    }
    
    public void UpdateBahan() {
        
    }
    
    public void DeleteBahan() {
        
    }
    
    public void ViewBahan() {
        
    }
    
}
