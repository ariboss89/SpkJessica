/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package spkjessica.dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import spkjessica.koneksi.Koneksi;

/**
 *
 * @author User
 */
public class BobotMatriksDao {
    Koneksi con;
    Statement st;
    ResultSet res;
    String query;
    
    public void BobotMatriks(int rowCount, JTable tbl, Double nilaiBobot1, Double nilaiBobot2,Double nilaiBobot3,Double nilaiBobot4,Double nilaiBobot5, DefaultTableModel dft) {
        
        ArrayList<String> listId = new ArrayList<String>();
        ArrayList<Double> listC1 = new ArrayList<Double>();
        ArrayList<Double> listC2 = new ArrayList<Double>();
        ArrayList<Double> listC3 = new ArrayList<Double>();
        ArrayList<Double> listC4 = new ArrayList<Double>();
        ArrayList<Double> listC5 = new ArrayList<Double>();

        for (int i = 0; i < rowCount; i++) {
            listId.add((tbl.getValueAt(i, 0).toString()));
            listC1.add((Double.parseDouble(tbl.getValueAt(i, 1).toString())) * nilaiBobot1);
            listC2.add((Double.parseDouble(tbl.getValueAt(i, 2).toString()) * nilaiBobot2));
            listC3.add((Double.parseDouble(tbl.getValueAt(i, 3).toString()) * nilaiBobot3));
            listC4.add((Double.parseDouble(tbl.getValueAt(i, 4).toString()) * nilaiBobot4));
            listC5.add((Double.parseDouble(tbl.getValueAt(i, 5).toString()) * nilaiBobot5));
        }

        int idSize = listId.size();
        int c1Size = listC1.size();
        int c2Size = listC2.size();
        int c3Size = listC3.size();
        int c4Size = listC4.size();
        int c5Size = listC5.size();

        for (int j = 0; j < c1Size; j++) {
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
