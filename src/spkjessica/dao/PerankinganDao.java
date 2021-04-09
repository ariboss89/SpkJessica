/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package spkjessica.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import spkjessica.koneksi.Koneksi;
import spkjessica.model.tb_perankingan;

/**
 *
 * @author User
 */
public class PerankinganDao extends tb_perankingan{
    Koneksi con;
    Statement st;
    ResultSet res;
    String query;
    private String idAlternatif;

    public String getIdAlternatif() {
        return idAlternatif;
    }

    public void setIdAlternatif(String idAlternatif) {
        this.idAlternatif = idAlternatif;
    }
   
    public Double FindMaxSValue(){
        
        Double s = 0.0;
        con = new Koneksi();
        try{
            st = con.connect().createStatement();
            res = st.executeQuery("SELECT MAX(s) as va FROM tb_perankingan");
            if(res.next()){
                s = res.getDouble("va");
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        return s;
    }
    
    public void Update(String Id, Double k) {
        con = new Koneksi();
        con.connect();
        try {
            st = con.conn.createStatement();
            query = "update tb_perankingan set k ='" + k + "' where Id = '" + Id + "'";
            st.executeUpdate(query);
            st.close();
            con.conn.close();
        } catch (SQLException e) {

        }
    }
    
    public void Perankingan(int rowCount, int columnCount, JTable tbl, Double maxS, DefaultTableModel dft){
        Double K = 0.0;
        ArrayList<String> listId = new ArrayList<String>();
        ArrayList<Double> listC1 = new ArrayList<Double>();
        ArrayList<Double> listC2 = new ArrayList<Double>();
        ArrayList<Double> listC3 = new ArrayList<Double>();
        ArrayList<Double> listC4 = new ArrayList<Double>();
        ArrayList<Double> listC5 = new ArrayList<Double>();
        ArrayList<Double> listS = new ArrayList<Double>();
        ArrayList<Double> listK = new ArrayList<Double>();
        
        for (int i = 0; i < rowCount; i++) {
            listId.add((tbl.getValueAt(i, 0).toString()));
            listC1.add((Double.parseDouble(tbl.getValueAt(i, 1).toString())));
            listC2.add((Double.parseDouble(tbl.getValueAt(i, 2).toString())));
            listC3.add((Double.parseDouble(tbl.getValueAt(i, 3).toString())));
            listC4.add((Double.parseDouble(tbl.getValueAt(i, 4).toString())));
            listC5.add((Double.parseDouble(tbl.getValueAt(i, 5).toString())));
            listS.add((Double.parseDouble(tbl.getValueAt(i, 6).toString())));
            listK.add(Double.parseDouble(tbl.getValueAt(i, 6).toString())/ maxS);
        }

        int idSize = listId.size();

        for (int k = 0; k < idSize; k++) {
            DefaultTableModel dataModel = dft;
            ArrayList list = new ArrayList<>();
            list.add(listId.get(k));
            list.add(String.format("%.4f", listC1.get(k)));
            list.add(String.format("%.4f", listC2.get(k)));
            list.add(String.format("%.4f", listC3.get(k)));
            list.add(String.format("%.4f", listC4.get(k)));
            list.add(String.format("%.4f", listC5.get(k)));
            list.add(String.format("%.4f", listS.get(k)));
            list.add(String.format("%.4f", listK.get(k)));
            dataModel.addRow(list.toArray());

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
            query = "SELECT *FROM tb_perankingan ORDER BY k DESC";
            res = st.executeQuery(query);
            data = new String[jumlahBaris][10];
            int r = 0;
            while (res.next()) {
                data[r][0] = res.getString("Id");
                data[r][1] = res.getString("alternatif");
                data[r][2] = res.getString("c1");
                data[r][3] = res.getString("c2");
                data[r][4] = res.getString("c3");
                data[r][5] = res.getString("c4");
                data[r][6] = res.getString("c5");
                data[r][7] = res.getString("s");
                data[r][8] = res.getString("k");
                data[r][9] = res.getString("ket");
                r++;
            }
            int jmlBaris = r;
            String[][] tmpArray = data;
            data = new String[jmlBaris][10];
            for (r = 0; r < jmlBaris; r++) {
                for (int c = 0; c <10; c++) {
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
    
    public void UpdateKet(String Id, String ket) {
        con = new Koneksi();
        con.connect();
        try {
            st = con.conn.createStatement();
            query = "update tb_perankingan set ket ='" + ket + "' where Id = '" + Id + "'";
            st.executeUpdate(query);
            st.close();
            con.conn.close();
        } catch (SQLException e) {

        }
    }
}
