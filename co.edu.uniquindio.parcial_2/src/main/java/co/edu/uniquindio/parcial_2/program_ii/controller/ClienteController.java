package co.edu.uniquindio.parcial_2.program_ii.controller;

import co.edu.uniquindio.parcial_2.program_ii.factory.ModelFactory;
import co.edu.uniquindio.parcial_2.program_ii.mapping.dto.ClienteDto;

import java.util.List;

public class ClienteController {
    ModelFactory modelFactory;
    public ClienteController(){
        modelFactory = ModelFactory.getInstancia();
    }

    public List<ClienteDto> obtenerClientes() {
        return modelFactory.obtenerClientes();
    }

    public boolean agregarCliente(ClienteDto clienteDto) {
        return modelFactory.agregarCliente(clienteDto);
    }

    public boolean eliminarCliente(String cedula) {
        return modelFactory.eliminarCliente(cedula);
    }
}
