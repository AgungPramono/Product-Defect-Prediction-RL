/*
 *  Main.java
 *  template-maven 
 * 
 *  Created by Agung Pramono on 08/08/2017 
 *  Copyright (c) 2017 Java Development. All rights reserved.
 */
package com.agung.prediksi;

import org.apache.commons.math3.random.RandomDataGenerator;

/**
 *
 * @author agung
 */
public class Main {
    public static void main(String[] args) {
        RandomDataGenerator generator = new RandomDataGenerator();
        Double chiSquare = generator.nextChiSquare(19.0);
        System.out.println(chiSquare);
        
        double nilai = Math.round(-0.5644171779141104);
        System.out.println(nilai);
        
        double a = 90.0;
        double b = 86.896;
        
        
    }
}

