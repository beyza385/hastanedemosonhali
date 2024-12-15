package com.example.hastanedemo2;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.Parent;

import java.io.IOException;
import java.util.ArrayList;

public class KayitGirisEkrani {
    @FXML
    private TextField kayitTCEntry;
    @FXML
    private TextField kayitSifreEntry;

    @FXML
    private void onGirisYapBt3Click() {
        String tc = kayitTCEntry.getText();
        String sifre = kayitSifreEntry.getText();

        if ("1515".equals(tc) && "admin".equals(sifre)) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("kayitsecim.fxml"));
                Parent yeniSayfa = loader.load();

                Stage stage = new Stage();
                stage.setTitle("Kayit Seçim");
                stage.setScene(new Scene(yeniSayfa));
                stage.show();
            } catch (IOException e) {
                hataGoster(AlertType.ERROR, "Hata!", "Ekran Yükleme Hatası", "Kayıt seçim ekranı yüklenirken bir hata oluştu: " + e.getMessage());
            }
        } else {
            hataGoster(AlertType.ERROR, "Hata!", null, "Yönetici bilgileri yanlış.");
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
