/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package spkjessica.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import spkjessica.koneksi.Koneksi;
import spkjessica.model.tb_kriteria;

/**
 *
 * @author User
 */
public class KriteriaDao extends tb_kriteria{
    Koneksi con;
    Statement st;
    ResultSet res;
    String query;
    
    public String IdKriteria() {
        String idKriteria = "";
        con = new Koneksi();
        try {
            st = con.connect().createStatement();
            res = st.executeQuery("select *from tb_kriteria ORDER BY id_kriteria DESC");
            if (res.first() == false) {
                idKriteria = ("C1");
            } else {
                res.first();
                System.out.println("COT: " + res.getString("id_kriteria").substring(1, 2));
                int no = Integer.valueOf(res.getString("id_kriteria").substring(1, 2)) + 1;
                System.out.println(no);
                if (no < 10) {
                    idKriteria = ("C" + no);
                }
            }
            res.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Data tidak ditemukan");
        }

        return idKriteria;
    };
    
    public Double SumKriteria(){
        
        Double nilai = 0.0;
        con = new Koneksi();
        try{
            st = con.connect().createStatement();
            res = st.executeQuery("SELECT SUM(nilai_kriteria) as sumValue FROM tb_kriteria");
            while(res.next()){
                nilai = res.getDouble("sumValue");
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        return nilai;
    }
    
    public void Save(String Id, String nama, Double nilai) {
        con = new Koneksi();
        con.connect();
        try {
            st = con.conn.createStatement();
            query = "insert into tb_kriteria(id_kriteria, nama_kriteria, nilai_kriteria)values('" + Id + "','" + nama + "', '"+nilai+"')";
            st.executeUpdate(query);
            st.close();
            con.conn.close();
            JOptionPane.showMessageDialog(null, "Data Berhasil di Simpan");
        } catch (SQLException e) {
        }
    }
    
    public void Update(String Id, String nama, Double nilai) {
        con = new Koneksi();
        con.connect();
        try {
            st = con.conn.createStatement();
            query = "update tb_kriteria set nama_kriteria ='" + nama + "', nilai_kriteria ='"+nilai+"' where id_kriteria = '" + Id + "'";
            st.executeUpdate(query);
            st.close();
            con.conn.close();
            JOptionPane.showMessageDialog(null, "Data Berhasil di Update");
        } catch (SQLException e) {

        }
    }
    
    public void Delete(String Id) {
        con = new Koneksi();
        con.connect();
        try {
            st = con.conn.createStatement();
            query = "delete from tb_kriteria where id_kriteria = '" + Id + "'";
            st.executeUpdate(query);
            st.close();
            con.conn.close();
            JOptionPane.showMessageDialog(null, "Data di Hapus");
        } catch (SQLException e) {
        }
    }
    
    public String[][] Show() {

        res = null;
        String[][] data = null;
        con = new Koneksi();
        con.connect();
        int jumlahBaris = 0;
        try {
            st = con.conn.createStatement();
            query = "SELECT COUNT(id_kriteria) AS Jumlah FROM tb_kriteria";
            res = st.executeQuery(query);
            if (res.next()) {
                jumlahBaris = res.getInt("Jumlah");
            }
            query = "select *from tb_kriteria";
            res = st.executeQuery(query);
            data = new String[jumlahBaris][3];
            int r = 0;
            while (res.next()) {
                data[r][0] = res.getString("id_kriteria");
                data[r][1] = res.getString("nama_kriteria");
                data[r][2] = res.getString("nilai_kriteria");
                r++;
            }
            int jmlBaris = r;
            String[][] tmpArray = data;
            data = new String[jmlBaris][3];
            for (r = 0; r < jmlBaris; r++) {
                for (int c = 0; c <3; c++) {
                    data[r][c] = tmpArray[r][c];
                }
            }
            st.close();
            con.conn.close();
        } catch (SQLException e) {
            System.err.println("SQLException : " + e.getMessage());
        }
        return data;
    }
    
}
