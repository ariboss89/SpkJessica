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
import spkjessica.model.tb_perankingan;

/**
 *
 * @author User
 */
public class ProsesDao extends tb_perankingan{
    Koneksi con;
    Statement st;
    ResultSet res;
    String query;
    
    public String IdPerankingan() {
        String idRanking = "";
        con = new Koneksi();
        try {
            st = con.connect().createStatement();
            res = st.executeQuery("select *from tb_perankingan ORDER BY Id DESC");
            if (res.first() == false) {
                idRanking = ("R001");
            } else {
                res.first();
                System.out.println("COT: " + res.getString("Id").substring(1, 4));
                int no = Integer.valueOf(res.getString("Id").substring(1, 4)) + 1;
                System.out.println(no);
                if (no < 10) {
                    idRanking = ("R00" + no);
                }
                else if (no >= 10 && no < 100) {
                    idRanking = ("R0" + no);
                } else if (no >= 100 && no < 1000) {
                    idRanking = ("R" + no);
                }
            }
            res.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Data tidak ditemukan");
        }

        return idRanking;
    };
    
    public void Save(String Id, String nama, Double c1, Double c2,Double c3,Double c4,Double c5 ) {
        con = new Koneksi();
        con.connect();
        try {
            st = con.conn.createStatement();
            query = "insert into tb_perankingan(Id, alternatif, c1, c2, c3, c4, c5)values('"+Id+"','" + nama + "','" + c1 + "', '"+c2+"', '"+c3+"', '"+c4+"', '"+c5+"')";
            st.executeUpdate(query);
            st.close();
            con.conn.close();
            JOptionPane.showMessageDialog(null, "Data Berhasil di Simpan");
        } catch (SQLException e) {
        }
    }
    
    public void Update(String Id, String nama, Double c1, Double c2,Double c3,Double c4,Double c5) {
        con = new Koneksi();
        con.connect();
        try {
            st = con.conn.createStatement();
            query = "update tb_perankingan set alternatif ='" + nama + "', c1 ='"+c1+"', c2 ='"+c2+"', c3 ='"+c3+"', c4 ='"+c4+"', c5 ='"+c5+"' where Id = '" + Id + "'";
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
            query = "delete from tb_perankingan where Id = '" + Id + "'";
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
            query = "SELECT COUNT(Id) AS Jumlah FROM tb_perankingan";
            res = st.executeQuery(query);
            if (res.next()) {
                jumlahBaris = res.getInt("Jumlah");
            }
            query = "select *from tb_perankingan ORDER BY Id ASC";
            res = st.executeQuery(query);
            data = new String[jumlahBaris][7];
            int r = 0;
            while (res.next()) {
                data[r][0] = res.getString("Id");
                data[r][1] = res.getString("alternatif");
                data[r][2] = res.getString("c1");
                data[r][3] = res.getString("c2");
                data[r][4] = res.getString("c3");
                data[r][5] = res.getString("c4");
                data[r][6] = res.getString("c5");
                r++;
            }
            int jmlBaris = r;
            String[][] tmpArray = data;
            data = new String[jmlBaris][7];
            for (r = 0; r < jmlBaris; r++) {
                for (int c = 0; c <7; c++) {
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
