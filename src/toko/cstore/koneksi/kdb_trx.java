/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toko.cstore.koneksi;

import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author aap_07
 */
public class kdb_trx {
    private static Connection con;
    public kdb_trx(){
    }
    public static Connection getConnection(){
         try{
    con=DriverManager.getConnection("jdbc:mysql://localhost/kode_trx","root","");
    }
    catch(SQLException e){
        JOptionPane.showMessageDialog(null,"Gagal Koneksi");
    }
return con;
  }
}
