package com.example.hastanedemo2;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import java.io.IOException;

public class PersonelGirisEkrani {
    @FXML
    private Button doktorBt;

    @FXML
    private Label PersonelGirisLable;

    @FXML
    protected void onDoktorBtClick() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("doktorgiris.fxml"));
            Pane root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Doktor Giriş Ekranı");
            stage.setScene(new Scene(root, 450, 400));
            stage.show();
        } catch (IOException e) {
            hataGoster(AlertType.ERROR, "Hata!", "Ekran Yükleme Hatası", "Doktor Giriş ekranı yüklenirken bir hata oluştu: " + e.getMessage());
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


