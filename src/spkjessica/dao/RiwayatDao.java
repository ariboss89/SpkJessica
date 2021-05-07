/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package spkjessica.dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import spkjessica.koneksi.Koneksi;
import spkjessica.model.tb_riwayat;

/**
 *
 * @author User
 */
public class RiwayatDao extends tb_riwayat {
    
    Koneksi con;
    Statement st;
    ResultSet res;
    String query;
    
    public void Save(String tanggal, String nama, String c1, String c2, String c3, String c4, String c5, String S, String K, String ket) {
        con = new Koneksi();
        con.connect();
        try {
            st = con.conn.createStatement();
            query = "insert into tb_riwayat(tanggal, alternatif, c1, c2, c3, c4, c5, s, k, ket)values('" + tanggal + "','" + nama + "','" + c1 + "', '"+c2+"','" + c3 + "','" + c4 + "','" + c5 + "','" + S + "','" + K + "','" + ket + "')";
            st.executeUpdate(query);
            st.close();
            con.conn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data Gagal di Simpan");
        }
    }
}
