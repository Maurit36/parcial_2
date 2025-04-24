package co.edu.uniquindio.parcial_2.program_ii.service;


import co.edu.uniquindio.parcial_2.program_ii.mapping.dto.ClienteDto;
import co.edu.uniquindio.parcial_2.program_ii.model.Cliente;

import java.util.List;

public interface IPrestamoMapping {
    List<ClienteDto> getClientesDto(List<Cliente> listaClientes);
    ClienteDto clienteToClienteDto(Cliente cliente);
    Cliente clienteDtoToCliente(ClienteDto clienteDto);
}
