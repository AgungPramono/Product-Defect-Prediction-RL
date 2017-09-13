/*
 *  Main.java
 *  template-maven 
 * 
 *  Created by Agung Pramono on 08/08/2017 
 *  Copyright (c) 2017 Java Development. All rights reserved.
 */
package com.agung.prediksi;

import com.agung.prediksi.dao.DataDao;
import com.agung.prediksi.ui.FormPrediksi;
import com.agung.prediksi.util.CSVReader;
import java.io.File;
import java.io.FileNotFoundException;
import javax.swing.SwingUtilities;

/**
 *
 * @author agung
 */
public class Main {

    private static DataDao dao;

    public static DataDao getDao() {
        return dao;
    }

    private static void setSourceFileData() throws FileNotFoundException {
        dao = new DataDao();
        CSVReader read = new CSVReader(new File("src/main/resources/data_nilai.csv"));
        dao.setData(read.readFile());
    }

    public static void main(String[] args) throws FileNotFoundException {
        setSourceFileData();
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FormPrediksi().setVisible(true);
            }
        }
        );

//            RandomDataGenerator generator = new RandomDataGenerator();
//            Double chiSquare = generator.nextChiSquare(19.0);
//            System.out.println(chiSquare);
//
//            double nilai = Math.round(-0.5644171779141104);
//            System.out.println(nilai);
//
//            double a = 90.0;
//            double b = 86.896;
    }
}
