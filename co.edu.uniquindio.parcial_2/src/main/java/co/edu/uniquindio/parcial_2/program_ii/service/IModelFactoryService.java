package co.edu.uniquindio.parcial_2.program_ii.service;

import co.edu.uniquindio.parcial_2.program_ii.mapping.dto.ClienteDto;

import java.util.List;

public interface IModelFactoryService {
    List<ClienteDto> obtenerClientes();

    boolean agregarCliente(ClienteDto clienteDto);

    boolean eliminarCliente(String cedula);
}
