package co.edu.uniquindio.parcial_2.program_ii.controller;

import co.edu.uniquindio.parcial_2.program_ii.factory.ModelFactory;
import co.edu.uniquindio.parcial_2.program_ii.model.Cliente;

import java.util.List;

public class ClienteController {
    ModelFactory modelFactory;
    public ClienteController(){
        modelFactory = ModelFactory.getInstancia();
    }

    public List<Cliente> obtenerClientes() {
        return modelFactory.obtenerClientes();
    }

    public boolean agregarCliente(Cliente cliente) {
        return modelFactory.agregarCliente(cliente);
    }

    public boolean eliminarCliente(String cedula) {
        return modelFactory.eliminarCliente(cedula);
    }
}
