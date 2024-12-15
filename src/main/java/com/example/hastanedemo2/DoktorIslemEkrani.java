package com.example.hastanedemo2;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class DoktorIslemEkrani {
    @FXML
    private Button TaburcuBt;
    @FXML
    private Button ReceteBt;
    @FXML
    private Button RandevuBt;
    private Doktorlar girisyapandoktor;

    public void setDoktor(Doktorlar d) {
        this.girisyapandoktor = d;
    }


    @FXML
    protected void onRandevuBtClick() {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("doktorrandevugoruntuleme.fxml"));
        Pane root;
        try {
            root=loader.load();
            Stage stage = new Stage();
            stage.setTitle("Randevu Görüntüleme Ekranı");
            stage.setScene(new Scene(root, 450.0, 350.0));
            DoktorRandevuGoruntule controller = loader.getController();
            controller.setDoktor(girisyapandoktor);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    protected void onReceteBtClick() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/hastanedemo2/taniverecetetanimla.fxml"));
        Pane root;
        try {
            root=loader.load();
            Stage stage = new Stage();
            stage.setTitle("Tanı ve Reçete Tanımlama Ekranı");
            stage.setScene(new Scene(root, 450.0, 350.0));
            RandevuTaniEkrani controller = loader.getController();
            controller.setDoktor(girisyapandoktor);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    protected void onTaburcuBtClick() {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("taburcuet.fxml"));
        Pane root;
        try {
            root=loader.load();
            Stage stage = new Stage();
            stage.setTitle("Taburcu Etme Ekranı");
            stage.setScene(new Scene(root, 450.0, 350.0));
            TaburcuEtmeEkrani controller=loader.getController();
            controller.setDoktor(girisyapandoktor);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


