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
public class Produk {
    String nama_produk;
    int stok_produk;
    
    public Produk(String nama, int stok) {
        this.nama_produk = nama;
        this.stok_produk = stok;
    }    

    public String getNama_produk() {
        return nama_produk;
    }

    public void setNama_produk(String nama_produk) {
        this.nama_produk = nama_produk;
    }

    public int getStok_produk() {
        return stok_produk;
    }

    public void setStok_produk(int stok_produk) {
        this.stok_produk = stok_produk;
    }
}
