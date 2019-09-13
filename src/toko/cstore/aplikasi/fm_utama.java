/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toko.cstore.aplikasi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import javax.swing.table.DefaultTableModel;
import toko.cstore.koneksi.kdb;
import toko.cstore.koneksi.kdb_trx;

/**
 *
 * @author User
 */
public class fm_utama extends javax.swing.JFrame {

    /**
     * Creates new form fm_utama
     */
    public fm_utama() {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        Locale locale = new Locale ("id", "ID");
        Locale.setDefault(locale);
        tgl_coy();
        jam_coy();
        chk1();
        chk2();
        chk3();
        chk4();
        chk5();
        chk6();
        chk7();
        cmb_user();
        cmb_stat();
        cmb_stat1();
        panel_trans_pulsa.setVisible(false);
        panel_tentang.setVisible(false);
        panel_trans_barang.setVisible(false);
        panel_add_user.setVisible(false);
        panel_kd_harga_pulsa.setVisible(false);
        panel_saldo_pulsa.setVisible(false);
        panel_kd_harga_barang.setVisible(false);
        panel_stock_barang.setVisible(false);
        panel_laporan_pulsa.setVisible(false);
        panel_laporan_barang.setVisible(false);
        panel_pengeluaran_barang.setVisible(false);
    }
    
    public void cmb_user(){
        cmb_user.addItem("---- Pilih ----");
        cmb_user.addItem("Admin");
        cmb_user.addItem("Kasir");
    }
    
    public void cmb_stat(){
        cmb_stat_pulsa.addItem("---- Pilih ----");
        cmb_stat_pulsa.addItem("Sudah Bayar");
        cmb_stat_pulsa.addItem("Belum Bayar");
    }
    
    public void cmb_stat1(){
        cmb_stat_pulsa1.addItem("---- Pilih ----");
        cmb_stat_pulsa1.addItem("Sudah Bayar");
        cmb_stat_pulsa1.addItem("Belum Bayar");
    }
    
    public void chk1(){
        if(chk_transaksi.isSelected()==true){
            panel_transaksi.setVisible(true);
        }else{
            panel_transaksi.setVisible(false);
        }
    }
    
    public void chk2(){
        if(chk_data.isSelected()==true){
            panel_data.setVisible(true);
        }else{
            panel_data.setVisible(false);
        }
    }
    
    public void chk3(){
        if(chk_pulsa1.isSelected()==true){
            panel_pulsa1.setVisible(true);
        }else{
            panel_pulsa1.setVisible(false);
        }
    }
    
    public void chk4(){
        if(chk_barang1.isSelected()==true){
            panel_barang1.setVisible(true);
        }else{
            panel_barang1.setVisible(false);
        }
    }
    
    public void chk5(){
        if(chk_laporan.isSelected()==true){
            panel_laporan.setVisible(true);
        }else{
            panel_laporan.setVisible(false);
        }
    }
    
    public void chk6(){
        if(chk_pulsa2.isSelected()==true){
            panel_pulsa2.setVisible(true);
        }else{
            panel_pulsa2.setVisible(false);
        }
    }
    
    public void chk7(){
        if(chk_barang2.isSelected()==true){
            panel_barang2.setVisible(true);
        }else{
            panel_barang2.setVisible(false);
        }
    }

    //untuk menampilkan tanggal
    public void tgl_coy(){
        Date sekarang = new Date();
        SimpleDateFormat kal = new SimpleDateFormat ("dd-MM-yyyy") ;
        txt_tgl.setText(kal.format(sekarang));
    }

