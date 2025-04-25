package co.edu.uniquindio.parcial_2.program_ii.viewcontroller;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import co.edu.uniquindio.parcial_2.program_ii.controller.ClienteController;
import co.edu.uniquindio.parcial_2.program_ii.factory.ModelFactory;
import co.edu.uniquindio.parcial_2.program_ii.model.Cliente;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import static co.edu.uniquindio.parcial_2.program_ii.utils.PrestamoConstantes.*;

public class ClienteViewController {


    ModelFactory modelFactory = ModelFactory.getInstancia();
    ObservableList<Cliente> listaClientes = FXCollections.observableArrayList();
    Cliente clienteSeleccionado;


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnActualizar;

    @FXML
    private Button btnAgregar;

    @FXML
    private Button btnEliminar;

    @FXML
    private Button btnNuevo;

    @FXML
    private TableView<Cliente> tableCliente;

    @FXML
    private TableColumn<Cliente, String> tcApellido;

    @FXML
    private TableColumn<Cliente, String> tcCedula;

    @FXML
    private TableColumn<Cliente, String> tcDireccion;

    @FXML
    private TableColumn<Cliente, String> tcEmail;

    @FXML
    private TableColumn<Cliente, String> tcNombre;

    @FXML
    private TextField txtApellido;

    @FXML
    private TextField txtCedula;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtdireccion;


    @FXML
    void initialize() {
        initView();
    }

    @FXML
    void onAgregarCliente(ActionEvent event) {
        agregarCliente();
    }

    @FXML
    void onActualizarCliente(ActionEvent event) {

    }

    @FXML
    void onNuevoCliente(ActionEvent event) {
        nuevoCliente();

    }

    @FXML
    void onEliminarCliente(ActionEvent event) {
        eliminarCliente();
    }

    private void initView() {
        initDataBinding();
        obtenerClientes();
        tableCliente.getItems().clear();
        tableCliente.setItems(listaClientes);
        listenerSelection();
    }

    private void obtenerClientes() {
       listaClientes.addAll(modelFactory.obtenerClientes());
    }

    private void initDataBinding() {
        tcNombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        tcApellido.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getApellido()));
        tcCedula.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCedula()));
        tcEmail.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEmail()));
        tcDireccion.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDireccion()));
    }

    private void listenerSelection() {
        tableCliente.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            clienteSeleccionado = newSelection;
            mostrarInformacionCliente(clienteSeleccionado);
        });
    }

    private void agregarCliente() {
        //1. Captura los datos del formulario
        //2. Armar un Dto con los datos
        Cliente clienteDto = crearClienteDto();
        //3.Validar campos
        if(datosValidos(clienteDto)){
            //4. Solicitar crear cliente
            if(modelFactory.agregarCliente(clienteDto)){
                listaClientes.addAll(clienteDto);
                limpiarCampos();
                mostrarMensaje(TITULO_CLIENTE_AGREGADO, HEADER, BODY_CLIENTE_AGREGADO,Alert.AlertType.INFORMATION);
            }else{
                mostrarMensaje(TITULO_CLIENTE_NO_AGREGADO, HEADER, BODY_CLIENTE_NO_AGREGADO,Alert.AlertType.ERROR);
            }
        }else{
            //mensaje de notificacion de campos incompletos
            mostrarMensaje(TITULO_INCOMPLETO, HEADER, BODY_INCOMPLETO,Alert.AlertType.WARNING);
        }
    }

    private void eliminarCliente() {
        if(clienteSeleccionado != null){
            if(modelFactory.eliminarCliente(clienteSeleccionado.getCedula())){
                listaClientes.remove(clienteSeleccionado);
                limpiarCampos();
                mostrarMensaje(TITULO_CLIENTE_ELIMINADO, HEADER, BODY_CLIENTE_AGREGADO,Alert.AlertType.INFORMATION);
            }else{
                mostrarMensaje(TITULO_CLIENTE_NO_AGREGADO, HEADER, BODY_CLIENTE_NO_AGREGADO,Alert.AlertType.ERROR);
            }
        }
    }

    private void nuevoCliente() {
        limpiarCampos();
        txtNombre.setText("Ingrese un nombre");
    }


    private void limpiarCampos() {
        txtNombre.setText("");
        txtApellido.setText("");
        txtCedula.setText("");
        txtEmail.setText("");
        txtdireccion.setText("");
    }

    private Cliente crearClienteDto() {
        return new Cliente(
                txtCedula.getText(),
                txtNombre.getText(),
                txtApellido.getText(),
                txtEmail.getText(),
                "",
                "",
                txtdireccion.getText(),
                0);
    }

    private boolean datosValidos(Cliente cliente) {
        if(cliente.getNombre().isBlank() ||
                cliente.getApellido().isBlank() ||
                cliente.getCedula().isBlank() ||
                cliente.getEmail().isBlank() ||
                cliente.getDireccion().isBlank()
        ){
            return false;
        }else{
            return true;
        }
    }


    private void mostrarInformacionCliente(Cliente clienteSeleccionado) {
        if(clienteSeleccionado != null){
            txtNombre.setText(clienteSeleccionado.getNombre());
            txtApellido.setText(clienteSeleccionado.getApellido());
            txtCedula.setText(clienteSeleccionado.getCedula());
            txtEmail.setText(clienteSeleccionado.getEmail());
            txtdireccion.setText(clienteSeleccionado.getDireccion());
        }
    }

    private void mostrarMensaje(String titulo, String header, String contenido, Alert.AlertType alertType) {
        Alert aler = new Alert(alertType);
        aler.setTitle(titulo);
        aler.setHeaderText(header);
        aler.setContentText(contenido);
        aler.showAndWait();
    }

    private boolean mostrarMensajeConfirmacion(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText(null);
        alert.setTitle("Confirmación");
        alert.setContentText(mensaje);
        Optional<ButtonType> action = alert.showAndWait();
        if (action.get() == ButtonType.OK) {
            return true;
        } else {
            return false;
        }
    }

}
