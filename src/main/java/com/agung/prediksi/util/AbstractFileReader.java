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
 *  CSVReader.java
 *  Created on 26/06/2017 
 *  Copyright (c) 2017. All rights reserved.
 */

package com.agung.prediksi.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

/**
 *
 * @author agung
 * @param <T> class yang akan dikelola
 */
public abstract class AbstractFileReader<T> {
    
    public abstract List<T> readFile()throws FileNotFoundException;
    public abstract void fileImporter(File sourceFile)throws FileNotFoundException;

}
