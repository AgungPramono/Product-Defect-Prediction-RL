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
    
    public void setDataset(List<Data> listData){
        this.data  = listData;
    }
    
    public void setData(List<Data> data){
        this.data = data;
    }
    
    public List<Data> getAllData(){
       return this.data;
    }
    
    public Data getDataById(int index){
        return this.data.get(index);
    }

}
