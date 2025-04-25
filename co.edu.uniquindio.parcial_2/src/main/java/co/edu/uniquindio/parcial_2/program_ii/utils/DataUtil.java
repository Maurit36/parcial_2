package co.edu.uniquindio.parcial_2.program_ii.utils;

import co.edu.uniquindio.parcial_2.program_ii.model.Cliente;
import co.edu.uniquindio.parcial_2.program_ii.model.Empleado;
import co.edu.uniquindio.parcial_2.program_ii.model.Objeto;
import co.edu.uniquindio.parcial_2.program_ii.model.PrestamoObjeto;

public class DataUtil {

    public static PrestamoObjeto inicializarDatos() {
        PrestamoObjeto prestamoObjeto = new PrestamoObjeto();
        Cliente cliente1 = Cliente.builder()
                .cedula("1094")
                .nombre("juan")
                .apellido("arias")
                .direccion("armenia")
                .edad(17)
                .email("jsjsj@gmail.com")
                .build();

        Cliente cliente2 = Cliente.builder()
                .cedula("1095")
                .nombre("Ana")
                .apellido("cardenas")
                .direccion("quimbaya")
                .edad(25)
                .email("jsjsj2@gmail.com")
                .build();

        Cliente cliente3 = Cliente.builder()
                .cedula("1096")
                .nombre("Pedro")
                .apellido("perez")
                .direccion("armenia")
                .edad(40)
                .email("jsjsj3@gmail.com")
                .build();

        prestamoObjeto.getListaClientes().add(cliente1);
        prestamoObjeto.getListaClientes().add(cliente2);
        prestamoObjeto.getListaClientes().add(cliente3);

        Empleado empleado1 = new Empleado("Juan", "Perez", "1094", 25);
        Empleado empleado2 = new Empleado("Ana", "Cardenas", "1095", 30);
        Empleado empleado3 = new Empleado("Pedro", "Perez", "1096", 40);
        Empleado empleado4 = new Empleado("Jose", "Perez", "1097", 25);
        empleado1.setVecesPrestado(4);
        empleado2.setVecesPrestado(2);
        empleado3.setVecesPrestado(2);
        empleado4.setVecesPrestado(4);

        prestamoObjeto.getListaEmpleados().add(empleado1);
        prestamoObjeto.getListaEmpleados().add(empleado2);
        prestamoObjeto.getListaEmpleados().add(empleado3);
        prestamoObjeto.getListaEmpleados().add(empleado4);



        return prestamoObjeto;
    }
}
