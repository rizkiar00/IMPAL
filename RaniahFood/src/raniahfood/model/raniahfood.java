/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package raniahfood.model;
import raniahfood.database.Database;
import java.util.*;
import java.sql.ResultSet; 
import java.sql.SQLException; 
import java.util.ArrayList; 
import javax.swing.JOptionPane; 
import javax.swing.table.DefaultTableModel;
import raniahfood.model.*;
/**
 *
 * @author Rizki Achmad Riyanto <your.name at your.org>
 */
public class raniahfood {
    private Database db;
    List<MKaryawan> listkaryawan = new ArrayList();
    List<Bahan> listbahan = new ArrayList();
    List<Produk> listproduk = new ArrayList();
    List<Penjualan> listpenjualan = new ArrayList();

    public raniahfood() {
        this.db=new Database();
        db.connect();
    }
    

    public String cekLogin(String id, String password) {
        MKaryawan karyawan = db.getKaryawan(id,password);
        if (karyawan==null) {
            return "";
        } else{
            return karyawan.getRole();
        }
    }
    public Bahan cekBahan(String nama) {
        Bahan bahan = db.getBahan(nama);
        return bahan;
    }
    public void addBahan(String nama, int stock, String keterangan,int stokmin){
        db.insertBahan(nama,stock,keterangan,stokmin);
    }
    
    public List<Bahan> listBahan(){
        List<Bahan> bahan =new ArrayList<>();
        bahan = db.listBahan();
        if(bahan.isEmpty()){
            return null;
        }else{
            return bahan;
        }
    }
    public void deleteBahan(String nama) {
        db.deleteBahan(nama);
    }
    public void updateBahan(String nama, int stock, String keterangan,int stokmin){
        db.updateBahan(nama,stock,keterangan,stokmin);
    }
    
    public Produk cekProduk(String nama) {
        Produk produk = db.getProduk(nama);
        return produk;
    }
    
    public void addProduk(String nama, int stock){
        db.insertProduk(nama,stock);
    }
    
    public List<Produk> listProduk(){
        List<Produk> produk =new ArrayList<>();
        produk = db.listProduk();
        if(produk.isEmpty()){
            return null;
        }else{
            return produk;
        }
    }
    public void deleteProduk(String nama) {
        db.deleteProduk(nama);
    }
    public void updateProduk(String nama, int stock){
        db.updateProduk(nama,stock);
    }    
    public MKaryawan cekKaryawan(String nama) {
        MKaryawan karyawan = db.cekKaryawan(nama);
        return karyawan;
    }
    
    public void addKaryawan(String username, String nama,String password,String role){
        db.insertKaryawan(username,nama,password,role);
    }
    
    public List<MKaryawan> listKaryawan(){
        List<MKaryawan> karyawan =new ArrayList<>();
        karyawan = db.listKaryawan();
        if(karyawan.isEmpty()){
            return null;
        }else{
            return karyawan;
        }
    }
    
    public void deleteKaryawan(String nama) {
        db.deleteKaryawan(nama);
    }
    
    public void updateKaryawan(String username, String nama,String password,String role){
        db.updateKaryawan(username,nama,password,role);
    }    
    
    public Penjualan cekPenjualan(String id,String Status) {
        Penjualan penjualan = db.getPenjualan(id,Status);
        return penjualan;
    }
    
    public void addPenjualan(String id, String tgl, String nama, String alamat, int uang,String status){
        db.insertPenjualan(id,tgl,nama,alamat,uang,status);
    }
    
    public List<Penjualan> listPenjualan(){
        List<Penjualan> penjualan =new ArrayList<>();
        penjualan = db.listPenjualan();
        if(penjualan.isEmpty()){
            return null;
        }else{
            return penjualan;
        }
    }    
    public List<Penjualan> listTransaksi(){
        List<Penjualan> penjualan =new ArrayList<>();
        penjualan = db.listTransaksi();
        if(penjualan.isEmpty()){
            return null;
        }else{
            return penjualan;
        }
    }
    
    public void deletePenjualan(String id,String Status) {
        db.deletePenjualan(id,Status);
    }
    
    public void updatePenjualan(String id, String tgl, String nama, String alamat, int uang,String status){
        db.updatePenjualan(id,tgl,nama,alamat,uang,status);
    }   
    public int[] listKeuangan(){
        List<Penjualan> penjualan =new ArrayList<>();
        penjualan = db.listPenjualan();
        List<Penjualan> transaksi =new ArrayList<>();
        transaksi = db.listTransaksi();
        if(penjualan.isEmpty()&&transaksi.isEmpty()){
            return null;
        }
        int[] array = new int[12];
        int year = Calendar.getInstance().get(Calendar.YEAR);
        for (int j = 0; j < penjualan.size(); j++) {
            Penjualan p = penjualan.get(j);
            if(Integer.parseInt(p.getTgl_penjualan().substring(0, 4))==year){
                String bulan = p.getTgl_penjualan().substring(5, 7);
                array[Integer.parseInt(bulan)-1] += p.getUang();
            }
        };
        for (int j = 0; j < transaksi.size(); j++) {
            Penjualan p = transaksi.get(j);
            if(Integer.parseInt(p.getTgl_penjualan().substring(0, 4))==year){
                String bulan = p.getTgl_penjualan().substring(5, 7);
                array[Integer.parseInt(bulan)-1] -= p.getUang();
            }
        };
        return array;
        
    }
}
