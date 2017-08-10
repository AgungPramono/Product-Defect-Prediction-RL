/*
 *  Main.java
 *  template-maven 
 * 
 *  Created by Agung Pramono on 08/08/2017 
 *  Copyright (c) 2017 Java Development. All rights reserved.
 */

package com.agung.prediksi;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

/**
 *
 * @author agung
 */
public class Main {
    public static void main(String[]args){
        List<Integer> hasil = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            hasil.add(i);
        }
        
        //sebelum java 5
        Iterator<Integer> iterator = hasil.iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            System.out.println(next);
        }
        
        //sejak java 5
        hasil.forEach(System.out::println);
    }

}
