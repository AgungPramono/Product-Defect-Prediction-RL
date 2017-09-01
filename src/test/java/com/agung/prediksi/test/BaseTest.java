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
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.BeforeClass;

/**
 *
 * @author agung
 */
public class BaseTest {
    
    private static DataDao dao;
    
    @BeforeClass
    public static void initData(){
        dao = new DataDao();
        CSVReader read = new CSVReader(new File("src/main/resources/data_nilai.csv"));
        try {
            dao.setData(read.readFile());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(BaseTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public DataDao getDao(){
        return dao;
    }
}
