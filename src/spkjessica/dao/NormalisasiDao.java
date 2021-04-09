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
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import spkjessica.koneksi.Koneksi;
import spkjessica.model.tb_perankingan;

/**
 *
 * @author User
 */
public class NormalisasiDao extends tb_perankingan{
    Koneksi con;
    Statement st;
    ResultSet res;
    String query;
    
    public Double MinC1(){
        
        Double c1 = 0.0;
        con = new Koneksi();
        try{
            st = con.connect().createStatement();
            res = st.executeQuery("SELECT MIN(c1) as minValue FROM tb_perankingan");
            while(res.next()){
                c1 = res.getDouble("minValue");
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        return c1;
    }
    
    public Double SumC1(){
        
        Double c1 = 0.0;
        con = new Koneksi();
        try{
            st = con.connect().createStatement();
            res = st.executeQuery("SELECT SUM(c1) as sumValue FROM tb_perankingan");
            while(res.next()){
                c1 = res.getDouble("sumValue");
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        return c1;
    }
    
    public Double SumC2(){
        
        Double c2 = 0.0;
        con = new Koneksi();
        try{
            st = con.connect().createStatement();
            res = st.executeQuery("SELECT SUM(c2) as sumValue FROM tb_perankingan");
            while(res.next()){
                c2 = res.getDouble("sumValue");
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        return c2;
    }
    
    public Double SumC3(){
        
        Double c3 = 0.0;
        con = new Koneksi();
        try{
            st = con.connect().createStatement();
            res = st.executeQuery("SELECT SUM(c3) as sumValue FROM tb_perankingan");
            while(res.next()){
                c3 = res.getDouble("sumValue");
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        return c3;
    }
    
    public Double SumC4(){
        
        Double c4 = 0.0;
        con = new Koneksi();
        try{
            st = con.connect().createStatement();
            res = st.executeQuery("SELECT SUM(c4) as sumValue FROM tb_perankingan");
            while(res.next()){
                c4 = res.getDouble("sumValue");
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        return c4;
    }
    
    public Double SumC5(){
        
        Double c5 = 0.0;
        con = new Koneksi();
        try{
            st = con.connect().createStatement();
            res = st.executeQuery("SELECT SUM(c5) as sumValue FROM tb_perankingan");
            while(res.next()){
                c5 = res.getDouble("sumValue");
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        return c5;
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
            query = "select *from tb_perankingan";
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
    
    public void Normalisasi(int rowCount, Double sum1, Double sum2,Double sum3,Double sum4,Double sum5, JTable tbl, DefaultTableModel dft) {
        ArrayList<String> listId = new ArrayList<String>();
        ArrayList<Double> listC1 = new ArrayList<Double>();
        ArrayList<Double> listC2 = new ArrayList<Double>();
        ArrayList<Double> listC3 = new ArrayList<Double>();
        ArrayList<Double> listC4 = new ArrayList<Double>();
        ArrayList<Double> listC5 = new ArrayList<Double>();

        for (int i = 0; i < rowCount; i++) {
            
            listId.add((tbl.getValueAt(i, 0).toString()));
            listC1.add((Double.parseDouble(tbl.getValueAt(i, 2).toString())/ sum1));
            listC2.add((Double.parseDouble(tbl.getValueAt(i, 3).toString()) / sum2));
            listC3.add((Double.parseDouble(tbl.getValueAt(i, 4).toString()) / sum3));
            listC4.add((Double.parseDouble(tbl.getValueAt(i, 5).toString()) / sum4));
            listC5.add((Double.parseDouble(tbl.getValueAt(i, 6).toString()) / sum5));
        }

        int idSize = listId.size();

        for (int j = 0; j < idSize; j++) {
            DefaultTableModel dataModel = dft;
            ArrayList list = new ArrayList<>();
            
            list.add(listId.get(j));
            list.add(String.format("%.4f", listC1.get(j)));
            list.add(String.format("%.4f", listC2.get(j)));
            list.add(String.format("%.4f", listC3.get(j)));
            list.add(String.format("%.4f", listC4.get(j)));
            list.add(String.format("%.4f", listC5.get(j)));
            dataModel.addRow(list.toArray());
        }
    }
}
