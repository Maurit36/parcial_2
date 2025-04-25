package co.edu.uniquindio.parcial_2.program_ii.service;

import co.edu.uniquindio.parcial_2.program_ii.model.Cliente;

import java.util.List;

public interface IModelFactoryService {
    List<Cliente> obtenerClientes();

    boolean agregarCliente(Cliente cliente);

    boolean eliminarCliente(String cedula);
}
