package com.example.hastanedemo2;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import java.io.IOException;
import java.util.ArrayList;

public class HastaGirisEkrani {
    @FXML
    private TextField HastaTCEntry;

    @FXML
    private Button HastaGirişYapBt;

    @FXML
    private Label HastaGirisLable;

    // Hata mesajını göstermek için ortak bir metod
    private void hataGoster(AlertType type, String title, String header, String content) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }

    @FXML
    protected void onGirisYapClick() {
        String tcText = HastaTCEntry.getText();
        System.out.println("Girilen TC: " + tcText); // Debugging için

        Long hastaTc;
        boolean found = false;
        try {
            hastaTc = Long.valueOf(tcText);
        } catch (NumberFormatException e) {
            hataGoster(AlertType.ERROR, "Hata!", "HATA!", "Geçersiz TC girişi, lütfen tekrar deneyin.");
            return;
        }

        ArrayList<Hastalar> hasta = Hastalar.getHastalar();
        for (Hastalar h : hasta) {
            System.out.println(h.isim);
        }
        if (hasta.isEmpty()) {
            hataGoster(AlertType.ERROR, "Hata!", "HATA!", "Hasta listesi boş.");
            return;
        }

        Hastalar bulunanHasta = null;
        for (Hastalar h : hasta) {
            System.out.println(h.getTC());
            if (h.getTC() == hastaTc.longValue()) {
                found = true;
                hataGoster(AlertType.INFORMATION, "Bilgi!", "Bilgi", "Hasta TC bulundu." + hastaTc);
                bulunanHasta = h;
                break;
            }
        }

        if (found) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/hastanedemo2/hastaislemekrani.fxml"));
            Pane root;
            try {
                root = loader.load();
                Stage stage = new Stage();
                stage.setTitle("Hasta İşlem Ekranı");
                stage.setScene(new Scene(root, 400, 400));

                HastaIslemEkrani controller = loader.getController();
                controller.setHasta(bulunanHasta);

                stage.show();
            } catch (IOException e) {
                hataGoster(AlertType.ERROR, "Hata!", "HATA!", "Ekran görüntülenemiyor.");
            }
        } else {
            hataGoster(AlertType.ERROR, "Hata!", "HATA!", "Hasta bulunamadı.");
        }
    }
}
