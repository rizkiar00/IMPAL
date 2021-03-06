/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package raniahfood.controller;
import raniahfood.database.Database;
import raniahfood.view.VLogin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import raniahfood.model.*; 
import raniahfood.view.*; 
import java.awt.HeadlessException; 
import raniahfood.view.VKoki;

import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; 
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException; 
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane; 
import javax.swing.JPanel; 
import javax.swing.JPasswordField;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import static javax.swing.WindowConstants.HIDE_ON_CLOSE;
import org.jfree.ui.RefineryUtilities;



/**
 *
 * @author Asus
 */
public class Controller implements ActionListener{
    private Database db;
    private raniahfood model;
    private String currentView;
    private JPanel mainPanel;
    private VLogin viewlogin;
    private VKoki viewkoki;
    private VAdmin viewadmin;
    private VSales viewsales;
    
    public Controller(raniahfood model,Database db) throws SQLException {
        this.model = model; 
        this.db = db;
        
        viewlogin = new VLogin();
        viewlogin.setVisible(true);
        viewlogin.pack();
        viewlogin.setLocationRelativeTo(null);
        viewkoki = new VKoki();
        viewadmin = new VAdmin();
        viewsales = new VSales();
        viewlogin.addActionListener(this);
        viewkoki.addActionListener(this);
        viewadmin.addActionListener(this);
        viewsales.addActionListener(this);
//        mainPanel = view.getMainPanel();
//        mainPanel.add(viewlogin,"0");
//        mainPanel.add(viewkoki,"1");
//        
//        currentView = "0";
//        view.getCardLayout().show(mainPanel, currentView); 
//        view.setVisible(true); 
//        view.addListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object a = e.getSource();
        if (a == viewlogin.getjButton1()) { //login
            String user = viewlogin.getjTextField1();
            String pass = viewlogin.getjPasswordField1();
            //System.out.println(user + pass);
            
            try {
                String role = model.cekLogin(user, pass); //cek username password
                if (role!="") {
                    if (role.equals("koki")) {
                        viewkoki.setVisible(true);
                        viewkoki.setLocationRelativeTo(null);
                        viewlogin.setVisible(false);
                    }
                    if (role.equals("admin")) {
                        viewadmin.setVisible(true);
                        viewadmin.setLocationRelativeTo(null);
                        viewlogin.setVisible(false);
                    }
                    if (role.equals("sales")) {
                        viewsales.setVisible(true);
                        viewsales.setLocationRelativeTo(null);
                        viewlogin.setVisible(false);
                    }
//                    viewkoki = new VKoki();

                }else {
                    JOptionPane.showConfirmDialog(viewlogin, "Anda belum terdaftar", "Login Gagal", JOptionPane.WARNING_MESSAGE);
                }
            } catch (Exception ee) {
                ee.printStackTrace();//penting
                JOptionPane.showConfirmDialog(viewlogin, ""+ee.getMessage(), ""+ee.getMessage(), JOptionPane.WARNING_MESSAGE);
            }
        } 
        if (a == viewkoki.getjButton2()){ //insertbahan
            if (viewkoki.getjTextField1().isEmpty() || viewkoki.getjTextField2().isEmpty() || viewkoki.getjTextField7().isEmpty()){
                JOptionPane.showConfirmDialog(null, "Pastikan Form Sudah di isi semua","Input Error",JOptionPane.DEFAULT_OPTION);
            } else {
                try { 
                // checking valid integer using parseInt() method 
                    String nama = viewkoki.getjTextField1();
                    String stock = viewkoki.getjTextField2();
                    String keterangan = viewkoki.getjTextField7();
                    String stokmin = viewkoki.getjTextField11();
                    int angka = Integer.parseInt(stock);
                    int min = Integer.parseInt(stokmin);
                    model.addBahan(nama, angka, keterangan,min);
                } catch (NumberFormatException ne) { 
                    JOptionPane.showConfirmDialog(null, "Pastikan Stock dalam bentuk angka","Input Error",JOptionPane.DEFAULT_OPTION);
                }
            }
        }
        if (a == viewkoki.getjButton1()){ //cektabelbahan
            try{
                List<Bahan> bahan=new ArrayList<>();
                bahan = model.listBahan();
                if(bahan==null) {
                    viewkoki.setDataBahan(bahan);
                    JOptionPane.showConfirmDialog(null, "Data Bahan Kosong","Refresh",JOptionPane.DEFAULT_OPTION);
                } else {
                    viewkoki.setDataBahan(bahan);
                    JOptionPane.showConfirmDialog(null, "Data Sudah Di Update","Refresh",JOptionPane.DEFAULT_OPTION);
                }
            } catch (Exception ee) {
                ee.printStackTrace();//penting
                JOptionPane.showConfirmDialog(viewlogin, ""+ee.getMessage(), ""+ee.getMessage(), JOptionPane.WARNING_MESSAGE);
            }
        }
        if (a == viewkoki.getjButton3()){ //deletebahan
            if (viewkoki.getjTextField3().isEmpty()){
                JOptionPane.showConfirmDialog(null, "Pastikan Form Sudah di isi semua","Delete Error",JOptionPane.DEFAULT_OPTION);
            } else {
                try { 
                    String nama = viewkoki.getjTextField3();
                    Bahan bahan = model.cekBahan(nama);
                    if (bahan == null){
                        JOptionPane.showConfirmDialog(null, "Bahan Tidak Ditemukan","Delete Error",JOptionPane.DEFAULT_OPTION);
                    } else {
                        model.deleteBahan(nama);
                    }
                } catch (NumberFormatException ne) { 
                    JOptionPane.showConfirmDialog(null, "Pastikan Stock dalam bentuk angka","Input Error",JOptionPane.DEFAULT_OPTION);
                }
            }
        }
        if (a == viewkoki.getjButton4()){ //logout
            try {
                viewlogin.setVisible(true);
                viewlogin.setLocationRelativeTo(null);
                viewkoki.setVisible(false);
            } catch (Exception ee) {
                ee.printStackTrace();//penting
                JOptionPane.showConfirmDialog(viewkoki, ""+ee.getMessage(), ""+ee.getMessage(), JOptionPane.WARNING_MESSAGE);
            }
        }
        if (a == viewkoki.getjButton5()){ //updatebahan
            if (viewkoki.getjTextField5().isEmpty() || viewkoki.getjTextField6().isEmpty() || viewkoki.getjTextField8().isEmpty()){
                JOptionPane.showConfirmDialog(null, "Pastikan Form Sudah di isi semua","Update Error",JOptionPane.DEFAULT_OPTION);
            } else {
                try { 
                    String nama = viewkoki.getjTextField5();
                    String stok = viewkoki.getjTextField6();
                    String keterangan = viewkoki.getjTextField8();
                    String stokmin = viewkoki.getjTextField14();
                    Bahan bahan = model.cekBahan(nama);
                    if (bahan == null){
                        JOptionPane.showConfirmDialog(null, "Bahan Tidak Ditemukan","Update Error",JOptionPane.DEFAULT_OPTION);
                    } else {
                        model.updateBahan(nama, Integer.parseInt(stok),keterangan,Integer.parseInt(stokmin));
                    }
                } catch (NumberFormatException ne) { 
                    JOptionPane.showConfirmDialog(null, "Pastikan Stock dalam bentuk angka","Update Error",JOptionPane.DEFAULT_OPTION);
                }
            }
        }
        if (a == viewkoki.getjButton6()){ //cekupdatebahan
            if (viewkoki.getjTextField5().isEmpty()){
                JOptionPane.showConfirmDialog(null, "Pastikan Form Sudah di isi semua","Update Error",JOptionPane.DEFAULT_OPTION);
            } else {
                try { 
                    String nama = viewkoki.getjTextField5();
                    Bahan bahan = model.cekBahan(nama);
                    if (bahan == null){
                        JOptionPane.showConfirmDialog(null, "Bahan Tidak Ditemukan","Update Error",JOptionPane.DEFAULT_OPTION);
                    } else {
                        viewkoki.setjTextField5(bahan.getNama_bahan());
                        viewkoki.setjTextField6(Integer.toString(bahan.getStok_bahan()));
                        viewkoki.setjTextField8(bahan.getKeterangan());
                        viewkoki.setjTextField14(Integer.toString(bahan.getStokmin()));
                    }
                } catch (NumberFormatException ne) { 
                    JOptionPane.showConfirmDialog(null, "Pastikan Stock dalam bentuk angka","Update Error",JOptionPane.DEFAULT_OPTION);
                }
            }
        }        
        //sini kebawah produk
        if (a == viewkoki.getjButton10()){ //insertproduk
            if (viewkoki.getjTextField12().isEmpty() || viewkoki.getjTextField13().isEmpty()){
                JOptionPane.showConfirmDialog(null, "Pastikan Form Sudah di isi semua","Input Error",JOptionPane.DEFAULT_OPTION);
            } else {
                try { 
                // checking valid integer using parseInt() method 
                    String nama = viewkoki.getjTextField12();
                    String stock = viewkoki.getjTextField13();
                    int angka = Integer.parseInt(stock);
                    model.addProduk(nama, angka);
                } catch (NumberFormatException ne) { 
                    JOptionPane.showConfirmDialog(null, "Pastikan Stock dalam bentuk angka","Input Error",JOptionPane.DEFAULT_OPTION);
                }
            }
        } 
        if (a == viewkoki.getjButton11()){ //cektabelproduk
            try{
                List<Produk> produk=new ArrayList<>();
                produk = model.listProduk();
                if(produk==null) {
                    viewkoki.setDataProduk(produk);
                    JOptionPane.showConfirmDialog(null, "Data Produk Kosong","Refresh",JOptionPane.DEFAULT_OPTION);
                } else {
                    viewkoki.setDataProduk(produk);
                    JOptionPane.showConfirmDialog(null, "Data Sudah Di Update","Refresh",JOptionPane.DEFAULT_OPTION);
                }
            } catch (Exception ee) {
                ee.printStackTrace();//penting
                JOptionPane.showConfirmDialog(viewlogin, ""+ee.getMessage(), ""+ee.getMessage(), JOptionPane.WARNING_MESSAGE);
            }
        }
        if (a == viewkoki.getjButton9()){ //deleteproduk
            if (viewkoki.getjTextField4().isEmpty()){
                JOptionPane.showConfirmDialog(null, "Pastikan Form Sudah di isi semua","Delete Error",JOptionPane.DEFAULT_OPTION);
            } else {
                try { 
                    String nama = viewkoki.getjTextField4();
                    Produk produk = model.cekProduk(nama);
                    if (produk == null){
                        JOptionPane.showConfirmDialog(null, "Produk Tidak Ditemukan","Delete Error",JOptionPane.DEFAULT_OPTION);
                    } else {
                        model.deleteProduk(nama);
                    }
                } catch (NumberFormatException ne) { 
                    JOptionPane.showConfirmDialog(null, "Pastikan Stock dalam bentuk angka","Input Error",JOptionPane.DEFAULT_OPTION);
                }
            }
        }
        if (a == viewkoki.getjButton7()){ //updateproduk
            if (viewkoki.getjTextField9().isEmpty() || viewkoki.getjTextField10().isEmpty()){
                JOptionPane.showConfirmDialog(null, "Pastikan Form Sudah di isi semua","Update Error",JOptionPane.DEFAULT_OPTION);
            } else {
                try { 
                    String nama = viewkoki.getjTextField9();
                    String stok = viewkoki.getjTextField10();
                    Produk produk = model.cekProduk(nama);
                    if (produk == null){
                        JOptionPane.showConfirmDialog(null, "Produk Tidak Ditemukan","Update Error",JOptionPane.DEFAULT_OPTION);
                    } else {
                        model.updateProduk(nama, Integer.parseInt(stok));
                    }
                } catch (NumberFormatException ne) { 
                    JOptionPane.showConfirmDialog(null, "Pastikan Stock dalam bentuk angka","Update Error",JOptionPane.DEFAULT_OPTION);
                }
            }
        }
        if (a == viewkoki.getjButton8()){ //cekupdateproduk
            if (viewkoki.getjTextField9().isEmpty()){
                JOptionPane.showConfirmDialog(null, "Pastikan Form Sudah di isi semua","Update Error",JOptionPane.DEFAULT_OPTION);
            } else {
                try { 
                    String nama = viewkoki.getjTextField9();
                    Produk produk = model.cekProduk(nama);
                    if (produk == null){
                        JOptionPane.showConfirmDialog(null, "Produk Tidak Ditemukan","Update Error",JOptionPane.DEFAULT_OPTION);
                    } else {
                        viewkoki.setjTextField9(produk.getNama_produk());
                        viewkoki.setjTextField10(Integer.toString(produk.getStok_produk()));
                    }
                } catch (NumberFormatException ne) { 
                    JOptionPane.showConfirmDialog(null, "Pastikan Stock dalam bentuk angka","Update Error",JOptionPane.DEFAULT_OPTION);
                }
            }
        }
        //Sini kebawah karyawan
        if (a == viewadmin.getjButton1()){ //logout
            try {
                viewlogin.setVisible(true);
                viewlogin.setLocationRelativeTo(null);
                viewadmin.setVisible(false);
            } catch (Exception ee) {
                ee.printStackTrace();//penting
                JOptionPane.showConfirmDialog(viewadmin, ""+ee.getMessage(), ""+ee.getMessage(), JOptionPane.WARNING_MESSAGE);
            }
        }
        if (a == viewadmin.getjButton2()){ //insertkaryawan
            if (viewadmin.getjTextField1().isEmpty() || viewadmin.getjTextField2().isEmpty() || viewadmin.getjPasswordField1().isEmpty()){
                JOptionPane.showConfirmDialog(null, "Pastikan Form Sudah di isi semua","Input Error",JOptionPane.DEFAULT_OPTION);
            } else {
                try { 
                // checking valid integer using parseInt() method 
                    String username = viewadmin.getjTextField1();
                    String nama = viewadmin.getjTextField2();
                    String password = viewadmin.getjPasswordField1();
                    String role = viewadmin.getjComboBox1();
                    model.addKaryawan(username,nama, password,role);
                } catch (Exception ee) { 
                    JOptionPane.showConfirmDialog(null, e,"Input Error",JOptionPane.DEFAULT_OPTION);
                }
            }
        } 
        if (a == viewadmin.getjButton6()){ //cektabelkaryawan
            try{
                List<MKaryawan> karyawan=new ArrayList<>();
                karyawan = model.listKaryawan();
                if(karyawan==null) {
                    viewadmin.setDataKaryawan(karyawan);
                    JOptionPane.showConfirmDialog(null, "Data Produk Kosong","Refresh",JOptionPane.DEFAULT_OPTION);
                } else {
                    viewadmin.setDataKaryawan(karyawan);
                    JOptionPane.showConfirmDialog(null, "Data Sudah Di Update","Refresh",JOptionPane.DEFAULT_OPTION);
                }
            } catch (Exception ee) {
                ee.printStackTrace();//penting
                JOptionPane.showConfirmDialog(viewlogin, ""+ee.getMessage(), ""+ee.getMessage(), JOptionPane.WARNING_MESSAGE);
            }
        }
        if (a == viewadmin.getjButton5()){ //deletekaryawan
            if (viewadmin.getjTextField5().isEmpty()){
                JOptionPane.showConfirmDialog(null, "Pastikan Form Sudah di isi semua","Delete Error",JOptionPane.DEFAULT_OPTION);
            } else {
                try { 
                    String username = viewadmin.getjTextField5();
                    MKaryawan karyawan = model.cekKaryawan(username);
                    if (karyawan == null){
                        JOptionPane.showConfirmDialog(null, "Karyawan Tidak Ditemukan","Update Error",JOptionPane.DEFAULT_OPTION);
                    } else {
                        model.deleteKaryawan(username);
                    }
                } catch (Exception ee) { 
                    JOptionPane.showConfirmDialog(null, ee,"Input Error",JOptionPane.DEFAULT_OPTION);
                }
            }
        }
        if (a == viewadmin.getjButton3()){ //updatekaryawan
            if (viewadmin.getjTextField3().isEmpty() || viewadmin.getjTextField4().isEmpty() || viewadmin.getjPasswordField2().isEmpty()){
                JOptionPane.showConfirmDialog(null, "Pastikan Form Sudah di isi semua","Update Error",JOptionPane.DEFAULT_OPTION);
            } else {
                try { 
                    String username = viewadmin.getjTextField3();
                    String nama = viewadmin.getjTextField4();
                    String password = viewadmin.getjPasswordField2();
                    String role = viewadmin.getjComboBox2();
                    MKaryawan karyawan = model.cekKaryawan(username);
                    if (karyawan == null){
                        JOptionPane.showConfirmDialog(null, "Karyawan Tidak Ditemukan","Update Error",JOptionPane.DEFAULT_OPTION);
                    } else {
                        model.updateKaryawan(username,nama, password,role);
                    }
                } catch (Exception ee) { 
                    JOptionPane.showConfirmDialog(null, e,"Update Error",JOptionPane.DEFAULT_OPTION);
                }
            }
        }
        if (a == viewadmin.getjButton4()){ //cekupdatekaryawan
            if (viewadmin.getjTextField3().isEmpty()){
                JOptionPane.showConfirmDialog(null, "Pastikan Form Sudah di isi semua","Update Error",JOptionPane.DEFAULT_OPTION);
            } else {
                try { 
                    String username = viewadmin.getjTextField3();
                    MKaryawan karyawan = model.cekKaryawan(username);
                    if (karyawan == null){
                        JOptionPane.showConfirmDialog(null, "Karyawan Tidak Ditemukan","Update Error",JOptionPane.DEFAULT_OPTION);
                    } else {
                        viewadmin.setjTextField3(karyawan.getUsername());
                        viewadmin.setjTextField4(karyawan.getNama());
                        viewadmin.setjPasswordField2(karyawan.getPassword());
                        viewadmin.setjComboBox2(karyawan.getRole());
                    }
                } catch (Exception ee) { 
                    JOptionPane.showConfirmDialog(null, ee,"Update Error",JOptionPane.DEFAULT_OPTION);
                }
            }
        }
        //sini kebawah penjualan
        if (a == viewsales.getjButton1()){ //logout
            try {
                viewlogin.setVisible(true);
                viewlogin.setLocationRelativeTo(null);
                viewsales.setVisible(false);
            } catch (Exception ee) {
                ee.printStackTrace();//penting
                JOptionPane.showConfirmDialog(viewadmin, ""+ee.getMessage(), ""+ee.getMessage(), JOptionPane.WARNING_MESSAGE);
            }
        }
        if (a == viewsales.getjButton2()){ //insertPenjualan
            if (viewsales.getjTextField1().isEmpty() || viewsales.getjTextField3().isEmpty() || viewsales.getjTextField4().isEmpty() ||
                    viewsales.getjTextField5().isEmpty() || viewsales.getjTextField6().isEmpty() || viewsales.getjTextArea1().isEmpty()){
                JOptionPane.showConfirmDialog(null, "Pastikan Form Sudah di isi semua","Input Error",JOptionPane.DEFAULT_OPTION);
            } else {
                try { 
                // checking valid integer using parseInt() method 
                    String nama = viewsales.getjTextField1();
                    String alamat = viewsales.getjTextArea1();
                    String tgl = viewsales.getjTextField3();
                    String bln = viewsales.getjTextField4();
                    String thn = viewsales.getjTextField5();
                    String uang = viewsales.getjTextField6();
                    int t = Integer.parseInt(tgl);
                    int b = Integer.parseInt(bln);
                    int th = Integer.parseInt(thn);
                    int angka = Integer.parseInt(uang);
                    String tanggal = th + "-" + b + "-" + t;
                    model.addPenjualan("DEFAULT",tanggal,nama, alamat,angka,"0");
                } catch (NumberFormatException ne) { 
                    JOptionPane.showConfirmDialog(null, "Pastikan Tanggal,Bulan,Tahun dan Uang dalam bentuk angka","Input Error",JOptionPane.DEFAULT_OPTION);
                }
            }
        } 
        if (a == viewsales.getjButton5()){ //cektabelpenjualan
            try{
                List<Penjualan> penjualan=new ArrayList<>();
                penjualan = model.listPenjualan();
                if(penjualan==null) {
                    viewsales.setjTable1(penjualan);
                    JOptionPane.showConfirmDialog(null, "Data Produk Penjualan","Refresh",JOptionPane.DEFAULT_OPTION);
                } else {
                    viewsales.setjTable1(penjualan);
                    JOptionPane.showConfirmDialog(null, "Data Sudah Di Update","Refresh",JOptionPane.DEFAULT_OPTION);
                }
            } catch (Exception ee) {
                ee.printStackTrace();//penting
                JOptionPane.showConfirmDialog(viewlogin, ""+ee.getMessage(), ""+ee.getMessage(), JOptionPane.WARNING_MESSAGE);
            }
        }
        if (a == viewsales.getjButton4()){ //deletepenjualan
            if (viewsales.getjTextField13().isEmpty()){
                JOptionPane.showConfirmDialog(null, "Pastikan Form Sudah di isi semua","Delete Error",JOptionPane.DEFAULT_OPTION);
            } else {
                try { 
                    String id = viewsales.getjTextField13();
                    Penjualan penjualan = model.cekPenjualan(id,"0");
                    if (penjualan == null){
                        JOptionPane.showConfirmDialog(null, "Karyawan Tidak Ditemukan","Update Error",JOptionPane.DEFAULT_OPTION);
                    } else {
                        model.deletePenjualan(id,"0");
                    }
                } catch (Exception ee) { 
                    JOptionPane.showConfirmDialog(null, ee,"Input Error",JOptionPane.DEFAULT_OPTION);
                }
            }
        }
        if (a == viewsales.getjButton3()){ //updatepenjualan
            if (viewsales.getjTextField2().isEmpty() || viewsales.getjTextField7().isEmpty() || viewsales.getjTextArea2().isEmpty()|| 
                    viewsales.getjTextField9().isEmpty() || viewsales.getjTextField10().isEmpty() || viewsales.getjTextField11().isEmpty() || viewsales.getjTextField12().isEmpty() ){
                JOptionPane.showConfirmDialog(null, "Pastikan Form Sudah di isi semua","Update Error",JOptionPane.DEFAULT_OPTION);
            } else {
                try {
                    String id = viewsales.getjTextField2(); 
                    String nama = viewsales.getjTextField7();
                    String alamat = viewsales.getjTextArea2();
                    String tgl = viewsales.getjTextField9();
                    String bln = viewsales.getjTextField10();
                    String thn = viewsales.getjTextField11();
                    String uang = viewsales.getjTextField12();
                    int t = Integer.parseInt(tgl);
                    int b = Integer.parseInt(bln);
                    int th = Integer.parseInt(thn);
                    int angka = Integer.parseInt(uang);
                    String tanggal = th + "-" + b + "-" + t;
                    Penjualan penjualan = model.cekPenjualan(id,"0");
                    if (penjualan == null){
                        JOptionPane.showConfirmDialog(null, "Penjualan Tidak Ditemukan","Update Error",JOptionPane.DEFAULT_OPTION);
                    } else {
                        model.updatePenjualan(id,tanggal,nama, alamat,angka,"0");
                    }
                } catch (Exception ee) { 
                    JOptionPane.showConfirmDialog(null, e,"Update Error",JOptionPane.DEFAULT_OPTION);
                }
            }
        }
        if (a == viewsales.getjButton6()){ //cekupdatepenjualan
            if (viewsales.getjTextField2().isEmpty()){
                JOptionPane.showConfirmDialog(null, "Pastikan Form Sudah di isi semua","Update Error",JOptionPane.DEFAULT_OPTION);
            } else {
                try { 
                    String id = viewsales.getjTextField2();
                    Penjualan penjualan = model.cekPenjualan(id,"0");
                    if (penjualan == null){
                        JOptionPane.showConfirmDialog(null, "Karyawan Tidak Ditemukan","Update Error",JOptionPane.DEFAULT_OPTION);
                    } else {
                        viewsales.setjTextField7(penjualan.getNama_pelanggan());
                        viewsales.setjTextArea2(penjualan.getAlamat_pelanggan());
                        viewsales.setjTextField11(penjualan.getTgl_penjualan().substring(0, 4));
                        viewsales.setjTextField10(penjualan.getTgl_penjualan().substring(5, 7));
                        viewsales.setjTextField9(penjualan.getTgl_penjualan().substring(8));
                        viewsales.setjTextField12(String.valueOf(penjualan.getUang()));
                    }
                } catch (Exception ee) { 
                    JOptionPane.showConfirmDialog(null, ee,"Update Error",JOptionPane.DEFAULT_OPTION);
                }
            }
        }        
        if (a == viewsales.getjButton7()){ //cektabelproduk
            try{
                List<Produk> produk=new ArrayList<>();
                produk = model.listProduk();
                if(produk==null) {
                    viewsales.setDataProduk(produk);
                    JOptionPane.showConfirmDialog(null, "Data Produk Kosong","Refresh",JOptionPane.DEFAULT_OPTION);
                } else {
                    viewsales.setDataProduk(produk);
                    JOptionPane.showConfirmDialog(null, "Data Sudah Di Update","Refresh",JOptionPane.DEFAULT_OPTION);
                }
            } catch (Exception ee) {
                ee.printStackTrace();//penting
                JOptionPane.showConfirmDialog(viewlogin, ""+ee.getMessage(), ""+ee.getMessage(), JOptionPane.WARNING_MESSAGE);
            }
        }
        //sini kebawah transaksi
        if (a == viewadmin.getjButton10()){ //insertTransaksi
            if (viewadmin.getjTextField16().isEmpty() || viewadmin.getjTextArea1().isEmpty() || viewadmin.getjTextField6().isEmpty() ||
                    viewadmin.getjTextField7().isEmpty() || viewadmin.getjTextField8().isEmpty() || viewadmin.getjTextField9().isEmpty()){
                JOptionPane.showConfirmDialog(null, "Pastikan Form Sudah di isi semua","Input Error",JOptionPane.DEFAULT_OPTION);
            } else {
                try { 
                // checking valid integer using parseInt() method 
                    String pembayaran = viewadmin.getjTextField16();
                    String keterangan = viewadmin.getjTextArea1();
                    String tgl = viewadmin.getjTextField6();
                    String bln = viewadmin.getjTextField7();
                    String thn = viewadmin.getjTextField8();
                    String uang = viewadmin.getjTextField9();
                    int t = Integer.parseInt(tgl);
                    int b = Integer.parseInt(bln);
                    int th = Integer.parseInt(thn);
                    int angka = Integer.parseInt(uang);
                    String tanggal = th + "-" + b + "-" + t;
                    model.addPenjualan("DEFAULT",tanggal,pembayaran, keterangan,angka,"1");
                } catch (NumberFormatException ne) { 
                    JOptionPane.showConfirmDialog(null, "Pastikan Tanggal,Bulan,Tahun dan Uang dalam bentuk angka","Input Error",JOptionPane.DEFAULT_OPTION);
                }
            }
        } 
        if (a == viewadmin.getjButton7()){ //cektabeltransaksi
            try{
                List<Penjualan> penjualan=new ArrayList<>();
                penjualan = model.listTransaksi();
                if(penjualan==null) {
                    viewadmin.setDataTransaksi(penjualan);
                    JOptionPane.showConfirmDialog(null, "Data Transaksi Kosong","Refresh",JOptionPane.DEFAULT_OPTION);
                } else {
                    viewadmin.setDataTransaksi(penjualan);
                    JOptionPane.showConfirmDialog(null, "Data Sudah Di Update","Refresh",JOptionPane.DEFAULT_OPTION);
                }
            } catch (Exception ee) {
                ee.printStackTrace();//penting
                JOptionPane.showConfirmDialog(viewlogin, ""+ee.getMessage(), ""+ee.getMessage(), JOptionPane.WARNING_MESSAGE);
            }
        }
        if (a == viewadmin.getjButton13()){ //deletetransaksi
            if (viewadmin.getjTextField10().isEmpty()){
                JOptionPane.showConfirmDialog(null, "Pastikan Form Sudah di isi semua","Delete Error",JOptionPane.DEFAULT_OPTION);
            } else {
                try { 
                    String id = viewadmin.getjTextField10();
                    model.deletePenjualan(id,"1");
                    Penjualan penjualan = model.cekPenjualan(id,"1");
                    if (penjualan == null){
                        JOptionPane.showConfirmDialog(null, "Karyawan Tidak Ditemukan","Update Error",JOptionPane.DEFAULT_OPTION);
                    } else {
                        model.deletePenjualan(id,"1");
                    }
                } catch (Exception ee) { 
                    JOptionPane.showConfirmDialog(null, ee,"Input Error",JOptionPane.DEFAULT_OPTION);
                }
            }
        }
        if (a == viewadmin.getjButton11()){ //updatetransaksi
            if (viewadmin.getjTextField11().isEmpty() || viewadmin.getjTextField17().isEmpty() || viewadmin.getjTextArea2().isEmpty()|| 
                    viewadmin.getjTextField12().isEmpty() || viewadmin.getjTextField13().isEmpty() || viewadmin.getjTextField14().isEmpty() || viewadmin.getjTextField15().isEmpty() ){
                JOptionPane.showConfirmDialog(null, "Pastikan Form Sudah di isi semua","Update Error",JOptionPane.DEFAULT_OPTION);
            } else {
                try {
                    String id = viewadmin.getjTextField11(); 
                    String nama = viewadmin.getjTextField17();
                    String alamat = viewadmin.getjTextArea2();
                    String tgl = viewadmin.getjTextField12();
                    String bln = viewadmin.getjTextField13();
                    String thn = viewadmin.getjTextField14();
                    String uang = viewadmin.getjTextField15();
                    int t = Integer.parseInt(tgl);
                    int b = Integer.parseInt(bln);
                    int th = Integer.parseInt(thn);
                    int angka = Integer.parseInt(uang);
                    String tanggal = th + "-" + b + "-" + t;
                    Penjualan penjualan = model.cekPenjualan(id,"1");
                    if (penjualan == null){
                        JOptionPane.showConfirmDialog(null, "Transaksi Tidak Ditemukan","Update Error",JOptionPane.DEFAULT_OPTION);
                    } else {
                        model.updatePenjualan(id,tanggal,nama, alamat,angka,"1");
                    }
                } catch (Exception ee) { 
                    JOptionPane.showConfirmDialog(null, ee,"Update Error",JOptionPane.DEFAULT_OPTION);
                }
            }
        }
        if (a == viewadmin.getjButton12()){ //cekupdatetransaksi
            if (viewadmin.getjTextField11().isEmpty()){
                JOptionPane.showConfirmDialog(null, "Pastikan Form Sudah di isi semua","Update Error",JOptionPane.DEFAULT_OPTION);
            } else {
                try { 
                    String id = viewadmin.getjTextField11();
                    Penjualan penjualan = model.cekPenjualan(id,"1");
                    if (penjualan == null){
                        JOptionPane.showConfirmDialog(null, "Transaksi Tidak Ditemukan","Update Error",JOptionPane.DEFAULT_OPTION);
                    } else {
                        viewadmin.setjTextField17(penjualan.getNama_pelanggan());
                        viewadmin.setjTextArea2(penjualan.getAlamat_pelanggan());
                        viewadmin.setjTextField14(penjualan.getTgl_penjualan().substring(0, 4));
                        viewadmin.setjTextField13(penjualan.getTgl_penjualan().substring(5, 7));
                        viewadmin.setjTextField12(penjualan.getTgl_penjualan().substring(8));
                        viewadmin.setjTextField15(String.valueOf(penjualan.getUang()));
                    }
                } catch (Exception ee) { 
                    JOptionPane.showConfirmDialog(null, ee,"Update Error",JOptionPane.DEFAULT_OPTION);
                }
            }
        }        
        if (a == viewadmin.getjButton8()){ //cektabelbahan
            try{
                List<Bahan> bahan = new ArrayList<>();
                bahan = model.listBahan();
                Iterator<Bahan> it = bahan.iterator();
                while (it.hasNext()) {
                    Bahan b = it.next();
                    if (b.getStok_bahan()>b.getStokmin()) {
                        it.remove();
                    }
                }
                if(bahan==null) {
                    viewadmin.setDataBahan(bahan);
                    JOptionPane.showConfirmDialog(null, "Data Bahan Yang Kurang Kosong","Refresh",JOptionPane.DEFAULT_OPTION);
                } else {
                    viewadmin.setDataBahan(bahan);
                    JOptionPane.showConfirmDialog(null, "Data Sudah Di Update","Refresh",JOptionPane.DEFAULT_OPTION);
                }
            } catch (Exception ee) {
                ee.printStackTrace();//penting
                JOptionPane.showConfirmDialog(viewlogin, ""+ee.getMessage(), ""+ee.getMessage(), JOptionPane.WARNING_MESSAGE);
            }
        }
        if (a == viewadmin.getjButton9()){ //keuangan
            try{
                int[] array = new int[12];
                array = model.listKeuangan();
                if(array==null) {
                    JOptionPane.showConfirmDialog(null, "Data Keuangan Kosong","Refresh",JOptionPane.DEFAULT_OPTION);
                } else {
                    LineChart_AWT chart = new LineChart_AWT("Grafik Keuangan" ,"Data Keuangan Satu Tahun Ini",array);
                    RefineryUtilities.centerFrameOnScreen( chart );
                    chart.setVisible( true );
                    chart.setExtendedState(LineChart_AWT.MAXIMIZED_BOTH);
                    WindowAdapter windowAdapter = new WindowAdapter()
                    {
                        public void windowClosing(WindowEvent we)
                        {
                            chart.setDefaultCloseOperation(HIDE_ON_CLOSE);
                            viewadmin.setVisible(true);
                        }
                    };
                    chart.addWindowListener(windowAdapter);
                }
            } catch (Exception ee) {
                ee.printStackTrace();//penting
                JOptionPane.showConfirmDialog(viewlogin, ""+ee.getMessage(), ""+ee.getMessage(), JOptionPane.WARNING_MESSAGE);
            }
        }
    }
    
}
