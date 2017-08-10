/*
 *  Data.java
 *  template-maven 
 * 
 *  Created by Agung Pramono on 08/08/2017 
 *  Copyright (c) 2017 Java Development. All rights reserved.
 */

package com.agung.prediksi.entity;

/**
 *
 * @author agung
 */
public class Data {
    
    private Integer tanggal;
    private Double suhuRuangan;
    private Double jumlahCacat;

    public Integer getTanggal() {
        return tanggal;
    }

    public void setTanggal(Integer tanggal) {
        this.tanggal = tanggal;
    }

    public Double getSuhuRuangan() {
        return suhuRuangan;
    }

    public void setSuhuRuangan(Double suhuRuangan) {
        this.suhuRuangan = suhuRuangan;
    }

    public Double getJumlahCacat() {
        return jumlahCacat;
    }

    public void setJumlahCacat(Double jumlahCacat) {
        this.jumlahCacat = jumlahCacat;
    }
    
    
}
