package com.example.hastanedemo2;
import java.util.ArrayList;

public abstract class Calisanlar {
    public String isim,soyisim;
    private long TC;
    protected ArrayList<Hastalar> hastalari=new ArrayList<>();

    public Calisanlar(String isim, String soyisim, long TC) {
        this.isim = isim;
        this.soyisim = soyisim;
        this.TC = TC;
    }

    public long getTC() {

        return TC;
    }

    public void setTC(int TC) {
        this.TC = TC;
    }

    public ArrayList<Hastalar> getHastalari() {
        return hastalari;
    }

    public void setHastalari(ArrayList<Hastalar> hastalari) {
        this.hastalari = hastalari;
    }

    public abstract void BilgiGoster();







}
