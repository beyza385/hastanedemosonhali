package com.example.hastanedemo2;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class RandevuTaniEkrani {
    @FXML
    private TextField hastatcTf;
    @FXML
    private TextField ilacTf;
    @FXML
    private TextField dozTf;
    @FXML
    private TextField taniTf;
    @FXML
    private Button ReceteKayitBt;
    @FXML
    private Button TaniKayitBt;
    protected Doktorlar girisyapandoktor;
    Hastalar bulunanHasta = null;
    boolean found = false;
    private void hataGoster(Alert.AlertType type, String title, String header, String content) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }
    public void setDoktor(Doktorlar d) {
        this.girisyapandoktor = d;
    }
    public void hastakontrol(){
        String tcText = hastatcTf.getText();
        System.out.println("Girilen TC: " + tcText); // Debugging için

        Long hastaTc;
        try {
            hastaTc = Long.valueOf(tcText);
        } catch (NumberFormatException e) {
            hataGoster(Alert.AlertType.ERROR, "Hata!", "HATA!", "Geçersiz TC girişi, lütfen tekrar deneyin.");
            return;
        }
        ArrayList<Hastalar> hasta = girisyapandoktor.getHastalari();
        for (Hastalar h : hasta) {
            System.out.println(h.isim);
        }
        if (hasta.isEmpty()) {
            hataGoster(Alert.AlertType.ERROR, "Hata!", "HATA!", "Hasta listesi boş.");
            return;
        }
        for (Hastalar h : hasta) {
            System.out.println(h.getTC());
            if (h.getTC() == hastaTc.longValue()) {
                found = true;
                hataGoster(Alert.AlertType.INFORMATION, "Bilgi!", "Bilgi", "Hasta TC bulundu." + hastaTc);
                bulunanHasta = h;
            }
        }
    }


    @FXML
    protected void onReceteKayitBtClick() {
        hastakontrol();
        if(found){
            String ilac=ilacTf.getText();
            String doz=dozTf.getText();
            if(ilac!=null && doz==null){
                girisyapandoktor.ilacYaz(bulunanHasta,ilac);
            } else if (ilac!=null && doz!=null) {
                girisyapandoktor.ilacYaz(bulunanHasta,ilac,doz);
            }
        }
        else {
            hataGoster(Alert.AlertType.ERROR, "Hata!", "HATA!", "Hasta Bulunamdı");
        }
    }
    @FXML
    protected void onTaniKayitBtClick() {
        hastakontrol();
        if (found){
            String tani=taniTf.getText();
            if(tani!=null){
                girisyapandoktor.taniKoy(bulunanHasta,tani);
            }
        }

    }
}

