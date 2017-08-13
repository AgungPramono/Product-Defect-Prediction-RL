/*
 *  Dataset.java
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
public class Dataset {

    public static List<Data> loadData(){
        List<Data> hasil = new ArrayList<>();
        
        Data d1 = new Data();
        d1.setTanggal(1);
        d1.setSuhuRuangan(24.0);
        d1.setJumlahCacat(10.0);
        hasil.add(d1);
        
        Data d2 = new Data();
        d2.setTanggal(2);
        d2.setSuhuRuangan(22.0);
        d2.setJumlahCacat(5.0);
        hasil.add(d2);
        
        Data d3 = new Data();
        d3.setTanggal(3);
        d3.setSuhuRuangan(21.0);
        d3.setJumlahCacat(6.0);
        hasil.add(d3);
        
        Data d4 = new Data();
        d4.setTanggal(4);
        d4.setSuhuRuangan(20.0);
        d4.setJumlahCacat(3.0);
        hasil.add(d4);
        
        Data d5 = new Data();
        d5.setTanggal(5);
        d5.setSuhuRuangan(22.0);
        d5.setJumlahCacat(6.0);
        hasil.add(d5);
        
        Data d6 = new Data();
        d6.setTanggal(6);
        d6.setSuhuRuangan(19.0);
        d6.setJumlahCacat(4.0);
        hasil.add(d6);
        
        Data d7 = new Data();
        d7.setTanggal(7);
        d7.setSuhuRuangan(20.0);
        d7.setJumlahCacat(5.0);
        hasil.add(d7);
        
        Data d8 = new Data();
        d8.setTanggal(8);
        d8.setSuhuRuangan(23.0);
        d8.setJumlahCacat(9.0);
        hasil.add(d8);
        
        Data d9 = new Data();
        d9.setTanggal(9);
        d9.setSuhuRuangan(24.0);
        d9.setJumlahCacat(11.0);
        hasil.add(d9);
        
        Data d10 = new Data();
        d10.setTanggal(10);
        d10.setSuhuRuangan(25.0);
        d10.setJumlahCacat(13.0);
        hasil.add(d10);
        
        Data d11 = new Data();
        d11.setTanggal(11);
        d11.setSuhuRuangan(28.0);
        d11.setJumlahCacat(15.0);
        hasil.add(d11);
        
        return hasil;
    }
}
