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
public class Bahan {
    private String id_bahan;
    String nama_bahan;
    int stok_bahan;
    int harga_bahan;
    
    public Bahan(String id, String nama, int stok, int harga) {
        this.id_bahan = id;
        this.nama_bahan = nama;
        this.stok_bahan = stok;
        this.harga_bahan = harga;
    }
}
