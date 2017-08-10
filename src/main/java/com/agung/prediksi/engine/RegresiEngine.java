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

    public double jumlahSuhu() {
        double jumlah = 0.0;
        for (int i = 0; i < data.size(); i++) {
            jumlah += data.get(i).getSuhuRuangan();
        }
        return jumlah;
    }

    public double jumlahCacatProduk() {
        double jumlah = 0.0;
        for (int i = 0; i < data.size(); i++) {
            jumlah += data.get(i).getJumlahCacat();
        }
        return jumlah;
    }
    List<Double> variabelX;

    private void getX() {
        variabelX = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            Data dx = dataDao.getDataById(i);
            double x = Math.pow(dx.getSuhuRuangan(), 2);
            variabelX.add(x);
        }
    }

    public double getJumlahVarX() {
        getX();
        double jumlahVarX = 0.0;
        for (int i = 0; i < data.size(); i++) {
            jumlahVarX += variabelX.get(i);
        }
        return jumlahVarX;
    }

    private List<Double> variabelY;

    private void getY() {
        variabelY = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            Data dx = dataDao.getDataById(i);
            double x = Math.pow(dx.getJumlahCacat(), 2);
            variabelY.add(x);
        }
    }

    public double getJumlahVarY() {
        getY();
        double jumlahVarY = 0.0;
        for (int i = 0; i < data.size(); i++) {
            jumlahVarY += variabelY.get(i);
        }
        return jumlahVarY;
    }

    private List<Double> variabelXY;

    public List<Double> getXY() {
        variabelXY = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            double jumlahXY = data.get(i).getSuhuRuangan() * data.get(i).getJumlahCacat();
            variabelXY.add(jumlahXY);
        }
        return variabelXY;
    }

    public double getJumlahVarXY() {
        getXY();
        double jumlahVarXY = 0.0;
        for (int i = 0; i < data.size(); i++) {
            jumlahVarXY += variabelXY.get(i);
        }
        return jumlahVarXY;
    }

    public double getKoefisienRegA() {
        double a = (((jumlahCacatProduk()) * (getJumlahVarX())) 
                - ((jumlahSuhu()) * (getJumlahVarXY())))
                / ((data.size() * (getJumlahVarX())) - (Math.pow(jumlahSuhu(), 2)));
        return a;
    }
    
    public double getKoefisienRegB(){
        double b = ((data.size() * (getJumlahVarXY())) - ((jumlahSuhu()) * (jumlahCacatProduk()))) 
                / ((data.size() * (getJumlahVarX())) - (Math.pow(jumlahSuhu(), 2)));
        return b;
    }
}
