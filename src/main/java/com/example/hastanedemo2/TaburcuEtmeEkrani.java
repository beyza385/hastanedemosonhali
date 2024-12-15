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

public class TaburcuEtmeEkrani {
    @FXML
    private TextField hastaTcTf;
    @FXML
    private Button TaburcuEtBt;
    protected Doktorlar girisyapandoktor;
    Hastalar bulunanHasta;
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


        @FXML
        protected void onTaburcuEtBtClick() throws TaburcuException{
            String tcText = hastaTcTf.getText();
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
                    break;
                }
            }
            if(found){
                if(bulunanHasta instanceof YatanHastalar){
                    girisyapandoktor.taburcuEt((YatanHastalar) bulunanHasta);
                }
                else{
                    hataGoster(Alert.AlertType.ERROR,"Hata!","HATA!","Hasta zaten taburcu edilmiş");
                }
            }
            else {
                hataGoster(Alert.AlertType.ERROR, "Hata!", "HATA!", "Hasta Bulunamdı");
            }
        }}



