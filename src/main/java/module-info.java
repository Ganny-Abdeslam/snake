module co.edu.uniquindio.parcial_ii {
    requires javafx.controls;
    requires javafx.fxml;


    opens co.edu.uniquindio.parcial_ii to javafx.fxml;
    exports co.edu.uniquindio.parcial_ii;
    exports co.edu.uniquindio.parcial_ii.controller;
    opens co.edu.uniquindio.parcial_ii.controller to javafx.fxml;
}