/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package raniahfood.model;

import java.util.*;

/**
 *
 * @author dev
 */
public class Penjualan {
    private String id_penjualan;
    String tgl_penjualan;
    String nama_pelanggan;
    String alamat_pelanggan;
    int uang;
    String status;

    public Penjualan(String id_penjualan, String tgl_penjualan, String nama_pelanggan, String alamat_pelanggan, int uang,String status) {
        this.id_penjualan = id_penjualan;
        this.tgl_penjualan = tgl_penjualan;
        this.nama_pelanggan = nama_pelanggan;
        this.alamat_pelanggan = alamat_pelanggan;
        this.uang = uang;
        this.status = status;
    }    
    public Penjualan(String tgl_penjualan, String nama_pelanggan, String alamat_pelanggan, int uang,String status) {
        this.tgl_penjualan = tgl_penjualan;
        this.nama_pelanggan = nama_pelanggan;
        this.alamat_pelanggan = alamat_pelanggan;
        this.uang = uang;
        this.status = status;
    }

    public String getId_penjualan() {
        return id_penjualan;
    }

    public void setId_penjualan(String id_penjualan) {
        this.id_penjualan = id_penjualan;
    }

    public String getTgl_penjualan() {
        return tgl_penjualan;
    }

    public void setTgl_penjualan(String tgl_penjualan) {
        this.tgl_penjualan = tgl_penjualan;
    }

    public String getNama_pelanggan() {
        return nama_pelanggan;
    }

    public void setNama_pelanggan(String nama_pelanggan) {
        this.nama_pelanggan = nama_pelanggan;
    }

    public String getAlamat_pelanggan() {
        return alamat_pelanggan;
    }

    public void setAlamat_pelanggan(String alamat_pelanggan) {
        this.alamat_pelanggan = alamat_pelanggan;
    }

    public int getUang() {
        return uang;
    }

    public void setUang(int uang) {
        this.uang = uang;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(char String) {
        this.status = status;
    }
    

}
