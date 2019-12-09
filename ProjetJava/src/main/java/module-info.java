module net.ProjetJava {
    requires javafx.controls;
    requires javafx.fxml;

    opens net.ProjetJava to javafx.fxml;
    exports net.ProjetJava;
}