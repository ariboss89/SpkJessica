/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spkjessica.view;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import spkjessica.dao.BobotMatriksDao;
import spkjessica.dao.NormalisasiDao;
import spkjessica.dao.OptimalisasiDao;
import spkjessica.dao.PerankinganDao;
import spkjessica.dao.ProsesDao;
import spkjessica.dao.ReportDao;
import spkjessica.dao.RiwayatDao;
import spkjessica.koneksi.Koneksi;
import spkjessica.model.tb_model;

/**
 *
 * @author User
 */
public class KeputusanView extends javax.swing.JFrame {

    Koneksi con;
    Statement st;
    ResultSet rs;
    BobotMatriksDao bd = new BobotMatriksDao();
    NormalisasiDao nd = new NormalisasiDao();
    OptimalisasiDao od = new OptimalisasiDao();
    ProsesDao pd = new ProsesDao();
    PerankinganDao prd = new PerankinganDao();
    ReportDao rd = new ReportDao();
    RiwayatDao rwd = new RiwayatDao();
    tb_model tbm = new tb_model();
    String Id, nama;
    Double c1, c2, c3, c4, c5;
    String[][] res;
    String[] kolomNormalisasi = {"ID", "ALTERNATIF", "C1", "C2", "C3", "C4", "C5"};
    int jmlKolomNormalisasi = kolomNormalisasi.length;
    int[] lebarNormalisasi = {200, 400, 200, 200, 200, 200, 200};

    String[] kolomPerankingan = {"ID", "ALTERNATIF", "C1", "C2", "C3", "C4", "C5", "S", "K", "KET"};
    int jmlKolomPerankingan = kolomPerankingan.length;
    int[] lebarPerankingan = {200, 400, 200, 200, 200, 200, 200, 200, 200, 200};

    public KeputusanView() {
        initComponents();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (dim.width - getWidth()) / 2 + 70;
        int y = (dim.height - getHeight()) / 2 + 10;
        setLocation(x, y);
        Refresh();
        ShowNamaAlternatif();
    }

    private void Refresh() {
        pd.setId(pd.IdPerankingan());
        cbNama.requestFocus();
        cbNama.setSelectedIndex(0);
        txtC1.setText("");
        txtC2.setText("");
        txtC3.setText("");
        txtC4.setText("");
        txtC5.setText("");
        btnSave.setEnabled(true);
        btnUpdate.setEnabled(false);
        btnDelete.setEnabled(false);
        btnCetak.setEnabled(false);
    }

