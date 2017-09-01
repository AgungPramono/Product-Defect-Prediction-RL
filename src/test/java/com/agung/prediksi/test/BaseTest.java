/*
 *  BaseTest.java
 *  Prediksi-Cacat-Produk 
 * 
 *  Created by Agung Pramono on 01/09/2017 
 *  Copyright (c) 2017 Java Development. All rights reserved.
 */
package com.agung.prediksi.test;

import com.agung.prediksi.dao.DataDao;
import com.agung.prediksi.util.CSVReader;
import java.io.File;
import java.io.FileNotFoundException;
import org.junit.BeforeClass;

/**
 *
 * @author agung
 */
public class BaseTest {

    private static DataDao dao;

    @BeforeClass
    public static void initData() throws FileNotFoundException {
        dao = new DataDao();
        CSVReader read = new CSVReader(new File("src/main/resources/data_nilai.csv"));
        dao.setData(read.readFile());
    }

    public DataDao getDao() {
        return dao;
    }
}
