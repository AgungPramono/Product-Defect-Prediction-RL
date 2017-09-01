/*
 *  NumericEvaluation.java
 *  template-maven 
 * 
 *  Created by Agung Pramono on 10/08/2017 
 *  Copyright (c) 2017 Java Development. All rights reserved.
 */
package com.agung.prediksi.engine;

import com.agung.prediksi.entity.Data;
import java.util.List;

/**
 *
 * @author agung
 */
public class NumericEvaluation {

    public static double calcRMSE(List<Data> dataAktual, List<Double> dataPrediksi) {
        if (dataAktual.size() != dataPrediksi.size()) {
            throw new IllegalArgumentException(String.format("Jumlah Data tidak sama: %d != %d.",
                    dataAktual.size(), dataPrediksi.size()));
        }
        double rmse = 0.0;

        int n = dataAktual.size();

        for (int i = 0; i < n; i++) {
            rmse += Math.pow(dataPrediksi.get(i) - dataAktual.get(i).getJumlahCacat(), 2);
        }
        return (double) Math.sqrt(rmse / n);
    }

    public static double calcMSE(List<Data> dataAktual, List<Double> dataPrediksi) {
        if (dataAktual.size() != dataPrediksi.size()) {
            throw new IllegalArgumentException(String.format("Jumlah Data tidak sama: %d != %d.",
                    dataAktual.size(), dataPrediksi.size()));
        }

        double mse = 0.0;
        int n = dataAktual.size();
        for (int i = 0; i < dataAktual.size(); i++) {
            mse += Math.pow(dataPrediksi.get(i) - dataAktual.get(i).getJumlahCacat(), 2);
        }

        return (double) mse / n;
    }
}
