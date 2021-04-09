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
public class OptimalisasiDao extends tb_perankingan{
    Koneksi con;
    Statement st;
    ResultSet rs;
    String query;
    
    public Double NilaiBobot(String Id){
        Double nilai = 0.0;
        
        con = new Koneksi();
        try{
            st = con.connect().createStatement();
            rs = st.executeQuery("SELECT *FROM tb_kriteria WHERE id_kriteria = '"+Id+"'");
            while(rs.next()){
                nilai = rs.getDouble("nilai_kriteria");
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        return nilai;
    };
    
    public void Update(String Id, Double s) {
        con = new Koneksi();
        con.connect();
        try {
            st = con.conn.createStatement();
            query = "update tb_perankingan set s ='" + s + "' where Id = '" + Id + "'";
            st.executeUpdate(query);
            st.close();
            con.conn.close();
        } catch (SQLException e) {

        }
    }
    
    public void Optimalisasi(int rowCount, int columnCount, JTable tbl, DefaultTableModel dft) {
        
        Double S = 0.0;
        ArrayList<String> listId = new ArrayList<String>();
        ArrayList<Double> listC1 = new ArrayList<Double>();
        ArrayList<Double> listC2 = new ArrayList<Double>();
        ArrayList<Double> listC3 = new ArrayList<Double>();
        ArrayList<Double> listC4 = new ArrayList<Double>();
        ArrayList<Double> listC5 = new ArrayList<Double>();
        ArrayList<Double> listS = new ArrayList<Double>();

        for (int i = 0; i < rowCount; i++) {
            listId.add((tbl.getValueAt(i, 0).toString()));
            listC1.add((Double.parseDouble(tbl.getValueAt(i, 1).toString())));
            listC2.add((Double.parseDouble(tbl.getValueAt(i, 2).toString())));
            listC3.add((Double.parseDouble(tbl.getValueAt(i, 3).toString())));
            listC4.add((Double.parseDouble(tbl.getValueAt(i, 4).toString())));
            listC5.add((Double.parseDouble(tbl.getValueAt(i, 5).toString())));

            for (int k = 1; k < columnCount; k++) {
                S += ((Double.parseDouble(tbl.getValueAt(i, k).toString())));
            }

            listS.add(S);
            S=0.0;

        }

        int idSize = listId.size();
        int c1Size = listC1.size();
        int c2Size = listC2.size();
        int c3Size = listC3.size();
        int c4Size = listC4.size();
        int c5Size = listC5.size();
        int sSize = listS.size();

        for (int k = 0; k < c1Size; k++) {
            DefaultTableModel dataModel = dft;
            ArrayList list = new ArrayList<>();
            list.add(listId.get(k));
            list.add(String.format("%.4f", listC1.get(k)));
            list.add(String.format("%.4f", listC2.get(k)));
            list.add(String.format("%.4f", listC3.get(k)));
            list.add(String.format("%.4f", listC4.get(k)));
            list.add(String.format("%.4f", listC5.get(k)));
            list.add(String.format("%.4f", listS.get(k)));
            dataModel.addRow(list.toArray());

        }
    }
}
