/*
 *  DataDaoTest.java
 *  template-maven 
 * 
 *  Created by Agung Pramono on 08/08/2017 
 *  Copyright (c) 2017 Java Development. All rights reserved.
 */
package com.agung.prediksi.test;

import com.agung.prediksi.dao.DataDao;
import com.agung.prediksi.entity.Data;
import com.agung.prediksi.util.CSVReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author agung
 */
public class DataDaoTest extends BaseTest{

    private DataDao dd;
    
    //@Before
    public void loadDataFromCSV() throws FileNotFoundException{
        CSVReader read = new CSVReader(new File("src/main/resources/Data.csv"));
        dd = new DataDao();
        dd.setData(read.readFile());
    }

    @Test
    public void testGetAll() {
        List<Data> data = getDao().getAllData();
        Assert.assertFalse(data.isEmpty());
        Assert.assertEquals(20, data.size());
    }
    
    @Test
    public void testGetAllFromCsv() throws FileNotFoundException{
        List<Data> data = getDao().getAllData();
        for (Data d : data) {
            System.out.println(d.getJumlahCacat());
            
        }
        Assert.assertFalse(data.isEmpty());
        Assert.assertEquals(20, data.size());
    }

    @Test
    public void testFindById() {
        Data d1 = getDao().getDataById(0);
        System.out.println(d1.getSuhuRuangan());
    }
}
