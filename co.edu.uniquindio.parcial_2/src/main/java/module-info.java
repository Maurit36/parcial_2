module co.edu.uniquindio.parcial_2.program_ii {
    requires javafx.controls;
    requires javafx.fxml;


    opens co.edu.uniquindio.parcial_2.program_ii to javafx.fxml;
    exports co.edu.uniquindio.parcial_2.program_ii;
}