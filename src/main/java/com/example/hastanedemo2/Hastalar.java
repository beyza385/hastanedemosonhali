
package com.example.hastanedemo2;

import java.util.ArrayList;

public class Hastalar {
    String isim;
    String soyisim;
    private long TC;
    String tani;
    String recete;
    Doktorlar doktor;
    private int hastaNo = 0;
    public String randevu;
    protected static ArrayList<Hastalar> hastalar = new ArrayList();

    public Hastalar(String isim, String soyisim, long TC) {
        this.isim = isim;
        this.soyisim = soyisim;
        this.TC = TC;
        ++this.hastaNo;
        hastalar.add(this);
    }

    public static ArrayList<Hastalar> getHastalar() {
        return hastalar;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public String getSoyisim() {
        return soyisim;
    }

    public void setSoyisim(String soyisim) {
        this.soyisim = soyisim;
    }

    public String getRandevu() {
        return randevu;
    }

    public void setRandevu(String randevu) {
        this.randevu = randevu;
    }

    public Long getTC() {
        return this.TC;
    }

    public static void setHastalar(ArrayList<Hastalar> hastalar) {
        Hastalar.hastalar = hastalar;
    }

    public int getHastaNo() {
        return this.hastaNo;
    }

    public void setRecete(String recete) {
        this.recete = recete;
    }

    public void setTani(String tani) {
        this.tani = tani;
    }

    public void receteGoruntule() {
        System.out.println(this.recete);
    }

    public void taniGoruntule() {
        System.out.println(this.tani);
    }
}
