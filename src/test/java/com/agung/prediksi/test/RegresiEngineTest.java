/*
 *  RegresiEngineTest.java
 *  template-maven 
 * 
 *  Created by Agung Pramono on 08/08/2017 
 *  Copyright (c) 2017 Java Development. All rights reserved.
 */
package com.agung.prediksi.test;

import com.agung.prediksi.dao.DataDao;
import com.agung.prediksi.engine.NumericEvaluation;
import com.agung.prediksi.engine.RegresiEngine;
import com.agung.prediksi.entity.Data;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

/**
 *
 * @author agung
 */
public class RegresiEngineTest {

    private final RegresiEngine regEngine = new RegresiEngine();

    //@Test
    public void testJumlahSuhu() {
        Double jumlahSuhu = regEngine.getTotalSuhu();
        System.out.println("Jumlah Suhu : " + jumlahSuhu);
    }

    //@Test
    public void testJumlahCacat() {
        Double jumlahCacat = regEngine.getCacatProduk();
        System.out.println("Jumlah Cacat = " + jumlahCacat);
    }

    @Test
    public void testHitungKoefisienRegA() {
        Double regA = regEngine.getKoefisienRegA();
        System.out.println("Koefisien Reg A = " + regA);
    }

    //@Test
    public void hitung() {
        Double nilai = ((8 * (17416)) - ((413) * (292))) / ((8 * (25189))
                - (Math.pow(413, 2)));

        System.out.println("Nilai = " + nilai);
        System.out.println("Nilai : " + nilai);
    }

    @Test
    public void testHitungKoefisienRegB() {
        Double regB = regEngine.getKoefisienRegB();
        System.out.println("Koefisien Reg B = " + regB);
    }

    @Test
    public void testPrediksiJumlahCacatProduk() {
        Double suhu = 25.0;

        Double jumlahCacat = regEngine.getKoefisienRegA()
                + regEngine.getKoefisienRegB() * suhu;

        System.out.println("");
        System.out.println("Jadi dengan suhu = " + suhu + " derajat celcius");
        System.out.println("Diprediksikan terjadi cacat produk sebanyak = "
                + Math.round(jumlahCacat) + " item\n");
    }

    @Test
    public void prediksiCacatProdukbyDataAktual() {
        DataDao dtDao = new DataDao();

        DecimalFormat format = new DecimalFormat("##.###");

        List<Double> dataPrediksi = new ArrayList<>();

        List<Data> dataAktual = dtDao.getAllData();

        for (int i = 0; i < dataAktual.size(); i++) {
            Double jmlCacat = regEngine.getKoefisienRegA() + regEngine.getKoefisienRegB()
                    * dataAktual.get(i).getSuhuRuangan();

            System.out.println("");
            System.out.println("Jumlah Cacat aktual = " + dataAktual.get(i).getJumlahCacat());
            System.out.println("Jumlah Cacat Prediksi = " + format.format(jmlCacat) + "\n");

            dataPrediksi.add(jmlCacat);
        }

        //test tingkat error dengan RMSE dan MSE
        Double rmse = NumericEvaluation.calcRMSE(dataAktual, dataPrediksi);
        Double mse = NumericEvaluation.calcMSE(dataAktual, dataPrediksi);
        System.out.println("Dengan Nilai RMSE = " + format.format(rmse / 100) + " %");
        System.out.println("Dengan Nilai MSE  = " + format.format(mse / 100) + " %");
    }
}
