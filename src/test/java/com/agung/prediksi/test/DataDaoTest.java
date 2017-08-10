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
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author agung
 */
public class DataDaoTest {

    private final DataDao dd = new DataDao();

    @Test
    public void testGetAll() {
        List<Data> data = dd.getAllData();
        Assert.assertFalse(data.isEmpty());
        Assert.assertEquals(10, data.size());
    }

    @Test
    public void testFindById() {
        Data d1 = dd.getDataById(0);
        System.out.println(d1.getSuhuRuangan());
    }
}
