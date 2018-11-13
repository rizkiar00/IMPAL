/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.*;

/**
 *
 * @author dev
 */
public class Penjualan {
    private String id_penjualan;
    String tgl_penjualan;
    int jumlah_penjualan;
    List ListProduk = new ArrayList();
    String nama_pelanggan;
    String alamat_pelanggan;
    String hp_pelanggan;
    
    public Penjualan(String id, String nama, int stok, int harga) {
        this.id_penjualan = id;
    }    
}
