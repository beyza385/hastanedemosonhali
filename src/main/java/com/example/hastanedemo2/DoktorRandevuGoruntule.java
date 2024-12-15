package com.example.hastanedemo2;

import javafx.beans.Observable;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.ArrayList;
import javafx.scene.control.cell.PropertyValueFactory;
public class DoktorRandevuGoruntule {
    @FXML
    TableView<Hastalar> hastaRandevuTb;
    @FXML
    TableColumn<Hastalar,String> HastaAdiColumn;
    @FXML
    TableColumn<Hastalar,String> SoyadiColumn;
    @FXML
    TableColumn<Hastalar,String> RandevuColumn;
    Doktorlar doktor;

    public void setDoktor(Doktorlar doktor) {
        this.doktor = doktor;
        setHastaRandevuTb();
    }
    public void setHastaRandevuTb(){
        HastaAdiColumn.setCellValueFactory(new PropertyValueFactory<>("isim"));
        SoyadiColumn.setCellValueFactory(new PropertyValueFactory<>("soyisim"));
        RandevuColumn.setCellValueFactory(new PropertyValueFactory<>("randevu"));

        ArrayList<Hastalar> hastarandevu= doktor.getHastalari();
        ObservableList<Hastalar> data= FXCollections.observableArrayList(hastarandevu);
        hastaRandevuTb.setItems(data);
    }
}
