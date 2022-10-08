module com.example.gradingsytem {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.gradingsytem to javafx.fxml;
    exports com.example.gradingsytem;
}