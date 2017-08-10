/*
 *  DataDao.java
 *  template-maven 
 * 
 *  Created by Agung Pramono on 08/08/2017 
 *  Copyright (c) 2017 Java Development. All rights reserved.
 */

package com.agung.prediksi.dao;

import com.agung.prediksi.entity.Data;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author agung
 */
public class DataDao {
    private List<Data> data = new ArrayList<>();
    
    public DataDao(){
        data = Dataset.loadData();
    }
    
    public List<Data> getAllData(){
       return data;
    }
    
    public Data getDataById(int index){
        return data.get(index);
    }

}
