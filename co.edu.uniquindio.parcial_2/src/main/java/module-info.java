module co.edu.uniquindio.parcial_2.program_ii {
    requires javafx.controls;
    requires javafx.fxml;

//    requires org.controlsfx.controls;

    opens co.edu.uniquindio.parcial_2.program_ii to javafx.fxml;
    exports co.edu.uniquindio.parcial_2.program_ii;
    opens co.edu.uniquindio.parcial_2.program_ii.viewcontroller;
    exports co.edu.uniquindio.parcial_2.program_ii.viewcontroller;
    opens co.edu.uniquindio.parcial_2.program_ii.controller;
    exports co.edu.uniquindio.parcial_2.program_ii.controller;
}