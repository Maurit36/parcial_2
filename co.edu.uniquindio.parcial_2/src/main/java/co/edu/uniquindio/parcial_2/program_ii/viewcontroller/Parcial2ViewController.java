package co.edu.uniquindio.parcial_2.program_ii.viewcontroller;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.parcial_2.program_ii.model.Empleado;
import co.edu.uniquindio.parcial_2.program_ii.model.Objeto;
import co.edu.uniquindio.parcial_2.program_ii.model.PrestamoObjeto;
import co.edu.uniquindio.parcial_2.program_ii.utils.DataUtil;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class Parcial2ViewController {
    PrestamoObjeto sistema;
    ObservableList<Empleado> listaEmpleados = FXCollections.observableArrayList();
    ObservableList<Objeto> listaObjetos = FXCollections.observableArrayList();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<Empleado, String> colNombreEmpleado;

    @FXML
    private TableView<Empleado> tablaEmpleados;

    @FXML
    private TextField txtPrestamoEmpleado;

    @FXML
    private TableColumn<Empleado, String> colVecesEmpleado;

    @FXML
    private Button btnBuscarEmpleadosMasPrestados;

    @FXML
    void onBuscarEmpleadosMasPrestados(ActionEvent event) {
        buscarEmpleadosMasPrestados();

    }

    @FXML
    void initialize() {
        sistema = DataUtil.inicializarDatos();
        initDataBinding();
    }

    private void initDataBinding() {
        colNombreEmpleado.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().nombre()));
        colVecesEmpleado.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().vecesPrestado())));

    }

    private void buscarEmpleadosMasPrestados() {
        String texto = txtPrestamoEmpleado.getText();
        if (!texto.matches("\\d+")) {
            mostrarAlerta("Ingrese Número Valido!!!");
            return;
        }
        int minimo = Integer.parseInt(texto);
        listaEmpleados.clear();
        for (Empleado empleado : sistema.getListaEmpleados()) {
            if (empleado.getVecesPrestado() >= minimo) {
                Empleado empleado1 = new Empleado(
                        empleado.getNombre(),
                        empleado.getApellido(),
                        empleado.getCedula(),
                        empleado.getEdad()
                );
                listaEmpleados.add(empleado1);
            }
        }
        tablaEmpleados.setItems(listaEmpleados);
        tablaEmpleados.refresh();
    }

    private void mostrarAlerta(String mensaje) {
        javafx.scene.control.Alert alert = new javafx.scene.control.Alert(Alert.AlertType.WARNING);
        alert.setTitle("Alerta");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
