
package com.example.hastanedemo2;

import java.util.ArrayList;
import java.util.Iterator;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        ArrayList<Hastalar> hasta = Hastalar.getHastalar();
        Iterator var2 = hasta.iterator();

        while(var2.hasNext()) {
            Hastalar h = (Hastalar)var2.next();
            System.out.println(h.isim);
        }

    }
}
