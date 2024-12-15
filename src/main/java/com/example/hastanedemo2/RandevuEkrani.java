package com.example.hastanedemo2;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

import java.util.ArrayList;
import java.util.List;

public class RandevuEkrani {

    @FXML
    private ComboBox<Doktorlar> doktorComboBox;

    @FXML
    private ComboBox<String> saatComboBox;

    @FXML
    private TextArea randevuAl;

    @FXML
    private TextArea randevuGoruntule;

    public Hastalar hasta;

    public Doktorlar doktor;

    @FXML
    public void initialize() {
        // Doktor listesini ComboBox'a ekle
        doktorComboBox.getItems().addAll(Doktorlar.getDoktorlar());

        // Doktor seçildiğinde uygun saatleri güncelle
        doktorComboBox.setOnAction(e -> doktorSecildi());
    }

    private void doktorSecildi() {
        // Saat ComboBox'ını temizle
        saatComboBox.getItems().clear();

        // Seçilen doktorun uygun saatlerini ekle
        Doktorlar secilenDoktor = doktorComboBox.getSelectionModel().getSelectedItem();
        if (secilenDoktor != null) {
            List<String> uygunSaatler = secilenDoktor.getUygunSaatler();
            saatComboBox.getItems().addAll(uygunSaatler);
        }
    }

    @FXML
    private void RandevuAlBt() {
        // Doktor ve saat seçimini kontrol et
        if (hasta.randevu != null && !hasta.randevu.isEmpty()) {
            randevuAl.setText("Hata: Daha önce randevu alındı.");
            return;
        }

        Doktorlar secilenDoktor = doktorComboBox.getSelectionModel().getSelectedItem();
        String secilenSaat = saatComboBox.getSelectionModel().getSelectedItem();

        if (secilenDoktor == null) {
            randevuAl.setText("Lütfen bir doktor seçin!");
            return;
        }

        if (secilenSaat == null) {
            randevuAl.setText("Lütfen bir saat seçin!");
            return;
        }

        // Randevuyu kontrol edip al
        boolean randevuAlindi = secilenDoktor.randevuKontrol(secilenSaat);
        if (randevuAlindi) {
            // Giriş yapan hastanın randevu bilgisini güncelle
            hasta.randevu = "Doktor: " + secilenDoktor + ", Saat: " + secilenSaat;
            randevuAl.setText("Randevu alındı: " + hasta.randevu);
            hasta.doktor=secilenDoktor;
            doktor.HastaEkle(hasta);
        } else {
            randevuAl.setText("Seçilen saat dolu. Lütfen başka bir saat seçin.");
        }
    }
    @FXML
    private void onrandevuGoruntuleBt() {
        if(hasta.randevu!=null){
            randevuGoruntule.setText(hasta.randevu);
        }

    }

    @FXML
    private void RandevuGoruntule() {
        // Tüm doktorların randevu durumlarını listele
        List<String> randevuDurumlari = new ArrayList<>();
        for (Doktorlar doktor : Doktorlar.getDoktorlar()) {
            randevuDurumlari.add("Doktor: " + doktor.isim + " " + doktor.soyisim);
            randevuDurumlari.add("Uygun Saatler: " + doktor.getUygunSaatler().toString());
            randevuDurumlari.add(""); // Boş bir satır ekleyerek ayır
        }

        // Listeyi TextArea'ya yazdır
        randevuGoruntule.clear();
        for (String durum : randevuDurumlari) {
            randevuGoruntule.appendText(durum + "\n");
        }
    }

}