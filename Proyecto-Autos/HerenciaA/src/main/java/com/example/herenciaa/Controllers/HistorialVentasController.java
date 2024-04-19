package com.example.herenciaa.Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.example.herenciaa.App;
import com.example.herenciaa.models.Venta;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class HistorialVentasController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button verButton;

    @FXML
    private Button SalirButton;

    @FXML
    private TableView<Venta> tableVentas;

    @FXML
    private TableColumn<Venta, String> nombreAutoColumn;

    @FXML
    private TableColumn<Venta, String> idAutoColumn;

    @FXML
    private TableColumn<Venta, String> modeloAutoColumn;

    @FXML
    private TableColumn<Venta, String> fechaAutoColumn;

    @FXML
    private TableColumn<Venta, Double> precioAutoColumn;

    @FXML
    private TableColumn<Venta, String> idVentaColumn;

    private ObservableList<Venta> listaVentas = FXCollections.observableArrayList();


    @FXML
    void onMouseClickedConfirmarButton(MouseEvent event) {
        List<Venta> listaVentas = Venta.getListaVentas();
        if (!listaVentas.isEmpty()) {
            tableVentas.getItems().clear();
            ObservableList<Venta> ventasObservableList = FXCollections.observableArrayList(listaVentas);
            tableVentas.setItems(ventasObservableList);
        } else {
            System.out.println("La lista de productos está vacía.");
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
        nombreAutoColumn.setCellValueFactory(cellData -> cellData.getValue().nombreAutoProperty());
        idAutoColumn.setCellValueFactory(cellData -> cellData.getValue().idAutoProperty());
        modeloAutoColumn.setCellValueFactory(cellData -> cellData.getValue().modeloAutoProperty());
        fechaAutoColumn.setCellValueFactory(cellData -> cellData.getValue().fechaProperty());
        precioAutoColumn.setCellValueFactory(cellData -> cellData.getValue().precioProperty().asObject());
        idVentaColumn.setCellValueFactory(cellData -> cellData.getValue().idVentaProperty());
    }

    private void cerrarVentana(){
        Stage stage = (Stage) SalirButton.getScene().getWindow();
        stage.close();
    }

}
