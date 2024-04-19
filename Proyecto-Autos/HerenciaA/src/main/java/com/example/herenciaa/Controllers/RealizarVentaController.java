package com.example.herenciaa.Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.example.herenciaa.App;
import com.example.herenciaa.models.Automovil;
import com.example.herenciaa.models.Venta;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class RealizarVentaController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField nombreAutoText;

    @FXML
    private Button AgregarButton;

    @FXML
    private Button SalirButton;

    @FXML
    private TextField modeloAutoText;

    @FXML
    private TextField idAutoText;

    @FXML
    private TextField fechaAutoText;

    @FXML
    private TextField precioText;

    @FXML
    private TextField idVentaText;

    @FXML
    private Button buscarButton;

    @FXML
    void onMouseClickedBuscarButton(MouseEvent event) {
        String nombreAuto = nombreAutoText.getText();

        Automovil automovilEncontrado = Automovil.obtenerListaProductos().stream()
                .filter(producto -> producto.getNombreAuto().equals(nombreAuto))
                .findFirst()
                .orElse(null);

        if (automovilEncontrado != null) {
            idAutoText.setText(automovilEncontrado.getIdAuto());
            modeloAutoText.setText(automovilEncontrado.getModeloAuto());
            fechaAutoText.setText(automovilEncontrado.getFecha());
            precioText.setText(String.valueOf(automovilEncontrado.getPrecio()));

            mostrarAlerta("Producto Encontrado", "Éxito", "El producto ha sido encontrado.");
        } else {
            mostrarAlertaError("Error", "El producto no fue encontrado.");
        }
    }

    @FXML
    void onMouseClickedAgregarButton(MouseEvent event) {
        try {
            String nombreAuto = nombreAutoText.getText();
            String idAuto = idAutoText.getText();
            String modeloAuto = modeloAutoText.getText();
            String fechaAuto = fechaAutoText.getText();
            double precio = Double.parseDouble(precioText.getText());
            String idVenta = idVentaText.getText();

            boolean productoDisponible = Automovil.obtenerListaProductos().stream()
                    .anyMatch(producto -> producto.getNombreAuto().equals(nombreAuto));

            if (productoDisponible) {
                Venta nuevaVenta = new Venta(nombreAuto, idAuto, modeloAuto, fechaAuto, precio, idVenta);
                Venta.agregarVenta(nuevaVenta);

                limpiarCampos();

                mostrarAlerta("Venta Agregada", "Éxito", "La venta ha sido agregada correctamente.");
            } else {
                mostrarAlertaError("Error", "El producto no está disponible.");
            }
        } catch (NumberFormatException e) {
            mostrarAlertaError("Error", "Por favor, ingrese un precio válido.");
        }
    }


    @FXML
    void onMouseClickedSalirButton(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("menu-vendedor.fxml"));
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

    private void mostrarAlerta(String titulo, String encabezado, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(encabezado);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    private void mostrarAlertaError(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(titulo);
        alert.setHeaderText(mensaje);
        alert.showAndWait();
    }
    private void limpiarCampos() {
        nombreAutoText.clear();
        idAutoText.clear();
        modeloAutoText.clear();
        fechaAutoText.clear();
        precioText.clear();
        idVentaText.clear();
    }

    private void cerrarVentana(){
        Stage stage = (Stage) SalirButton.getScene().getWindow();
        stage.close();
    }
}
