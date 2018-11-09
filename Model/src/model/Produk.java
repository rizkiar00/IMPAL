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
public class Produk {
    private String id_produk;
    String nama_produk;
    int stok_produk;
    int harga_produk;
    
    public Produk(String id, String nama, int stok, int harga) {
        this.id_produk = id;
        this.nama_produk = nama;
        this.stok_produk = stok;
        this.harga_produk = harga;
    }    
}