    private void ShowNamaAlternatif() {
        con = new Koneksi();
        try {
            st = con.connect().createStatement();
            rs = st.executeQuery("SELECT *FROM tb_alternatif");
            while (rs.next()) {
                cbNama.addItem(rs.getString("nama"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void UpdateS() {
        int rowCount = jTable4.getRowCount();
        for (int i = 0; i < rowCount; i++) {
            String Id = jTable4.getValueAt(i, 0).toString();
            Double s = Double.parseDouble(jTable4.getValueAt(i, 6).toString());

            od.Update(Id, s);
        }
    }

    private void UpdateK() {
        int rowCount = jTable5.getRowCount();
        for (int i = 0; i < rowCount; i++) {
            String Id = jTable5.getValueAt(i, 0).toString();
            Double k = Double.parseDouble(jTable5.getValueAt(i, 7).toString());

            prd.Update(Id, k);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtC1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtC2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtC3 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtC4 = new javax.swing.JTextField();
        txtC5 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnNew = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        cbNama = new javax.swing.JComboBox();
        btnHitung = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable6 = new javax.swing.JTable();
        btnCetak = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 153, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("NAMA");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("SMART SELLING (1-3)");

        txtC1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtC1KeyTyped(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("KINERJA BISNIS (1-3)");

        txtC2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtC2KeyTyped(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("PELAYANAN (1-90)");

        txtC3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtC3KeyTyped(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("PENAMPILAN (1-8)");

        txtC4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtC4KeyTyped(evt);
            }
        });

        txtC5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtC5KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtC5KeyTyped(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("KEPRIBADIAN (1-85)");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        btnNew.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnNew.setText("NEW");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        btnUpdate.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnUpdate.setText("UPDATE");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDelete.setText("DELETE");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnSave.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSave.setText("SAVE");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        cbNama.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cbNama.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "PILIH" }));
        cbNama.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbNamaItemStateChanged(evt);
            }
        });

        btnHitung.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnHitung.setText("MULAI PERHITUNGAN");
        btnHitung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHitungActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(213, 213, 213))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(cbNama, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(18, 18, 18)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(txtC3, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(txtC1, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(txtC4, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel3)
                                    .addComponent(txtC2, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                            .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addComponent(txtC5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 394, Short.MAX_VALUE))
                    .addComponent(btnHitung, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(31, 31, 31))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtC3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtC1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtC4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtC2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtC5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNew)
                    .addComponent(btnSave)
                    .addComponent(btnUpdate)
                    .addComponent(btnDelete))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnHitung)
                .addContainerGap())
        );

        jTabbedPane1.addTab("ALTERNATIF DAN KRITERIA", jPanel1);

        jPanel2.setBackground(new java.awt.Color(0, 153, 255));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "C1", "C2", "C3", "C4", "C5"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 876, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("NORMALISASI", jPanel2);

        jPanel3.setBackground(new java.awt.Color(0, 153, 255));

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "C1", "C2", "C3", "C4", "C5"
            }
        ));
        jScrollPane3.setViewportView(jTable3);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 876, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("BOBOT MATRIKS", jPanel3);

        jPanel4.setBackground(new java.awt.Color(0, 153, 255));

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "C1", "C2", "C3", "C4", "C5", "S"
            }
        ));
        jScrollPane4.setViewportView(jTable4);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 876, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("OPTIMALISASI", jPanel4);

        jPanel5.setBackground(new java.awt.Color(0, 153, 255));

        jTable5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "C1", "C2", "C3", "C4", "C5", "S", "K"
            }
        ));
        jScrollPane5.setViewportView(jTable5);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 876, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("PERANKINGAN", jPanel5);

        jPanel6.setBackground(new java.awt.Color(0, 153, 255));

        jTable6.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane6.setViewportView(jTable6);

        btnCetak.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnCetak.setText("CETAK HASIL PERANKINGAN");
        btnCetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCetakActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 876, Short.MAX_VALUE)
                    .addComponent(btnCetak, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 415, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCetak)
                .addContainerGap())
        );

        jTabbedPane1.addTab("HASIL", jPanel6);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        // TODO add your handling code here:
        Refresh();
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        if (cbNama.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Silahkan Pilih Nama Terlebih Dahulu !!");
            cbNama.requestFocus();
        } else if (txtC1.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Silahkan Isi Field Terlebih Dahulu !!");
            txtC1.requestFocus();
        } else if (txtC2.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Silahkan Isi Field Terlebih Dahulu !!");
            txtC2.requestFocus();
        } else if (txtC3.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Silahkan Isi Field Terlebih Dahulu !!");
            txtC3.requestFocus();
        } else if (txtC4.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Silahkan Isi Field Terlebih Dahulu !!");
            txtC4.requestFocus();
        } else if (txtC5.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Silahkan Isi Field Terlebih Dahulu !!");
            txtC5.requestFocus();
        } else {
            Id = pd.getId();
            nama = cbNama.getSelectedItem().toString().trim();
            c1 = Double.parseDouble(txtC1.getText().trim());
            c2 = Double.parseDouble(txtC2.getText().trim());
            c3 = Double.parseDouble(txtC3.getText().trim());
            c4 = Double.parseDouble(txtC4.getText().trim());
            c5 = Double.parseDouble(txtC5.getText().trim());
            pd.Update(Id, nama, c1, c2, c3, c4, c5);
            Refresh();
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        int ok = JOptionPane.showConfirmDialog(null, "Konfirmasi", "Apa Anda Ingin Menghapus Data ?", JOptionPane.YES_NO_OPTION);
        if (ok == 0) {
            pd.Delete(pd.getId());
            Refresh();
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        if (cbNama.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Silahkan Pilih Nama Terlebih Dahulu !!");
            cbNama.requestFocus();
        } else if (txtC1.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Silahkan Isi Field Terlebih Dahulu !!");
            txtC1.requestFocus();
        } else if (txtC2.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Silahkan Isi Field Terlebih Dahulu !!");
            txtC2.requestFocus();
        } else if (txtC3.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Silahkan Isi Field Terlebih Dahulu !!");
            txtC3.requestFocus();
        } else if (Integer.parseInt(txtC3.getText()) > 90) {
            JOptionPane.showMessageDialog(null, "Batas Nilai Kriteria Pelayanan Adalah 90");
            txtC3.setText("");
        } else if (Integer.parseInt(txtC3.getText()) < 70) {
            JOptionPane.showMessageDialog(null, "Batas Nilai Minimum Kriteria Pelayanan Adalah 70");
            txtC3.setText("");
            txtC3.requestFocus();
        } else if (txtC4.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Silahkan Isi Field Terlebih Dahulu !!");
            txtC4.requestFocus();
        } else if (txtC5.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Silahkan Isi Field Terlebih Dahulu !!");
            txtC5.requestFocus();
        } else if (Integer.parseInt(txtC5.getText()) > 85) {
            JOptionPane.showMessageDialog(null, "Batas Nilai Kriteria Kepribadian Adalah 85");
            txtC5.setText("");
            txtC5.requestFocus();
        } else if (Integer.parseInt(txtC5.getText()) < 70) {
            JOptionPane.showMessageDialog(null, "Batas Nilai Minimum Kriteria Kepribadian Adalah 70");
            txtC5.setText("");
            txtC5.requestFocus();
        } else {
            con = new Koneksi();
            try {
                st = con.connect().createStatement();
                rs = st.executeQuery("SELECT *FROM tb_perankingan WHERE alternatif = '" + cbNama.getSelectedItem().toString() + "'");
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "Data Alternatif Telah di Tambahkan !!");
                    Refresh();
                } else {
                    Id = pd.getId();
                    nama = cbNama.getSelectedItem().toString().trim();
                    c1 = Double.parseDouble(txtC1.getText().trim());
                    c2 = Double.parseDouble(txtC2.getText().trim());
                    c3 = Double.parseDouble(txtC3.getText().trim());
                    c4 = Double.parseDouble(txtC4.getText().trim());
                    c5 = Double.parseDouble(txtC5.getText().trim());
                    pd.Save(Id, nama, c1, c2, c3, c4, c5);
                    Refresh();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        res = pd.Show();
        tbm.SetTabel(jTable1, res, kolomNormalisasi, jmlKolomNormalisasi, lebarNormalisasi);
    }//GEN-LAST:event_formWindowActivated

    private void cbNamaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbNamaItemStateChanged
        // TODO add your handling code here:
        txtC1.requestFocus();
    }//GEN-LAST:event_cbNamaItemStateChanged

    private void btnHitungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHitungActionPerformed
        // TODO add your handling code here:       
        int rowCountTabel1 = jTable1.getRowCount();

        if (rowCountTabel1 < 3) {
            JOptionPane.showMessageDialog(null, "Silahkan Masukkan Kembali Data Alternatif Untuk Melanjutkan, Minimal 3 data !!");
        } else {

            //Normalisasi
            DefaultTableModel dataModelTabel2 = (DefaultTableModel) jTable2.getModel();
            nd.Normalisasi(rowCountTabel1, nd.SumC1(), nd.SumC2(), nd.SumC3(), nd.SumC4(), nd.SumC5(), jTable1, dataModelTabel2);

            //Bobot Matriks
            int rowCountTabel2 = jTable2.getRowCount();
            DefaultTableModel dataModelTabel3 = (DefaultTableModel) jTable3.getModel();
            bd.BobotMatriks(rowCountTabel2, jTable2, od.NilaiBobot("C1"), od.NilaiBobot("C2"), od.NilaiBobot("C3"), od.NilaiBobot("C4"), od.NilaiBobot("C5"), dataModelTabel3);

            //Optimalisasi
            int rowCountTabel3 = jTable3.getRowCount();
            int columnCountTabel3 = jTable3.getColumnCount();
            DefaultTableModel dataModelTabel4 = (DefaultTableModel) jTable4.getModel();
            od.Optimalisasi(rowCountTabel3, columnCountTabel3, jTable3, dataModelTabel4);
            UpdateS();

            //Perankingan
            int rowCountTabel4 = jTable4.getRowCount();
            int columnCountTabel4 = jTable4.getColumnCount();
            Double maxS = prd.FindMaxSValue();
            DefaultTableModel dataModel = (DefaultTableModel) jTable5.getModel();

            prd.Perankingan(rowCountTabel4, columnCountTabel4, jTable4, maxS, dataModel);
            UpdateK();

            res = prd.Show();
            tbm.SetTabel(jTable6, res, kolomPerankingan, jmlKolomPerankingan, lebarPerankingan);

            int rowCounts = jTable6.getRowCount();
            for (int i = 0; i < rowCounts; i++) {

                String IdAlternatif = jTable6.getValueAt(i, 0).toString();
                int rank = i + 1;
                String ket = "Ranking " + rank;
                prd.UpdateKet(IdAlternatif, ket);
            }

            res = prd.Show();
            tbm.SetTabel(jTable6, res, kolomPerankingan, jmlKolomPerankingan, lebarPerankingan);

            btnHitung.setEnabled(false);
            btnCetak.setEnabled(true);
            btnSave.setEnabled(false);
            cbNama.setEnabled(false);
            btnNew.setEnabled(false);
        }
    }//GEN-LAST:event_btnHitungActionPerformed

    private void btnCetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCetakActionPerformed
        // TODO add your handling code here:
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMM-yyyy");
        LocalDateTime now = LocalDateTime.now();

        String tanggal = (dtf.format(now));
        
        int count = jTable6.getRowCount();
        for (int i = 0; i < count; i++) {
            String namaa = jTable6.getValueAt(i, 1).toString();
            String c11 = jTable6.getValueAt(i, 2).toString();
            String c22 = jTable6.getValueAt(i, 3).toString();
            String c33 = jTable6.getValueAt(i, 4).toString();
            String c44 = jTable6.getValueAt(i, 5).toString();
            String c55 = jTable6.getValueAt(i, 6).toString();
            String s = jTable6.getValueAt(i, 7).toString();
            String k = jTable6.getValueAt(i, 8).toString();
            String ket = jTable6.getValueAt(i, 9).toString();
            
            rwd.Save(tanggal, namaa, c11, c22, c33, c44, c55, s, k, ket);
        }

        rd.CetakHasil();
        dispose();
    }//GEN-LAST:event_btnCetakActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        int count = jTable1.getSelectedRow();
        pd.setId(jTable1.getValueAt(count, 0).toString());
        cbNama.setSelectedItem(jTable1.getValueAt(count, 1).toString());
        txtC1.setText(jTable1.getValueAt(count, 2).toString());
        txtC2.setText(jTable1.getValueAt(count, 3).toString());
        txtC3.setText(jTable1.getValueAt(count, 4).toString());
        txtC4.setText(jTable1.getValueAt(count, 5).toString());
        txtC5.setText(jTable1.getValueAt(count, 6).toString());
        btnUpdate.setEnabled(true);
        btnDelete.setEnabled(true);
        btnSave.setEnabled(false);
    }//GEN-LAST:event_jTable1MouseClicked

    private void txtC1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtC1KeyTyped
        // TODO add your handling code here:
        char karakter = evt.getKeyChar();

        if (!(((karakter >= '0') && (karakter <= '3') || (karakter == KeyEvent.VK_BACK_SPACE) || (karakter == KeyEvent.VK_DELETE) || (karakter == KeyEvent.VK_ENTER)))) {
            getToolkit().beep();
            evt.consume();
        }

        if (karakter == KeyEvent.VK_SPACE) {
            getToolkit().beep();
            evt.consume();
        }

        if (txtC1.getText().length() >= 1) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtC1KeyTyped

    private void txtC2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtC2KeyTyped
        // TODO add your handling code here:
        char karakter = evt.getKeyChar();

        if (!(((karakter >= '0') && (karakter <= '3') || (karakter == KeyEvent.VK_BACK_SPACE) || (karakter == KeyEvent.VK_DELETE) || (karakter == KeyEvent.VK_ENTER)))) {
            getToolkit().beep();
            evt.consume();
        }

        if (karakter == KeyEvent.VK_SPACE) {
            getToolkit().beep();
            evt.consume();
        }

        if (txtC2.getText().length() >= 1) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtC2KeyTyped

    private void txtC3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtC3KeyTyped
        // TODO add your handling code here:
        char karakter = evt.getKeyChar();

        if (!(((karakter >= '0') && (karakter <= '9') || (karakter == KeyEvent.VK_BACK_SPACE) || (karakter == KeyEvent.VK_DELETE) || (karakter == KeyEvent.VK_ENTER)))) {
            getToolkit().beep();
            evt.consume();
        }

        if (karakter == KeyEvent.VK_SPACE) {
            getToolkit().beep();
            evt.consume();
        }

        if (txtC3.getText().length() >= 2) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtC3KeyTyped

    private void txtC4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtC4KeyTyped
        // TODO add your handling code here:
        char karakter = evt.getKeyChar();

        if (!(((karakter >= '0') && (karakter <= '8') || (karakter == KeyEvent.VK_BACK_SPACE) || (karakter == KeyEvent.VK_DELETE) || (karakter == KeyEvent.VK_ENTER)))) {
            getToolkit().beep();
            evt.consume();
        }

        if (karakter == KeyEvent.VK_SPACE) {
            getToolkit().beep();
            evt.consume();
        }

        if (txtC4.getText().length() >= 1) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtC4KeyTyped

    private void txtC5KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtC5KeyTyped
        // TODO add your handling code here:
        char karakter = evt.getKeyChar();

        if (!(((karakter >= '0') && (karakter <= '9') || (karakter == KeyEvent.VK_BACK_SPACE) || (karakter == KeyEvent.VK_DELETE) || (karakter == KeyEvent.VK_ENTER)))) {
            getToolkit().beep();
            evt.consume();
        }

        if (karakter == KeyEvent.VK_SPACE) {
            getToolkit().beep();
            evt.consume();
        }

        if (txtC5.getText().length() >= 2) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtC5KeyTyped

    private void txtC5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtC5KeyReleased
        // TODO add your handling code here:

    }//GEN-LAST:event_txtC5KeyReleased

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
            java.util.logging.Logger.getLogger(KeputusanView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KeputusanView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KeputusanView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KeputusanView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new KeputusanView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCetak;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnHitung;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox cbNama;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTable jTable5;
    private javax.swing.JTable jTable6;
    private javax.swing.JTextField txtC1;
    private javax.swing.JTextField txtC2;
    private javax.swing.JTextField txtC3;
    private javax.swing.JTextField txtC4;
    private javax.swing.JTextField txtC5;
    // End of variables declaration//GEN-END:variables
}
