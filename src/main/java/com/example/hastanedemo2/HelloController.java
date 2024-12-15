package com.example.hastanedemo2;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import java.io.IOException;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHastaBtClick() {
        try {
            Pane root = new FXMLLoader(getClass().getResource("HastaGirisEkrani.fxml")).load();
            Stage stage = new Stage();
            stage.setTitle("Hasta Girişi");
            stage.setScene(new Scene(root, 300, 300));
            stage.show();
        } catch (IOException e) {
            hataGoster(AlertType.ERROR, "Hata!", "Ekran Yükleme Hatası", "Hasta Giriş ekranı yüklenirken bir hata oluştu: " + e.getMessage());
        }
    }

    @FXML
    protected void DoktorBtClick(){
        try {
            Pane root = new FXMLLoader(getClass().getResource("doktorgiris.fxml")).load();
            Stage stage = new Stage();
            stage.setTitle("Personel Girişi");
            stage.setScene(new Scene(root, 400, 400));
            stage.show();
        } catch (IOException e) {
            hataGoster(AlertType.ERROR, "Hata!", "Ekran Yükleme Hatası", "Doktor Giriş ekranı yüklenirken bir hata oluştu: " + e.getMessage());
        }
    }

    @FXML
    protected void onKayitBtClick(){
        try {
            Pane root = new FXMLLoader(getClass().getResource("kayitgiris.fxml")).load();
            Stage stage = new Stage();
            stage.setTitle("Kayit Girişi");
            stage.setScene(new Scene(root, 450, 350));
            stage.show();
        } catch (IOException e) {
            hataGoster(AlertType.ERROR, "Hata!", "Ekran Yükleme Hatası", "Kayıt Giriş ekranı yüklenirken bir hata oluştu: " + e.getMessage());
        }
    }

    private void hataGoster(AlertType type, String title, String header, String content) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }}