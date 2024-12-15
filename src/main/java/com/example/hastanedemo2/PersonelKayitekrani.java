package com.example.hastanedemo2;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import java.util.ArrayList;


public class PersonelKayitekrani {


    @FXML
    private TextField isimEntryDoktor;

    @FXML
    private TextField soyisimEntryDoktor;

    @FXML
    private TextField TCEntryDoktor;

    @FXML
    private TextField alanEntryDoktor;

    @FXML
    private TextField silTCEntryDoktor;



    @FXML
    private TextField EntryDoktorSifre;


    @FXML
    private Button DoktorEkleBt;

    @FXML
    private Button DoktorSilBt;

    @FXML
    private Button doktorListeleBt;


    // Doktor eklemek icin
    @FXML
    private void DoktorEkleBt() {
        try {
            String isim = isimEntryDoktor.getText();
            String soyisim = soyisimEntryDoktor.getText();
            long TC = Long.parseLong(TCEntryDoktor.getText());
            String alan = alanEntryDoktor.getText();
            String sifre = EntryDoktorSifre.getText();

            Doktorlar yeniDoktor = new Doktorlar(isim, soyisim, TC, sifre, alan);
            hataGoster(AlertType.INFORMATION, "Doktor Kayıt", "Doktor başarıyla eklendi!", "Doktor: " + isim + " " + soyisim + ", Alan: " + alan);
            temizleDoktorAlani();
        } catch (NumberFormatException e) {
            hataGoster(AlertType.ERROR, "Hata", "Geçersiz TC", "Lütfen TC alanına sadece sayı giriniz.");
        }
    }

    // Doktor silmek icin
    @FXML
    private void DoktorSilBt() {
        try {
            long TC = Long.parseLong(silTCEntryDoktor.getText());
            boolean bulundu = false;
            for (int i = 0; i < Doktorlar.getDoktorlar().size(); i++) {
                if (Doktorlar.getDoktorlar().get(i).getTC() == TC) {
                    Doktorlar.getDoktorlar().remove(i);
                    bulundu = true;
                    hataGoster(AlertType.INFORMATION, "Doktor Silme", "Doktor başarıyla silindi!", "TC: " + TC);
                    break;
                }
            }
            if (!bulundu) {
                hataGoster(AlertType.ERROR, "Hata", "Doktor bulunamadı", "Bu TC ile kayıtlı doktor yok.");
            }
            silTCEntryDoktor.clear();
        } catch (NumberFormatException e) {
            hataGoster(AlertType.ERROR, "Hata", "Geçersiz TC", "Lütfen TC alanına sadece sayı giriniz.");
        }
    }

    // Doktorları listelemek icin
    @FXML
    private void DoktorListeleBt() {
        String liste = "Kayıtlı Doktorlar:\n";
        for (Doktorlar d : Doktorlar.getDoktorlar()) {
            liste += "Isim: " + d.isim + " " + d.soyisim + ", TC: " + d.getTC() + ", Alan: " + d.alan + "\n";
        }
        hataGoster(AlertType.INFORMATION, "Doktor Listesi", "Doktorlar", liste);
    }

    // Hemşire eklemek icin




    // Uyarı mesajları gösteren yardımcı metod
    private void hataGoster(AlertType type, String title, String header, String content) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }

    // TextField'ları temizleyen metodlar
    private void temizleDoktorAlani() {
        isimEntryDoktor.clear();
        soyisimEntryDoktor.clear();
        TCEntryDoktor.clear();
        alanEntryDoktor.clear();
    }

}