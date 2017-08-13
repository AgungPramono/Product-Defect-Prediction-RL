/*
 *  RegresiEngine.java
 *  template-maven 
 * 
 *  Created by Agung Pramono on 08/08/2017 
 *  Copyright (c) 2017 Java Development. All rights reserved.
 */
package com.agung.prediksi.engine;

import com.agung.prediksi.dao.DataDao;
import com.agung.prediksi.entity.Data;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author agung
 */
public class RegresiEngine {

    private List<Data> data = new ArrayList<>();
    private final DataDao dataDao = new DataDao();

    public RegresiEngine() {
        data = dataDao.getAllData();
    }

    public Double getTotalSuhu() {
        Double jumlah = 0.0;
        for (int i = 0; i < data.size(); i++) {
            jumlah += data.get(i).getSuhuRuangan();
        }
        return jumlah;
    }

    public Double getCacatProduk() {
        Double jumlah = 0.0;
        for (int i = 0; i < data.size(); i++) {
            jumlah += data.get(i).getJumlahCacat();
        }
        return jumlah;
    }
    List<Double> variabelX;

    private void hitungX() {
        variabelX = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            Data dx = dataDao.getDataById(i);
            Double x = Math.pow(dx.getSuhuRuangan(), 2);
            variabelX.add(x);
        }
    }

    private Double getJumlahVarX() {
        hitungX();
        Double jumlahVarX = 0.0;
        for (int i = 0; i < data.size(); i++) {
            jumlahVarX += variabelX.get(i);
        }
        return jumlahVarX;
    }

    private List<Double> variabelY;

    private void hitungY() {
        variabelY = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            Data dx = dataDao.getDataById(i);
            Double x = Math.pow(dx.getJumlahCacat(), 2);
            variabelY.add(x);
        }
    }

    private Double getJumlahVarY() {
        hitungY();
        Double jumlahVarY = 0.0;
        for (int i = 0; i < data.size(); i++) {
            jumlahVarY += variabelY.get(i);
        }
        return jumlahVarY;
    }

    private List<Double> variabelXY;

    private void hitungXY() {
        variabelXY = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            Double jumlahXY = data.get(i).getSuhuRuangan() * data.get(i).getJumlahCacat();
            variabelXY.add(jumlahXY);
        }
    }

    private Double getJumlahVarXY() {
        hitungXY();
        Double jumlahVarXY = 0.0;
        for (int i = 0; i < data.size(); i++) {
            jumlahVarXY += variabelXY.get(i);
        }
        return jumlahVarXY;
    }

    public Double getKoefisienRegA() {
        Double a = (((getCacatProduk()) * (getJumlahVarX())) 
                - ((getTotalSuhu()) * (getJumlahVarXY())))
                / ((data.size() * (getJumlahVarX())) - (Math.pow(getTotalSuhu(), 2)));
        return a;
    }
    
    public Double getKoefisienRegB(){
        Double b = ((data.size() * (getJumlahVarXY())) - ((getTotalSuhu()) * (getCacatProduk()))) 
                / ((data.size() * (getJumlahVarX())) - (Math.pow(getTotalSuhu(), 2)));
        return b;
    }
}
