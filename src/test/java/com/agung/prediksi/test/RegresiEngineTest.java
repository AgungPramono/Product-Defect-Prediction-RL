/*
 *  RegresiEngineTest.java
 *  template-maven 
 * 
 *  Created by Agung Pramono on 08/08/2017 
 *  Copyright (c) 2017 Java Development. All rights reserved.
 */
package com.agung.prediksi.test;

import com.agung.prediksi.engine.NumericEvaluation;
import com.agung.prediksi.engine.RegresiEngine;
import com.agung.prediksi.entity.Data;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.math3.util.FastMath;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author agung
 */
public class RegresiEngineTest extends BaseTest {

    private RegresiEngine regEngine;
    private DecimalFormat format = new DecimalFormat("##.##");
    private static final Logger logger = LoggerFactory.getLogger(RegresiEngineTest.class);

    @Before
    public void initialize() {
        List<Data> listData = getDao().getAllData();
        regEngine = new RegresiEngine(listData);
    }

    @Test
    public void testJumlahSuhu() {
        Double jumlahSuhu = regEngine.getTotalSuhu();
        System.out.println("Jumlah Suhu : " + jumlahSuhu);
    }

    @Test
    public void testJumlahCacat() {
        Double jumlahCacat = regEngine.getTotalCacatProduk();
        logger.info("Jumlah Cacat = {}", jumlahCacat);
    }

    @Test
    public void testHitungKoefisienRegA() {
        Double regA = regEngine.getKoefisienRegA();
        logger.info("Koefisien Reg A = {}", regA);
    }

    @Test
    public void hitung() {
        Double nilai = ((8 * (17416)) - ((413) * (292))) / ((8 * (25189))
                - (Math.pow(413, 2)));

        logger.info("Nilai = {}", nilai);
        logger.info("Nilai : ", nilai);
    }

    @Test
    public void testHitungKoefisienRegB() {
        Double regB = regEngine.getKoefisienRegB();
        logger.info("Koefisien Reg B = {}", regB);
    }

    @Test
    public void testPrediksiJumlahCacatProduk() {
        Double suhu = 90.0;

        Double jumlahCacat = regEngine.getKoefisienRegA()
                + regEngine.getKoefisienRegB() * suhu;

        System.out.println("");
        logger.info("Jadi dengan suhu = {} derajat celcius", suhu);
        logger.info("Diprediksikan terjadi cacat produk sebanyak = {} item\n",
                 FastMath.round(jumlahCacat));
    }

    @Test
    public void prediksiCacatProdukbyDataAktual() {
        List<Double> dataPrediksi = new ArrayList<>();

        List<Data> dataAktual = getDao().getAllData();

        for (int i = 0; i < dataAktual.size(); i++) {
            Double jmlCacat = regEngine.getKoefisienRegA() + regEngine.getKoefisienRegB()
                    * dataAktual.get(i).getSuhuRuangan();

            System.out.println("");
            logger.info("Jumlah Cacat aktual = {}", dataAktual.get(i).getJumlahCacat());
            logger.info("Jumlah Cacat Prediksi = {} \n", format.format(jmlCacat));

            dataPrediksi.add(jmlCacat);
        }

        //test tingkat error dengan RMSE dan MSE
        Double rmse = NumericEvaluation.calcRMSE(dataAktual, dataPrediksi);
        Double mse = NumericEvaluation.calcMSE(dataAktual, dataPrediksi);
        logger.info("Dengan Nilai RMSE = {} %", format.format(rmse / 100));
        logger.info("Dengan Nilai MSE  = {} %", format.format(mse / 100));
        System.out.println("\n");
    }
}
