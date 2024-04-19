package com.example.herenciaa.Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.example.herenciaa.App;
import com.example.herenciaa.models.Automovil;
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

public class VerAutosController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button verButton;

    @FXML
    private Button SalirButton;

    @FXML
    private TableView<Automovil> tableVentas;

    @FXML
    private TableColumn<Automovil, String> nombreAutoColumn;

    @FXML
    private TableColumn<Automovil, String> idAutoColumn;

    @FXML
    private TableColumn<Automovil, String> modeloAutoColumn;

    @FXML
    private TableColumn<Automovil, String> fechaAutoColumn;

    @FXML
    private TableColumn<Automovil, Double> precioAutoColumn;

    private ObservableList<Automovil> listaAutomovils = FXCollections.observableArrayList();


    @FXML
    void onMouseClickedConfirmarButton(MouseEvent event) {
        List<Automovil> listaAutomovils = Automovil.obtenerListaProductos();
        if (!listaAutomovils.isEmpty()) {
            tableVentas.getItems().clear();
            ObservableList<Automovil> productosObservableList = FXCollections.observableArrayList(listaAutomovils);
            tableVentas.setItems(productosObservableList);
        } else {
            System.out.println("La lista de productos está vacía.");
        }
    }

    @FXML
    void onMouseClickedSalirButton(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("menu-gerente.fxml"));
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
    }

    private void cerrarVentana(){
        Stage stage = (Stage) SalirButton.getScene().getWindow();
        stage.close();
    }

}
