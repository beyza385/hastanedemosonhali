package com.example.hastanedemo2;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import java.io.IOException;
import java.util.ArrayList;

public class DoktorGiris {
    @FXML
    private TextField DoktorTCEntry;
    @FXML
    private TextField DoktorSifreEntry;

    @FXML
    private Button GirisYapBt;

    // Hata mesajını göstermek için ortak bir metod
    private void hataGoster(AlertType type, String title, String header, String content) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }

    @FXML
    protected void onGirisYapBtClick() {
        String tcText = DoktorTCEntry.getText();
        System.out.println("Girilen TC: " + tcText); // Debugging için
        String SifreText = DoktorSifreEntry.getText();

        Long DoktorTc;
        boolean found = false;
        try {
            DoktorTc = Long.valueOf(tcText);
        } catch (NumberFormatException e) {
            hataGoster(AlertType.ERROR, "Hata!", "HATA!", "Geçersiz TC girişi.");
            return;
        }

        ArrayList<Doktorlar> doktor = Doktorlar.getDoktorlar();
        if (doktor.isEmpty()) {
            hataGoster(AlertType.ERROR, "Hata!", "HATA!", "Doktor listesi boş.");
            return;
        }
        Doktorlar bulunanDoktor=null;

        for (Doktorlar d : doktor) {
            System.out.println(d.getTC()); // Debugging için
            if (d.getTC() == DoktorTc.longValue() && d.getSifre().equals(SifreText)) {
                bulunanDoktor=d;
                found = true;
                hataGoster(AlertType.INFORMATION, "Giriş başarılı!", "TC Bulundu!", "Doktor TC bulundu.");
                break;
            }
        }

        if (found) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/hastanedemo2/doktorislemekrani.fxml"));
            Pane root;
            try {
                root = loader.load();
                Stage stage = new Stage();
                stage.setTitle("Doktor İşlem Ekranı");
                stage.setScene(new Scene(root, 450, 350));

                DoktorIslemEkrani controller = loader.getController();
                controller.setDoktor(bulunanDoktor);

                stage.show();
            } catch (IOException e) {
                hataGoster(AlertType.ERROR, "Hata!", "HATA!", "Ekran görüntülenemiyor.");
            }
        } else {
            hataGoster(AlertType.ERROR, "Hata!", "HATA!", "Doktor bulunamadı.");
        }
    }
}