    //untuk menampilkan jam
    public void jam_coy(){
        ActionListener taskPerformer = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                String nol_jam="",nol_menit="",nol_detik="";
                Date waktu = new Date();
                int get_jam = waktu.getHours();
                int get_menit = waktu.getMinutes();
                int get_detik = waktu.getSeconds();  
                if(get_jam<=9){
                    nol_jam="0";
                }
                if(get_menit<=9){
                    nol_menit="0";
                }
                if(get_detik<=9){
                    nol_detik="0";
                }
                String jam = nol_jam + Integer.toString(get_jam);
                String menit = nol_menit + Integer.toString(get_menit);
                String detik = nol_detik + Integer.toString(get_detik);
                txt_jam.setText(jam + ":" + menit + ":" + detik);
            }
        };
        new Timer(1000, taskPerformer).start();
    }
    
    public void bersih(){
        txt_nama_user.setText("");
        txt_nama.setText("");
        txt_pass_user.setText("");
        cmb_user.setSelectedItem("---- Pilih ----");
    }
    
    public void bersih_pulsa(){
        txt_kd_pulsa.setText("");
        txt_nominal_pulsa.setText("");
        txt_harga_pulsa1.setText("");
    }
    
    public void bersih_saldo(){
        txt_saldo_terpakai.setText("");
        txt_saldo_tambah.setText("");
    }
    
    public void bersih_trans_pls(){
        btn_indosat.setEnabled(true);
        btn_telkomsel.setEnabled(true);
        btn_xl.setEnabled(true);
        btn_axis.setEnabled(true);
        btn_three.setEnabled(true);
        btn_bolt.setEnabled(true);
        btn_token.setEnabled(true);
        btn_smartfren.setEnabled(true);
        btn_gojek.setEnabled(true);
        btn_etoll.setEnabled(true);
        txt_nama_cus.setText("");
        txt_no_cus.setText("");
        txt_provider1.setText("Provider");
        txt_harga_pulsa.setText("");
        txt_tgl_pulsa.setDate(null);
        cmb_nominal.removeAllItems();
        cmb_nominal.addItem("---- Pilih ----");
        cmb_stat_pulsa.setSelectedItem("---- Pilih ----");
    }
    
    public void bersih_harga(){
        txt_kd_barang.setText("");
        txt_nama_barang.setText("");
        txt_harga_barang.setText("");
    }

    public void bersih_stock(){
        txt_kd_barang1.setText("");
        txt_nama_barang1.setText("");
        txt_stock_awal.setText("");
        txt_stock_tambah.setText("");
    }
    
    public void bersih_trans_barang(){
        txt_kd_barang_trans.setText("");
        txt_stock.setText("");
        txt_harga_trans.setText("");
        txt_total_jmlh.setText("");
        txt_jmlh.setText("");
    }
    
    public void tmbl_pulsa(){
        smpn_kd_pls.setEnabled(false);
        batal_kd_pls.setEnabled(true);
        hapus_kd_pls.setEnabled(false);
        tmbh_kd_pls.setEnabled(true);
        edit_kd_pls.setEnabled(false);
        kembali_kd_pls.setEnabled(true);
    }
    
    public void tmbl_saldo(){
        tmbh_saldo_pls.setEnabled(true);
        edit_saldo_pls.setEnabled(false);
        smpn_saldo_pls.setEnabled(false);
        batal_saldo_pls.setEnabled(true);
        kembali_saldo_pls.setEnabled(true);
    }
    
    public void tmbl_harga(){
        tmbh_kd_barang.setEnabled(true);
        edit_kd_barang.setEnabled(false);
        smpn_kd_barang.setEnabled(false);
        batal_kd_barang.setEnabled(true);
        hapus_kd_barang.setEnabled(false);
        kembali_kd_barang.setEnabled(true);
    }

    public void tmbl_transaksi_barang(){
        btn_transaksi_baru.setEnabled(true);
        btn_tambah_transaksi.setEnabled(false);
        btn_batal_transaksi.setEnabled(false);
        btn_kembali_barang.setEnabled(true);
    }
    
    public void auto_no(){
        Connection koneksi = kdb.getConnection();
	try{
            Statement stmt = koneksi.createStatement();
            String sql = "SELECT MAX(RIGHT(no_transaksi,5)) AS NO FROM tbl_transaksi";
            ResultSet rsjual = stmt.executeQuery(sql);
            while (rsjual.next()) {
                if (rsjual.first() == false) {
                    txt_no_transaksi.setText("CSTROE-00001");
                } else {
                    rsjual.last();
                    int auto_id = rsjual.getInt(1) + 1;
                    String no = String.valueOf(auto_id);
                    int NomorJual = no.length();
                    //MENGATUR jumlah 0
                    for (int j = 0; j < 5 - NomorJual; j++) {
                        no = "0" + no;
                    }
                    txt_no_transaksi.setText("CSTORE-"+no);
                }
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void daftar_user(){
        Connection koneksi = kdb.getConnection();
        if(cmb_user.getSelectedItem().equals("Admin")){
            String pass = txt_pass_user.getText();
            if(txt_nama_user.getText().trim().equals("")){
                JOptionPane.showMessageDialog(null, "Silahkan input nama id anda");
                txt_nama_user.requestFocus();
            }else if(txt_nama.getText().trim().equals("")){
                JOptionPane.showMessageDialog(null, "Silahkan input nama anda");
                txt_nama.requestFocus();
            }else if(txt_pass_user.getText().trim().equals("")){
                JOptionPane.showMessageDialog(null, "Silahkan input password anda");
                txt_pass_user.requestFocus();
            }else if(pass.matches("[a-z]*")){                  
                JOptionPane.showMessageDialog(null, "Inputan pass hanya dengan angka");
                txt_pass_user.setText("");
                txt_pass_user.requestFocus();
            }else{
                try{
                    Statement stmt = koneksi.createStatement();
                    String sql_admin = "INSERT INTO tbl_admin(user_name,nama_kasir,password) VALUES('"+txt_nama_user.getText()+"','"+txt_nama.getText()+"',md5('"+String.valueOf(txt_pass_user.getPassword())+"'))";
                    stmt.executeUpdate(sql_admin);
                    bersih();
                    JOptionPane.showMessageDialog(rootPane, "Anda Telah Mendaftar");
                }catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Anda Gagal Mendaftar", "Pesan", JOptionPane.WARNING_MESSAGE);
                }
            }  
        }else if(cmb_user.getSelectedItem().equals("Kasir")){
            String pass = txt_pass_user.getText();
            if(txt_nama_user.getText().trim().equals("")){
                JOptionPane.showMessageDialog(null, "Silahkan input nama anda");
                txt_nama_user.requestFocus();
            }else if(txt_nama.getText().trim().equals("")){
                JOptionPane.showMessageDialog(null, "Silahkan input nama anda");
                txt_nama.requestFocus();
            }else if(txt_pass_user.getText().trim().equals("")){
                JOptionPane.showMessageDialog(null, "Silahkan input password anda");
                txt_pass_user.requestFocus();
            }else if(pass.matches("[a-z]*")){                  
                JOptionPane.showMessageDialog(null, "Inputan pass hanya dengan angka");
                txt_pass_user.setText("");
                txt_pass_user.requestFocus();
            }else{
                try{
                    Statement stmt = koneksi.createStatement();
                    String sql_client = "INSERT INTO tbl_kasir(user_name,nama_kasir,password) VALUES('"+txt_nama_user.getText()+"','"+txt_nama.getText()+"',md5('"+String.valueOf(txt_pass_user.getPassword())+"'))";
                    stmt.executeUpdate(sql_client);
                    bersih();
                    JOptionPane.showMessageDialog(rootPane, "Anda Telah Mendaftar");
                }catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Anda Gagal Mendaftar", "Pesan", JOptionPane.WARNING_MESSAGE);
                }
            }   
        }else{
            JOptionPane.showMessageDialog(null, "Silahkan pilih SERVER terlebih dahulu", "Peringatan", JOptionPane.INFORMATION_MESSAGE);            
        }
    }
    
    public void tabel_indosat(){
        Connection koneksi = kdb_trx.getConnection();
        Object[] Baris={"Kode Pulsa","Nominal","Harga"};
        DefaultTableModel tabel = new DefaultTableModel(null, Baris);
        tbl_kd_harga_pulsa.setModel(tabel);
        try{
            String sql="Select * from tbl_indosat order by kd_trx asc";
            Statement stmt=koneksi.createStatement();
            ResultSet rs=stmt.executeQuery(sql);
            while(rs.next()){
                String kode_pulsa = rs.getString("kd_trx");
                String nominal_pulsa = rs.getString("nominal");
                String harga_pulsa = rs.getString("harga");
                String[] dataField={kode_pulsa, nominal_pulsa, harga_pulsa};
                tabel.addRow(dataField);
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Menampilkan Data Ke Tabel GAGAL");
        }
    }
    
    public void tabel_telkomsel(){
        Connection koneksi = kdb_trx.getConnection();
        Object[] Baris={"Kode Pulsa","Nominal","Harga"};
        DefaultTableModel tabel = new DefaultTableModel(null, Baris);
        tbl_kd_harga_pulsa.setModel(tabel);
        try{
            String sql="Select * from tbl_telkomsel order by kd_trx asc";
            Statement stmt=koneksi.createStatement();
            ResultSet rs=stmt.executeQuery(sql);
            while(rs.next()){
                String kode_pulsa = rs.getString("kd_trx");
                String nominal_pulsa = rs.getString("nominal");
                String harga_pulsa = rs.getString("harga");
                String[] dataField={kode_pulsa, nominal_pulsa, harga_pulsa};
                tabel.addRow(dataField);
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Menampilkan Data Ke Tabel GAGAL");
        }
    }
    
    public void tabel_xl(){
        Connection koneksi = kdb_trx.getConnection();
        Object[] Baris={"Kode Pulsa","Nominal","Harga"};
        DefaultTableModel tabel = new DefaultTableModel(null, Baris);
        tbl_kd_harga_pulsa.setModel(tabel);
        try{
            String sql="Select * from tbl_xl order by kd_trx asc";
            Statement stmt=koneksi.createStatement();
            ResultSet rs=stmt.executeQuery(sql);
            while(rs.next()){
                String kode_pulsa = rs.getString("kd_trx");
                String nominal_pulsa = rs.getString("nominal");
                String harga_pulsa = rs.getString("harga");
                String[] dataField={kode_pulsa, nominal_pulsa, harga_pulsa};
                tabel.addRow(dataField);
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Menampilkan Data Ke Tabel GAGAL");
        }
    }
    
    public void tabel_axis(){
        Connection koneksi = kdb_trx.getConnection();
        Object[] Baris={"Kode Pulsa","Nominal","Harga"};
        DefaultTableModel tabel = new DefaultTableModel(null, Baris);
        tbl_kd_harga_pulsa.setModel(tabel);
        try{
            String sql="Select * from tbl_axis order by kd_trx asc";
            Statement stmt=koneksi.createStatement();
            ResultSet rs=stmt.executeQuery(sql);
            while(rs.next()){
                String kode_pulsa = rs.getString("kd_trx");
                String nominal_pulsa = rs.getString("nominal");
                String harga_pulsa = rs.getString("harga");
                String[] dataField={kode_pulsa, nominal_pulsa, harga_pulsa};
                tabel.addRow(dataField);
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Menampilkan Data Ke Tabel GAGAL");
        }
    }
    
    public void tabel_gojek(){
        Connection koneksi = kdb_trx.getConnection();
        Object[] Baris={"Kode Pulsa","Nominal","Harga"};
        DefaultTableModel tabel = new DefaultTableModel(null, Baris);
        tbl_kd_harga_pulsa.setModel(tabel);
        try{
            String sql="Select * from tbl_gojek order by kd_trx asc";
            Statement stmt=koneksi.createStatement();
            ResultSet rs=stmt.executeQuery(sql);
            while(rs.next()){
                String kode_pulsa = rs.getString("kd_trx");
                String nominal_pulsa = rs.getString("nominal");
                String harga_pulsa = rs.getString("harga");
                String[] dataField={kode_pulsa, nominal_pulsa, harga_pulsa};
                tabel.addRow(dataField);
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Menampilkan Data Ke Tabel GAGAL");
        }
    }
    
    public void tabel_three(){
        Connection koneksi = kdb_trx.getConnection();
        Object[] Baris={"Kode Pulsa","Nominal","Harga"};
        DefaultTableModel tabel = new DefaultTableModel(null, Baris);
        tbl_kd_harga_pulsa.setModel(tabel);
        try{
            String sql="Select * from tbl_three order by kd_trx asc";
            Statement stmt=koneksi.createStatement();
            ResultSet rs=stmt.executeQuery(sql);
            while(rs.next()){
                String kode_pulsa = rs.getString("kd_trx");
                String nominal_pulsa = rs.getString("nominal");
                String harga_pulsa = rs.getString("harga");
                String[] dataField={kode_pulsa, nominal_pulsa, harga_pulsa};
                tabel.addRow(dataField);
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Menampilkan Data Ke Tabel GAGAL");
        }
    }
    
    public void tabel_bolt(){
        Connection koneksi = kdb_trx.getConnection();
        Object[] Baris={"Kode Pulsa","Nominal","Harga"};
        DefaultTableModel tabel = new DefaultTableModel(null, Baris);
        tbl_kd_harga_pulsa.setModel(tabel);
        try{
            String sql="Select * from tbl_bolt order by kd_trx asc";
            Statement stmt=koneksi.createStatement();
            ResultSet rs=stmt.executeQuery(sql);
            while(rs.next()){
                String kode_pulsa = rs.getString("kd_trx");
                String nominal_pulsa = rs.getString("nominal");
                String harga_pulsa = rs.getString("harga");
                String[] dataField={kode_pulsa, nominal_pulsa, harga_pulsa};
                tabel.addRow(dataField);
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Menampilkan Data Ke Tabel GAGAL");
        }
    }
    
    public void tabel_token(){
        Connection koneksi = kdb_trx.getConnection();
        Object[] Baris={"Kode Pulsa","Nominal","Harga"};
        DefaultTableModel tabel = new DefaultTableModel(null, Baris);
        tbl_kd_harga_pulsa.setModel(tabel);
        try{
            String sql="Select * from tbl_token order by kd_trx asc";
            Statement stmt=koneksi.createStatement();
            ResultSet rs=stmt.executeQuery(sql);
            while(rs.next()){
                String kode_pulsa = rs.getString("kd_trx");
                String nominal_pulsa = rs.getString("nominal");
                String harga_pulsa = rs.getString("harga");
                String[] dataField={kode_pulsa, nominal_pulsa, harga_pulsa};
                tabel.addRow(dataField);
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Menampilkan Data Ke Tabel GAGAL");
        }
    }
    
    public void tabel_smartfren(){
        Connection koneksi = kdb_trx.getConnection();
        Object[] Baris={"Kode Pulsa","Nominal","Harga"};
        DefaultTableModel tabel = new DefaultTableModel(null, Baris);
        tbl_kd_harga_pulsa.setModel(tabel);
        try{
            String sql="Select * from tbl_smartfren order by kd_trx asc";
            Statement stmt=koneksi.createStatement();
            ResultSet rs=stmt.executeQuery(sql);
            while(rs.next()){
                String kode_pulsa = rs.getString("kd_trx");
                String nominal_pulsa = rs.getString("nominal");
                String harga_pulsa = rs.getString("harga");
                String[] dataField={kode_pulsa, nominal_pulsa, harga_pulsa};
                tabel.addRow(dataField);
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Menampilkan Data Ke Tabel GAGAL");
        }
    }

    public void tabel_etoll(){
        Connection koneksi = kdb_trx.getConnection();
        Object[] Baris={"Kode Pulsa","Nominal","Harga"};
        DefaultTableModel tabel = new DefaultTableModel(null, Baris);
        tbl_kd_harga_pulsa.setModel(tabel);
        try{
            String sql="Select * from tbl_etoll order by kd_trx asc";
            Statement stmt=koneksi.createStatement();
            ResultSet rs=stmt.executeQuery(sql);
            while(rs.next()){
                String kode_pulsa = rs.getString("kd_trx");
                String nominal_pulsa = rs.getString("nominal");
                String harga_pulsa = rs.getString("harga");
                String[] dataField={kode_pulsa, nominal_pulsa, harga_pulsa};
                tabel.addRow(dataField);
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Menampilkan Data Ke Tabel GAGAL");
        }
    }
    
    public void tabel_saldo(){
        Connection koneksi = kdb.getConnection();
        Object[] Baris={"Tanggal","Awal","Tambah","Terpakai","Sisa"};
        DefaultTableModel tabel = new DefaultTableModel(null, Baris);
        tbl_saldo.setModel(tabel);
        try{
            String sql="Select * from tbl_saldo order by tanggal asc";
            Statement stmt=koneksi.createStatement();
            ResultSet rs=stmt.executeQuery(sql);
            while(rs.next()){
                String tanggal = rs.getString("tanggal");
                String awal = rs.getString("awal");
                String tambah = rs.getString("tambah");
                String terpakai = rs.getString("terpakai");
                String sisa = rs.getString("sisa");
                String[] dataField={tanggal,awal,tambah,terpakai,sisa};
                tabel.addRow(dataField);
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Menampilkan Data Ke Tabel GAGAL");
        }
        try{
            String sql="SELECT * FROM tbl_saldo ORDER BY sisa DESC LIMIT 1";
            Statement stmt=koneksi.createStatement();
            ResultSet rs=stmt.executeQuery(sql);
            if(rs.next()){
                txt_saldo_awal.setText(rs.getString("sisa"));
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Menampilkan Data GAGAL");
        }
    }
    
    public void tabel_barang_harga(){
        Connection koneksi = kdb.getConnection();
        Object[] Baris={"Kode Barang","Nama Barang","Harga"};
        DefaultTableModel tabel = new DefaultTableModel(null, Baris);
        tbl_kd_harga_barang.setModel(tabel);
        try{
            String sql="Select * from tbl_barang order by kd_barang asc";
            Statement stmt=koneksi.createStatement();
            ResultSet rs=stmt.executeQuery(sql);
            while(rs.next()){
                String kd_barang = rs.getString("kd_barang");
                String nm_barang = rs.getString("nm_barang");
                String harga = rs.getString("harga");
                String[] dataField={kd_barang,nm_barang,harga};
                tabel.addRow(dataField);
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Menampilkan Data Ke Tabel GAGAL");
        }
    }
    
    public void tabel_barang_stock(){
        Connection koneksi = kdb.getConnection();
        Object[] Baris={"Tanggal","Kode Barang","Nama Barang","Harga"};
        DefaultTableModel tabel = new DefaultTableModel(null, Baris);
        tbl_stock_barang.setModel(tabel);
        try{
            String sql="Select * from tbl_barang order by kd_barang asc";
            Statement stmt=koneksi.createStatement();
            ResultSet rs=stmt.executeQuery(sql);
            while(rs.next()){
                String kd_barang = rs.getString("kd_barang");
                String nm_barang = rs.getString("nm_barang");
                String stock = rs.getString("stock");
                String tanggal = rs.getString("tanggal");
                String[] dataField={tanggal,kd_barang,nm_barang,stock};
                tabel.addRow(dataField);
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Menampilkan Data Ke Tabel GAGAL");
        }
    }
    
    public void tabel_transaksi(){
        Connection koneksi = kdb.getConnection();
        Object[] Baris={"Nama Barang","Jumlah Barang","Harga Barang","Total"};
        DefaultTableModel tabel = new DefaultTableModel(null, Baris);
        tbl_trans_barang.setModel(tabel);
        try{
            String sql="Select * from tbl_transaksi where no_transaksi like '%"+ txt_no_transaksi.getText() + "%'";
            Statement stmt=koneksi.createStatement();
            ResultSet rs=stmt.executeQuery(sql);
            while(rs.next()){
                String nm_barang = rs.getString("nm_barang");
                String jmlh_barang = rs.getString("jmlh_barang");
                String hrg_barang = rs.getString("hrg_barang");
                String total = rs.getString("total");
                String[] dataField={nm_barang,jmlh_barang,hrg_barang,total};
                tabel.addRow(dataField);
            }
            int totalBiaya = 0;
            for (int i=0; i< tbl_trans_barang.getRowCount(); i++){
                int amount = Integer.parseInt((String)tbl_trans_barang.getValueAt(i, 3));
                totalBiaya += amount;
            }
            txt_total_transaksi.setText(""+totalBiaya);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Menampilkan Data Ke Tabel GAGAL");
        }
    }

    public void tabel_filter_trx_pls(){
        Connection koneksi = kdb_trx.getConnection();
        Object[] Baris={"Tanggal","Nama Customer","Provider","Nomer","Nominal","Harga","Status Pembayaran"};
        DefaultTableModel tabel = new DefaultTableModel(null, Baris);
        tbl_trx_pls.setModel(tabel);
        try{
            String sql="Select * from tbl_trans_pls where no_trans_pls like '%"+ txt_cari_nama.getText() + "%'AND stat_trans like '%" + cmb_stat_pulsa1.getSelectedItem() + "%'";
            Statement stmt=koneksi.createStatement();
            ResultSet rs=stmt.executeQuery(sql);
            while(rs.next()){
                String tanggal = rs.getString("tgl_trans");
                String nama_customer = rs.getString("nm_cus_trans");
                String provider = rs.getString("provider_trans");
                String nomer = rs.getString("no_cus_trans");
                String nominal = rs.getString("nominal_pls");
                String harga = rs.getString("harga_pls");
                String status_pembayaran = rs.getString("stat_trans");
                String[] dataField={tanggal, nama_customer, provider, nomer, nominal,harga,status_pembayaran};
                tabel.addRow(dataField);
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Menampilkan Data Ke Tabel GAGAL");
        }
    }
    
    public void runReportDefault(String sourcefilename, HashMap hash) {
        Connection koneksi = kdb.getConnection();
        try {
            InputStream report;
            report = getClass().getResourceAsStream(sourcefilename);
            JasperPrint jprint = JasperFillManager.fillReport(report,hash, koneksi);
            JasperViewer viewer = new JasperViewer(jprint, false);
            viewer.setFitPageZoomRatio();
            viewer.setVisible(true);
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }
        
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_tgl = new javax.swing.JLabel();
        txt_jam = new javax.swing.JLabel();
        txt_user = new javax.swing.JLabel();
        txt_nama_kasir = new javax.swing.JLabel();
        menu = new javax.swing.JScrollPane();
        panelmenu = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        chk_transaksi = new javax.swing.JCheckBox();
        panel_transaksi = new javax.swing.JPanel();
        btn_pulsa = new javax.swing.JButton();
        btn_barang = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        chk_data = new javax.swing.JCheckBox();
        panel_data = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        chk_pulsa1 = new javax.swing.JCheckBox();
        panel_pulsa1 = new javax.swing.JPanel();
        kd_harga_pulsa = new javax.swing.JButton();
        stk_pulsa = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        chk_barang1 = new javax.swing.JCheckBox();
        panel_barang1 = new javax.swing.JPanel();
        kd_harga_barang = new javax.swing.JButton();
        stk_barang = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        chk_laporan = new javax.swing.JCheckBox();
        panel_laporan = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        chk_pulsa2 = new javax.swing.JCheckBox();
        panel_pulsa2 = new javax.swing.JPanel();
        trans_pulsa = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        chk_barang2 = new javax.swing.JCheckBox();
        panel_barang2 = new javax.swing.JPanel();
        trans_barang = new javax.swing.JButton();
        data_barang = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        panel_utama = new javax.swing.JPanel();
        bg_toko1 = new toko.cstore.gambar.bg_toko();
        panel_add_user = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        cmb_user = new javax.swing.JComboBox();
        jLabel27 = new javax.swing.JLabel();
        txt_nama_user = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        txt_nama = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        txt_pass_user = new javax.swing.JPasswordField();
        jPanel5 = new javax.swing.JPanel();
        btn_batal_user = new javax.swing.JButton();
        btn_kembali_user = new javax.swing.JButton();
        btn_tmbh_user = new javax.swing.JButton();
        panel_tentang = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        lbl_kembali = new javax.swing.JLabel();
        panel_trans_pulsa = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        txt_nama_cus = new javax.swing.JTextField();
        jPanel13 = new javax.swing.JPanel();
        btn_indosat = new javax.swing.JButton();
        btn_telkomsel = new javax.swing.JButton();
        btn_xl = new javax.swing.JButton();
        btn_axis = new javax.swing.JButton();
        btn_three = new javax.swing.JButton();
        btn_bolt = new javax.swing.JButton();
        btn_token = new javax.swing.JButton();
        btn_smartfren = new javax.swing.JButton();
        btn_gojek = new javax.swing.JButton();
        btn_etoll = new javax.swing.JButton();
        jPanel18 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        txt_no_cus = new javax.swing.JTextField();
        jPanel16 = new javax.swing.JPanel();
        cmb_nominal = new javax.swing.JComboBox();
        jPanel17 = new javax.swing.JPanel();
        txt_harga_pulsa = new javax.swing.JTextField();
        jPanel19 = new javax.swing.JPanel();
        txt_tgl_pulsa = new com.toedter.calendar.JDateChooser();
        txt_provider1 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        cmb_stat_pulsa = new javax.swing.JComboBox();
        btn_tmbh_data_pulsa = new javax.swing.JButton();
        btn_batal_data_pulsa = new javax.swing.JButton();
        btn_kembali_pulsa = new javax.swing.JButton();
        panel_trans_barang = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbl_trans_barang = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jPanel27 = new javax.swing.JPanel();
        txt_no_transaksi = new javax.swing.JTextField();
        jPanel28 = new javax.swing.JPanel();
        tgl_transaksi = new javax.swing.JLabel();
        jPanel29 = new javax.swing.JPanel();
        txt_kd_barang_trans = new javax.swing.JTextField();
        jPanel30 = new javax.swing.JPanel();
        txt_stock = new javax.swing.JTextField();
        jPanel31 = new javax.swing.JPanel();
        txt_harga_trans = new javax.swing.JTextField();
        jPanel32 = new javax.swing.JPanel();
        txt_jmlh = new javax.swing.JTextField();
        jPanel34 = new javax.swing.JPanel();
        txt_total_jmlh = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txt_total_transaksi1 = new javax.swing.JLabel();
        txt_total_transaksi = new javax.swing.JLabel();
        txt_bayar = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txt_total_transaksi2 = new javax.swing.JLabel();
        txt_kembalian = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        btn_transaksi_baru = new javax.swing.JButton();
        btn_tambah_transaksi = new javax.swing.JButton();
        btn_batal_transaksi = new javax.swing.JButton();
        btn_kembali_barang = new javax.swing.JButton();
        btn_print_transaksi = new javax.swing.JButton();
        panel_kd_harga_pulsa = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        btn_indosat1 = new javax.swing.JButton();
        btn_telkomsel1 = new javax.swing.JButton();
        btn_xl1 = new javax.swing.JButton();
        btn_axis1 = new javax.swing.JButton();
        btn_three1 = new javax.swing.JButton();
        btn_bolt1 = new javax.swing.JButton();
        btn_token1 = new javax.swing.JButton();
        btn_smartfren1 = new javax.swing.JButton();
        btn_gojek1 = new javax.swing.JButton();
        btn_etoll1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        txt_provider = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_kd_harga_pulsa = new javax.swing.JTable();
        txt_cari_kd_pulsa = new javax.swing.JTextField();
        jPanel21 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        txt_kd_pulsa = new javax.swing.JTextField();
        txt_nominal_pulsa = new javax.swing.JTextField();
        jLabel54 = new javax.swing.JLabel();
        txt_harga_pulsa1 = new javax.swing.JTextField();
        tmbh_kd_pls = new javax.swing.JButton();
        edit_kd_pls = new javax.swing.JButton();
        smpn_kd_pls = new javax.swing.JButton();
        batal_kd_pls = new javax.swing.JButton();
        hapus_kd_pls = new javax.swing.JButton();
        kembali_kd_pls = new javax.swing.JButton();
        panel_saldo_pulsa = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_saldo = new javax.swing.JTable();
        jPanel10 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        txt_saldo_tambah = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        txt_saldo_terpakai = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        txt_tgl_saldo = new javax.swing.JLabel();
        txt_saldo_awal = new javax.swing.JTextField();
        tmbh_saldo_pls = new javax.swing.JButton();
        edit_saldo_pls = new javax.swing.JButton();
        smpn_saldo_pls = new javax.swing.JButton();
        batal_saldo_pls = new javax.swing.JButton();
        kembali_saldo_pls = new javax.swing.JButton();
        panel_kd_harga_barang = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_kd_harga_barang = new javax.swing.JTable();
        txt_cari_kd_barang = new javax.swing.JTextField();
        jPanel22 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        txt_kd_barang = new javax.swing.JTextField();
        txt_nama_barang = new javax.swing.JTextField();
        txt_harga_barang = new javax.swing.JTextField();
        tmbh_kd_barang = new javax.swing.JButton();
        edit_kd_barang = new javax.swing.JButton();
        smpn_kd_barang = new javax.swing.JButton();
        batal_kd_barang = new javax.swing.JButton();
        hapus_kd_barang = new javax.swing.JButton();
        kembali_kd_barang = new javax.swing.JButton();
        panel_stock_barang = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbl_stock_barang = new javax.swing.JTable();
        jPanel23 = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        txt_stock_awal = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        txt_tgl_barang = new javax.swing.JLabel();
        txt_stock_tambah = new javax.swing.JTextField();
        txt_kd_barang1 = new javax.swing.JTextField();
        txt_nama_barang1 = new javax.swing.JTextField();
        edit_stock_barang = new javax.swing.JButton();
        smpn_stock_barang = new javax.swing.JButton();
        batal_stock_barang = new javax.swing.JButton();
        kembali_stock_barang = new javax.swing.JButton();
        txt_cari_barang = new javax.swing.JTextField();
        panel_laporan_pulsa = new javax.swing.JPanel();
        jPanel24 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tbl_trx_pls = new javax.swing.JTable();
        jLabel44 = new javax.swing.JLabel();
        txt_total_transaksi3 = new javax.swing.JLabel();
        txt_penjualan_pulsa = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        cmb_stat_pulsa1 = new javax.swing.JComboBox();
        txt_cari_nama = new javax.swing.JTextField();
        filter_penjualan_pulsa = new javax.swing.JButton();
        edit_penjualan_pulsa = new javax.swing.JButton();
        kembali_penjualan_pulsa = new javax.swing.JButton();
        btn_print_transaksi1 = new javax.swing.JButton();
        jPanel33 = new javax.swing.JPanel();
        txt_no_trans = new javax.swing.JLabel();
        txt_nama_trans = new javax.swing.JLabel();
        txt_no_user = new javax.swing.JLabel();
        txt_nominal_trans = new javax.swing.JLabel();
        cmb_stat_pulsa2 = new javax.swing.JComboBox();
        simpan_penjualan_pulsa = new javax.swing.JButton();
        batal_penjualan_pulsa = new javax.swing.JButton();
        panel_laporan_barang = new javax.swing.JPanel();
        jPanel25 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        tabel_lap_transaksi = new javax.swing.JTable();
        jLabel45 = new javax.swing.JLabel();
        txt_total_transaksi4 = new javax.swing.JLabel();
        txt_penjualan_barang = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        txt_tgl_awal = new com.toedter.calendar.JDateChooser();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        txt_tgl_akhir = new com.toedter.calendar.JDateChooser();
        filter_penjualan_barang = new javax.swing.JButton();
        kembali_penjualan_barang = new javax.swing.JButton();
        btn_print_barang = new javax.swing.JButton();
        panel_pengeluaran_barang = new javax.swing.JPanel();
        jPanel26 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tbl_pengeluaran = new javax.swing.JTable();
        jLabel49 = new javax.swing.JLabel();
        txt_penjualan_barang1 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        filter_pengeluaran = new javax.swing.JButton();
        kembali_pengeluaran = new javax.swing.JButton();
        txt_tgl_awal1 = new com.toedter.calendar.JDateChooser();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        txt_tgl_akhir1 = new com.toedter.calendar.JDateChooser();
        btn_pengeluaran = new javax.swing.JButton();
        txt_cari_barang1 = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        menu_menu = new javax.swing.JMenu();
        about = new javax.swing.JMenuItem();
        user = new javax.swing.JMenuItem();
        login = new javax.swing.JMenuItem();
        exit = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Toko C-Store");
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel1.setFont(new java.awt.Font("Transformers Movie", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("TOKO C-STORE");

        txt_tgl.setFont(new java.awt.Font("A GALEGA", 0, 18)); // NOI18N
        txt_tgl.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txt_tgl.setText("TANGGAL");

        txt_jam.setFont(new java.awt.Font("A GALEGA", 0, 18)); // NOI18N
        txt_jam.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txt_jam.setText("JAM");

        txt_user.setFont(new java.awt.Font("A GALEGA", 0, 18)); // NOI18N
        txt_user.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        txt_user.setText("USER");

        txt_nama_kasir.setFont(new java.awt.Font("A GALEGA", 0, 18)); // NOI18N
        txt_nama_kasir.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        txt_nama_kasir.setText("Nama");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_jam, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_tgl, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 545, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(151, 151, 151)
                        .addComponent(txt_user, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_nama_kasir, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(txt_tgl)
                        .addGap(16, 16, 16)
                        .addComponent(txt_jam))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(txt_user)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_nama_kasir)))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        menu.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        panelmenu.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel2.setText(".: Transaksi");

        chk_transaksi.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        chk_transaksi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/toko/cstore/gambar/Uparrow2.png"))); // NOI18N
        chk_transaksi.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/toko/cstore/gambar/Uparrow2.png"))); // NOI18N
        chk_transaksi.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/toko/cstore/gambar/downarrow2.png"))); // NOI18N
        chk_transaksi.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/toko/cstore/gambar/downarrow2.png"))); // NOI18N
        chk_transaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chk_transaksiActionPerformed(evt);
            }
        });

        btn_pulsa.setText("Pulsa");
        btn_pulsa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pulsaActionPerformed(evt);
            }
        });

        btn_barang.setText("Barang");
        btn_barang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_barangActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_transaksiLayout = new javax.swing.GroupLayout(panel_transaksi);
        panel_transaksi.setLayout(panel_transaksiLayout);
        panel_transaksiLayout.setHorizontalGroup(
            panel_transaksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_transaksiLayout.createSequentialGroup()
                .addGroup(panel_transaksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_barang, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                    .addComponent(btn_pulsa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panel_transaksiLayout.setVerticalGroup(
            panel_transaksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_transaksiLayout.createSequentialGroup()
                .addComponent(btn_pulsa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_barang)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel3.setText(".: Data");

        chk_data.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        chk_data.setIcon(new javax.swing.ImageIcon(getClass().getResource("/toko/cstore/gambar/Uparrow2.png"))); // NOI18N
        chk_data.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/toko/cstore/gambar/Uparrow2.png"))); // NOI18N
        chk_data.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/toko/cstore/gambar/downarrow2.png"))); // NOI18N
        chk_data.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/toko/cstore/gambar/downarrow2.png"))); // NOI18N
        chk_data.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chk_dataActionPerformed(evt);
            }
        });

        jLabel5.setText(".: Pulsa");

        chk_pulsa1.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        chk_pulsa1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/toko/cstore/gambar/Uparrow2.png"))); // NOI18N
        chk_pulsa1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/toko/cstore/gambar/Uparrow2.png"))); // NOI18N
        chk_pulsa1.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/toko/cstore/gambar/downarrow2.png"))); // NOI18N
        chk_pulsa1.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/toko/cstore/gambar/downarrow2.png"))); // NOI18N
        chk_pulsa1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chk_pulsa1ActionPerformed(evt);
            }
        });

        kd_harga_pulsa.setText("Kode & Harga");
        kd_harga_pulsa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kd_harga_pulsaActionPerformed(evt);
            }
        });

        stk_pulsa.setText("Stock");
        stk_pulsa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stk_pulsaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_pulsa1Layout = new javax.swing.GroupLayout(panel_pulsa1);
        panel_pulsa1.setLayout(panel_pulsa1Layout);
        panel_pulsa1Layout.setHorizontalGroup(
            panel_pulsa1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_pulsa1Layout.createSequentialGroup()
                .addGroup(panel_pulsa1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(kd_harga_pulsa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                    .addComponent(stk_pulsa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE))
                .addContainerGap())
        );
        panel_pulsa1Layout.setVerticalGroup(
            panel_pulsa1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_pulsa1Layout.createSequentialGroup()
                .addComponent(kd_harga_pulsa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(stk_pulsa)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel6.setText(".: Barang");

        chk_barang1.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        chk_barang1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/toko/cstore/gambar/Uparrow2.png"))); // NOI18N
        chk_barang1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/toko/cstore/gambar/Uparrow2.png"))); // NOI18N
        chk_barang1.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/toko/cstore/gambar/downarrow2.png"))); // NOI18N
        chk_barang1.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/toko/cstore/gambar/downarrow2.png"))); // NOI18N
        chk_barang1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chk_barang1ActionPerformed(evt);
            }
        });

        kd_harga_barang.setText("Kode & Harga");
        kd_harga_barang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kd_harga_barangActionPerformed(evt);
            }
        });

        stk_barang.setText("Stock");
        stk_barang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stk_barangActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_barang1Layout = new javax.swing.GroupLayout(panel_barang1);
        panel_barang1.setLayout(panel_barang1Layout);
        panel_barang1Layout.setHorizontalGroup(
            panel_barang1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_barang1Layout.createSequentialGroup()
                .addGroup(panel_barang1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(kd_harga_barang, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                    .addComponent(stk_barang, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE))
                .addContainerGap())
        );
        panel_barang1Layout.setVerticalGroup(
            panel_barang1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_barang1Layout.createSequentialGroup()
                .addComponent(kd_harga_barang)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(stk_barang)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panel_dataLayout = new javax.swing.GroupLayout(panel_data);
        panel_data.setLayout(panel_dataLayout);
        panel_dataLayout.setHorizontalGroup(
            panel_dataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_dataLayout.createSequentialGroup()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chk_pulsa1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panel_dataLayout.createSequentialGroup()
                .addGroup(panel_dataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel_pulsa1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panel_dataLayout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chk_barang1))
                    .addGroup(panel_dataLayout.createSequentialGroup()
                        .addComponent(panel_barang1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 4, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        panel_dataLayout.setVerticalGroup(
            panel_dataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_dataLayout.createSequentialGroup()
                .addGroup(panel_dataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(chk_pulsa1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel_pulsa1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_dataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(chk_barang1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel_barang1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel4.setText(".: Laporan");

        chk_laporan.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        chk_laporan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/toko/cstore/gambar/Uparrow2.png"))); // NOI18N
        chk_laporan.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/toko/cstore/gambar/Uparrow2.png"))); // NOI18N
        chk_laporan.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/toko/cstore/gambar/downarrow2.png"))); // NOI18N
        chk_laporan.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/toko/cstore/gambar/downarrow2.png"))); // NOI18N
        chk_laporan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chk_laporanActionPerformed(evt);
            }
        });

        jLabel8.setText(".: Pulsa");

        chk_pulsa2.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        chk_pulsa2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/toko/cstore/gambar/Uparrow2.png"))); // NOI18N
        chk_pulsa2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/toko/cstore/gambar/Uparrow2.png"))); // NOI18N
        chk_pulsa2.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/toko/cstore/gambar/downarrow2.png"))); // NOI18N
        chk_pulsa2.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/toko/cstore/gambar/downarrow2.png"))); // NOI18N
        chk_pulsa2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chk_pulsa2ActionPerformed(evt);
            }
        });

        trans_pulsa.setText("Penjualan");
        trans_pulsa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trans_pulsaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_pulsa2Layout = new javax.swing.GroupLayout(panel_pulsa2);
        panel_pulsa2.setLayout(panel_pulsa2Layout);
        panel_pulsa2Layout.setHorizontalGroup(
            panel_pulsa2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_pulsa2Layout.createSequentialGroup()
                .addComponent(trans_pulsa, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                .addContainerGap())
        );
        panel_pulsa2Layout.setVerticalGroup(
            panel_pulsa2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(trans_pulsa)
        );

        jLabel9.setText(".: Barang");

        chk_barang2.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        chk_barang2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/toko/cstore/gambar/Uparrow2.png"))); // NOI18N
        chk_barang2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/toko/cstore/gambar/Uparrow2.png"))); // NOI18N
        chk_barang2.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/toko/cstore/gambar/downarrow2.png"))); // NOI18N
        chk_barang2.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/toko/cstore/gambar/downarrow2.png"))); // NOI18N
        chk_barang2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chk_barang2ActionPerformed(evt);
            }
        });

        trans_barang.setText("Penjualan");
        trans_barang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trans_barangActionPerformed(evt);
            }
        });

        data_barang.setText("Pengeluaran");
        data_barang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                data_barangActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_barang2Layout = new javax.swing.GroupLayout(panel_barang2);
        panel_barang2.setLayout(panel_barang2Layout);
        panel_barang2Layout.setHorizontalGroup(
            panel_barang2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_barang2Layout.createSequentialGroup()
                .addGroup(panel_barang2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(data_barang, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                    .addComponent(trans_barang, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panel_barang2Layout.setVerticalGroup(
            panel_barang2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_barang2Layout.createSequentialGroup()
                .addComponent(trans_barang)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(data_barang)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panel_laporanLayout = new javax.swing.GroupLayout(panel_laporan);
        panel_laporan.setLayout(panel_laporanLayout);
        panel_laporanLayout.setHorizontalGroup(
            panel_laporanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_laporanLayout.createSequentialGroup()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chk_pulsa2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panel_laporanLayout.createSequentialGroup()
                .addGroup(panel_laporanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel_pulsa2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panel_laporanLayout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chk_barang2))
                    .addGroup(panel_laporanLayout.createSequentialGroup()
                        .addComponent(panel_barang2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 4, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        panel_laporanLayout.setVerticalGroup(
            panel_laporanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_laporanLayout.createSequentialGroup()
                .addGroup(panel_laporanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(chk_pulsa2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel_pulsa2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_laporanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(chk_barang2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel_barang2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelmenuLayout = new javax.swing.GroupLayout(panelmenu);
        panelmenu.setLayout(panelmenuLayout);
        panelmenuLayout.setHorizontalGroup(
            panelmenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelmenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelmenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelmenuLayout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chk_transaksi)
                        .addGap(137, 137, 137))
                    .addGroup(panelmenuLayout.createSequentialGroup()
                        .addGroup(panelmenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panel_transaksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelmenuLayout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(chk_data))
                            .addComponent(panel_data, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelmenuLayout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(chk_laporan))
                            .addComponent(panel_laporan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        panelmenuLayout.setVerticalGroup(
            panelmenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelmenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelmenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chk_transaksi)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel_transaksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelmenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chk_data)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel_data, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelmenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chk_laporan)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel_laporan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(808, 808, 808))
        );

        menu.setViewportView(panelmenu);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        javax.swing.GroupLayout bg_toko1Layout = new javax.swing.GroupLayout(bg_toko1);
        bg_toko1.setLayout(bg_toko1Layout);
        bg_toko1Layout.setHorizontalGroup(
            bg_toko1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 841, Short.MAX_VALUE)
        );
        bg_toko1Layout.setVerticalGroup(
            bg_toko1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 811, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panel_utamaLayout = new javax.swing.GroupLayout(panel_utama);
        panel_utama.setLayout(panel_utamaLayout);
        panel_utamaLayout.setHorizontalGroup(
            panel_utamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg_toko1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panel_utamaLayout.setVerticalGroup(
            panel_utamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg_toko1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        panel_add_user.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tambah User", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Premier League with Lion Number", 1, 12))); // NOI18N

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/toko/cstore/gambar/account-profile-user-icon--icon-search-engine-101.png"))); // NOI18N
        jLabel25.setText("jLabel8");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel25)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Data User", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel26.setText("Level User");

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel27.setText("User Name");

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel28.setText("Nama");

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel29.setText("Password");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel26, javax.swing.GroupLayout.Alignment.LEADING))
                    .addComponent(jLabel29))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_nama)
                            .addComponent(txt_nama_user, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                            .addComponent(txt_pass_user))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(cmb_user, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(cmb_user, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel27)
                    .addComponent(txt_nama_user, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(txt_nama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(txt_pass_user, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        btn_batal_user.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btn_batal_user.setIcon(new javax.swing.ImageIcon(getClass().getResource("/toko/cstore/gambar/exit - Copy.png"))); // NOI18N
        btn_batal_user.setText("Batal");
        btn_batal_user.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_batal_user.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_batal_user.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_batal_userActionPerformed(evt);
            }
        });

        btn_kembali_user.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btn_kembali_user.setIcon(new javax.swing.ImageIcon(getClass().getResource("/toko/cstore/gambar/2leftarrow.png"))); // NOI18N
        btn_kembali_user.setText("Kembali");
        btn_kembali_user.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_kembali_user.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_kembali_user.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_kembali_userActionPerformed(evt);
            }
        });

        btn_tmbh_user.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btn_tmbh_user.setIcon(new javax.swing.ImageIcon(getClass().getResource("/toko/cstore/gambar/baru - Copy (2).png"))); // NOI18N
        btn_tmbh_user.setText("Tambah");
        btn_tmbh_user.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_tmbh_user.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_tmbh_user.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tmbh_userActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_tmbh_user)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_batal_user)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_kembali_user)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_batal_user, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_kembali_user)
                    .addComponent(btn_tmbh_user, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout panel_add_userLayout = new javax.swing.GroupLayout(panel_add_user);
        panel_add_user.setLayout(panel_add_userLayout);
        panel_add_userLayout.setHorizontalGroup(
            panel_add_userLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_add_userLayout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 65, Short.MAX_VALUE))
            .addGroup(panel_add_userLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel_add_userLayout.setVerticalGroup(
            panel_add_userLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_add_userLayout.createSequentialGroup()
                .addGroup(panel_add_userLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(153, 153, 153));
        jPanel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel11.setFont(new java.awt.Font("Premier League with Lion Number", 1, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Tentang Aplikasi");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/toko/cstore/gambar/aap07-1.png"))); // NOI18N

        jLabel13.setFont(new java.awt.Font("Premier League with Lion Number", 1, 12)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Version : Beta 1.0.01");

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Hak Cipta © 2018 aap07.");

        lbl_kembali.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        lbl_kembali.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_kembali.setIcon(new javax.swing.ImageIcon(getClass().getResource("/toko/cstore/gambar/2leftarrow.png"))); // NOI18N
        lbl_kembali.setText("Kembali");
        lbl_kembali.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_kembaliMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lbl_kembali, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jLabel12)
                .addGap(18, 18, 18)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(lbl_kembali, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout panel_tentangLayout = new javax.swing.GroupLayout(panel_tentang);
        panel_tentang.setLayout(panel_tentangLayout);
        panel_tentangLayout.setHorizontalGroup(
            panel_tentangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panel_tentangLayout.setVerticalGroup(
            panel_tentangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_tentangLayout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panel_trans_pulsa.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Transaksi Pulsa", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Premier League with Lion Number", 1, 12))); // NOI18N

        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nama Customer", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        txt_nama_cus.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_nama_cus.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txt_nama_cus, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txt_nama_cus, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
        );

        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Provider", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        btn_indosat.setBackground(new java.awt.Color(255, 204, 0));
        btn_indosat.setFont(new java.awt.Font("Premier League with Lion Number", 1, 12)); // NOI18N
        btn_indosat.setForeground(new java.awt.Color(0, 0, 0));
        btn_indosat.setText("Indosat");
        btn_indosat.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_indosat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_indosatActionPerformed(evt);
            }
        });

        btn_telkomsel.setBackground(new java.awt.Color(255, 0, 0));
        btn_telkomsel.setFont(new java.awt.Font("Premier League with Lion Number", 1, 12)); // NOI18N
        btn_telkomsel.setForeground(new java.awt.Color(0, 0, 0));
        btn_telkomsel.setText("Telkomsel");
        btn_telkomsel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_telkomsel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_telkomselActionPerformed(evt);
            }
        });

        btn_xl.setBackground(new java.awt.Color(0, 0, 255));
        btn_xl.setFont(new java.awt.Font("Premier League with Lion Number", 1, 12)); // NOI18N
        btn_xl.setForeground(new java.awt.Color(0, 0, 0));
        btn_xl.setText("XL");
        btn_xl.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_xl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xlActionPerformed(evt);
            }
        });

        btn_axis.setBackground(new java.awt.Color(153, 0, 153));
        btn_axis.setFont(new java.awt.Font("Premier League with Lion Number", 1, 12)); // NOI18N
        btn_axis.setForeground(new java.awt.Color(0, 0, 0));
        btn_axis.setText("Axis");
        btn_axis.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_axis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_axisActionPerformed(evt);
            }
        });

        btn_three.setBackground(new java.awt.Color(255, 255, 255));
        btn_three.setFont(new java.awt.Font("Premier League with Lion Number", 1, 12)); // NOI18N
        btn_three.setForeground(new java.awt.Color(0, 0, 0));
        btn_three.setText("Three");
        btn_three.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_three.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_threeActionPerformed(evt);
            }
        });

        btn_bolt.setBackground(new java.awt.Color(255, 102, 0));
        btn_bolt.setFont(new java.awt.Font("Premier League with Lion Number", 1, 12)); // NOI18N
        btn_bolt.setForeground(new java.awt.Color(0, 0, 0));
        btn_bolt.setText("Bolt");
        btn_bolt.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_bolt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_boltActionPerformed(evt);
            }
        });

        btn_token.setBackground(new java.awt.Color(255, 255, 0));
        btn_token.setFont(new java.awt.Font("Premier League with Lion Number", 1, 12)); // NOI18N
        btn_token.setForeground(new java.awt.Color(0, 0, 0));
        btn_token.setText("Token PLN");
        btn_token.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_token.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tokenActionPerformed(evt);
            }
        });

        btn_smartfren.setBackground(new java.awt.Color(255, 0, 0));
        btn_smartfren.setFont(new java.awt.Font("Premier League with Lion Number", 1, 12)); // NOI18N
        btn_smartfren.setForeground(new java.awt.Color(0, 0, 0));
        btn_smartfren.setText("Smartfren");
        btn_smartfren.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_smartfren.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_smartfrenActionPerformed(evt);
            }
        });

        btn_gojek.setBackground(new java.awt.Color(0, 204, 51));
        btn_gojek.setFont(new java.awt.Font("Premier League with Lion Number", 1, 12)); // NOI18N
        btn_gojek.setForeground(new java.awt.Color(0, 0, 0));
        btn_gojek.setText("Go-Jek");
        btn_gojek.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_gojek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_gojekActionPerformed(evt);
            }
        });

        btn_etoll.setBackground(new java.awt.Color(0, 0, 0));
        btn_etoll.setFont(new java.awt.Font("Premier League with Lion Number", 1, 12)); // NOI18N
        btn_etoll.setForeground(new java.awt.Color(255, 255, 255));
        btn_etoll.setText("E-Toll");
        btn_etoll.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_etoll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_etollActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(btn_indosat, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_telkomsel, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_xl, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_axis, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(btn_three, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_bolt, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_token, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_smartfren, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(btn_gojek, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_etoll, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_indosat, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_telkomsel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_xl, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_axis, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_three, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_bolt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_token, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_smartfren, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_gojek, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_etoll, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel18.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Rincian Transaksi", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        jPanel15.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nomor", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        txt_no_cus.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_no_cus.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txt_no_cus)
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txt_no_cus)
        );

        jPanel16.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nominal", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        cmb_nominal.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cmb_nominal.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "----- Pilih -----" }));
        cmb_nominal.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmb_nominalItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cmb_nominal, 0, 165, Short.MAX_VALUE)
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cmb_nominal, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
        );

        jPanel17.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Harga", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        txt_harga_pulsa.setEditable(false);
        txt_harga_pulsa.setBackground(new java.awt.Color(18, 30, 49));
        txt_harga_pulsa.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_harga_pulsa.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txt_harga_pulsa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txt_harga_pulsa)
        );

        jPanel19.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tanggal", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        txt_tgl_pulsa.setBackground(new java.awt.Color(18, 30, 49));
        txt_tgl_pulsa.setForeground(new java.awt.Color(18, 30, 49));
        txt_tgl_pulsa.setDateFormatString("dd-MM-yyyy");
        txt_tgl_pulsa.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txt_tgl_pulsa, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txt_tgl_pulsa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        txt_provider1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_provider1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        txt_provider1.setText("Provider");

        jPanel20.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Status Bayar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        cmb_stat_pulsa.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cmb_stat_pulsa, 0, 165, Short.MAX_VALUE)
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cmb_stat_pulsa, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_provider1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(txt_provider1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btn_tmbh_data_pulsa.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btn_tmbh_data_pulsa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/toko/cstore/gambar/baru - Copy (2).png"))); // NOI18N
        btn_tmbh_data_pulsa.setText("Tambah");
        btn_tmbh_data_pulsa.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_tmbh_data_pulsa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_tmbh_data_pulsa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tmbh_data_pulsaActionPerformed(evt);
            }
        });

        btn_batal_data_pulsa.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btn_batal_data_pulsa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/toko/cstore/gambar/exit - Copy.png"))); // NOI18N
        btn_batal_data_pulsa.setText("Batal");
        btn_batal_data_pulsa.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_batal_data_pulsa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_batal_data_pulsa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_batal_data_pulsaActionPerformed(evt);
            }
        });

        btn_kembali_pulsa.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btn_kembali_pulsa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/toko/cstore/gambar/2leftarrow.png"))); // NOI18N
        btn_kembali_pulsa.setText("Kembali");
        btn_kembali_pulsa.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_kembali_pulsa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_kembali_pulsa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_kembali_pulsaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_trans_pulsaLayout = new javax.swing.GroupLayout(panel_trans_pulsa);
        panel_trans_pulsa.setLayout(panel_trans_pulsaLayout);
        panel_trans_pulsaLayout.setHorizontalGroup(
            panel_trans_pulsaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_trans_pulsaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_trans_pulsaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panel_trans_pulsaLayout.createSequentialGroup()
                        .addComponent(btn_tmbh_data_pulsa, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_batal_data_pulsa, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_kembali_pulsa, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel_trans_pulsaLayout.setVerticalGroup(
            panel_trans_pulsaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_trans_pulsaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_trans_pulsaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_tmbh_data_pulsa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_batal_data_pulsa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_kembali_pulsa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panel_trans_barang.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Transaksi Barang", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Premier League with Lion Number", 1, 12))); // NOI18N
        panel_trans_barang.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        tbl_trans_barang.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tbl_trans_barang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nama Barang", "Jumlah Barang", "Harga Barang", "Total"
            }
        ));
        jScrollPane4.setViewportView(tbl_trans_barang);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Rincian Pembelian", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Premier League with Lion Number", 1, 12))); // NOI18N

        jPanel27.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "No Transaksi", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        txt_no_transaksi.setEditable(false);
        txt_no_transaksi.setBackground(new java.awt.Color(18, 30, 49));
        txt_no_transaksi.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_no_transaksi.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txt_no_transaksi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txt_no_transaksi)
        );

        jPanel28.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tgl Transaksi", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        tgl_transaksi.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tgl_transaksi.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tgl_transaksi.setText("Tanggal");

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tgl_transaksi, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tgl_transaksi, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
        );

        jPanel29.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Kode Barang", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        txt_kd_barang_trans.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_kd_barang_trans.setForeground(new java.awt.Color(0, 0, 0));
        txt_kd_barang_trans.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_kd_barang_transKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txt_kd_barang_trans, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txt_kd_barang_trans)
        );

        jPanel30.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Stock", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        txt_stock.setEditable(false);
        txt_stock.setBackground(new java.awt.Color(18, 30, 49));
        txt_stock.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_stock.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
        jPanel30.setLayout(jPanel30Layout);
        jPanel30Layout.setHorizontalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txt_stock, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txt_stock)
        );

        jPanel31.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Harga", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        txt_harga_trans.setEditable(false);
        txt_harga_trans.setBackground(new java.awt.Color(18, 30, 49));
        txt_harga_trans.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_harga_trans.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
        jPanel31.setLayout(jPanel31Layout);
        jPanel31Layout.setHorizontalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txt_harga_trans, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
        );
        jPanel31Layout.setVerticalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txt_harga_trans, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
        );

        jPanel32.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Qty", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        txt_jmlh.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_jmlh.setForeground(new java.awt.Color(0, 0, 0));
        txt_jmlh.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_jmlhKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel32Layout = new javax.swing.GroupLayout(jPanel32);
        jPanel32.setLayout(jPanel32Layout);
        jPanel32Layout.setHorizontalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txt_jmlh, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel32Layout.setVerticalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txt_jmlh)
        );

        jPanel34.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Total Harga", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        txt_total_jmlh.setEditable(false);
        txt_total_jmlh.setBackground(new java.awt.Color(18, 30, 49));
        txt_total_jmlh.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_total_jmlh.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel34Layout = new javax.swing.GroupLayout(jPanel34);
        jPanel34.setLayout(jPanel34Layout);
        jPanel34Layout.setHorizontalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txt_total_jmlh, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel34Layout.setVerticalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txt_total_jmlh, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
        );

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel20.setText("Sub Total :");

        txt_total_transaksi1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_total_transaksi1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        txt_total_transaksi1.setText("Rp. ");

        txt_total_transaksi.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_total_transaksi.setText("Total Belanja");

        txt_bayar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_bayar.setForeground(new java.awt.Color(0, 0, 0));
        txt_bayar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_bayarKeyReleased(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel21.setText("Bayar :");

        txt_total_transaksi2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_total_transaksi2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        txt_total_transaksi2.setText("Rp. ");

        txt_kembalian.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_kembalian.setText("Kembalian");

        jLabel53.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel53.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel53.setText("Kembali :");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 435, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_total_transaksi1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_total_transaksi, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(txt_bayar)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel53)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_total_transaksi2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_kembalian, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_total_transaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_total_transaksi1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_bayar)
                            .addComponent(jLabel21))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_kembalian, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_total_transaksi2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel53))
                        .addGap(51, 51, 51))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jPanel34, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel32, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(0, 0, Short.MAX_VALUE))))))
        );

        btn_transaksi_baru.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btn_transaksi_baru.setIcon(new javax.swing.ImageIcon(getClass().getResource("/toko/cstore/gambar/New.png"))); // NOI18N
        btn_transaksi_baru.setText("Transaksi Baru");
        btn_transaksi_baru.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_transaksi_baru.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_transaksi_baru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_transaksi_baruActionPerformed(evt);
            }
        });

        btn_tambah_transaksi.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btn_tambah_transaksi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/toko/cstore/gambar/baru - Copy (2).png"))); // NOI18N
        btn_tambah_transaksi.setText("Tambah");
        btn_tambah_transaksi.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_tambah_transaksi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_tambah_transaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tambah_transaksiActionPerformed(evt);
            }
        });

        btn_batal_transaksi.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btn_batal_transaksi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/toko/cstore/gambar/exit - Copy.png"))); // NOI18N
        btn_batal_transaksi.setText("Batal");
        btn_batal_transaksi.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_batal_transaksi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_batal_transaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_batal_transaksiActionPerformed(evt);
            }
        });

        btn_kembali_barang.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btn_kembali_barang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/toko/cstore/gambar/2leftarrow.png"))); // NOI18N
        btn_kembali_barang.setText("Kembali");
        btn_kembali_barang.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_kembali_barang.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_kembali_barang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_kembali_barangActionPerformed(evt);
            }
        });

        btn_print_transaksi.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btn_print_transaksi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/toko/cstore/gambar/Print.png"))); // NOI18N
        btn_print_transaksi.setText("Print Transaksi");
        btn_print_transaksi.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_print_transaksi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_print_transaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_print_transaksiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_trans_barangLayout = new javax.swing.GroupLayout(panel_trans_barang);
        panel_trans_barang.setLayout(panel_trans_barangLayout);
        panel_trans_barangLayout.setHorizontalGroup(
            panel_trans_barangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_trans_barangLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_trans_barangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane4)
                    .addGroup(panel_trans_barangLayout.createSequentialGroup()
                        .addComponent(btn_transaksi_baru, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_tambah_transaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_batal_transaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_kembali_barang, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_print_transaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        panel_trans_barangLayout.setVerticalGroup(
            panel_trans_barangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_trans_barangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panel_trans_barangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_transaksi_baru, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_tambah_transaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_batal_transaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_kembali_barang, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_print_transaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panel_kd_harga_pulsa.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Kode & Harga", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Premier League with Lion Number", 1, 12))); // NOI18N

        jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Provider", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        btn_indosat1.setBackground(new java.awt.Color(255, 204, 0));
        btn_indosat1.setFont(new java.awt.Font("Premier League with Lion Number", 1, 12)); // NOI18N
        btn_indosat1.setForeground(new java.awt.Color(0, 0, 0));
        btn_indosat1.setText("Indosat");
        btn_indosat1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_indosat1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_indosat1ActionPerformed(evt);
            }
        });

        btn_telkomsel1.setBackground(new java.awt.Color(255, 0, 0));
        btn_telkomsel1.setFont(new java.awt.Font("Premier League with Lion Number", 1, 12)); // NOI18N
        btn_telkomsel1.setForeground(new java.awt.Color(0, 0, 0));
        btn_telkomsel1.setText("Telkomsel");
        btn_telkomsel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_telkomsel1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_telkomsel1ActionPerformed(evt);
            }
        });

        btn_xl1.setBackground(new java.awt.Color(0, 0, 255));
        btn_xl1.setFont(new java.awt.Font("Premier League with Lion Number", 1, 12)); // NOI18N
        btn_xl1.setForeground(new java.awt.Color(0, 0, 0));
        btn_xl1.setText("XL");
        btn_xl1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_xl1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xl1ActionPerformed(evt);
            }
        });

        btn_axis1.setBackground(new java.awt.Color(153, 0, 153));
        btn_axis1.setFont(new java.awt.Font("Premier League with Lion Number", 1, 12)); // NOI18N
        btn_axis1.setForeground(new java.awt.Color(0, 0, 0));
        btn_axis1.setText("Axis");
        btn_axis1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_axis1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_axis1ActionPerformed(evt);
            }
        });

        btn_three1.setBackground(new java.awt.Color(255, 255, 255));
        btn_three1.setFont(new java.awt.Font("Premier League with Lion Number", 1, 12)); // NOI18N
        btn_three1.setForeground(new java.awt.Color(0, 0, 0));
        btn_three1.setText("Three");
        btn_three1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_three1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_three1ActionPerformed(evt);
            }
        });

        btn_bolt1.setBackground(new java.awt.Color(255, 102, 0));
        btn_bolt1.setFont(new java.awt.Font("Premier League with Lion Number", 1, 12)); // NOI18N
        btn_bolt1.setForeground(new java.awt.Color(0, 0, 0));
        btn_bolt1.setText("Bolt");
        btn_bolt1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_bolt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_bolt1ActionPerformed(evt);
            }
        });

        btn_token1.setBackground(new java.awt.Color(255, 255, 0));
        btn_token1.setFont(new java.awt.Font("Premier League with Lion Number", 1, 12)); // NOI18N
        btn_token1.setForeground(new java.awt.Color(0, 0, 0));
        btn_token1.setText("Token PLN");
        btn_token1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_token1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_token1ActionPerformed(evt);
            }
        });

        btn_smartfren1.setBackground(new java.awt.Color(255, 0, 0));
        btn_smartfren1.setFont(new java.awt.Font("Premier League with Lion Number", 1, 12)); // NOI18N
        btn_smartfren1.setForeground(new java.awt.Color(0, 0, 0));
        btn_smartfren1.setText("Smartfren");
        btn_smartfren1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_smartfren1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_smartfren1ActionPerformed(evt);
            }
        });

        btn_gojek1.setBackground(new java.awt.Color(0, 204, 51));
        btn_gojek1.setFont(new java.awt.Font("Premier League with Lion Number", 1, 12)); // NOI18N
        btn_gojek1.setForeground(new java.awt.Color(0, 0, 0));
        btn_gojek1.setText("Go-Jek");
        btn_gojek1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_gojek1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_gojek1ActionPerformed(evt);
            }
        });

        btn_etoll1.setBackground(new java.awt.Color(0, 0, 0));
        btn_etoll1.setFont(new java.awt.Font("Premier League with Lion Number", 1, 12)); // NOI18N
        btn_etoll1.setForeground(new java.awt.Color(255, 255, 255));
        btn_etoll1.setText("E-Toll");
        btn_etoll1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_etoll1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_etoll1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(btn_indosat1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_telkomsel1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_xl1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_axis1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_gojek1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(btn_three1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_bolt1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_token1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_smartfren1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_etoll1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_indosat1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_telkomsel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_xl1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_axis1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_gojek1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_three1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_bolt1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_token1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_smartfren1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_etoll1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txt_provider.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_provider.setText("Provider");

        tbl_kd_harga_pulsa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Kode Pulsa", "Nominal", "Harga"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_kd_harga_pulsa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_kd_harga_pulsaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_kd_harga_pulsa);

        txt_cari_kd_pulsa.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_cari_kd_pulsa.setForeground(new java.awt.Color(153, 153, 153));
        txt_cari_kd_pulsa.setText("Cari Kode Pulsa");
        txt_cari_kd_pulsa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_cari_kd_pulsaMouseClicked(evt);
            }
        });
        txt_cari_kd_pulsa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_cari_kd_pulsaKeyTyped(evt);
            }
        });

        jPanel21.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Rincian", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel23.setText("Kode Pulsa");

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel24.setText("Nominal");

        txt_kd_pulsa.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_kd_pulsa.setForeground(new java.awt.Color(0, 0, 0));

        txt_nominal_pulsa.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_nominal_pulsa.setForeground(new java.awt.Color(0, 0, 0));

        jLabel54.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel54.setText("Harga");

        txt_harga_pulsa1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_harga_pulsa1.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_kd_pulsa, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_nominal_pulsa, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_harga_pulsa1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_kd_pulsa, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_nominal_pulsa, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_harga_pulsa1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_provider, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_cari_kd_pulsa, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt_provider)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txt_cari_kd_pulsa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        tmbh_kd_pls.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        tmbh_kd_pls.setIcon(new javax.swing.ImageIcon(getClass().getResource("/toko/cstore/gambar/baru - Copy (2).png"))); // NOI18N
        tmbh_kd_pls.setText("Tambah");
        tmbh_kd_pls.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tmbh_kd_pls.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tmbh_kd_plsActionPerformed(evt);
            }
        });

        edit_kd_pls.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        edit_kd_pls.setIcon(new javax.swing.ImageIcon(getClass().getResource("/toko/cstore/gambar/file-edit-32x32 - Copy.png"))); // NOI18N
        edit_kd_pls.setText("Edit");
        edit_kd_pls.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        edit_kd_pls.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edit_kd_plsActionPerformed(evt);
            }
        });

        smpn_kd_pls.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        smpn_kd_pls.setIcon(new javax.swing.ImageIcon(getClass().getResource("/toko/cstore/gambar/save-16x16.png"))); // NOI18N
        smpn_kd_pls.setText("Simpan");
        smpn_kd_pls.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        smpn_kd_pls.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                smpn_kd_plsActionPerformed(evt);
            }
        });

        batal_kd_pls.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        batal_kd_pls.setIcon(new javax.swing.ImageIcon(getClass().getResource("/toko/cstore/gambar/exit - Copy.png"))); // NOI18N
        batal_kd_pls.setText("Batal");
        batal_kd_pls.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        batal_kd_pls.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                batal_kd_plsActionPerformed(evt);
            }
        });

        hapus_kd_pls.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        hapus_kd_pls.setIcon(new javax.swing.ImageIcon(getClass().getResource("/toko/cstore/gambar/hapus.png"))); // NOI18N
        hapus_kd_pls.setText("Hapus");
        hapus_kd_pls.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        hapus_kd_pls.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapus_kd_plsActionPerformed(evt);
            }
        });

        kembali_kd_pls.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        kembali_kd_pls.setIcon(new javax.swing.ImageIcon(getClass().getResource("/toko/cstore/gambar/2leftarrow.png"))); // NOI18N
        kembali_kd_pls.setText("Kembali");
        kembali_kd_pls.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        kembali_kd_pls.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kembali_kd_plsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_kd_harga_pulsaLayout = new javax.swing.GroupLayout(panel_kd_harga_pulsa);
        panel_kd_harga_pulsa.setLayout(panel_kd_harga_pulsaLayout);
        panel_kd_harga_pulsaLayout.setHorizontalGroup(
            panel_kd_harga_pulsaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_kd_harga_pulsaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_kd_harga_pulsaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panel_kd_harga_pulsaLayout.createSequentialGroup()
                        .addComponent(tmbh_kd_pls, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(edit_kd_pls, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(smpn_kd_pls, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(batal_kd_pls, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(hapus_kd_pls, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(kembali_kd_pls, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel_kd_harga_pulsaLayout.setVerticalGroup(
            panel_kd_harga_pulsaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_kd_harga_pulsaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panel_kd_harga_pulsaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tmbh_kd_pls, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(edit_kd_pls, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(smpn_kd_pls, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(batal_kd_pls, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hapus_kd_pls, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kembali_kd_pls, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panel_saldo_pulsa.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Saldo Pulsa", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Premier League with Lion Number", 1, 12))); // NOI18N

        tbl_saldo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Tanggal", "Awal", "Tambah", "Terpakai", "Sisa"
            }
        ));
        tbl_saldo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_saldoMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbl_saldo);

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Rincian", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Premier League with Lion Number", 1, 12))); // NOI18N

        jLabel36.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel36.setText("Awal");

        jLabel37.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel37.setText("Tambah");

        txt_saldo_tambah.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_saldo_tambah.setForeground(new java.awt.Color(0, 0, 0));

        jLabel38.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel38.setText("Terpakai");

        txt_saldo_terpakai.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_saldo_terpakai.setForeground(new java.awt.Color(0, 0, 0));

        jLabel39.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel39.setText("Tanggal");

        txt_tgl_saldo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_tgl_saldo.setText("Tanggal");

        txt_saldo_awal.setEditable(false);
        txt_saldo_awal.setBackground(new java.awt.Color(18, 30, 49));
        txt_saldo_awal.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_saldo_awal.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel37, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                    .addComponent(jLabel36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_saldo_tambah, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                    .addComponent(txt_saldo_awal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_saldo_terpakai))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_tgl_saldo, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_saldo_terpakai, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txt_saldo_awal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_tgl_saldo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_saldo_tambah, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
        );

        tmbh_saldo_pls.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        tmbh_saldo_pls.setIcon(new javax.swing.ImageIcon(getClass().getResource("/toko/cstore/gambar/baru - Copy (2).png"))); // NOI18N
        tmbh_saldo_pls.setText("Tambah");
        tmbh_saldo_pls.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tmbh_saldo_pls.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tmbh_saldo_plsActionPerformed(evt);
            }
        });

        edit_saldo_pls.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        edit_saldo_pls.setIcon(new javax.swing.ImageIcon(getClass().getResource("/toko/cstore/gambar/file-edit-32x32 - Copy.png"))); // NOI18N
        edit_saldo_pls.setText("Edit");
        edit_saldo_pls.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        edit_saldo_pls.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edit_saldo_plsActionPerformed(evt);
            }
        });

        smpn_saldo_pls.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        smpn_saldo_pls.setIcon(new javax.swing.ImageIcon(getClass().getResource("/toko/cstore/gambar/save-16x16.png"))); // NOI18N
        smpn_saldo_pls.setText("Simpan");
        smpn_saldo_pls.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        smpn_saldo_pls.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                smpn_saldo_plsActionPerformed(evt);
            }
        });

        batal_saldo_pls.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        batal_saldo_pls.setIcon(new javax.swing.ImageIcon(getClass().getResource("/toko/cstore/gambar/exit - Copy.png"))); // NOI18N
        batal_saldo_pls.setText("Batal");
        batal_saldo_pls.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        batal_saldo_pls.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                batal_saldo_plsActionPerformed(evt);
            }
        });

        kembali_saldo_pls.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        kembali_saldo_pls.setIcon(new javax.swing.ImageIcon(getClass().getResource("/toko/cstore/gambar/2leftarrow.png"))); // NOI18N
        kembali_saldo_pls.setText("Kembali");
        kembali_saldo_pls.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        kembali_saldo_pls.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kembali_saldo_plsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_saldo_pulsaLayout = new javax.swing.GroupLayout(panel_saldo_pulsa);
        panel_saldo_pulsa.setLayout(panel_saldo_pulsaLayout);
        panel_saldo_pulsaLayout.setHorizontalGroup(
            panel_saldo_pulsaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_saldo_pulsaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_saldo_pulsaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_saldo_pulsaLayout.createSequentialGroup()
                        .addComponent(tmbh_saldo_pls, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(edit_saldo_pls, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(smpn_saldo_pls, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(batal_saldo_pls, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(kembali_saldo_pls, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel_saldo_pulsaLayout.setVerticalGroup(
            panel_saldo_pulsaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_saldo_pulsaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panel_saldo_pulsaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tmbh_saldo_pls, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(edit_saldo_pls, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(smpn_saldo_pls, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(batal_saldo_pls, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kembali_saldo_pls, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panel_kd_harga_barang.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Kode & Harga", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Premier League with Lion Number", 1, 12))); // NOI18N

        tbl_kd_harga_barang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Kode Barang", "Nama Barang", "Harga"
            }
        ));
        tbl_kd_harga_barang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_kd_harga_barangMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_kd_harga_barang);

        txt_cari_kd_barang.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_cari_kd_barang.setForeground(new java.awt.Color(153, 153, 153));
        txt_cari_kd_barang.setText("Cari Kode Barang");
        txt_cari_kd_barang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_cari_kd_barangMouseClicked(evt);
            }
        });
        txt_cari_kd_barang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_cari_kd_barangKeyTyped(evt);
            }
        });

        jPanel22.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Rincian", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel31.setText("Kode Barang");

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel32.setText("Nama Barang");

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel33.setText("Harga");

        txt_kd_barang.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_kd_barang.setForeground(new java.awt.Color(0, 0, 0));

        txt_nama_barang.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_nama_barang.setForeground(new java.awt.Color(0, 0, 0));

        txt_harga_barang.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_harga_barang.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_kd_barang, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_nama_barang, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_harga_barang, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel22Layout.createSequentialGroup()
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_kd_barang, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_nama_barang, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_harga_barang, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_cari_kd_barang, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 24, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(txt_cari_kd_barang, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 10, Short.MAX_VALUE))
        );

        tmbh_kd_barang.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        tmbh_kd_barang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/toko/cstore/gambar/baru - Copy (2).png"))); // NOI18N
        tmbh_kd_barang.setText("Tambah");
        tmbh_kd_barang.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tmbh_kd_barang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tmbh_kd_barangActionPerformed(evt);
            }
        });

        edit_kd_barang.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        edit_kd_barang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/toko/cstore/gambar/file-edit-32x32 - Copy.png"))); // NOI18N
        edit_kd_barang.setText("Edit");
        edit_kd_barang.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        edit_kd_barang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edit_kd_barangActionPerformed(evt);
            }
        });

        smpn_kd_barang.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        smpn_kd_barang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/toko/cstore/gambar/save-16x16.png"))); // NOI18N
        smpn_kd_barang.setText("Simpan");
        smpn_kd_barang.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        smpn_kd_barang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                smpn_kd_barangActionPerformed(evt);
            }
        });

        batal_kd_barang.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        batal_kd_barang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/toko/cstore/gambar/exit - Copy.png"))); // NOI18N
        batal_kd_barang.setText("Batal");
        batal_kd_barang.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        batal_kd_barang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                batal_kd_barangActionPerformed(evt);
            }
        });

        hapus_kd_barang.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        hapus_kd_barang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/toko/cstore/gambar/hapus.png"))); // NOI18N
        hapus_kd_barang.setText("Hapus");
        hapus_kd_barang.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        hapus_kd_barang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapus_kd_barangActionPerformed(evt);
            }
        });

        kembali_kd_barang.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        kembali_kd_barang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/toko/cstore/gambar/2leftarrow.png"))); // NOI18N
        kembali_kd_barang.setText("Kembali");
        kembali_kd_barang.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        kembali_kd_barang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kembali_kd_barangActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_kd_harga_barangLayout = new javax.swing.GroupLayout(panel_kd_harga_barang);
        panel_kd_harga_barang.setLayout(panel_kd_harga_barangLayout);
        panel_kd_harga_barangLayout.setHorizontalGroup(
            panel_kd_harga_barangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_kd_harga_barangLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_kd_harga_barangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panel_kd_harga_barangLayout.createSequentialGroup()
                        .addComponent(tmbh_kd_barang, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(edit_kd_barang, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(smpn_kd_barang, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(batal_kd_barang, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(hapus_kd_barang, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(kembali_kd_barang, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel_kd_harga_barangLayout.setVerticalGroup(
            panel_kd_harga_barangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_kd_harga_barangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panel_kd_harga_barangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tmbh_kd_barang, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(edit_kd_barang, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(smpn_kd_barang, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(batal_kd_barang, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hapus_kd_barang, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kembali_kd_barang, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panel_stock_barang.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Stock", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Premier League with Lion Number", 1, 12))); // NOI18N

        tbl_stock_barang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Tanggal", "Kode Barang", "Nama Barang", "Stock"
            }
        ));
        jScrollPane5.setViewportView(tbl_stock_barang);

        jPanel23.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Rincian", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Premier League with Lion Number", 1, 12))); // NOI18N

        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel34.setText("Kode Barang");

        jLabel35.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel35.setText("Nama Barang");

        jLabel40.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel40.setText("Stock Awal");

        txt_stock_awal.setEditable(false);
        txt_stock_awal.setBackground(new java.awt.Color(18, 30, 49));
        txt_stock_awal.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_stock_awal.setForeground(new java.awt.Color(255, 255, 255));

        jLabel41.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel41.setText("Tambah");

        jLabel42.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel42.setText("Tanggal");

        txt_tgl_barang.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_tgl_barang.setText("Tanggal");

        txt_stock_tambah.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_stock_tambah.setForeground(new java.awt.Color(0, 0, 0));

        txt_kd_barang1.setEditable(false);
        txt_kd_barang1.setBackground(new java.awt.Color(18, 30, 49));
        txt_kd_barang1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_kd_barang1.setForeground(new java.awt.Color(255, 255, 255));

        txt_nama_barang1.setEditable(false);
        txt_nama_barang1.setBackground(new java.awt.Color(18, 30, 49));
        txt_nama_barang1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_nama_barang1.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_kd_barang1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_tgl_barang, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_nama_barang1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_stock_awal, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_stock_tambah)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_stock_awal, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_kd_barang1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_stock_tambah, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_nama_barang1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_tgl_barang, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        edit_stock_barang.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        edit_stock_barang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/toko/cstore/gambar/file-edit-32x32 - Copy.png"))); // NOI18N
        edit_stock_barang.setText("Edit");
        edit_stock_barang.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        edit_stock_barang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edit_stock_barangActionPerformed(evt);
            }
        });

        smpn_stock_barang.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        smpn_stock_barang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/toko/cstore/gambar/save-16x16.png"))); // NOI18N
        smpn_stock_barang.setText("Simpan");
        smpn_stock_barang.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        smpn_stock_barang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                smpn_stock_barangActionPerformed(evt);
            }
        });

        batal_stock_barang.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        batal_stock_barang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/toko/cstore/gambar/exit - Copy.png"))); // NOI18N
        batal_stock_barang.setText("Batal");
        batal_stock_barang.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        batal_stock_barang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                batal_stock_barangActionPerformed(evt);
            }
        });

        kembali_stock_barang.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        kembali_stock_barang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/toko/cstore/gambar/2leftarrow.png"))); // NOI18N
        kembali_stock_barang.setText("Kembali");
        kembali_stock_barang.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        kembali_stock_barang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kembali_stock_barangActionPerformed(evt);
            }
        });

        txt_cari_barang.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_cari_barang.setForeground(new java.awt.Color(153, 153, 153));
        txt_cari_barang.setText("Cari Barang");
        txt_cari_barang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_cari_barangMouseClicked(evt);
            }
        });
        txt_cari_barang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_cari_barangKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout panel_stock_barangLayout = new javax.swing.GroupLayout(panel_stock_barang);
        panel_stock_barang.setLayout(panel_stock_barangLayout);
        panel_stock_barangLayout.setHorizontalGroup(
            panel_stock_barangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_stock_barangLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_stock_barangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_stock_barangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(panel_stock_barangLayout.createSequentialGroup()
                            .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_cari_barang, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel_stock_barangLayout.createSequentialGroup()
                        .addComponent(edit_stock_barang, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(smpn_stock_barang, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(batal_stock_barang, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(kembali_stock_barang, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel_stock_barangLayout.setVerticalGroup(
            panel_stock_barangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_stock_barangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(panel_stock_barangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_cari_barang, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(panel_stock_barangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(edit_stock_barang, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(smpn_stock_barang, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(batal_stock_barang, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kembali_stock_barang, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        panel_laporan_pulsa.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Laporan Pulsa", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Premier League with Lion Number", 1, 12))); // NOI18N

        tbl_trx_pls.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Tanggal", "Nama Customer", "Provider", "Nomer", "Nominal", "Harga", "Status Pembayaran"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_trx_pls.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_trx_plsMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tbl_trx_pls);

        jLabel44.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel44.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel44.setText("Sub Total :");

        txt_total_transaksi3.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txt_total_transaksi3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        txt_total_transaksi3.setText("Rp. ");

        txt_penjualan_pulsa.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txt_penjualan_pulsa.setText("Total Belanja");

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 783, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel24Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel44)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_total_transaksi3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_penjualan_pulsa, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_penjualan_pulsa, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_total_transaksi3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel44))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel43.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel43.setText("Status Pembayaran");

        cmb_stat_pulsa1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        txt_cari_nama.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_cari_nama.setForeground(new java.awt.Color(153, 153, 153));
        txt_cari_nama.setText("Cari Nama");

        filter_penjualan_pulsa.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        filter_penjualan_pulsa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/toko/cstore/gambar/cari biru.png"))); // NOI18N
        filter_penjualan_pulsa.setText("Filter");
        filter_penjualan_pulsa.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        filter_penjualan_pulsa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filter_penjualan_pulsaActionPerformed(evt);
            }
        });

        edit_penjualan_pulsa.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        edit_penjualan_pulsa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/toko/cstore/gambar/file-edit-32x32 - Copy.png"))); // NOI18N
        edit_penjualan_pulsa.setText("Edit");
        edit_penjualan_pulsa.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        edit_penjualan_pulsa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edit_penjualan_pulsaActionPerformed(evt);
            }
        });

        kembali_penjualan_pulsa.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        kembali_penjualan_pulsa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/toko/cstore/gambar/2leftarrow.png"))); // NOI18N
        kembali_penjualan_pulsa.setText("Kembali");
        kembali_penjualan_pulsa.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        kembali_penjualan_pulsa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kembali_penjualan_pulsaActionPerformed(evt);
            }
        });

        btn_print_transaksi1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btn_print_transaksi1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/toko/cstore/gambar/Print.png"))); // NOI18N
        btn_print_transaksi1.setText("Print Transaksi");
        btn_print_transaksi1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_print_transaksi1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jPanel33.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Edit Data Transaksi", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        txt_no_trans.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_no_trans.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_no_trans.setText("1");

        txt_nama_trans.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_nama_trans.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_nama_trans.setText("Antonius Adi Pratomo");

        txt_no_user.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_no_user.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_no_user.setText("085781197518");

        txt_nominal_trans.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_nominal_trans.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_nominal_trans.setText("Paket Data 3Gb");

        cmb_stat_pulsa2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        simpan_penjualan_pulsa.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        simpan_penjualan_pulsa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/toko/cstore/gambar/save-16x16.png"))); // NOI18N
        simpan_penjualan_pulsa.setText("Simpan");
        simpan_penjualan_pulsa.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        simpan_penjualan_pulsa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpan_penjualan_pulsaActionPerformed(evt);
            }
        });

        batal_penjualan_pulsa.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        batal_penjualan_pulsa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/toko/cstore/gambar/exit - Copy.png"))); // NOI18N
        batal_penjualan_pulsa.setText("Batal");
        batal_penjualan_pulsa.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        batal_penjualan_pulsa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                batal_penjualan_pulsaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel33Layout = new javax.swing.GroupLayout(jPanel33);
        jPanel33.setLayout(jPanel33Layout);
        jPanel33Layout.setHorizontalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel33Layout.createSequentialGroup()
                        .addComponent(simpan_penjualan_pulsa, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(batal_penjualan_pulsa, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel33Layout.createSequentialGroup()
                        .addComponent(txt_no_trans, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txt_nama_trans, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txt_no_user, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txt_nominal_trans, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmb_stat_pulsa2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel33Layout.setVerticalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_no_trans, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                    .addComponent(txt_nama_trans, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_no_user, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_nominal_trans, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmb_stat_pulsa2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(simpan_penjualan_pulsa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(batal_penjualan_pulsa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout panel_laporan_pulsaLayout = new javax.swing.GroupLayout(panel_laporan_pulsa);
        panel_laporan_pulsa.setLayout(panel_laporan_pulsaLayout);
        panel_laporan_pulsaLayout.setHorizontalGroup(
            panel_laporan_pulsaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_laporan_pulsaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_laporan_pulsaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_laporan_pulsaLayout.createSequentialGroup()
                        .addGroup(panel_laporan_pulsaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel_laporan_pulsaLayout.createSequentialGroup()
                                .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cmb_stat_pulsa1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panel_laporan_pulsaLayout.createSequentialGroup()
                                .addComponent(filter_penjualan_pulsa, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(edit_penjualan_pulsa, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(kembali_penjualan_pulsa, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panel_laporan_pulsaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_cari_nama, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_print_transaksi1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panel_laporan_pulsaLayout.createSequentialGroup()
                        .addComponent(jPanel33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panel_laporan_pulsaLayout.setVerticalGroup(
            panel_laporan_pulsaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_laporan_pulsaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel_laporan_pulsaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_laporan_pulsaLayout.createSequentialGroup()
                        .addComponent(txt_cari_nama, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_print_transaksi1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel_laporan_pulsaLayout.createSequentialGroup()
                        .addGroup(panel_laporan_pulsaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel43, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                            .addComponent(cmb_stat_pulsa1))
                        .addGap(18, 18, 18)
                        .addGroup(panel_laporan_pulsaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(filter_penjualan_pulsa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(edit_penjualan_pulsa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(kembali_penjualan_pulsa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jPanel33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panel_laporan_barang.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Laporan Barang", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Premier League with Lion Number", 1, 12))); // NOI18N

        tabel_lap_transaksi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Tanggal Transaksi", "Nama Barang", "Harga Barang", "Jumlah", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane8.setViewportView(tabel_lap_transaksi);

        jLabel45.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel45.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel45.setText("Sub Total :");

        txt_total_transaksi4.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txt_total_transaksi4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        txt_total_transaksi4.setText("Rp. ");

        txt_penjualan_barang.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txt_penjualan_barang.setText("Total Belanja");

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane8)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel25Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel45)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_total_transaksi4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_penjualan_barang, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_penjualan_barang, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_total_transaksi4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel45))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel46.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel46.setText("Tanggal Awal");

        txt_tgl_awal.setBackground(new java.awt.Color(18, 30, 49));
        txt_tgl_awal.setForeground(new java.awt.Color(18, 30, 49));
        txt_tgl_awal.setDateFormatString("dd-MM-yyyy");
        txt_tgl_awal.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N

        jLabel47.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel47.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel47.setText("s/d");

        jLabel48.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel48.setText("Tanggal Akhir");

        txt_tgl_akhir.setBackground(new java.awt.Color(18, 30, 49));
        txt_tgl_akhir.setForeground(new java.awt.Color(18, 30, 49));
        txt_tgl_akhir.setDateFormatString("dd-MM-yyyy");
        txt_tgl_akhir.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N

        filter_penjualan_barang.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        filter_penjualan_barang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/toko/cstore/gambar/cari biru.png"))); // NOI18N
        filter_penjualan_barang.setText("Filter");
        filter_penjualan_barang.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        kembali_penjualan_barang.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        kembali_penjualan_barang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/toko/cstore/gambar/2leftarrow.png"))); // NOI18N
        kembali_penjualan_barang.setText("Kembali");
        kembali_penjualan_barang.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        kembali_penjualan_barang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kembali_penjualan_barangActionPerformed(evt);
            }
        });

        btn_print_barang.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btn_print_barang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/toko/cstore/gambar/Print.png"))); // NOI18N
        btn_print_barang.setText("Print Transaksi");
        btn_print_barang.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_print_barang.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout panel_laporan_barangLayout = new javax.swing.GroupLayout(panel_laporan_barang);
        panel_laporan_barang.setLayout(panel_laporan_barangLayout);
        panel_laporan_barangLayout.setHorizontalGroup(
            panel_laporan_barangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_laporan_barangLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_laporan_barangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panel_laporan_barangLayout.createSequentialGroup()
                        .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_tgl_awal, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_tgl_akhir, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 293, Short.MAX_VALUE))
                    .addGroup(panel_laporan_barangLayout.createSequentialGroup()
                        .addComponent(filter_penjualan_barang, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(kembali_penjualan_barang, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_print_barang, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        panel_laporan_barangLayout.setVerticalGroup(
            panel_laporan_barangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_laporan_barangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel_laporan_barangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_laporan_barangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel46, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_tgl_awal, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                        .addComponent(jLabel47, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panel_laporan_barangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel48, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_tgl_akhir, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel_laporan_barangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(filter_penjualan_barang, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kembali_penjualan_barang, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_print_barang, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panel_pengeluaran_barang.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Laporan Pengeluaran", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Premier League with Lion Number", 1, 12))); // NOI18N

        tbl_pengeluaran.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Tanggal Transaksi", "Kode Barang", "Nama Barang", "Jumlah"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane7.setViewportView(tbl_pengeluaran);

        jLabel49.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel49.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel49.setText("Total :");

        txt_penjualan_barang1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txt_penjualan_barang1.setText("Total");

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane7)
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel49)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_penjualan_barang1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_penjualan_barang1)
                    .addComponent(jLabel49))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel50.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel50.setText("Tanggal Awal");

        filter_pengeluaran.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        filter_pengeluaran.setIcon(new javax.swing.ImageIcon(getClass().getResource("/toko/cstore/gambar/cari biru.png"))); // NOI18N
        filter_pengeluaran.setText("Filter");
        filter_pengeluaran.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        kembali_pengeluaran.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        kembali_pengeluaran.setIcon(new javax.swing.ImageIcon(getClass().getResource("/toko/cstore/gambar/2leftarrow.png"))); // NOI18N
        kembali_pengeluaran.setText("Kembali");
        kembali_pengeluaran.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        kembali_pengeluaran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kembali_pengeluaranActionPerformed(evt);
            }
        });

        txt_tgl_awal1.setBackground(new java.awt.Color(18, 30, 49));
        txt_tgl_awal1.setForeground(new java.awt.Color(18, 30, 49));
        txt_tgl_awal1.setDateFormatString("dd-MM-yyyy");
        txt_tgl_awal1.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N

        jLabel51.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel51.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel51.setText("s/d");

        jLabel52.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel52.setText("Tanggal Akhir");

        txt_tgl_akhir1.setBackground(new java.awt.Color(18, 30, 49));
        txt_tgl_akhir1.setForeground(new java.awt.Color(18, 30, 49));
        txt_tgl_akhir1.setDateFormatString("dd-MM-yyyy");
        txt_tgl_akhir1.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N

        btn_pengeluaran.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btn_pengeluaran.setIcon(new javax.swing.ImageIcon(getClass().getResource("/toko/cstore/gambar/Print.png"))); // NOI18N
        btn_pengeluaran.setText("Print Transaksi");
        btn_pengeluaran.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_pengeluaran.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        txt_cari_barang1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_cari_barang1.setForeground(new java.awt.Color(153, 153, 153));
        txt_cari_barang1.setText("Cari Nama");

        javax.swing.GroupLayout panel_pengeluaran_barangLayout = new javax.swing.GroupLayout(panel_pengeluaran_barang);
        panel_pengeluaran_barang.setLayout(panel_pengeluaran_barangLayout);
        panel_pengeluaran_barangLayout.setHorizontalGroup(
            panel_pengeluaran_barangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_pengeluaran_barangLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_pengeluaran_barangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panel_pengeluaran_barangLayout.createSequentialGroup()
                        .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_tgl_awal1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_tgl_akhir1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 168, Short.MAX_VALUE)
                        .addComponent(txt_cari_barang1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel_pengeluaran_barangLayout.createSequentialGroup()
                        .addComponent(filter_pengeluaran, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(kembali_pengeluaran, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_pengeluaran, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        panel_pengeluaran_barangLayout.setVerticalGroup(
            panel_pengeluaran_barangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_pengeluaran_barangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_pengeluaran_barangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panel_pengeluaran_barangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panel_pengeluaran_barangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel50, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_tgl_awal1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(panel_pengeluaran_barangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel52, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_tgl_akhir1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(txt_cari_barang1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel_pengeluaran_barangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(filter_pengeluaran, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kembali_pengeluaran, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_pengeluaran, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_utama, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panel_trans_pulsa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(panel_tentang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panel_trans_barang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addComponent(panel_add_user, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panel_kd_harga_pulsa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panel_saldo_pulsa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panel_kd_harga_barang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panel_stock_barang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panel_laporan_pulsa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panel_laporan_barang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panel_pengeluaran_barang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_utama, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panel_trans_pulsa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(panel_tentang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panel_trans_barang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panel_add_user, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panel_kd_harga_pulsa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panel_saldo_pulsa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panel_kd_harga_barang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panel_stock_barang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panel_laporan_pulsa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panel_laporan_barang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panel_pengeluaran_barang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jMenuBar1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jMenuBar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuBar1.setRequestFocusEnabled(false);

        menu_menu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/toko/cstore/gambar/MENU copy.png"))); // NOI18N
        menu_menu.setText("MENU");

        about.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        about.setIcon(new javax.swing.ImageIcon(getClass().getResource("/toko/cstore/gambar/info_1.png"))); // NOI18N
        about.setText("About");
        about.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutActionPerformed(evt);
            }
        });
        menu_menu.add(about);

        user.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, 0));
        user.setIcon(new javax.swing.ImageIcon(getClass().getResource("/toko/cstore/gambar/account-profile-user-icon--icon-search-engine-10 - Copy.png"))); // NOI18N
        user.setText("Add User");
        user.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userActionPerformed(evt);
            }
        });
        menu_menu.add(user);

        login.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, 0));
        login.setIcon(new javax.swing.ImageIcon(getClass().getResource("/toko/cstore/gambar/2leftarrow.png"))); // NOI18N
        login.setText("Login");
        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });
        menu_menu.add(login);

        exit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, 0));
        exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/toko/cstore/gambar/Exit2.png"))); // NOI18N
        exit.setText("Exit");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        menu_menu.add(exit);

        jMenuBar1.add(menu_menu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginActionPerformed
        fm_login login = new fm_login();
        login.setVisible(true);
        this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_loginActionPerformed

    private void chk_transaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chk_transaksiActionPerformed
        chk1();
        // TODO add your handling code here:
    }//GEN-LAST:event_chk_transaksiActionPerformed

    private void chk_dataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chk_dataActionPerformed
        chk2();
        // TODO add your handling code here:
    }//GEN-LAST:event_chk_dataActionPerformed

    private void chk_pulsa1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chk_pulsa1ActionPerformed
        chk3();
        // TODO add your handling code here:
    }//GEN-LAST:event_chk_pulsa1ActionPerformed

    private void chk_barang1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chk_barang1ActionPerformed
        chk4();
        // TODO add your handling code here:
    }//GEN-LAST:event_chk_barang1ActionPerformed

    private void chk_laporanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chk_laporanActionPerformed
        chk5();
        // TODO add your handling code here:
    }//GEN-LAST:event_chk_laporanActionPerformed

    private void chk_pulsa2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chk_pulsa2ActionPerformed
        chk6();
        // TODO add your handling code here:
    }//GEN-LAST:event_chk_pulsa2ActionPerformed

    private void chk_barang2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chk_barang2ActionPerformed
        chk7();
        // TODO add your handling code here:
    }//GEN-LAST:event_chk_barang2ActionPerformed

    private void userActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userActionPerformed
        panel_tentang.setVisible(false);
        panel_utama.setVisible(false);
        panel_trans_pulsa.setVisible(false);
        panel_trans_barang.setVisible(false);
        panel_add_user.setVisible(true);
        panel_kd_harga_pulsa.setVisible(false);
        panel_saldo_pulsa.setVisible(false);
        panel_kd_harga_barang.setVisible(false);
        panel_stock_barang.setVisible(false);
        panel_laporan_pulsa.setVisible(false);
        panel_laporan_barang.setVisible(false);
        panel_pengeluaran_barang.setVisible(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_userActionPerformed

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        dispose();
        System.exit(0);
        // TODO add your handling code here:
    }//GEN-LAST:event_exitActionPerformed

    private void aboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutActionPerformed
        panel_tentang.setVisible(true);
        panel_utama.setVisible(false);
        panel_trans_pulsa.setVisible(false);
        panel_trans_barang.setVisible(false);
        panel_add_user.setVisible(false);
        panel_kd_harga_pulsa.setVisible(false);
        panel_saldo_pulsa.setVisible(false);
        panel_kd_harga_barang.setVisible(false);
        panel_stock_barang.setVisible(false);
        panel_laporan_pulsa.setVisible(false);
        panel_laporan_barang.setVisible(false);
        panel_pengeluaran_barang.setVisible(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_aboutActionPerformed

    private void btn_pulsaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pulsaActionPerformed
        panel_tentang.setVisible(false);
        panel_utama.setVisible(false);
        panel_trans_barang.setVisible(false);
        panel_trans_pulsa.setVisible(true);
        panel_add_user.setVisible(false);
        panel_kd_harga_pulsa.setVisible(false);
        panel_saldo_pulsa.setVisible(false);
        panel_kd_harga_barang.setVisible(false);
        panel_stock_barang.setVisible(false);
        panel_laporan_pulsa.setVisible(false);
        panel_laporan_barang.setVisible(false);
        panel_pengeluaran_barang.setVisible(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_pulsaActionPerformed

    private void lbl_kembaliMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_kembaliMouseClicked
        panel_tentang.setVisible(false);
        panel_utama.setVisible(true);
        panel_trans_pulsa.setVisible(false);
        panel_trans_barang.setVisible(false);
        panel_add_user.setVisible(false);
        panel_kd_harga_pulsa.setVisible(false);
        panel_saldo_pulsa.setVisible(false);
        panel_kd_harga_barang.setVisible(false);
        panel_stock_barang.setVisible(false);
        panel_laporan_pulsa.setVisible(false);
        panel_laporan_barang.setVisible(false);
        panel_pengeluaran_barang.setVisible(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_kembaliMouseClicked

    private void btn_barangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_barangActionPerformed
        Date sekarang = new Date();
        SimpleDateFormat kal = new SimpleDateFormat ("dd-MM-yyyy") ;
        tgl_transaksi.setText(kal.format(sekarang));
        panel_tentang.setVisible(false);
        panel_utama.setVisible(false);
        panel_trans_pulsa.setVisible(false);
        panel_add_user.setVisible(false);
        panel_trans_barang.setVisible(true);
        panel_kd_harga_pulsa.setVisible(false);
        panel_saldo_pulsa.setVisible(false);
        panel_kd_harga_barang.setVisible(false);
        panel_stock_barang.setVisible(false);
        panel_laporan_pulsa.setVisible(false);
        panel_laporan_barang.setVisible(false);
        panel_pengeluaran_barang.setVisible(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_barangActionPerformed

    private void btn_kembali_barangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_kembali_barangActionPerformed
        panel_tentang.setVisible(false);
        panel_utama.setVisible(true);
        panel_trans_pulsa.setVisible(false);
        panel_add_user.setVisible(false);
        panel_trans_barang.setVisible(false);
        panel_kd_harga_pulsa.setVisible(false);
        panel_saldo_pulsa.setVisible(false);
        panel_kd_harga_barang.setVisible(false);
        panel_stock_barang.setVisible(false);
        panel_laporan_pulsa.setVisible(false);
        panel_laporan_barang.setVisible(false);
        panel_pengeluaran_barang.setVisible(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_kembali_barangActionPerformed

    private void btn_tmbh_userActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tmbh_userActionPerformed
        //menambah user kedalam database
        daftar_user();
    }//GEN-LAST:event_btn_tmbh_userActionPerformed

    private void kembali_kd_plsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kembali_kd_plsActionPerformed
        panel_tentang.setVisible(false);
        panel_utama.setVisible(true);
        panel_trans_pulsa.setVisible(false);
        panel_add_user.setVisible(false);
        panel_trans_barang.setVisible(false);
        panel_kd_harga_pulsa.setVisible(false);
        panel_saldo_pulsa.setVisible(false);
        panel_kd_harga_barang.setVisible(false);
        panel_stock_barang.setVisible(false);
        panel_laporan_pulsa.setVisible(false);
        panel_laporan_barang.setVisible(false);
        panel_pengeluaran_barang.setVisible(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_kembali_kd_plsActionPerformed

    private void kd_harga_pulsaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kd_harga_pulsaActionPerformed
        smpn_kd_pls.setEnabled(false);
        batal_kd_pls.setEnabled(false);
        hapus_kd_pls.setEnabled(false);
        tmbh_kd_pls.setEnabled(false);
        edit_kd_pls.setEnabled(false);
        kembali_kd_pls.setEnabled(true);
        panel_tentang.setVisible(false);
        panel_utama.setVisible(false);
        panel_trans_pulsa.setVisible(false);
        panel_add_user.setVisible(false);
        panel_trans_barang.setVisible(false);
        panel_kd_harga_pulsa.setVisible(true);
        panel_saldo_pulsa.setVisible(false);
        panel_kd_harga_barang.setVisible(false);
        panel_stock_barang.setVisible(false);
        panel_laporan_pulsa.setVisible(false);
        panel_laporan_barang.setVisible(false);
        panel_pengeluaran_barang.setVisible(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_kd_harga_pulsaActionPerformed

    private void kembali_saldo_plsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kembali_saldo_plsActionPerformed
        panel_tentang.setVisible(false);
        panel_utama.setVisible(true);
        panel_trans_pulsa.setVisible(false);
        panel_add_user.setVisible(false);
        panel_trans_barang.setVisible(false);
        panel_kd_harga_pulsa.setVisible(false);
        panel_saldo_pulsa.setVisible(false);
        panel_kd_harga_barang.setVisible(false);
        panel_stock_barang.setVisible(false);
        panel_laporan_pulsa.setVisible(false);
        panel_laporan_barang.setVisible(false);
        panel_pengeluaran_barang.setVisible(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_kembali_saldo_plsActionPerformed

    private void stk_pulsaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stk_pulsaActionPerformed
        tabel_saldo();
        Date sekarang = new Date();
        SimpleDateFormat kal = new SimpleDateFormat ("dd-MM-yyyy") ;
        txt_tgl_saldo.setText(kal.format(sekarang));
        panel_tentang.setVisible(false);
        panel_utama.setVisible(false);
        panel_trans_pulsa.setVisible(false);
        panel_add_user.setVisible(false);
        panel_trans_barang.setVisible(false);
        panel_kd_harga_pulsa.setVisible(false);
        panel_saldo_pulsa.setVisible(true);
        panel_kd_harga_barang.setVisible(false);
        panel_stock_barang.setVisible(false);
        panel_laporan_pulsa.setVisible(false);
        panel_laporan_barang.setVisible(false);
        panel_pengeluaran_barang.setVisible(false);
        tmbl_saldo();
        // TODO add your handling code here:
    }//GEN-LAST:event_stk_pulsaActionPerformed

    private void kembali_kd_barangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kembali_kd_barangActionPerformed
        panel_tentang.setVisible(false);
        panel_utama.setVisible(true);
        panel_trans_pulsa.setVisible(false);
        panel_add_user.setVisible(false);
        panel_trans_barang.setVisible(false);
        panel_kd_harga_pulsa.setVisible(false);
        panel_saldo_pulsa.setVisible(false);
        panel_kd_harga_barang.setVisible(false);
        panel_stock_barang.setVisible(false);
        panel_laporan_pulsa.setVisible(false);
        panel_laporan_barang.setVisible(false);
        panel_pengeluaran_barang.setVisible(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_kembali_kd_barangActionPerformed

    private void kd_harga_barangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kd_harga_barangActionPerformed
        tabel_barang_harga();
        tmbl_harga();
        panel_tentang.setVisible(false);
        panel_utama.setVisible(false);
        panel_trans_pulsa.setVisible(false);
        panel_add_user.setVisible(false);
        panel_trans_barang.setVisible(false);
        panel_kd_harga_pulsa.setVisible(false);
        panel_saldo_pulsa.setVisible(false);
        panel_kd_harga_barang.setVisible(true);
        panel_stock_barang.setVisible(false);
        panel_laporan_pulsa.setVisible(false);
        panel_laporan_barang.setVisible(false);
        panel_pengeluaran_barang.setVisible(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_kd_harga_barangActionPerformed

    private void kembali_stock_barangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kembali_stock_barangActionPerformed
        panel_tentang.setVisible(false);
        panel_utama.setVisible(true);
        panel_trans_pulsa.setVisible(false);
        panel_add_user.setVisible(false);
        panel_trans_barang.setVisible(false);
        panel_kd_harga_pulsa.setVisible(false);
        panel_saldo_pulsa.setVisible(false);
        panel_kd_harga_barang.setVisible(false);
        panel_stock_barang.setVisible(false);
        panel_laporan_pulsa.setVisible(false);
        panel_laporan_barang.setVisible(false);
        panel_pengeluaran_barang.setVisible(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_kembali_stock_barangActionPerformed

    private void stk_barangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stk_barangActionPerformed
        tabel_barang_stock();
        Date sekarang = new Date();
        SimpleDateFormat kal = new SimpleDateFormat ("dd-MM-yyyy") ;
        txt_tgl_barang.setText(kal.format(sekarang));
        panel_tentang.setVisible(false);
        panel_utama.setVisible(false);
        panel_trans_pulsa.setVisible(false);
        panel_add_user.setVisible(false);
        panel_trans_barang.setVisible(false);
        panel_kd_harga_pulsa.setVisible(false);
        panel_saldo_pulsa.setVisible(false);
        panel_kd_harga_barang.setVisible(false);
        panel_stock_barang.setVisible(true);
        panel_laporan_pulsa.setVisible(false);
        panel_laporan_barang.setVisible(false);
        panel_pengeluaran_barang.setVisible(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_stk_barangActionPerformed

    private void kembali_penjualan_pulsaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kembali_penjualan_pulsaActionPerformed
        panel_tentang.setVisible(false);
        panel_utama.setVisible(true);
        panel_trans_pulsa.setVisible(false);
        panel_add_user.setVisible(false);
        panel_trans_barang.setVisible(false);
        panel_kd_harga_pulsa.setVisible(false);
        panel_saldo_pulsa.setVisible(false);
        panel_kd_harga_barang.setVisible(false);
        panel_stock_barang.setVisible(false);
        panel_laporan_pulsa.setVisible(false);
        panel_laporan_barang.setVisible(false);
        panel_pengeluaran_barang.setVisible(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_kembali_penjualan_pulsaActionPerformed

    private void trans_pulsaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trans_pulsaActionPerformed
        panel_tentang.setVisible(false);
        panel_utama.setVisible(false);
        panel_trans_pulsa.setVisible(false);
        panel_add_user.setVisible(false);
        panel_trans_barang.setVisible(false);
        panel_kd_harga_pulsa.setVisible(false);
        panel_saldo_pulsa.setVisible(false);
        panel_kd_harga_barang.setVisible(false);
        panel_stock_barang.setVisible(false);
        panel_laporan_pulsa.setVisible(true);
        panel_laporan_barang.setVisible(false);
        panel_pengeluaran_barang.setVisible(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_trans_pulsaActionPerformed

    private void btn_kembali_pulsaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_kembali_pulsaActionPerformed
        panel_utama.setVisible(true);
        panel_tentang.setVisible(false);
        panel_trans_pulsa.setVisible(false);
        panel_trans_barang.setVisible(false);
        panel_add_user.setVisible(false);
        panel_kd_harga_pulsa.setVisible(false);
        panel_saldo_pulsa.setVisible(false);
        panel_kd_harga_barang.setVisible(false);
        panel_stock_barang.setVisible(false);
        panel_laporan_pulsa.setVisible(false);
        panel_laporan_barang.setVisible(false);
        panel_pengeluaran_barang.setVisible(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_kembali_pulsaActionPerformed

    private void btn_kembali_userActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_kembali_userActionPerformed
        panel_tentang.setVisible(false);
        panel_utama.setVisible(true);
        panel_trans_pulsa.setVisible(false);
        panel_add_user.setVisible(false);
        panel_trans_barang.setVisible(false);
        panel_kd_harga_pulsa.setVisible(false);
        panel_saldo_pulsa.setVisible(false);
        panel_kd_harga_barang.setVisible(false);
        panel_stock_barang.setVisible(false);
        panel_laporan_pulsa.setVisible(false);
        panel_laporan_barang.setVisible(false);
        panel_pengeluaran_barang.setVisible(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_kembali_userActionPerformed

    private void btn_batal_userActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_batal_userActionPerformed
        bersih();
    }//GEN-LAST:event_btn_batal_userActionPerformed

    private void kembali_penjualan_barangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kembali_penjualan_barangActionPerformed
        panel_tentang.setVisible(false);
        panel_utama.setVisible(true);
        panel_trans_pulsa.setVisible(false);
        panel_add_user.setVisible(false);
        panel_trans_barang.setVisible(false);
        panel_kd_harga_pulsa.setVisible(false);
        panel_saldo_pulsa.setVisible(false);
        panel_kd_harga_barang.setVisible(false);
        panel_stock_barang.setVisible(false);
        panel_laporan_pulsa.setVisible(false);
        panel_laporan_barang.setVisible(false);
        panel_pengeluaran_barang.setVisible(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_kembali_penjualan_barangActionPerformed

    private void trans_barangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trans_barangActionPerformed
        panel_tentang.setVisible(false);
        panel_utama.setVisible(false);
        panel_trans_pulsa.setVisible(false);
        panel_add_user.setVisible(false);
        panel_trans_barang.setVisible(false);
        panel_kd_harga_pulsa.setVisible(false);
        panel_saldo_pulsa.setVisible(false);
        panel_kd_harga_barang.setVisible(false);
        panel_stock_barang.setVisible(false);
        panel_laporan_pulsa.setVisible(false);
        panel_laporan_barang.setVisible(true);
        panel_pengeluaran_barang.setVisible(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_trans_barangActionPerformed

    private void kembali_pengeluaranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kembali_pengeluaranActionPerformed
        panel_tentang.setVisible(false);
        panel_utama.setVisible(true);
        panel_trans_pulsa.setVisible(false);
        panel_add_user.setVisible(false);
        panel_trans_barang.setVisible(false);
        panel_kd_harga_pulsa.setVisible(false);
        panel_saldo_pulsa.setVisible(false);
        panel_kd_harga_barang.setVisible(false);
        panel_stock_barang.setVisible(false);
        panel_laporan_pulsa.setVisible(false);
        panel_laporan_barang.setVisible(false);
        panel_pengeluaran_barang.setVisible(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_kembali_pengeluaranActionPerformed

    private void data_barangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_data_barangActionPerformed
        panel_tentang.setVisible(false);
        panel_utama.setVisible(false);
        panel_trans_pulsa.setVisible(false);
        panel_add_user.setVisible(false);
        panel_trans_barang.setVisible(false);
        panel_kd_harga_pulsa.setVisible(false);
        panel_saldo_pulsa.setVisible(false);
        panel_kd_harga_barang.setVisible(false);
        panel_stock_barang.setVisible(false);
        panel_laporan_pulsa.setVisible(false);
        panel_laporan_barang.setVisible(false);
        panel_pengeluaran_barang.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_data_barangActionPerformed

    private void btn_indosat1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_indosat1ActionPerformed
        txt_provider.setText("Indosat");
        tmbl_pulsa();
        tabel_indosat();
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_indosat1ActionPerformed

    private void btn_telkomsel1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_telkomsel1ActionPerformed
        txt_provider.setText("Telkomsel");
        tmbl_pulsa();
        tabel_telkomsel();
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_telkomsel1ActionPerformed

    private void btn_xl1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xl1ActionPerformed
        txt_provider.setText("XL");
        tmbl_pulsa();
        tabel_xl();
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_xl1ActionPerformed

    private void btn_axis1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_axis1ActionPerformed
        txt_provider.setText("Axis");
        tmbl_pulsa();
        tabel_axis();
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_axis1ActionPerformed

    private void btn_gojek1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_gojek1ActionPerformed
        txt_provider.setText("GoJek");
        tmbl_pulsa();
        tabel_gojek();
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_gojek1ActionPerformed

    private void btn_three1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_three1ActionPerformed
        txt_provider.setText("Three");
        tmbl_pulsa();
        tabel_three();
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_three1ActionPerformed

    private void btn_bolt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_bolt1ActionPerformed
        txt_provider.setText("Bolt");
        tmbl_pulsa();
        tabel_bolt();
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_bolt1ActionPerformed

    private void btn_token1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_token1ActionPerformed
        txt_provider.setText("Token");
        tmbl_pulsa();
        tabel_token();
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_token1ActionPerformed

    private void btn_smartfren1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_smartfren1ActionPerformed
        txt_provider.setText("Smartfren");
        tmbl_pulsa();
        tabel_smartfren();
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_smartfren1ActionPerformed

    private void btn_etoll1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_etoll1ActionPerformed
        txt_provider.setText("Etoll");
        tmbl_pulsa();
        tabel_etoll();
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_etoll1ActionPerformed

    private void tmbh_kd_plsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tmbh_kd_plsActionPerformed
        Connection koneksi = kdb_trx.getConnection();
        if(txt_provider.getText().equals("Indosat")){
            try{
                Statement stmt = koneksi.createStatement();
                String sql = "INSERT INTO tbl_indosat(kd_trx,nominal,harga) VALUES('"+txt_kd_pulsa.getText()+"','"+txt_nominal_pulsa.getText()+"','"+txt_harga_pulsa1.getText()+"')";
                stmt.executeUpdate(sql);
                JOptionPane.showMessageDialog(rootPane, "Data Berhasil Di Masukan");
                tabel_indosat();
                bersih_pulsa();
            }catch(Exception ex){
                JOptionPane.showMessageDialog(this, "Data Gagal Di Masukan", "Pesan", JOptionPane.WARNING_MESSAGE);                
            }
        }else if(txt_provider.getText().equals("Telkomsel")){
            try{
                Statement stmt = koneksi.createStatement();
                String sql = "INSERT INTO tbl_telkomsel(kd_trx,nominal,harga) VALUES('"+txt_kd_pulsa.getText()+"','"+txt_nominal_pulsa.getText()+"','"+txt_harga_pulsa1.getText()+"')";
                stmt.executeUpdate(sql);
                JOptionPane.showMessageDialog(rootPane, "Data Berhasil Di Masukan");
                tabel_telkomsel();
                bersih_pulsa();
            }catch(Exception ex){
                JOptionPane.showMessageDialog(this, "Data Gagal Di Masukan", "Pesan", JOptionPane.WARNING_MESSAGE);                
            }
        }else if(txt_provider.getText().equals("XL")){
            try{
                Statement stmt = koneksi.createStatement();
                String sql = "INSERT INTO tbl_xl(kd_trx,nominal,harga) VALUES('"+txt_kd_pulsa.getText()+"','"+txt_nominal_pulsa.getText()+"','"+txt_harga_pulsa1.getText()+"')";
                stmt.executeUpdate(sql);
                JOptionPane.showMessageDialog(rootPane, "Data Berhasil Di Masukan");
                tabel_xl();
                bersih_pulsa();
            }catch(Exception ex){
                JOptionPane.showMessageDialog(this, "Data Gagal Di Masukan", "Pesan", JOptionPane.WARNING_MESSAGE);                
            }
        }else if(txt_provider.getText().equals("Axis")){
            try{
                Statement stmt = koneksi.createStatement();
                String sql = "INSERT INTO tbl_axis(kd_trx,nominal,harga) VALUES('"+txt_kd_pulsa.getText()+"','"+txt_nominal_pulsa.getText()+"','"+txt_harga_pulsa1.getText()+"')";
                stmt.executeUpdate(sql);
                JOptionPane.showMessageDialog(rootPane, "Data Berhasil Di Masukan");
                tabel_axis();
                bersih_pulsa();
            }catch(Exception ex){
                JOptionPane.showMessageDialog(this, "Data Gagal Di Masukan", "Pesan", JOptionPane.WARNING_MESSAGE);                
            }
        }else if(txt_provider.getText().equals("GoJek")){
            try{
                Statement stmt = koneksi.createStatement();
                String sql = "INSERT INTO tbl_gojek(kd_trx,nominal,harga) VALUES('"+txt_kd_pulsa.getText()+"','"+txt_nominal_pulsa.getText()+"','"+txt_harga_pulsa1.getText()+"')";
                stmt.executeUpdate(sql);
                JOptionPane.showMessageDialog(rootPane, "Data Berhasil Di Masukan");
                tabel_gojek();
                bersih_pulsa();
            }catch(Exception ex){
                JOptionPane.showMessageDialog(this, "Data Gagal Di Masukan", "Pesan", JOptionPane.WARNING_MESSAGE);                
            }
        }else if(txt_provider.getText().equals("Three")){
            try{
                Statement stmt = koneksi.createStatement();
                String sql = "INSERT INTO tbl_three(kd_trx,nominal,harga) VALUES('"+txt_kd_pulsa.getText()+"','"+txt_nominal_pulsa.getText()+"','"+txt_harga_pulsa1.getText()+"')";
                stmt.executeUpdate(sql);
                JOptionPane.showMessageDialog(rootPane, "Data Berhasil Di Masukan");
                tabel_three();
                bersih_pulsa();
            }catch(Exception ex){
                JOptionPane.showMessageDialog(this, "Data Gagal Di Masukan", "Pesan", JOptionPane.WARNING_MESSAGE);                
            }
        }else if(txt_provider.getText().equals("Bolt")){
            try{
                Statement stmt = koneksi.createStatement();
                String sql = "INSERT INTO tbl_bolt(kd_trx,nominal,harga) VALUES('"+txt_kd_pulsa.getText()+"','"+txt_nominal_pulsa.getText()+"','"+txt_harga_pulsa1.getText()+"')";
                stmt.executeUpdate(sql);
                JOptionPane.showMessageDialog(rootPane, "Data Berhasil Di Masukan");
                tabel_bolt();
                bersih_pulsa();
            }catch(Exception ex){
                JOptionPane.showMessageDialog(this, "Data Gagal Di Masukan", "Pesan", JOptionPane.WARNING_MESSAGE);                
            }
        }else if(txt_provider.getText().equals("Token")){
            try{
                Statement stmt = koneksi.createStatement();
                String sql = "INSERT INTO tbl_token(kd_trx,nominal,harga) VALUES('"+txt_kd_pulsa.getText()+"','"+txt_nominal_pulsa.getText()+"','"+txt_harga_pulsa1.getText()+"')";
                stmt.executeUpdate(sql);
                JOptionPane.showMessageDialog(rootPane, "Data Berhasil Di Masukan");
                tabel_token();
                bersih_pulsa();
            }catch(Exception ex){
                JOptionPane.showMessageDialog(this, "Data Gagal Di Masukan", "Pesan", JOptionPane.WARNING_MESSAGE);                
            }
        }else if(txt_provider.getText().equals("Smartfren")){
            try{
                Statement stmt = koneksi.createStatement();
                String sql = "INSERT INTO tbl_smartfren(kd_trx,nominal,harga) VALUES('"+txt_kd_pulsa.getText()+"','"+txt_nominal_pulsa.getText()+"','"+txt_harga_pulsa1.getText()+"')";
                stmt.executeUpdate(sql);
                JOptionPane.showMessageDialog(rootPane, "Data Berhasil Di Masukan");
                tabel_smartfren();
                bersih_pulsa();
            }catch(Exception ex){
                JOptionPane.showMessageDialog(this, "Data Gagal Di Masukan", "Pesan", JOptionPane.WARNING_MESSAGE);                
            }
        }else if(txt_provider.getText().equals("Etoll")){
            try{
                Statement stmt = koneksi.createStatement();
                String sql = "INSERT INTO tbl_etoll(kd_trx,nominal,harga) VALUES('"+txt_kd_pulsa.getText()+"','"+txt_nominal_pulsa.getText()+"','"+txt_harga_pulsa1.getText()+"')";
                stmt.executeUpdate(sql);
                JOptionPane.showMessageDialog(rootPane, "Data Berhasil Di Masukan");
                tabel_etoll();
                bersih_pulsa();
            }catch(Exception ex){
                JOptionPane.showMessageDialog(this, "Data Gagal Di Masukan", "Pesan", JOptionPane.WARNING_MESSAGE);                
            }
        }else{
            JOptionPane.showMessageDialog(null, "Silahkan pilih SERVER terlebih dahulu", "Peringatan", JOptionPane.INFORMATION_MESSAGE);            
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_tmbh_kd_plsActionPerformed

    private void edit_kd_plsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edit_kd_plsActionPerformed
        hapus_kd_pls.setEnabled(false);
        int row = tbl_kd_harga_pulsa.getSelectedRow();
        txt_kd_pulsa.setText((String)tbl_kd_harga_pulsa.getValueAt(row, 0));
        txt_nominal_pulsa.setText((String)tbl_kd_harga_pulsa.getValueAt(row, 1));
        txt_harga_pulsa1.setText((String)tbl_kd_harga_pulsa.getValueAt(row, 2));
        // TODO add your handling code here:
    }//GEN-LAST:event_edit_kd_plsActionPerformed

    private void smpn_kd_plsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_smpn_kd_plsActionPerformed
        Connection koneksi = kdb_trx.getConnection();
        if(txt_provider.getText().equals("Indosat")){
            try{
                Statement stmt = koneksi.createStatement();
                String sql = "UPDATE tbl_indosat SET kd_trx='"+txt_kd_pulsa.getText()+"',nominal='"+txt_nominal_pulsa.getText()+"',harga='"+txt_harga_pulsa1.getText()+"' WHERE kd_trx='"+ txt_kd_pulsa.getText()+"'";
                stmt.executeUpdate(sql);
                JOptionPane.showMessageDialog(rootPane, "Edit Data Berhasil");
                tabel_indosat();
                tmbl_pulsa();
                bersih_pulsa();
            }catch(Exception ex){
                JOptionPane.showMessageDialog(this, "Data Gagal Di Simpan", "Pesan", JOptionPane.WARNING_MESSAGE);                
            }
        }else if(txt_provider.getText().equals("Telkomsel")){
            try{
                Statement stmt = koneksi.createStatement();
                String sql = "UPDATE tbl_telkomsel SET kd_trx='"+txt_kd_pulsa.getText()+"',nominal='"+txt_nominal_pulsa.getText()+"',harga='"+txt_harga_pulsa1.getText()+"' WHERE kd_trx='"+ txt_kd_pulsa.getText()+"'";
                stmt.executeUpdate(sql);
                JOptionPane.showMessageDialog(rootPane, "Edit Data Berhasil");
                tabel_telkomsel();
                tmbl_pulsa();
                bersih_pulsa();
            }catch(Exception ex){
                JOptionPane.showMessageDialog(this, "Data Gagal Di Simpan", "Pesan", JOptionPane.WARNING_MESSAGE);                
            }
        }else if(txt_provider.getText().equals("XL")){
            try{
                Statement stmt = koneksi.createStatement();
                String sql = "UPDATE tbl_xl SET kd_trx='"+txt_kd_pulsa.getText()+"',nominal='"+txt_nominal_pulsa.getText()+"',harga='"+txt_harga_pulsa1.getText()+"' WHERE kd_trx='"+ txt_kd_pulsa.getText()+"'";
                stmt.executeUpdate(sql);
                JOptionPane.showMessageDialog(rootPane, "Edit Data Berhasil");
                tabel_xl();
                tmbl_pulsa();
                bersih_pulsa();
            }catch(Exception ex){
                JOptionPane.showMessageDialog(this, "Data Gagal Di Simpan", "Pesan", JOptionPane.WARNING_MESSAGE);                
            }
        }else if(txt_provider.getText().equals("Axis")){
            try{
                Statement stmt = koneksi.createStatement();
                String sql = "UPDATE tbl_axis SET kd_trx='"+txt_kd_pulsa.getText()+"',nominal='"+txt_nominal_pulsa.getText()+"',harga='"+txt_harga_pulsa1.getText()+"' WHERE kd_trx='"+ txt_kd_pulsa.getText()+"'";
                stmt.executeUpdate(sql);
                JOptionPane.showMessageDialog(rootPane, "Edit Data Berhasil");
                tabel_axis();
                tmbl_pulsa();
                bersih_pulsa();
            }catch(Exception ex){
                JOptionPane.showMessageDialog(this, "Data Gagal Di Simpan", "Pesan", JOptionPane.WARNING_MESSAGE);                
            }
        }else if(txt_provider.getText().equals("GoJek")){
            try{
                Statement stmt = koneksi.createStatement();
                String sql = "UPDATE tbl_gojek SET kd_trx='"+txt_kd_pulsa.getText()+"',nominal='"+txt_nominal_pulsa.getText()+"',harga='"+txt_harga_pulsa1.getText()+"' WHERE kd_trx='"+ txt_kd_pulsa.getText()+"'";
                stmt.executeUpdate(sql);
                JOptionPane.showMessageDialog(rootPane, "Edit Data Berhasil");
                tabel_gojek();
                tmbl_pulsa();
                bersih_pulsa();
            }catch(Exception ex){
                JOptionPane.showMessageDialog(this, "Data Gagal Di Simpan", "Pesan", JOptionPane.WARNING_MESSAGE);                
            }
        }else if(txt_provider.getText().equals("Three")){
            try{
                Statement stmt = koneksi.createStatement();
                String sql = "UPDATE tbl_three SET kd_trx='"+txt_kd_pulsa.getText()+"',nominal='"+txt_nominal_pulsa.getText()+"',harga='"+txt_harga_pulsa1.getText()+"' WHERE kd_trx='"+ txt_kd_pulsa.getText()+"'";
                stmt.executeUpdate(sql);
                JOptionPane.showMessageDialog(rootPane, "Edit Data Berhasil");
                tabel_three();
                tmbl_pulsa();
                bersih_pulsa();
            }catch(Exception ex){
                JOptionPane.showMessageDialog(this, "Data Gagal Di Simpan", "Pesan", JOptionPane.WARNING_MESSAGE);                
            }
        }else if(txt_provider.getText().equals("Bolt")){
            try{
                Statement stmt = koneksi.createStatement();
                String sql = "UPDATE tbl_bolt SET kd_trx='"+txt_kd_pulsa.getText()+"',nominal='"+txt_nominal_pulsa.getText()+"',harga='"+txt_harga_pulsa1.getText()+"' WHERE kd_trx='"+ txt_kd_pulsa.getText()+"'";
                stmt.executeUpdate(sql);
                JOptionPane.showMessageDialog(rootPane, "Edit Data Berhasil");
                tabel_bolt();
                tmbl_pulsa();
                bersih_pulsa();
            }catch(Exception ex){
                JOptionPane.showMessageDialog(this, "Data Gagal Di Simpan", "Pesan", JOptionPane.WARNING_MESSAGE);                
            }
        }else if(txt_provider.getText().equals("Token")){
            try{
                Statement stmt = koneksi.createStatement();
                String sql = "UPDATE tbl_token SET kd_trx='"+txt_kd_pulsa.getText()+"',nominal='"+txt_nominal_pulsa.getText()+"',harga='"+txt_harga_pulsa1.getText()+"' WHERE kd_trx='"+ txt_kd_pulsa.getText()+"'";
                stmt.executeUpdate(sql);
                JOptionPane.showMessageDialog(rootPane, "Edit Data Berhasil");
                tabel_token();
                tmbl_pulsa();
                bersih_pulsa();
            }catch(Exception ex){
                JOptionPane.showMessageDialog(this, "Data Gagal Di Simpan", "Pesan", JOptionPane.WARNING_MESSAGE);                
            }
        }else if(txt_provider.getText().equals("Smartfren")){
            try{
                Statement stmt = koneksi.createStatement();
                String sql = "UPDATE tbl_smartfren SET kd_trx='"+txt_kd_pulsa.getText()+"',nominal='"+txt_nominal_pulsa.getText()+"',harga='"+txt_harga_pulsa1.getText()+"' WHERE kd_trx='"+ txt_kd_pulsa.getText()+"'";
                stmt.executeUpdate(sql);
                JOptionPane.showMessageDialog(rootPane, "Edit Data Berhasil");
                tabel_smartfren();
                tmbl_pulsa();
                bersih_pulsa();
            }catch(Exception ex){
                JOptionPane.showMessageDialog(this, "Data Gagal Di Simpan", "Pesan", JOptionPane.WARNING_MESSAGE);                
            }
        }else if(txt_provider.getText().equals("Etoll")){
            try{
                Statement stmt = koneksi.createStatement();
                String sql = "UPDATE tbl_etoll SET kd_trx='"+txt_kd_pulsa.getText()+"',nominal='"+txt_nominal_pulsa.getText()+"',harga='"+txt_harga_pulsa1.getText()+"' WHERE kd_trx='"+ txt_kd_pulsa.getText()+"'";
                stmt.executeUpdate(sql);
                JOptionPane.showMessageDialog(rootPane, "Edit Data Berhasil");
                tabel_etoll();
                tmbl_pulsa();
                bersih_pulsa();
            }catch(Exception ex){
                JOptionPane.showMessageDialog(this, "Data Gagal Di Simpan", "Pesan", JOptionPane.WARNING_MESSAGE);                
            }
        }else{
            JOptionPane.showMessageDialog(null, "Silahkan pilih SERVER terlebih dahulu", "Peringatan", JOptionPane.INFORMATION_MESSAGE);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_smpn_kd_plsActionPerformed

    private void tbl_kd_harga_pulsaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_kd_harga_pulsaMouseClicked
        smpn_kd_pls.setEnabled(true);
        batal_kd_pls.setEnabled(true);
        hapus_kd_pls.setEnabled(true);
        tmbh_kd_pls.setEnabled(false);
        edit_kd_pls.setEnabled(true);
        kembali_kd_pls.setEnabled(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_kd_harga_pulsaMouseClicked

    private void batal_kd_plsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batal_kd_plsActionPerformed
        tmbl_pulsa();
        bersih_pulsa();
        // TODO add your handling code here:
    }//GEN-LAST:event_batal_kd_plsActionPerformed

    private void hapus_kd_plsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapus_kd_plsActionPerformed
        Connection koneksi = kdb_trx.getConnection();
        int row = tbl_kd_harga_pulsa.getSelectedRow();
        String kode_pulsa = tbl_kd_harga_pulsa.getValueAt(row, 0).toString();
        if(row == -1){
            JOptionPane.showMessageDialog(this, "Mohon Pilih Data Pada Tabel Terlebih Dahulu","Pesan",JOptionPane.WARNING_MESSAGE);
        }else{
            if(txt_provider.getText().equals("Indosat")){
                try{
                    Statement stmt = koneksi.createStatement();
                    String sql = "DELETE FROM tbl_indosat WHERE kd_trx = '"+kode_pulsa+"'";
                    stmt.executeUpdate(sql);
                    tabel_indosat();
                    JOptionPane.showMessageDialog(rootPane, "Hapus Data Berhasil");
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(this, "Data Gagal Di Hapus", "Pesan", JOptionPane.WARNING_MESSAGE);                
                }
            }else if(txt_provider.getText().equals("Telkomsel")){
                try{
                    Statement stmt = koneksi.createStatement();
                    String sql = "DELETE FROM tbl_telkomsel WHERE kd_trx = '"+kode_pulsa+"'";
                    stmt.executeUpdate(sql);
                    tabel_telkomsel();
                    JOptionPane.showMessageDialog(rootPane, "Hapus Data Berhasil");
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(this, "Data Gagal Di Hapus", "Pesan", JOptionPane.WARNING_MESSAGE);                
                }
            }else if(txt_provider.getText().equals("XL")){
                try{
                    Statement stmt = koneksi.createStatement();
                    String sql = "DELETE FROM tbl_xl WHERE kd_trx = '"+kode_pulsa+"'";
                    stmt.executeUpdate(sql);
                    tabel_xl();
                    JOptionPane.showMessageDialog(rootPane, "Hapus Data Berhasil");
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(this, "Data Gagal Di Hapus", "Pesan", JOptionPane.WARNING_MESSAGE);                
                }
            }else if(txt_provider.getText().equals("Axis")){
                try{
                    Statement stmt = koneksi.createStatement();
                    String sql = "DELETE FROM tbl_axis WHERE kd_trx = '"+kode_pulsa+"'";
                    stmt.executeUpdate(sql);
                    tabel_axis();
                    JOptionPane.showMessageDialog(rootPane, "Hapus Data Berhasil");
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(this, "Data Gagal Di Hapus", "Pesan", JOptionPane.WARNING_MESSAGE);                
                }
            }else if(txt_provider.getText().equals("GoJek")){
                try{
                    Statement stmt = koneksi.createStatement();
                    String sql = "DELETE FROM tbl_gojek WHERE kd_trx = '"+kode_pulsa+"'";
                    stmt.executeUpdate(sql);
                    tabel_gojek();
                    JOptionPane.showMessageDialog(rootPane, "Hapus Data Berhasil");
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(this, "Data Gagal Di Hapus", "Pesan", JOptionPane.WARNING_MESSAGE);                
                }
            }else if(txt_provider.getText().equals("Three")){
                try{
                    Statement stmt = koneksi.createStatement();
                    String sql = "DELETE FROM tbl_three WHERE kd_trx = '"+kode_pulsa+"'";
                    stmt.executeUpdate(sql);
                    tabel_three();
                    JOptionPane.showMessageDialog(rootPane, "Hapus Data Berhasil");
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(this, "Data Gagal Di Hapus", "Pesan", JOptionPane.WARNING_MESSAGE);                
                }
            }else if(txt_provider.getText().equals("Bolt")){
                try{
                    Statement stmt = koneksi.createStatement();
                    String sql = "DELETE FROM tbl_bolt WHERE kd_trx = '"+kode_pulsa+"'";
                    stmt.executeUpdate(sql);
                    tabel_bolt();
                    JOptionPane.showMessageDialog(rootPane, "Hapus Data Berhasil");
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(this, "Data Gagal Di Hapus", "Pesan", JOptionPane.WARNING_MESSAGE);                
                }
            }else if(txt_provider.getText().equals("Token")){
                try{
                    Statement stmt = koneksi.createStatement();
                    String sql = "DELETE FROM tbl_token WHERE kd_trx = '"+kode_pulsa+"'";
                    stmt.executeUpdate(sql);
                    tabel_token();
                    JOptionPane.showMessageDialog(rootPane, "Hapus Data Berhasil");
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(this, "Data Gagal Di Hapus", "Pesan", JOptionPane.WARNING_MESSAGE);                
                }
            }else if(txt_provider.getText().equals("Smartfren")){
                try{
                    Statement stmt = koneksi.createStatement();
                    String sql = "DELETE FROM tbl_smartfren WHERE kd_trx = '"+kode_pulsa+"'";
                    stmt.executeUpdate(sql);
                    tabel_smartfren();
                    JOptionPane.showMessageDialog(rootPane, "Hapus Data Berhasil");
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(this, "Data Gagal Di Hapus", "Pesan", JOptionPane.WARNING_MESSAGE);                
                }
            }else if(txt_provider.getText().equals("Etoll")){
                try{
                    Statement stmt = koneksi.createStatement();
                    String sql = "DELETE FROM tbl_etoll WHERE kd_trx = '"+kode_pulsa+"'";
                    stmt.executeUpdate(sql);
                    tabel_etoll();
                    JOptionPane.showMessageDialog(rootPane, "Hapus Data Berhasil");
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(this, "Data Gagal Di Hapus", "Pesan", JOptionPane.WARNING_MESSAGE);                
                }
            }else{
                JOptionPane.showMessageDialog(null, "Silahkan Pilih SERVER Terlebih Dahulu", "Peringatan", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_hapus_kd_plsActionPerformed

    private void txt_cari_kd_pulsaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cari_kd_pulsaKeyTyped
        Connection koneksi = kdb_trx.getConnection();
        Object[] Baris={"Kode Pulsa","Nominal","Harga"};
        DefaultTableModel tabel = new DefaultTableModel(null, Baris);
        tbl_kd_harga_pulsa.setModel(tabel);
        if(txt_provider.getText().equals("Indosat")){
            try{
                String sql="Select * from tbl_indosat where kd_trx like '%"+ txt_cari_kd_pulsa.getText() + "%'";
                Statement stmt=koneksi.createStatement();
                ResultSet rs=stmt.executeQuery(sql);
                while(rs.next()){
                    String kd_trx = rs.getString("kd_trx");
                    String nominal = rs.getString("nominal");
                    String harga = rs.getString("harga");
                    String[] dataField={kd_trx, nominal, harga};
                    tabel.addRow(dataField);
                }
            }catch(Exception ex){
                JOptionPane.showMessageDialog(rootPane, "Akses Gagal");
            }
        }else if(txt_provider.getText().equals("Telkomsel")){
            try{
                String sql="Select * from tbl_telkomsel where kd_trx like '%"+ txt_cari_kd_pulsa.getText() + "%'";
                Statement stmt=koneksi.createStatement();
                ResultSet rs=stmt.executeQuery(sql);
                while(rs.next()){
                    String kd_trx = rs.getString("kd_trx");
                    String nominal = rs.getString("nominal");
                    String harga = rs.getString("harga");
                    String[] dataField={kd_trx, nominal, harga};
                    tabel.addRow(dataField);
                }
            }catch(Exception ex){
                JOptionPane.showMessageDialog(rootPane, "Akse Gagal");
            }
        }else if(txt_provider.getText().equals("XL")){
            try{
                String sql="Select * from tbl_xl where kd_trx like '%"+ txt_cari_kd_pulsa.getText() + "%'";
                Statement stmt=koneksi.createStatement();
                ResultSet rs=stmt.executeQuery(sql);
                while(rs.next()){
                    String kd_trx = rs.getString("kd_trx");
                    String nominal = rs.getString("nominal");
                    String harga = rs.getString("harga");
                    String[] dataField={kd_trx, nominal, harga};
                    tabel.addRow(dataField);
                }
            }catch(Exception ex){
                JOptionPane.showMessageDialog(rootPane, "Akse Gagal");
            }
        }else if(txt_provider.getText().equals("Axis")){
            try{
                String sql="Select * from tbl_axis where kd_trx like '%"+ txt_cari_kd_pulsa.getText() + "%'";
                Statement stmt=koneksi.createStatement();
                ResultSet rs=stmt.executeQuery(sql);
                while(rs.next()){
                    String kd_trx = rs.getString("kd_trx");
                    String nominal = rs.getString("nominal");
                    String harga = rs.getString("harga");
                    String[] dataField={kd_trx, nominal, harga};
                    tabel.addRow(dataField);
                }
            }catch(Exception ex){
                JOptionPane.showMessageDialog(rootPane, "Akse Gagal");
            }
        }else if(txt_provider.getText().equals("GoJek")){
            try{
                String sql="Select * from tbl_gojek where kd_trx like '%"+ txt_cari_kd_pulsa.getText() + "%'";
                Statement stmt=koneksi.createStatement();
                ResultSet rs=stmt.executeQuery(sql);
                while(rs.next()){
                    String kd_trx = rs.getString("kd_trx");
                    String nominal = rs.getString("nominal");
                    String harga = rs.getString("harga");
                    String[] dataField={kd_trx, nominal, harga};
                    tabel.addRow(dataField);
                }
            }catch(Exception ex){
                JOptionPane.showMessageDialog(rootPane, "Akse Gagal");
            }
        }else if(txt_provider.getText().equals("Three")){
            try{
                String sql="Select * from tbl_three where kd_trx like '%"+ txt_cari_kd_pulsa.getText() + "%'";
                Statement stmt=koneksi.createStatement();
                ResultSet rs=stmt.executeQuery(sql);
                while(rs.next()){
                    String kd_trx = rs.getString("kd_trx");
                    String nominal = rs.getString("nominal");
                    String harga = rs.getString("harga");
                    String[] dataField={kd_trx, nominal, harga};
                    tabel.addRow(dataField);
                }
            }catch(Exception ex){
                JOptionPane.showMessageDialog(rootPane, "Akse Gagal");
            }
        }else if(txt_provider.getText().equals("Bolt")){
            try{
                String sql="Select * from tbl_bolt where kd_trx like '%"+ txt_cari_kd_pulsa.getText() + "%'";
                Statement stmt=koneksi.createStatement();
                ResultSet rs=stmt.executeQuery(sql);
                while(rs.next()){
                    String kd_trx = rs.getString("kd_trx");
                    String nominal = rs.getString("nominal");
                    String harga = rs.getString("harga");
                    String[] dataField={kd_trx, nominal, harga};
                    tabel.addRow(dataField);
                }
            }catch(Exception ex){
                JOptionPane.showMessageDialog(rootPane, "Akse Gagal");
            }
        }else if(txt_provider.getText().equals("Token")){
            try{
                String sql="Select * from tbl_token where kd_trx like '%"+ txt_cari_kd_pulsa.getText() + "%'";
                Statement stmt=koneksi.createStatement();
                ResultSet rs=stmt.executeQuery(sql);
                while(rs.next()){
                    String kd_trx = rs.getString("kd_trx");
                    String nominal = rs.getString("nominal");
                    String harga = rs.getString("harga");
                    String[] dataField={kd_trx, nominal, harga};
                    tabel.addRow(dataField);
                }
            }catch(Exception ex){
                JOptionPane.showMessageDialog(rootPane, "Akse Gagal");
            }
        }else if(txt_provider.getText().equals("Smartfren")){
            try{
                String sql="Select * from tbl_smartfren where kd_trx like '%"+ txt_cari_kd_pulsa.getText() + "%'";
                Statement stmt=koneksi.createStatement();
                ResultSet rs=stmt.executeQuery(sql);
                while(rs.next()){
                    String kd_trx = rs.getString("kd_trx");
                    String nominal = rs.getString("nominal");
                    String harga = rs.getString("harga");
                    String[] dataField={kd_trx, nominal, harga};
                    tabel.addRow(dataField);
                }
            }catch(Exception ex){
                JOptionPane.showMessageDialog(rootPane, "Akse Gagal");
            }
        }else if(txt_provider.getText().equals("Etoll")){
            try{
                String sql="Select * from tbl_etoll where kd_trx like '%"+ txt_cari_kd_pulsa.getText() + "%'";
                Statement stmt=koneksi.createStatement();
                ResultSet rs=stmt.executeQuery(sql);
                while(rs.next()){
                    String kd_trx = rs.getString("kd_trx");
                    String nominal = rs.getString("nominal");
                    String harga = rs.getString("harga");
                    String[] dataField={kd_trx, nominal,  harga};
                    tabel.addRow(dataField);
                }
            }catch(Exception ex){
                JOptionPane.showMessageDialog(rootPane, "Akse Gagal");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Silahkan Pilih SERVER Terlebih Dahulu", "Peringatan", JOptionPane.INFORMATION_MESSAGE);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cari_kd_pulsaKeyTyped

    private void txt_cari_kd_pulsaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_cari_kd_pulsaMouseClicked
        txt_cari_kd_pulsa.setText("");
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cari_kd_pulsaMouseClicked

    private void btn_indosatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_indosatActionPerformed
        txt_provider1.setText("Indosat");
        btn_indosat.setEnabled(true);
        btn_telkomsel.setEnabled(false);
        btn_xl.setEnabled(false);
        btn_axis.setEnabled(false);
        btn_three.setEnabled(false);
        btn_bolt.setEnabled(false);
        btn_token.setEnabled(false);
        btn_smartfren.setEnabled(false);
        btn_gojek.setEnabled(false);
        btn_etoll.setEnabled(false);
        Connection koneksi = kdb_trx.getConnection();
        try {
            String sql="SELECT * FROM tbl_indosat";
            Statement stmt = koneksi.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                cmb_nominal.addItem(rs.getString("nominal"));
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Terjadi Kesalahan" +e);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_indosatActionPerformed

    private void btn_telkomselActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_telkomselActionPerformed
        txt_provider1.setText("Telkomsel");
        btn_indosat.setEnabled(false);
        btn_telkomsel.setEnabled(true);
        btn_xl.setEnabled(false);
        btn_axis.setEnabled(false);
        btn_three.setEnabled(false);
        btn_bolt.setEnabled(false);
        btn_token.setEnabled(false);
        btn_smartfren.setEnabled(false);
        btn_gojek.setEnabled(false);
        btn_etoll.setEnabled(false);
        Connection koneksi = kdb_trx.getConnection();
        try {
            String sql="SELECT * FROM tbl_telkomsel";
            Statement stmt = koneksi.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                cmb_nominal.addItem(rs.getString("nominal"));
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Terjadi Kesalahan" +e);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_telkomselActionPerformed

    private void btn_batal_data_pulsaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_batal_data_pulsaActionPerformed
        bersih_trans_pls();
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_batal_data_pulsaActionPerformed

    private void cmb_nominalItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmb_nominalItemStateChanged
        Connection koneksi = kdb_trx.getConnection();
        if(txt_provider1.getText().equals("Indosat")){
            try {
                String sql="SELECT * FROM tbl_indosat where nominal = '"+cmb_nominal.getSelectedItem().toString()+"'";
                Statement stmt = koneksi.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                if (rs.next()){
                    txt_harga_pulsa.setText(rs.getString("harga"));
                }
            }catch(Exception e) {
                JOptionPane.showMessageDialog(null,"Terjadi Kesalahan" +e);
            }
        }else if(txt_provider1.getText().equals("Telkomsel")){
            try {
                String sql="SELECT * FROM tbl_telkomsel where nominal = '"+cmb_nominal.getSelectedItem().toString()+"'";
                Statement stmt = koneksi.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                if (rs.next()){
                    txt_harga_pulsa.setText(rs.getString("harga"));
                }
            }catch(Exception e) {
                JOptionPane.showMessageDialog(null,"Terjadi Kesalahan" +e);
            }
        }else if(txt_provider1.getText().equals("XL")){
            try {
                String sql="SELECT * FROM tbl_xl where nominal = '"+cmb_nominal.getSelectedItem().toString()+"'";
                Statement stmt = koneksi.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                if (rs.next()){
                    txt_harga_pulsa.setText(rs.getString("harga"));
                }
            }catch(Exception e) {
                JOptionPane.showMessageDialog(null,"Terjadi Kesalahan" +e);
            }
        }else if(txt_provider1.getText().equals("Axis")){
            try {
                String sql="SELECT * FROM tbl_axis where nominal = '"+cmb_nominal.getSelectedItem().toString()+"'";
                Statement stmt = koneksi.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                if (rs.next()){
                    txt_harga_pulsa.setText(rs.getString("harga"));
                }
            }catch(Exception e) {
                JOptionPane.showMessageDialog(null,"Terjadi Kesalahan" +e);
            }
        }else if(txt_provider1.getText().equals("Three")){
            try {
                String sql="SELECT * FROM tbl_three where nominal = '"+cmb_nominal.getSelectedItem().toString()+"'";
                Statement stmt = koneksi.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                if (rs.next()){
                    txt_harga_pulsa.setText(rs.getString("harga"));
                }
            }catch(Exception e) {
                JOptionPane.showMessageDialog(null,"Terjadi Kesalahan" +e);
            }
        }else if(txt_provider1.getText().equals("Bolt")){
            try {
                String sql="SELECT * FROM tbl_bolt where nominal = '"+cmb_nominal.getSelectedItem().toString()+"'";
                Statement stmt = koneksi.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                if (rs.next()){
                    txt_harga_pulsa.setText(rs.getString("harga"));
                }
            }catch(Exception e) {
                JOptionPane.showMessageDialog(null,"Terjadi Kesalahan" +e);
            }
        }else if(txt_provider1.getText().equals("Token")){
            try {
                String sql="SELECT * FROM tbl_token where nominal = '"+cmb_nominal.getSelectedItem().toString()+"'";
                Statement stmt = koneksi.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                if (rs.next()){
                    txt_harga_pulsa.setText(rs.getString("harga"));
                }
            }catch(Exception e) {
                JOptionPane.showMessageDialog(null,"Terjadi Kesalahan" +e);
            }
        }else if(txt_provider1.getText().equals("Smartfren")){
            try {
                String sql="SELECT * FROM tbl_smartfren where nominal = '"+cmb_nominal.getSelectedItem().toString()+"'";
                Statement stmt = koneksi.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                if (rs.next()){
                    txt_harga_pulsa.setText(rs.getString("harga"));
                }
            }catch(Exception e) {
                JOptionPane.showMessageDialog(null,"Terjadi Kesalahan" +e);
            }
        }else if(txt_provider1.getText().equals("GoJek")){
            try {
                String sql="SELECT * FROM tbl_gojek where nominal = '"+cmb_nominal.getSelectedItem().toString()+"'";
                Statement stmt = koneksi.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                if (rs.next()){
                    txt_harga_pulsa.setText(rs.getString("harga"));
                }
            }catch(Exception e) {
                JOptionPane.showMessageDialog(null,"Terjadi Kesalahan" +e);
            }
        }else if(txt_provider1.getText().equals("Etoll")){
            try {
                String sql="SELECT * FROM tbl_etoll where nominal = '"+cmb_nominal.getSelectedItem().toString()+"'";
                Statement stmt = koneksi.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                if (rs.next()){
                    txt_harga_pulsa.setText(rs.getString("harga"));
                }
            }catch(Exception e) {
                JOptionPane.showMessageDialog(null,"Terjadi Kesalahan" +e);
            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_nominalItemStateChanged

    private void btn_xlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xlActionPerformed
        txt_provider1.setText("XL");
        btn_indosat.setEnabled(false);
        btn_telkomsel.setEnabled(false);
        btn_xl.setEnabled(true);
        btn_axis.setEnabled(false);
        btn_three.setEnabled(false);
        btn_bolt.setEnabled(false);
        btn_token.setEnabled(false);
        btn_smartfren.setEnabled(false);
        btn_gojek.setEnabled(false);
        btn_etoll.setEnabled(false);
        Connection koneksi = kdb_trx.getConnection();
        try {
            String sql="SELECT * FROM tbl_xl";
            Statement stmt = koneksi.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                cmb_nominal.addItem(rs.getString("nominal"));
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Terjadi Kesalahan" +e);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_xlActionPerformed

    private void btn_axisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_axisActionPerformed
        txt_provider1.setText("Axis");
        btn_indosat.setEnabled(false);
        btn_telkomsel.setEnabled(false);
        btn_xl.setEnabled(false);
        btn_axis.setEnabled(true);
        btn_three.setEnabled(false);
        btn_bolt.setEnabled(false);
        btn_token.setEnabled(false);
        btn_smartfren.setEnabled(false);
        btn_gojek.setEnabled(false);
        btn_etoll.setEnabled(false);
        Connection koneksi = kdb_trx.getConnection();
        try {
            String sql="SELECT * FROM tbl_axis";
            Statement stmt = koneksi.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                cmb_nominal.addItem(rs.getString("nominal"));
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Terjadi Kesalahan" +e);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_axisActionPerformed

    private void btn_threeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_threeActionPerformed
        txt_provider1.setText("Three");
        btn_indosat.setEnabled(false);
        btn_telkomsel.setEnabled(false);
        btn_xl.setEnabled(false);
        btn_axis.setEnabled(false);
        btn_three.setEnabled(true);
        btn_bolt.setEnabled(false);
        btn_token.setEnabled(false);
        btn_smartfren.setEnabled(false);
        btn_gojek.setEnabled(false);
        btn_etoll.setEnabled(false);
        Connection koneksi = kdb_trx.getConnection();
        try {
            String sql="SELECT * FROM tbl_three";
            Statement stmt = koneksi.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                cmb_nominal.addItem(rs.getString("nominal"));
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Terjadi Kesalahan" +e);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_threeActionPerformed

    private void btn_boltActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_boltActionPerformed
        txt_provider1.setText("Bolt");
        btn_indosat.setEnabled(false);
        btn_telkomsel.setEnabled(false);
        btn_xl.setEnabled(false);
        btn_axis.setEnabled(false);
        btn_three.setEnabled(false);
        btn_bolt.setEnabled(true);
        btn_token.setEnabled(false);
        btn_smartfren.setEnabled(false);
        btn_gojek.setEnabled(false);
        btn_etoll.setEnabled(false);
        Connection koneksi = kdb_trx.getConnection();
        try {
            String sql="SELECT * FROM tbl_bolt";
            Statement stmt = koneksi.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                cmb_nominal.addItem(rs.getString("nominal"));
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Terjadi Kesalahan" +e);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_boltActionPerformed

    private void btn_tokenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tokenActionPerformed
        txt_provider1.setText("Token");
        btn_indosat.setEnabled(false);
        btn_telkomsel.setEnabled(false);
        btn_xl.setEnabled(false);
        btn_axis.setEnabled(false);
        btn_three.setEnabled(false);
        btn_bolt.setEnabled(false);
        btn_token.setEnabled(true);
        btn_smartfren.setEnabled(false);
        btn_gojek.setEnabled(false);
        btn_etoll.setEnabled(false);
        Connection koneksi = kdb_trx.getConnection();
        try {
            String sql="SELECT * FROM tbl_token";
            Statement stmt = koneksi.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                cmb_nominal.addItem(rs.getString("nominal"));
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Terjadi Kesalahan" +e);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_tokenActionPerformed

    private void btn_smartfrenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_smartfrenActionPerformed
        txt_provider1.setText("Smartfren");
        btn_indosat.setEnabled(false);
        btn_telkomsel.setEnabled(false);
        btn_xl.setEnabled(false);
        btn_axis.setEnabled(false);
        btn_three.setEnabled(false);
        btn_bolt.setEnabled(false);
        btn_token.setEnabled(false);
        btn_smartfren.setEnabled(true);
        btn_gojek.setEnabled(false);
        btn_etoll.setEnabled(false);
        Connection koneksi = kdb_trx.getConnection();
        try {
            String sql="SELECT * FROM tbl_smartfren";
            Statement stmt = koneksi.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                cmb_nominal.addItem(rs.getString("nominal"));
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Terjadi Kesalahan" +e);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_smartfrenActionPerformed

    private void btn_gojekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_gojekActionPerformed
        txt_provider1.setText("GoJek");
        btn_indosat.setEnabled(false);
        btn_telkomsel.setEnabled(false);
        btn_xl.setEnabled(false);
        btn_axis.setEnabled(false);
        btn_three.setEnabled(false);
        btn_bolt.setEnabled(false);
        btn_token.setEnabled(false);
        btn_smartfren.setEnabled(false);
        btn_gojek.setEnabled(true);
        btn_etoll.setEnabled(false);
        Connection koneksi = kdb_trx.getConnection();
        try {
            String sql="SELECT * FROM tbl_gojek";
            Statement stmt = koneksi.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                cmb_nominal.addItem(rs.getString("nominal"));
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Terjadi Kesalahan" +e);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_gojekActionPerformed

    private void btn_etollActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_etollActionPerformed
        txt_provider1.setText("Etoll");
        btn_indosat.setEnabled(false);
        btn_telkomsel.setEnabled(false);
        btn_xl.setEnabled(false);
        btn_axis.setEnabled(false);
        btn_three.setEnabled(false);
        btn_bolt.setEnabled(false);
        btn_token.setEnabled(false);
        btn_smartfren.setEnabled(false);
        btn_gojek.setEnabled(false);
        btn_etoll.setEnabled(true);
        Connection koneksi = kdb_trx.getConnection();
        try {
            String sql="SELECT * FROM tbl_etoll";
            Statement stmt = koneksi.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                cmb_nominal.addItem(rs.getString("nominal"));
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Terjadi Kesalahan" +e);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_etollActionPerformed

    private void btn_tmbh_data_pulsaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tmbh_data_pulsaActionPerformed
        Connection koneksi = kdb.getConnection();
        try{
            String tampilan ="dd-MM-yyyy" ; 
            SimpleDateFormat fm = new SimpleDateFormat(tampilan); 
            String tanggal = String.valueOf(fm.format(txt_tgl_pulsa.getDate()));
            Statement stmt = koneksi.createStatement();
            String sql = "INSERT INTO tbl_trans_pls(tgl_trans,nm_cus_trans,provider_trans,no_cus_trans,nominal_pls,harga_pls,stat_trans) VALUES('"+tanggal+"','"+txt_nama_cus.getText()+"','"+txt_provider1.getText()+"','"+txt_no_cus.getText()+"','"+cmb_nominal.getSelectedItem()+"','"+txt_harga_pulsa.getText()+"','"+cmb_stat_pulsa.getSelectedItem()+"')";
            stmt.executeUpdate(sql);
            JOptionPane.showMessageDialog(rootPane, "Data Berhasil Di Masukan");
            bersih_trans_pls();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this, "Data Gagal Di Masukan", "Pesan", JOptionPane.WARNING_MESSAGE);                
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_tmbh_data_pulsaActionPerformed

    private void batal_saldo_plsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batal_saldo_plsActionPerformed
        bersih_saldo();
        tmbl_saldo();
        // TODO add your handling code here:
    }//GEN-LAST:event_batal_saldo_plsActionPerformed

    private void tbl_saldoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_saldoMouseClicked
        tmbh_saldo_pls.setEnabled(false);
        edit_saldo_pls.setEnabled(true);
        smpn_saldo_pls.setEnabled(true);
        batal_saldo_pls.setEnabled(true);
        kembali_saldo_pls.setEnabled(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_saldoMouseClicked

    private void edit_saldo_plsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edit_saldo_plsActionPerformed
        int row = tbl_saldo.getSelectedRow();
        txt_saldo_awal.setText((String)tbl_saldo.getValueAt(row, 1));
        txt_saldo_tambah.setText((String)tbl_saldo.getValueAt(row, 2));
        txt_saldo_terpakai.setText((String)tbl_saldo.getValueAt(row, 3));
        // TODO add your handling code here:
    }//GEN-LAST:event_edit_saldo_plsActionPerformed

    private void tmbh_saldo_plsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tmbh_saldo_plsActionPerformed
        Connection koneksi = kdb.getConnection();
        try{
            int sisa = (Integer.parseInt(txt_saldo_awal.getText()) + Integer.parseInt(txt_saldo_tambah.getText())) - Integer.parseInt(txt_saldo_terpakai.getText());
            Statement stmt = koneksi.createStatement();
            String sql = "INSERT INTO tbl_saldo(tanggal,awal,tambah,terpakai,sisa) VALUES('"+txt_tgl_saldo.getText()+"','"+txt_saldo_awal.getText()+"','"+txt_saldo_tambah.getText()+"','"+txt_saldo_terpakai.getText()+"','"+sisa+"')";
            stmt.executeUpdate(sql);
            JOptionPane.showMessageDialog(rootPane, "Data Berhasil Di Masukan");
            bersih_saldo();
            tabel_saldo();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this, "Data Gagal Di Masukan", "Pesan", JOptionPane.WARNING_MESSAGE);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_tmbh_saldo_plsActionPerformed

    private void smpn_saldo_plsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_smpn_saldo_plsActionPerformed
        Connection koneksi = kdb.getConnection();
        try{
            int sisa = (Integer.parseInt(txt_saldo_awal.getText()) + Integer.parseInt(txt_saldo_tambah.getText())) - Integer.parseInt(txt_saldo_terpakai.getText());
            Statement stmt = koneksi.createStatement();
            String sql = "UPDATE tbl_saldo SET awal='"+txt_saldo_awal.getText()+"',tambah='"+txt_saldo_tambah.getText()+"',terpakai='"+txt_saldo_terpakai.getText()+"',sisa='"+sisa+"' WHERE tanggal='"+ txt_tgl_saldo.getText()+"'";
            stmt.executeUpdate(sql);
            JOptionPane.showMessageDialog(rootPane, "Edit Data Berhasil");
            tabel_saldo();
            bersih_saldo();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this, "Data Gagal Di Simpan", "Pesan", JOptionPane.WARNING_MESSAGE);                
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_smpn_saldo_plsActionPerformed

    private void tmbh_kd_barangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tmbh_kd_barangActionPerformed
        Connection koneksi = kdb.getConnection();
        try{
            String tanggal = "-";
            String stock = "0";
            Statement stmt = koneksi.createStatement();
            String sql = "INSERT INTO tbl_barang(kd_barang,nm_barang,stock,harga,tanggal) VALUES('"+txt_kd_barang.getText()+"','"+txt_nama_barang.getText()+"','"+stock+"','"+txt_harga_barang.getText()+"','"+tanggal+"')";
            stmt.executeUpdate(sql);
            JOptionPane.showMessageDialog(rootPane, "Data Berhasil Di Masukan");
            bersih_harga();
            tabel_barang_harga();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this, "Data Gagal Di Masukan", "Pesan", JOptionPane.WARNING_MESSAGE);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_tmbh_kd_barangActionPerformed

    private void batal_kd_barangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batal_kd_barangActionPerformed
        tmbl_harga();
        bersih_harga();
        // TODO add your handling code here:
    }//GEN-LAST:event_batal_kd_barangActionPerformed

    private void tbl_kd_harga_barangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_kd_harga_barangMouseClicked
        tmbh_kd_barang.setEnabled(false);
        edit_kd_barang.setEnabled(true);
        smpn_kd_barang.setEnabled(true);
        batal_kd_barang.setEnabled(true);
        hapus_kd_barang.setEnabled(true);
        kembali_kd_barang.setEnabled(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_kd_harga_barangMouseClicked

    private void edit_kd_barangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edit_kd_barangActionPerformed
        int row = tbl_kd_harga_barang.getSelectedRow();
        txt_kd_barang.setText((String)tbl_kd_harga_barang.getValueAt(row, 0));
        txt_nama_barang.setText((String)tbl_kd_harga_barang.getValueAt(row, 1));
        txt_harga_barang.setText((String)tbl_kd_harga_barang.getValueAt(row, 2));
        // TODO add your handling code here:
    }//GEN-LAST:event_edit_kd_barangActionPerformed

    private void txt_cari_kd_barangKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cari_kd_barangKeyTyped
        Connection koneksi = kdb.getConnection();
        Object[] Baris={"Kode Barang","Nama Barang","Harga"};
        DefaultTableModel tabel = new DefaultTableModel(null, Baris);
        tbl_kd_harga_barang.setModel(tabel);
        try{
            String sql="Select * from tbl_barang where kd_barang like '%"+ txt_cari_kd_barang.getText() + "%'";
            Statement stmt=koneksi.createStatement();
            ResultSet rs=stmt.executeQuery(sql);
            while(rs.next()){
                String kd_barang = rs.getString("kd_barang");
                String nm_barang = rs.getString("nm_barang");
                String harga = rs.getString("harga");
                String[] dataField={kd_barang, nm_barang, harga};
                tabel.addRow(dataField);
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(rootPane, "Akses Gagal");
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cari_kd_barangKeyTyped

    private void txt_cari_kd_barangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_cari_kd_barangMouseClicked
        txt_cari_kd_barang.setText("");
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cari_kd_barangMouseClicked

    private void smpn_kd_barangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_smpn_kd_barangActionPerformed
        Connection koneksi = kdb.getConnection();
        try{
            String sql="Select * from tbl_barang where kd_barang like '%"+ txt_kd_barang.getText() + "%'";
            Statement stmt=koneksi.createStatement();
            ResultSet rs=stmt.executeQuery(sql);
            while(rs.next()){
                try{
                    String stock = rs.getString("stock");
                    String tanggal = rs.getString("tanggal");
                    Statement stmt1 = koneksi.createStatement();
                    String sql1 = "UPDATE tbl_barang SET nm_barang='"+txt_nama_barang.getText()+"',stock='"+stock+"',harga='"+txt_harga_barang.getText()+"',tanggal='"+tanggal+"' WHERE kd_barang='"+ txt_kd_barang.getText()+"'";
                    stmt1.executeUpdate(sql1);
                    JOptionPane.showMessageDialog(rootPane, "Edit Data Berhasil");
                    tabel_barang_harga();
                    bersih_harga();
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(this, "Data Gagal Di Simpan", "Pesan", JOptionPane.WARNING_MESSAGE);                
                }
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(rootPane, "Akses Gagal");
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_smpn_kd_barangActionPerformed

    private void hapus_kd_barangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapus_kd_barangActionPerformed
        Connection koneksi = kdb.getConnection();
        int row = tbl_kd_harga_barang.getSelectedRow();
        String kode_barang = tbl_kd_harga_barang.getValueAt(row, 0).toString();
        if(row == -1){
            JOptionPane.showMessageDialog(this, "Mohon Pilih Data Pada Tabel Terlebih Dahulu","Pesan",JOptionPane.WARNING_MESSAGE);
        }else{
            try{
                Statement stmt = koneksi.createStatement();
                String sql = "DELETE FROM tbl_barang WHERE kd_barang = '"+kode_barang+"'";
                stmt.executeUpdate(sql);
                tabel_barang_harga();
                JOptionPane.showMessageDialog(rootPane, "Hapus Data Berhasil");
            }catch(Exception ex){
                JOptionPane.showMessageDialog(this, "Data Gagal Di Hapus", "Pesan", JOptionPane.WARNING_MESSAGE);                
            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_hapus_kd_barangActionPerformed

    private void edit_stock_barangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edit_stock_barangActionPerformed
        int row = tbl_stock_barang.getSelectedRow();
        txt_kd_barang1.setText((String)tbl_stock_barang.getValueAt(row, 1));
        txt_nama_barang1.setText((String)tbl_stock_barang.getValueAt(row, 2));
        txt_stock_awal.setText((String)tbl_stock_barang.getValueAt(row, 3));
        // TODO add your handling code here:
    }//GEN-LAST:event_edit_stock_barangActionPerformed

    private void batal_stock_barangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batal_stock_barangActionPerformed
        bersih_stock();
        // TODO add your handling code here:
    }//GEN-LAST:event_batal_stock_barangActionPerformed

    private void txt_cari_barangKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cari_barangKeyTyped
        Connection koneksi = kdb.getConnection();
        Object[] Baris={"Tanggal","Kode Barang","Nama Barang","Stock"};
        DefaultTableModel tabel = new DefaultTableModel(null, Baris);
        tbl_stock_barang.setModel(tabel);
        try{
            String sql="Select * from tbl_barang where kd_barang like '%"+ txt_cari_barang.getText() + "%'";
            Statement stmt=koneksi.createStatement();
            ResultSet rs=stmt.executeQuery(sql);
            while(rs.next()){
                String kd_barang = rs.getString("kd_barang");
                String nm_barang = rs.getString("nm_barang");
                String stock = rs.getString("stock");
                String tanggal = rs.getString("tanggal");
                String[] dataField={tanggal,kd_barang, nm_barang, stock};
                tabel.addRow(dataField);
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(rootPane, "Akses Gagal");
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cari_barangKeyTyped

    private void txt_cari_barangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_cari_barangMouseClicked
        txt_cari_barang.setText("");
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cari_barangMouseClicked

    private void smpn_stock_barangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_smpn_stock_barangActionPerformed
        Connection koneksi = kdb.getConnection();
        try{
            String sql="Select * from tbl_barang where kd_barang like '%"+ txt_kd_barang1.getText() + "%'";
            Statement stmt=koneksi.createStatement();
            ResultSet rs=stmt.executeQuery(sql);
            while(rs.next()){
                try{
                    String harga = rs.getString("harga");
                    int stock = (Integer.parseInt(txt_stock_awal.getText()) + Integer.parseInt(txt_stock_tambah.getText()));
                    Statement stmt1 = koneksi.createStatement();
                    String sql1 = "UPDATE tbl_barang SET nm_barang='"+txt_nama_barang1.getText()+"',stock='"+stock+"',harga='"+harga+"',tanggal='"+txt_tgl_barang.getText()+"' WHERE kd_barang='"+ txt_kd_barang1.getText()+"'";
                    stmt1.executeUpdate(sql1);
                    JOptionPane.showMessageDialog(rootPane, "Edit Data Berhasil");
                    tabel_barang_stock();
                    bersih_stock();
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(this, "Data Gagal Di Simpan", "Pesan", JOptionPane.WARNING_MESSAGE);                
                }
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(rootPane, "Akses Gagal");
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_smpn_stock_barangActionPerformed

    private void btn_transaksi_baruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_transaksi_baruActionPerformed
        auto_no();
        btn_transaksi_baru.setEnabled(false);
        btn_tambah_transaksi.setEnabled(true);
        btn_batal_transaksi.setEnabled(true);
        btn_kembali_barang.setEnabled(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_transaksi_baruActionPerformed

    private void txt_kd_barang_transKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_kd_barang_transKeyTyped
        Connection koneksi = kdb.getConnection();
        try{
            String sql="Select * from tbl_barang where kd_barang like '%"+ txt_kd_barang_trans.getText() + "%'";
            Statement stmt=koneksi.createStatement();
            ResultSet rs=stmt.executeQuery(sql);
            while(rs.next()){
                txt_stock.setText(rs.getString("stock"));
                txt_harga_trans.setText(rs.getString("harga"));
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(rootPane, "Akses Gagal");
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_kd_barang_transKeyTyped

    private void txt_jmlhKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_jmlhKeyReleased
        int jmlh=Integer.parseInt(this.txt_jmlh.getText());
        int stock=Integer.parseInt(this.txt_stock.getText());
        int harga=Integer.parseInt(this.txt_harga_trans.getText());
        if( jmlh <= stock){
            int total_jmlh1=(harga*jmlh);
            String total_jmlh2=String.valueOf(total_jmlh1);
            txt_total_jmlh.setText(total_jmlh2);
        }else{
            txt_jmlh.setText("");
            JOptionPane.showMessageDialog(null, "Silahkan Masukan Jumlah Pembelian Lebih Kecil Dari Stock");
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_jmlhKeyReleased

    private void btn_tambah_transaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambah_transaksiActionPerformed
        Connection koneksi = kdb.getConnection();
        try{
                String sql="Select * from tbl_barang where kd_barang like '%"+ txt_kd_barang_trans.getText() + "%'";
                Statement stmt=koneksi.createStatement();
                ResultSet rs=stmt.executeQuery(sql);
                while(rs.next()){
                    try{
                        String kd_barang = rs.getString("kd_barang");
                        String nm_barang = rs.getString("nm_barang");
                        String harga = rs.getString("harga");
                        int jmlh=Integer.parseInt(this.txt_jmlh.getText());
                        int stock=Integer.parseInt(this.txt_stock.getText());
                        int update_stock = stock - jmlh ;
                        String update_stock1=String.valueOf(update_stock);
                        Statement stmt1 = koneksi.createStatement();
                        String sql1 = "INSERT INTO tbl_transaksi(no_transaksi,tgl_transaksi,kd_barang,nm_barang,jmlh_barang,hrg_barang,total,nama_kasir) VALUES('"+txt_no_transaksi.getText()+"','"+tgl_transaksi.getText()+"','"+kd_barang+"','"+nm_barang+"','"+txt_jmlh.getText()+"','"+txt_harga_trans.getText()+"','"+txt_total_jmlh.getText()+"','"+txt_nama_kasir.getText()+"')";
                        String sql2 = "UPDATE tbl_barang SET nm_barang='"+ nm_barang+"',stock='"+ update_stock1+"',harga='"+harga+"',tanggal='"+tgl_transaksi.getText()+"' WHERE kd_barang='"+kd_barang+"'";
                        stmt1.executeUpdate(sql1);
                        stmt1.executeUpdate(sql2);
                        bersih_trans_barang();
                        tabel_transaksi();
                    }catch(Exception ex){
                        JOptionPane.showMessageDialog(null, "Input Data gagal disimpan");            
                    }
                }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Input Data gagal disimpan");            
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_tambah_transaksiActionPerformed

    private void btn_batal_transaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_batal_transaksiActionPerformed
        bersih_trans_barang();
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_batal_transaksiActionPerformed

    private void btn_print_transaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_print_transaksiActionPerformed
        String NamaFile = "/toko/cstore/report/contoh.jasper";
        HashMap hash = new HashMap();
        try {
            hash.put("print_no", txt_no_transaksi.getText());
            hash.put("print_bayar", Integer.parseInt(txt_bayar.getText()));
            hash.put("print_kembali", Integer.parseInt(txt_kembalian.getText()));
            runReportDefault(NamaFile,hash);
            tmbl_transaksi_barang();
            bersih_trans_barang();
            txt_no_transaksi.setText("");
            txt_bayar.setText("");
        } catch (Exception e) {
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_print_transaksiActionPerformed

    private void txt_bayarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_bayarKeyReleased
        int bayar=Integer.parseInt(this.txt_bayar.getText());
        int total=Integer.parseInt(this.txt_total_transaksi.getText());
        int kembali=(bayar-total);
        String kembali2=String.valueOf(kembali);
        txt_kembalian.setText(kembali2);
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_bayarKeyReleased

    private void edit_penjualan_pulsaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edit_penjualan_pulsaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edit_penjualan_pulsaActionPerformed

    private void simpan_penjualan_pulsaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpan_penjualan_pulsaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_simpan_penjualan_pulsaActionPerformed

    private void batal_penjualan_pulsaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batal_penjualan_pulsaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_batal_penjualan_pulsaActionPerformed

    private void filter_penjualan_pulsaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filter_penjualan_pulsaActionPerformed
        // TODO add your handling code here:
        tabel_filter_trx_pls();
    }//GEN-LAST:event_filter_penjualan_pulsaActionPerformed

    private void tbl_trx_plsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_trx_plsMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_trx_plsMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(fm_utama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(fm_utama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(fm_utama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(fm_utama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new fm_utama().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem about;
    private javax.swing.JButton batal_kd_barang;
    private javax.swing.JButton batal_kd_pls;
    private javax.swing.JButton batal_penjualan_pulsa;
    private javax.swing.JButton batal_saldo_pls;
    private javax.swing.JButton batal_stock_barang;
    private toko.cstore.gambar.bg_toko bg_toko1;
    private javax.swing.JButton btn_axis;
    private javax.swing.JButton btn_axis1;
    private javax.swing.JButton btn_barang;
    private javax.swing.JButton btn_batal_data_pulsa;
    private javax.swing.JButton btn_batal_transaksi;
    private javax.swing.JButton btn_batal_user;
    private javax.swing.JButton btn_bolt;
    private javax.swing.JButton btn_bolt1;
    private javax.swing.JButton btn_etoll;
    private javax.swing.JButton btn_etoll1;
    private javax.swing.JButton btn_gojek;
    private javax.swing.JButton btn_gojek1;
    private javax.swing.JButton btn_indosat;
    private javax.swing.JButton btn_indosat1;
    private javax.swing.JButton btn_kembali_barang;
    private javax.swing.JButton btn_kembali_pulsa;
    private javax.swing.JButton btn_kembali_user;
    private javax.swing.JButton btn_pengeluaran;
    private javax.swing.JButton btn_print_barang;
    private javax.swing.JButton btn_print_transaksi;
    private javax.swing.JButton btn_print_transaksi1;
    private javax.swing.JButton btn_pulsa;
    private javax.swing.JButton btn_smartfren;
    private javax.swing.JButton btn_smartfren1;
    private javax.swing.JButton btn_tambah_transaksi;
    private javax.swing.JButton btn_telkomsel;
    private javax.swing.JButton btn_telkomsel1;
    private javax.swing.JButton btn_three;
    private javax.swing.JButton btn_three1;
    private javax.swing.JButton btn_tmbh_data_pulsa;
    private javax.swing.JButton btn_tmbh_user;
    private javax.swing.JButton btn_token;
    private javax.swing.JButton btn_token1;
    private javax.swing.JButton btn_transaksi_baru;
    private javax.swing.JButton btn_xl;
    private javax.swing.JButton btn_xl1;
    private javax.swing.JCheckBox chk_barang1;
    private javax.swing.JCheckBox chk_barang2;
    private javax.swing.JCheckBox chk_data;
    private javax.swing.JCheckBox chk_laporan;
    private javax.swing.JCheckBox chk_pulsa1;
    private javax.swing.JCheckBox chk_pulsa2;
    private javax.swing.JCheckBox chk_transaksi;
    private javax.swing.JComboBox cmb_nominal;
    private javax.swing.JComboBox cmb_stat_pulsa;
    private javax.swing.JComboBox cmb_stat_pulsa1;
    private javax.swing.JComboBox cmb_stat_pulsa2;
    private javax.swing.JComboBox cmb_user;
    private javax.swing.JButton data_barang;
    private javax.swing.JButton edit_kd_barang;
    private javax.swing.JButton edit_kd_pls;
    private javax.swing.JButton edit_penjualan_pulsa;
    private javax.swing.JButton edit_saldo_pls;
    private javax.swing.JButton edit_stock_barang;
    private javax.swing.JMenuItem exit;
    private javax.swing.JButton filter_pengeluaran;
    private javax.swing.JButton filter_penjualan_barang;
    private javax.swing.JButton filter_penjualan_pulsa;
    private javax.swing.JButton hapus_kd_barang;
    private javax.swing.JButton hapus_kd_pls;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    public static javax.swing.JButton kd_harga_barang;
    public static javax.swing.JButton kd_harga_pulsa;
    private javax.swing.JButton kembali_kd_barang;
    private javax.swing.JButton kembali_kd_pls;
    private javax.swing.JButton kembali_pengeluaran;
    private javax.swing.JButton kembali_penjualan_barang;
    private javax.swing.JButton kembali_penjualan_pulsa;
    private javax.swing.JButton kembali_saldo_pls;
    private javax.swing.JButton kembali_stock_barang;
    private javax.swing.JLabel lbl_kembali;
    public static javax.swing.JMenuItem login;
    private javax.swing.JScrollPane menu;
    private javax.swing.JMenu menu_menu;
    private javax.swing.JPanel panel_add_user;
    private javax.swing.JPanel panel_barang1;
    private javax.swing.JPanel panel_barang2;
    private javax.swing.JPanel panel_data;
    private javax.swing.JPanel panel_kd_harga_barang;
    private javax.swing.JPanel panel_kd_harga_pulsa;
    private javax.swing.JPanel panel_laporan;
    private javax.swing.JPanel panel_laporan_barang;
    private javax.swing.JPanel panel_laporan_pulsa;
    private javax.swing.JPanel panel_pengeluaran_barang;
    private javax.swing.JPanel panel_pulsa1;
    private javax.swing.JPanel panel_pulsa2;
    private javax.swing.JPanel panel_saldo_pulsa;
    private javax.swing.JPanel panel_stock_barang;
    private javax.swing.JPanel panel_tentang;
    private javax.swing.JPanel panel_trans_barang;
    private javax.swing.JPanel panel_trans_pulsa;
    private javax.swing.JPanel panel_transaksi;
    private javax.swing.JPanel panel_utama;
    private javax.swing.JPanel panelmenu;
    private javax.swing.JButton simpan_penjualan_pulsa;
    private javax.swing.JButton smpn_kd_barang;
    private javax.swing.JButton smpn_kd_pls;
    private javax.swing.JButton smpn_saldo_pls;
    private javax.swing.JButton smpn_stock_barang;
    private javax.swing.JButton stk_barang;
    private javax.swing.JButton stk_pulsa;
    private javax.swing.JTable tabel_lap_transaksi;
    private javax.swing.JTable tbl_kd_harga_barang;
    private javax.swing.JTable tbl_kd_harga_pulsa;
    private javax.swing.JTable tbl_pengeluaran;
    private javax.swing.JTable tbl_saldo;
    private javax.swing.JTable tbl_stock_barang;
    private javax.swing.JTable tbl_trans_barang;
    private javax.swing.JTable tbl_trx_pls;
    private javax.swing.JLabel tgl_transaksi;
    private javax.swing.JButton tmbh_kd_barang;
    private javax.swing.JButton tmbh_kd_pls;
    private javax.swing.JButton tmbh_saldo_pls;
    private javax.swing.JButton trans_barang;
    private javax.swing.JButton trans_pulsa;
    private javax.swing.JTextField txt_bayar;
    private javax.swing.JTextField txt_cari_barang;
    private javax.swing.JTextField txt_cari_barang1;
    private javax.swing.JTextField txt_cari_kd_barang;
    private javax.swing.JTextField txt_cari_kd_pulsa;
    private javax.swing.JTextField txt_cari_nama;
    private javax.swing.JTextField txt_harga_barang;
    private javax.swing.JTextField txt_harga_pulsa;
    private javax.swing.JTextField txt_harga_pulsa1;
    private javax.swing.JTextField txt_harga_trans;
    private javax.swing.JLabel txt_jam;
    private javax.swing.JTextField txt_jmlh;
    private javax.swing.JTextField txt_kd_barang;
    private javax.swing.JTextField txt_kd_barang1;
    private javax.swing.JTextField txt_kd_barang_trans;
    private javax.swing.JTextField txt_kd_pulsa;
    private javax.swing.JLabel txt_kembalian;
    private javax.swing.JTextField txt_nama;
    private javax.swing.JTextField txt_nama_barang;
    private javax.swing.JTextField txt_nama_barang1;
    private javax.swing.JTextField txt_nama_cus;
    public static javax.swing.JLabel txt_nama_kasir;
    private javax.swing.JLabel txt_nama_trans;
    private javax.swing.JTextField txt_nama_user;
    private javax.swing.JTextField txt_no_cus;
    private javax.swing.JLabel txt_no_trans;
    private javax.swing.JTextField txt_no_transaksi;
    private javax.swing.JLabel txt_no_user;
    private javax.swing.JTextField txt_nominal_pulsa;
    private javax.swing.JLabel txt_nominal_trans;
    private javax.swing.JPasswordField txt_pass_user;
    private javax.swing.JLabel txt_penjualan_barang;
    private javax.swing.JLabel txt_penjualan_barang1;
    private javax.swing.JLabel txt_penjualan_pulsa;
    private javax.swing.JLabel txt_provider;
    private javax.swing.JLabel txt_provider1;
    private javax.swing.JTextField txt_saldo_awal;
    private javax.swing.JTextField txt_saldo_tambah;
    private javax.swing.JTextField txt_saldo_terpakai;
    private javax.swing.JTextField txt_stock;
    private javax.swing.JTextField txt_stock_awal;
    private javax.swing.JTextField txt_stock_tambah;
    private javax.swing.JLabel txt_tgl;
    private com.toedter.calendar.JDateChooser txt_tgl_akhir;
    private com.toedter.calendar.JDateChooser txt_tgl_akhir1;
    private com.toedter.calendar.JDateChooser txt_tgl_awal;
    private com.toedter.calendar.JDateChooser txt_tgl_awal1;
    private javax.swing.JLabel txt_tgl_barang;
    private com.toedter.calendar.JDateChooser txt_tgl_pulsa;
    private javax.swing.JLabel txt_tgl_saldo;
    private javax.swing.JTextField txt_total_jmlh;
    private javax.swing.JLabel txt_total_transaksi;
    private javax.swing.JLabel txt_total_transaksi1;
    private javax.swing.JLabel txt_total_transaksi2;
    private javax.swing.JLabel txt_total_transaksi3;
    private javax.swing.JLabel txt_total_transaksi4;
    public static javax.swing.JLabel txt_user;
    public static javax.swing.JMenuItem user;
    // End of variables declaration//GEN-END:variables
}
