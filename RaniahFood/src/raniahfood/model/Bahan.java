/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package raniahfood.model;

/**
 *
 * @author dev
 */
public class Bahan {
    String nama_bahan;
    int stok_bahan;
    String keterangan;
    int stokmin;
    
    public Bahan(String nama, int stok, String keterangan,int stokmin) {
        this.nama_bahan = nama;
        this.stok_bahan = stok;
        this.keterangan = keterangan;
        this.stokmin = stokmin;
    }

    public int getStokmin() {
        return stokmin;
    }

    public void setStokmin(int stokmin) {
        this.stokmin = stokmin;
    }

    public String getNama_bahan() {
        return nama_bahan;
    }

    public void setNama_bahan(String nama_bahan) {
        this.nama_bahan = nama_bahan;
    }

    public int getStok_bahan() {
        return stok_bahan;
    }

    public void setStok_bahan(int stok_bahan) {
        this.stok_bahan = stok_bahan;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }
}
