/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package raniahfood.database;
import java.sql.*; 
import raniahfood.model.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
/**
 *
 * @author Asus
 */
public class Database {
    private String server = "jdbc:mysql://localhost/tubesraniah";//nama database 
    private String dbuser = "root"; 
    private String dbpasswd = ""; 
    private Statement statement = null; 
    private Connection connection = null; 
    private ResultSet rs = null; 
    
    public Database() { //constructor untuk mengkoneksikan database 
        try{ 
            Class.forName("com.mysql.jdbc.Driver"); 
        }catch(Exception e){ 
            System.out.println("Error: " + e.getMessage()); 
        } 
        connect();//manggil method connect 
    } 
    public void connect() { //method untuk mengkoneksikan database  
        try { 
            connection = DriverManager.getConnection(server, dbuser, dbpasswd); 
            statement = connection.createStatement(); 
        } catch (Exception e) { 
            throw new IllegalArgumentException(e); 
        } 
    } 
     
    public ResultSet getData(String str) { //string disini merupakan query 
        try{ 
            rs = statement.executeQuery(str); 
        }catch(Exception e){ 
            System.out.println("Error: " + e.getMessage()); 
        } 
        return rs; 
    } 
     
    public void query(String str) { //string disini merupakan query 
        try{ 
            statement.executeUpdate(str); 
        }catch(Exception e){ 
            System.out.println("Error: " + e.getMessage()); 
        } 
    }
    public List<MKaryawan> listKoki(){
         List<MKaryawan> koki=new ArrayList<>();
         try{
             String query="SELECT * FROM `karyawan` WHERE role='koki'";
             ResultSet rs=statement.executeQuery(query);
              while(rs.next()){
                 MKaryawan k = new MKaryawan(rs.getString("id_karyawan"),rs.getString("nama_karyawan"),rs.getString("password"),rs.getString("role")); 
                 koki.add(k);  
             }
             return koki;
         }catch(SQLException ex){
             System.out.println("Get data gagal");
             return null;
         }
     }


    
    public List<Bahan> listBahan(){
         List<Bahan> bahan=new ArrayList<>();
         try{
             String query="SELECT * FROM `BAHAN`";
             ResultSet rs=statement.executeQuery(query);
              while(rs.next()){
                 Bahan b = new Bahan(rs.getString("nama_bahan"),rs.getInt("stok_bahan"),rs.getString("keterangan")); 
                 bahan.add(b);  
             }
             return bahan;
         }catch(SQLException ex){
             System.out.println(ex);
             return null;
         }
     }
    
    public Bahan getBahan(String nama){
         Bahan bahan = null;
         try {
            String query = "SELECT * FROM `bahan` WHERE nama_bahan = '"+ nama+  "'";
            ResultSet rs = statement.executeQuery(query);
            if (rs.next()) {
                bahan = new Bahan(rs.getString("nama_bahan"),Integer.parseInt(rs.getString("stok_bahan")),rs.getString("keterangan"));
            }
            return bahan;
        } catch (Exception e) {
           JOptionPane.showConfirmDialog(null, e);
        }
        return bahan;
     }  
    
    public void insertBahan(String nama, int stock, String keterangan){
        try{
            String query="INSERT INTO BAHAN(nama_bahan,stok_bahan,keterangan) VALUES("+
                    "'"+nama+"',"+
                    "'"+stock+"',"+
                    "'"+keterangan+"')";
            statement.execute(query,Statement.RETURN_GENERATED_KEYS);
            ResultSet rs=statement.getGeneratedKeys();
            JOptionPane.showMessageDialog(null, "Data Bahan Telah Ditambah");
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
            System.out.println("Semua data harus terisi"+ex.toString());
        }
    }
    
