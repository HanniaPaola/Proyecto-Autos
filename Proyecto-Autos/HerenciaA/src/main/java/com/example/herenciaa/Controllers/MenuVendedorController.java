package com.example.herenciaa.Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.example.herenciaa.App;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class MenuVendedorController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button EliminarVentas;

    @FXML
    private Button HistorialVentas;

    @FXML
    private Button SalirButton;

    @FXML
    void onMouseClickedSalirButton(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("home-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Agregar");
        stage.setScene(scene);
        stage.show();
        cerrarVentana();
    }

    @FXML
    void onMouseClickedVentasButton(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("realizar-venta.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
        cerrarVentana();
    }

    @FXML
    void onMouseClickedVerHistorial(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("historial-ventas.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Agregar");
        stage.setScene(scene);
        stage.show();
        cerrarVentana();
    }

    @FXML
    void initialize() {

    }

    private void cerrarVentana(){
        Stage stage = (Stage) SalirButton.getScene().getWindow();
        stage.close();
    }

}
