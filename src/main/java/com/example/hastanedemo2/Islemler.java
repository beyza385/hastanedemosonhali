package com.example.hastanedemo2;
public interface Islemler {
    public void ilacYaz(Hastalar h,String ilac);
    public void taniKoy(Hastalar h,String tani);
    public void taburcuEt(YatanHastalar yh) throws TaburcuException;

}