module com.example.herenciaa {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.herenciaa to javafx.fxml;
    exports com.example.herenciaa;
    exports com.example.herenciaa.Controllers;
    opens com.example.herenciaa.Controllers to javafx.fxml;
}