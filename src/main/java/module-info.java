module com.example.csc311_loancalc {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.csc311_loancalc to javafx.fxml;
    exports com.example.csc311_loancalc;
}