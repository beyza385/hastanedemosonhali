module com.example.hastanedemo2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.hastanedemo2 to javafx.fxml;
    exports com.example.hastanedemo2;
}