package com.example.hastanedemo2;
import java.util.ArrayList;
import java.util.Scanner;

public class Hemsireler extends Calisanlar{
    private String Sifre;
    protected static ArrayList<Hemsireler> hemsireler=new ArrayList<>();

    public Hemsireler(String isim, String soyisim, long TC,String Sifre) {
        super(isim, soyisim, TC);
        this.Sifre=Sifre;
        hemsireler.add(this);
    }

    public static ArrayList<Hemsireler> getHemsireler() {
        return hemsireler;
    }

    public static void setHemsireler(ArrayList<Hemsireler> hemsireler) {
        Hemsireler.hemsireler = hemsireler;
    }

    public String getSifre() {
        return Sifre;
    }

    public void setSifre(String sifre) {
        Sifre = sifre;
    }

    public void BilgiGoster()
    {
        System.out.println("Hemsirenin isim : "+isim+" Hemsirenin soyismi : "+soyisim);
    }

    public void gunlukKotnrol(YatanHastalar yh1)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Tansiyon degerini giriniz : ");
        yh1.tansiyon=input.nextDouble();
        System.out.println("Kan sekeri degerini giriniz : ");
        yh1.tansiyon=input.nextDouble();

        if(100>yh1.tansiyon && yh1.tansiyon>75)
        {
            System.out.println("Tansiyon degeri normal.");
        }
        else
        {
            System.out.println("Tansiyon normal degil.");
        }


        if(140>yh1.kanSekeri && yh1.kanSekeri>70)
        {
            System.out.println("Kan sekeri degeri normal.");
        }
        else
        {
            System.out.println("Kan sekeri normal degil.");
        }
    }
}