package com.example.herenciaa.Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.example.herenciaa.App;
import com.example.herenciaa.models.Automovil;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class AgregarController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button AgregarButton;

    @FXML
    private Button SalirButton;

    @FXML
    private TextField fechaAutoText;

    @FXML
    private TextField idAutoText;

    @FXML
    private TextField modeloAutoText;

    @FXML
    private TextField nombreAutoText;

    @FXML
    private TextField precioText;

    @FXML
    void onMouseClickedAgregarButton(MouseEvent event) {
        String nombreAuto = nombreAutoText.getText();
        String idAuto = idAutoText.getText();
        String modeloAuto = modeloAutoText.getText();
        String fechaAuto = fechaAutoText.getText();
        double precioAuto;

        try {
            precioAuto = Double.parseDouble(precioText.getText());
        } catch (NumberFormatException e) {
            mostrarAlertaError("Error",  "Precio inválido\nPor favor, ingrese un valor numérico para el precio.");
            return;
        }

        if (nombreAuto.isEmpty() || idAuto.isEmpty() || modeloAuto.isEmpty() || fechaAuto.isEmpty()) {
            mostrarAlertaError("Error",  "Campos vacíos\nPor favor, complete todos los campos.");
            return;
        }

        Automovil nuevoAutomovil = new Automovil(nombreAuto, idAuto, modeloAuto, fechaAuto, precioAuto);
        nuevoAutomovil.agregarProducto(nuevoAutomovil);
        mostrarAlerta("Exito", "Auto agredado exitosamente");
        System.out.println("Producto agregado: " + nuevoAutomovil.getNombreAuto());
    }

    @FXML
    void onMouseClickedSalirButton(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("menu-gerente.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Home");
        stage.setScene(scene);
        stage.show();
        cerrarVentana();
    }

    @FXML
    void initialize() {

    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    private void mostrarAlertaError(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(titulo);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    private void cerrarVentana(){
        Stage stage = (Stage) SalirButton.getScene().getWindow();
        stage.close();
    }

}