    public void deleteBahan(String nama){
        try {
            String query1 = "Delete from bahan where nama_bahan='" + nama + "'";
            statement.execute(query1);
            JOptionPane.showConfirmDialog(null, "Data Berhasil Dihapus", "Delete", JOptionPane.DEFAULT_OPTION);
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "Data Tidak Ada", "Delete Error", JOptionPane.DEFAULT_OPTION);
        }
    }    
    public void updateBahan(String nama, int stock, String keterangan){
        try{
            String query="UPDATE bahan SET nama_bahan= "+
                    "'"+nama+"', stok_bahan= "+
                    "'"+stock+"', keterangan= "+
                    "'"+keterangan+"' WHERE nama_bahan = "+
                    "'"+nama+"'";
            statement.execute(query,Statement.RETURN_GENERATED_KEYS);
            ResultSet rs=statement.getGeneratedKeys();
            JOptionPane.showMessageDialog(null, "Data Bahan Berhasil Di Update");
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
            System.out.println("Semua data harus terisi"+ex.toString());
        }
    }    
    
   public List<Produk> listProduk(){
         List<Produk> produk=new ArrayList<>();
         try{
             String query="SELECT * FROM `Produk`";
             ResultSet rs=statement.executeQuery(query);
              while(rs.next()){
                 Produk p = new Produk(rs.getString("nama_produk"),rs.getInt("stok_produk")); 
                 produk.add(p);  
             }
             return produk;
         }catch(SQLException ex){
             System.out.println(ex);
             return null;
         }
     }
   
    public Produk getProduk(String nama){
         Produk produk = null;
         try {
            String query = "SELECT * FROM `produk` WHERE nama_produk = '"+ nama+  "'";
            ResultSet rs = statement.executeQuery(query);
            if (rs.next()) {
                produk = new Produk(rs.getString("nama_produk"),Integer.parseInt(rs.getString("stok_produk")));
            }
            return produk;
        } catch (Exception e) {
           JOptionPane.showConfirmDialog(null, e);
        }
        return produk;
     }  
    
    public void insertProduk(String nama, int stock){
        try{
            String query="INSERT INTO Produk(nama_produk,stok_produk) VALUES("+
                    "'"+nama+"',"+
                    "'"+stock+"')";
            statement.execute(query,Statement.RETURN_GENERATED_KEYS);
            ResultSet rs=statement.getGeneratedKeys();
            JOptionPane.showMessageDialog(null, "Data Produk Telah Ditambah");
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
            System.out.println("Semua data harus terisi"+ex.toString());
        }
    }
    
    public void deleteProduk(String nama){
        try {
            String query1 = "Delete from Produk where nama_produk='" + nama + "'";
            statement.execute(query1);
            JOptionPane.showConfirmDialog(null, "Data Berhasil Dihapus", "Delete", JOptionPane.DEFAULT_OPTION);
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "Data Tidak Ada", "Delete Error", JOptionPane.DEFAULT_OPTION);
        }
    }    
    
    public void updateProduk(String nama, int stock){
        try{
            String query="UPDATE produk SET nama_produk= "+
                    "'"+nama+"', stok_produk= "+
                    "'"+stock+"' WHERE nama_produk = "+
                    "'"+nama+"'";
            statement.execute(query,Statement.RETURN_GENERATED_KEYS);
            ResultSet rs=statement.getGeneratedKeys();
            JOptionPane.showMessageDialog(null, "Data Produk Berhasil Di Update");
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
            System.out.println("Semua data harus terisi"+ex.toString());
        }
    }
    
   public List<MKaryawan> listKaryawan(){
         List<MKaryawan> karyawan=new ArrayList<>();
         try{
             String query="SELECT * FROM `Karyawan`";
             ResultSet rs=statement.executeQuery(query);
              while(rs.next()){
                 MKaryawan k = new MKaryawan(rs.getString("id_karyawan"),rs.getString("nama_karyawan"),rs.getString("password_karyawan"),rs.getString("role"));
                 karyawan.add(k);  
             }
             return karyawan;
         }catch(SQLException ex){
             System.out.println(ex);
             return null;
         }
     }
   
    public MKaryawan getKaryawan(String id,String password){
         MKaryawan koki = null;
         try {
            String query = "SELECT * FROM `karyawan` WHERE id_karyawan = '"+ id+  "' and password_karyawan = '"+ password + "'";
            ResultSet rs = statement.executeQuery(query);
            if (rs.next()) {
                koki = new MKaryawan(rs.getString("id_karyawan"),rs.getString("nama_karyawan"),rs.getString("password_karyawan"),rs.getString("role"));
            }
            return koki;
        } catch (Exception e) {
           JOptionPane.showConfirmDialog(null, e);
        }
        return koki;
     }    
    public MKaryawan cekKaryawan(String username){
         MKaryawan koki = null;
         try {
            String query = "SELECT * FROM `karyawan` WHERE id_karyawan = '"+ username+ "'";
            ResultSet rs = statement.executeQuery(query);
            if (rs.next()) {
                koki = new MKaryawan(rs.getString("id_karyawan"),rs.getString("nama_karyawan"),rs.getString("password_karyawan"),rs.getString("role"));
            }
            return koki;
        } catch (Exception e) {
           JOptionPane.showConfirmDialog(null, e);
        }
        return koki;
     }  
    public void insertKaryawan(String username, String nama,String password,String role){
        try{
            String query="INSERT INTO `karyawan`(`id_karyawan`, `nama_karyawan`, `password_karyawan`, `role`) VALUES("+
                    "'"+username+"',"+
                    "'"+nama+"',"+
                    "'"+password+"',"+
                    "'"+role+"')";
            statement.execute(query,Statement.RETURN_GENERATED_KEYS);
            ResultSet rs=statement.getGeneratedKeys();
            JOptionPane.showMessageDialog(null, "Data Karyawan Telah Ditambah");
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
            System.out.println("Semua data harus terisi"+ex.toString());
        }
    }
    
    public void deleteKaryawan(String username){
        try {
            String query1 = "Delete from Karyawan where id_karyawan='" + username + "'";
            statement.execute(query1);
            JOptionPane.showConfirmDialog(null, "Data Berhasil Dihapus", "Delete", JOptionPane.DEFAULT_OPTION);
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "Data Tidak Ada", "Delete Error", JOptionPane.DEFAULT_OPTION);
        }
    }    
    
    public void updateKaryawan(String username, String nama,String password,String role){
        try{
            String query="UPDATE karyawan SET id_karyawan= "+
                    "'"+username+"', nama_karyawan= "+
                    "'"+nama+"', password_karyawan= "+
                    "'"+password+"', role= "+
                    "'"+role+"' WHERE id_karyawan= "+
                    "'"+username+"'";
            statement.execute(query,Statement.RETURN_GENERATED_KEYS);
            ResultSet rs=statement.getGeneratedKeys();
            JOptionPane.showMessageDialog(null, "Data Karyawan Berhasil Di Update");
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
            System.out.println("Semua data harus terisi"+ex.toString());
        }
    }
    //sini kebawah transaksi
   public List<Penjualan> listPenjualan(){
         List<Penjualan> penjualan=new ArrayList<>();
         try{
             String query="SELECT * FROM `Penjualan` where status = '0'";
             ResultSet rs=statement.executeQuery(query);
              while(rs.next()){
                 Penjualan p = new Penjualan(rs.getString("id"),rs.getString("tgl_penjualan"),rs.getString("nama_pelanggan"),
                        rs.getString("alamat_pelanggan"),Integer.parseInt(rs.getString("uang")),rs.getString("status")); 
                 penjualan.add(p);  
             }
             return penjualan;
         }catch(SQLException ex){
             System.out.println(ex);
             return null;
         }
     }
      public List<Penjualan> listTransaksi(){
         List<Penjualan> penjualan=new ArrayList<>();
         try{
             String query="SELECT * FROM `Penjualan` where status = '1'";
             ResultSet rs=statement.executeQuery(query);
              while(rs.next()){
                 Penjualan p = new Penjualan(rs.getString("id"),rs.getString("tgl_penjualan"),rs.getString("nama_pelanggan"),
                        rs.getString("alamat_pelanggan"),Integer.parseInt(rs.getString("uang")),rs.getString("status")); 
                 penjualan.add(p);  
             }
             return penjualan;
         }catch(SQLException ex){
             System.out.println(ex);
             return null;
         }
     }
   
   
    public Penjualan getPenjualan(String id,String Status){
         Penjualan penjualan = null;
         try {
            String query = "SELECT * FROM `Penjualan` where id='" + id + "' AND status='" + Status + "'";
            ResultSet rs = statement.executeQuery(query);
            if (rs.next()) {
                penjualan = new Penjualan(rs.getString("id"),rs.getString("tgl_penjualan"),rs.getString("nama_pelanggan"),
                        rs.getString("alamat_pelanggan"),Integer.parseInt(rs.getString("uang")),rs.getString("status"));
            }
            return penjualan;
        } catch (Exception e) {
           JOptionPane.showConfirmDialog(null, e);
        }
        return penjualan;
     }  
    
    public void insertPenjualan(String id, String tgl, String nama, String alamat, int uang,String status){
        try{
            String query="INSERT INTO Penjualan(id,tgl_penjualan,nama_pelanggan,alamat_pelanggan,uang,status) VALUES("+
                    ""+id+","+
                    "'"+tgl+"',"+
                    "'"+nama+"',"+
                    "'"+alamat+"',"+
                    "'"+uang+"',"+
                    "'"+status+"')";
            statement.execute(query,Statement.RETURN_GENERATED_KEYS);
            ResultSet rs=statement.getGeneratedKeys();
            JOptionPane.showMessageDialog(null, "Data Telah Ditambah");
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Pastikan Tanggal sudah terisi dengan benar");
            System.out.println("Semua data harus terisi"+ex.toString());
        }
    }
    
    public void deletePenjualan(String id,String Status){
        try {
            String query1 = "Delete from penjualan where id='" + id + "' AND status='" + Status + "'";
            statement.execute(query1);
            JOptionPane.showConfirmDialog(null, "Data Berhasil Dihapus", "Delete", JOptionPane.DEFAULT_OPTION);
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "Data Tidak Ada", "Delete Error", JOptionPane.DEFAULT_OPTION);
        }
    }    
    
    public void updatePenjualan(String id, String tgl, String nama, String alamat, int uang, String status){
        try{
            String query="UPDATE penjualan SET id= "+
                    "'"+id+"', tgl_penjualan= "+
                    "'"+tgl+"', nama_pelanggan= "+
                    "'"+nama+"', alamat_pelanggan= "+
                    "'"+alamat+"', uang= "+
                    "'"+uang+"', status= "+
                    "'"+status+"' WHERE id = "+
                    "'"+id+"'";
            statement.execute(query,Statement.RETURN_GENERATED_KEYS);
            ResultSet rs=statement.getGeneratedKeys();
            JOptionPane.showMessageDialog(null, "Data Penjualan Berhasil Di Update");
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Pastikan Tanggal sudah terisi dengan benar");
            System.out.println("Semua data harus terisi"+ex.toString());
        }
    }
}

