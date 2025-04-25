package co.edu.uniquindio.parcial_2.program_ii.factory;

import co.edu.uniquindio.parcial_2.program_ii.model.Cliente;
import co.edu.uniquindio.parcial_2.program_ii.model.PrestamoObjeto;
import co.edu.uniquindio.parcial_2.program_ii.service.IModelFactoryService;
import co.edu.uniquindio.parcial_2.program_ii.utils.DataUtil;

import java.util.List;

public class ModelFactory implements IModelFactoryService {
    private static ModelFactory modelFactory;
    private PrestamoObjeto prestamoObjeto;

    public static ModelFactory getInstancia() {
        if(modelFactory == null) {
            modelFactory = new ModelFactory();
        }
        return modelFactory;
    }

    private ModelFactory(){
        prestamoObjeto = DataUtil.inicializarDatos();
    }


    @Override
    public List<Cliente> obtenerClientes() {
        return prestamoObjeto.getListaClientes();
    }

    @Override
    public boolean agregarCliente(Cliente cliente) {
        return prestamoObjeto.crearCliente(cliente);
    }

    @Override
    public boolean eliminarCliente(String cedula) {
        return prestamoObjeto.eliminarCliente(cedula);
    }
}
