module com.example.gradingsytem {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.gradingsytem to javafx.fxml;
    exports com.example.gradingsytem;
}