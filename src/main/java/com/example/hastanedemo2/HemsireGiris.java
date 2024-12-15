package com.example.hastanedemo2;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import java.io.IOException;
import java.util.ArrayList;

public class HemsireGiris {
    @FXML
    private TextField HemsireTCEntry;
    @FXML
    private TextField HemsireSifreEntry;

    @FXML
    private Button GirisYapBt;

    @FXML
    protected void onGirisYapBtClick() {
        String tcText = HemsireTCEntry.getText();
        System.out.println("Girilen TC: " + tcText); // Debugging için
        String SifreText=HemsireSifreEntry.getText();

        Long HemsireTc;
        boolean found=false;
        try {
            HemsireTc = Long.valueOf(tcText);
        } catch (NumberFormatException e) {
            System.out.println("Geçersiz TC girişi");
            return;
        }
        ArrayList<Hemsireler> hemsire=Hemsireler.getHemsireler(); //hemsire listesi boş gözüküyor
        if(hemsire.isEmpty()){
            System.out.println("hasta listesi boş");
            return;
        }
        for (Hemsireler h : hemsire) {
            System.out.println(h.getTC());
            if (h.getTC()==HemsireTc.longValue() && h.getSifre()==SifreText) {
                found=true;
                System.out.println("Hasta TC bulundu:"+ HemsireTc);
                break;
            }
        }
        if(found){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/hastanedemo2/hemsireislemekrani.fxml"));
            Pane root = null;
            try {
                root = loader.load();
                Stage stage = new Stage();
                stage.setTitle("Hemsire İşlem Ekranı");
                stage.setScene(new Scene(root, 400, 300));
                stage.show();

            }catch(IOException e){
                System.out.println("ekran goruntulenemiyor");
            }}
        else{
            System.out.println("hasta bulunamadı");
        }


    }
}
