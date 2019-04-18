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
import org.apache.commons.math3.util.FastMath;

/**
 *
 * @author agung
 */
public class RegresiEngine {

    private List<Data> listData = new ArrayList<>();
    private DataDao dataDao;

    public RegresiEngine(List<Data> listDatas) {
      this.listData = listDatas;
    }

    public Double getTotalSuhu() {
        Double jumlah = 0.0;
        for (int i = 0; i < listData.size(); i++) {
            jumlah += listData.get(i).getSuhuRuangan();
        }
        return jumlah;
    }

    public Double getTotalCacatProduk() {
        Double jumlah = 0.0;
        for (int i = 0; i < listData.size(); i++) {
            jumlah += listData.get(i).getJumlahCacat();
        }
        return jumlah;
    }

    private List<Double> listDataX = new ArrayList<>();

    private void countX() {
        for (int i = 0; i < listData.size(); i++) {
            Data dx = listData.get(i);
            Double x = Math.pow(dx.getSuhuRuangan(), 2);
            listDataX.add(x);
        }
    }

    private Double getTotalX() {
        countX();
        Double jumlahVarX = 0.0;
        for (int i = 0; i < listData.size(); i++) {
            jumlahVarX += listDataX.get(i);
        }
        return jumlahVarX;
    }

    private List<Double> listDataY = new ArrayList<>();

    private void countY() {
        for (int i = 0; i < listData.size(); i++) {
            Data dx = listData.get(i);
            Double x = Math.pow(dx.getJumlahCacat(), 2);
            listDataY.add(x);
        }
    }

    private Double getTotalY() {
        countY();
        Double jumlahVarY = 0.0;
        for (int i = 0; i < listData.size(); i++) {
            jumlahVarY += listDataY.get(i);
        }
        return jumlahVarY;
    }

    private List<Double> listDataXY = new ArrayList<>();

    private void countXY() {
        for (int i = 0; i < listData.size(); i++) {
            Double jumlahXY = listData.get(i).getSuhuRuangan() * listData.get(i).getJumlahCacat();
            listDataXY.add(jumlahXY);
        }
    }

    private Double getTotalXY() {
        countXY();
        Double jumlahVarXY = 0.0;
        for (int i = 0; i < listData.size(); i++) {
            jumlahVarXY += listDataXY.get(i);
        }
        return jumlahVarXY;
    }

    public Double getKoefisienRegA() {
        Double a = (double) (((getTotalCacatProduk()) * (getTotalX()))
                - ((getTotalSuhu()) * (getTotalXY())))
                / ((listData.size() * (getTotalX())) - (FastMath.pow(getTotalSuhu(), 2)));
        return a;
    }

    public Double getKoefisienRegB() {
        Double b = (double) ((listData.size() * (getTotalXY()))
                - ((getTotalSuhu()) * (getTotalCacatProduk())))
                / ((listData.size() * (getTotalX())) - (FastMath.pow(getTotalSuhu(), 2)));
        return b;
    }
}
