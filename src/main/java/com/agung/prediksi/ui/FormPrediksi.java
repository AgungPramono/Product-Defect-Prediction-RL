/*
 *  FormPrediksi.java
 *  Prediksi-Cacat-Produk 
 * 
 *  Created by Agung Pramono on 08/09/2017 
 *  Copyright (c) 2017 Java Development. All rights reserved.
 */
package com.agung.prediksi.ui;

import com.agung.prediksi.Main;
import com.agung.prediksi.engine.NumericEvaluation;
import com.agung.prediksi.engine.RegresiEngine;
import com.agung.prediksi.entity.Data;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author agung
 */
public class FormPrediksi extends javax.swing.JFrame {

    private List<Data> listData;

    public FormPrediksi() {
        initComponents();
        setTitle(".: Prediksi Cacat Produk :.");
        setLocationRelativeTo(null);
        loadDataToTable();
    }

    private void loadDataToTable() {
        listData = Main.getDao().getAllData();
        if (listData != null && !listData.isEmpty()) {
            tblData.setModel(new DataTableModel(listData));
        } else {
            tblData.setModel(new DataTableModel(new ArrayList<>()));
        }
    }

    private List<Double> listPrediksi = new ArrayList<>();

    private void predict() {
        DecimalFormat formatAngka = new DecimalFormat("##.###");

        RegresiEngine re = new RegresiEngine(listData);
        Double nilai = Double.parseDouble(txtNilai.getText());

        Double nilaiPrediksi = re.getKoefisienRegA() + re.getKoefisienRegB() * nilai;
        txtPrediksi.setText(String.valueOf(formatAngka.format(nilaiPrediksi)));

        for (int i = 0; i < listData.size(); i++) {
            Double prediksiValue = re.getKoefisienRegA() + re.getKoefisienRegB()
                    * listData.get(i).getSuhuRuangan();
            listPrediksi.add(prediksiValue);
        }
        if (listPrediksi != null && !listPrediksi.isEmpty()) {
            tblPrediksi.setModel(new PrediksTabelModel(listPrediksi));
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblPrediksi = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        btnPredict = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        txtNilai = new javax.swing.JTextField();
        txtPrediksi = new javax.swing.JTextField();
        txtRmse = new javax.swing.JTextField();
        txtMse = new javax.swing.JTextField();
        btnreset = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblData = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new java.awt.BorderLayout(5, 0));

        jPanel2.setBackground(new java.awt.Color(215, 245, 148));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 785, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, java.awt.BorderLayout.PAGE_START);

        tblPrediksi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Prediksi"
            }
        ));
        tblPrediksi.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane4.setViewportView(tblPrediksi);

        jPanel1.add(jScrollPane4, java.awt.BorderLayout.CENTER);

        jPanel3.setBackground(new java.awt.Color(199, 221, 223));
        jPanel3.setPreferredSize(new java.awt.Dimension(716, 150));

        btnPredict.setText("Prediksi");
        btnPredict.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPredictActionPerformed(evt);
            }
        });

        txtNilai.setPreferredSize(new java.awt.Dimension(200, 25));
        jPanel4.add(txtNilai);

        txtPrediksi.setPreferredSize(new java.awt.Dimension(200, 25));
        jPanel4.add(txtPrediksi);

        txtRmse.setPreferredSize(new java.awt.Dimension(200, 25));
        jPanel4.add(txtRmse);

        txtMse.setPreferredSize(new java.awt.Dimension(200, 25));
        jPanel4.add(txtMse);

        btnreset.setText("Reset");
        btnreset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnresetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnPredict, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                    .addComponent(btnreset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(471, Short.MAX_VALUE))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnPredict, btnreset});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnPredict, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnreset, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnPredict, btnreset});

        jPanel1.add(jPanel3, java.awt.BorderLayout.PAGE_END);

        tblData.setModel(new javax.swing.table.DefaultTableModel(
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
        tblData.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane1.setViewportView(tblData);

        jPanel1.add(jScrollPane1, java.awt.BorderLayout.LINE_START);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 785, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 497, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void clearData() {
        listData = new ArrayList<>();
        listPrediksi = new ArrayList<>();
        tblData.setModel(new DataTableModel(new ArrayList<>()));
        tblPrediksi.setModel(new PrediksTabelModel(new ArrayList<>()));
        //clear form
        //txtNilai.setText("");
        txtPrediksi.setText("");
        txtRmse.setText("");
        txtMse.setText("");
    }
    
    private void countError(){
        double rmse = (double) NumericEvaluation.calcRMSE(listData, listPrediksi);
        double mse = (double) NumericEvaluation.calcMSE(listData, listPrediksi);

        txtRmse.setText(String.valueOf(Math.round(rmse)));
        txtMse.setText(String.valueOf(Math.round(mse)));
    }
    

    private void btnPredictActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPredictActionPerformed
        // TODO add your handling code here:
        clearData();
        loadDataToTable();
        predict();
        countError();
    }//GEN-LAST:event_btnPredictActionPerformed

    private void btnresetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnresetActionPerformed
        // TODO add your handling code here:
        clearData();
        loadDataToTable();
    }//GEN-LAST:event_btnresetActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPredict;
    private javax.swing.JButton btnreset;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable tblData;
    private javax.swing.JTable tblPrediksi;
    private javax.swing.JTextField txtMse;
    private javax.swing.JTextField txtNilai;
    private javax.swing.JTextField txtPrediksi;
    private javax.swing.JTextField txtRmse;
    // End of variables declaration//GEN-END:variables

    private class DataTableModel extends AbstractTableModel {

        private List<Data> listData = new ArrayList<>();
        private final String[] header = {"id", "Value A", "Value B"};

        public DataTableModel(List<Data> listData) {
            this.listData = listData;
        }

        @Override
        public int getRowCount() {
            return listData.size();
        }

        @Override
        public int getColumnCount() {
            return header.length;
        }

        @Override
        public String getColumnName(int column) {
            return header[column];
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            Data d = listData.get(rowIndex);
            switch (columnIndex) {
                case 0:
                    return d.getTanggal();
                case 1:
                    return d.getJumlahCacat();
                case 2:
                    return d.getSuhuRuangan();
                default:
                    return new Data();
            }
        }
    }

    private class PrediksTabelModel extends AbstractTableModel {

        private List<Double> listPrediksi = new ArrayList<>();
        private DecimalFormat format = new DecimalFormat("##.###");

        public PrediksTabelModel(List<Double> listPrediksi) {
            this.listPrediksi = listPrediksi;
        }

        @Override
        public int getRowCount() {
            return listPrediksi.size();
        }

        @Override
        public int getColumnCount() {
            return 1;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            Double prediksi = listPrediksi.get(rowIndex);
            switch (columnIndex) {
                case 0:
                    return format.format(prediksi.doubleValue());
                default:
                    return 0.0;
            }
        }

    }

}
