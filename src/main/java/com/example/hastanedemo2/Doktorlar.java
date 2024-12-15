
package com.example.hastanedemo2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Doktorlar extends Calisanlar implements Islemler {
    public String alan;
    private String Sifre;
    protected static ArrayList<Doktorlar> doktorlar = new ArrayList();
    private List<String> uygunSaatler;
    private ArrayList<Hastalar> hastalari=new ArrayList<>();

    public Doktorlar(String isim, String soyisim, long TC, String Sifre, String alan) {
        super(isim, soyisim, TC);
        this.Sifre = Sifre;
        this.alan = alan;
        doktorlar.add(this);
        this.uygunSaatler = new ArrayList();

        for(int saat = 9; saat < 17; ++saat) {
            this.uygunSaatler.add("" + saat + ":00");
            this.uygunSaatler.add("" + saat + ":30");
        }

    }

    public List<String> getUygunSaatler() {
        return this.uygunSaatler;
    }

    public boolean randevuKontrol(String saat) {
        if (this.uygunSaatler.contains(saat)) {
            this.uygunSaatler.remove(saat);
            return true;
        } else {
            return false;
        }
    }

    public static ArrayList<Doktorlar> getDoktorlar() {
        return doktorlar;
    }

    public static void setDoktorlar(ArrayList<Doktorlar> doktorlar) {
        Doktorlar.doktorlar = doktorlar;
    }

    @Override
    public  ArrayList<Hastalar> getHastalari() {
        return hastalari;
    }
    public void HastaEkle(Hastalar h){
        this.hastalari.add(h);
    }

    public String getSifre() {
        return this.Sifre;
    }

    public void setSifre(String sifre) {
        this.Sifre = sifre;
    }

    public void BilgiGoster() {
        System.out.println("Doktorun isim : " + this.isim + " Doktorun soyismi : " + this.soyisim + "Doktorun alani : " + this.alan);
    }

    public void taburcuEt(YatanHastalar yh) throws TaburcuException {
        if (yh.yatmaDurumu) {
            yh.yatmaDurumu = false;
            this.hastalari.remove(yh);
        } else {
            throw new TaburcuException("Zaten Taburcu Edilmiş Bir Hasta Tekrar Taburcu Edilemez");
        }
    }

    public void ilacYaz(Hastalar h,String ilac) { //düzenle
        h.recete=ilac;
        System.out.println("Recete basariyla tanimlandi");
    }

    public void ilacYaz(Hastalar h, String ilac, String doz) {
        h.recete=ilac + " gunde " + doz + "kere kullanılmalı";
        System.out.println("Recete basariyla tanimlandi");
    }

    public void taniKoy(Hastalar h,String tani) {
        h.tani=tani;
        System.out.println("Hastalık teşhis edildi");
    }

    public String toString() {
        return "dr. " + this.isim + " " + this.soyisim + " " + this.alan;
    }
}

