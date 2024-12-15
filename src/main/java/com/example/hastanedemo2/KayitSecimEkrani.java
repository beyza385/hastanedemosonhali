package com.example.hastanedemo2;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

import java.io.IOException;

public class KayitSecimEkrani {

    @FXML
    private void onPersonelBtClick() {
        try {
            // Yeni bir sayfa aç
            FXMLLoader loader = new FXMLLoader(getClass().getResource("personelkayitekrani.fxml"));
            Parent yeniSayfa = loader.load();

            // Yeni bir pencere (Stage) oluştur
            Stage stage = new Stage();
            stage.setTitle("Personel Kayit");
            stage.setScene(new Scene(yeniSayfa));
            stage.show();
        } catch (IOException e) {
            hataGoster(AlertType.ERROR, "Hata!", "Ekran Yükleme Hatası", "Personel Kayıt ekranı yüklenirken bir hata oluştu: " + e.getMessage());
        }
    }

    @FXML
    private void onHastaBtClick() {
        try {
            // Yeni bir sayfa aç
            FXMLLoader loader = new FXMLLoader(getClass().getResource("hastakayitekrani.fxml"));
            Parent yeniSayfa = loader.load();

            // Yeni bir pencere (Stage) oluştur
            Stage stage = new Stage();
            stage.setTitle("Hasta Kayit");
            stage.setScene(new Scene(yeniSayfa));
            stage.show();
        } catch (IOException e) {
            hataGoster(AlertType.ERROR, "Hata!", "Ekran Yükleme Hatası", "Hasta Kayıt ekranı yüklenirken bir hata oluştu: " + e.getMessage());
        }
    }

    private void hataGoster(AlertType type, String title, String header, String content) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }
}