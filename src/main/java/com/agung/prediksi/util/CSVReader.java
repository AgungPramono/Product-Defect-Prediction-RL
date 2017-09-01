/*
 *  DO NOT REMOVE THIS LICENSE
 *  
 *  This source code is created by Agung Pramono
 *  You can use and modify this source code freely but
 *  you are forbidden to change or remove this license.
 * 
 *   o Project Name  : Aplikasi-Prediksi-Stok 
 *   o Author        : Agung
 *   o Email         : agungpermadi13@gmail.com
 *   o Github        : https://github.com/agungpramono
 * 
 *  CSVReaderImpl.java
 *  Created on 26/06/2017 
 *  Copyright (c) 2017. All rights reserved.
 */
package com.agung.prediksi.util;

import com.agung.prediksi.entity.Data;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.LoggerFactory;

/**
 *
 * @author agung
 */
public class CSVReader extends AbstractFileReader<Data> {

    private final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(CSVReader.class);

    private final File sourceFile;

    public CSVReader(File sourceFile) {
        this.sourceFile = sourceFile;
    }

    @Override
    public List<Data> readFile() throws FileNotFoundException {
        try {
            List<Data> result = new ArrayList<>();

            BufferedReader bufferedReader;
            try (FileReader fileReader = new FileReader(sourceFile)) {

                bufferedReader = new BufferedReader(fileReader);
                String data = bufferedReader.readLine();//header ignore

                while ((data = bufferedReader.readLine()) != null) {
                    String[] element = data.split(",");
                    result.add(trainingArrayToObject(element));
                }
                fileReader.close();
            }
            bufferedReader.close();
            return result;
        } catch (IOException ex) {
            LOGGER.error(ex.getMessage());
        }
        return null;
    }

    private Data trainingArrayToObject(String[] element) {
        Data data = new Data();
        
        data.setTanggal(Integer.parseInt(element[0]));
        data.setSuhuRuangan(Double.parseDouble(element[1]));
        data.setJumlahCacat(Double.parseDouble(element[2]));
        
        return data;
    }

    @Override
    public void fileImporter(File sourceFile) throws FileNotFoundException {
    }
}
